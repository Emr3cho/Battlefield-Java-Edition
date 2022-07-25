package Models;

import GlobalConstansts.PublicConstants;
import Models.Generals.General;
import Models.Soldiers.Soldier;
import Models.WeaponsAndWarMachines.Machines.IWarMachines;

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

    public Army(General general, int armyMorale, List<Soldier> soldiers, List<IWarMachines> warMachines) {
        this.general = general;
        this.armyMorale = PublicConstants.ARMY_INITIAL_MORALE;
        this.soldiers = soldiers;
        this.warMachines = warMachines;
        initialSoldierCappacity = soldiers.size();
    }

    private void armyMoraleChecker() {
        if (soldiers.size() <= initialSoldierCappacity - 50 && isLosedFiftySoldiers == false) {
            armyMorale200ProcentIncreaser();
            isLosedFiftySoldiers = true;
        }
        if (soldiers.size() <= initialSoldierCappacity - (initialSoldierCappacity * 20 / 100) && isLosedFiftySoldiers == false) {
            int randomDigit = new Random().nextInt(0, 10);
            if (randomDigit % 10 == 5 || randomDigit % 10 == 0) {
                armyMorale200ProcentIncreaser();
            }
        }
    }

    private void armyMorale200ProcentIncreaser() {
        double newArmyMorale = this.armyMorale * 200 / 100 + this.armyMorale;
        this.armyMorale = newArmyMorale;
    }
    private void armyMorale5ProcentDecreaser() {
        double newArmyMorale =  (this.armyMorale) - this.armyMorale * 5 / 100;
        this.armyMorale = newArmyMorale;
    }


}
