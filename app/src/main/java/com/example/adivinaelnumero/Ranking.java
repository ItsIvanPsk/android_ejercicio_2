package com.example.adivinaelnumero;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    private ArrayList<Record> ranking = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ranking.this, MainActivity.class);
                Ranking.this.startActivity(intent);
            }
        });
        ranking = MainActivity.ranking;

        // Inicialitzem l'ArrayAdapter amb el layout pertinent
        ArrayAdapter<Record> adapter = new ArrayAdapter<Record>( this, android.R.layout.simple_list_item_1, ranking )
        {
            @Override
            public View getView(int pos, View convertView, ViewGroup container)
            {
                // getView ens construeix el layout i hi "pinta" els valors de l'element en la posició pos
                if( convertView==null ) {
                    // inicialitzem l'element la View amb el seu layout
                    convertView = getLayoutInflater().inflate(R.layout.record_layout, container, false);
                }
                // "Pintem" valors (també quan es refresca)
                ((TextView) convertView.findViewById(R.id.nom)).setText(getItem(pos).nom);
                ((TextView) convertView.findViewById(R.id.intents)).setText(Integer.toString(getItem(pos).intents));
                return convertView;
            }
        };

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(adapter);

        System.out.println("UPDATED!");
    }
}