package org.logic;

import java.util.HashMap;
import java.util.Map;

public class Service {
    public static int getArabs(String romans) {
        char[] charRomans = romans.toCharArray();
        Map<Character, Integer> mappedValues = new HashMap<>();
        mappedValues.put('I', 1);
        mappedValues.put('V', 5);
        mappedValues.put('X', 10);
        mappedValues.put('L', 50);
        mappedValues.put('C', 100);
        mappedValues.put('D', 500);
        mappedValues.put('M', 1000);

        int arabNumber = 0;
        for (int i = 0; i < charRomans.length; i++) {
            try {
                if (mappedValues.get(charRomans[i]) >= mappedValues.get(charRomans[i + 1])) {
                    arabNumber = arabNumber + mappedValues.get(charRomans[i]);
                } else {
                    arabNumber = arabNumber + mappedValues.get(charRomans[i + 1]) - mappedValues.get(charRomans[i]);
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                arabNumber = arabNumber + mappedValues.get(charRomans[i]);
            }


        }
        return arabNumber;
    }
}
