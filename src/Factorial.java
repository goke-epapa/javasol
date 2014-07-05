
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
 * @author adegoke
 */
public class Factorial {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < inputNum; i++){
            int input = Integer.parseInt(br.readLine());
            long factorial = factorial(input);
            int trailingZeros = 0;
            while(factorial % 10 == 0){
                trailingZeros++;
                factorial /= 10;
            }
            System.out.println(trailingZeros);
        }
        br.close();
        System.exit(0);
    }
    
    public static long factorial(long n){
        if(n == 0 || n == 1)
            return 1;
        long count = n;
        long factorial = 1;
        while(count != 1){
            factorial *= count;
            count--;
        }
        return factorial;
    }
    
}
