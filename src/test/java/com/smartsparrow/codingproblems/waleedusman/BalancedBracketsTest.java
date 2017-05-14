package com.smartsparrow.codingproblems.waleedusman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BalancedBracketsTest {
    @Test
    public void shouldBalanceWhenEmptyString() {
        assertThat(new BalancedBrackets().balance(""), is(true));
    }

    @Test
    public void shouldBalanceSampleInputOne() {
        String sampleInputOne = "()[]{}(([])){[()][]}";
        assertThat(new BalancedBrackets().balance(sampleInputOne), is(true));
    }

    @Test
    public void shouldNotBalanceSampleInputTwo() {
        String sampleInputTwo = "())[]{}";
        assertThat(new BalancedBrackets().balance(sampleInputTwo), is(false));
    }

    @Test
    public void shouldNotBalanceSampleInputThree() {
        String sampleInputThree = "[(])";
        assertThat(new BalancedBrackets().balance(sampleInputThree), is(false));
    }

}
