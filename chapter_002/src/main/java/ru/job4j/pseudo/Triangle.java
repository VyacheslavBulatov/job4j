package ru.job4j.pseudo;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    /**
     * Создает треугольник в псевдографике
     * @return треугольник
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   ^ \n ");
        pic.append(" / \\\n ");
        pic.append("/___\\");
        return pic.toString();
    }
}
