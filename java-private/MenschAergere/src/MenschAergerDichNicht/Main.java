package MenschAergerDichNicht;

public class Main {
    public static void main(String[] args) {

        State state = State.getInstance();
        state.setUpPlayers();
        PlayGame.Play();

    }
}
