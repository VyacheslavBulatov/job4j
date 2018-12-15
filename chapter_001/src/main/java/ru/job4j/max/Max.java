package ru.job4j.max;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Определяет наибольшее из двух чисел
     * @param first первое число
     * @param second второе число
     * @return наиблоьшее из двух чисел
     */
    public int max(int first, int second) {
        return first  > second ? first : second;
    }
}
