package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StartUITest {
    /**
     * поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker;

    @Before
    public void loadOutput() {
        this.tracker = new Tracker();
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    /**
     * Тест проверяющий пункт меню: 0. Add new Item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /**
     * Тест проверяющий пункт меню: 1. Show all items в случае, когда заявок нет
     */
    @Test
    public void whenGetAllItemsWithoutAdd() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String expected = "Заявок нет";
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
    /**
     * Тест проверяющий пункт меню: 1. Show all items в случае, когда заявки есть
     */
    @Test
    public void whenUserAddItemThenGetAllItems() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String expected = item.getId();
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
    /**
     *  Тест проверяющий пункт меню: 2. Edit item
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     *  Тест проверяющий пункт меню: 3. Delete item
     */
    @Test
    public void whenDeleteThenTrackerHasnotItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    /**
     * Тест проверяющий пункт меню: 4. Find item by Id в случае, когда заявки с указанным Id нет
     */
    @Test
    public void whenGetItemByIdWithoutAddingItems() {
        Input input = new StubInput(new String[]{"4", "123", "6"});
        new StartUI(input, tracker).init();
        String expected = "Заявки с заданным Id не существует";
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
    /**
     * Тест проверяющий пункт меню: 4. Find item by Id в случае, когда существует заявка с указанным Id
     */
    @Test
    public void whenUserAddItemThemGetItemById() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        String expected = item.getId();
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
    /**
     * Тест проверяющий пункт меню: 4. Find item by Id в случае, когда заявки с указанным названием нет
     */
    @Test
    public void whenGetItemByNameWithoutAddingItems() {
        Input input = new StubInput(new String[]{"5", "123", "6"});
        new StartUI(input, tracker).init();
        String expected = "Заявок нет";
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
    /**
     * Тест проверяющий пункт меню: 5. Find items by name в случае, когда существует заявка с указанным названием
     */
    @Test
    public void whenUserAddItemThemGetItemByName() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        String expected = item.getId();
        assertTrue(new String(out.toByteArray()).contains(expected));
    }
}