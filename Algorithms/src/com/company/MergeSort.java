package com.company;

class MergeSort extends Sorting {
    MergeSort(int[] A) {
        super(A,true);
    }
    MergeSort(int[] A, boolean cloneArray) {
        super(A,cloneArray);
    }

    final int LEAF_SIZE = 64;

    int inversions = 0;

    @Override
    void sort() {
        MergeSort(0, A.length - 1);
    }

    void MergeSort(int p, int r){
        if (r-p<LEAF_SIZE) {

            InsertionSort.InsertionSort(p,r,A);
            return;
        }

        int q = (p+r)/2;
        MergeSort(p,q);
        MergeSort(q+1,r);
        Merge(p,q,r);

    }



    void Merge(int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int n = n1 + n2;
        int i = 0;
        int j = 0;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int l = 0; l < n1; l++) {
            L[l] = A[p + l];

        }

        for (int k = 0; k < n2; k++) {
            R[k] = A[q + 1 + k];

        }

        for (int s = p; s < r + 1; s++) {
            if (i > n1 - 1) {
                A[s] = R[j];
                j++;

            } else if (j > n2 - 1) {
                A[s] = L[i];
                i++;

            } else if (L[i] > R[j]) {
                A[s] = R[j];
                inversions = inversions + n1-i;
                j++;
            } else {
                A[s] = L[i];
                i++;
            }
        }
    }
}