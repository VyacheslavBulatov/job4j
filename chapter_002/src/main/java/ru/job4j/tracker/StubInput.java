package ru.job4j.tracker;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * Поле, содержащее список ответов пользователя
     */
    private List<String> value;
    /**
     * Итератор для списка ответов
     */
    private ListIterator<String> iterator;


    /**
     * Конструктор объекта класса StubInput
     * @param value список ответов
     */
    public StubInput(final List<String> value) {
        this.value = value;
        iterator = value.listIterator();
    }

    /**
     * Метод имитирующий ответы пользователя
     * Каждый следующий вызов будет возвращать следующий в ответ в списе value
     * @param question вопрос для пользователя
     * @return ответ из массива
     */
    @Override
    public String ask(String question) {
        return this.iterator.next();
    }

    /**
     * Метод имитирующий ответы пользователя при выборе пунктов меню
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ из массива
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.iterator.next());
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of range");
        }
        return key;
    }
}
