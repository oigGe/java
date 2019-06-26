package MenschAergerDichNicht;

public class PlayGame {

    private static final String ROLL_REGEX = "roll";
    private static final String QUIT_REGEX = "quit";
    private static int turnCount = 1;
    private static boolean isRunning = true;
    private static Player thisPlayer;
    private static boolean hasWinner = false;

    public static void Play() {
        thisPlayer = State.getInstance().getPlayers()[0];

        while (isRunning) {
            State.getInstance().getBoardMatrix().printBoardMatrix();
            System.out.println("Player " + thisPlayer.getColor() + " has turn.");
            int roll = rollPhase();
            if (roll == -1) {
                continue;
            }

            movePhase(roll);
            if (roll != 6) {
                switchTurn();
            }
            try{

                Thread.sleep(00);
            }catch(InterruptedException ex){
                //do stuff
            }

            if (hasWinner) {
                System.out.println("Turn count: " + turnCount);
                System.out.println("Game closed");
                isRunning = false;
            }
        }
    }

    private static int rollPhase() {
        while (isRunning) {
            String input;
            if (!thisPlayer.isAi()) {
                System.out.println("Player " + thisPlayer.getColor() + " ,please roll");
                input = edu.kit.informatik.Terminal.readLine();
            } else {
                input = ROLL_REGEX;
            }
            if (input.matches(ROLL_REGEX)) {
                if (thisPlayer.isOut()) {
                    int roll = Dice.roll();
                    System.out.println("Player " + thisPlayer.getColor() + " rolled a " + roll);
                    return roll;
                } else {
                    int counter = 0;
                    int roll = Dice.roll();
                    if (roll == 6) {
                        System.out.println("Player " + thisPlayer.getColor() + " rolled a " + roll);
                        return roll;
                    }
                    while (roll != 6 && counter < 2) {
                        System.out.println("Player " + thisPlayer.getColor() + " rolled a " + roll + "" +
                                ". Please roll again.");
                        String input2;
                        if (!thisPlayer.isAi()) {
                             input2 = edu.kit.informatik.Terminal.readLine();
                        }else {
                            input2 = ROLL_REGEX;
                        }
                        if (input2.matches(ROLL_REGEX)) {
                            roll = Dice.roll();
                            if (roll == 6) {
                                System.out.println("Player " + thisPlayer.getColor() + " rolled a " + roll);
                                return roll;
                            }
                            counter++;
                        } else if (input2.matches(QUIT_REGEX)) {
                            isRunning = false;
                            break;
                        } else {
                            System.out.println("Error, invalid command");
                        }
                    }
                    System.out.println("Player " + thisPlayer.getColor() + " rolled a " + roll + ". Player cant Move");
                    switchTurn();
                    return -1;
                }
            } else if (input.matches(QUIT_REGEX)) {
                isRunning = false;
                break;
            } else {
                System.out.println("Error, invalid command");
            }
        }
        return -1;
    }

    private static void movePhase(int roll) {
        while (isRunning) {
            if (canMove(roll)) {
                int input;
                if (!thisPlayer.isAi()) {
                    System.out.println("Which figure should be moved?");
                    input = Integer.parseInt(edu.kit.informatik.Terminal.readLine());
                }else {
                    input = thisPlayer.bestMove(roll);
                }
                if (input > 0 && input <= 4) {
                    if (thisPlayer.moveFigure(input - 1, roll)) {
                        System.out.println("Figure was moved");
                        if (thisPlayer.hasWon()) {
                            hasWinner = true;
                            System.out.println("Player " + thisPlayer.getColor() + " has won.");
                        }
                        break;
                    } else {
                        System.out.println("You cant move this figure.");
                    }

                } else {
                    System.out.println("Error, invalid input.");
                }
            } else {
                System.out.println("You cant move");
                break;
            }
        }
    }

    private static boolean canMove(int roll) {
        for (Figure figure : thisPlayer.getFigures()) {
            if (thisPlayer.canMoveFigure(figure.getFigureNumber() - 1, roll)) {
                return true;
            }
        }
        return false;
    }


    private static void switchTurn() {
        State.getInstance().getPlayers()[(turnCount - 1) % 4].setTurn(false);
        State.getInstance().getPlayers()[turnCount % 4].setTurn(true);
        thisPlayer = State.getInstance().getPlayers()[turnCount % 4];
        turnCount++;
    }
}
