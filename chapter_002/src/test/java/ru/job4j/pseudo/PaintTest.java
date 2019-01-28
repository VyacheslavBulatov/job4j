package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PaintTest {
    /**
     * поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquareThenGetSquare() {
        new Paint().draw(new Square());
        String expected = new StringBuilder()
                .append("+++++\n")
                .append("+   +\n")
                .append("+   +\n")
                .append("+++++")
                .append(System.lineSeparator())
                .toString();
        assertThat(new String(out.toByteArray()), is(expected));
    }
    @Test
    public void whenDrawTriangleThenGetTriangle() {
        new Paint().draw(new Triangle());
        String expected = new StringBuilder()
                .append("   ^ \n ")
                .append(" / \\\n ")
                .append("/___\\")
                .append(System.lineSeparator())
                .toString();
        assertThat(new String(out.toByteArray()), is(expected));
    }
}