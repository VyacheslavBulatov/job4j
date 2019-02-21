package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Path;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
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
        if(source.y == 6 && (Math.abs(dy) > 2 || dx != 0 || dy > 0 )) {
            throw new ImpossibleMoveException("Пешка со стартовой позици может двигаться только на одну или две клетки вперед");
        }
        if(source.y != 6 && (Math.abs(dy) > 1 || dx != 0 || dy > 0 )) {
            throw new ImpossibleMoveException("Пешка не со стартовой позиции может двигаться только на одну клетку вперед");
        }
        return new Path().getPath(source, dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
