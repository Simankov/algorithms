package com.company;

public class InsertionSortRecursive extends Sorting {

    InsertionSortRecursive(int[] A) {
        super(A,true);
    }
    InsertionSortRecursive(int[] A, boolean cloneArray) {
        super(A,cloneArray);
    }

    @Override
    void sort() {

        InsertionRecursive(A.length - 1);
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
