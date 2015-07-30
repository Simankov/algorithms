package com.company;

/**
 * For array A and element x search are there indexes j!=i : A[j]+A[i] = x
 * Used MergeSort (one time) with O(n*lgn) and BinarySearch (n-1 times) with O(lgn)
 * so complexity of algorithm is O(n*lgn)
 */
public class AdditionSearch extends Searching{
    AdditionSearch(int [] a){
        super(a);
    }

    @Override
    int search(int sum) {
        if (AdditionSearch(sum)) return 1;
        else return 0;
    }
// additional search with complexity O(n^2)
    boolean sillyAdditionSearch(int element){


        for (int i=0; i<A.length; i++){
            int key = element - A[i];
            for (int j = 0; j<A.length; j++) {
                if (A[j]==key) return true;
            }
        }
        return false;
    }

    boolean AdditionSearch(int x){
        BinarySearch binarySearch = new BinarySearch(A);
        MergeSort mergeSort = new MergeSort(A,false);
        for (int j=0; j<A.length-1; j++){
            int key = x-A[j];
            int result = binarySearch.search(key);
            if (result > 0) return true;

        }
        return false;
    }
}
