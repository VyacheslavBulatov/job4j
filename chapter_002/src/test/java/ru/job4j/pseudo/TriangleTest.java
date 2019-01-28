package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triag = new Triangle();
        String expected = new StringBuilder()
                .append("   ^ \n ")
                .append(" / \\\n ")
                .append("/___\\")
                .toString();
        assertThat(triag.draw(), is(expected));
    }
}