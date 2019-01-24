package ru.job4j.professions;

/**
 * Учитель
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    public Teacher(String name, String profession) {
        super(name, "Учитель");
    }
    /**
     * Учит студента
     * @param student студент
     */
    public void teach(Student student) {
    }
}
