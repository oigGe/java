package Attributes;

public abstract class Trait {
    private String name;
    private String description;
    private String command;

    public Trait(String name) {
        this.name = name;
    }

    private void setDescription(){

    }
    public abstract void applyTrait();
}
