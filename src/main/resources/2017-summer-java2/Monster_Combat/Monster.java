/*
 * Abstract class that defines a generic "monster" combatant.
 * Each Monster has health, attack, and hitChance attributes.
 *
 *   health - ( > 0) - the number of hit points; the Monster is dead when 
 *                     this reaches 0
 *   attack - (0 - 100) - the amount of damage done by this Monster's normal attack
 *   hitChance - (0.0 - 1.0) - the probability of an attack succeeding
 *   
 * Author: Jeremy Porter, 2017
 */
public abstract class Monster {
   public static final int ATT_MISSED = -1;
   
   private double hitChance;
   private int health;
   private int attack;
   
   public Monster(double hc, int h, int a) {
      setHitChance(hc);
      setHealth(Math.max(1, h));
      setAttack(a);
   }
   
   public void setHitChance(double hc) {
      hitChance = Math.max(0.0, Math.min(1.0, hc));
   }
   public void setHealth(int h) {
      health = Math.max(0, h);
   }   
   public void setAttack(int a) {
      attack =  Math.max(0, Math.min(100, a));
   }
   
   // Returns probability of landing a hit (always between 0.0 and 1.0)
   public double getHitChance() {
      return hitChance;
   }
   public int getHealth() {
      return health;
   }   
   public int getAttack() {
      return attack;
   }
   
   
   
   /*
    * Uses a random uniform distribution together with the hitChance to
    * determine whether an attempted attack was successful (true) or not (false).
    */
   public boolean hitAttempt() {
      return (Math.random() < hitChance);
   }
   
   /*
    * Adjusts health relative to its current value. May be a positive 
    * or negative adjustment.
    */
   public void adjustHealth(int adj) {
      setHealth(health + adj);
   }
   
   /*
    * Returns true if the value of health is positive, false otherwise.
    */
   public boolean isAlive() {
      return (health > 0);
   }
   
   /*
    * Attacks a target Monster. First, an attempt is made to hit the target,
    * using the hitChance probability. If the hit is successful, then the damage
    * applied to the target is equal to this Monster's attack value.
    * Returns the amount of damage done to the target, or Monster.ATT_MISSED
    * if the attack missed.
    */
   public int attack(Monster target) {
      if(hitAttempt()) {
         target.adjustHealth(-attack);
         return attack;
      } else {
         return ATT_MISSED;
      }      
   }
   
   /*
    * Perform a special attack against a target Monster.
    */
   public abstract int specialAttack(Monster target);
   
}