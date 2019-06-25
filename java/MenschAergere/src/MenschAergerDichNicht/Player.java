package MenschAergerDichNicht;

import java.util.ArrayList;

public class Player {

    private String color;
    private ArrayList<Figure> figures;
    private Position startPosition;
    private Position finalPosition;
    private boolean isTurn;

    public Player(String color, Position startPosition, Position finalPosition) {
        this.color = color;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        figures = new ArrayList<>();
        setUpFigures();
        isTurn = false;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    private void setUpFigures() {
        startPosition.setUpFigures(this);

    }

    public boolean moveFigure(int whichFigure, int roll) {
        Figure thisFigure = choseFigure(whichFigure);
        if (thisFigure.isOnBoard()) {
            //needs a check if momentarily on final position
            if (!isFinalPositionOnPath(thisFigure.getPosition(), roll)) {
                if (canMoveThere(State.getInstance().getBoard().getPositionWithValue((thisFigure.getPosition().getValue() + roll) % 40))) {
                    thisFigure.move(State.getInstance().getBoard().getPositionWithValue
                            ((thisFigure.getPosition().getValue() + roll) % 40));
                    return true;
                }
            } else {
                //landing directly on final position
                if (movesRemainingOnFinal(thisFigure.getPosition(), roll) == 0) {
                    thisFigure.move(finalPosition);
                    return true;
                    //landing in home and the position is free
                } else if (canMoveThere(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1))) {
                    thisFigure.move(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1));
                    return true;
                }
            }
        } else if (!thisFigure.isOnBoard() || !isOut()) {
            if (roll == 6) {
                thisFigure.move(startPosition);
                return true;
            }
        } else if (finalPosition.isThisFigureHome(thisFigure)) {
            //very flawed. roll needs to be added to current position in home. Same problem in the can move method
            if (canMoveThere(finalPosition.getHomeAt(roll-1))) {
                thisFigure.move(finalPosition.getHomeAt(roll-1));
                return true;
            }
        }
        return false;
    }


    public boolean canMoveFigure(int whichFigure, int roll) {
        Figure thisFigure = choseFigure(whichFigure);
        if (thisFigure.isOnBoard()) {
            //home needs to be checked for on the way
            if (!isFinalPositionOnPath(thisFigure.getPosition(), roll)) {
                if (canMoveThere(State.getInstance().getBoard().getPositionWithValue((thisFigure.getPosition().getValue() + roll) % 40))) {

                    return true;
                }
            } else {
                //landing directly on final position
                if (movesRemainingOnFinal(thisFigure.getPosition(), roll) == 0) {

                    return true;
                    //landing in home and the position is free
                } else if (canMoveThere(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll)))) {
                    return true;
                }
            }
        } else if (!thisFigure.isOnBoard() || !isOut()) {
            if (roll == 6) {
                return true;
            }
        } else if (finalPosition.isThisFigureHome(thisFigure)) {
            // siehe oben PROBLEM
            if (canMoveThere(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll)))) {
                return true;
            }
        }
        return false;
    }

    private boolean canMoveThere(Position position) {
        if (position.isEmpty()) {
            return true;
        } else if (position.getFigure().getPlayer() == this) {
            return false;
        }
        return true;
    }

    private boolean isFinalPositionOnPath(Position currentPosition, int roll) {
        for (int i = 1; i <= roll; i++) {
            if (State.getInstance().getBoard().getPositionWithValue((currentPosition.getValue() + i) % 40)
                    == finalPosition) {
                return true;
            }
        }
        return false;
    }

    //method for remainig moves after hit final position
    private int movesRemainingOnFinal(Position currentPosition, int roll) {
        for (int i = 1; i <= roll; i++) {
            if (State.getInstance().getBoard().getPositionWithValue((currentPosition.getValue() + i) % 40)
                    == finalPosition) {
                return roll - i;
            }
        }
        return -1;
    }

    public boolean isOut() {
        return startPosition.hasFigureOut();
    }

    // get figure with int 0-3
    public Figure choseFigure(int whichFigure) {
        return figures.get(whichFigure);
    }

    public void addFigure(Figure newFigure) {
        figures.add(newFigure);
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getFinalPosition() {
        return finalPosition;
    }

    public boolean hasWon() {
        for (Position position : finalPosition.getHome()) {
            if (position.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
