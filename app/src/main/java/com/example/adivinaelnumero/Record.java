package com.example.adivinaelnumero;

import java.io.Serializable;

public class Record implements Serializable {
    public Integer intents;
    public String nom;

    public Record(Integer _intents, String _nom ) {
        intents = _intents;
        nom = _nom;
    }
}
