package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dragonball.model.game.Game;
import dragonball.view.AddAnotherFighter;
import dragonball.view.AudioFilePlayer;

public class CreateFighterInTournamentHandler implements ActionListener {
	private JFrame parent ; 
	private AddAnotherFighter child ; 
	private Game game ; 

	public CreateFighterInTournamentHandler(
			JFrame selectFighterView, AddAnotherFighter child2,
			Game game) {
		this.parent = selectFighterView ; 
		this.child = child2; 
		this.game = game ; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child = new AddAnotherFighter(parent, game.getPlayer().getName() , game) ; 
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
		this.child.setVisible(true );
	}

}
