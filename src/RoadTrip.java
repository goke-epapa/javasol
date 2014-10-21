
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author team ca3sium
 */
public class RoadTrip {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        int noOfTests = Integer.parseInt(line);

        for (int i = 0; i < noOfTests; i++) {

            line = bInputStream.readLine().trim();
            String[] arr = line.split(" ");

            int N_numberOfGasStations = Integer.parseInt(arr[0]);
            int F_unitsOfFuel = Integer.parseInt(arr[1]);
            int T_beginFuel = Integer.parseInt(arr[2]);
            int L_pathLength = Integer.parseInt(arr[3]);
            int stations[][] = new int[N_numberOfGasStations][2];
            for (int j = 0; j < N_numberOfGasStations; j++) {
                line = bInputStream.readLine().trim();
                arr = line.split(" ");
                stations[j][0] = Integer.parseInt(arr[0]);
                stations[j][1] = Integer.parseInt(arr[1]);
            }

            process(F_unitsOfFuel, T_beginFuel, L_pathLength, stations);
        }
    }

    public static void process(int maxFuel, int beginFuel, int pathLength, int[][] stations) {
        int numberOfstations = stations.length;

        System.out.println(getCheapFuelStation(stations));
        for (int i = 0; i < numberOfstations; i++) {
            
        }
//        System.out.println("-1");
    }

    public static int getFuelPrice(int[] A) {
        return A[1];
    }

    public static int getCheapFuelStation(int[][] A) {
        int cost = Integer.MIN_VALUE, station = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = getFuelPrice(A[i]);
            if (cost > temp) {
                cost = temp;
                station = i;
            }
        }
        return station;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

}
