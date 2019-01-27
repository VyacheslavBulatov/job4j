package ru.job4j.tracker;

/**
 * Класс заявки
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /** Id заявки */
    private String id;
    /** Имя заявки */
    private String name;
    /** Описание */
    private String desc;
    /** Дата создания */
    private long create;
    /** Список комментариев */
    private String[] comments;

    /**
     * Конструктор создания нового объекта
     */
    public  Item() {
        this.name = "Default";
        this.id = "";
    }

    /**
     * Конструктор создания нового объекта с заданными параметрами
     * @param name имя
     * @param desc описание
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    /**
     * Конструктор создания нового объекта с заданными параметрами
     * @param name имя
     * @param desc описание
     * @param create дата создания
     */
    public Item(String name, String desc, long create) {
        this(name, desc);
        this.create = create;
    }

    /**
     * Задает Id заявки
     * @param id Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает id заявки
     * @return id заявки
     */
    public String getId() {
        return this.id;
    }

    /**
     * Возвращает имя заявки
     * @return имя заявки
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает описание заявки
     * @return описание заявки
     */
    public String getDesc() {
        return this.desc;
    }
}
