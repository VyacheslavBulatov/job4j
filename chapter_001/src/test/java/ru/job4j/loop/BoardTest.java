package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("X X%s X %sX X%s", ln, ln, ln)));
    }
    @Test
    public void when5x10() {
        Board board = new Board();
        String rsl = board.paint(5, 10);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("X X X%s X X %sX X X%s X X %sX X X%s X X %sX X X%s X X %sX X X%s X X %s", ln, ln, ln, ln, ln, ln, ln, ln, ln, ln)));
    }
}