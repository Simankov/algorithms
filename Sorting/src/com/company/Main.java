package com.company;

import java.util.ArrayList;

public class Main {
    static int n = 15;
    static double [] A = new double[n];
    public static void main(String[] args) {

        fillArray();
        MergeSort mergeSort = new MergeSort(A);
        SelectionSort selectionSort = new  SelectionSort(A);
        mergeSort.sort();
        mergeSort.print();
        selectionSort.sort();
        selectionSort.print();

        InsertionSortRecursive insertionSortRecursive = new InsertionSortRecursive(A);
        insertionSortRecursive.sort();
        insertionSortRecursive.print();


    }


    static void fillArray()
    {
        for (int i=0; i<n; i++) A[i] = Math.random()*10;
    }


}
