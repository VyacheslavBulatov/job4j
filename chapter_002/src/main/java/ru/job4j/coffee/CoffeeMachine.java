package ru.job4j.coffee;

/**
 * Кофемашина
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachine {
    /**
     * Массив монет, отсавшихся в автомате
     */
    private int[] remcoins = new int[4];
    /**
     * Массив восзможных номиналов монет для сдачи
     */
    private final int[] coins = {10, 5, 2, 1};
    /**
     * Массив восзможных номиналов купюр для приема
     */
    private final int[] banknotes = {50, 100, 200, 500, 1000, 2000, 5000};
    /**
     * Конструктор создания кофемшины
     * @param ten количество 10-рублевых монет
     * @param five количество 5-рублевых монет
     * @param two количество 2-рублевых монет
     * @param one количество 1-рублевых монет
     */
    public CoffeeMachine(int ten, int five, int two, int one) {
        this.remcoins[0] = ten;
        this.remcoins[1] = five;
        this.remcoins[2] = two;
        this.remcoins[3] = one;
    }
    /**
     * Возвращает сдачу в монетах если хватает монет и коректно введены номинал купюры  и цена
     * @param value Введенная купюра
     * @param price цена напитка
     * @return сдача в монетах,
     */
    public int[] change(int value, int price) {
        int change = value - price;
        if (!this.correctValue(value)) {
            throw new IncorrectValueException("Такая купюра не принимается");
        } else if (value < price) {
            throw new IncorrectValueException("Недостаточно средств для покупки");
        } else if (change - this.changesum(this.changecoins(change)) > 0) {
            throw new IncorrectValueException("Невозможно выдать сдачу");
        }
        return this.fillChange(this.changecoins(change));
    }
    /**
     * Проверяет вводимую купюру
     * @param value вводимая купюра
     * @return true, если купюра подходит
     */
    public boolean correctValue(int value) {
        boolean rst = false;
        for (int i : banknotes) {
            if (value == i) {
                rst = true;
                break;
            }
        }
        return rst;
    }
    /**
     * Возвращает итоговый вариант сдачи
     * @param coin массив, элементы которого - количество монет для сдачи
     * @return сдача
     */
    private int[] fillChange(int[] coin) {
        int[] change = new int[this.sum(coin)];
        for (int i = 0; i < change.length; i++) {
            if (i < coin[0]) {
                change[i] = 10;
            } else if (i < coin[0] + coin[1]) {
                change[i] = 5;
            } else if (i < coin[0] + coin[1] + coin[2]) {
                change[i] = 2;
            } else {
                change[i] = 1;
            }
        }
        return change;
    }
    /**
     * Возвращает массив, элементы которого - количество монет для сдачи
     * @param change сдача
     * @return массив, элементы которого - количество монет для сдачи
     */
    private int[] changecoins(int change) {
        int[] changecoin = new int[4];
        for (int i = 0; i < 4; i++) {
            int quotient = change / coins[i];
            if (quotient > 0) {
                if (quotient < this.remcoins[i]) {
                    changecoin[i] = quotient;
                    change %= coins[i];
                } else {
                    changecoin[i] = this.remcoins[i];
                    change -= coins[i] * this.remcoins[i];
                }
            }
        }
        return changecoin;
    }
    /**
     * Находит сумму первых 4 элементов массива длины
     * @param sum заданный массив
     * @return сумма первых 4  элементов массива
     */
    private int sum(int[] sum) {
        int rst = 0;
        for (int i = 0; i < 4; i++) {
            rst += sum[i];
        }
        return rst;
    }
    /**
     * Находит первых 4  элементов массива, с учетом номинала
     * Номинал 0-го элемента = 10, 1-го - 5, 2-го - 2 и 3-го -1.
     * @param sum заданный массив
     * @return сумма первых 4  элементов массива, с учетом номинала
     */
    private int changesum(int[] sum) {
        int rst = 0;
        for (int i = 0; i < 4; i++) {
            rst += this.coins[i] * sum[i];
        }
        return rst;
    }
}
