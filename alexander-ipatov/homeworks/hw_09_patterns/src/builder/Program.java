package builder;

import builder.builders.MageBuilder;
import builder.builders.ScoutBuilder;
import builder.builders.WarriorBuilder;

public class Program {
    public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new MageBuilder());
        Character mage = director.buildCharacter();
        System.out.println(mage);

        director.setBuilder(new ScoutBuilder());
        Character scout = director.buildCharacter();
        System.out.println(scout);

        director.setBuilder(new WarriorBuilder());
        Character warrior = director.buildCharacter();
        System.out.println(warrior);
    }
}
