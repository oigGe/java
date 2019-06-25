package MenschAergerDichNicht;

public class StartingPosition extends Position {

    private Position[] startingPositions;
    private static int counter = 100;
    private Player player;

    public StartingPosition(int value) {
        super(value);
        startingPositions = new Position[4];
        setUpStartingPositions();
    }


    private void setUpStartingPositions() {
        for (int i = 0; i < startingPositions.length; i++) {
            startingPositions[i] = new Position(counter + i);
        }
        counter += 100;
    }

    @Override
    public void setUpFigures(Player player) {
        int i = 1;
        for (Position position : startingPositions) {
            Figure newFigure = new Figure(player, i, position);
            position.setFigure(newFigure);
            player.addFigure(newFigure);
            i++;
        }
    }

    @Override
    public Position[] getStartingPositions() {
        return startingPositions;
    }

    @Override
    public boolean isInStartingPosition(Position position) {
        for (int i = 0; i < startingPositions.length; i++) {
            if (startingPositions[i] == position) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasFigureOut() {
        for (int i = 0; i < startingPositions.length; i++) {
            if (startingPositions[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }


}
