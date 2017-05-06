package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.ModeVeiw;
import dragonball.view.OptionVeiw;
import dragonball.view.WorldVeiw;

public class WorldHandler implements ActionListener {
   private ModeVeiw parent ; 
   private WorldVeiw child ; 
   private Game game ; 
   
   
   
	public WorldHandler(ModeVeiw parent, WorldVeiw child, Game game) {
	this.parent = parent;
	this.child = child;
	this.game = game;
}



	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child = new WorldVeiw(parent, game) ; 
		
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
		   child.validate();
	}

}
