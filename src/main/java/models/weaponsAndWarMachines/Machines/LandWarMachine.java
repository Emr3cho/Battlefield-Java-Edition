package models.weaponsAndWarMachines.Machines;

import models.contacts.IWarMachines;

public enum LandWarMachine implements IWarMachines {
    Car("Flexi", 150, 200, 10),
    RocketCar("MD10", 200, 60, 8),
    AirWarMachieKiller("KillerX", 50, 50, 0.3),
    Bus("PartyBus", 30, 500, 2);

    private String name;
    private int damage;
    private int durability;
    private double reloadRatio;
    private Boolean isDestroyed;

    LandWarMachine(String name, int damage, int durability, double reloadRatio) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.reloadRatio = reloadRatio;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public double getReloadRatio() {
        return reloadRatio;
    }

    @Override
    public Boolean getIsDestoyed() {
        return isDestroyed;
    }

    public void setDestroyed() {
        if (this.durability <= 0){
            isDestroyed = true;
        }
    }
}

