package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class InsertionSort extends Sorting {
    InsertionSort(double[] A) {
        super(A);
    }

    @Override
    void sort() {
        InsertionSort();
    }

    void InsertionSort() {
        int n = A.length;
        for (int j = 0; j < n - 1; j++) {

            int keyIndex = j;
            for (int i = j; i < n; i++) {
                if (A[i] > A[keyIndex]) {
                    keyIndex = i;
                }
            }
            double dummy = A[keyIndex];
            A[keyIndex] = A[j];
            A[j] = dummy;

        }
    }
}
