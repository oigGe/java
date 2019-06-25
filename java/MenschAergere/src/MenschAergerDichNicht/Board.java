package MenschAergerDichNicht;

public class Board {
    private final int SIZE = 40;
    Position[] board;


    public Board() {
        board = new Position[SIZE];
        setUpBoard();

    }







    private void setUpBoard() {
        for (int i = 0; i < board.length; i++) {
            boolean crt1 = i % 10 == 0;
            boolean crt2 = i % 10 == 9;

            if (!crt1 && !crt2) {
                board[i] = new Position(i);
            }
            if (crt1) {
                board[i] = new StartingPosition(i);

            } else if (crt2) {
                board[i] = new FinalPosition(i);
            }
        }
    }

    public Position getPositionWithValue(int value) {
        for (Position position : board) {
            if (position.getValue() == value) {
                return position;
            }
        }
        return null;
    }
}
