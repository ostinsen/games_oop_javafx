package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {

       BishopBlack bishopBlack = new BishopBlack(Cell.C8);
       assertThat(Cell.C8,  is(bishopBlack.position()));
    }



    @Test
    public void copy() {
       BishopBlack bishopBlack = new BishopBlack(Cell.C8);

       assertThat(bishopBlack.copy(Cell.A6).position(), is(Cell.A6));
    }

    @Test
    public void way() {

        BishopBlack bishopBlack = new BishopBlack(Cell.C1);

        Cell[] cells = bishopBlack.way(Cell.G5);


        assertThat(cells,  is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void wayReverse() {

        BishopBlack bishopBlack = new BishopBlack(Cell.G5);

        Cell[] cells = bishopBlack.way(Cell.C1);


        assertThat(cells,  is(new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1}));
    }

}