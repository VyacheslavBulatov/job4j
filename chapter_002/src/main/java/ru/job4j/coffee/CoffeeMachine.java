package ru.job4j.coffee;
import java.util.Arrays;

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
     * @return сдача в монетах
     */
    public int[] change(int value, int price) {
        int change = value - price;
        int[] result = new int[0];
        int index = 0;
        if (!this.correctValue(value)) {
            throw new IncorrectValueException("Такая купюра не принимается");
        } else if (value < price) {
            throw new IncorrectValueException("Недостаточно средств для покупки");
        } else {
            for (int i = 0; i < coins.length; i++) {
                while (change >= coins[i] && this.remcoins[i] != 0) {
                    index++;
                    result = Arrays.copyOf(result, index);
                    result[index - 1] = coins[i];
                    change -= coins[i];
                    this.remcoins[i] -= 1;
                }
            }
            if (change != 0) {
                throw new IncorrectValueException("Невозможно выдать сдачу");
            }
        }
        return result;
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
}
