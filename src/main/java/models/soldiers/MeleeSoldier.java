package models.soldiers;

import models.contacts.IWeapon;
import models.contacts.Soldier;

public class MeleeSoldier extends Soldier {

    public MeleeSoldier(String name, int age, IWeapon weapon) {
        super(name, age, weapon);
    }
}

