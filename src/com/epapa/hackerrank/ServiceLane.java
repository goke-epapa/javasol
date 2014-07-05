package com.epapa.hackerrank;


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
 * @author epapa
 */
public class ServiceLane {

    public static void main(String[] args) throws IOException {
//        int[] array = {2,3,1,3,2,3,2,3};
//        int[][] testCase = {{0,3},{1,3}};

        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine();
        String[] inputLens = line.split(" ");

        int arrLen = Integer.parseInt(inputLens[0]);
        int testCaseLen = Integer.parseInt(inputLens[1]);
        int[] array = new int[arrLen];
        int[][] testCases = new int[testCaseLen][2];

        String[] lineTwo = bInputStream.readLine().split(" ");
        for (int i = 0; i < arrLen; i++) {
            array[i] = Integer.parseInt(lineTwo[i]);
            if (i < testCaseLen) {
                String[] testCase = bInputStream.readLine().split(" ");
                testCases[i][0] = Integer.parseInt(testCase[0]);
                testCases[i][1] = Integer.parseInt(testCase[1]);
            }
        }

//        System.out.println(arrLen + " " + testCaseLen);
        getNumberOfVehicles(testCases.length, testCases, array);
    }

    static void getNumberOfVehicles(int numTestCases, int[][] testCase, int[] array) {
        for (int i = 0; i < numTestCases; i++) {
            int a = testCase[i][0];
            int b = testCase[i][1];
            int max = 3;
            for (int j = a; j <= b; j++) {

                if (array[j] < max) {
                    max = array[j];
                }
            }
            System.out.println(max);
        }
    }
}
