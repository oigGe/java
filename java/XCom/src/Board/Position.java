package Board;

import Figure.Figure;
import State.State;

public class Position {
    int xPos;
    int yPos;
    private Position positionTop;
    private Position positionBottom;
    private Position positionLeft;
    private Position positionRight;
    private Figure figure;
    private Covers cover;

    public Position(int xPos, int yPos,int[] coverInt) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.cover = new Covers(coverInt);
    }

    public void setNeighborPos() {
        positionTop = State.getInstance().getBoard().getPosition(xPos - 1, yPos);
        positionBottom = State.getInstance().getBoard().getPosition(xPos + 1, yPos);
        positionLeft = State.getInstance().getBoard().getPosition(xPos, yPos - 1);
        positionRight = State.getInstance().getBoard().getPosition(xPos, yPos + 1);

    }


}
