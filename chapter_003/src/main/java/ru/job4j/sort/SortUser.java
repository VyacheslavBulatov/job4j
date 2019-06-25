package ru.job4j.sort;

import java.util.Comparator;
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

    /**
     * Сортирует список пользователей по длине имени
     * @param users исходный список
     * @return отсортированный список
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    /**
     * Сортирует список пользователей сначала по имени в лексикографическом порядке, потом по возрасту
     * @param users исходный список
     * @return отсортированный список
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result;
                String n1 = o1.getName();
                String n2 = o2.getName();
                if (!n1.equals(n2)) {
                    result = o1.getName().compareTo(o2.getName());
                } else {
                    result = Integer.compare(o1.getAge(), o2.getAge());
                }
                return result;
            }
        });
        return users;
    }
}
