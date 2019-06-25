package MenschAergerDichNicht;

public class Position {
    private Figure figure;
    private boolean isEmpty;
    private int value;

    public Position(int value) {
        this.value = value;
        isEmpty = true;
    }

    public int getValue() {
        return value;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        this.isEmpty = false;
    }

    public void removeFigure() {
        this.figure = null;
        this.isEmpty = true;
    }

    public void setUpFigures(Player player) {

    }

    public Position[] getStartingPositions() {
        return null;
    }

    public boolean isInStartingPosition(Position position) {
        return false;
    }

    //this is wrong
    public boolean isInFinalPosition(Position position) {
        return false;
    }

    public boolean hasFigureOut() {
        return false;
    }

    public boolean hasWon() {
        return false;
    }

    public Figure getFigure() {
        return figure;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isThisFigureOut (Figure figure){
        return false;
    }

    public boolean isThisFigureHome(Figure figure){
        return false;
    }

    public Position getHomeAt(int i) {
        return null;
    }

    public Position[] getHome(){
        return null;
    }
}
