package com.computinglaboratory;

import java.util.Comparator;

/**
 * AlphanumericComparator class.
 */
public class AlphanumericComparator implements Comparator<String> {
    @Override
    public int compare(String string1, String string2) {

        // If any of the strings is null throw the exception
        if (string1 == null || string2 == null) {
           throw new NullPointerException("At least one of the strings in comparator is null");
        }

        // Iterating thru the strings extracting and comparing substrings that are digits or non-digits
        int index1 = 0;
        int index2 = 0;
        while (index1 < string1.length() && index2 < string2.length()) {

            // Get substrings of strings at given begin index
            String substring1 = getSubstring(string1, index1);
            String substring2 = getSubstring(string2, index2);
            index1 += substring1.length();
            index2 += substring2.length();

            // Stores a result of comparison
            int result;

            // If both substrings are digits convert to integer and compare, otherwise compare strings
            if (Character.isDigit(substring1.charAt(0)) && Character.isDigit(substring2.charAt(0))) {
                int number1 = Integer.parseInt(substring1);
                int number2 = Integer.parseInt(substring2);
                result = number1 - number2;

            } else {
                result = substring1.compareTo(substring2);
            }

            if (result != 0) return result;
        }

        return string1.compareTo(string2);
    }

    /**
     * Extracts substring that starts in given index and ends when next character is of different
     * type than character in begin position. Types are digit and non-digit.
     * @param string input string
     * @param beginIndex substring begin index
     * @return substring
     */
    private static String getSubstring(String string, int beginIndex) {

        int index = beginIndex;

        // Get character from given position
        char ch = string.charAt(index);

        // Check if the character is digit
        if (Character.isDigit(ch)) {
            // If it is digit, grab all next characters that are components of number
            index++;
            while (index < string.length()) {
                if (!Character.isDigit(string.charAt(index))) break;
                index++;
            }
        } else {
            // If it is NOT digit, grab all next characters that are not digits
            index++;
            while (index < string.length()) {
                if (Character.isDigit(string.charAt(index))) break;
                index++;
            }
        }

        return string.substring(beginIndex, index);
    }
}
