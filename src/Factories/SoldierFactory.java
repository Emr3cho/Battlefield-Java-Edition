package Factories;

import Models.Soldiers.LongRangeSoldier;
import Models.Soldiers.MeleeSoldier;
import Models.Soldiers.Soldier;
import Models.WeaponsAndWarMachines.Weapons.LongRangeWeapon;
import Models.WeaponsAndWarMachines.Weapons.MaleeWeapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SoldierFactory {
    private static String[] firstNames = new String[]{
            "Harry", "Ross", "Bruce", "Cook", "Carolyn", "Morgan", "Albert",
            "Walker", "Randy", "Reed", "Larry", "Barnes", "Lois", "Wilson",
            "Jesse", "Campbell", "Ernest", "Rogers", "Theresa", "Patterson",
            "Henry", "Simmons", "Michelle", "Perry", "Frank", "Butler",
            "Shirley", "Marilyn", "Thompson", "Anthony", "Evans", "Julie",
            "Hall", "Paula", "Phillips", "Annie", "Hernandez", "Dorothy",
            "Murphy", "Alice","Ruth", "Jackson", "Debra", "Allen", "Gerald",
            "Harris", "Raymond", "Carter", "Jacqueline", "Torres", "Joseph",
            "Nelson", "Carlos", "Sanchez", "Ralph", "Clark", "Jean",
            "Alexander", "Stephen", "Roberts", "Eric", "Long", "Amanda",
            "Scott", "Teresa", "Diaz", "Wanda", "Thomas", "Brooks",
            "Rachel", "Edwards", "Christopher", "Perez", "Thomas", "Baker",
            "Sara", "Moore", "Chris", "Bailey", "Roger"
    };

    public static List<Soldier> randomSoldierGeneratorByGivenCount(int count) {
        List<Soldier> soldiers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            soldierMaker(soldiers);
        }

        return soldiers;
    }

    private static void soldierMaker(List<Soldier> soldiers) {
        Random random = new Random();
        List<MaleeWeapon> maleeWeapons = Arrays.stream(MaleeWeapon.values()).toList();
        List<LongRangeWeapon> longRangeWeapons = Arrays.stream(LongRangeWeapon.values()).toList();
        int randomWeaponTakeIndex = random.nextInt(0, maleeWeapons.size() - 1);
        int randomDigit = random.nextInt(0, 10);
        int nameAndLastNameRandomTakeIndex = random.nextInt(0, firstNames.length - 1);
        Soldier currentSoldier;

        String name = firstNames[nameAndLastNameRandomTakeIndex];
        nameAndLastNameRandomTakeIndex = random.nextInt(0, firstNames.length - 1);
        int age = random.nextInt(15, 70);

        if (randomDigit % 2 == 0) {
            MaleeWeapon maleeWeapon = maleeWeapons.get(randomWeaponTakeIndex);
            currentSoldier = new MeleeSoldier(name, age, maleeWeapon);
        }
        else{
            LongRangeWeapon longRangeWeapon = longRangeWeapons.get(randomWeaponTakeIndex);
            currentSoldier = new LongRangeSoldier(name, age, longRangeWeapon);
        }

        soldiers.add(currentSoldier);
    }
}
