package schereSteinPapier;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Game game =  Game.getInstance();
        game.startComputerGame();
        game.rules.gameTurns();


    }

    public static String rand(){
       String rand="";
        for (int i = 0; i < 80; i++){
            rand +=  ThreadLocalRandom.current().nextInt(0, 2);
        }
        return rand;
    }
}

