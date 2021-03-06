package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(Arrays.asList("invalid", "1")));
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста введите корректное значение пункта меню%n")
                )
        );
    }
    @Test
    public void whenIncorrectInput() {
        ValidateInput input = new ValidateInput(new StubInput(Arrays.asList("90", "1")));
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста введите значение пункта меню из указанного диапазона%n")
                )
        );
    }
}