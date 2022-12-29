import java.util.Random;
/**
* Charizard Pokemon object class.
* Subclass of Charmeleon
* @author Group 3, Grayson, Ashley, Ken
* @version 1.0
* @since 02/19/2021
*/
public class Charizard extends Charmeleon implements FlyingType {

   /** The minimum attack power for species. */ 
   static final int BASE_ATTACK_POWER = 223;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 173;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 186;
   
   //booleans for telling which type attack to use for dual type Pokemon
   /** Indicator for fast attack type. */
   protected boolean fastIsFire = true;
   /** Indicator for special attack type. */
   protected boolean specialIsFire = true;
   
   /** Constructor with no name. */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER, FIRE_TYPE, FLYING_TYPE);
      chooseSpecialAttack(); 
      chooseFastAttack();  
   }
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5, BASE_ATTACK_POWER, 
            BASE_DEFENSE_POWER, BASE_STAMINA_POWER, FIRE_TYPE, FLYING_TYPE);
      chooseSpecialAttack(); 
      chooseFastAttack();
   }
   
   /**
   * Fire|Flying-type specific fast attack chooser.
   * Randomly picks whether attack type is fire or flying
   * Randomly picks an attack from type attack arrays
   */
   protected void chooseFastAttack() {
      //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsFire = randGen.nextBoolean();
      
      if (fastIsFire) {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { //is flying
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index]; 
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
         fastIsFire = false;  
      }
   }
    /**
   * Fire|Flying-type specific fast attack chooser.
   * Randomly picks whether attack type is fire or flying
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack() {
      //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set type choice boolean
      specialIsFire = randGen.nextBoolean();
      
      if (specialIsFire) {
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      } else { //is flying
         index = randGen.nextInt(FLYING_SPECIAL_ATTACKS.length);
         specialAttack =  FLYING_SPECIAL_ATTACKS[index];
         specialAttackPower = FLYING_SPECIAL_ATK_POWER[index];  
          
      }
   }
}
   
