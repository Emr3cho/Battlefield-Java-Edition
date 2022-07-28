package models.contacts;

import common.exceptions.MyExceptions;
import common.GlobalConstants;
import lombok.Getter;

@Getter
public abstract class Soldier {
    private String name;
    private int age;
    private double damage;
    private double health;
    private final IWeapon weapon;
    private Boolean isDead;

    public Soldier(String name, int age, IWeapon weapon) {
        setName(name);
        setAge(age);
        this.weapon = weapon;
        setDamage(weapon.getDamage());
        setHealth(GlobalConstants.SOLDIER_INITIAL_HEALTH);
        isDead = false;
    }

    public void attackSoldier(Soldier soldier){
        soldier.setHealth(soldier.getHealth() - this.getDamage());
        soldier.chechIsDead();
    }

    public void chechIsDead() {
        if (this.health <= 0){
            isDead = true;
        }
    }

    public void boostDamage(double damage){
        this.damage += damage;
    }

    private void setHealth(double health) {
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
