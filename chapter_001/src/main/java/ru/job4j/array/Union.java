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
        int c = 0;
        for (int i = b; i < second.length; i++) {
                for (int j = a; j < first.length; j++) {
                    if (first[j] < second[i]) {
                        result[c] = first[j];
                        c++;
                        a++;
                    } else {
                        result[c] = second[i];
                        c++;
                        b++;
                        break;
                    }
                }
            }
        for (int i = a; i < first.length; i++) {
                result[c] = first[i];
                c++;
        }
        for (int i = b; i < second.length; i++) {
            result[c] = second[i];
            c++;
        }
        return result;
    }
}
