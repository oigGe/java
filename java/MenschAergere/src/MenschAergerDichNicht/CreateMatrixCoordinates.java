package MenschAergerDichNicht;

public enum CreateMatrixCoordinates {
    BLUE_START(new MatrixCoordinates(9, 0), new MatrixCoordinates(10, 0),
            new MatrixCoordinates(9, 1), new MatrixCoordinates(10, 1)),
    YELLOW_START(new MatrixCoordinates(0, 0), new MatrixCoordinates(1, 0),
            new MatrixCoordinates(0, 1), new MatrixCoordinates(1, 1)),
    GREEN_START(new MatrixCoordinates(0, 9), new MatrixCoordinates(1, 9),
            new MatrixCoordinates(0, 10), new MatrixCoordinates(1, 10)),
    RED_START(new MatrixCoordinates(9, 9), new MatrixCoordinates(10, 9),
            new MatrixCoordinates(9, 10), new MatrixCoordinates(10, 10)),
    BLUE_END(new MatrixCoordinates(9, 5), new MatrixCoordinates(8, 5),
            new MatrixCoordinates(7, 5), new MatrixCoordinates(6, 5)),
    YELLOW_END(new MatrixCoordinates(5, 1), new MatrixCoordinates(5, 2),
            new MatrixCoordinates(5, 3), new MatrixCoordinates(5, 4)),
    GREEN_END(new MatrixCoordinates(1, 5), new MatrixCoordinates(2, 5),
            new MatrixCoordinates(3, 5), new MatrixCoordinates(4, 5)),
    RED_END(new MatrixCoordinates(5, 9), new MatrixCoordinates(5, 8),
            new MatrixCoordinates(5, 7), new MatrixCoordinates(5, 6));


    private MatrixCoordinates coordinates1;
    private MatrixCoordinates coordinates2;
    private MatrixCoordinates coordinates3;
    private MatrixCoordinates coordinates4;

    CreateMatrixCoordinates(MatrixCoordinates coordinates1, MatrixCoordinates coordinates2, MatrixCoordinates coordinates3, MatrixCoordinates coordinates4) {
        this.coordinates1 = coordinates1;
        this.coordinates2 = coordinates2;
        this.coordinates3 = coordinates3;
        this.coordinates4 = coordinates4;
    }



    public MatrixCoordinates[] createCoordinates() {
        return new MatrixCoordinates[]{coordinates1, coordinates2, coordinates3, coordinates4};

    }

}

