package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UnionTest {
    @Test
    public void whenTwoBecomeOne() {
        Union array = new Union();
        int[] input1 = {1, 2, 6, 8};
        int[] input2 = {3, 5, 7, 9};
        int[] result = array.union(input1, input2);
        int[] expect = {1, 2, 3, 5, 6, 7, 8, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoBecomeNewOne() {
        Union array = new Union();
        int[] input1 = {1, 2, 6, 8, 11, 13, 16};
        int[] input2 = {3, 5, 7, 9, 12, 15, 18, 20, 22};
        int[] result = array.union(input1, input2);
        int[] expect = {1, 2, 3, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16, 18, 20, 22};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoBecomeUniOne() {
        Union array = new Union();
        int[] input1 = {1, 2, 6, 8, 11, 13, 16};
        int[] input2 = {3, 5, 7, 9, 12, 15};
        int[] result = array.union(input1, input2);
        int[] expect = {1, 2, 3, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16};
        assertThat(result, is(expect));
    }

}