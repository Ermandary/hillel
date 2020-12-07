package builder.builders;

import builder.enums.Armor;
import builder.enums.CharacterClass;
import builder.enums.Weapon;

public class WarriorBuilder extends CharacterBuilder {
    @Override
    public void buildCharacterClass() {
        character.setCharacterClass(CharacterClass.WARRIOR);
    }

    @Override
    public void buildArmor() {
        character.setArmor(Armor.HEAVY_ARMOR);
    }

    @Override
    public void buildWeapon() {
        character.setWeapon(Weapon.SWORD);
    }

    @Override
    public void buildStrength() {
        character.setStrength(100);
    }

    @Override
    public void buildHealth() {
        character.setHealth(100);
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
        character.setAgility(10);
    }

    @Override
    public void buildSpeed() {
        character.setSpeed(20);
    }
}
