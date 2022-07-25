package Models.WeaponsAndWarMachines.Weapons;

public enum MaleeWeapon implements IWeapon {
    Knife("M9 Bayonet", 20, 80, 0.3),
    Sword("Katana", 30, 75, 0.5),
    Axe("Aspathines", 35, 85, 0.9);

    private String name;
    private int damage;
    private int durability;
    private double reloadRatio;

    MaleeWeapon(String name, int damage, int durability, double reloadRatio) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.reloadRatio = reloadRatio;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public double getReloadRatio() {
        return this.reloadRatio;
    }

    @Override
    public String toString() {
        return "MaleeWeapon {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", durability=" + durability +
                ", reloadRatio=" + reloadRatio +
                "}";
    }
}
