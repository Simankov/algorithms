package com.company;

/**
 * Created by sergey on 26.07.15.
 */
public class MaximumSubarray extends Searching {

    MaximumSubarray(int[] A) {
        super(A);
    }

    @Override
    int search(int element) {
        return 0;
    }

    int[] reсursiveMethod() {
        return FindMaxSubarray(0, A.length - 1);
    }

    int[] FindMaxSubarray(int low, int high) {
//        if (low == high) {
//            return new int[]{low, high, A[low]};
//        }
        if (high - low < 80){
            MaximumSubarray maximumSubarray = new MaximumSubarray(
                                                java.util.Arrays.copyOfRange(A,low,high));

            return maximumSubarray.bruteForceMethod();
        }

        int mid = (low + high) / 2;

        int[] left = FindMaxSubarray(low, mid);
        int[] right = FindMaxSubarray(mid + 1, high);
        int[] cross = FindMaxCrossSubarray(low, mid, high);

        if (left[2] >= right[2] && left[2] >= cross[2]) {
            return left;
        } else if (right[2] >= left[2] && right[2] >= cross[2]) {
            return right;
        } else {
            return cross;
        }

    }


    int[] FindMaxCrossSubarray(int low, int mid, int high) {

        int maxValueL = A[mid];
        int maxValueR = A[mid + 1];
        int sum = A[mid];
        int maxIndexL = mid;
        int maxIndexR = mid + 1;


        for (int j = mid - 1; j >= low; j--) {
            sum = sum + A[j];
            if (sum > maxValueL) {
                maxValueL = sum;
                maxIndexL = j;
            }
        }

        sum = A[mid + 1];

        for (int i = mid + 2; i <= high; ++i) {
            sum = sum + A[i];
            if (sum > maxValueR) {
                maxValueR = sum;
                maxIndexR = i;
            }
        }

        return new int[]{maxIndexL, maxIndexR, maxValueL + maxValueR};


    }

    int[] linearMethod() {

//        if (maxValue()[1]<=0) {
//            return maxValue();
//        }


        int[] maxIndex = {0, 0};
        int maxValue = A[0];
        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {

            sum += A[i];

            if (sum > maxValue) {
                maxIndex[0] = startIndex;
                maxIndex[1] = i;
                maxValue = sum;
            }

            if (sum < 0) {
                sum = 0;
                startIndex = i + 1;
                continue;
            }


        }
        return new int[]{maxIndex[0], maxIndex[1], maxValue};
    }

    int[] maxValue() {
        int max = A[0];
        int maxIndex = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[j] > max) {
                max = A[j];
                maxIndex = j;
            }
        }
        return new int[]{maxIndex, max};
    }

    int[] bruteForceMethod() {
        int leftIndex = 0;
        int rightIndex = 0;
        int maxSum = A[0];
        int sum = 0;

        for (int i = 0; i < A.length; ++i) {
            sum = 0;
            for (int j = i; j < A.length; ++j) {
                sum = sum + A[j];
                if (sum > maxSum) {
                    leftIndex = i;
                    rightIndex = j;
                    maxSum = sum;

                }

            }
        }

        return new int[]{leftIndex, rightIndex, maxSum};
    }
}