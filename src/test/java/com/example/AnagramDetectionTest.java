package com.example;

import com.example.AnagramDetection;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AnagramDetectionTest {
    @Test
    public void shouldFindAllOccurrencesInSampleInputOne() {
        String parentStringOne = "AdnBndAndBdaBn";
        String queryStringOne = "dAn";
        assertThat(new AnagramDetection().findOccurrences(parentStringOne, queryStringOne),
                is(equalTo(4)));
    }

    @Test
    public void shouldFindAllOccurrencesInSampleInputTwo() {
        String parentStringOne = "AbrAcadAbRa";
        String queryStringOne = "cAda";
        assertThat(new AnagramDetection().findOccurrences(parentStringOne, queryStringOne),
                is(equalTo(2)));
    }
}
