package MenschAergerDichNicht;

public enum CreatePlayer {

    GREEN("green", getPositionAt(20), getPositionAt(19),true),
    BLUE("blue", getPositionAt(0), getPositionAt(39),false),
    YELLOW("yellow", getPositionAt(10), getPositionAt(9),true),
    RED("red", getPositionAt(30), getPositionAt(29),true);


    private String color;
    private Position startingPosition;
    private Position finalPosition;
    private Figure[] figures;
    private Boolean isAi;

    CreatePlayer(String color, Position startingPositions, Position finalPosition, Boolean isAi) {
        this.color = color;
        this.startingPosition = startingPositions;
        this.finalPosition = finalPosition;
        this.isAi = isAi;

    }


    public Player createPlayer() {
        return new Player(color, startingPosition, finalPosition,isAi);
    }


    private static Position getPositionAt(int value) {

        return State.getInstance().getBoard().getPositionWithValue(value);
    }


}

