package com.epapa.hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by epapa on 25/10/2015.
 */
public class Arrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        String[] elements = new String[inputNum];

        String line = br.readLine();

        elements = line.split(" ");

        for(int i = elements.length - 1; i >= 0; i--) {
            System.out.print(elements[i]);

            if(i != 0) {
                System.out.print(" ");
            }
        }
    }


}
