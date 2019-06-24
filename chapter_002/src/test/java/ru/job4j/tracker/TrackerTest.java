package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenAddNewItemsThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expected = Arrays.asList(item1, item2, item3);
        assertThat(tracker.findAll(), is(expected));
    }
    @Test
    public void whenAddNewItemsThenTrackerHasEqualItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test3", "testDescription", 123L);
        Item item5 = new Item("test3", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        List<Item> expected = Arrays.asList(item3, item4, item5);
        assertThat(tracker.findByName("test3"), is(expected));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenAddNewItemThenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.delete(item.getId()), is(true));
    }
    @Test
    public void whenAddNewItemThenDoesNotDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.delete("123"), is(false));
    }
    @Test
    public void whenAddNewItemThenDeleteSomeItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test3", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item3.getId());
        List<Item> expected = Arrays.asList(item1, item2, item4);
        assertThat(tracker.findAll(), is(expected));
    }
    @Test
    public void whenAddNewItemThenFindIt() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test4", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    @Test
    public void whenAddNewItemThenDoesNotFindIt() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test4", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertNull(tracker.findById("123"));
    }
}