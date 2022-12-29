/**
* Pokemon Node.
* @author Ashley Bare
* @since 04/24/21
*/
public class PokeNode {

	/** pData stores a Pokemon object. */
   private Pokemon pData;
   /** count stores how many times Pokemon has been caught. */ 
   private int count; 
	/** lChild points to the left child. */
   private PokeNode lChild;
   /** rChild points to the right child. */ 
   private PokeNode rChild; 
 
   
   /**
	* Constructor to create PokeNode.
	* @param poke the pokemon object in PokeNode 
   * @param numCaught count of this pokemon type caught 
   * @param lChildIn PokeNode to put left w/ lower number 
   * @param rChildIn PokeNode to put right w/ higher number 
   * @throws PokeNodeException if P is null or count < 1
	*/
   public PokeNode(Pokemon poke, int numCaught, PokeNode lChildIn, PokeNode rChildIn) 
      throws PokeNodeException {
      
      //if/else checks that P isn't null & count >= 1 before making new PokeNode
      if (poke == null) {
         throw new PokeNodeException("Wait, there isn't a pokemon here. Try again."); 
      } else if (numCaught < 1) {
         throw new PokeNodeException("You don't have any of this Pokemon to release!"); 
      } else {
         pData = poke;
         count = numCaught; 
         lChild = lChildIn; 
         rChild = rChildIn; 
      } //close if/else checking constructor safety
      
   } //close PokeNode constructor

	/**
	* Display pokemon in PokeNode.
	* @return String of the pokemon in PokeNode
	*/
   public String toString() {
      return pData.toString();
   } // close toString


/*******************GET METHODS******************************/ 

	/**
	* method to get Pokemon object. 
	* @return Pokemon object in PokeNode
	*/
   public Pokemon getPokemon() {
      return pData;
   } //close getData
   
   /** 
   * method to get Pokemon object's species. 
   * @return pokemon object in node's species
   */ 
   public String getSpecies() {
      return this.getPokemon().getSpecies(); 
   } //close getSpecies
   
   /**
	* method to get Pokemon object key/number. 
	* @return pokedex number of Pokemon
	*/
   public int getKey() {
      Pokemon thisPoke = this.getPokemon(); 
      int key = thisPoke.getNumber(); 
      return key;  
   } //close getKey
   
   /**
	* method to get number caught. 
	* @return count of this type pokemon. 
	*/
   public int getNumCaught() {
      return count; 
   } //close getLChild

	/**
	* method to get left child.
	* @return the address to the left child
	*/
   public PokeNode getLChild() {
      return lChild; 
   } //close getLChild
   
   /**
	* method to get right child.
	* @return the address to the right child
	*/
   public PokeNode getRChild() {
      return rChild; 
   } //close getRChild


/*********************SET METHODS*****************************/ 

	/**
	* set pokemon in PokeNode. 
	* @param poke pokemon for node
	*/
   public void setPokemon(Pokemon poke) {
      pData = poke;
   } //close setPokemon

	/**
	* Update left/less child PokeNode. 
	* @param left to set as left child 
	*/
   public void setLChild(PokeNode left) {
      lChild = left; 
   } //close setLChild
   
   /**
	* Update right/higher child PokeNode. 
	* @param right to set as right child 
	*/
   public void setRChild(PokeNode right) {
      rChild = right; 
   } //close setRChild  
   
   /**
	* Increment count of this type pokemon caught. 
	*/
   public void increaseNumCaught() {
      count++; 
   } //close increaseNumCaught  
   
   /**
	* Decrement count of this type pokemon caught. 
	*/
   public void decreaseNumCaught() {
      count--; 
   } //close decreaseNumCaught  
   
   
} //close PokeNode class 