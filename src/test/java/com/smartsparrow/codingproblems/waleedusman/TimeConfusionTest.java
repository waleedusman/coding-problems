package com.smartsparrow.codingproblems.waleedusman;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class TimeConfusionTest {
    @Test
    public void shouldProcessSampleInputOne() {
        List<String> expectedOutput = Arrays.asList("The correct time is 5:00.", "The correct time is 12:30.", "Look at the sun.");
        List<String> result = new TimeConfusion().run(3, Arrays.asList("5:00 12:00 10:00", "11:59 12:30 1:01", "12:00 4:00 8:00"));
        assertThat(result, contains(expectedOutput.toArray()));
    }
}
