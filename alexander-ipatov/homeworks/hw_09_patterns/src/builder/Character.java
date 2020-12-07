package builder;

import builder.enums.Armor;
import builder.enums.CharacterClass;
import builder.enums.Weapon;

public class Character {
    private CharacterClass characterClass;
    private Armor armor;
    private Weapon weapon;
    private int strength;
    private int health;
    private int intelligence;
    private int will;
    private int agility;
    private int speed;


    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "builder.Character{" +
                "characterClass=" + characterClass +
                ", armor=" + armor +
                ", weapon=" + weapon +
                ", strength=" + strength +
                ", health=" + health +
                ", intelligence=" + intelligence +
                ", will=" + will +
                ", agility=" + agility +
                ", speed=" + speed +
                '}';
    }
}
