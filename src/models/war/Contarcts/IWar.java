package models.war.Contarcts;

import models.war.Army;

public interface IWar extends Runnable {
    void addArmy(Army army);

    void addArmyToCoalition(Army armyToAdd);

    @Override
    void run();


}
