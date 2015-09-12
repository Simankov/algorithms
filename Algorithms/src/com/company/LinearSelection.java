package com.company;

/**
 * Created by admin on 04/09/15.
 */
public class LinearSelection {
    int [] A;
    final int k = 5;
    LinearSelection(int [] array){
        A = array;
    }
    int LinearSelection(int position){
        return LinearSelection(position,A);
    }

    int LinearSelection(int position, int [] array) {
        int n = array.length;
        if (n==1) return array[0];
        int start = 0;
        int delimiter = n % 5;
        int offset;
        int d_offset;
        if (k % 2 == 0) {
            offset = k / 2 - 1;
        } else {
            offset = k / 2;
        }

        if (delimiter % 2 == 0) {
            d_offset = delimiter / 2 - 1;
        } else {
            d_offset = delimiter / 2;
        }

        int count = delimiter == 0 ? n / 5 : n / 5 + 1;
        int[] medians = new int[count];
        for (int j = 1; j < count; j++) {
            InsertionSort.InsertionSort(start, start + k - 1, array);
            medians[j - 1] = array[start + offset];
            start = start + k;
        }

        if (delimiter > 0) {
            InsertionSort.InsertionSort(start, start + delimiter - 1, array);
            medians[count - 1] = array[start + d_offset];
        }
        int center = medians.length % 2 == 0 ? medians.length / 2 - 1
                : medians.length / 2;

        int median_medians;
        if (medians.length == 2 || medians.length == 1) {
            median_medians = medians[0];
        } else {
            median_medians = LinearSelection(center, medians);
        }

        int q = Partition(array,median_medians);

        if (q==position){

            return array[q];

        } else if (position>q){

            int [] right_array = new int[n-q-1];

            for(int j = 0; j<right_array.length; j++)
                right_array[j]=array[q+1+j];

            return LinearSelection(position-q,right_array);

        } else {
            int [] left_array = new int[q];

            for (int j = 0; j<left_array.length; j++)
                left_array[j]=array[j];

            return LinearSelection(position,left_array);
        }


    }

    int Partition(int [] A, int pivot){
        int i = -1;
        for (int j = 0; j<A.length; j++){
            if (A[j]<pivot){
                i++;
                swap(i,j,A);
            }
        }
        return i+1;
    }

    void swap(int i, int j,int [] A){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
