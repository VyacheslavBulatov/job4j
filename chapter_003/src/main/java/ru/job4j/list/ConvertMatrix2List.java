package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Конвертирует двухмерный массив в ArrayList
     * @param array заданный массив
     * @return получившийся ArrayList
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i: array) {
            for (int j: i) {
                list.add(j);
            }
        }
        return list;
    }
}