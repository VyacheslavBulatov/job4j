package ru.job4j.tracker;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * Поле, содержащее список ответов пользователя
     */
    private String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Конструктор объекта класса StubInput
     * @param value список ответов
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Метод имитирующий ответы пользователя
     * Каждый следующий вызов будет возвращать следующий в ответ в списе value
     * @param question вопрос для пользователя
     * @return ответ из массива
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    /**
     * Метод имитирующий ответы пользователя при выборе пунктов меню
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ из массива
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.value[this.position++]);
    }

}
