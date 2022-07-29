package models.war;

import common.GlobalConstants;
import models.contacts.General;
import models.contacts.Soldier;
import models.contacts.IWarMachines;

import java.util.List;
import java.util.Random;

public class Army {
    private final General general;
    private final List<Soldier> soldiers;
    private final List<IWarMachines> warMachines;
    private final int initialSoldierCapacity;
    private double armyMorale;
    private Boolean isLoseFiftySoldiers = false;
    private Boolean isLose20PercentOfAllSoldiers = false;

    public Army(General general, List<Soldier> soldiers, List<IWarMachines> warMachines) {
        this.general = general;
        this.armyMorale = GlobalConstants.ARMY_INITIAL_MORALE;
        this.soldiers = soldiers;
        this.warMachines = warMachines;
        initialSoldierCapacity = soldiers.size();
    }

    public String armyPrinter() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----General %s, %d years old with %d war knowledge!%n", general.getName(), general.getAge(), general.getWarKnowledge()));
        for (Soldier soldier : soldiers) {
            sb.append("-------" + soldier.printSoldierNameAndWeapon() + System.lineSeparator());
        }

        //sb.append(addMachinesToPrinter());

        return sb.toString();
    }

    public void attack(Army armyToAttack) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        int firstArmyIndex = 0;
        int secondArmyIndex = 0;
        int counter = 0;
        while (true) {

            Thread.sleep(10);
            System.out.printf("\rCurrent fight: Army of Democratics: %d soldiers; Army of Repiblicans: %d soldiers!", armyToAttack.getSoldiers().size(), this.getSoldiers().size());
            if (this.getSoldiers().size() == 0) {
                sb.append(String.format("\rArmy with commander %s has been defeated!%n", this.getGeneral().getName()));
                break;
            }
            if (armyToAttack.getSoldiers().size() == 0) {
                sb.append(String.format("\rArmy with commander %s has been defeated!%n", armyToAttack.getGeneral().getName()));
                break;
            }


            Soldier soldierOfArmyOne = this.getSoldiers().get(firstArmyIndex);
            Soldier soldierOfArmyTwo = armyToAttack.getSoldiers().get(secondArmyIndex);


            //Attacking each other, each iteration switching who gets to hit first!
            if (counter % 2 == 0) {
                counter++;
                soldierOfArmyOne.attackSoldier(soldierOfArmyTwo);
                if (soldierOfArmyTwo.getIsDead()) {
                    armyToAttack.getSoldiers().remove(soldierOfArmyTwo);
                    continue;
                }
                soldierOfArmyTwo.attackSoldier(soldierOfArmyOne);
                if (soldierOfArmyOne.getIsDead()) {
                    this.getSoldiers().remove(soldierOfArmyOne);
                    continue;
                }
            } else {
                counter++;
                soldierOfArmyTwo.attackSoldier(soldierOfArmyOne);
                if (soldierOfArmyOne.getIsDead()) {
                    this.getSoldiers().remove(soldierOfArmyOne);
                    continue;
                }
                soldierOfArmyOne.attackSoldier(soldierOfArmyTwo);
                if (soldierOfArmyTwo.getIsDead()) {
                    armyToAttack.getSoldiers().remove(soldierOfArmyTwo);
                    continue;
                }
            }

        }
    }

    public List<IWarMachines> getWarMachines() {
        return warMachines;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public General getGeneral() {
        return general;
    }

    private void armyMoraleChecker() {
        if (soldiers.size() <= initialSoldierCapacity - 50 && isLoseFiftySoldiers == false) {
            armyMorale200percenttIncreaser();
            isLoseFiftySoldiers = true;
        }
        if (soldiers.size() <= initialSoldierCapacity - (initialSoldierCapacity * 20 / 100) && isLoseFiftySoldiers == false) {
            int randomDigit = new Random().nextInt(0, 10);
            if (randomDigit % 10 == 5 || randomDigit % 10 == 0) {
                armyMorale200percenttIncreaser();
            }
        }
    }

    private void armyMorale200percenttIncreaser() {
        double newArmyMorale = this.armyMorale * 200 / 100 + this.armyMorale;
        this.armyMorale = newArmyMorale;
    }

    private void armyMorale5PercentDecrea() {
        double newArmyMorale = (this.armyMorale) - this.armyMorale * 5 / 100;
        this.armyMorale = newArmyMorale;
    }

    private String addMachinesToPrinter() {
        StringBuilder sb = new StringBuilder();
        for (IWarMachines machine : warMachines) {
            sb.append(String.format("-------%s {%s} with %d damage; %d durability; %.2f reload ratio!%n"
                    , machine.getName(), machine.getClass().getSimpleName(), machine.getDamage(), machine.getDurability(), machine.getReloadRatio()));
        }
        return sb.toString();
    }
}
