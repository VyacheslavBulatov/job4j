package ru.job4j.list;

import java.util.List;

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
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cells; j++) {
                    if (index < list.size()) {
                        array[i][j] = list.get(index);
                        index++;
                    } else {
                        array[i][j] = 0;
                    }
                }
            }
            return array;
        }
    }

