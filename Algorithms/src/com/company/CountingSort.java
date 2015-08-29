package com.company;

import org.w3c.dom.css.Counter;

/**
 * Created by sergey on 29.08.15.
 */
public class CountingSort extends Sorting{
   static int COUNTER_SIZE = 100000;
    int [] counter;
    int [] B;
    int [] C;

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

    void CountingSortWithVariableLenght(){
        // Using two arrays of size n and two arrays of size k
        // Time complexify is O(n+k)


        int start = 0;
        int digitNumber = 0;
        int p = A.length;
        int [] sortedArray = new int[p];
        int[] oneDigitCounter = new int[COUNTER_SIZE];
        B = A.clone();
        C = A.clone();

        while (start < p-1) {
            oneDigitCounter = new int[COUNTER_SIZE];
            counter = new int[COUNTER_SIZE];

            for (int i = start; i < p; i++) {
                int digit = digit(i, digitNumber);
                if (!isDigitBefore(i, digitNumber)) {
                    oneDigitCounter[digit]++;
                } else {
                    counter[digit]++;
                }
            }

            for (int i = 1; i < COUNTER_SIZE; i++) {
                counter[i] = counter[i - 1] + counter[i];
                oneDigitCounter[i] = oneDigitCounter[i - 1] + oneDigitCounter[i];
            }
            int offset = oneDigitCounter[COUNTER_SIZE - 1];

            for (int j = p - 1; j >= start; j--) {
                int digit = digit(j, digitNumber);
                int oneDigitCount = oneDigitCounter[digit];
                int count = counter[digit];
                if (oneDigitCount > 0 && !isDigitBefore(j,digitNumber)) {
                    sortedArray[start + oneDigitCount - 1] = B[j];
                    oneDigitCounter[digit]--;
                } else {
                    if (count > 0) {
                        C[start + count - 1 + offset] = B[j];
                        counter[digit]--;
                    }
                }
            }
            B = C.clone();
            start += offset;
            digitNumber++;
        }
        A = sortedArray;

    }

    int digit(int i, int digitNumber){
        String number = String.valueOf(B[i]);
        char digit =  number.charAt(number.length() - (digitNumber+1));
        return Character.getNumericValue(digit);
    }

    boolean isDigitBefore(int i, int digitNumber){
        String number = String.valueOf(B[i]);
        if (number.length()-(digitNumber+1)==0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    void sort() {
        CountingSortWithVariableLenght();
    }

    void swap(int i, int j){
        int temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }





}
