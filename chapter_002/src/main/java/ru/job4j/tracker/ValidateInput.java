package ru.job4j.tracker;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Проверяет корректность данных введенных пользователем
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ пользователя или ошибку
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
