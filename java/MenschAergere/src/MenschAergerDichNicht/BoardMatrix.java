package MenschAergerDichNicht;

public class BoardMatrix {
    private String[][] boardMatrix;


    public BoardMatrix() {
        boardMatrix = new String[11][11];
        setUpBoardMatrix();
    }

    private void setUpBoardMatrix() {
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[0].length; j++) {
                boardMatrix[i][j] = emptyField();
            }
        }
    }

    private void refreshBoardMatrix() {
        setStartingPositions();
        setBoard();
    }


    private void setBoard(){
        Board thisBoard = State.getInstance().getBoard();
        boardMatrix[4][0] = positionField(thisBoard.getPositionWithValue(10));
        boardMatrix[5][0] = positionField(thisBoard.getPositionWithValue(9));
        boardMatrix[6][0] = positionField(thisBoard.getPositionWithValue(8));

        boardMatrix[4][1] = positionField(thisBoard.getPositionWithValue(11));
        boardMatrix[6][1] = positionField(thisBoard.getPositionWithValue(7));

        boardMatrix[4][2] = positionField(thisBoard.getPositionWithValue(12));
        boardMatrix[6][2] = positionField(thisBoard.getPositionWithValue(6));

        boardMatrix[4][3] = positionField(thisBoard.getPositionWithValue(13));
        boardMatrix[6][3] = positionField(thisBoard.getPositionWithValue(5));

        boardMatrix[0][4] = positionField(thisBoard.getPositionWithValue(18));
        boardMatrix[1][4] = positionField(thisBoard.getPositionWithValue(17));
        boardMatrix[2][4] = positionField(thisBoard.getPositionWithValue(16));
        boardMatrix[3][4] = positionField(thisBoard.getPositionWithValue(15));
        boardMatrix[4][4] = positionField(thisBoard.getPositionWithValue(14));
        boardMatrix[6][4] = positionField(thisBoard.getPositionWithValue(4));
        boardMatrix[7][4] = positionField(thisBoard.getPositionWithValue(3));
        boardMatrix[8][4] = positionField(thisBoard.getPositionWithValue(2));
        boardMatrix[9][4] = positionField(thisBoard.getPositionWithValue(1));
        boardMatrix[10][4] = positionField(thisBoard.getPositionWithValue(0));

        boardMatrix[0][5] = positionField(thisBoard.getPositionWithValue(19));
        boardMatrix[10][5] = positionField(thisBoard.getPositionWithValue(39));

        boardMatrix[0][6] = positionField(thisBoard.getPositionWithValue(20));
        boardMatrix[1][6] = positionField(thisBoard.getPositionWithValue(21));
        boardMatrix[2][6] = positionField(thisBoard.getPositionWithValue(22));
        boardMatrix[3][6] = positionField(thisBoard.getPositionWithValue(23));
        boardMatrix[4][6] = positionField(thisBoard.getPositionWithValue(24));
        boardMatrix[6][6] = positionField(thisBoard.getPositionWithValue(34));
        boardMatrix[7][6] = positionField(thisBoard.getPositionWithValue(35));
        boardMatrix[8][6] = positionField(thisBoard.getPositionWithValue(36));
        boardMatrix[9][6] = positionField(thisBoard.getPositionWithValue(37));
        boardMatrix[10][6] = positionField(thisBoard.getPositionWithValue(38));

        boardMatrix[4][7] = positionField(thisBoard.getPositionWithValue(25));
        boardMatrix[6][7] = positionField(thisBoard.getPositionWithValue(33));

        boardMatrix[4][8] = positionField(thisBoard.getPositionWithValue(26));
        boardMatrix[6][8] = positionField(thisBoard.getPositionWithValue(32));

        boardMatrix[4][9] = positionField(thisBoard.getPositionWithValue(27));
        boardMatrix[6][9] = positionField(thisBoard.getPositionWithValue(31));

        boardMatrix[4][10] = positionField(thisBoard.getPositionWithValue(28));
        boardMatrix[5][10] = positionField(thisBoard.getPositionWithValue(29));
        boardMatrix[6][10] = positionField(thisBoard.getPositionWithValue(30));


    }


    private void setStartingPositions() {
        Player[] players = State.getInstance().getPlayers();
        Player blue = players[0];
        Player yellow = players[1];
        Player green = players[2];
        Player red = players[3];

        MatrixCoordinates[] blueStartCoordinates = CreateMatrixCoordinates.BLUE_START.createCoordinates();
        MatrixCoordinates[] yellowStartCoordinates = CreateMatrixCoordinates.YELLOW_START.createCoordinates();
        MatrixCoordinates[] greenStartCoordinates = CreateMatrixCoordinates.GREEN_START.createCoordinates();
        MatrixCoordinates[] redStartCoordinates = CreateMatrixCoordinates.RED_START.createCoordinates();

        MatrixCoordinates[] blueEndCoordinates = CreateMatrixCoordinates.BLUE_END.createCoordinates();
        MatrixCoordinates[] yellowEndCoordinates = CreateMatrixCoordinates.YELLOW_END.createCoordinates();
        MatrixCoordinates[] greenEndCoordinates = CreateMatrixCoordinates.GREEN_END.createCoordinates();
        MatrixCoordinates[] redEndCoordinates = CreateMatrixCoordinates.RED_END.createCoordinates();

        setStartAtCoordinates(blueStartCoordinates, blue);
        setStartAtCoordinates(yellowStartCoordinates, yellow);
        setStartAtCoordinates(greenStartCoordinates, green);
        setStartAtCoordinates(redStartCoordinates, red);

        setEndAtCoordinates(blueEndCoordinates,blue);
        setEndAtCoordinates(yellowEndCoordinates,yellow);
        setEndAtCoordinates(greenEndCoordinates,green);
        setEndAtCoordinates(redEndCoordinates,red);


    }

    private void setStartAtCoordinates(MatrixCoordinates[] coordinates, Player player) {
        for (int i = 0; i < coordinates.length; i++) {
            MatrixCoordinates thisCoordinate = coordinates[i];
            boardMatrix[thisCoordinate.getxPos()][thisCoordinate.getyPos()] = positionField(player.getStartPosition().getStartingPositions()[i]);
        }
    }

    private void setEndAtCoordinates(MatrixCoordinates[] coordinates, Player player){
        for (int i = 0; i<coordinates.length; i++){
            MatrixCoordinates thisCoordinates = coordinates[i];
            boardMatrix[thisCoordinates.getxPos()][thisCoordinates.getyPos()] = homeField(player.getFinalPosition().getHomeAt(i));
        }
    }

    public void printBoardMatrix() {
        refreshBoardMatrix();
        String outPut = "";
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[0].length; j++) {
                outPut += boardMatrix[i][j];
            }
            System.out.println(outPut);
            System.out.println("");
            outPut = "";
        }
    }

    private String emptyField() {
        return "   .   ";
    }

    private String positionField(Position position) {
        if (position.isEmpty()) {
            return "  [*]  ";
        }
        if (position.getFigure().getPlayer().getColor().matches("yellow")) {
            return " [y:" + position.getFigure().getFigureNumber() + "] ";
        }
        if (position.getFigure().getPlayer().getColor().matches("red")) {
            return " [r:" + position.getFigure().getFigureNumber() + "] ";
        }
        if (position.getFigure().getPlayer().getColor().matches("green")) {
            return " [g:" + position.getFigure().getFigureNumber() + "] ";
        }
        if (position.getFigure().getPlayer().getColor().matches("blue")) {
            return " [b:" + position.getFigure().getFigureNumber() + "] ";
        }
        return " [" + position.getFigure().getPlayer().getColor() + "] ";
    }

    private String homeField(Position position){
        if (position.isEmpty()){
            return "  (o)  ";
        }
        if (position.getFigure().getPlayer().getColor().matches("yellow")) {
            return " (y:" + position.getFigure().getFigureNumber() + ") ";
        }
        if (position.getFigure().getPlayer().getColor().matches("red")) {
            return " (r:" + position.getFigure().getFigureNumber() + ") ";
        }
        if (position.getFigure().getPlayer().getColor().matches("green")) {
            return " (g:" + position.getFigure().getFigureNumber() + ") ";
        }
        if (position.getFigure().getPlayer().getColor().matches("blue")) {
            return " (b:" + position.getFigure().getFigureNumber() + ") ";
        }
        return " (" + position.getFigure().getPlayer().getColor() + ") ";

    }
}
