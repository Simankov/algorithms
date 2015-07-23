package com.company;

class MergeSort extends Sorting {
    MergeSort(double[] A) {
        super(A);
    }

    @Override
    void sort() {
        MergeSort(0,A.length-1);
    }

    void MergeSort(int p, int r){
        if (p>=r) return;

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

        double[] L = new double[n1];
        double[] R = new double[n2];

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
                j++;
            } else {
                A[s] = L[i];
                i++;
            }
        }
    }
}