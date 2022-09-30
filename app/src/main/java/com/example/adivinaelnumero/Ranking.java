package com.example.adivinaelnumero;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Ranking extends AppCompatActivity {
    // private HashMap<String, String> hash = new HashMap<String, String>();
    private ArrayList<String> ranking = new ArrayList<>();
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

        TextView userNames = findViewById(R.id.userNames);
        TextView scores = findViewById(R.id.Scores);

        ranking = getIntent().getStringArrayListExtra("ranking");

        String totalUsernames = "";
        String totalScores = "";

        System.out.println("Size" + ranking.size());
        for(int i = 0; i < ranking.size(); i += 2)
        {
            totalUsernames = totalUsernames + ranking.get(i) + "\n\n";
            totalScores = totalScores + ranking.get(i+1) + "\n\n";
        }

        userNames.setText(totalUsernames);
        scores.setText(totalScores);

        System.out.println("UPDATED!");





    }
}