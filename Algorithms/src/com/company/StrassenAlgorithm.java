package com.company;

/**
 * Created by sergey on 30.07.15.
 */
public class StrassenAlgorithm extends  MatrixOperations {
    StrassenAlgorithm(int [][] A, int [][] B){
        super(A,B);
    }

    final int LEAF_SIZE = 128;

    enum Matrix{
        mA,mB,Nil,Both
    }

    enum Sign{
        Plus,Minus
    }
    int [][] StrassenMultiplication(){
        return StrassenMultiplication(left,right,new int[] {0,0},Matrix.Both,left.length);
    }
    //

    int [][] StrassenMultiplication(int a[][], int b[][], int [] matrixLeftUpperEdge, Matrix matrix, int length){


        int Ai = 0;
        int Aj = 0;
        int Bi = 0;
        int Bj = 0;


        switch(matrix){
            case mA:
                Ai += matrixLeftUpperEdge[0];
                Aj += matrixLeftUpperEdge[1];
                break;
            case Both:
                Ai += matrixLeftUpperEdge[0];
                Aj += matrixLeftUpperEdge[1];
                Bi += matrixLeftUpperEdge[0];
                Bj += matrixLeftUpperEdge[1];
                break;
            case mB:
                Bi += matrixLeftUpperEdge[0];
                Bj += matrixLeftUpperEdge[1];
                break;
            case Nil:
                break;

        }


        int [][] C = new int[length][length];
        if (length<LEAF_SIZE){
           for(int i = 0; i<length; i++){
               for(int j = 0; j<length; j++){
                   for (int k = 0; k<length; k++) {
                       C[i][j] = a[Ai+i][Aj+k] * b[Bi+k][Bj+j];
                   }
               }
           }

        }
        else
        {


            int delimiter = length%2;
            int size = length/2;
            int n = (delimiter==1)? length-1:length;

            int hSplitIndexA = size + Ai;
            int vSplitIndexA = size + Aj;
            int hSplitIndexB = size + Bi;
            int vSplitIndexB = size + Bj;


             int [] A11 = new int[]{Ai, Aj};
             int [] A12 = new int[]{Ai, vSplitIndexA};
             int [] A21 = new int[]{hSplitIndexA, Aj};
             int [] A22 = new int[]{hSplitIndexA,vSplitIndexA};

             int [] B11 = new int[]{Bi, Bj};
             int [] B12 = new int[]{Bi, vSplitIndexB};
             int [] B21 = new int[]{hSplitIndexB, Bj};
             int [] B22 = new int[]{hSplitIndexB,vSplitIndexB};


            int [][] S1 = subtraction(B12, B22, size, b);                 // B12 - B22
            int [][] S2 = addition   (A11,A12,size,a);
            int [][] S3 = addition   (A21,A22,size,a);
            int [][] S4 = subtraction(B21,B11,size,b);
            int [][] S5 = addition   (A11,A22,size,a);
            int [][] S6 = addition   (B11,B22,size,b);
            int [][] S7 = subtraction(A12,A22,size,a);
            int [][] S8 = addition   (B21,B22,size,b);
            int [][] S9 = subtraction(A11,A21,size,a);                          // A11 - A21
            int [][] S10 =addition   (B11,B12,size,b);

            S1 = StrassenMultiplication(a,S1,A11,Matrix.mA,size);
            S2 = StrassenMultiplication(S2,b,B22,Matrix.mB,size);
            S3 = StrassenMultiplication(S3,b,B11,Matrix.mB,size);
            S4 = StrassenMultiplication(a,S4,A22,Matrix.mA,size);
            S5 = StrassenMultiplication(S5,S6,null,Matrix.Nil,size);
            S6 = StrassenMultiplication(S7,S8,null,Matrix.Nil,size);
            S7 = StrassenMultiplication(S9,S10,null,Matrix.Nil,size);

            for (int i = 0;i < size; i++){
                for (int j = 0; j<size; j++){
                    C[i][j] = S5[i][j] + S4[i][j] - S2[i][j] + S6[i][j];
                }
                for(int k = size; k<n; k++){
                    C[i][k]= S1[i][k-size] + S2[i][k-size];
                }
            }

            for (int i = size;i< n; i++){
                for (int j = 0; j<size; j++){
                    C[i][j] = S3[i-size][j] + S4[i-size][j];
                }
                for(int k = size; k<n; k++){
                    C[i][k]= S5[i-size][k-size] + S1[i-size][k-size] - S3[i-size][k-size] - S7[i-size][k-size];
                }
            }


            if (delimiter > 0){
                for (int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++){
                        C[i][j] += a[i][length-1]+b[length-1][j];
                    }
                }

                for (int i = 0; i<length; i++){
                    for (int l = 0; l<length; l++){
                        C[i][length-1] += a[i][l]*b[l][length-1];
                        C[length-1][i] += a[length-1][l]*b[l][i];
                    }
                }


            }

        }

        return C;

    }

    int[][] sillyMultiply(){

        int n = left.length;
        int [][] c = new int [n][n];

        for (int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                c[i][j] = 0;
                for (int k = 0; k<n; k++){
                    c[i][j]+=left[i][k]*right[k][j];
                }
            }
        }

        return c;
    }


   // first (second) is 2D point, which point to left upper edge of A (B)

   int [][] subtraction(int[] firstLeftUpper, int[] secondLeftUpper, int n, int[][] matrix) {
       return addition(firstLeftUpper,secondLeftUpper,n,Sign.Minus,matrix, matrix);
   }
    int [][] addition(int[] firstLeftUpper, int[] secondLeftUpper, int n, Sign sign, int[][] matrixA, int [][] matrixB){
        int[][] result = new int[n][n];
        int signMultipler = 1;




        if (sign == Sign.Minus){
            signMultipler = -1;
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                result[i][j] = matrixA[i+firstLeftUpper[0]][j+firstLeftUpper[1]] +
                               matrixB[i+secondLeftUpper[0]][j+secondLeftUpper[1]]*signMultipler;
            }
        }
        return result;
    }

    int [][] addition(int[] firstLeftUpper, int[] secondLeftUpper, int n, int[][] matrix) {
         return addition(firstLeftUpper,secondLeftUpper, n, Sign.Plus, matrix, matrix);
    }

}
