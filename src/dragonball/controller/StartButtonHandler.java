package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.MainMenuVeiw;
import dragonball.view.StartGameVeiw;

public class StartButtonHandler implements ActionListener {

	private MainMenuVeiw mainMenuVeiw;
    private StartGameVeiw child1;
    private Game game ;
    
	public StartButtonHandler(StartGameVeiw child1, MainMenuVeiw mainMenuVeiw,Game game) {
		this.child1 = child1;
		this.mainMenuVeiw = mainMenuVeiw;
		this.game=game ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub 
       child1 = new StartGameVeiw(mainMenuVeiw, game);
       
	   child1.setVisible(true); 
	   child1.validate();
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
		
	}



	public MainMenuVeiw getMainMenuVeiw() {
		return mainMenuVeiw;
	}

	public void setMainMenuVeiw(MainMenuVeiw mainMenuVeiw) {
		this.mainMenuVeiw = mainMenuVeiw;
	}

}
