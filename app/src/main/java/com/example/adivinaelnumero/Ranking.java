package com.example.adivinaelnumero;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    ArrayList<Scores> ranking = new ArrayList<>();
    RecyclerView recycler;
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

        ranking = MainActivity.ranking;

        recycler= findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DataAdapter adapter = new DataAdapter(ranking);
        recycler.setAdapter(adapter);


        System.out.println("UPDATED!");
    }
}