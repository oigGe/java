package MenschAergerDichNicht;

public class Figure {
    private Player player;
    private int figureNumber;
    private Position position;
    private boolean isOnBoard;


    public Figure(Player player, int figureNumber, Position position) {
        this.player = player;
        this.figureNumber = figureNumber;
        this.position = position;
        this.isOnBoard = false;
    }

    public boolean isOnBoard() {
        return isOnBoard;
    }

    private boolean isInStartingPosition() {
        return player.getStartPosition().isInStartingPosition(position);
    }

    private boolean isHome() {
        return player.getFinalPosition().isInFinalPosition(position);
    }

    public void move(Position newPosition) {
        if (!isPositionEmpty(newPosition)) {
            newPosition.getFigure().beatFigure();
        }
        this.position.removeFigure();
        setPosition(newPosition);
        newPosition.setFigure(this);
        if (player.getStartPosition().isInStartingPosition(newPosition) || player.getFinalPosition().isInFinalPosition(position)) {
            isOnBoard = false;
        } else {
            isOnBoard = true;
        }
    }


    public void beatFigure() {
        move(player.getStartPosition().getStartingPositions()[figureNumber - 1]);
        System.out.println("Figure " + figureNumber + " from Player " + player.getColor() + " was beaten.");
    }

    private boolean isPositionEmpty(Position position) {
        return position.isEmpty();
    }

    private void setPosition(Position newPosition) {
        position.removeFigure();
        this.position = newPosition;
        position.setFigure(this);
    }


    public Player getPlayer() {
        return player;
    }

    public int getFigureNumber() {
        return figureNumber;
    }

    public Position getPosition() {
        return position;
    }
}
