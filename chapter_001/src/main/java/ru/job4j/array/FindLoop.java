package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Проверяет наличие элемента в данном масиве
     * @param data Заданный массив
     * @param el Искомый элемент
     * @return индекс искомого элемента в массиве или -1, если такой элемент отсутствует
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}