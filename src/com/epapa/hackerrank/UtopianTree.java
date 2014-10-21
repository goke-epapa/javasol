/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epapa.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author adegoke
 */
public class UtopianTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bInputStream.readLine());

        int treeHeight = 1;
        int curCycle = 0;
        for (int i = 0; i < numTestCases; i++) {
            // Get number of cycles
            int numCycles = Integer.parseInt(bInputStream.readLine());
            if (numCycles == 0) {
                System.out.println(treeHeight);
                continue;
            }

            int steps = numCycles  - curCycle;
            
            if(steps < 0){
                steps = numCycles;
                treeHeight = 1;
                curCycle = 0;
            }
            while (steps > 0) {
                curCycle++;
                treeHeight += curCycle % 2 == 0 ? 1 : treeHeight;
                steps--;
            }

            System.out.println(treeHeight);
        }

        System.exit(0);
    }

}
