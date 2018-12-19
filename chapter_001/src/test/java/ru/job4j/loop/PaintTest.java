package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {
    @Test
    public void when3() {
        Paint pir = new Paint();
        String rsl = pir.piramid(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("  ^%s ^^^%s^^^^^%s", ln, ln, ln)));
    }
    @Test
    public void when5() {
        Paint pir = new Paint();
        String rsl = pir.piramid(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("    ^%s   ^^^%s  ^^^^^%s ^^^^^^^%s^^^^^^^^^%s", ln, ln, ln, ln, ln)));
    }
    @Test
    public void whenR3() {
        Paint pir = new Paint();
        String rsl = pir.rightTrl(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("^%s^^%s^^^%s", ln, ln, ln)));
    }
    @Test
    public void whenR5() {
        Paint pir = new Paint();
        String rsl = pir.rightTrl(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("^%s^^%s^^^%s^^^^%s^^^^^%s", ln, ln, ln, ln, ln)));
    }
    @Test
    public void whenL3() {
        Paint pir = new Paint();
        String rsl = pir.leftTrl(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("  ^%s ^^%s^^^%s", ln, ln, ln)));
    }
    @Test
    public void whenL5() {
        Paint pir = new Paint();
        String rsl = pir.leftTrl(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("    ^%s   ^^%s  ^^^%s ^^^^%s^^^^^%s", ln, ln, ln, ln, ln)));
    }
}