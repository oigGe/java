package schereSteinPapier;

import java.util.concurrent.ThreadLocalRandom;

public class Npc extends Player {
    Game game;

    public Npc() {
        super();
        this.setName("Computer");
        this.game = Game.getInstance();

    }

    @Override
    public void turn(Player p) {
        int randInput = ThreadLocalRandom.current().nextInt(1, 4);
        int input = randInputToInput(randInput);
        System.out.println("Computer chose: " + input);
        if (input == 6) {
            game.print();
            turn(p);
        } else if (input == 9) {
            System.out.println("quitting Game");
            game.rules.setRuning(false);

        } else {
            p.setInput(input);
        }

    }

    public int randInputToInput(int randInput) {
        int input = -1;
        switch (randInput) {
            case 1:
                input = 0;
                break;
            case 2:
                input = 1;
                break;
            case 3:
                input = 3;
                break;
            default:
                input = 999;
                break;
        }
        return input;
    }
}
