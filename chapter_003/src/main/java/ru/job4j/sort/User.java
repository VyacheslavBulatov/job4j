package ru.job4j.sort;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Возраст пользователя
     */
    private int age;

    /**
     * Конструктор создания объекта класса пользователь
     * @param name имя
     * @param age возраст
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(this.age, user.getAge());
    }
}
