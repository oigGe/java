package Race;

public class Elf extends Race {

    private final String SIZE = "M";
    private final int SPEED = 9;

    public Elf() {
    }

    @Override
    int getSpeed() {
        return this.SPEED;
    }

    @Override
    String getSize() {
        return this.SIZE;
    }


}
