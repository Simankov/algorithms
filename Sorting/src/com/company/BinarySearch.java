package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class BinarySearch extends Searching{

    BinarySearch(int[] A){
        super(A);
    }

    void search(int element) {
        int result = BinarySearch(element,0,A.length-1);
        switch (result){
            case -1:
                break;
            default:
                this.setSearched(result);
        }
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
