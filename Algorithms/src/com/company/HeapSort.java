package com.company;

/**
 * Created by sergey on 17.08.15.
 */
public class HeapSort extends Sorting{
    HeapSort(int [] a){
        super(a,false);
    }
    void sort(){
         HeapSort();
    };
    void HeapSort(){
        int n = A.length;
        BuildHeap();
        for(int j = A.length-1; j>0; j--){
            int temp = A[j];
            A[j]=A[0];
            A[0]=temp;

            n--;
            MaxHeapify(0,n);
        }
    }


    void MaxHeapify(int i,int heapLenght){
        int left = 2*i;
        int right = left+1;
        int largest = i;
        if (left<heapLenght && A[left]>A[largest]){
            largest = left;
        }

        if(right<heapLenght && A[right]>A[largest]){
            largest = right;
        }

        if (largest != i){
            int temp = A[i];
            A[i]=A[largest];
            A[largest] = temp;

            MaxHeapify(largest,heapLenght);
        }
    }
    void BuildHeap(){
        int firstNodeWithChild = (int)Math.floor(((double)A.length)/2)-1;
        for (int j = firstNodeWithChild;j>=0;j--){
            MaxHeapify(j,A.length);
        }
    }

}
