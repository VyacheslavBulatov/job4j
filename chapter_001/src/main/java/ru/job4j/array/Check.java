package ru.job4j.array;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Проверяет все ли элементы данного массива одинаковы
     * @param data Заданный массив
     * @return Результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
       for (int i = 1; i != data.length; i++) {
           if (data[i] != data[0]) {
               result = false;
               break;
           }
        }
        return result;
    }
}