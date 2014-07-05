
//import static Factorial.factorial;
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
public class Holes {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < inputNum; i++){
            String input = br.readLine();
            System.out.println(getHoles(input));
        }
        br.close();
        System.exit(0);
    }

    public static int getHoles(String string) {

        String oneHole = "ADOPQR";
        String twoHoles = "B";
        int len = string.length() - 1;
        int res = 0;
        for (int i = len; i >= 0; i--) {
            char c = string.charAt(i);

            if (oneHole.indexOf(c + "") != -1) {
                res++;
            }

            if (twoHoles.indexOf(c + "") != -1) {
                res += 2;
            }
        }
        return res;
    }

}
