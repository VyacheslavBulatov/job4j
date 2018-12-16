package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    @Test
    public void whenFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFrom50To55Then156() {
        Counter count = new Counter();
        int result = count.add(50, 55);
        int expected = 156;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFrom5To20Then104() {
        Counter count = new Counter();
        int result = count.add(5, 20);
        int expected = 104;
        assertThat(result, is(expected));
    }
}
