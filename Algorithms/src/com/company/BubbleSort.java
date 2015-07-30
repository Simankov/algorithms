package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class BubbleSort extends Sorting {
    BubbleSort(int [] a)
    {
        super(a,true);
    }

    @Override
    void sort() {
        BubbleSort();
    }

    void BubbleSort(){
        for (int i = 0; i<A.length-2; ++i){
            for (int j = A.length-1; j>i;--j){
                if (A[j]<=A[j-1]){
                    int temp = A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
            }
        }
    }
}
