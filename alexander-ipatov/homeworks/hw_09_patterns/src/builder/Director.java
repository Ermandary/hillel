package builder;

import builder.builders.CharacterBuilder;

public class Director {
    private CharacterBuilder builder;

    public void setBuilder(CharacterBuilder builder) {
        this.builder = builder;
    }

    public Character buildCharacter() {
        builder.createCharacter();

        builder.buildCharacterClass();
        builder.buildArmor();
        builder.buildWeapon();
        builder.buildStrength();
        builder.buildHealth();
        builder.buildIntelligence();
        builder.buildWill();
        builder.buildAgility();
        builder.buildSpeed();

        return builder.getCharacter();
    }


}
