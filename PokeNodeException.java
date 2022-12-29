/** 
* pokenode exception class. 
* @author Ashley Bare 
* @since 11/25/20 
*/ 

public class PokeNodeException extends RuntimeException {

   /** no parameter constructor. */
   public PokeNodeException() {
      super(); 
   
   }
   
   /** constructor with message.
   * @param message error message
   */
   public PokeNodeException(String message) {
      super(message);
   }



} //close exception class 