package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n = 300;
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


        for (int i = 0; i<1500; ++i) {
            int element = (int) (Math.random() * 100);
            BinarySearch binarySearch = new BinarySearch(A);
            int systemResult = java.util.Arrays.binarySearch(A,element);
            int myResult = binarySearch.search(element);
            if (systemResult == myResult && myResult>0)
            {
                System.out.println("success: find "+ myResult);
            }
            else if (systemResult<0 && myResult<0){
                System.out.println("success: null ");
            }
            else {
                System.out.println("fail");
            }




        }
    }

}
