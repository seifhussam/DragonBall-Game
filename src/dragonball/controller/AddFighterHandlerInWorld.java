package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dragonball.model.game.Game;
import dragonball.view.AddFighterInWorld;
import dragonball.view.AudioFilePlayer;
import dragonball.view.FighterOptionsVeiw;
import dragonball.view.MainMenuVeiw;
import dragonball.view.ModeVeiw;
import dragonball.view.SelectFighterView;
import dragonball.view.StartGameVeiw;
import dragonball.view.WorldVeiw;

public class AddFighterHandlerInWorld implements ActionListener {
private JFrame child ; 
private JFrame parent ; 
private JTextField FighterName ; 
private Game game ; 
private JLabel type; 

	public AddFighterHandlerInWorld(JFrame parent,
			JFrame child, JTextField FighterName, Game game,
			JLabel fighterrType) {
		this.child = child ; 
		this.parent = parent ; 
		this.FighterName = FighterName ; 
		this.game = game ; 
		this.type = fighterrType ; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		boolean valid = true ; 
		String Update = (FighterName.getText());
		if (!containSpace(Update)) {
			valid = false ; 
			JOptionPane.showMessageDialog(null, "Please enter a valid Fighter Name \n A valid fighter name consist of letters only");
			
		}
		else {
			for (int i = 0; i < Update.length(); i++) {
				if (!(Character.isAlphabetic(Update.charAt(i))|| Update.charAt(i) == ' ') ) {
					valid = false ; 
					JOptionPane.showMessageDialog(null, "Please enter a valid Player Name \n A valid fighter name consist of letters only");
					FighterName.setText("");
				}
			}
		}
		if (valid) {
			String Name = FighterName.getText() ; 
			String typo = type.getText() ; 
			char c ; 
			if (typo.equals("Earthling"))
				c='E' ; 
			else if (typo.equals("Frieza"))
				c='F' ; 
			else if (typo.equals("Majin"))
				c='M' ; 
			else if (typo.equals("Namekian")) 
				c = 'N' ; 
			else 
				c= 'S' ;
		
		    game.getPlayer().createFighter(c, Name);
	       
			child = new FighterOptionsVeiw(new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(game), game), game), game), game) ; 
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
	private boolean containSpace(String actionCommand) {
		// TODO Auto-generated method stub
		for (int i = 0; i < actionCommand.length(); i++) {
			if(actionCommand.charAt(i)!=' ') {
				return true ;
		}
		}
		return false;
	}

	

}
