public class SpiralOrderMatrix {
  /*  [
            [ 1, 2, 3 10 11 ],
            [ 4, 5, 6 12 13],
            [ 7, 8, 9 14 15]
            [ 16, 17, 18, 19 20]  i=0 row.length-2-i 5-1-0  5-1-1
            ]*/

    public static void main(String[] args) {
        SpiralOrderMatrix spiralMatrix = new SpiralOrderMatrix();
        int[][] ar = new int[][]{
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };

        //spiralMatrix.printSpiral(ar);

        int[][] genSpiralMat = spiralMatrix.generateSpiralMat(4);

        for(int l=0; l<genSpiralMat.length;l++){
            for(int m=0; m<genSpiralMat[0].length;m++){
                System.out.print(genSpiralMat[l][m]+" ");
            }
            System.out.println(" ");
        }
    }

    void printSpiral(int[][] arr){

        int row_len = arr.length,
             col_len = arr[0].length;

        for(int i=0; i< row_len/2; i++){

            for(int p=i; p<col_len-i; p++){
                System.out.print(arr[i][p]+" ");
            }

            for(int q= i+1; q<row_len-i-1;q++){
                System.out.print(arr[q][col_len-i-1]+" ");
            }

            for(int r=col_len-i-1; r>i; r--){
                System.out.print(arr[row_len-i-1][r]+ " ");
            }

            for(int s=row_len-i-1; s>i; s--){
                System.out.print(arr[s][i]+ " ");
            }
        }

    }

    int[][] generateSpiralMat(int n){
        int[][] resultMat = new int[n][n];
        int nextNum=0;
        for(int i=0; i< n/2; i++){

            for(int p=i; p<n-i; p++){
                resultMat[i][p]= nextNum+1;
                nextNum+=1;
            }

            for(int q= i+1; q<n-i-1;q++){
                resultMat[q][n-i-1] = nextNum+1;
                nextNum+=1;
            }

            for(int r=n-i-1; r>i; r--){
                resultMat[n-i-1][r]= nextNum+1;
                nextNum+=1;
            }

            for(int s=n-i-1; s>i; s--){
                resultMat[s][i]=nextNum+1;
                nextNum+=1;
            }
        }

        return resultMat;
    }

}
