package ru.job4j.chess.firuges;

import ru.job4j.chess.exeptions.ImpossibleMoveException;

public class Path {
    public  Cell[] getPath(Cell source, Cell dest) {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        Cell[] steps = new Cell[Math.max(Math.abs(dx), Math.abs(dy))];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.findByXY(source.x + (i + 1) * Integer.compare(dx, 0),
                    source.y + (i + 1) * Integer.compare(dy, 0));
        }
        return steps;
    }
    public Cell[] getBishopPath(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (Math.abs(dx) != Math.abs(dy)) {
            throw new ImpossibleMoveException("Слон ходит только по диагонали");
        }
        return this.getPath(source, dest);
    }
    public Cell[] getRookPath(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (dx != 0 && dy != 0) {
            throw new ImpossibleMoveException("Ладья ходит только по прямой");
        }
        return this.getPath(source, dest);
    }
    public Cell[] getQeenPath(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (Math.abs(dx) != Math.abs(dy) && dx != 0 && dy != 0) {
            throw new ImpossibleMoveException("Ферзь ходит только по диагонали или прямой");
        }
        return this.getPath(source, dest);
    }
    public Cell[] getKnightPath(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (!((Math.abs(dx) == 2 && Math.abs(dy) == 1) || (Math.abs(dx) == 1 && Math.abs(dy) == 2))) {
            throw new ImpossibleMoveException("Конь может ходить только буквой Г");
        }
        return new Cell[] {dest};
    }
    public Cell[] getKingPath(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            throw new ImpossibleMoveException("Король может ходить только на одну клетку");
        }
        return new Cell[] {dest};
    }
}
