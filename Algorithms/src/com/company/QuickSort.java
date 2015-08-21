package com.company;

/**
 * Created by sergey on 19.08.15.
 */
public class QuickSort extends Sorting{

     int LEAF_SIZE = 29;

    QuickSort(int [] A) {
    super(A,true);
    }

    void RandomizedQuickSort(int p,int r){
        if ( r-p > LEAF_SIZE) {
            int q = RandomizedPartition(p,r);
            RandomizedQuickSort(p,q-1);
            RandomizedQuickSort(q+1,r);
        } else {
            InsertionSort.InsertionSort(p,r,A);

        }
    }
    int[] PartitionWithEquals(int p,int r){
        int i = p-1;
        int k = p-1;
        int x = A[r];
        for (int j=p; j<r; j++){
            if (A[j]<x){
                i++;
                k++;
                swap(k,j);
                swap(i,k);

            } else if (A[j]==x){
                k++;
                swap(k,j);
            }
        }
        swap(k+1,r);
        return new int[] {i+1,k+1};
    }
    int [] RandomizedPartitionWithEquals(int p,int r){
        int k = Main.randInt(p,r);
        swap(r,k);
        return PartitionWithEquals(p,r);
    }

    void RandomizedQuickSortWithEquals(int p,int r){
        if (p<r){
            int [] indexes = RandomizedPartitionWithEquals(p,r);
            int q1 = indexes[0];
            int q2 = indexes[1];
            RandomizedQuickSortWithEquals(p,q1-1);
            RandomizedQuickSortWithEquals(q2,r);
        }
    }

    int RandomizedPartition(int p, int r){
       int k = Main.randInt(p,r);
        swap(p,k);
        return HoarPartition(p,r);
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

    void setLeaf(int LEAF_SIZE){
        this.LEAF_SIZE = LEAF_SIZE;
    }

    int HoarPartition(int p,int r){
        int i = p-1;
        int j = r+1;
        int x = A[p];
        while (true){

            do {
                i++;
            } while (A[i]<x);

            do {
                j--;
            } while (A[j]>x);

            if (i<j) {
                swap(i, j);
            } else {
                return j;
            }

        }
    }

    void sort(){
        RandomizedQuickSortWithEquals(0,A.length-1);
    }
}
