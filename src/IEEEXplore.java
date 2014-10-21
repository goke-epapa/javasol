
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author epapa
 */
public class IEEEXplore {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        byte[] bytes = line.getBytes();
        int len = 16;
        for (int index = 0; index < bytes.length; index += 16) {
            printHex(bytes, index, len);
            printAscii(bytes, index, len);
        }
    }

    private static byte[] read(String inputFileName, int start, int end)
            throws FileNotFoundException, IOException {
        File theFile = new File(inputFileName);
        FileInputStream input = new FileInputStream(theFile);
        int skipped = 0;
        while (skipped < start) {
            skipped += input.skip(start - skipped);
        }
        int length = (int) (Math.min(end, theFile.length()) - start);
        byte[] bytes = new byte[length];
        int bytesRead = 0;
        while (bytesRead < bytes.length) {
            bytesRead = input.read(bytes, bytesRead, bytes.length - bytesRead);
            if (bytesRead == -1) {
                break;
            }
        }
        return bytes;
    }

    private static void printHex(byte[] bytes, int offset, int width) {
        for (int index = 0; index < width; index++) {
            if (index + offset < bytes.length) {
                System.out.printf("%02x ", bytes[index + offset]);
            } else {
                System.out.print("	");
            }
        }
    }

    private static void printAscii(byte[] bytes, int index, int width)
            throws UnsupportedEncodingException {
        if (index < bytes.length) {
            width = Math.min(width, bytes.length - index);
            System.out.println(
                    ":"
                    + new String(bytes, index, width, "UTF-8").replaceAll("\r\n", " ").replaceAll(
                            "\n",
                            " "));
        } else {
            System.out.println();
        }
    }

}
