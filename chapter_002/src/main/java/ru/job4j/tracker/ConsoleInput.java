package ru.job4j.tracker;

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
}
