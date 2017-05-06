package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.GameVeiw;
import dragonball.view.NewGameVeiw;
import dragonball.view.StartGameVeiw;

public class NewGameHandler implements ActionListener {

	private NewGameVeiw child;
    private Game game ; 
    private StartGameVeiw startGameVeiw ; 
	public NewGameHandler( NewGameVeiw child, Game game2, StartGameVeiw startGameVeiw) {
		this.game = game2 ; 
		this.child = child;
		this.startGameVeiw=startGameVeiw;
	
		}

	@Override	
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		game = new Game () ; 
		child = new NewGameVeiw(startGameVeiw,game);
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    startGameVeiw.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
		this.child.setVisible(true );
	}



	public NewGameVeiw getChild() {
		return child;
	}

	public void setChild(NewGameVeiw child) {
		this.child = child;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}



}
