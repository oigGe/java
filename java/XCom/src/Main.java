import Board.Tiles;
import State.State;

public class Main {
    public static void main(String[] args) {
        State state = State.getInstance();
        state.getBoard().initBoard();
        System.out.println("lol");
        for (int i = 0; i < 100; i++){
            System.out.println( Tiles.getRNDINT());
        }

    }
}
