package com.example.adivinaelnumero;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Ranking extends AppCompatActivity {
    private ArrayList<String> ranking = new ArrayList<>();

    List<String>usernames = new LinkedList<String>();
    List<String>scores = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ranking.this, MainActivity.class);
                System.out.println("Intent generated");
                intent.putExtra("ranking", ranking);
                Ranking.this.startActivity(intent);
                System.out.println("START");
            }
        });

        ranking = getIntent().getStringArrayListExtra("ranking");

        this.ArrayToListSetter(ranking);

        TableLayout tbl = findViewById(R.id.table);


        //make sure that the lists contain data or else display will be blank screen
        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT);

        for(int i = 0 ;i < usernames.size(); i++)
        {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView username = new TextView(this);
            TextView score = new TextView(this);

            username.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //setting the text
            username.setText(usernames.get(i));
            score.setText(scores.get(i));

            username.setLayoutParams(params1);
            score.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(username);
            row.addView(score);
            row.setLayoutParams(params2);
            tbl.addView(row);
        }

        System.out.println("UPDATED!");
    }

    public void ArrayToListSetter(ArrayList<String> arr)
    {
        for(int i = 0; i < arr.size(); i += 2)
        {
            usernames.add(arr.get(i));
            scores.add(arr.get(i+1));
        }
    }
}