package ru.job4j.tracker;

import java.util.*;

/**
 * Хранение заявок
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Список заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * ГСЧ для генерации идентификаторов заявок
     */
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Заменяет заявку с заданным идентиффикатором
     * @param id идентификатор
     * @param item новая заявка
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                item.setId(id);
                this.items.set(i, item);
                break;
            }
        }
    }

    /**
     * Удаляет заявку с заданным идентификатором
     * @param id идентификатор
     * @return true если удалось удалить, false иначе
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает список всех заявок
     * @return список всех заявок
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Выдает список заявок с данным именем
     * @param key имя заявки
     * @return список заявок с данным именем
     */
    public  List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Выдает заявку с заданным идентификатором
     * @param id идентификатор
     * @return заявка с заданным идентификатором или null, если таковой нет
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
