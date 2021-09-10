package com.company;
import member.Memmber;
import source.Source;

import java.util.Date;
import java.util.*;
public class Lend {
    private boolean inLend;
    private Source source;
    private Memmber asker;
    private Date lendDay;
    private Date returnDay;
    boolean ended;

    public Lend(Source source, Date lendDay, Memmber asker){
        this.source = source;
        this.asker = asker;
        this.lendDay = lendDay;
        ended = false;
    }

    public boolean isInLend() {
        return inLend;
    }

    public void setInLend(boolean inLend) {
        this.inLend = inLend;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Memmber getAsker() {
        return asker;
    }

    public void setAsker(Memmber asker) {
        this.asker = asker;
    }

    public Date getLendDay() {
        return lendDay;
    }

    public void setLendDay(Date lendDay) {
        this.lendDay = lendDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public void setReturn(){
        ended = true;
        lendDay = new Date();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Lend lend = (Lend)obj;
        return Objects.equals(source, lend.source) &&
                obj.equals(asker);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean gozashteaztime(){
        Date date = new Date();
        long diff = date.getTime() - lendDay.getTime();
        float days = (diff / 1000*60*60*24);
        long mojaz = source.
                return mojaz < days;
    }


}