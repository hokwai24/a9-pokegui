import java.util.Random;
/**
* Charmeleon Pokemon object class.
* Subclass of Charmander
* @author Group 3, Grayson, Ashley, Ken
* @version 1.0
* @since 02/19/2021
*/
public class Charmeleon extends Charmander {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 158;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 126;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 151;
   
   /** Constructor with no name. */
   public Charmeleon() {
      super("Charmeleon", "Charmeleon", 5, 1.1, 19.0, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER, FIRE_TYPE, ""); 
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charmeleon(String name) {
      super("Charmeleon", name, 5, 1.1, 19.0, BASE_ATTACK_POWER, 
             BASE_DEFENSE_POWER, BASE_STAMINA_POWER, FIRE_TYPE, "");
      chooseFastAttack();
      chooseSpecialAttack();
   }
   /** 
   * Constructor with species and name for subclasses.
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   *@param type1 type 1 for subclass with different type
   *@param type2 type 2 for subclass with different type
   */
   protected Charmeleon(String species, String name, int num, double ht, 
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr, 
       String type1, String type2) {
      
      super(species, name, num, ht, wt, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr, type1, type2);
   }
   
   /**
   * Fire-type specific fast attack chooser.
   * Randomly picks an attack from type attack arrays
   */
   protected void chooseFastAttack() {
      
      Random randGen = new Random();
      int index;
      
      //sets index to random number within length of options     
      index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   }
   
   

}
   
