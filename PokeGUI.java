import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.PriorityQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque; 

/**
* Panels for Pokemon GUI. 
* @author Ashley Bare, Hok Wai Chan
* @since 12/14/20
*/

public class PokeGUI extends JPanel {

   /*** label for top with Pokemon logo image. ***/
   private JLabel topHeader = new JLabel();
   /*** label to display Pokemon image when hunting. ***/ 
   private JLabel pokeDisplay = new JLabel(); 
   /*** label to display caught or flee image. ***/ 
   private JLabel caughtOrNot = new JLabel(); 
   /*** button to hunt pokemon. ***/
   private JButton bHunt = new JButton(" Hunt ");
   /*** button to catch pokemon. ***/
   private JButton bCatch = new JButton(" Catch ");
   /*** button to print pokedex. ***/ 
   private JButton bPokedex = new JButton(" Pokedex "); 
   /*** button to print backpack. ***/ 
   private JButton bBackpack = new JButton(" Backpack "); 
   /*** radio button for sorting by number. ***/ 
   private JRadioButton sortByNum = new JRadioButton("Number"); 
   /*** radio button for sorting by most recent. ***/ 
   private JRadioButton sortByRecent = new JRadioButton("Most Recent"); 
   /*** button group to make sure only one selected. ***/ 
   private ButtonGroup bGroup = new ButtonGroup(); 
  
   /*** top sub-panel. ***/
   private JPanel topSubPanel = new JPanel();
   /*** center sub-panel. ***/ 
   private JPanel centerSubPanel = new JPanel(); 
   /*** bottom sub-panel. ***/
   private JPanel bottomSubPanel = new JPanel();
   /*** left sub-panel. ***/ 
   private JPanel leftSubPanel = new JPanel(new GridLayout(2, 1)); 
   /*** right sub-panel. ***/ 
   private JPanel rightSubPanel = new JPanel(new GridLayout(2, 1));    
   /*** pop-up. ***/ 
   private JPanel popUp = new JPanel();
   
   /*** ActionListener to add to buttons. ***/
   private GUIListener listener = new GUIListener();
  
   /*** pokemon. ***/
   private Pokemon pm;
   /*** BST of Pokemon. ***/
   private PokeTree pokedex = new PokeTree(); 
   /*** PriorityQueue for backpack sort by number. ***/ 
   private PriorityQueue<Pokemon> backpackNum = new PriorityQueue<Pokemon>();
   /*** alt PriorityQueue for backpack sort by number. ***/ 
   private PriorityQueue<Pokemon> altBackpackNum = new PriorityQueue<Pokemon>();
   /*** stack for backpack sort by recent. ***/ 
   private ArrayDeque<Pokemon> backpackRecent = new ArrayDeque<Pokemon>(); 
   /*** alt stack for backpack sort by recent. ***/ 
   private ArrayDeque<Pokemon> altBackpackRecent = new ArrayDeque<Pokemon>(); 
   /*** counter for Pokemon in Pokedex. ***/
   private int dexCount = 0;
   /*** counter for Pokemon in Backpack. ***/
   private int packCount = 0;
   
   /*** String for displaying new pokemon. ***/ 
   private String pokeOut = new String("");
   /*** String for displaying Pokedex or backpack. ***/
   private String pokeList = new String(""); 
   
   /*** text area for displaying hunt and catch messages. ***/
   private JTextArea textHuntCatch = new JTextArea(15, 20);
   /*** text area for displaying pokedex or backpack. ***/
   private JTextArea textArea = new JTextArea(10, 30); 
   /*** text area for popUp. ***/ 
   private JTextArea popUpMessage = new JTextArea(2, 20); 
   
   /*** image icon for header. ***/ 
   private ImageIcon header = new ImageIcon("IMAGE\\headerimage.png"); 
   /*** image icon for catch button. ***/ 
   private ImageIcon pokeball = new ImageIcon("IMAGE\\pokeball.png"); 
   /*** image icon for backpack. ***/ 
   private ImageIcon backpack = new ImageIcon("IMAGE\\backpack.png"); 
   /*** image icon for pokedex. ***/ 
   private ImageIcon pokedexImage = new ImageIcon("IMAGE\\pokedex.png"); 
   /** image icon for pokemon ran. ***/ 
   private ImageIcon ran = new ImageIcon("IMAGE\\ran.jpg");  
   /** image icon for bulbasaur 001. ***/ 
   private ImageIcon bulbasaurIcon = new ImageIcon("IMAGE\\001.png"); 
   /** image icon for ivysaur 002. ***/ 
   private ImageIcon ivysaurIcon = new ImageIcon("IMAGE\\002.png"); 
   /** image icon for venusaur 003. ***/ 
   private ImageIcon venusaurIcon = new ImageIcon("IMAGE\\003.png");
   /** image icon for charmander 004. ***/ 
   private ImageIcon charmanderIcon = new ImageIcon("IMAGE\\004.png");
   /** image icon for charmeleon 005. ***/ 
   private ImageIcon charmeleonIcon = new ImageIcon("IMAGE\\005.png");
   /** image icon for charizard 006. ***/ 
   private ImageIcon charizardIcon = new ImageIcon("IMAGE\\006.png");
   /** image icon for squirtle 007. ***/ 
   private ImageIcon squirtleIcon = new ImageIcon("IMAGE\\007.png");
   /** image icon for wartortle 008. ***/ 
   private ImageIcon wartortleIcon = new ImageIcon("IMAGE\\008.png");
   /** image icon for blastoise 009. ***/ 
   private ImageIcon blastoiseIcon = new ImageIcon("IMAGE\\009.png");
   /*** image icon for transferring icon. ***/ 
   private ImageIcon activeIcon = new ImageIcon(); 
   
