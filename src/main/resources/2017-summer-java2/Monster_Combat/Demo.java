public class Demo {
   public static void main(String[] args) {
      Monster o, g;
      
      o = new Orc();
      g = new Giant();
      
      CombatArena arena = new CombatArena(o, g);
      
      arena.fight();
   }
}