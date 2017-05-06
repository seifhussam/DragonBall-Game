package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.CreateFighterVeiw;
import dragonball.view.ModeVeiw;
import dragonball.view.StartGameVeiw;

public class Next2Handler implements ActionListener {
	private CreateFighterVeiw parent ; 
	private ModeVeiw child ; 
	private JTextField FighterName ;
	private Game game ;
	private JLabel type ;
	
	public Next2Handler( CreateFighterVeiw parent,
			ModeVeiw child, JTextField fighterName, Game game , JLabel type ) {
		
		this.parent = parent;
		this.child = child;
		FighterName = fighterName;
		this.game = game ; 
		this.type = type ; 
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
		String Update = (FighterName.getText());
		if (!containSpace(Update)|| Update.length() == 0) {
			valid = false ; 
			JOptionPane.showMessageDialog(null, "Please enter a valid Player Name \n A valid player name consist of letters only");
			FighterName.setText("");
		}
		else {
			for (int i = 0; i < Update.length(); i++) {
				if (!(Character.isAlphabetic(Update.charAt(i))|| Update.charAt(i) == ' ') ) {
					valid = false ; 
					JOptionPane.showMessageDialog(null, "Please enter a valid Player Name \n A valid player name consist of letters only");
					FighterName.setText("");
				}
			}
		}
	
		if (valid) {
			String Name = FighterName.getText() ; 
			String typo = type.getText() ; 
			System.out.println(typo);
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
			System.out.println(typo);	
		    game.getPlayer().createFighter(c, Name);
		    
			child = new ModeVeiw(parent,game) ; 
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


	


	public JFrame getParent() {
		return parent;
	}


	public void setParent(CreateFighterVeiw parent) {
		this.parent = parent;
	}


	public ModeVeiw getChild() {
		return child;
	}


	public void setChild(ModeVeiw child) {
		this.child = child;
	}


	public JTextField getFighterName() {
		return FighterName;
	}


	public void setFighterName(JTextField fighterName) {
		FighterName = fighterName;
	}
	
	
}
