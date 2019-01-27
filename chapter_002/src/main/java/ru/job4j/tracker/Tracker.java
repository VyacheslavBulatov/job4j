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
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * ГСЧ для генерации идентификаторов заявок
     */
    private static final Random RN = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
     * @return true если удалось заменить, false иначе
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаляет заявку с заданным идентификатором
     * @param id идентификатор
     * @return true если удалось удалить, false иначе
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position-- - i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает копию массива заявок без null элементов
     * @return копия массива заявок без null элементов
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Выдает список заявок с данным именем
     * @param key имя заявки
     * @return список заявок с данным именем
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int counter = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[counter++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, counter);
    }

    /**
     * Выдает заявку с заданным идентификатором
     * @param id идентификатор
     * @return заявка с заданным идентификатором или null, если таковой нет
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}
