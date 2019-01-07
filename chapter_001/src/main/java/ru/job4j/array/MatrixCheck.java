package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * Проверяет монотонность двух диагоналей квадратной матрицы
     * @param data заданная матрица
     * @return результат
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int length = data[0].length;
        for (int i = 1; i < length; i++) {
            if (data[i][i] != data[0][0] || data[i][length - 1 - i] != data[0][length - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
