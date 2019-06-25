package schereSteinPapier;

import java.util.Scanner;

public class Rules {

    private int schere = 0;
    private int stein = 1;
    private int papier = 3;
    private boolean isRuning = true;
    Game game = Game.getInstance();
    Player playerA = game.playerA;
    Player playerB = game.playerB;
    Scanner scanner = new Scanner(System.in);


    public void win(Player playerA, Player playerB) {
        int playerAInput = playerA.getInput();
        int playerBInput = playerB.getInput();
        int combinedInput = playerAInput + playerBInput;
        switch (combinedInput) {
            case 0:
            case 2:
            case 6:
            default:
                System.out.println("unentschieden");
                break;
            case 1:

                if (playerAInput == stein) {

                    playerA.setPoints(playerA.getPoints() + 1);
                    System.out.println(playerA.getName() + " gewinnt");
                } else {

                    playerB.setPoints(playerB.getPoints() + 1);
                    System.out.println(playerB.getName() + " gewinnt");
                }
                break;
            case 3:

                if (playerAInput == schere) {

                    playerA.setPoints(playerA.getPoints() + 1);
                    System.out.println(playerA.getName() + " gewinnt");
                } else {

                    playerB.setPoints(playerB.getPoints() + 1);
                    System.out.println(playerB.getName() + " gewinnt");
                }
                break;
            case 4:

                if (playerAInput == papier) {

                    playerA.setPoints(playerA.getPoints() + 1);
                    System.out.println(playerA.getName() + " gewinnt");
                } else {

                    playerB.setPoints(playerB.getPoints() + 1);
                    System.out.println(playerB.getName() + " gewinnt");

                }
                break;
        }
    }

    public void gameTurns() {
        System.out.println("0 for Scissors; 1 for Stone; 3 for Paper");

        while (isRuning) {
            turn(playerA);
            if (isRuning) {
                if (playerB.getClass() == playerA.getClass()){
                turn(playerB);}
                else {
                    playerB.turn(playerB);
                }

                win(playerA, playerB);
            }


        }
    }

    public void turn(Player p) {
        System.out.println(p.getName() + " Turn : ");
        int input = scanner.nextInt();
        if (input == 6) {
            game.print();
            turn(p);
        } else if (input == 9) {
            System.out.println("quitting Game");
            isRuning = false;

        } else {
            p.setInput(input);
        }
    }

    public boolean isRuning() {
        return isRuning;
    }

    public void setRuning(boolean runing) {
        isRuning = runing;
    }
}
