package com.company;

/**
 * Created by sergey on 24.07.15.
 */
abstract class Searching {
    protected int [] A;
    Searching(int [] a){
        A = a.clone();
    }

    abstract int search(int element);

}
