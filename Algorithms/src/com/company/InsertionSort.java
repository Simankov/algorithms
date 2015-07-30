package com.company;

public class InsertionSort extends Sorting {

    InsertionSort(int[] A) {
        super(A,true);
    }
    InsertionSort(int[] A, boolean cloneArray) {
        super(A,cloneArray);
    }

    @Override
    void sort() {

        InsertionRecursive(A.length - 1);
    }

   static void InsertionSort(int i, int j, int [] A){

        for(int k = i+1; k<=j; k++){
            int key = A[k];
            int p = k-1;
            while (p>=j && A[p]>key){
                A[p+1]=A[p];
                --i;
            }
            A[p+1] = A[p];

        }
    }

    void InsertionRecursive(int p){
        if (p == 0) return;
        else
        {
            int q = p-1;
            InsertionRecursive(q);
            int key = A[p];
            int i = q;
            while ((i >= 0 ) && (A[i] < key)) {
                A[i + 1] = A[i];
                --i;
            }
            A[i + 1] = key;

        }

    }

}
