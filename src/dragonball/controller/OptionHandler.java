package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.GameVeiw;
import dragonball.view.MainMenuVeiw;
import dragonball.view.OptionVeiw;

public class OptionHandler implements ActionListener {
	private GameVeiw gameveiw;
	private MainMenuVeiw mainMenuVeiw;
	private OptionVeiw child2;
	private Game game ; 
	public OptionHandler(OptionVeiw child2, GameVeiw gameveiw, Game game) {
		this.setChild2(child2);
		this.gameveiw = gameveiw;
		this.game = game ; 
		this.setMainMenuVeiw((MainMenuVeiw) gameveiw);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
	child2 = new OptionVeiw(mainMenuVeiw, game) ; 
	
		   child2.setVisible(true);
		   Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    mainMenuVeiw.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
		   child2.validate();
	}
	public OptionVeiw getChild2() {
		return child2;
	}
	public void setChild2(OptionVeiw child2) {
		this.child2 = child2;
	}
	public MainMenuVeiw getMainMenuVeiw() {
		return mainMenuVeiw;
	}
	public void setMainMenuVeiw(MainMenuVeiw mainMenuVeiw) {
		this.mainMenuVeiw = mainMenuVeiw;
	}
	
}
