package it.unibo.battleship.commons;

import it.unibo.battleship.ships.Ship;

import java.util.stream.IntStream;

import static it.unibo.battleship.commons.GlobalProperties.*;

/**
 * Represents the ruleset of the battlefield game. Some rules can be changed
 * manually.
 */
public final class Ruleset {
  public static final Boundary BOUNDARY = BoundaryImpl.createBoundary(10, 10);
  public static final boolean SHOOT_AGAIN_AFTER_HIT = false;

  private Ruleset() {
  }

  /**
   * Returns {@code true} if the point is within the limits of the boundary,
   * {@code false} otherwise.
   *
   * @param p
   *          a {@link Point2d}
   * @return {@code true} if the point is within the limits
   */
  public static boolean isPointWithinLimits(final Point2d p) {
    return ((p.getY() >= 0) && (p.getY() < BOUNDARY.getRowsCount()))
        && ((p.getX() >= 0) && (p.getX() < BOUNDARY.getColumnnCount()));
  }

  /**
   * Returns {@code true} if the ship is within the limits of the boundary,
   * {@code false} otherwise.
   *
   * @param ship
   *          {@link Ship}
   * @param point
   *          the starting position of the ship
   * @return {@code true} if the ship is within the limits of the boundary
   */
  public static boolean isShipWithinLimits(final Ship ship, final Point2d point) {
    // Standard direction : east
    /*
     * todo: refactor in the future to permit using other directions Use
     * Point2dHelper for the purpose
     */
    final int length = ship.getSize();

    return IntStream.range(point.getX(), (point.getX() + length)).allMatch(
        x -> Ruleset.isPointWithinLimits(new Point2dImpl(x, point.getY())));
  }

  public enum ShipRules {
    SUBMARINE("Submarine", SUBMARINE_SIZE, 3),
    CRUISER("Cruiser", CRUISER_SIZE, 2),
    BATTLESHIP("Battleship", BATTLESHIP_SIZE, 2),
    AIR_CARRIER("Air Carrier", AIR_CARRIER_SIZE, 0);

    // TODO: extract this enum and make a class (?)
    private final String name;
    private final int size;
    private final int instancesNumber;

    ShipRules(final String name, final int size, final int instancesNumber) {
      this.name = name;
      this.size = size;
      this.instancesNumber = instancesNumber;
    }

    @Override
    public String toString() {
      return this.name;
    }

    public int getInstancesNumber() {
      return this.instancesNumber;
    }

    public int getSize() {
      return this.size;
    }
  }

}
