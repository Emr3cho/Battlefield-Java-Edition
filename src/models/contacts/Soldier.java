package models.contacts;

import common.exceptions.MyExceptions;
import common.GlobalConstants;
import lombok.Getter;

@Getter
public abstract class Soldier {
    private String name;
    private int age;
    private double damage;
    private int health;
    private final IWeapon weapon;

    public Soldier(String name, int age, IWeapon weapon) {
        setName(name);
        setAge(age);
        this.weapon = weapon;
        setDamage(weapon.getDamage());
        setHealth(GlobalConstants.SOLDIER_INITIAL_HEALTH);
    }

    public void boostDamage(double damage){
        this.damage += damage;
    }

    private void setHealth(int health) {
        if (health <= 0)
            throw new MyExceptions.InvalidHealthException();
        this.health = health;
    }

    private void setAge(int age) {
        if (age < 15)
            throw new MyExceptions.InvalidAgeException();
        this.age = age;
    }

    private void setDamage(double damage) {
        if (damage < 0)
            throw new MyExceptions.InvalidDamageException();
        this.damage = damage;
    }

    private void setName(String name) {
        if (name.length() < 3)
            throw new MyExceptions.InvalidNameException();
        this.name = name;
    }

    public String printSoldierNameAndWeapon(){
        return String.format("%s is %d years old with %s!", this.getName(), this.getAge(), this.getWeapon());
    }
}
