/** 
* pokemon exception class. 
* @author Ashley Bare 
* @since 11/25/20 
*/ 

public class PokemonException extends RuntimeException {

   /** no parameter constructor. */
   public PokemonException() {
      super(); 
   
   }
   
   /** constructor with message.
   * @param message error message
   */
   public PokemonException(String message) {
      super(message);
   }



} //close exception class 