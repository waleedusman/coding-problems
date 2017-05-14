package com.example;

import com.example.Spiral;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class SpiralTest {
    @Test
    public void shouldReturnCorrectOutputForSampleInputOne() {
        String input = "5 5 3 3";
        List<Integer> expectedOutput = Arrays.asList(13, 8, 7, 12, 17, 18, 19, 14, 9, 4, 3, 2, 1, 6, 11, 16, 21, 22, 23, 24, 25, 20, 15, 10, 5);
        assertThat(new Spiral(input).run(), contains(expectedOutput.toArray()));
    }

    @Test
    public void shouldReturnCorrectOutputForSampleInputTwo() {
        String input = "2 4 1 2";
        List<Integer> expectedOutput = Arrays.asList(2, 1, 5, 6, 7, 3, 8, 4);
        assertThat(new Spiral(input).run(), contains(expectedOutput.toArray()));
    }
}
