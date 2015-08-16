package com.company;

/**
 * Created by sergey on 24.07.15.
 */
public class BinarySearch extends Searching{

    BinarySearch(int[] A){
        super(A);
    }

    int search(int element) {
//        return  BinarySearch(element,0,A.length-1);
        return  recursiveBinarySearch(0,A.length-1,element);

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

    int recursiveBinarySearch(int left, int right, int element){
        if (left>right){
            return -1;
        }

        int center = (left + right)/2;
        if (A[center]==element){
            return center;
        }

        if (A[center]<element)
        {
           return recursiveBinarySearch(center+1,right,element);
        }
        return recursiveBinarySearch(left,center-1,element);

    }
}
