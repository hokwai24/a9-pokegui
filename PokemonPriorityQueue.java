import java.util.PriorityQueue; 
import java.util.ArrayDeque; 
/**
* @author Ashley Bare
* @since 03/30/21
*/
public class PokemonPriorityQueue {
   /** 
   * main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
   
      Pokemon pTemp = null;
      PriorityQueue<Pokemon> pq = new PriorityQueue<Pokemon>(); 
      ArrayDeque<Pokemon> stack = new ArrayDeque<Pokemon>(); 
      
      for (int i = 0; i < 5; i++) {
         pTemp = new Bulbasaur(); 
         pq.add(pTemp); 
         stack.push(pTemp); 
         pTemp = new Venusaur(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Ivysaur(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Charmander(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Charmeleon(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Charizard(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Squirtle(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Wartortle(); 
         pq.add(pTemp); 
         stack.push(pTemp);
         pTemp = new Blastoise(); 
         pq.add(pTemp); 
         stack.push(pTemp);
      } //close for 
      
      System.out.println("*****PriorityQueue******"); 
      while(pq.size() > 0){
         Pokemon curr = pq.poll();
         System.out.println(curr.toString());
         System.out.println("");
      } //close while 
      
      System.out.println("*****Stack******"); 
      while(stack.size() > 0){
       Pokemon curr = stack.poll();
       System.out.println(curr.toString());
       System.out.println("");
     }
   
   } //close main 
} //close class