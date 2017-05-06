package dragonball.controller;

import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.CreateFighterVeiw;

public class Next1Handler implements ActionListener { 

	private JFrame parent ; 
	private CreateFighterVeiw child ; 
	private JTextField PlayerName ;
	private Game game ;
	
	public Next1Handler( JFrame parent,
			CreateFighterVeiw child, JTextField playerName,Game game) {
		this.parent = parent;
		this.child = child;
		PlayerName = playerName;
		this.game = game ;
	
	}
	private boolean containSpace(String actionCommand) {
		// TODO Auto-generated method stub
		for (int i = 0; i < actionCommand.length(); i++) {
			if(actionCommand.charAt(i)!=' ') {
				return true ;
		}
		}
		return false;
	}
@Override
	public void actionPerformed(ActionEvent Event) {

    AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		boolean valid = true ; 
		String Update = (PlayerName.getText());
		if (!containSpace(Update)|| Update.length() == 0) {
			valid = false ; 
			JOptionPane.showMessageDialog(null, "Please enter a valid Player Name \n A valid player name consist of letters only");
			PlayerName.setText("");
		}
		else {
			for (int i = 0; i < Update.length(); i++) {
				if (!(Character.isAlphabetic(Update.charAt(i))|| Update.charAt(i) == ' ') ) {
					valid = false ; 
					JOptionPane.showMessageDialog(null, "Please enter a valid Player Name \n A valid player name consist of letters only");
					PlayerName.setText("");
				}
			}
		}
	
		if (valid) {

			game = new Game();
			game.getPlayer().setName(PlayerName.getText());
			child = new CreateFighterVeiw( parent, PlayerName.getText(),game) ; 
			child.setVisible(true);
			  Runnable r = new Runnable() {
				   public void run() {
				    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    parent.setVisible(false);
				   }
				 };
			Thread t = new Thread(r) ;
			t.start();
			
			
		
		}
}

}
