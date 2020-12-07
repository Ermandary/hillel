package builder.builders;

import builder.enums.Armor;
import builder.enums.CharacterClass;
import builder.enums.Weapon;

public class MageBuilder extends CharacterBuilder {
    @Override
    public void buildCharacterClass() {
        character.setCharacterClass(CharacterClass.MAGE);
    }

    @Override
    public void buildArmor() {
        character.setArmor(Armor.LIGHT_ARMOR);
    }

    @Override
    public void buildWeapon() {
        character.setWeapon(Weapon.STUDFF);
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
        character.setIntelligence(100);
    }

    @Override
    public void buildWill() {
        character.setWill(100);
    }

    @Override
    public void buildAgility() {
        character.setAgility(10);
    }

    @Override
    public void buildSpeed() {
        character.setSpeed(10);
    }
}
