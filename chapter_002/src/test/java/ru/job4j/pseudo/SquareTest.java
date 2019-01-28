package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String expected = new StringBuilder()
                .append("+++++\n")
                .append("+   +\n")
                .append("+   +\n")
                .append("+++++")
                .toString();
        assertThat(square.draw(), is(expected));
    }
}
