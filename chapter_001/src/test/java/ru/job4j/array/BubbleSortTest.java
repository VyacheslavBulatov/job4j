package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithSevenElementsThenSortedArray() {
        BubbleSort seq = new BubbleSort();
        int[] result = seq.sort(new int[] {0, 1, 5, 3, 6, 2, 4});
        int[] expected = {0, 1, 2, 3, 4, 5, 6};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort seq = new BubbleSort();
        int[] result = seq.sort(new int[] {8, 1, 5, 3, 6, 2, 4, 9, 7, 0});
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expected));
    }
}