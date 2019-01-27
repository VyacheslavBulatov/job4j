package ru.job4j.tracker;

/**
 * Интерфейс ввода
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * Организует диалог программы с пользователем
     * @param question вопрос для пользователя
     * @return ответ пользователя
     */
    String ask(String question);
}
