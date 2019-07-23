package State;

import Board.Board;

public class State {

    private static State instance;
    private Board board;

    private State() {
        this.board = new Board();
    }


    public static State getInstance() {
        if (State.instance == null) {
            State.instance = new State();
        }
        return State.instance;
    }

    public Board getBoard() {
        return board;
    }
}