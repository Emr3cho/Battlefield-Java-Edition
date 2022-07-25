package Models.Soldiers;

import GlobalConstansts.Exceptions.MyExceptions;
import GlobalConstansts.PublicConstants;
import lombok.Getter;

@Getter
public abstract class Soldier {
    private String name;
    private int age;
    private double damage;
    private int health;

    public Soldier(String name, int age, double damage) {
        setName(name);
        setAge(age);
        setDamage(damage);
        PublicConstants pc = new PublicConstants();
        setHealth(PublicConstants.SOLDIER_INITIAL_HEALTH);
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
}
