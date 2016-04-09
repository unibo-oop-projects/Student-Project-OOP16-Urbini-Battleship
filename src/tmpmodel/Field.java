package tmpmodel;


public class Field {
    private final FieldCell[][] matrix;
    private final int rows;
    private final int columns; 
    
    public Field(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new FieldCell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new FieldCell(State.WATER);
            }
        }
    }

    public void updateStateWithShot(final Shot shot) {
        Point2d p = shot.getPoint();
        int x = p.getX();
        int y = p.getY();
        
        if (matrix[x][y].getCurrentState() == State.PRESENT ) {
            matrix[x][y].setState(State.HIT);
        } else {
            matrix[x][y].setState(State.MISSED);
        }
    }

    public void placeShip(final AbstractShip ship) {
        for ( final Point2d point : ship.getAllPositions() ) {
            matrix[point.getX()][point.getY()].setState(State.PRESENT);
        }
    }

    public boolean isShipSunk(final AbstractShip s) {
        // Il controllo potrebbe esser fatto su Field
        return s.isSunk();
    }
}
