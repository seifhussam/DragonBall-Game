package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.ModeVeiw;
import dragonball.view.NewGameVeiw;
import dragonball.view.SelectFighterView;
import dragonball.view.TournamentView;

public class StartTournamentHandler implements ActionListener{
	private SelectFighterView parent ; 
	private TournamentView child ; 
	private Game game ; 
	private ArrayList<PlayableFighter> myFighters ; 

	public StartTournamentHandler(ArrayList<PlayableFighter> selectedFighters,
			SelectFighterView selectFighterView, TournamentView child2,
			Game game2) {
		child = child2 ; 
		parent = selectFighterView ; 
		game = game2 ; 
		myFighters = selectedFighters ; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child = new TournamentView(parent,game,myFighters);
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
