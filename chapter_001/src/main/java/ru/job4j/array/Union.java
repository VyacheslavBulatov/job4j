package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Union {
    /**
     * Объединяет два отсортированных массива в один отсортированный
     * @param first первый массив
     * @param second второй массив
     * @return объединненный массив
     */
    public int[] union(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < result.length; i++) {
            if (a != first.length && b != second.length) {
               result[i] = first[a] < second[b] ? first[a++] : second[b++];
                } else {
                result[i] = a != first.length ? first[a++] : second[b++];
            }
            }
        return result;
    }
}
