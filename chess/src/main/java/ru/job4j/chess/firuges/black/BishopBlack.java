package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (! isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
            int size = Math.abs(position.getX() - dest.getX());
            Cell[] steps = new Cell[size];
            int deltaX = position.getX();
            int deltaY = position.getY();
            for (int index = 0; index < size; index++) {
                if (position.getX() < dest.getX() && position.getY() > dest.getY() ) {
                    steps[index] = Cell.findBy((position.getX() + 1 + index), (position.getY() - 1 - index));
                }
                else if (position.getX() > dest.getX() && position.getY() < dest.getY()){
                    steps[index] = Cell.findBy((position.getX() - 1 - index), (position.getY() + 1 + index));
                }
                else if (position.getX() > dest.getX() && position.getY() > dest.getY()){
                    steps[index] = Cell.findBy((position.getX() - 1 - index), (position.getY() - 1 - index));
                }
                else if (this.position().getX() < dest.getX() && this.position().getY() < dest.getY()){
                    steps[index] = Cell.findBy((position.getX() + 1 + index), (position.getY() + 1 + index));
                }
            }
            return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
