package com.sample;

public class Relacja {
    public Osoba[] osoby = new Osoba[2];
    public String relacja;

    public Relacja(Osoba o1, Osoba o2, String relacja) {
        this.osoby[0] = o1;
        this.osoby[1] = o2;
        this.relacja = relacja;

        o1.dodajRelacje(this);
        o2.dodajRelacje(this);
    }
    
    public void setPlecOsoby(Osoba os, Plec plec) {
    	os.setPlec(plec);
    }
}
