import java.util.Scanner;
/**
* Pokemon-specific binary search tree.
* @author Ashley Bare from Lisa Miller from William McDaniel Albritton
* @since 04/24/21
*/
 
public class PokeTree {

   /** Root node instance variable. */
   private PokeNode root;

   /** No parameter constructor. */
   public PokeTree() {
      root = null; //this is only here because otherwise checkstyle complains? 
   } // close no parameter PokeTree constructor

   /**
   * Adds a Pokemon to the tree.
   * Non-recursive wrapper method
   * @param p pokemon to be added
   */
   public void add(Pokemon p) {
      root = add(root, p);
   } //close non recursive add-er
  
   /**
   * Recursively adds an item to tree.
   * @param node root of tree/subtree
   * @param p pokemon to be added
   * @return current node
   */
   private PokeNode add(PokeNode node, Pokemon p) {
      
      // base case: empty tree or node is leaf
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      // base case: tree position already has value, increase count in PokeNode.
      } else if (p.getNumber() == node.getKey()) {
         node.increaseNumCaught(); 
         return node; 
      // recursive case: if p < current recursive call over left child
      } else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      // recursive case: if p > current recursive call over right child 
      } else {
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      }
   } //close recursive add method 


   /**
   * called automatically by println/print method.
   * @return an inorder String of the tree
   */
   public String toString() {
      return this.inOrder(root);
   } //close tostring

   /**
   * inOrder display of nodes, with newline between each node.
   * @param node The root of the tree/subtree
   * @return an inorder String of the tree
   */
   private String inOrder(PokeNode node) {
      String list = "";
      
      //traverse left nodes then print from bottom most left up to subtree node, then right nodes  
      if (node != null) {
         list = list + this.inOrder(node.getLChild()); 
         list = list + node.toString() + "\n" + "Caught: " + node.getNumCaught() + "\n\n"
            + "____________________\n\n";
         list = list + this.inOrder(node.getRChild());
      } //close if 
      return list;
   } //close inOrder method 


   /**
   * gets pokemon that matches param pokemon based on key.
   * @param searchKey Pokemon at index 
   * @return the data item in the tree with matching key.
   */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey); 
   } //close get pokemon method 

   /**
   * Recursive method to get an item from the tree.
   * @param node The root of the tree/subtree
   * @param searchKey2 An object storing the key to get.
   * @return the data item in tree with matching key.
   * @throws PokeTreeException if item not found
   */
   private Pokemon get(PokeNode node, Pokemon searchKey2) {
      // if not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Pokemon not found!");
      } 
      else {
        // if the search key matches, return the item's address
         if (searchKey2.getNumber() == node.getPokemon().getNumber()) {
            return node.getPokemon();
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree 
         else if (searchKey2.getNumber() < node.getPokemon().getNumber()) {
            return this.get(node.getLChild(), searchKey2);
         }
         // if the search key of the searchKey is greater than the node,
         // then search the right subtree
         else {
            return this.get(node.getRChild(), searchKey2);
         }
      }
   } //close get 


   /**
   * wrapper method to remove pokemon from tree. 
   * @param p the pokemon to be removed. 
   */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   } 

   /**
   * Recursively removes an item from the tree.   
   * @param node The root of the tree/subtree
   * @param p the pokemon to be removed from tree.
   * @return root of current subtree.
   * @throws PokeTreeException if item not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon p) {
      
      // if item not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Pokemon not found.");
      }
      // if p number < node's search key, continue to left subtree 
      else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      }
      // if p number > node's search key, continue to right subtree 
      else if (p.getNumber() > node.getKey()) {
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      }
      // found node containing pokenode with same search key, decrement count if count > 0
      else if (p.getNumber() == node.getKey() && node.getNumCaught() > 0) { 
         System.out.println("Okay, releasing the " + node.getSpecies()); 
         node.decreaseNumCaught(); 
         return node; 
      } 
      //found node containing pokenode with same search key, remove from tree if count = 0  
      else {
         // ask if sure, then call private method remove with one parameter if y
         System.out.println("You don't have any of this pokemon left." 
             + "\nIf you continue this will remove the pokemon from your Pokedex."
             + "\nEnter y to continue or n to return to the menu: "); 
         Scanner sc = new Scanner(System.in); 
         String s = sc.nextLine(); 
         s = s.trim().toLowerCase(); 
         switch (s) {
            case "y":
               System.out.println("Okay, removing the " + node.getSpecies()); 
               node = this.remove(node);
               break; 
            case "n": 
               System.out.println("Okay we'll keep this in your Pokedex for now."); 
               break; 
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter y or n.\n");
               break; 
         } 
         return node; 
      }
   } //close recursive remove 

   /**
   * Helper method that takes a node out of tree.
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode remove(PokeNode node) {
      // if node is leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if single right child, return right child 
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if single left child, return left child 
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if two child nodes
      else {
      // get next smaller item, which is rightmost in left subtree 
         PokeNode largestItemInLeftSubtree = this.getItemWithLargestSearchKey(node
             .getLChild());
      // replace the node's item with this item
         node = largestItemInLeftSubtree;
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   } //close private remove 

   /**
   * Recursive, returns item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node root of tree/subtree
   * @return data item with largest key
   */
   private PokeNode getItemWithLargestSearchKey(PokeNode node) {
      // if no right child, then this is largest node 
      if (node.getRChild() == null) {
         return node;
      }
      // otherwise keep looking
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   } //close getItemWithLargestSearchKey

   /**
   * Removes node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove node formerly occupied by item with largest search key.
   * called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains largest item
   // so replace with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   } //close removeNodeWithLargestSearchKey




} // end of class

