package models.war;

import models.war.Contarcts.IWar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class War implements IWar {
    private List<Army> allArmies;
    private List<Army> republicans;
    private List<Army> democratics;

    public War() {
        allArmies = new ArrayList<>();
        republicans = new ArrayList<>();
        democratics = new ArrayList<>();
    }

    public List<Army> getAllArmies() {
        return Collections.unmodifiableList(allArmies);
    }

    @Override
    public void addArmy(Army army) {
        allArmies.add(army);
        addArmyToCoalition(army);
    }

    @Override
    public void addArmyToCoalition(Army armyToAdd) {
        String coalitionName;
        if (republicans.size() > democratics.size()){
            democratics.add(armyToAdd);
            coalitionName = "democratics";
        }
        else{
            republicans.add(armyToAdd);
            coalitionName = "republicans";
        }

        System.out.println(String.format("Army added to %s coalition!", coalitionName));
    }

    public String printArmies(){
        StringBuilder result = new StringBuilder();
        result.append("War%n" + System.lineSeparator());
        for (int i = 0; i < allArmies.size(); i++) {
            result.append(String.format("%n--Army %d%n", i + 1));
            Army currentArmy = allArmies.get(i);
            result.append(currentArmy.armyPrinter());
        }

        return result.toString().trim();
    }

    @Override
    public void run() {

    }
}
