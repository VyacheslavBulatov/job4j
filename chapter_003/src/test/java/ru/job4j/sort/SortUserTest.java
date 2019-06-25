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

}