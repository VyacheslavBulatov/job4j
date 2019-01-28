package ru.job4j.tracker;

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
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

}