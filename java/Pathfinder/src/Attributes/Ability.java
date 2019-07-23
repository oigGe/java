package Attributes;

public class Ability {
    private int abilityScore;
    private int abilityModifier;
    private int temporaryAdjustment;
    private int temporaryModifier;

    public Ability(int abilityScore) {
        this.abilityScore = abilityScore;
        this.abilityModifier = calcAbilityModifier(abilityScore);
    }

    public int calcAbilityModifier(int abilityScore) {
        int mod = 0;
        if (abilityScore % 2 != 0) {
            mod = 1;
        }
        return (abilityScore - 10) / 2 + mod;
    }

    private void refreshModifier(){
      abilityModifier =  calcAbilityModifier(abilityScore
              + temporaryAdjustment + temporaryModifier);
    }
}
