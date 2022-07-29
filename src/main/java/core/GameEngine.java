package core;

import core.contracts.IGameEngine;
import models.contacts.General;
import models.contacts.IWarMachines;
import models.contacts.Soldier;
import models.war.Army;
import models.war.War;
import seeders.GeneralSeeder;
import seeders.SoldierSeeder;
import seeders.WarMachineSeeder;
import services.*;

import java.util.List;
import java.util.Scanner;

public class GameEngine implements IGameEngine {
    public void engineStart(){
        War war = new War();
        Thread fight = new Thread(war);
        Scanner scanner = new Scanner(System.in);
        BattlefieldJavaEditionService service = new BattlefieldJavaEditionService();

        System.out.print("How many armies to have: ");
        int armiesCount = Integer.parseInt(scanner.nextLine());

        System.out.print("How many total soldiers have each army: ");
        int soldiersInEachArmy = Integer.parseInt(scanner.nextLine());

        System.out.print("How many total machines have each army: ");
        int machinesInEachArmy = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < armiesCount; i++) {
            General general = GeneralSeeder.generalMaker();
            List<Soldier> soldiers;
            List<IWarMachines> machines;
            if(i % 2 == 0){
                soldiers = SoldierSeeder.randomSoldierGeneratorByGivenCount(soldiersInEachArmy);
                machines = WarMachineSeeder.warMachines(machinesInEachArmy);
            }
            else{
                soldiers = SoldierSeeder.randomSoldierGeneratorByGivenCount(soldiersInEachArmy);
                machines = WarMachineSeeder.warMachines(machinesInEachArmy);
            }
            Army currentArmy = new Army(general, soldiers, machines);
            war.addArmy(currentArmy);
            System.out.println("-----------------------------------");
            if (i == armiesCount - 1){
                System.out.println();
            }
        }

        service.sortGeneralArmy(war);
        war.run();


    //    System.out.println(service.printAllArmyWeapons(war));
   // System.out.println(service.getAllArmySoldiersByWeaponType(war));
//        System.out.println(service.getOverallArmyDamage(war));
//        System.out.println(service.getAverageArmyAge(war));
//        System.out.println(service.getOverallArmyDurability(war));
//        System.out.println(service.getAllSoldiersOverSpecificAge(war, 50));
//        System.out.println(service.sortGeneralArmy(war));


    }
}
