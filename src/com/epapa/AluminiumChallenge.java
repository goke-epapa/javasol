/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epapa;

/**
 *
 * @author adegoke
 */
public class AluminiumChallenge {

    public static void main(String[] args) {
        System.out.println(new AluminiumChallenge().solution2(new int[]{2, 2, 1, 0, 1}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                // Swap
                int[] B = A;
                int temp = B[j];
                B[j] = B[i];
                B[i] = temp;

                int seqSum = 0;
                for (int k = i; k < B.length; k++) {
                    seqSum += B[k];
                    if (seqSum > maxSum) {
                        maxSum = seqSum;
                    }
                }
            }
        }
        return maxSum;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int B[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if(i > 0){
                    break;
                }
                B[A[j]]++; 
                System.out.println(i + " " + j);
            }
        }
        
        for(int i = 0; i < B.length; i++){
            System.out.println("Elem: " + i + " " + B[i]);
        }
        return result;
    }
}
