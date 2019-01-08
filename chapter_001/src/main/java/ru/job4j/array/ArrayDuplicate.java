package ru.job4j.array;
import java.util.Arrays;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Удаляет из заданного массива дублирующиеся элементы
     * @param array заданный массив
     * @return массив без дублирующихся элементов
     */
    public String[] remove(String[] array) {
        int uniq = array.length;
        for (int i = 0; i < uniq; i++) {
            for (int j = i + 1; j < uniq; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[uniq - 1];
                    uniq--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, uniq);
    }
}
