/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*
* @author yemex4god
*/
public class Pipeline {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws IOException {

       BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
       String line = bInputStream.readLine().trim();
       int N = Integer.parseInt(line);
       int[][] matrix = new int[N][N];
       for (int i = 0; i < N; i++) {
           String row = bInputStream.readLine().trim();
           for (int j = 0; j < N; j++) {
               matrix[i][j] = Integer.parseInt(row.substring(j, j + 1));
           }
       }
       print2dArray(matrix);
       getMovement(matrix);
   }

   public static void print2dArray(int[][] arr) {
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr[i].length; j++) {
               System.out.print(arr[i][j]);
           }
           System.out.println("");
       }
   }

   public static void printArray(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]);
           System.out.print(" ");
       }
       System.out.println("");
   }

   public static void getMovement(int[][] city) {

       int[] startingLine = getColumn(0, city);

       int columnsNum = city[0].length;
       int rowsNum = city.length;
       int[] startingLineClone = Arrays.copyOf(startingLine, startingLine.length);
       Arrays.sort(startingLineClone);
       int startingCost = startingLineClone[0];
       int startingRow = 0;
       int currentRow;

       for (int i = 0; i < startingLine.length; i++) {
           if (startingLine[i] == startingCost) {
               startingRow = i;
               break;
           }
       }
       System.out.println("Starting Row: " + startingCost + ", Starting Index: " + startingRow);

       currentRow = startingRow;
       int currentColumn = 0;
       int north, south, east, min;
       
       while (currentColumn < columnsNum -1) {
           east = city[currentColumn + 1][currentRow];
           System.out.println("East = "+ east);

           if (currentRow < rowsNum) {
               south = city[currentColumn][currentRow + 1];
           } else {
               south = -1;
           }

           if (currentRow > 0) {
               north = city[currentColumn][currentRow - 1];
           } else {
               north = -1;
           }

           min = east;
           if (min < north && north != -1) {
               min = north;
           }
           if (min < south && south != -1) {
               min = south;
           }

           if (min == east) {
               currentColumn++;
           } else if (min == south) {
               System.out.println("Min is south");
               currentRow++;
           } else if (min == north) {
               currentRow--;
           }
           System.out.println("Column: " + currentColumn + ", Row: " + currentRow);
           System.out.println("Cost: " + city[currentColumn][currentRow]);
       }
   }

   public static int[] getColumn(int index, int[][] arr) {
       int[] column = new int[arr.length];
       for (int i = 0; i < arr.length; i++) {
           column[i] = arr[i][0];
       }
       return column;
   }

}