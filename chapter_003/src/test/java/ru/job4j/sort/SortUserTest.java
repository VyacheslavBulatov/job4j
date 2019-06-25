package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void whenAddThreeUsersThanFindOne() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 40));
        users.add(new User("Slava", 23));
        users.add(new User("Vadyan", 18));
        Set<User> result = sortUser.sort(users);
        Iterator<User> it = result.iterator();
        assertEquals(it.next().getName(), "Vadyan");
        assertEquals(it.next().getName(), "Slava");
    }
    @Test
    public void whenAddFourUsersThanFindOne() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 40));
        users.add(new User("Slava", 23));
        users.add(new User("Vadyan", 18));
        users.add(new User("Petr", 50));
        List<User> result = sortUser.sortByAllFields(users);
        assertEquals(result.get(3).getName(), "Vadyan");
        assertEquals(result.get(1).getName(), "Petr");
        assertEquals(result.get(2).getName(), "Slava");
        assertEquals(result.get(1).getAge(), 50);
    }
    @Test
    public void whenAddFiveUsersThanFindOne() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 40));
        users.add(new User("Slava", 23));
        users.add(new User("Vadyan", 18));
        users.add(new User("Viacheslav", 50));
        users.add(new User("Alexandr", 50));
        List<User> result = sortUser.sortNameLength(users);
        assertEquals(result.get(2).getName(), "Vadyan");
        assertEquals(result.get(0).getName(), "Petr");
        assertEquals(result.get(4).getName(), "Viacheslav");
    }
}