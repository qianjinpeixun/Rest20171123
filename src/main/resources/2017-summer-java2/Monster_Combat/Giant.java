/*
 * Class that defines a Giant that is a Monster combatant.
 * Giants have default health of 500, attack strength of 65, and 
 * hitChance of 0.5 (50%). 
 *
 * The Giant's special attack does double damage if it succeeds.
 *
 * Author: Jeremy Porter, 2017
 */
 public class Giant extends Monster {
   private static final double DEF_HC = 0.5;
   private static final int DEF_HP = 500;
   private static final int DEF_AT = 65;
   
   private static int giantCount = 0;
   
   public Giant() {
      super(DEF_HC, DEF_HP, DEF_AT);
      giantCount++;
   }
   
   /*
    * Special attack: attempt a hit using the usual method. If successful, 
    * apply damage to the target that is equal to twice the Giant's normal 
    * attack value.
    */
   public int specialAttack(Monster target) {
      if(hitAttempt()) {
         target.adjustHealth(-2*getAttack());
         return 2*getAttack();
      } else {
         return ATT_MISSED;
      }   
   }   
   
   public String toString() {
      return "Giant " + giantCount;
   }
}