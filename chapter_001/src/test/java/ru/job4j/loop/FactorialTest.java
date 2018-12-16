package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial count = new Factorial();
        int result = count.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial count = new Factorial();
        int result = count.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}
