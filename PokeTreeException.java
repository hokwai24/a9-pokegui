/** 
* poketree exception class. 
* @author Ashley Bare 
* @since 11/25/20 
*/ 

public class PokeTreeException extends RuntimeException {

   /** no parameter constructor. */
   public PokeTreeException() {
      super(); 
   
   }
   
   /** constructor with message.
   * @param message error message
   */
   public PokeTreeException(String message) {
      super(message);
   }



} //close exception class 