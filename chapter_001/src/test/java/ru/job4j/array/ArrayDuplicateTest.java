package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "5", "2", "1"};
        String[] expected = {"1", "2", "5"};
        String[] result = duplicate.remove(input);
        assertThat(result, is(expected));
    }
    @Test
    public void whenRemoveFiveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"3", "1", "2", "5", "2", "1", "3", "4", "5", "3"};
        String[] expected = {"3", "1", "2", "5", "4"};
        String[] result = duplicate.remove(input);
        assertThat(result, is(expected));
    }
}