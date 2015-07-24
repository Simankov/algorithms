package com.company;

/**
 * Created by sergey on 24.07.15.
 */
abstract class Searching {
    protected int [] A;
    protected boolean searched = false;
    protected int index;
    Searching(int [] a){
        A = a.clone();
    }
    protected void setSearched(int index){
        searched = true;
        this.index = index;
    }
    abstract void search(int element);
    void print(){
        if (searched)
        {
            System.out.println("Success. Index: " + index);
            System.out.println("");
        }else
        {
            System.out.println("NIL");
            System.out.println("");
        }
    }
}
