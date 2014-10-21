
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * IEEEXtreme 8.0
 * @author caes1um
 */
public class Nekops_NuSequences {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        String[] arr = line.split(" ");
        int numberOfSeq = Integer.parseInt(arr[0]);

        int numberOfElems = arr.length - 1;
        Integer[] fSeq = new Integer[numberOfElems];

        for (int i = 0; i < numberOfElems; i++) {
            fSeq[i] = Integer.parseInt(arr[i + 1]);
        }
        process(numberOfSeq, fSeq);
    }

    public static void process(int numberOfSeq, Integer[] seq) {
        ArrayList<Integer[]> sequences = new ArrayList<Integer[]>();
        int maxSequence = seq.length;
        sequences.add(seq);
        for (int i = 0; i < numberOfSeq; i++) {
            ArrayList<Integer> listSeq = getNuSequence(seq);
            seq = listSeq.toArray(new Integer[0]);
            if(seq.length > maxSequence){
                maxSequence = seq.length;
            }
            sequences.add(seq);
        }
        output(sequences, maxSequence);
    }

    public static HashMap getHistogram(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int value = hashMap.get(new Integer(arr[i])) == null ? 1 : hashMap.get(new Integer(arr[i])) + 1;
            hashMap.put(arr[i], value);
        }
        return hashMap;
    }

    public static ArrayList<Integer> getNuSequence(Integer[] A) {
        int startIndex = 0;
        int count = 1;
        int curElem = A[startIndex];

        ArrayList<Integer> newSeq = new ArrayList<Integer>();

        while (startIndex < A.length) {
            startIndex++;

            if (startIndex >= A.length) {
                newSeq.add(count);
                newSeq.add(curElem);
                break;
            }

            int prevElem = curElem;
            curElem = A[startIndex];

            if (curElem == prevElem) {
                count++;
            } else {
                newSeq.add(count);
                newSeq.add(prevElem);
                count = 1;
            }
        }

        return newSeq;
    }

    public static void output(ArrayList<Integer[]> sequences, int maxLength) {
        for(Integer[] seq : sequences){
            printArray(seq, maxLength);
        }
        System.out.println(sequences.get(sequences.size() - 1).length);
    }
    
    public static int getNumberOfChars(int len){
        return (len * 2) - 1;  
    }
    
    public static int getNumberOfChars(Integer[] longSeq){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < longSeq.length; i++){
            sb.append(longSeq[i]);
            if(i != longSeq.length - 1)
                sb.append(" ");
        }
        return sb.length();  
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
    
    public static void printArray(Integer[] arr, int maxLen) {
        int maxChars = getNumberOfChars(maxLen);
        int noOfStars = maxLen - arr.length;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < noOfStars; i++){
            sb.append(".");
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i != arr.length - 1)
                sb.append(" ");
        }
        int usedChars = sb.length();
        for(int i = usedChars; i < maxChars; i++){
            sb.append(".");
        }
        System.out.println(sb.toString());
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
