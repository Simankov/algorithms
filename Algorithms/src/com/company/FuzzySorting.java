package com.company;

/**
 * Created by sergey on 22.08.15.
 */
public class FuzzySorting {
    Interval[] A;
    FuzzySorting(Interval[] intervals){
        this.A = intervals;
    }

    int [] RandomizedFuzzyPartition(int p,int r) {
        int rand = Main.randInt(p,r);
        swap(rand,r);
        return FuzzyPartition(p,r);
    }
    void RandomizedFuzzySorting(int p, int r){
        if (p<r){
            int[] partition = RandomizedFuzzyPartition(p,r);
            RandomizedFuzzySorting(p, partition[0] - 1);
            RandomizedFuzzySorting(partition[1]+1,r);
        }
    }
    void sort(){
        RandomizedFuzzySorting(0,A.length-1);
    }

    int [] FuzzyPartition(int p,int r){
        Interval x = new Interval(A[r]);
        int i = p-1;
        int k = p-1;
        for (int j = p; j<r; j++) {
            Interval intersection = intersect(A[j], x);
            if (A[j].b < x.a) {
                i++;
                k++;
                swap(k, j);
                swap(i, k);
            } else if (intersection.a <= intersection.b) {
                k++;
                swap(j, k);
                x = intersection;

            }
        }
        swap(r, k + 1);
        return new int[] {i+1,k+1};
    }

    Interval intersect(Interval A, Interval B){
        int max_a = A.a>=B.a?A.a:B.a;
        int min_b = A.b<=B.b?A.b:B.b;

        return new Interval(max_a,min_b);
    }

    void swap(int i,int j){
        Interval temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    void print(){
        for (Interval a : A){
            System.out.println(a.a + "-" + a.b);
        }
    }

    void check() {
        for (int j=0; j<A.length-1; j++) {
            if (A[j+1].b<A[j].a){
                System.out.println("failed" +A[j].a + " " + A[j].b);
                System.out.println(A[j+1].a + " " + A[j+1].b);
            }
        }

    }
}
