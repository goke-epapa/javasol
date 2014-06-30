
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adegoke
 */
public class Atm {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        int amount = Integer.parseInt(arr[0]);
        double accountBalance = Double.valueOf(arr[1]);
        
        if(amount % 5 == 0 && accountBalance - 0.5 > amount)
            System.out.println(accountBalance - 0.5 - amount);
        else
            System.out.println(accountBalance);
    }
    
}
