package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Возвращает массив заполненный квадратами целых чисел
     * @param bound Длина массива
     * @return Массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}