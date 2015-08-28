package com.company;

/**
 * Created by sergey on 29.08.15.
 */
public class Interval {
    int a;
    int b;
    Interval(){
        this.a = Main.randInt(-1000,1000);
        this.b = Main.randInt(a,1000);
    }
    Interval(int a, int b){
        this.a = a;
        this.b = b;
    }
    Interval(Interval inv){
        this.a = inv.a;
        this.b = inv.b;
    }
}
