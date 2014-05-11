/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epapa;

/**
 * Main Class
 *
 * @author Adegoke Obasa
 */
public class Main {

    // Array of small numbers
    private static String[] smallNumbers = new String[]{
        "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
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
        int number = 1000;
        System.out.println(Main.projectEulerNumber17(number));
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
        
        for(int i = 0; i < groupText.length; i++){
            groupText[i] = Main.threeDigitsGroupToWords(digitGroups[i]);
        }
        
        // Recombine the three digits groups
        String combined = groupText[0];
        boolean appendAnd;
        
        // Determine whether an 'and' is needed
        appendAnd = (digitGroups[0] > 0) && (digitGroups[0] < 100);
        
        // Process the remaining groups in turn, smallest to largest
        for(int i = 1; i < groupText.length; i++){
            
            if(digitGroups[i] != 0){
                // Only add non-zero items
            String prefix = groupText[i] + " " + scale[i];
            
            if(combined.length() != 0){
                prefix += appendAnd ? " and " : ", ";
            }
            
            // Opportunity to add 'and' is ended
            appendAnd = false;
            
            // And the three-digit group to the combined string
            combined = prefix + combined;
            }
        }
        
        // Negative Rule
        if(number < 0){
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
            
            if(tensUnit != 0){
                groupText += " and ";
            }
        }
        
        // Determine the tens and units
        int tens = tensUnit / 10;
        int units = tensUnit % 10;
        
        // Ten Rule
        if(tens >= 2){
            groupText += _tens[tens];
            
            if(units != 0){
                groupText += " " + smallNumbers[units];
            }
        }
        
        else if(tensUnit != 0){
            groupText += smallNumbers[tensUnit];
        }

        return groupText;
    }
    
    public static long projectEulerNumber17(int number){
        long result = 0;
        
        for(int i = 1; i <= number; i++){
            result += Main.numberToWords(i).replace(",", "")
                    .replace(" ", "")
                    .replace("-", "").length();
        }
        return result;
    }
}
