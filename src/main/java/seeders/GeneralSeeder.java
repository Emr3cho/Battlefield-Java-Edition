package seeders;

import models.contacts.General;
import models.generals.ArmyGeneral;

import java.util.Random;

public class GeneralSeeder {
    private static String[] names = new String[]{
            "Adam", "Alex", "Aaron", "Ben", "Carl",
            "Dan", "David", "Edward", "Fred", "Frank",
            "George", "Hal", "Hank", "Ike", "John",
            "Jack", "Joe", "Larry", "Monte", "Matthew",
            "Mark", "Nathan", "Otto", "Paul", "Peter",
            "Roger", "Roger", "Steve", "Thomas", "Tim",
            "Ty", "Victor", "Walter"};

    public static General generalMaker() {
        Random random = new Random();
        String name = names[random.nextInt(0, names.length - 1)];
        int age = random.nextInt(20,80);
        int warKnowledge = random.nextInt(1,100);

        return new ArmyGeneral(name, age, warKnowledge);
    }
}
