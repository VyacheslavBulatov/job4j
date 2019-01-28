package ru.job4j.pseudo;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     * Создает квадрат в псевдографике
     * @return квадрат
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++\n");
        pic.append("+   +\n");
        pic.append("+   +\n");
        pic.append("+++++");
        return pic.toString();
    }
}
