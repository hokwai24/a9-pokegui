import java.util.Random;
/**
* Charmander Pokemon object class.
* type Fire implements Fire type interfaces
* Parent class to Charmeleon
* @author Group 3, Grayson, Ashley, Ken
* @version 1.0
* @since 02/19/2021
*/
public class Charmander extends Pokemon implements FireType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 116;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 93;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 118;

   
   /**
   * Constructor with no name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   */
   public Charmander() {
      super("Charmander", "Charmander", 4, FIRE_COLOR, 0.6, 8.5, 
         FIRE_TYPE, "", BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
     
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   /**
   * Constructor with name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   * @param name The user-defined name.
   */
   public Charmander(String name) {
      super("Charmander", name, 4, FIRE_COLOR, 0.6, 8.5, 
         FIRE_TYPE, "", BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      
      //pick Attacks
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** 
   * Constructor with species and name for subclasses.
   * This allows subclass specific name, number, height, weight, and basePowers 
   * to pass through to Pokemon superclass constructor
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
   protected Charmander(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr, String type1, String type2) {
       
      super(species, name, num, FIRE_COLOR, ht, wt, type1, 
         type2, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
    
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
   
  /**
   * Fire-type specific special attack chooser.
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack() {
      //randomly choose fire attack
      Random randGen = new Random();
      int index;
      index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   *
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      //check effectiveness of attack
      if ((fastAttack == "Ember") || (fastAttack == "Fire Fang")) {
         if (vType.equals("Ice") || vType.equals("Grass")  
             || vType.equals("Bug") || vType.equals("Steel")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Rock") 
             || vType.equals("Fire") || vType.equals("Dragon")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //flying type
         if (vType.equals("Fighting") || vType.equals("Grass") 
             || vType.equals("Bug")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
   
  /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      //check effectiveness of attack
      if ((specialAttack == "Aerial Ace") || (specialAttack == "Air Cutter") 
            || (specialAttack == "Drill Peck") || (specialAttack == "Hurricane")) {
         if (vType.equals("Fighting") || vType.equals("Grass") 
             || vType.equals("Bug")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //fire type
         if (vType.equals("Ice") || vType.equals("Grass") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Rock") 
             || vType.equals("Fire") || vType.equals("Dragon")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }      
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
   * Reduces Pokemon's HP by damage/defensePower.
   * Doesn't allow HP to go less than 0
   * Implementation of "fainting" not done here
   * @param damage Hit points to take off HP
   */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
   }     

}