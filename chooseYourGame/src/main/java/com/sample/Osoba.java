package com.sample;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
    public String imie;
    public Plec plec;

    public List<Relacja> relacje = new ArrayList<>();

    public Osoba(String imie) {
        this.imie = imie;
        this.plec = Plec.NIEZNANA;
    }

    public void dodajRelacje(Relacja relacja) {
        relacje.add(relacja);
    }

    public void setPlec(Plec nowaPlec) {
        this.plec = nowaPlec;
    }
    
    public String toString() {
        return imie;
    }
    
    public Plec getPlec() {
    	return plec;
    }
}
