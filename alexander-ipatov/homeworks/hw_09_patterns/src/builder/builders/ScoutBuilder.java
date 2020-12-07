package builder.builders;

import builder.enums.Armor;
import builder.enums.CharacterClass;
import builder.enums.Weapon;

public class ScoutBuilder extends CharacterBuilder {
    @Override
    public void buildCharacterClass() {
        character.setCharacterClass(CharacterClass.SCOUT);
    }

    @Override
    public void buildArmor() {
        character.setArmor(Armor.MEDIUM_ARMOR);
    }

    @Override
    public void buildWeapon() {
        character.setWeapon(Weapon.BOW);
    }

    @Override
    public void buildStrength() {
        character.setStrength(20);
    }

    @Override
    public void buildHealth() {
        character.setHealth(50);
    }

    @Override
    public void buildIntelligence() {
        character.setIntelligence(10);
    }

    @Override
    public void buildWill() {
        character.setWill(10);
    }

    @Override
    public void buildAgility() {
        character.setAgility(100);
    }

    @Override
    public void buildSpeed() {
        character.setSpeed(100);
    }
}
