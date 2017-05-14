package com.smartsparrow.codingproblems.waleedusman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class CsvParsing {
    public List<String> parse(final String input) {
        Scanner inputScanner = new Scanner(input).useDelimiter("");

        StringBuilder buffer = new StringBuilder();
        boolean stringCaptureStarted = false;
        List<String> result = new ArrayList<>();

        while(inputScanner.hasNext()) {
            String nextElement = inputScanner.next();
            if (nextElement.equals(",") && !stringCaptureStarted) {
                result.add(parseString(buffer.toString()));
                buffer.setLength(0);
                continue;
            }
            if (nextElement.equals("\"")) {
                stringCaptureStarted = !stringCaptureStarted;
            }
            buffer.append(nextElement);
        }
        result.add(parseString(buffer.toString()));

        return result;
    }

    private String parseString(final String str) {
        try {
            return String.valueOf(Integer.parseInt(str));
        } catch (Exception ex) {
            if (str.startsWith("\"") && str.endsWith("\"")) {
                return str;
            }
            throw new IllegalArgumentException(
                    format("Value between commas must be; integer or string that start/end"
                            + " with double-quote. [%s] does not meet this criteria", str));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter comma-separated values here: ");
        String input = new Scanner(System.in).nextLine();

        new CsvParsing().parse(input)
                .stream()
                .forEachOrdered(System.out::println);
    }
}
