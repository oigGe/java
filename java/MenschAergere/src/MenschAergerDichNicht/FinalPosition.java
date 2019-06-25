package MenschAergerDichNicht;

public class FinalPosition extends Position {

    private static int counter = 1000;
    private Position[] home;
    private String playerName;

    public FinalPosition(int value) {
        super(value);
        this.home = new Position[4];
        setUpHome();

    }

    private void setUpHome() {
        for (int i = 0; i < home.length; i++) {
            home[i] = new Position(counter + i);
        }
        counter += 1000;
    }

    @Override
    public boolean isInFinalPosition(Position position) {
        for (int i = 0; i < home.length; i++) {
            if (home[i] == position) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasWon() {
        for (int i = 0; i < home.length; i++) {
            if (home[i].isEmpty()) {
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isThisFigureHome(Figure figure) {
        return isInFinalPosition(figure.getPosition());
    }

    @Override
    public Position getHomeAt(int i) {
        if (i < home.length) {
            return home[i];
        }
        return null;
    }

    @Override
    public Position[] getHome() {
        return home;
    }
}
