package ru.job4j.tracker;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * хранит ссылку на объект .
     */
    private Input input;
    /**
     * хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * отвечает за выход из программы
     */
    private boolean exit = false;
    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Массив допустимых ответов пользователя в меню
     */
    private int[] range = new int[actions.length];
    /**
     * Заполняет массив допустимых ответов пользователя в меню
     */
    public void fillRange() {
        for (int i = 0; i < actions.length; i++) {
            range[i] = actions[i].key();
        }
    }
    /**
     * Возвращает массив допустимых ответов пользователя в меню
     * @return массив допустимых ответов пользователя в меню
     */
    public int[] getRange() {
        return range;
    }
    /**
     * Метод, возвращающий значение переменной exit
     * @return значение переменной exit
     */
    public boolean getExit() {
        return exit;
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        int key = 0;
        this.actions[key] = this.new AddItem(key++, "Add item");
        this.actions[key] = this.new ShowAllItems(key++, "Show all items.");
        this.actions[key] = this.new EditItem(key++, "Edit item.");
        this.actions[key] = this.new DeleteItem(key++, "Delete item.");
        this.actions[key] = this.new FindByID(key++, "Find item by Id.");
        this.actions[key] = this.new FindByName(key++, "Find items by name.");
        this.actions[key] = this.new Exit(key, "Exit.");
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Выводит на консоль имя, описание и Id заявки
     * @param item заявка
     */
    private void showItem(Item item) {
        System.out.println(item.getName() + " Description:" + " \"" + item.getDesc() + "\" with Id: " + item.getId());
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
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Реализация пункта меню: Add new Item.
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Реализация пункта меню: Show all items.
     */
    private class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.showAllItems(tracker.findAll());
        }

    }
    /**
     * Реализация пункта меню: Edit item.
     */
    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование выбранной заявки --------------");
            String id = input.ask("Введите Id заявки :");
            if (tracker.findById(id) == null) {
                System.out.println("Заявки с заданным Id не существует");
            } else {
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите описание заявки :");
                Item item = new Item(name, desc);
                tracker.replace(id, item);
                System.out.println("------------ Заявка изменена --------------");
            }
        }
    }
    /**
     * Реализация пункта меню: Delete item.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление выбранной заявки --------------");
            String id = input.ask("Введите Id заявки :");
            if (tracker.findById(id) == null) {
                System.out.println("Заявки с заданным Id не существует");
            } else {
                tracker.delete(id);
                System.out.println("------------ Заявка удалена --------------");
            }
        }
    }
    /**
     * Реализация пункта меню: Find item by Id.
     */
    private class FindByID extends BaseAction {
        public FindByID(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id заявки :");
            if (tracker.findById(id) == null) {
                System.out.println("Заявки с заданным Id не существует");
            } else {
                MenuTracker.this.showItem(tracker.findById(id));
            }
        }
    }
    /**
     * Реализация пункта меню: Find items by name.
     */
    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по названию --------------");
            String name = input.ask("Введите имя заявки :");
            MenuTracker.this.showAllItems(tracker.findByName(name));
        }
}
    /**
     * Реализация пункта меню: Find items by name.
     */
    private class Exit extends BaseAction {
        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.exit = true;
        }
    }
}
