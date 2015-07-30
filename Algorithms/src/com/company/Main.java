package com.company;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int n = 2000;
    static int [] A = new int[n];
    static int [][] a = new int[n][n];
    static int [][] b = new int[n][n];
    public static void main(String[] args) {
//
        fillArray();
       MergeSort mergeSort = new MergeSort(A);
//        SelectionSort selectionSort = new  SelectionSort(A);
        mergeSort.sort();
       mergeSort.print();
//        System.out.println(mergeSort.inversions);
//        selectionSort.sort();
//        selectionSort.print();
//
//        InsertionSortRecursive insertionSortRecursive = new InsertionSortRecursive(A);
//        insertionSortRecursive.sort();
//        insertionSortRecursive.print();

//        testBinarySearch();
//        testAdditionSearch();

//        BubbleSort bubbleSort = new BubbleSort(A);
//        bubbleSort.sort();;
//        bubbleSort.print();
//        MaximumSubarray maximumSubarray = new MaximumSubarray(A);
//        maximumSubarray.start();
//        int resultLinear = maximumSubarray.linearMethod()[2];
//        maximumSubarray.stop();
//
//
//        maximumSubarray.start();
//        int resultReqursive = maximumSubarray.reсursiveMethod()[2];
//        maximumSubarray.stop();
//
//        maximumSubarray.start();
//        int resultBruteForce = maximumSubarray.bruteForceMethod()[2];
//        maximumSubarray.stop();
//
//        System.out.println(resultLinear + " " + resultReqursive + " "+resultBruteForce);
//
//        fillArray();
//
//
//        StrassenAlgorithm strassenAlgorithm = new StrassenAlgorithm(a,b);
//        StrassenAlgorithm strassenAlgorithm1 = new StrassenAlgorithm(a,b);
//        long time = System.nanoTime();
//
//         strassenAlgorithm.StrassenMultiplication();
//        time = System.nanoTime() - time;
//        System.out.println(time);

//        time = System.nanoTime();
//        int [][] d = strassenAlgorithm1.sillyMultiply();
//        time = System.nanoTime() - time;
//        System.out.println(time);



//        long time2 = System.nanoTime();
//
//         Strassen.multiply(a,b);
//        time2 = System.nanoTime() - time2;
//        System.out.println(time);
//        System.out.println("done");




    }
    public static int randInt(int min, int max) {


        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    static void fillArray()
    {

        for (int i=0; i<n; i++) {
            A[i] = randInt(-1000,1000);
            for (int j=0; j<n; j++) {
                a[i][j] = randInt(-1000, 1000);
                b[i][j] = randInt(-1000, 1000);
            }
        }
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

    static void testAdditionSearch(){
        AdditionSearch additionSearch = new AdditionSearch(A);
        for (int i = 0;i<1000; i++) {
            int sum = randInt(-10000, 10000);
            int myResult = additionSearch.search(sum);    //int represents boolean 1 or 0
            boolean sysResult = additionSearch.sillyAdditionSearch(sum);
            if (myResult == 1 && sysResult){
                System.out.println("Find");
            }
            else if (myResult == 0 && !sysResult){
                System.out.println("There aren't such indexes");

            }
            else {
                System.out.println("fail.....");
            }
        }



    }


    static int T(int n){
        int [] array = new int[n+1];
        array[0] = 0;
        array[35] = 0;
        for (int i = 36; i<=n; i++){
            if (i % 2 == 1){
                array[i]=2*array[i/2+16]+i;
            }
            else {
                array[i]=2*array[i/2+17]+i;
            }
        }
        return array[n];
    }


}
