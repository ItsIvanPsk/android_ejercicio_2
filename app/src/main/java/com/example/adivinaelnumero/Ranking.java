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

        ranking = getIntent().getStringArrayListExtra("ranking");



        System.out.println("UPDATED!");
    }
}