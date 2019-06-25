package schereSteinPapier;

public class Player extends Rules {
    private String name;
    private boolean turn;
    private int input;

    private int points = 0;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.turn = false;
        this.input = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
