package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int it = Integer.min(left.length(), right.length());
        for (int i = 0; i < it; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}