package it.unibo.battleship.common;

import it.unibo.battleship.ships.Ship;

/**
 * Represents the ruleset of the battlefield game.
 * Some rules can be changed manually.
 */
public final class Ruleset {
    private static final Boundary BOUNDARY = BoundaryImpl.createBoundary(9, 9);
    private static final boolean SHOOT_AGAIN_AFTER_HIT = false;

    private Ruleset() {}

    public static boolean isPointWithinLimits(final Point2d p) {
        return ( p.getY() >= 0 && p.getY() < BOUNDARY.getRowsCount()) &&
                ( p.getX() >= 0 && p.getX() < BOUNDARY.getColumnsCount() );
    }

    public static boolean isShipWithinLimits(final Ship ship, final Point2d point) {
        // Standard direction : east
        int length = ship.getSize();

        for (int x = point.getX(); x <(point.getX() + length); x++ ) {
            if (!Ruleset.isPointWithinLimits(new Point2dImpl(x, point.getY()))) {
                return false;
            }
        }
        return true;
    }

    public static Boundary getBoundary() {
        return BOUNDARY; // boundary is immutable
    }

    @SuppressWarnings("unused")
    public static boolean shootAgainAfterHit() {
    	return SHOOT_AGAIN_AFTER_HIT;
    }
}
