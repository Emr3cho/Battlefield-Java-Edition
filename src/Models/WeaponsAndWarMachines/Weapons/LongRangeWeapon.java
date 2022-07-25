package Models.WeaponsAndWarMachines.Weapons;

public enum LongRangeWeapon implements IWeapon {
    Rifle("AK-47", 75, 35, 2.3),
    Gun("Desert Eagle", 100, 25, 5),
    Bow("Super-Bow", 80, 10, 1.2),
    FlameThrower("Super Flame", 100, 60, 4.9);

    private String name;
    private int damage;
    private int durability;
    private double reloadRatio;

    LongRangeWeapon(String name, int damage, int durability, double reloadRatio) {
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
    public String toString() {
        return "LongRangeWeapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", durability=" + durability +
                ", reloadRatio=" + reloadRatio +
                "}";
    }
}
