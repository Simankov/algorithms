package com.company;

/**
 * Created by sergey on 18.08.15.
 */
public class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    void add(int addition){
        this.x+=addition;
        this.y+=addition;
    }
}
