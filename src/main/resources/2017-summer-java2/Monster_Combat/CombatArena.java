/*
 * Class that defines a CombatArena where Monster combatants
 * can fight.
 *
 * Combat begins by randomly selecting one of the two combatants
 * to be the first attacker. In each round, the first attacker
 * has the first opportunity to attack, then the second has its
 * opportunity to attack. In every third round of combat, the
 * order of attacking is reversed and special attacks are used
 * instead of regular ones.
 *
 * If the health value for one of the Monsters any point
 *
 * The Giant's special attack does double damage if it succeeds.
 *
 * Author: Jeremy Porter, 2017
 */
 public class CombatArena {
   private Monster red, blue;
   
   public CombatArena(Monster r, Monster b) {
      red = r;
      blue = b;
   }
   
   public void fight() {
      int roundNumber = 0;
      int damageDone;
      Monster first, second;
      
      if(Math.random() < 0.5) {
         first = red;
         second = blue;
      } else {
         first = blue;
         second = red;
      }
         
      while(first.isAlive() && second.isAlive()) {
         roundNumber++;
         
         if(roundNumber % 3 == 0) {
         
            performSpecialAttack(second, first);
            if(first.isAlive())
               performSpecialAttack(first, second);
                              
         } else {
         
            performAttack(first, second);
            if(second.isAlive())
               performAttack(second, first);

         }
      }
      
      
      
      int healthRemaining;
      
      if(first.isAlive()) {
         System.out.print(first);
         healthRemaining = first.getHealth();
      } else {
         System.out.print(second);
         healthRemaining = second.getHealth();
      }   
         
      System.out.println(" wins with " + healthRemaining + " health remaining!");      
   }
   
   
   private void performAttack(Monster attacker, Monster target) {
      int damage = 0;
      int startingHealth = target.getHealth();
      
      damage = attacker.attack(target);
      if(damage != Monster.ATT_MISSED) {
         System.out.print(attacker + " hits " + target + " for " + damage + " damage!");
      } else {
         System.out.print(attacker + " misses " + target + "!");
      }
      
      System.out.println("\n\t" + target + " has " + target.getHealth() + " health remaining.\n");
   }
   
   private void performSpecialAttack(Monster attacker, Monster target) {
      int damage = 0;
      int startingHealth = target.getHealth();
      
      damage = attacker.specialAttack(target);
      System.out.print(attacker + " uses **SPECIAL ATTACK**\t");
      if(damage != Monster.ATT_MISSED) {
         System.out.print(attacker + " hits " + target + " for " + damage + " damage!");
      } else {
         System.out.print(attacker + " misses " + target + "!");
      }
      
      System.out.println("\n\t" + target + " has " + target.getHealth() + " health remaining.\n");
   }
   

}