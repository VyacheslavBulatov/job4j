package ru.job4j.list;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User {
    public int id;
    public String name;
    public String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getCity() {
        return this.city;
    }
}
