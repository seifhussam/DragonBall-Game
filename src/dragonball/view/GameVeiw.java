package dragonball.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.game.Game;
import dragonball.model.game.GameListener;

abstract public class GameVeiw extends JFrame implements GameListener,Serializable{
	private Game game ;  
	private JFrame MainFrame ;
	public static  Cursor cursor; 
	
	public GameVeiw(Game game) {
		// TODO Auto-generated constructor stub
		this.game=game ;

		 System.setProperty("awt.useSystemAAFontSettings","on");
		 System.setProperty("swing.aatext", "true");
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Image image = toolkit.getImage(getClass().getResource("4star_dragonball_by_chibi_fej-d4frd47.png"));
	        Point hotspot = new Point(0, 0);
	         cursor = toolkit.createCustomCursor(image, hotspot, "Stone");
	      
	        setCursor(cursor);
		
 	}
  
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}

	public JFrame getMainFrame() {
		return MainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		MainFrame = mainFrame;
	}
	
}
