package yusenze.List;

import yusenze.Interface.Addible;

public class TermX implements Comparable<TermX>,Addible<TermX> {
    protected int coef,xexp;
    public TermX(int coef,int xexp){

    }

    public TermX(TermX termX){

    }

    public TermX(String termstr){

    }

    public String toString(){
        String str="";
        return str;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    }

    @Override
    public int compareTo(TermX term){
        return 0;
    }

    @Override
    public void add(TermX term){

    }

    @Override
    public boolean removable(){
        return true;
    }
}
