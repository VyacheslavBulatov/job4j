package ru.job4j.list;

import java.util.List;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {
        /**
         * Конвертирует ArrayList в двухмерный массив с заданным количеством строк
         * @param list заданный ArrayList
         * @param rows количество строк
         * @return двухмерный массив
         */
        public int[][] toArray(List<Integer> list, int rows) {
            int cells = 1 + list.size() / rows;
            int[][] array = new int[rows][cells];
            int r = 0;
            int c = 0;
            for (int i: list) {
                if (c < cells) {
                    array[r][c] = i;
                    c++;
                } else {
                    c = 0;
                    r++;
                    array[r][c] = i;
                    c++;
                }
            }
            return array;
        }
    }

