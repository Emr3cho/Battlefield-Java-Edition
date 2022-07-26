package models.soldiers;

import models.contacts.IWeapon;
import models.contacts.Soldier;

public class LongRangeSoldier extends Soldier {

    public LongRangeSoldier(String name, int age, IWeapon weapon) {
        super(name, age, weapon);
    }
}
