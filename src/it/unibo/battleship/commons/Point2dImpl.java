package it.unibo.battleship.commons;

import com.google.common.base.Objects;

/**
 * Implementation of a 2 dimension point
 * {@see Point2d}
 * @author fabio.urbini
 *
 */
public final class Point2dImpl implements Point2d {
    private static final long serialVersionUID = -551958507759199801L;
    private final int x;
    private final int y;

    /**
     * @param x column
     * @param y row
     */
    public Point2dImpl(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }

        final Point2dImpl that = (Point2dImpl) o;

        return Objects.equal(this.x, that.x) && Objects.equal(this.y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.x, this.y);
    }

    @Override
    public String toString() {
        return " x = " + this.x + ", y = " + this.y;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}
