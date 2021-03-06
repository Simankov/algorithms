package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int size = 15000000;
//    static int n = 20;
//    static int m = 39;
    static int[] A = new int[size];
//    static int[][] a = new int[m][n];
//    static int[][] b = new int[m][n];

    public static void main(String[] args) {


        fillArray();
        YoungTable youngTable = new YoungTable(A);
        int element = -19999;

        long time = System.nanoTime();
        youngTable.findElement(element);     // my realization
        time = System.nanoTime()-time;
        System.out.println(time);

        time = System.nanoTime();
        youngTable.smartSearch(element);    // clean O(n+m)
        time = System.nanoTime()-time;
        System.out.println(time);

        time = System.nanoTime();
        youngTable.standartSearch(element); // clean O(nlogn)
        time = System.nanoTime()-time;
        System.out.println(time);


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

        for (int i=0; i<size; i++) {
            A[i] = randInt(-1000, 1000);
        }
//        for (int i=0; i<m; i++)
//            for (int j=0; j<n; j++) {
//                a[i][j] = randInt(-10, 10);
//                b[i][j] = randInt(-10, 10);
//            }
    }

    static void sortArray(){
        java.util.Arrays.sort(A);
    }

    static void testYoungTableSearch(){

        YoungTable youngTable  = new YoungTable(A);



        for (int i = 0; i<1500; ++i) {
            int element = (int) (Math.random() * 100);

            boolean systemResult = youngTable.smartSearch(element);
            boolean myResult = youngTable.standartSearch(element);
            if (systemResult && myResult)
            {
                System.out.println("success: find "+ myResult);
            }
            else if (!systemResult && !myResult){
                System.out.println("success: null ");
            }
            else {
                System.out.println("fail");
            }




        }


        youngTable.sort();
        youngTable.print();
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
