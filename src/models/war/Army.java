package models.war;

import common.GlobalConstants;
import models.contacts.General;
import models.contacts.Soldier;
import models.contacts.IWarMachines;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Army {
    private final General general;
    private final List<Soldier> soldiers;
    private final List<IWarMachines> warMachines;
    private final int initialSoldierCappacity;
    private double armyMorale;
    private Boolean isLosedFiftySoldiers = false;
    private Boolean isLosed20ProcentOfAllSoldiers = false;

    public Army(General general, List<Soldier> soldiers, List<IWarMachines> warMachines) {
        this.general = general;
        this.armyMorale = GlobalConstants.ARMY_INITIAL_MORALE;
        this.soldiers = soldiers;
        this.warMachines = warMachines;
        initialSoldierCappacity = soldiers.size();
    }

    public List<IWarMachines> getWarMachines() {
        return warMachines;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    private void armyMoraleChecker() {
        if (soldiers.size() <= initialSoldierCappacity - 50 && isLosedFiftySoldiers == false) {
            armyMorale200percenttIncreaser();
            isLosedFiftySoldiers = true;
        }
        if (soldiers.size() <= initialSoldierCappacity - (initialSoldierCappacity * 20 / 100) && isLosedFiftySoldiers == false) {
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
    private void armyMorale5PercentDecreaser() {
        double newArmyMorale =  (this.armyMorale) - this.armyMorale * 5 / 100;
        this.armyMorale = newArmyMorale;
    }

    public String armyPrinter(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----General %s, %d years old with %d war knowledge!%n", general.getName(), general.getAge(), general.getWarKnowledge()));
        for (Soldier soldier : soldiers) {
            sb.append("-------" + soldier.printSoldierNameAndWeapon() + System.lineSeparator());
        }

        //sb.append(addMachinesToPrinter());

        return sb.toString();
    }

    private String addMachinesToPrinter(){
        StringBuilder sb = new StringBuilder();
        for (IWarMachines machine : warMachines) {
            sb.append(String.format("-------%s {%s} with %d damage; %d durability; %.2f reload ratio!%n"
                    , machine.getName(), machine.getClass().getSimpleName(), machine.getDamage(), machine.getDurability(), machine.getReloadRatio()));
        }
        return sb.toString();
    }




}
