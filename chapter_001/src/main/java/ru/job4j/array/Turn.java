package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     * Переворачивает заданный массив задом на перед
     * @param array заданный массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        for (int i = 0; i != array.length / 2; i++) {
            int first = array[i];
            int j = array.length - 1 - i;
            array[i] = array[j];
            array[j] = first;
        }
        return array;
    }
}
