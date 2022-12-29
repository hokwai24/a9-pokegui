import javax.swing.JFrame;
/**
* GUI for use with Pokemon Class. 
* @author Ashley Bare, Hok Wai Chan
* @since 12/14/20
*/

public class PokeFrame {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame      
      JFrame frm = new JFrame("Group 2 Pokemon GUI");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add PokeGUI object to Frame
      frm.getContentPane().add(new PokeGUI());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}
