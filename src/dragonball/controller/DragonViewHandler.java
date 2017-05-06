package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.DragonView;
import dragonball.view.MainMenuVeiw;
import dragonball.view.ModeVeiw;
import dragonball.view.StartGameVeiw;
import dragonball.view.WorldVeiw;


public class DragonViewHandler implements ActionListener {
	
	private Game game;
	private Dragon dragon;
	private JButton button;
	private JFrame parent ; 
	private DragonView child ;
	
	public DragonViewHandler(Game game,Dragon dragon,JButton button,JFrame parent, DragonView child ){
		this.parent = parent ; 
		this.game = game;
		this.dragon = dragon;
		this.button = button;
		this.child = child ; 
		
		
	}
	
	public void actionPerformed(ActionEvent arg0) {

        AudioFilePlayer.ButtonPressed();
		DragonWish[] wishes = dragon.getWishes();
		if(button.getText().equalsIgnoreCase("Ability Points")){
			game.getPlayer().chooseWish(wishes[0]);
		}else{ if(button.getText().equalsIgnoreCase("Senzu Beans")){
			game.getPlayer().chooseWish(wishes[1]);
		}else{ if(button.getText().equalsIgnoreCase("New Random Super Attack")){
			game.getPlayer().chooseWish(wishes[2]);
		}else{ if(button.getText().equalsIgnoreCase("New Random Ultimate Attack")){
			game.getPlayer().chooseWish(wishes[3]);
		}}}}	
  parent = new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(game), game), game), game) ; 
  Runnable r1 = new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		parent . setVisible(true );
		 Runnable r = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					child.setVisible(false) ; 
				}
			};
			Thread t = new Thread(r) ; 
			t.start();
	}
};
  Thread t1 = new Thread(r1) ;
  t1.start();
 
  
	
	}
	
	



}
