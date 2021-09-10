package com.company;

import member.Memmber;
import source.Source;

import java.util.ArrayList;

public class database {
    private static database ourInstance = new database();
    private ArrayList<Memmber> users= new ArrayList<>();
    private ArrayList<Source> sources= new ArrayList<>();
    private ArrayList<Lend> lends= new ArrayList<>();



    public static database getInstance() {
        return ourInstance;
    }

    public void clear(){
        users = new ArrayList<>();
        sources = new ArrayList<Source>();
    }


    public void addSource(Source source){
        sources.add(source);
    }

    public ArrayList<Memmber> getUsers() {
        return users;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }

    public ArrayList<Lend> getLends() {
        return lends;
    }

    public void removeSource(Source source){
        sources.remove(source);
    }

    public void addMember(Memmber member){
        users.add(member);
    }

    public void removeUser(Memmber member){
        users.remove(member);
    }

    private database() {
    }
}
