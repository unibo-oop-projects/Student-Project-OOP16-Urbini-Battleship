package tmpmodel;

public final class Ruleset {
    // PATTERN COMMAND PER FARE METODI IN BASE ALLE NAVI ESISTENTI?

    private static final int N_SUBMARINES = 3;
    private static final int N_CRUISERS = 2;

    private static final int NORTHERN_LIMIT = 0;
    private static final int SOUTHERN_LIMIT = 9;
    private static final int EASTERN_LIMIT = 9;
    private static final int WESTERN_LIMIT = 0;
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    
    private static final int SUBMARINE_SIZE = 2;
    private static final int CRUISER_SIZE = 3;
    private static final int BATTLESHIP_SIZE = 4;

//    public static boolean isPointWithinLimits(final Point2d p) {
//        return (p.getY() >= NORTHERN_LIMIT && p.getY() <= SOUTHERN_LIMIT) &&
//                (p.getX() >= WESTERN_LIMIT && p.getX() <= EASTERN_LIMIT );
//    }
    
    public static boolean isPointWithinLimits(final Point2d p) {
        return (p.getY() >= 0 && p.getY() < Ruleset.ROWS) &&
                (p.getX() >= 0 && p.getX() <= Ruleset.COLUMNS );
    }
    
    public static boolean isShipWithinLimits(final AbstractShip ship, final Point2d point) {
        // DIREZIONE EST ( x++ )
        int length = ship.getSize();
        
        for (int x = point.getX(); x < (point.getX() + length); x++ ) {
            if (!Ruleset.isPointWithinLimits(new Point2dImpl(x, point.getY()))) {
                return false;
            }
        }
        return true;
    }

    public static Fleet getNewFleet(){
        Fleet fleet = new Fleet();

        // Creazione di 10 navi, aggiunte alla flotta
        for (int i = 0; i < N_SUBMARINES; i++) {
            fleet.addShip(new AbstractShip.Submarine());
        }

        for (int i = 0; i < N_CRUISERS; i++) {
            fleet.addShip(new AbstractShip.Cruiser());
        }
        return fleet;
    }

    // GET BORDER LIMITS
    
    public static int getSouthernLimit() {
        return Ruleset.SOUTHERN_LIMIT;
    }
    
    public static int getEasternLimit() {
        return Ruleset.EASTERN_LIMIT;
    }
    
    public static int getRows() {
        return Ruleset.ROWS;
    }
    
    public static int getColumns() {
        return Ruleset.COLUMNS;
    }
    
    // GET - SIZE
    public static int getSubmarineSize() {
        return Ruleset.SUBMARINE_SIZE;
    }

    public static int getCruiserSize() {
        return Ruleset.CRUISER_SIZE;
    }
    
    public static int getBattleshipSize() {
        return Ruleset.BATTLESHIP_SIZE;
    }
    
    // GET - NUMBER OF
    
    public static int getSubmarinesNumber() {
        return Ruleset.N_SUBMARINES;
    }
    
    public static int getCruisersNumber() {
        return Ruleset.N_CRUISERS;
    }
}
