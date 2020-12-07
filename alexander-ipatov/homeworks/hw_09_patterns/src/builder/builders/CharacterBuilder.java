package builder.builders;

import builder.Character;

public abstract class CharacterBuilder {
    protected Character character;

    public void createCharacter() {
        character = new Character();
    }

    public Character getCharacter() {
        return character;
    }

    public abstract void buildCharacterClass();

    public abstract void buildArmor();

    public abstract void buildWeapon();

    public abstract void buildStrength();

    public abstract void buildHealth();

    public abstract void buildIntelligence();

    public abstract void buildWill();

    public abstract void buildAgility();

    public abstract void buildSpeed();
}

