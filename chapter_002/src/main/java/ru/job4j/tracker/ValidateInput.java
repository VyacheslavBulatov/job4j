package ru.job4j.tracker;

import java.util.List;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Конструктор класса Validate input
     * @param input входящие данные
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Реализация метода ask интерфейса Input
     * @param question вопрос для пользователя
     * @return ответ пользователя или иммитирующего класса
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Проверяет корректность данных введенных пользователем
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ пользователя или ошибку
     */
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста введите значение пункта меню из указанного диапазона");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите корректное значение пункта меню");
            }
        } while (invalid);
        return value;
    }
}
