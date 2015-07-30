package com.company;

    abstract class Sorting {
        int [] A;

        Sorting(int [] a, boolean cloneArray) {
            if  (cloneArray){
                A  = a.clone();
            }
            else {
                A = a;
            }
        }

        abstract void sort();
        void print(){
            for (double a : A){
                System.out.println(a);
            }
        }


    }

