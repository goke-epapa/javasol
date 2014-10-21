
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * K Value XTREME 8.0
 *
 * @author caes1um
 */
public class KValue {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        String[] arr = line.split(" ");

        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int K = Integer.parseInt(arr[2]);
        
        String inputLine = bInputStream.readLine().trim();
        String[] iArr = inputLine.split(" ");

        int kValue = getMinKValue(iArr, M, N, K);

        System.out.println(kValue);
        System.exit(0);
    }

    public static int getMinKValue(String[] numbers, int M, int N, int K) {
        int len = N;
        int[] subSequence = new int[M];
        int startIndex = 0;
        int count, kValue, valuePoint, minKValue = Integer.MAX_VALUE;

        while (startIndex < len) {
            count = 0;
            while (count < M) {
                valuePoint = count + startIndex;
                if (valuePoint >= len) {
                    valuePoint = valuePoint % len;
                }
                subSequence[count] = Integer.parseInt(numbers[valuePoint]);
                count++;
                if (count == M) {
                    startIndex++;
                    Arrays.sort(subSequence);
                }
            }
            kValue = subSequence[K - 1];
            if (kValue < minKValue) {
                minKValue = kValue;
            }
        }

        return minKValue;
    }

    public static void printList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
