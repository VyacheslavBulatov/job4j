package ru.job4j.loop;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Вычисляет факториал заданного числа
     * @param n заданное число
     * @return факториал числа n
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
