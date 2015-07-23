package com.company;

import java.util.ArrayList;

public class Main {
    static int n = 1500;
    static double [] A = new double[n];
    public static void main(String[] args) {

        fillArray();
        MergeSort mergeSort = new MergeSort(A);
        InsertionSort insertionSort = new  InsertionSort(A);
        mergeSort.sort();
        mergeSort.print();
        insertionSort.sort();
        insertionSort.print();


    }


    static void fillArray()
    {
        for (int i=0; i<n; i++) A[i] = Math.random()*10;
    }


}
