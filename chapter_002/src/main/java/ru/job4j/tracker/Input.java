package ru.job4j.tracker;

import java.util.List;

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

    /**
     * Реализует выбор пунтков меню пользователем
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ пользователя, если он подходит, иначе ошибку
     */
    int ask(String question, List<Integer> range);
}
