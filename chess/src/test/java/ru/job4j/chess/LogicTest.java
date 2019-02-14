package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.junit.Assert.*;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class LogicTest {
    /**
     * Проверяет движение слона по диагонали (право верх)
     */
    @Test
    public void whenBishopUpAndRight() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        logic.add(bishopBlack);
        boolean rst = logic.move(Cell.F2, Cell.E3);
        assertTrue(rst);
    }
    /**
     * Проверяет движение слона по диагонали (право низ)
     */
    @Test
    public void whenBishopDownAndRight() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        logic.add(bishopBlack);
        boolean rst = logic.move(Cell.F2, Cell.H4);
        assertTrue(rst);
    }
    /**
     * Проверяет невозможное движение слона
     */
    @Test
    public void whenBishopIncorrectMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        logic.add(bishopBlack);
        boolean rst = logic.move(Cell.F2, Cell.H8);
        assertFalse(rst);
    }

    /**
     * Проверяет движение слона при заблокированном пути
     */
    @Test
    public void whenBishopWayIsOccuped() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        PawnBlack pawnBlack = new PawnBlack(Cell.F3);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        boolean rst = logic.move(Cell.H1, Cell.D4);
        assertFalse(rst);
    }

}