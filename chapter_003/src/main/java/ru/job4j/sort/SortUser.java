package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    /**
     * Сортирует список пользователей
     * @param users исходный список
     * @return отсортированный список
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
