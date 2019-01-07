package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
