package services.contracts;

import models.war.War;

public interface IBattlefieldJavaEditionService {

    String printAllArmyWeapons(War war);

    String getAllArmySoldiersByWeaponType(War war);

    String getOverallArmyDamage(War war);

    String getAverageArmyAge(War war);

    String getAllSoldiersOverSpecificAge(War war ,int age);

    String getOverallArmyDurability(War war);

    void sortGeneralArmy(War war);
}
