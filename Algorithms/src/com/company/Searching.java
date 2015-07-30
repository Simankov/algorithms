package com.company;

import java.util.Timer;

/**
 * Created by sergey on 24.07.15.
 */
abstract class Searching {
    long time;
    protected int [] A;
    Searching(int [] a){
        A = a;
    }

    abstract int search(int element);
    void start(){
        time = System.nanoTime();
    }
    void stop(){
        time = System.nanoTime()-time;
        System.out.println(time);
    }

}
