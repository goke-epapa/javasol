
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epapa
 */
public class SmallFactorial {
    
    public static void main(String[] args) throws IOException{
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(bInputStream.readLine());
        
        for(int i = 0; i < inputNum; i++){
            System.out.println(factorial(Integer.parseInt(bInputStream.readLine())));
        }
        System.exit(0);
    }
    
    public static int factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        int factorial = 1;
        while(n > 1){
            factorial *= n;
            n--;
        }
        return factorial;
    }
    
}
