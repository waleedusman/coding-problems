package com.example;

import com.example.CsvParsing;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CsvParsingTest {
    @Test
    public void shouldParseInputOne() {
        String inputOne = "2,6,3,2,5";
        List<String> expectedResult = Arrays.asList("2", "6", "3", "2", "5");
//        assertThat(new CsvParsing().parse(inputOne), contains(expectedResult));
        new CsvParsing().parse(inputOne)
                .stream()
                .forEachOrdered(System.out::println);
    }

    @Test
    public void shouldParseInputTwo() {
        String inputTwo = "\"pears\",\"apples\",\"walnuts\",\"grapes\",\"cheese,cake\"";
        new CsvParsing().parse(inputTwo)
                .stream()
                .forEachOrdered(System.out::println);
    }

    @Test
    public void shouldParseInputThree() {
        String inputThree = "1,\"Que?\",\"Kay?\",2,\"Si.\",\"Sea? Kay, sea?\",\"No, no, no. Que..."
                + "‘what’.\",234,\"Kay Watt?\",\"Si, que ‘what’.\",\"C.K."
                + "Watt?\",3,\"Yes!\",\"comma,comma, comma , :)\"";
        new CsvParsing().parse(inputThree)
                .stream()
                .forEachOrdered(System.out::println);
    }
}
