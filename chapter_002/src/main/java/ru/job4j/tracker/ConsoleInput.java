package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Считывание ввода пользователя
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Реализация метода ask интерфейса Input
     * @param question вопрос для пользователя
     * @return ответ пользователя
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Реализует выбор пунтков меню пользователем
     * @param question вопрос для пользователя
     * @param range список возможных ответов
     * @return ответ пользователя или ошибку
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
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
