package ru.job4j.coffee;

/**
 * Кофемашина
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachine {
    /**
     * Массив восзможных номиналов монет для сдачи
     */
    private final int[] coins = {10, 5, 2, 1};
    /**
     * Массив монет, оставшихся в автомате
     */
    private int[] remcoins = new int[this.coins.length];
    /**
     * Массив восзможных номиналов купюр для приема
     */
    private final int[] banknotes = {50, 100, 200, 500, 1000, 2000, 5000};
    /**
     * Конструктор создания кофемшины
     * @param coin массив с количеством монет
     */
    public CoffeeMachine(int[] coin) {
        for (int i = 0; i < this.coins.length; i++) {
            if (i < coin.length) {
                this.remcoins[i] = coin[i];
            } else {
                this.remcoins[i] = 0;
            }
        }
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
        int[] change = new int[this.sumN(coin, this.coins.length)];
        for (int i = 0; i < change.length; i++) {
            for (int j = 0; j < this.coins.length; j++) {
                if (i < this.sumN(coin, j + 1)) {
                    change[i] = this.coins[j];
                    break;
                }
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
        int[] changecoin = new int[this.coins.length];
        for (int i = 0; i < this.coins.length; i++) {
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
     * Находит сумму первых n элементов массива
     * @param sum заданный массив
     * @return сумма первых n элементов массива
     */
    private int sumN(int[] sum, int n) {
        int rst = 0;
        for (int i = 0; i < n; i++) {
            rst += sum[i];
        }
        return rst;
    }
    /**
     * Находит элементов массива, с учетом номинала
     * Номинал 0-го элемента = 10, 1-го - 5, 2-го - 2 и 3-го -1.
     * @param sum заданный массив
     * @return сумма элементов массива, с учетом номинала
     */
    private int changesum(int[] sum) {
        int rst = 0;
        for (int i = 0; i < this.coins.length; i++) {
            rst += this.coins[i] * sum[i];
        }
        return rst;
    }
}
