package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Integer count;
    private int secretNum;
    static ArrayList<Scores> ranking = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secretNum = genRandomNumber();

        Button checkBtn = findViewById(R.id.checkBtn);
        EditText userNumber = findViewById(R.id.inputNumber);
        TextView cantTries = findViewById(R.id.textTries);

        userNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                    {
                        System.out.println("ENTER");
                        InputMethodManager imm =
                                (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(userNumber.getApplicationWindowToken(),0);
                        return true;
                    }
                }
                return MainActivity.super.onKeyDown(keyCode, keyEvent);
            }
        });



        checkBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Context con = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                TextView tv_count = findViewById(R.id.textTries);
                TextView str_tries = findViewById(R.id.string_tries);
                count = Integer.parseInt(tv_count.getText().toString());
                Integer userNum = Integer.parseInt(userNumber.getText().toString());

                if (!(userNum.toString() == "")){
                    if (secretNum == userNum)
                    {
                        count++;
                        System.out.println("Equal!");
                        CharSequence txt = "You WIN!!";
                        showToast(con, txt, duration);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


                        EditText usernameInput = new EditText(MainActivity.this);
                        usernameInput.setHint("Username");
                        builder.setView(usernameInput);

                        builder.setMessage("Congratulations!!");
                        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intent = new Intent(MainActivity.this, Ranking.class);
                                ranking.add(new Scores(usernameInput.getText().toString(), count));
                                MainActivity.this.startActivity(intent);
                                count = 0;
                                userNumber.setText("");
                                cantTries.setText(count.toString());
                                str_tries.setText("");
                                setSecretNum(genRandomNumber());
                            }
                        });
                        builder.setNegativeButton("Don't Save", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                count = 0;
                                userNumber.setText("");
                                cantTries.setText(count.toString());
                                str_tries.setText("");
                                setSecretNum(genRandomNumber());
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();

                        System.out.println("Restarted :D");
                    }
                    else if (userNum < secretNum)
                    {
                        count++;
                        System.out.println("Less!");
                        CharSequence txt = "The number is higher than " + userNumber.getText();
                        showToast(con, txt, duration);
                    }
                    else
                    {
                        count++;
                        System.out.println("Higher!");
                        CharSequence txt = "The number is lower than " + userNumber.getText();
                        showToast(con, txt, duration);
                    }
                    str_tries.append("You have tried " + userNumber.getText().toString() + ".\n");
                    // str_tries.getParent();
                    tv_count.setText(count.toString());
                    userNumber.setText("");
                }
                else {
                    showToast(getApplicationContext(), "Por favor, ingresa un numero válido", 1);
                }
            }
        });
    }

    private void setSecretNum(int num) {
        this.secretNum = num;
    }

    private void showToast(Context con, CharSequence txt, int duration)
    {
        Toast t = Toast.makeText(con,txt,duration);
        t.show();
    }

    private int genRandomNumber()
    {
        return (int)(Math.random() * 10);
    }
}