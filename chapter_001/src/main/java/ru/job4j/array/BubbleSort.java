package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {
    /**
     * Сортирует массив целых чисел в порядке возрастания
     * @param array заданный массив
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int j = array.length; j > 1; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int first = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = first;
                }
            }
        }
        return array;
    }
}
