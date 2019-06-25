package MenschAergerDichNicht;

public enum CreatePlayer {

    GREEN("green", getPositionAt(20), getPositionAt(19)),
    BLUE("blue", getPositionAt(0), getPositionAt(39)),
    YELLOW("yellow", getPositionAt(10), getPositionAt(9)),
    RED("red", getPositionAt(30), getPositionAt(29));


    private String color;
    private Position startingPosition;
    private Position finalPosition;
    private Figure[] figures;

    CreatePlayer(String color, Position startingPositions, Position finalPosition) {
        this.color = color;
        this.startingPosition = startingPositions;
        this.finalPosition = finalPosition;

    }


    public Player createPlayer() {
        return new Player(color, startingPosition, finalPosition);
    }


    private static Position getPositionAt(int value) {

        return State.getInstance().getBoard().getPositionWithValue(value);
    }


}

