package com.company;

/**
 * Created by sergey on 17.08.15.
 */
public class YoungTable {

    int[] A;
    int [] sortedArray;
    int[][] youngTable;
    int m;
    int n;


    YoungTable(int[] array) {
        A = array;

        // get suitable size for youngTable
        m =(int)Math.sqrt((double)A.length);
        n = A.length/m+1;


        youngTable = new int[m][n];

        //fill with inf-elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                youngTable[i][j] = Integer.MAX_VALUE;
            }
        }
        youngTable[0][0] = A[0];

        // insert method take O(n+m)
        for (int i = 1; i < A.length; i++) {
                    insert(A[i]);
        }
    }

    // sort n^2 elements for O(n^3)
    void sort(){
        for (int i = 0; i<A.length; i++){
               A[i] = ExtractMin();
            }
    }

    // O(n+m)
    int ExtractMin(){
        int min = youngTable[0][0];
        int i = 0;
        int j = 0;
        while (i<m && j<n){
            if (i==m-1){
                while(j<n-1) {
                    youngTable[i][j] = youngTable[i][j + 1];
                    j++;
                }
                break;
            }

            if (j==n-1){
                while(i<m-1) {
                    youngTable[i][j] = youngTable[i+1][j];
                    i++;
                }
                break;
            }

            if (youngTable[i+1][j]<youngTable[i][j+1]){
                youngTable[i][j] = youngTable[i+1][j];
                i++;
            } else {
                youngTable[i][j] = youngTable[i][j+1];
                j++;
            }

        }
        youngTable[m-1][n-1] = Integer.MAX_VALUE;
        return min;
    }

    // O(n+m)
    void insert(int element) {

        if (youngTable[m - 1][n - 1] != Integer.MAX_VALUE) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int left;
        int upper;
        while (i > 0 && j > 0) {
            left = youngTable[i][j - 1];
            upper = youngTable[i - 1][j];

            if (element < left || element < upper) {
                if (left > upper) {
                    youngTable[i][j] = left;
                    j--;
                } else {
                    youngTable[i][j] = upper;
                    i--;
                }
            } else {
                youngTable[i][j] = element;
                return;
            }
        }


        if (i == 0) {

            while (j > 0 && youngTable[i][j - 1] > element) {
                youngTable[i][j] = youngTable[i][j - 1];
                j--;
            }
            youngTable[i][j] = element;
            return;
        }

        if (j == 0) {

            while (i > 0 && youngTable[i - 1][j] > element) {
                youngTable[i][j] = youngTable[i - 1][j];
                i--;
            }
            youngTable[i][j] = element;
            return;
        }


    }


    void print() {

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int value = youngTable[row][col];

                if (value==Integer.MAX_VALUE){
                    System.out.printf("max");
                } else {
                    System.out.printf("%4d", youngTable[row][col]);
                }
            }
            System.out.println();
        }

        for (int i = 0; i < A.length; i++) {
                System.out.printf(A[i]+" ");
        }

    }
   // This program for memory advantages using arrays of Points, two points for every submatrix
    // one of this points represent left upper edge of submatrix and another point represent
    // right lower edge.
    // SplitTable(Point[],...) work with square matrix.It split matrix using a point (a,b) where a,b
    //-diagonal elements : a<x<b.

    Point[][] SplitTable(Point[] splitter, Point leftUpper, Point rightBottom) {
        Point[] rightUpperMatrix = {new Point(leftUpper.x, splitter[1].y),
                new Point(splitter[0].x, rightBottom.y)};

        Point[] leftBottomMatrix = {new Point(splitter[1].x, leftUpper.y),
                new Point(rightBottom.x, splitter[0].y)};
        Point[][] tables = new Point[][]{leftBottomMatrix, rightUpperMatrix};
        return tables;

    }

    // Split matrix by square matrixes and remainder.

    Point[][] SplitTable(Point leftUpper, Point rightBottom) {
        int m = rightBottom.x - leftUpper.x + 1;
        int n = rightBottom.y - leftUpper.y + 1;
        int j = 0;
        int factor = m > n ? m / n : n / m;
        Point[][] points = new Point[factor][2];
        int addition = 0;
        int min = n > m ? m : n;
        int max = n > m ? n : m;

        if (n > m) addition = m;
        else addition = n;
        Point rightBottomPoint = new Point(leftUpper.x, leftUpper.y);
        rightBottomPoint.add(addition - 1);
        if (n > m) {

            for (int i = 0; i < factor; i++) {

                Point leftUp = new Point(leftUpper.x, leftUpper.y + addition * i);
                Point rightBot = new Point(rightBottomPoint.x, rightBottomPoint.y + addition * i);


                points[i][0] = leftUp;
                points[i][1] = rightBot;
            }

        } else {

            for (int i = 0; i < factor; i++) {
                Point leftUp = new Point(leftUpper.x + addition * i, leftUpper.y);
                Point rightBot = new Point(rightBottomPoint.x + addition * i, rightBottomPoint.y);


                points[i][0] = leftUp;
                points[i][1] = rightBot;
            }

        }
        // Is there a remainder
        if (factor * min < max) {
            Point leftUp;
            Point rightBot;
            if (n > m) {
                leftUp = new Point(leftUpper.x, leftUpper.y + factor * addition);
                rightBot = new Point(rightBottom.x, rightBottom.y);

            } else {
                leftUp = new Point(leftUpper.x + factor * addition, leftUpper.y);
                rightBot = new Point(rightBottom.x, rightBottom.y);
            }

            Point[][] newPoints = new Point[factor + 1][2];
            for (int i = 0; i < factor; i++) {
                newPoints[i] = points[i];
            }
            newPoints[factor][0] = leftUp;
            newPoints[factor][1] = rightBot;
            return newPoints;
        }

        return points;
    }



    boolean findElement(int element) {
        return findElement(element, new Point(0, 0),
                           new Point(m - 1, n - 1));
    }

    // main function
    boolean findElement(int element, Point leftUpper, Point rightBottom) {

        int m = rightBottom.x - leftUpper.x + 1;
        int n = rightBottom.y - leftUpper.y + 1;


        //matrix 2x2 and 1x1
        if (n == m && n <= 2) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (element == youngTable[leftUpper.x + i][leftUpper.y + j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        // matrix 1xk
        if (leftUpper.x == rightBottom.x) {
            int result = new BinarySearch(youngTable[leftUpper.x]).BinarySearch(element, leftUpper.y, rightBottom.y);
            if (result != -1) return true;
            return false;
        }

        // matrix kx1
        if (leftUpper.y == rightBottom.y) {
            // Special implementation of binarySearch for memory advantage
            return BinarySearchInRow(leftUpper.y, element, leftUpper.x, rightBottom.x);
        }

        if (n != m) {
            Point[][] splitTables = SplitTable(leftUpper, rightBottom);
            for (Point[] table : splitTables)
                if (findElement(element, table[0], table[1])) {
                    return true;
                }
        } else {
            Point[] result = DiagonalBinarySearch(leftUpper, rightBottom, element);
            if (result.length != 0) {
                if (result.length == 1) {
                    return true;
                } else {
                    Point[][] tables = SplitTable(result, leftUpper, rightBottom);
                    for (Point[] table : tables) {
                        if (findElement(element, table[0], table[1])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;


    }

    //Special realizations of Binarysearch O(lgn), in place

    boolean BinarySearchInRow(int row, int element, int begin, int end) {
        while (begin <= end) {
            int c = begin + (end - begin) / 2;
            if (youngTable[c][row] == element) {
                return true;
            }
            if (youngTable[c][row] > element) {
                end = c - 1;
            } else {
                begin = c + 1;
            }
        }
        return false;
    }


    //return point (a,b) where a,b - diagonal elements : a<x<b.
    Point[] DiagonalBinarySearch(Point leftUpper, Point rightBottom, int element) {
        int begin = 0;
        int end = rightBottom.x - leftUpper.x;

        if (element > youngTable[rightBottom.x][rightBottom.y] ||
                element < youngTable[leftUpper.x][leftUpper.y]) {
            return new Point[]{};
        }

        while (begin <= end) {
            int c = (begin + end) / 2;
            int x = leftUpper.x + c;
            int y = leftUpper.y + c;
            if (youngTable[x][y] == element) {
                return new Point[]{new Point(c, c)};
            }
            if (youngTable[x][y] > element) {
                if (youngTable[x - 1][y - 1] < element)
                    return new Point[]{new Point(x - 1, y - 1), new Point(x, y)};
                end = c - 1;
            } else {
                if (youngTable[x + 1][y + 1] > element)
                    return new Point[]{new Point(x, y), new Point(x + 1, y + 1)};
                begin = c + 1;
            }
        }
        return new Point[]{};
    }

    //Search element by every column using BinarySearch, so O(nlgn)
    boolean standartSearch(int element) {
        for (int i = 0; i < m; i++) {
            if (java.util.Arrays.binarySearch(youngTable[i], element) > 0)
                return true;
        }
        return false;
    }

    //Search element in O(n+m), simplest
    boolean smartSearch(int element){
        int i=m-1;
        int j=0;
        while (i>=0 && i<m && j>=0 && j<n){
            if (youngTable[i][j]==element)
                return true;
            if (youngTable[i][j]<element){
                if (j!=n-1) {
                    j++;
                } else {
                    return false;
                }
            } else {
                if (i!=0) {
                    i--;
                } else {
                    return false;
                }
            }
        }



        return false;
    }
}