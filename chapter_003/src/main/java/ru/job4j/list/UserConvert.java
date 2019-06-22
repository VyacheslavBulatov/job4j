package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    /**
     * Конвертирует список пользователей в хэш-таблицу
     * @param list заданный список пользователей
     * @return результат конвертации
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user: list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
