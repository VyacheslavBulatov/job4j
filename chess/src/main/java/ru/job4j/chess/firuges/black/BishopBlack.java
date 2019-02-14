package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int dx = dest.x - source.x;
        int dy = dest.y - source.y;
        if (Math.abs(dx) != Math.abs(dy)) {
            throw new ImpossibleMoveException("Слон ходит только по диагонали");
        }
        Cell[] steps = new Cell[Math.abs(dx)];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.findByXY(source.x + (i + 1) * Integer.compare(dx, 0),
                    source.y + (i + 1) * Integer.compare(dy, 0));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
