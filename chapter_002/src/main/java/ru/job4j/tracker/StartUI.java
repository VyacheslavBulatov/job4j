package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String ID = "4";
    /**
     * Константа меню для поиска заявок по названию.
     */
    private static final String NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems(this.tracker.findAll());
            } else if (NAME.equals(answer)) {
                this.findByNAME();
            } else if (ID.equals(answer)) {
                this.findByID();
            } else if (DEL.equals(answer)) {
                this.deleteItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Выводит на консоль имя, описание и Id заявки
     * @param item заявка
     */
    private void showItem(Item item) {
        System.out.println(item.getName() + " Description:" + " '" + item.getDesc() + "' with Id: " + item.getId());
    }

    /**
     * Вывод на консоль списка заявок
     * @param items массив заявок для вывода
     */
    private void showAllItems(Item[] items) {
        if (items.length == 0) {
            System.out.println("Заявок нет");
        } else {
            System.out.println("*");
            for (Item item : items) {
                this.showItem(item);
                System.out.println("*");
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует удаление заявки из хранилища
     */
    private void deleteItem() {
        System.out.println("------------ Удаление выбранной заявки --------------");
        String id = this.input.ask("Введите Id заявки :");
        if (this.tracker.findById(id) == null) {
            System.out.println("Заявки с заданным Id не существует");
        } else {
            this.tracker.delete(id);
            System.out.println("------------ Заявка удалена --------------");
        }
    }
    /**
     * Метод поиск заявки по Id
     */
    private void findByID() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id заявки :");
        if (this.tracker.findById(id) == null) {
            System.out.println("Заявки с заданным Id не существует");
        } else {
            showItem(this.tracker.findById(id));
        }
    }
    /**
     * Метод поиск заявок по названию
     */
    private void findByNAME() {
        System.out.println("------------ Поиск заявок по названию --------------");
        String name = this.input.ask("Введите имя заявки :");
        this.showAllItems(this.tracker.findByName(name));
    }
    /**
     * Метод реализует редактирование заявки
     */
    private void editItem() {
        System.out.println("------------ Редактирование выбранной заявки --------------");
        String id = this.input.ask("Введите Id заявки :");
        if (this.tracker.findById(id) == null) {
            System.out.println("Заявки с заданным Id не существует");
        } else {
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            this.tracker.replace(id, item);
            System.out.println("------------ Заявка изменена --------------");
        }
    }
    /**
     * Выводит меню программы в консоль
     */
    private void showMenu() {
        StringBuilder menu = new StringBuilder();
        String ln = System.lineSeparator();
        menu.append("Меню:"); menu.append(ln);
        menu.append("0. Add new Item"); menu.append(ln);
        menu.append("1. Show all items"); menu.append(ln);
        menu.append("2. Edit item"); menu.append(ln);
        menu.append("3. Delete item"); menu.append(ln);
        menu.append("4. Find item by Id"); menu.append(ln);
        menu.append("5. Find items by name"); menu.append(ln);
        menu.append("6. Exit Program"); menu.append(ln);
        System.out.println(menu.toString());


    }

    /**
     * Запускает программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}