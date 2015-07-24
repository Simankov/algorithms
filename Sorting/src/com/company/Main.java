package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n = 15;
    static int [] A = new int[n];
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

        testBinarySearch();

    }


    static void fillArray()
    {

        for (int i=0; i<n; i++) A[i] = ((int) (Math.random()*100));
    }

    static void sortArray(){
        java.util.Arrays.sort(A);
    }

    static void testBinarySearch(){
        sortArray();

        for (int i = 0; i<150; ++i) {
            int index = (int) (Math.random() * n);

            BinarySearch binarySearch = new BinarySearch(A);
            binarySearch.search(A[index]);
            binarySearch.print();
        }

        for (int i = 0; i<150; ++i) {
            int element = (int) (Math.random() * 100);
            System.out.println(java.util.Arrays.binarySearch(A,element));
            BinarySearch binarySearch = new BinarySearch(A);
            binarySearch.search(element);
            binarySearch.print();

        }
    }

}
