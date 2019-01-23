package ru.job4j.professions;

/**
 * Доктор
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    public Doctor(String name) {
        this.name = name;
        this.profession = "Доктор";
    }

    /**
     * Лечит пациента
     * @param patient пациент
     */
    public void heal(Patient patient) {
    }
}
