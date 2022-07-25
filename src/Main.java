import Models.Generals.ArmyGeneral;
import Models.Generals.General;
import Models.Soldiers.MeleeSoldier;
import Models.Soldiers.Soldier;

public class Main {
    public static void main(String[] args) {

        Soldier soldier = new MeleeSoldier("ccs", 16, 20.0, 100);
        General general = new ArmyGeneral(12);
    }
}
