package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int secretNum = genRandomNumber();

        Button checkBtn = findViewById(R.id.checkBtn);
        EditText userNumber = findViewById(R.id.inputNumber);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context con = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                int userNum = Integer.parseInt(userNumber.getText().toString());
                if (secretNum == userNum)
                {
                    System.out.println("Equal!");
                    CharSequence txt = "You WIN!!";
                    showToast(con, txt, duration);
                }
                else if (userNum < secretNum)
                {
                    System.out.println("Less!");
                    CharSequence txt = "The number is higher than " + userNumber.getText();
                    showToast(con, txt, duration);
                }
                else
                {
                    System.out.println("Higher!");
                    CharSequence txt = "The number is lower than " + userNumber.getText();
                    showToast(con, txt, duration);
                }
            }
        });
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