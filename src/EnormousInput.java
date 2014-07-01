
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
public class EnormousInput {
    static long number, counter;
    public static void main(String[] args) {
        try {
            //        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        String line = scanner.nextLine();
//        String[] arr = line.split(" ");
//        long count = Integer.parseInt(arr[0]);
//        long divisor = Integer.valueOf(arr[1]);
//        
//        for(long i = 0; i < count; i++){
//            number = Long.parseLong(scanner.nextLine());
//            if(number % divisor == 0)
//                counter++;
//        }
//        System.out.println(counter);
            
            BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
            String line = bInputStream.readLine().trim();
            String[] arr = line.split(" ");
            long count = Integer.parseInt(arr[0]);
            long divisor = Integer.valueOf(arr[1]);
            
            for(long i = 0; i < count; i++){
                number = Long.parseLong(bInputStream.readLine().trim());
                if(number % divisor == 0)
                    counter++;
            }
            System.out.println(counter);
        } catch (IOException ex) {
//            Logger.getLogger(EnormousInput.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
