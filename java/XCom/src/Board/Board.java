package Board;

public class Board {

    private Position[][] board;
    public final int SIZE = 10;

    public Board() {
        this.board = new Position[SIZE][SIZE];
    }

    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Position(i, j,Tiles.RAND.getCoverInt());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setNeighborPos();
            }
        }
    }

    public Position getPosition(int xPos, int yPos) {
        try {
            return board[xPos][yPos];
        } catch (NullPointerException| ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
