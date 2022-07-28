package models.weaponsAndWarMachines.Machines;

import models.contacts.IWarMachines;

public enum AirWarMachine implements IWarMachines {
    Helicopter("Augusta Apache", 250, 100, 2),
    Jet("F-31", 1000, 150, 3),
    AttachHelicopter("Kordon-66", 200, 400, 3),
    Drone("Bayraktar TB-2", 100, 250, 0.2);


    private String name;
    private int damage;
    private int durability;
    private double reloadRatio;
    private Boolean isDestroyed;

    AirWarMachine(String name, int damage, int durability, double reloadRatio) {
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

