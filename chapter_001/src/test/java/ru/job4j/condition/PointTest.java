package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenFirstZeroZeroSecondThreeFourThenFive() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 12);
        double result = a.distanceTo(b);
        double expected = 13D;
        assertThat(result, is(expected));
    }
}
