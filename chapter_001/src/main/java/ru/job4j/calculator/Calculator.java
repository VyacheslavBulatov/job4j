package ru.job4j.calculator;

/**
 * Элементарный калькулятор
 */
public class Calculator {
    private double result;

    /**
     * Вычисление суммы двух чисел
     * @param first первое число
     * @param second второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычисление разности двух чисел
     * @param first первое число
     * @param second второе число
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Вычисление частного двух чисел
     * @param first первое число
     * @param second второе число
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Вычисление произведения двух чисел
     * @param first первое число
     * @param second второе число
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Возвращает результат вычисления
     * @return результат операции
     */
    public double getResult() {
        return this.result;
    }
}