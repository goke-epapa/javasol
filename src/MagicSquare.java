
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author team caesium
 */
public class MagicSquare {

    static int sumOfPrimaryDiag = 0;
    static int sumOfSecDiag = 0;
    static int[] sumOfRows;
    static int[] sumOfCols;

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bInputStream.readLine().trim());
        int[][] mSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = bInputStream.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                mSquare[i][j] = Integer.parseInt(arr[j]);
            }
        }
        if (isMagicSquare(mSquare)) {
            System.out.println("0");
        } else {
            calculateMagicSums(mSquare);
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = sumOfCols.length - 1; i >= 0; i--) {
                if (sumOfCols[i] != sumOfPrimaryDiag) {
                    sb.append("-" + (i + 1));
                    sb.append("\n");
                    count++;
                }
            }
            if (sumOfSecDiag != sumOfPrimaryDiag) {
                sb.append("0");
                sb.append("\n");
                count++;
            }
            for (int i = 0; i < sumOfRows.length; i++) {
                if (sumOfRows[i] != sumOfPrimaryDiag) {
                    sb.append(i + 1);
                    sb.append("\n");
                    count++;
                }
            }
            System.out.println(count);
            System.out.println(sb.toString());
        }
        System.exit(0);
    }

    public static void printErrors(int[][] arr) {
        // columns
    }

    public static void calculateMagicSums(int[][] arr) {
        final int n = arr.length;
        final int nSquare = n * n;
        final int M = (n * n * (n * n + 1) / 2) / n;
        int sumOfRow = 0, sumOfColoumns = 0, sumOfPrimaryDiagonal = 0, sumOfSecondaryDiagonal = 0;
        boolean[] flag = new boolean[n * n];
        sumOfRows = new int[n];
        sumOfCols = new int[n];
        for (int row = 0; row < n; row++) {
            sumOfRow = 0;
            sumOfColoumns = 0;
            for (int col = 0; col < n; col++) {
                sumOfRow += arr[row][col];
                sumOfColoumns += arr[col][row];
            }
            sumOfPrimaryDiagonal += arr[row][row];
            sumOfSecondaryDiagonal += arr[row][n - row - 1];
            sumOfRows[row] = sumOfRow;
            sumOfCols[row] = sumOfColoumns;
        }
        sumOfPrimaryDiag = sumOfPrimaryDiagonal;
        sumOfSecDiag = sumOfSecondaryDiagonal;
    }

    public static boolean isMagicSquare(int[][] arr) {
        final int n = arr.length;
        final int nSquare = n * n;
        final int M = (n * n * (n * n + 1) / 2) / n;
        int sumOfRow = 0, sumOfColoumns = 0, sumOfPrimaryDiagonal = 0, sumOfSecondaryDiagonal = 0;
        boolean[] flag = new boolean[n * n];
        sumOfRows = new int[n];
        sumOfCols = new int[n];
        for (int row = 0; row < n; row++) {
            sumOfRow = 0;
            sumOfColoumns = 0;
            for (int col = 0; col < n; col++) {
                if (arr[row][col] < 1 || arr[row][col] > nSquare) {
                    return false;
                }

                if (flag[arr[row][col] - 1] == true) {
                    return false;
                }

                flag[arr[row][col] - 1] = true;
                sumOfRow += arr[row][col];
                sumOfColoumns += arr[col][row];
            }
            sumOfPrimaryDiagonal += arr[row][row];
            sumOfSecondaryDiagonal += arr[row][n - row - 1];
            sumOfRows[row] = sumOfRow;
            sumOfCols[row] = sumOfColoumns;
            if (sumOfRow != M || sumOfColoumns != M) {
                return false;
            }
        }
        sumOfPrimaryDiag = sumOfPrimaryDiagonal;
        sumOfSecDiag = sumOfSecondaryDiagonal;
        if (sumOfPrimaryDiagonal != M || sumOfSecondaryDiagonal != M) {
            return false;
        }
        return true;
    }
}
