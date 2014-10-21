
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Team caesium
 */
public class Kabloom {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        int numCards = Integer.parseInt(bInputStream.readLine().trim());
        ArrayList<String> row1 = null, row2 = null;
        String[] line1 = bInputStream.readLine().trim().split(" ");
        String[] line2 = bInputStream.readLine().trim().split(" ");
        row1 = new ArrayList<String>(Arrays.asList(line1));
        row2 = new ArrayList<String>(Arrays.asList(line2));
        
        for(String top : row1){
            for (String bottom : row2){
                if(!top.equals(bottom)){
                    System.out.println("");
                }
            }
        }
        System.exit(0);
    }

}
