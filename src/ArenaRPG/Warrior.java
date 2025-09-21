package ArenaRPG;

public class Warrior {
    String name;
    int health;
    int baseStrength;
    int baseDefense;
    int weaponStrength;
    private Weapon weapon;



    public Warrior() {
        this.name = "???";
        this.health = 100;
        this.baseStrength = 5;
        this.baseDefense = 6;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weaponStrength = weapon.weaponStrength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int playerPower() {
        return baseStrength + (weapon != null ? weapon.weaponStrength : 0);
    }


    public boolean isAlive() {
        if (health >= 1) {
            return true;
        }
        return false;
    }

    public void takeHit(Enemy opponent) {
        int playerDmg = (opponent.enemyPower() - baseDefense);
        health = (health - playerDmg);

        if (health < 0) {
            health = 0;
        }
        if (baseDefense > opponent.enemyPower()){
            health = (playerDmg = 0);
        }
        System.out.println(opponent.getName() + " strikes and you take " + playerDmg + " damage!!");
        System.out.println("Your current health: " + health);
    }

    public void reducedHit(Enemy opponent) {

        int reducedDmg = (opponent.enemyPower() / 3);
        health = (health - reducedDmg);

        if (health < 0) {
            health = 0;
        }
        System.out.println("You braced yourself for impact and took " + reducedDmg + " damage.");
        System.out.println("Your current health: " + health);
    }

}
