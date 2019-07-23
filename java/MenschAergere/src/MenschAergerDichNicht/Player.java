package MenschAergerDichNicht;

import java.util.ArrayList;

public class Player {

    private String color;
    private ArrayList<Figure> figures;
    private Position startPosition;
    private Position finalPosition;
    private boolean isTurn;
    private boolean isAi;

    public Player(String color, Position startPosition, Position finalPosition, boolean isAi) {
        this.color = color;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        figures = new ArrayList<>();
        setUpFigures();
        isTurn = false;
        this.isAi = isAi;

    }

    public boolean isAi() {
        return isAi;
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
        //Zu implementieren: Bei 6 muss man raus.
        //im haus darf man nicht ueberspringen

        Figure thisFigure = choseFigure(whichFigure);
        if (roll == 6) {
            if (!startPosition.isAllOut() && startPosition.isEmpty()) {
                if (startPosition.isInStartingPosition(thisFigure.getPosition())) {
                    if (canMoveThere(startPosition)) {
                        thisFigure.move(startPosition);
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }

        if (thisFigure.isOnBoard()) {
            //needs a check if momentarily on final position
            if (!isFinalPositionOnPath(thisFigure.getPosition(), roll) && thisFigure.getPosition() != finalPosition) {
                if (canMoveThere(State.getInstance().getBoard().getPositionWithValue((thisFigure.getPosition()
                        .getValue() + roll) % 40))) {
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
                } else if (finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1) != null) {
                    if (canMoveThere(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1))) {
                        Position destination = finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1);
                        if (!hasToJump(thisFigure.getPosition(), destination)) {
                            thisFigure.move(destination);
                            return true;
                        }
                    }
                } else if (thisFigure.getPosition() == finalPosition) {
                    if (finalPosition.getHomeAt(roll - 1) != null) {
                        if (canMoveThere(finalPosition.getHomeAt(roll - 1))) {
                            thisFigure.move(finalPosition.getHomeAt(roll - 1));
                            return true;
                        }
                    }
                    return false;
                }
            }
        } else if (finalPosition.isThisFigureHome(thisFigure)) {
            if (finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll) != null) {
                if (canMoveThere(finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll))) {
                    if (!hasToJump(thisFigure.getPosition(), finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll))) {
                        thisFigure.move(finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll));
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean canMoveFigure(int whichFigure, int roll) {
        Figure thisFigure = choseFigure(whichFigure);
        if (roll == 6) {
            if (!startPosition.isAllOut() && startPosition.isEmpty()) {
                if (startPosition.isInStartingPosition(thisFigure.getPosition())) {
                    if (canMoveThere(startPosition)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }

        if (thisFigure.isOnBoard()) {
            //home needs to be checked for on the way
            if (!isFinalPositionOnPath(thisFigure.getPosition(), roll) && thisFigure.getPosition() != finalPosition) {
                if (canMoveThere(State.getInstance().getBoard().getPositionWithValue((thisFigure.getPosition().getValue() + roll) % 40))) {

                    return true;
                }
            } else {
                //landing directly on final position
                if (movesRemainingOnFinal(thisFigure.getPosition(), roll) == 0) {

                    return true;
                    //landing in home and the position is free
                } else if (finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1) != null) {
                    if (canMoveThere(finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1))) {
                        Position destination = finalPosition.getHomeAt(movesRemainingOnFinal(thisFigure.getPosition(), roll) - 1);
                        if (!hasToJump(thisFigure.getPosition(), destination)) {
                            return true;
                        }
                    }
                } else if (thisFigure.getPosition() == finalPosition) {
                    if (finalPosition.getHomeAt(roll - 1) != null) {
                        if (canMoveThere(finalPosition.getHomeAt(roll - 1))) {
                            return true;
                        }
                    }
                    return false;
                }
            }

        } else if (finalPosition.isThisFigureHome(thisFigure)) {
            if (finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll) != null) {
                if (canMoveThere(finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll))) {
                    if (!hasToJump(thisFigure.getPosition(), finalPosition.getHomeAt(thisFigure.getPosition().getValue() + roll))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasToJump(Position thisPosition, Position destination) {
        if (finalPosition.isInFinalPosition(thisPosition)) {
            int x = thisPosition.getValue();
            for (int i = x + 1; i < 3; i++) {
                if (finalPosition.getHome()[i] == destination) {
                    return false;
                }
                if (!finalPosition.getHome()[i].isEmpty()) {
                    return true;
                }
            }
        } else {
            for (Position position : finalPosition.getHome()) {
                if (position == destination) {
                    return false;
                }
                if (!position.isEmpty()) {
                    return true;
                }
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

    public int bestMove(int roll) {
        int minSteps = Integer.MAX_VALUE - 1;
        int thisFigure = -1;
        if (!startPosition.isEmpty() && startPosition.getFigure().getPlayer() == this) {
            if (canMoveFigure(startPosition.getFigure().getFigureNumber() - 1, roll)) {
                return startPosition.getFigure().getFigureNumber();
            }
        }
        int canBeat = canBeat(roll);
        if (canBeat != -1) {
            return canBeat;
        }
        for (Figure figure : figures) {
            if (canMoveFigure(figure.getFigureNumber() - 1, roll)) {
                int thisSteps = stepsTillHome(figure);
                if (thisSteps < minSteps) {
                    thisFigure = figure.getFigureNumber();
                }
            }
        }
        return thisFigure;
    }

    private int canBeat(int roll) {
        for (Figure figure : figures) {
            if (canMoveFigure(figure.getFigureNumber() - 1, roll)) {
                if (!isFinalPositionOnPath(figure.getPosition(), roll)) {
                    if (!State.getInstance().getBoard().getPositionWithValue
                            ((figure.getPosition().getValue() + roll) % 40).isEmpty()) {
                        return figure.getFigureNumber();
                    }
                }
            }
        }
        return -1;
    }


    public int stepsTillHome(Figure figure) {
        if (!finalPosition.isThisFigureHome(figure)) {
            for (int i = 0; i < 40; i++) {
                if (State.getInstance().getBoard().getPositionWithValue((figure.getPosition().getValue() + i) % 40)
                        == finalPosition) {
                    return i + 4;
                }
            }
        }
        if (startPosition.isInStartingPosition(figure.getPosition())) {
            return 40;
        }
        if (finalPosition.isThisFigureHome(figure)) {
            return 3 - figure.getPosition().getValue();
        }
        return Integer.MAX_VALUE;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
