package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int n = 3000;
    static int m = 1689;
    static int[] A = new int[n];
    static int[][] a = new int[m][n];
    static int[][] b = new int[m][n];

    public static void main(String[] args) {

        fillArray();
        testYoungTableSearch();



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

        for (int i=0; i<m; i++) {
//            A[i] = randInt(-1000,1000);
            for (int j=0; j<n; j++) {
                a[i][j] = randInt(-100, 100);
                b[i][j] = randInt(-10, 10);
            }
        }
    }

    static void sortArray(){
        java.util.Arrays.sort(A);
    }

    static void testYoungTableSearch(){
        sortArray();
        YoungTable youngTable  = new YoungTable(a);


        for (int i = 0; i<1500; ++i) {
            int element = (int) (Math.random() * 100);

            boolean systemResult = youngTable.searchElement(element);
            boolean myResult = youngTable.findElement(element);
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
