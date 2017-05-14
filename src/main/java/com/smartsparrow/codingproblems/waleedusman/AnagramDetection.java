package com.smartsparrow.codingproblems.waleedusman;

import com.google.common.base.CharMatcher;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ASSUMPTION: input string contains ASCII characters only
 */
public class AnagramDetection {
    private static final int NUM_ASCII_CHARACTERS = 256;

    public int findOccurrences(String parentString, String queryString) {
        if ((parentString == null) || (queryString == null) || queryString.length() > parentString.length()) {
            return 0;
        }

        // store count of all characters in query-string
        // store count of all characters at beginning of parent-string (equal to length of query-string)
        int[] queryCharacterCount = new int[NUM_ASCII_CHARACTERS];
        int[] slidingWindowCharacterCount = new int[NUM_ASCII_CHARACTERS];
        for (int i = 0; i < queryString.length(); i++) {
            queryCharacterCount[(int) queryString.charAt(i)]++;
            slidingWindowCharacterCount[(int) parentString.charAt(i)]++;
        }

        int result = 0;
        Scanner inputScanner = new Scanner(parentString).useDelimiter("");
        for(int i = queryString.length(); i < parentString.length(); i++ ) {
            if (Arrays.equals(queryCharacterCount, slidingWindowCharacterCount)) {
                result++;
            }

            // update window
            slidingWindowCharacterCount[(int) parentString.charAt(i)]++;
            slidingWindowCharacterCount[(int) parentString.charAt(i - queryString.length())]--;
        }

        // check for last window
        if (Arrays.equals(queryCharacterCount, slidingWindowCharacterCount)) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter parent string (ASCII characters only): ");
        String parentString = new Scanner(System.in).nextLine();
        System.out.println("Enter query string (ASCII characters only). Length should be less than parent string: ");
        String queryString = new Scanner(System.in).nextLine();

        System.out.println(new AnagramDetection().findOccurrences(parentString, queryString));
    }
}
