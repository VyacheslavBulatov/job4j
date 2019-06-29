package ru.job4j.bank;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Account {
    /**
     * Колличество денежных средств на счету
     */
    private double value;
    /**
     * Реквизиты счета
     */
    private String requisites;

    /**
     * Конструктор создания счета
     * @param value колличество денежных средств на счету
     * @param requisites реквизиты счета
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Переводит средства с данного счета на указанный
     * @param dest счет для перевода
     * @param ammount колличество средств для перевода
     * @return true в случае успеха, иначе - false
     */
    public boolean transfer(Account dest, double ammount) {
        boolean result = false;
        if (dest != null && 0 < ammount && ammount < this.value) {
            this.value -= ammount;
            dest.value += ammount;
            result = true;
        }
        return result;
    }


}
