package it.unibo.battleship.common;

import com.google.common.base.Objects;

/**
 * Implementation of Boundary 
 * {@see Boundary}
 */
public class BoundaryImpl implements Boundary {
    private final int horizontalBound;
    private final int verticalBound;

    /**
     * @param horizontalBound Horizontal bound
     * @param verticalBound Vertical bound
     */
    public BoundaryImpl(final int horizontalBound, final int verticalBound) {
        this.horizontalBound = horizontalBound;
        this.verticalBound = verticalBound;
    }
    
    @Override
    public final int getHorizontalBound() {
        return this.horizontalBound;
    }

    @Override
    public final int getVerticalBound() {
        return this.verticalBound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoundaryImpl that = (BoundaryImpl) o;

        return Objects.equal(this.horizontalBound, that.horizontalBound) &&
                Objects.equal(this.verticalBound, that.verticalBound);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(horizontalBound, verticalBound);
    }

    @Override
    public String toString() {
        return " x : " + this.horizontalBound + " y : " + verticalBound;
    }
}
