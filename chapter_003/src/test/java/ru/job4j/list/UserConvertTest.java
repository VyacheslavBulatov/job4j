package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {
    @Test
    public void whenProcessUserList() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(2908, "Slava", "Saint-Petersburg"));
        String result = convert.process(list).get(2908).getName();
        assertThat(result, is("Slava"));
    }
}