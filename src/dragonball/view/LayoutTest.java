package dragonball.view;

import java.io.Serializable;



public class LayoutTest implements Serializable {

public static void main(String[] args) {
	  System.setProperty("awt.useSystemAAFontSettings","on");
	  System.setProperty("swing.aatext", "true");
	  javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
        	  new SplashScreen() ;
          }
      });  
}


// Seif the line to add the blast sound to any attack is
//
//AudioFilePlayer.PlaySound();



}