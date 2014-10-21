
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author team caesium
 */
public class GrandIntegerLottery {

    static ArrayList<String> numbers = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        String[] arr = line.split(" ");

        int S = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        int P = Integer.parseInt(arr[2]);
        int N = Integer.parseInt(arr[3]);

        String[] lotteryNos = new String[N];
        int minNoLen = 0;

        // Read Lottery Numbers
        for (int i = 0; i < N; i++) {
            lotteryNos[i] = bInputStream.readLine().trim();
        }

        // Generate [S, E]
        int count = 0;
        for (int i = S; i < E; i++) {
            if (addNumber(lotteryNos, i)) {
                count++;
                if (count == P) {
                    System.out.println(i);
                    break;
                }
            }
        }
        
        if (count < P) {
            System.out.println("DOES NOT EXIST");
            System.exit(0);
        }
        System.exit(0);
    }

    public static boolean isValid(int num, String lottNum) {
        return String.valueOf(num).contains(lottNum);
    }

    public static boolean addNumber(String[] lotteryNos, int num) {
        for (int j = 0; j < lotteryNos.length; j++) {
            if (String.valueOf(num).contains(lotteryNos[j])) {
                numbers.add(String.valueOf(num));
                return true;
            }
        }
        return false;
    }
}
