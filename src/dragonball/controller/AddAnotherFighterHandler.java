package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dragonball.model.game.Game;
import dragonball.view.AddAnotherFighter;
import dragonball.view.AudioFilePlayer;
import dragonball.view.ModeVeiw;
import dragonball.view.SelectFighterView;


public class AddAnotherFighterHandler implements ActionListener{
private JFrame  child ; 
private AddAnotherFighter parent ; 
private Game  game ; 
private JTextField FighterName ;
private JLabel type ;

	public AddAnotherFighterHandler(
		AddAnotherFighter parent,JFrame child,JTextField fightername, Game game,JLabel type ) {
	this.child = child;
	this.parent = parent;
	this.game = game;
	this.FighterName=fightername;
	this.type = type ; 
}

	@Override
	public void actionPerformed(ActionEvent arg0) {

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
			System.out.println(game);	
		    game.getPlayer().createFighter(c, Name);
		    System.out.println("Size :"+game.getPlayer().getFighters().size());
		    if (child instanceof SelectFighterView)
			child = new SelectFighterView(parent,game) ; 
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
