package com.guercifzone.adapter_model;

public class Data {
private int letter_consonne_ID,lettet_voyelle_ID,raw_ID;
private String name;
public Data(int raw_ID,int letter_consonne_ID,int lettet_voyelle_ID,String name){
    this.letter_consonne_ID = letter_consonne_ID;
    this.lettet_voyelle_ID = lettet_voyelle_ID;
    this.raw_ID = raw_ID;
    this.name = name;
}

    public int getLetter_consonne_ID() {
        return letter_consonne_ID;
    }

    public String getName() {
        return name;
    }

    public int getRaw_ID() {
        return raw_ID;
    }

    public int getLettet_voyelle_ID() {
        return lettet_voyelle_ID;
    }
}
