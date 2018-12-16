package ru.job4j.loop;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Определяет сумму четных чисел в заданном диапазоне
     * @param start начало диапазона
     * @param finish конец диапазона
     * @return сумма четных чисел этого диапазона
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
