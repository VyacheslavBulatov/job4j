package ru.job4j.pseudo;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Выводит на консоль фигуру
     * @param shape форма фигуры
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
