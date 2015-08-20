package com.company;

/**
 * Created by sergey on 19.08.15.
 */
public class QuickSort extends Sorting{
    QuickSort(int [] A) {
    super(A,true);
    }

    void RandomizedQuickSort(int p,int r){
        if (p<r){
            int q = RandomizedPartition(p,r);
            RandomizedQuickSort(p,q-1);
            RandomizedQuickSort(q+1,r);
        }
    }

    int RandomizedPartition(int p, int r){
       int k = Main.randInt(p,r);
        swap(r,k);
        return Partition(p,r);
    }

    void QuickSort(int p, int r){
        if (p<r) {
            int q = Partition(p,r);
            QuickSort(p,q-1);
            QuickSort(q+1,r);
        }
    }

    int Partition(int p,int r){
        int x = A[r];
        int i = p-1;

        for(int j = p; j<r; j++){
            if (A[j]<=x){
                i++;
                swap(i,j);
            }
        }
        swap(i+1,r);
        return i+1;

    }

    void swap(int i, int j){
        int temp = A[j];
        A[j]=A[i];
        A[i]=temp;

    }

    void sort(){
        RandomizedQuickSort(0,A.length-1);
    }
}
