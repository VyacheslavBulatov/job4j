package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenFirstMoreSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 3);
        assertThat(result, is(5));
    }
    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(5, 3, 4);
        assertThat(result, is(5));
    }
    @Test
    public void whenSecondMoreFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(5, 15, 2);
        assertThat(result, is(15));
    }
    @Test
    public void whenThirdMoreSecondAndFirst() {
        Max maxim = new Max();
        int result = maxim.max(10, 12, 14);
        assertThat(result, is(14));
    }
}
