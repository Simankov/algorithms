package com.company;

    abstract class Sorting {
        int [] A;

        Sorting(int [] a) {

            A  = a.clone();
        }

        abstract void sort();
        void print(){
            for (double a : A){
                System.out.println(a);
            }
        }


    }

