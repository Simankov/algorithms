package com.company;

/**
 * Created by sergey on 29.08.15.
 */
public class CountingSort extends Sorting{
   static int COUNTER_SIZE = 100000;
    int [] counter;

   static public void setCounterSize(int size) {
        COUNTER_SIZE = size;
    }

    CountingSort(int [] A){
        super(A,true);
        counter = new int [COUNTER_SIZE];
    }

    void CountingSort(){
        for (int i = 0; i<A.length; i++){
            counter[A[i]]++;
        }
        for (int j = 1; j<COUNTER_SIZE; j++){
            counter[j]=counter[j]+counter[j-1];
        }

        for (int i = 0; i<A.length-1; i++){
            int last = A[A.length-1];
            swap(counter[last]-1,A.length-1);
            counter[last]--;

        }
    }

    @Override
    void sort() {
        CountingSort();
    }

    void swap(int i, int j){
        int temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }





}
