package services;

import lombok.SneakyThrows;
import models.contacts.IWarMachines;
import models.contacts.IWeapon;
import models.contacts.Soldier;
import models.war.Army;
import models.war.War;
import services.contracts.IBattlefieldJavaEditionService;

import java.util.*;

public class BattlefieldJavaEditionService implements IBattlefieldJavaEditionService {
    @Override
    public String printAllArmyWeapons(War war) {
         return war.printArmies();
    }

    @Override
    public String getAllArmySoldiersByWeaponType(War war) {
        Map<IWeapon, ArrayList<Soldier>> weaponBySoldier = new HashMap<>();
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army currentArmy = war.getAllArmies().get(i);

            for (int j = 0; j < currentArmy.getSoldiers().size(); j++) {
                Soldier currentSoldier = currentArmy.getSoldiers().get(j);
                if (!weaponBySoldier.containsKey(currentSoldier.getWeapon())) {
                    weaponBySoldier.put(currentSoldier.getWeapon(), new ArrayList<Soldier>());
                }

                weaponBySoldier.get(currentSoldier.getWeapon()).add(currentSoldier);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (var weapon : weaponBySoldier.keySet()) {
            IWeapon currentWeapon = weapon;
            ArrayList<Soldier> soldiers = weaponBySoldier.get(weapon);
            sb.append(String.format("%n" + weapon.getName() + "%n"));
            for (Soldier soldier : soldiers) {
                sb.append("---" + soldier.printSoldierNameAndWeapon() + System.lineSeparator());
            }
        }

        return sb.toString();
    }

    @Override
    public String getOverallArmyDamage(War war) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army army = war.getAllArmies().get(i);
            double currentArmySoldiersDamage = army.getSoldiers().stream().mapToDouble(Soldier::getDamage).sum();
            double currentArmyMachinesDamage = army.getWarMachines().stream().mapToDouble(IWarMachines::getDamage).sum();
            sb.append(String.format("Army %d has overall army damage %.2f%n", i + 1, currentArmySoldiersDamage + currentArmyMachinesDamage));
        }
        return sb.toString().trim();
    }

    @Override
    public String getAverageArmyAge(War war) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army army = war.getAllArmies().get(i);
            int currentArmyAvgAge = (int) army.getSoldiers().stream().mapToDouble(Soldier::getAge).average().getAsDouble();
            sb.append(String.format("Army %d has average %d army age!%n", i + 1, currentArmyAvgAge));
        }
        return sb.toString().trim();
    }

    @Override
    public String getAllSoldiersOverSpecificAge(War war, int age) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army army = war.getAllArmies().get(i);
            List<Soldier> currentSoldiersOverSpecificAge = army.getSoldiers().stream().filter(soldier -> soldier.getAge() > age).toList();
            sb.append(String.format("%nArmy %d has %d soldiers over %d years old!%n", i + 1, currentSoldiersOverSpecificAge.size(), age));
            currentSoldiersOverSpecificAge.forEach(soldier -> sb.append(String.format("----%s%n", soldier.printSoldierNameAndWeapon())));
        }
        return sb.toString().trim();

    }

    @Override
    public String getOverallArmyDurability(War war) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army army = war.getAllArmies().get(i);
            double currentOverallArmyDurability = army.getWarMachines().stream().mapToDouble(IWarMachines::getDurability).sum();
            sb.append(String.format("Army %d has overall %.0f durability!%n", i + 1, currentOverallArmyDurability));
        }
        return sb.toString().trim();
    }

    @SneakyThrows
    @Override
    public void sortGeneralArmy(War war) {
        for (int i = 0; i < war.getAllArmies().size(); i++) {
            Army currentArmy = war.getAllArmies().get(i);
            Collections.sort(currentArmy.getSoldiers(), (firstSoldier, secondSoldier) -> {
                int sComp = secondSoldier.getClass().getSimpleName().compareTo(firstSoldier.getClass().getSimpleName());

                if (sComp != 0) {
                    return sComp;
                } else {
                    return firstSoldier.getName().compareTo(secondSoldier.getName());
                }
            });
            Collections.sort(currentArmy.getWarMachines(), (firstMachine, secondMachine) -> {
                int sComp = secondMachine.getClass().getSimpleName().compareTo(firstMachine.getClass().getSimpleName());

                if (sComp != 0) {
                    return sComp;
                } else {
                    return firstMachine.getName().compareTo(secondMachine.getName());
                }
            });
            Thread.sleep(600);
            System.out.println(String.format("Army %d's all soldiers and machines are successfully sorted!%n", i + 1));
        }
    }
}

