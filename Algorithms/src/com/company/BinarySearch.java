package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class BinarySearch extends Searching{

    BinarySearch(int[] A){
        super(A);
    }

    int search(int element) {
        return  BinarySearch(element,0,A.length-1);

    }

    int BinarySearch(int element, int begin, int end){
        int el = element;
        while(end>=begin){
            int c = (end+begin)/2;
            if (A[c]==element) return c;
            if (A[c]>element){
                end = c-1;
            }
            else
            {
                begin = c+1;
            }
        }
        return -1;
    }
}
