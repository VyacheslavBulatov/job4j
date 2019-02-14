package ru.job4j.chess;

import ru.job4j.chess.exeptions.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest)  {
        boolean rst = false;
        try {
            rst = this.canMove(source, dest);
        } catch (ImpossibleMoveException | FigureNotFoundException | OccupedWayException err) {
            System.out.println(err.getMessage());
        }
        return rst;
    }

    public boolean canMove(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Вы выбрали пустую клетку");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (Cell i : steps) {
            if (this.findBy(i) != -1) {
                throw new OccupedWayException("Путь заблокирован");
            }
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
