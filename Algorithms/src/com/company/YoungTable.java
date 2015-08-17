package com.company;

/**
 * Created by sergey on 17.08.15.
 */
public class YoungTable {

    int [][] A;
    int [][] youngTable;
    int m;
    int n;

    YoungTable(int [][] array){
        A = array;
        m = array.length;
        n = array[0].length;
        youngTable = new int[m][n];

        for (int i=0; i<m;i++){
            for (int j=0; j<n; j++){
                youngTable[i][j]=Integer.MAX_VALUE;
            }
        }
        youngTable[0][0] = A[0][0];

        for (int i=0; i<m;i++){
            for (int j=0; j<n; j++){
                if (i!=0 || j!=0) {
                    insert(A[i][j]);
                }
            }
        }

        int a = 45;

    }

    void insert(int element) {

        if (youngTable[m - 1][n - 1] != Integer.MAX_VALUE) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int left;
        int upper;
        while (i > 0 && j > 0) {
            left = youngTable[i][j - 1];
            upper = youngTable[i - 1][j];

            if (element < left || element < upper) {
                if (left > upper) {
                    youngTable[i][j] = left;
                    j--;
                } else {
                    youngTable[i][j] = upper;
                    i--;
                }
            } else {
                youngTable[i][j] = element;
                return;
            }
        }


        if (i == 0) {

            while (j > 0 && youngTable[i][j - 1] > element) {
                youngTable[i][j] = youngTable[i][j-1];
                j--;
            }
            youngTable[i][j] = element;
            return;
        }

        if (j == 0) {

            while (i > 0 && youngTable[i - 1][j] > element) {
                youngTable[i][j] = youngTable[i - 1][j];
                i--;
            }
            youngTable[i][j] = element;
            return;
        }



    }
}


