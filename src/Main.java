import Factories.SoldierFactory;
import Models.Soldiers.Soldier;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Soldier> soldiers = SoldierFactory.randomSoldierGeneratorByGivenCount(10);
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.printSoldierNameAndWeapon());
        }
    }
}
