package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.ModeVeiw;
import dragonball.view.NewGameVeiw;
import dragonball.view.SelectFighterView;

public class SelectHandler implements ActionListener  {
	private ModeVeiw parent ; 
	private SelectFighterView child ; 
	private Game game ;
	

	public SelectHandler(ModeVeiw parent, SelectFighterView child, Game game) {
		this.parent = parent;
		this.child = child;
		this.game = game;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child = new SelectFighterView(parent,game);
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
