/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author epapa
 */
public class Gems {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int number = Integer.parseInt(scanner.nextLine());
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            ArrayList checked = new ArrayList();
            for (int j = 0; j < line.length(); j++) {
                Character c = line.charAt(j);
                if (!checked.contains(c)) {
                    int value = map.containsKey(c) ? map.get(c) + 1 : 1;
                    //System.out.println(c);
                    map.put(c, value);
                    checked.add(c);
                }
            }
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character character = entry.getKey();
            Integer integer = entry.getValue();
            if(integer == number){
                result++;
            }
        }
//        3
//abcdde
//baccd
//eeabg
//5
        
        /*
        3
abddddddddddddddddddddddde
abcs
aas
2
        */
        System.out.println(result);
        System.exit(0);
    }

}
