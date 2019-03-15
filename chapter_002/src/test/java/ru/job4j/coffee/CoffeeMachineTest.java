package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMachineTest {
    @Test
    public void whenMachineGiveChange() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {100, 100, 100, 100});
        int[] rst = machine.change(50, 35);
        int[] expected = {10, 5};
        assertThat(rst, is(expected));
    }
    @Test
    public void whenMachineGiveChangeWithoutTen() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {0, 2, 3, 5});
        int[] rst = machine.change(50, 35);
        int[] expected = {5, 5, 2, 2, 1};
        assertThat(rst, is(expected));
    }
    @Test(expected = IncorrectValueException.class)
    public void whenMachineCannotGiveChange() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {0, 2, 3, 5});
        machine.change(50, 15);
    }
    @Test(expected = IncorrectValueException.class)
    public void whenMachineGetIncorrectValue() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {0, 2, 3, 5});
        machine.change(60, 15);
    }
    @Test(expected = IncorrectValueException.class)
    public void whenPriceMoreThanValue() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {0, 2, 3, 5});
        machine.change(50, 75);
    }

}