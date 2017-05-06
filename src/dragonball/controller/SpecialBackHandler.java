package dragonball.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dragonball.view.AudioFilePlayer;
import dragonball.view.FighterOptionsVeiw;
import dragonball.view.MainMenuVeiw;
import dragonball.view.ModeVeiw;
import dragonball.view.StartGameVeiw;
import dragonball.view.WorldVeiw;

public class SpecialBackHandler implements ActionListener{
private FighterOptionsVeiw fighterOptionsVeiw ;
private WorldVeiw child; 

	public WorldVeiw getChild() {
	return child;
}

public void setChild(WorldVeiw child) {
	this.child = child;
}

	public SpecialBackHandler(WorldVeiw child,
			FighterOptionsVeiw fighterOptionsVeiw) {
		// TODO Auto-generated constructor stub
		this.fighterOptionsVeiw = fighterOptionsVeiw ; 
		this.child=child ; 
		//this.child =  new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(fighterOptionsVeiw.getGame()), fighterOptionsVeiw.getGame()), fighterOptionsVeiw.getGame()), fighterOptionsVeiw.getGame()) ; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		child.setVisible(true);
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    // your Code ... 
			    fighterOptionsVeiw.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
	}

}
