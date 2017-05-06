package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.FighterOptionsVeiw;
import dragonball.view.WorldVeiw;

public class FighterOptionsVeiwHandler implements ActionListener {
	private FighterOptionsVeiw child;
    private Game game ; 
    private WorldVeiw parent ; 
	public FighterOptionsVeiwHandler( WorldVeiw parent, Game game2, FighterOptionsVeiw child) {
		this.game = game2 ; 
		this.child = child;
		this.parent=parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child = new FighterOptionsVeiw(parent, game) ; 
		
		   child.setVisible(true);
		   child.validate();
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

	public FighterOptionsVeiw getChild() {
		return child;
	}

	public void setChild(FighterOptionsVeiw child) {
		this.child = child;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public WorldVeiw getParent() {
		return parent;
	}

	public void setParent(WorldVeiw parent) {
		this.parent = parent;
	}
	
	
}