   /*** Make bottom textArea scrollable. ***/
   private JScrollPane scroll = new JScrollPane(textArea, JScrollPane.
                                                VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                JScrollPane.
                                                HORIZONTAL_SCROLLBAR_NEVER);
   
  /**
  * Constructor for panels. 
  */
   public PokeGUI() {
      
      this.setLayout(new BorderLayout()); //Border panel layout
      this.setPreferredSize(new Dimension(600, 700));
      topSubPanel.setBackground(Color.red); 
      centerSubPanel.setBackground(Color.red); 
      leftSubPanel.setBackground(Color.red); 
      rightSubPanel.setBackground(Color.red); 
      bottomSubPanel.setBackground(Color.white); 
      bottomSubPanel.setPreferredSize(new Dimension(600, 275)); 
     
      //adding action listeners 
      bHunt.addActionListener(listener); 
      bCatch.addActionListener(listener); 
      bPokedex.addActionListener(listener); 
      bBackpack.addActionListener(listener); 
      sortByNum.addActionListener(listener); 
      sortByRecent.addActionListener(listener); 
      
      //TOP SUBPANEL 
      //header only in top subpanel  
      topHeader.setIcon(header);
      topSubPanel.add(topHeader);
      this.add("North", topSubPanel); 
      
      
      //LEFT SUBPANEL 
      leftSubPanel.setPreferredSize(new Dimension(175, 200)); 
      bHunt.setBackground(Color.yellow); 
      leftSubPanel.add(bHunt);
      pokeDisplay.setHorizontalAlignment(JLabel.CENTER);
      leftSubPanel.add(pokeDisplay); 
      this.add("West", leftSubPanel); 
      
      //CENTER SUBPANEL 
      //format text area for display hunt and catch messages 
      textHuntCatch.setBackground(Color.white); 
      textHuntCatch.setEditable(false); 
      textHuntCatch.setBorder(BorderFactory.createLineBorder(Color.black)); 
      centerSubPanel.add(textHuntCatch); 
      this.add("Center", centerSubPanel); 
      
      //RIGHT SUBPANEL 
      bCatch.setIcon(pokeball);
      //validate();
      bCatch.setEnabled(false); 
      rightSubPanel.setPreferredSize(new Dimension(175, 200));  
      rightSubPanel.add(bCatch);
      caughtOrNot.setHorizontalAlignment(JLabel.CENTER);
      rightSubPanel.add(caughtOrNot); 
      this.add("East", rightSubPanel);       
   
      //BOTTOM SUBPANEL 
      //adding message and buttons to bottom sub-panel 
      bPokedex.setIcon(pokedexImage);
      validate();
      bottomSubPanel.add(bPokedex);
      bBackpack.setIcon(backpack);
      validate();
      bottomSubPanel.add(bBackpack); 
      //format textArea for holding list
      textArea.setBackground(Color.red);
      textArea.setEditable(false);
      scroll.setBorder(null);
      //add scrollPane to panel, textArea inside.
      bottomSubPanel.add(scroll);          
      scroll.getVerticalScrollBar().setPreferredSize(new Dimension(14, 0));
      this.add("South", bottomSubPanel);
      
      //POPUP SUBPANEL
      String s = "How would you like to sort?";
      popUpMessage.setText(s);
      popUpMessage.setEditable(false);  
      popUp.add(popUpMessage); 
      bGroup.add(sortByNum); 
      bGroup.add(sortByRecent); 
      popUp.add(sortByNum);
      popUp.add(sortByRecent);  
     
      
   } //close PokeGUI constructor
  
 
 /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   
   /**
   * ActionPerformed method.
   * @param event which button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
      
         //if "Hunt" button clicked, random new pokemon  
         if (event.getSource() == bHunt) {
            pm = newPoke(); 
            pokeOut = ("A wild " + pm.getSpecies() + " appeared!\n" 
               + "You can try to catch it or keep hunting.");
            textHuntCatch.setText(pokeOut);
            caughtOrNot.setIcon(null); 
            bCatch.setEnabled(true); 
            
         //else if "Catch" pressed, random catch/escape 
         } else if (event.getSource()  == bCatch) {  
            
            boolean caughtIt; 
            Random randgen = new Random();
            
            pokeOut = ("Trying to catch the " + pm.getSpecies() + "...\n"); 
            textHuntCatch.setText(pokeOut); 
            caughtIt = randgen.nextBoolean(); 
            
            //if caught, add to pokedex and backpack + update displays
            if (caughtIt) {
               pokeOut += ("\nNice, you caught it!\n\n" 
                  + "Here are the stats for" 
                  + " your new Pokemon: \n" + pm.toString()); 
               textHuntCatch.setText(pokeOut); 
               pokeDisplay.setIcon(null); 
               caughtOrNot.setIcon(activeIcon); 
               validate(); 
               pokedex.add(pm); 
               backpackNum.add(pm); 
               backpackRecent.push(pm); 
               dexCount++; 
               packCount++; 
               
            //else not caught, update displays 
            } else {
               pokeDisplay.setIcon(null); 
               caughtOrNot.setIcon(ran);
               validate(); 
               pokeOut += ("\nAw man, it got away." + "\nTry hunting again."); 
               textHuntCatch.setText(pokeOut); 
            } //close if/else for catching pokemon
            
            bCatch.setEnabled(false); 
         
         //END TOP BUTTONS
         
         
         //else if "Pokedex" pressed, print BST inOrder           
         } else if (event.getSource() == bPokedex) {
            if (dexCount > 0) {
               textArea.setText(pokedex.toString()); 
            } else {
               textArea.setText("You haven't caught any pokemon yet."); 
            }
            
         //else if "Backpack" pressed,popUp asking choice then print appropriate
         } else if (event.getSource() == bBackpack) {
            
            JOptionPane.showMessageDialog(textHuntCatch, popUp); 
            
            //nested if/else actionlistener for radio buttons 
            if (!sortByNum.isSelected() && !sortByRecent.isSelected()) {
               pokeList = "You didn't select anything..."; 
               textArea.setText(pokeList); 
            } else if (sortByNum.isSelected()) {
               pokeList = ""; 
               while (backpackNum.size() > 0) {
                  pm = backpackNum.poll();
                  altBackpackNum.add(pm); 
                  pokeList += (pm.toString() + "\n\n"); 
               } 
               textArea.setText(pokeList); 
               
               for (int i = 0; i < packCount; i++) {
                  pm = altBackpackNum.poll(); 
                  backpackNum.add(pm); 
               } //close for refilling  
               
            } else if (sortByRecent.isSelected()) {
            
               pokeList = ""; 
               while (backpackRecent.size() > 0) {
                  pm = backpackRecent.poll();
                  altBackpackRecent.push(pm); 
                  pokeList += (pm.toString() + "\n\n"); 
               } 
               textArea.setText(pokeList); 
               
               for (int i = 0; i < packCount; i++) {
                  pm = altBackpackRecent.poll(); 
                  backpackRecent.add(pm); 
               } //close for refilling  
               
            } //close nested radio button if/else 
         
            bGroup.clearSelection(); 
            validate();    
         
         } //close backpack action listener 
                
      } //close actionEvent method
   
   
    
      /**
      * helper method for ActionListener.
      * randomly generates new pokemon.  
      * @return the new pokemon
      */
      private Pokemon newPoke() {
         Random randgen = new Random(); 
         int randNum = 0; 
         Pokemon p = null; 
      
         randNum = randgen.nextInt(9) + 1; 
         switch(randNum) {
            case 1:
               activeIcon = bulbasaurIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Bulbasaur();
               break; 
            case 2:
               activeIcon = ivysaurIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Ivysaur();
               break; 
            case 3:
               activeIcon = venusaurIcon; 
               pokeDisplay.setIcon(activeIcon);             
               validate();
               p = new Venusaur();
               break; 
            case 4:
               activeIcon = charmanderIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Charmander();
               break; 
            case 5:
               activeIcon = charmanderIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Charmeleon();
               break; 
            case 6:
               activeIcon = charizardIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Charizard();
               break; 
            case 7:  	
               activeIcon = squirtleIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Squirtle();
               break; 
            case 8:
               activeIcon = wartortleIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Wartortle();
               break; 
            case 9:
               activeIcon = blastoiseIcon; 
               pokeDisplay.setIcon(activeIcon);
               validate();
               p = new Blastoise();
               break;
         
            default: //not a valid menu entry
               System.out.println("\nSorry, no pokemon here.");
               break; 
         } //close switch
      
         return p; 
      
      } //close newPoke method 
   
   } // end GUIListener private class

} //end PokeGUI class
