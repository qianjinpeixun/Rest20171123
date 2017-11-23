/*
 * Class that defines an Orc that is a Monster combatant.
 * Orcs have default health of 250, attack strength of 45, and 
 * hitChance of 0.9 (90%). 
 *
 * The Orc's special attack does normal damage but has double 
 * the chance of succeeding.
 *
 * Author: Jeremy Porter, 2017
 */
 public class Orc extends Monster {
   private static final double DEF_HC = 0.9;
   private static final int DEF_HP = 250;
   private static final int DEF_AT = 45;
   
   private static int orcCount = 0;
   
   
   public Orc() {
      super(DEF_HC, DEF_HP, DEF_AT);
      orcCount++;
   }
   
   /*
    * Special attack: attempt two hits. If either attempt is  
    * successful, apply damage to the target that is equal to the
    * Orc's normal attack value.
    */
   public int specialAttack(Monster target) {
      if(hitAttempt() || hitAttempt()) {
         target.adjustHealth(-getAttack());
         return getAttack();
      } else {
         return ATT_MISSED;
      }   
   }
   
   public String toString() {
      return "Orc " + orcCount;
   }
}