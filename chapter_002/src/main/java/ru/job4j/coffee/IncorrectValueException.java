package ru.job4j.coffee;

public class IncorrectValueException extends RuntimeException {
    public IncorrectValueException(String msg) {
        super(msg);
    }
}
