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
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowAllItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindByID();
        this.actions[5] = this.new FindByName();
        this.actions[6] = this.new Exit();
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
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
    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "Add new Item.";
        }
    }

    /**
     * Реализация пункта меню: Show all items.
     */
    public class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.showAllItems(tracker.findAll());
        }

        @Override
        public String info() {
            return "Show all items.";
        }
    }
    /**
     * Реализация пункта меню: Edit item.
     */
    public class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "Edit item.";
        }
    }
    /**
     * Реализация пункта меню: Delete item.
     */
    public class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "Delete item.";
        }
    }
    /**
     * Реализация пункта меню: Find item by Id.
     */
    public class FindByID implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return "Find item by Id.";
        }
    }
    /**
     * Реализация пункта меню: Find items by name.
     */
    public class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по названию --------------");
            String name = input.ask("Введите имя заявки :");
            MenuTracker.this.showAllItems(tracker.findByName(name));
        }

        @Override
        public String info() {
            return "Find items by name.";
        }
    }
    /**
     * Реализация пункта меню: Find items by name.
     */
    public class Exit implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.exit = true;
        }

        @Override
        public String info() {
            return "Exit.";
        }
    }

}
