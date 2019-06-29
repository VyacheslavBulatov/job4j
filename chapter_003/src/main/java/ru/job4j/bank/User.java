package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Имя клиента
     */
    private String name;
    /**
     * Паспортные данные клиента
     */
    private String pasport;

    /**
     * Конструктор создания пользователя
     * @param name имя
     * @param pasport паспортные данные
     */
    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    public String getName() {
        return this.name;
    }
    public String getPasport() {
        return this.pasport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.pasport.equals(user.pasport) && this.name.equals(user.pasport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pasport, this.name);
    }
}
