package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertListTest {
    @Test
    public void whenConvertListOfArraysToIntegerList() {
    ConvertList convertList = new ConvertList();
    List<int[]> list = new ArrayList<>();
    list.add(new int[] {1, 2});
    list.add(new int[] {3, 4, 5, 6});
    List<Integer> result = convertList.convert(list);
    List<Integer> expected = new ArrayList<>();
    expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertThat(result, is(expected));
}
    @Test
    public void whenConvertListOf3ArraysToIntegerList() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 2});
        list.add(new int[] {3, 4, 5, 6});
        list.add(new int[] {7, 9, 1, 0});
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 1, 0));
        assertThat(result, is(expected));
    }
}