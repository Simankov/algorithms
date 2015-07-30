package com.company;

/**
 * Created by sergey on 30.07.15.
 */
abstract class MatrixOperations {
    int [][] left;
    int [][] right;
    int [][] result;
    MatrixOperations(int [][] a){
        left = a.clone();
    }

    MatrixOperations(int [][] a, int [][] b){
        left = a;
        right = b;
    }

    public boolean compare(int[][] a,int [][] b){
        for (int i = 0; i<a.length; i++){
            for(int j = 0; j<a.length; j++){
                if (a[i][j]!=b[i][j]){
                    System.out.println("Error in "+ i + " "+j + " values: "+
                                       a[i][j] + " "+ b[i][j]);
                    return false;

                }
            }
        }
        return true;
    }




}
