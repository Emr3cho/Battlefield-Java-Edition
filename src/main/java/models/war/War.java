package models.war;

import lombok.SneakyThrows;
import models.war.Contarcts.IWar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        if (republicans.size() > democratics.size()) {
            democratics.add(armyToAdd);
            coalitionName = "democratics";
        } else {
            republicans.add(armyToAdd);
            coalitionName = "republicans";
        }

        System.out.println(String.format("Army added to %s coalition!", coalitionName));
    }

    public String printArmies() {
        StringBuilder result = new StringBuilder();
        result.append("War%n" + System.lineSeparator());
        for (int i = 0; i < allArmies.size(); i++) {
            result.append(String.format("%n--Army %d%n", i + 1));
            Army currentArmy = allArmies.get(i);
            result.append(currentArmy.armyPrinter());
        }

        return result.toString().trim();
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder textToAddToSB = new StringBuilder();
        Army firstArmy = republicans.stream().max(Comparator.comparing(x -> x.getGeneral().getWarKnowledge())).orElse(null);
        Army secondArmy = democratics.stream().max(Comparator.comparing(x -> x.getGeneral().getWarKnowledge())).orElse(null);
        while (true) {
            if (republicans.size() == 0) {
                System.out.println("Democratics are the Winner!");
                return;
            }
            if (democratics.size() == 0) {
                System.out.println("Republicans are the Winner!");
                return;
            }

            firstArmy.attack(secondArmy);
            System.out.println();


            if (firstArmy.getSoldiers().size() == 0) {
                republicans.remove(firstArmy);
                allArmies.remove(firstArmy);
                firstArmy = republicans.stream().max(Comparator.comparing(x -> x.getGeneral().getWarKnowledge())).orElse(null);
            }
            if (secondArmy.getSoldiers().size() == 0) {
                democratics.remove(secondArmy);
                allArmies.remove(secondArmy);
                secondArmy = democratics.stream().max(Comparator.comparing(x -> x.getGeneral().getWarKnowledge())).orElse(null);
            }
        }
    }

    private String resultGenerator() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\rRepublicans with total %d soldiers and %d machines has total %s durability and soldiers has total %d health%n",
                republicans.stream().mapMultiToInt((x, y) -> x.getSoldiers().size()).sum(),
                republicans.stream().mapMultiToInt((x, y) -> x.getWarMachines().size()).sum(),
                republicans.stream().mapMultiToInt((x, y) -> x.getWarMachines().stream().mapMultiToInt((j, m) -> j.getDurability()).sum()),
                republicans.stream().mapMultiToInt((x, y) -> x.getSoldiers().size()).sum() * 100));
        for (int i = 0; i < republicans.size(); i++) {
            sb.append(String.format("\r---Army %d with commander %s with %d war knowledge has total %d soldiers and total %d machines",
                    i + 1,
                    republicans.get(i).getGeneral().getName(),
                    republicans.get(i).getGeneral().getWarKnowledge(),
                    republicans.get(i).getSoldiers().size(),
                    republicans.get(i).getWarMachines().size()));
        }

        sb.append(String.format("\r%nDemocratics with total %d soldiers and %d machines has total %s durability and soldiers has total %d health%n",
                democratics.stream().mapMultiToInt((x, y) -> x.getSoldiers().size()).sum(),
                democratics.stream().mapMultiToInt((x, y) -> x.getWarMachines().size()).sum(),
                democratics.stream().mapMultiToInt((x, y) -> x.getWarMachines().stream().mapMultiToInt((j, m) -> j.getDurability()).sum()),
                democratics.stream().mapMultiToInt((x, y) -> x.getSoldiers().size()).sum() * 100));
        for (int i = 0; i < democratics.size(); i++) {
            sb.append(String.format("\r---Army %d with commander %s with %d war knowledge has total %d soldiers and total %d machines",
                    i + 1,
                    democratics.get(i).getGeneral().getName(),
                    democratics.get(i).getGeneral().getWarKnowledge(),
                    democratics.get(i).getSoldiers().size(),
                    democratics.get(i).getWarMachines().size()));
        }

        return sb.toString();
    }
}
