/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epapa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Main Class
 *
 * @author Adegoke Obasa
 */
public class Main {

    // Array of small numbers
    private static String[] smallNumbers = new String[]{
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen"
    };
    // Array of tens
    private static String[] _tens = new String[]{
        "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
        "eighty", "ninty"
    };
    // Array of possible scale
    private static String[] scale = new String[]{
        "", "thousand", "million", "billion", "trillion", "quadrillion"
    };

    public static void main(String[] args) {
        long number = 1023546789l;
//        System.out.println(Main.projectEulerNumber17(number));
//        System.out.println(Main.isPandigital(number));
//        System.out.println(Main.projectEulerNumber43());
        System.out.println(Main.fibonacci());
//        System.out.println(String.valueOf(number).matches("^[0-9]{10}$"));
    }

    /**
     * Converts a Number to words
     *
     * @param number
     * @return
     */
    public static String numberToWords(int number) {
        // Zero Rule
        if (number == 0) {
            return smallNumbers[0];
        }

        // Array to hold four three digits group
        int[] digitGroups = new int[4];

        // Ensure the number is positive to extract from
        int positiveNumber = Math.abs(number);

        // Extract the three-digits group
        for (int i = 0; i < digitGroups.length; i++) {
            digitGroups[i] = positiveNumber % 1000;
            positiveNumber /= 1000;
        }

        // Convert each three-digit group to words
        String[] groupText = new String[4];

        for (int i = 0; i < groupText.length; i++) {
            groupText[i] = Main.threeDigitsGroupToWords(digitGroups[i]);
        }

        // Recombine the three digits groups
        String combined = groupText[0];
        boolean appendAnd;

        // Determine whether an 'and' is needed
        appendAnd = (digitGroups[0] > 0) && (digitGroups[0] < 100);

        // Process the remaining groups in turn, smallest to largest
        for (int i = 1; i < groupText.length; i++) {

            if (digitGroups[i] != 0) {
                // Only add non-zero items
                String prefix = groupText[i] + " " + scale[i];

                if (combined.length() != 0) {
                    prefix += appendAnd ? " and " : ", ";
                }

                // Opportunity to add 'and' is ended
                appendAnd = false;

                // And the three-digit group to the combined string
                combined = prefix + combined;
            }
        }

        // Negative Rule
        if (number < 0) {
            combined = "Negative " + combined;
        }

        return combined;
    }

    private static String threeDigitsGroupToWords(int threeDigits) {
        // Initialize return text
        String groupText = "";

        // Determine the hundreds and the remainder
        int hundred = threeDigits / 100;
        int tensUnit = threeDigits % 100;

        // Hundred Rule
        if (hundred != 0) {
            groupText += smallNumbers[hundred] + " hundred";

            if (tensUnit != 0) {
                groupText += " and ";
            }
        }

        // Determine the tens and units
        int tens = tensUnit / 10;
        int units = tensUnit % 10;

        // Ten Rule
        if (tens >= 2) {
            groupText += _tens[tens];

            if (units != 0) {
                groupText += " " + smallNumbers[units];
            }
        } else if (tensUnit != 0) {
            groupText += smallNumbers[tensUnit];
        }

        return groupText;
    }

    /**
     * Solution to Problem 17 on http://projecteuler.net
     *
     * @param number
     * @return
     */
    public static long projectEulerNumber17(int number) {
        long result = 0;

        for (int i = 1; i <= number; i++) {
            result += Main.numberToWords(i).replace(",", "")
                    .replace(" ", "")
                    .replace("-", "").length();
        }
        return result;
    }

