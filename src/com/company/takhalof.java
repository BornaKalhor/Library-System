package com.company;

import source.Source;
import member.Memmber;

import java.util.ArrayList;
import java.util.Date;

public class amanatManager {
    public void addNewAmanat(Source source, Date day, Memmber asker) {
        database DATA = database.getInstance();
        DATA.getLends().add(new Lend(source, day, asker));
    }

    public ArrayList<Lend> getMokhalafUser() {
        database DATA = database.getInstance();
        ArrayList<Lend> list = new ArrayList<>();
        for (Lend X : DATA.getLends()) {
            if (X.isEnded()) {
                list.add(X);
            }
        }
        return list;
    }
}