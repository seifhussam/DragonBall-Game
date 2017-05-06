package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.GameVeiw;
import dragonball.view.MainMenuVeiw;

public class MainMenuBackHandler implements ActionListener {
	
  private	MainMenuVeiw parent ;  
  private   GameVeiw   child ; 
  private   Game game ; 
	

	public MainMenuVeiw getParent() {
	return parent;
}


public void setParent(MainMenuVeiw parent) {
	this.parent = parent;
}


public GameVeiw getChild() {
	return child;
}


public void setChild(GameVeiw child) {
	this.child = child;
}


public Game getGame() {
	return game;
}


public void setGame(Game game) {
	this.game = game;
}


	public MainMenuBackHandler( GameVeiw child, Game game) {
	
	this.child = child;
	this.game = game;
}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub 

        AudioFilePlayer.ButtonPressed();
		parent = new MainMenuVeiw(game) ;
		parent.setVisible(true); 
		
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    child.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
	}

}
