package ru.job4j.professions;

/**
 * Инженер
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    public Engineer(String name) {
        this.name = name;
        this.profession = "Инженер";
    }

    /**
     * Строит дом
     * @param house дом
     */
    public void build(House house) {
    }
}
