package com.company;

    abstract class Sorting {
        double [] A;
        static Sorting implementation = null;
        Sorting(double [] a) {
            if (implementation == null) {
                implementation = this;
            }
            A  = a.clone();
        }

        abstract void sort();
        void print(){
            for (double a : A){
                System.out.println(a);
            }
        }


    }

