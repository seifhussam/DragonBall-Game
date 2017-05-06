package dragonball.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.view.AudioFilePlayer;

public class TournamentBackHandler implements ActionListener {
	private JFrame parent;
	private JFrame child ;
	private Font JcustomFont;

	

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	public JFrame getChild() {
		return child;
	}

	public void setChild(JFrame child) {
		this.child = child;
	}

	public TournamentBackHandler(JFrame parent2, JFrame startGameVeiw) {
		this.parent = parent2;
	
		this.setChild(startGameVeiw);
	}
	 private JPanel getPanel() {
		  JcustomFont= new Font("Serif",Font.PLAIN,14);
			try {
			    //create the font to use. Specify the size!
			   JcustomFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(30f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
			} catch (IOException e) {
			    e.printStackTrace();
			} catch(FontFormatException e) {
			    e.printStackTrace();
			}
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("ARE YOU SURE YOU WANT TO EXIT THE TOURNAMENT ");
	        label.setFont(JcustomFont);
	       
	        label.setForeground(Color.red); 
	        ImageIcon image = null;
	       
	            image = new ImageIcon(getClass().getResource("son_goku__plans_to_eradicate_the_saiyans__by_delvallejoel-d5vwebz.jpg"));
	        

	        label.setIcon(image);
	        panel.add(label);

	        return panel;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

        AudioFilePlayer.ButtonPressed();
		int reply = JOptionPane.showConfirmDialog(null, getPanel(), "Exit",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		{
		  
		

		parent.setVisible(true);
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    // your Code ... 
			    child.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
		}
		
		
		
	}
	

}
