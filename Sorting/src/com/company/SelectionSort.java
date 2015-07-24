package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class SelectionSort extends Sorting {
    SelectionSort(int[] A) {
        super(A);
    }

    @Override
    void sort() {
       SelectionSort();
    }

    void SelectionSort() {
        int n = A.length;
        for (int j = 0; j < n - 1; j++) {

            int keyIndex = j;
            for (int i = j; i < n; i++) {
                if (A[i] > A[keyIndex]) {
                    keyIndex = i;
                }
            }
            int dummy = A[keyIndex];
            A[keyIndex] = A[j];
            A[j] = dummy;

        }
    }

    @Override
    void print() {
        System.out.println("SelectionSort started");
        super.print();

    }
}
