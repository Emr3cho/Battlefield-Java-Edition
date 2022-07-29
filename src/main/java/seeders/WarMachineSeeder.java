package seeders;

import models.contacts.IWarMachines;
import models.weaponsAndWarMachines.Machines.AirWarMachine;
import models.weaponsAndWarMachines.Machines.LandWarMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WarMachineSeeder {
    public static List<IWarMachines> warMachines(int count) {
        List<IWarMachines> warMachines = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            machineMaker(warMachines);
        }

        return warMachines;
    }

    private static void machineMaker(List<IWarMachines> warMachines) {
        Random random = new Random();

        int randomNumber = random.nextInt(0, 100);
        IWarMachines machine;
        int randomMachineIndex;

        if (randomNumber % 2 == 0) {
            List<LandWarMachine> landWarMachines = Arrays.stream(LandWarMachine.values()).toList();
            randomMachineIndex = random.nextInt(0, landWarMachines.size() - 1);
            machine = landWarMachines.get(randomMachineIndex);
        } else {
            List<AirWarMachine> airWarMachines = Arrays.stream(AirWarMachine.values()).toList();
            randomMachineIndex = random.nextInt(0, airWarMachines.size() - 1);
            machine = airWarMachines.get(randomMachineIndex);
        }

        warMachines.add(machine);
    }
}

