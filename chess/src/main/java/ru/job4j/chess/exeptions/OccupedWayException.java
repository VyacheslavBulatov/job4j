package ru.job4j.chess.exeptions;

public class OccupedWayException extends RuntimeException {
    public OccupedWayException(String msg) {
        super(msg);
    }
}
