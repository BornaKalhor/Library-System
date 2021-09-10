package com.company;
import
import member.Memmber;
import source.Source;

import java.util.ArrayList;

public class Admin {
    private String user = "user";
    private String pass = "pass";


    public ArrayList<Source> findIntopicSource(String target) {
        database DATA = database.getInstance();
        ArrayList<Source> listsource = DATA.getSources();
        ArrayList<Source> find = new ArrayList<>();
        for (Source X : listsource) {
            if (X.getTopic().contains(target)) {
                find.add(X);
            }
        }
        return find;
    }

    public ArrayList<Memmber> findInTopicMember(String target) {
        database DATA = database.getInstance();
        ArrayList<Memmber> listUser = DATA.getUsers();
        ArrayList<Memmber> find = new ArrayList<>();
        for (Memmber X : listUser) {
            if (X.getFamilyname().contains(target) || X.getName().contains(target)) {
                find.add(X);
            }
        }
        return find;
    }

    public Source findManba(String code, int id) {
        database DATA = database.getInstance();
        ArrayList<Source> listUser = DATA.getSources();
        int Mycode = Source.CovertToint(code, id);
        for (Source X : listUser) {
            if (Source.CovertToint(X.getCode() == Mycode) {
                return X;
            }
        }
        return null;
    }

    public Memmber findUser(String code, int id) {
        database DATA = database.getInstance();
        ArrayList<Memmber> listUser = DATA.getUsers();
        int Mycode = Memmber.CovertToint(code);
        for (Memmber X : listUser) {
            if (Memmber.CovertToint(X.getCode(), X.getCode()) == Mycode) {
                return X;
            }
        }
        return null;
    }
}