    public static boolean isPandigital(long number) {
        String stringNum = String.valueOf(number);

        if (stringNum.length() < 10) {
            return false;
        }


        ArrayList<String> chars = new ArrayList<String>();
        int sum = 0;
        for (int i = 0; i < stringNum.length(); i++) {
            chars.add(stringNum.substring(i, i + 1));
            sum += Integer.parseInt(stringNum.substring(i, i + 1));
        }

        if (sum % 9 != 0) {
            return false;
        }


        Collections.sort(chars);

        StringBuffer sb = new StringBuffer();
        for (String s : chars) {
            sb.append(s);
        }

        return sb.toString().equalsIgnoreCase("0123456789");
    }

    public static boolean is1To9Pandigital(long number) {
        String stringNum = String.valueOf(number);

        if (stringNum.length() < 9) {
            return false;
        }


        ArrayList<String> chars = new ArrayList<String>();
        int sum = 0;
        for (int i = 0; i < stringNum.length(); i++) {
            chars.add(stringNum.substring(i, i + 1));
            sum += Integer.parseInt(stringNum.substring(i, i + 1));
        }

        if (sum % 9 != 0) {
            return false;
        }


        Collections.sort(chars);

        StringBuffer sb = new StringBuffer();
        for (String s : chars) {
            sb.append(s);
        }

        return sb.toString().equalsIgnoreCase("123456789");
    }

    public static long projectEulerNumber43() {
        long sum = 0;

        long startNum = 1406357289;
        long endNum = 1406357289;

        for (long i = startNum; i <= endNum; i++) {
            if (!isPandigital(i)) {
                continue;
            }

            long d1 = i / 1000000000l;
            long d2 = (i - (d1 * 1000000000l)) / 100000000l;
            long d3 = (i - (d2 * 100000000l)) / 10000000l;
            long d4 = (i - (d3 * 10000000l)) / 1000000l;
            System.out.println((d2 * 100000000l));
            long d5 = (i - (d4 * 1000000l)) / 100000l;
            long d6 = (i - (d5 * 100000l)) / 10000l;
            long d7 = (i - (d6 * 10000l)) / 1000l;
            long d8 = (i - (d7 * 1000l)) / 100;
            long d9 = (i - (d8 * 100l)) / 10;
            long d10 = (i - (d9 * 10l)) / 1;

            System.out.println(i);
            System.out.print(d1);
            System.out.print(d2);
            System.out.print(d3);
//            System.out.print(d4);
//            System.out.print(d5);
//            System.out.print(d6);
//            System.out.print(d7);
//            System.out.print(d8);
//            System.out.print(d9);
//            System.out.print(d10);
//            System.out.println("Me");


            if (Integer.parseInt(d2 + "" + d3 + "" + d4) % 2 != 0) {
                continue;
            }

            if (Integer.parseInt(d3 + "" + d4 + "" + d5) % 3 != 0) {
                continue;
            }

            if (Integer.parseInt(d4 + "" + d5 + "" + d6) % 5 != 0) {
                continue;
            }

            if (Integer.parseInt(d5 + "" + d6 + "" + d7) % 7 != 0) {
                continue;
            }

            if (Integer.parseInt(d6 + "" + d7 + "" + d8) % 11 != 0) {
                continue;
            }

            if (Integer.parseInt(d7 + "" + d8 + "" + d9) % 13 != 0) {
                continue;
            }

            if (Integer.parseInt(d8 + "" + d9 + "" + d10) % 17 != 0) {
                continue;
            }

            sum += i;
        }

        return sum;
    }

    public static BigInteger fibonacci() {
        BigInteger f1 = BigInteger.valueOf(1l);
        BigInteger f2 = BigInteger.valueOf(1l);
        BigInteger f = BigInteger.valueOf(1l);
        int count = 2;
        while (true) {
            f = f2.add(f1);
            f1 = f2;
            f2 = f;
            count++;
            String num = f.toString();
            if (num.length() > 9) {
                if (Main.is1To9Pandigital(Integer.parseInt(num.substring(num.length() - 9)))
                        && Main.is1To9Pandigital(Integer.parseInt(num.substring(0, 9)))) {
                    System.out.println(count);
                    break;
                }
            }
        }
        return f;
    }
}
