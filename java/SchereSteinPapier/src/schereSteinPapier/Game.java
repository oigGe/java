package schereSteinPapier;

import java.util.Scanner;

public class Game {
    private static Game ourInstance = new Game();


    Player playerA;
    Player playerB;
    Rules rules;
    String name1;
    String name2;
    Scanner scanner = new Scanner(System.in);


    public static Game getInstance() {

        return ourInstance;
    }


    private Game() {
        this("PlayerA", "PlayerB");
    }


    private Game(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;


    }



    public void print() {
        System.out.println(playerA.getName() + " Points: " + playerA.getPoints());
        System.out.println(playerB.getName() + " Points: " + playerB.getPoints());
    }

    public void setPlayerName(String name, Player p) {
        p.setName(name);
    }

    public void startGame() {
        this.playerA = new Player(name1);
        this.playerB = new Player(name2);
        this.rules = new Rules();

        System.out.println("Player 1 name: ");
        setPlayerName(scanner.next(), playerA);

        System.out.println("Player 2 name: ");
        setPlayerName(scanner.next(), playerB);

        System.out.println(" Hello " + playerA.getName() + " and " +
                playerB.getName());
    }

    public void startComputerGame(){
        this.playerA = new Player(name1);
        this.playerB = new Npc();
        this.rules = new Rules();


        System.out.println("Player 1 name: ");

        setPlayerName(scanner.next(),playerA);
        System.out.println(" Hello " + playerA.getName() + " and " +
                playerB.getName());
    }

}
