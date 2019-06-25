package MenschAergerDichNicht;

public class State {

    private static State instance;
    private static final int NUMBER_OF_PLAYERS = 4;
    private Board board;
    private Player[] players;
    private BoardMatrix boardMatrix;

    private State() {
        this.board = new Board();
        this.boardMatrix = new BoardMatrix();
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }


    public void setUpPlayers() {
        Player blue = CreatePlayer.BLUE.createPlayer();
        Player yellow = CreatePlayer.YELLOW.createPlayer();
        Player green = CreatePlayer.GREEN.createPlayer();
        Player red = CreatePlayer.RED.createPlayer();
        Player[] newPlayers = {blue,yellow,green,red};
        this.players = newPlayers;
    }


    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public BoardMatrix getBoardMatrix() {
        return boardMatrix;
    }
}
