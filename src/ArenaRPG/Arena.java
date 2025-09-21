package ArenaRPG;

import java.util.Scanner;

public class Arena {
    Scanner input = new Scanner(System.in);


    public void battle(Warrior fighter, Enemy opponent) {

        while (fighter.isAlive() && opponent.isAlive()) {
            System.out.println("Your stats: " +
                    "\nBase Power: " + fighter.baseStrength +
                    ", Base Endurance: " + fighter.baseDefense +
                    ", Battle Power: " + fighter.playerPower() +
                    ", Equipped Weapon: " + (fighter.getWeapon() != null ? fighter.getWeapon().weaponName : "None"));
            System.out.println("Enemy's stats: " + "\nBase Power: " + opponent.baseStrength + ", Base Endurance: " + opponent.baseDefense + ", Battle Power: " + opponent.enemyPower());
            System.out.println("Player Turn.");
            System.out.println("Your opponent Stands before you, what will you do?\n(on your keyboard type: z to attack, x to defend, or c to forfeit)");
            String action = input.nextLine();
            if (action.equals("z")) {
                opponent.takeHit(fighter.playerPower());

            }
            if (action.equals("z") && opponent.isAlive()) {
                System.out.println("Enemy Turn");
                fighter.takeHit(opponent);
            }
            
            if (action.equals("x")) {
                fighter.reducedHit(opponent);
            }


            if (action.equals("c")) {
                System.out.println("There is always next time, I suppose...\n(if you wish to play again, please rerun the code.)");
                return;
            }

            if (fighter.health <= 0) {
                System.out.println("You have fallen in battle and lost...\n(if you wish to play again, please rerun the code.)");// to make up for no replay method.
            }
            if (opponent.health <= 0) {
                System.out.println("You have bested your opponent and won!!\n(if you wish to play again, please rerun the code.)");
            }


        }
    }
}
