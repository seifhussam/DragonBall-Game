package dragonball.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dragonball.view.AudioFilePlayer;
import dragonball.view.GameVeiw;
import dragonball.view.MainMenuVeiw;
import dragonball.view.StartGameVeiw;

public class BackHandler implements ActionListener {
	
	private JFrame parent;
	private JFrame child ;

	

	public BackHandler(JFrame parent2, JFrame startGameVeiw) {
		this.parent = parent2;
	
		this.setChild(startGameVeiw);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
		parent.setVisible(true);
		
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    // your Code ... 
			    child.setVisible(false);
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
	
		
		
		
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	
	public JFrame getChild() {
		return child;
	}

	public void setChild(JFrame startGameVeiw) {
		this.child = startGameVeiw;
	}

}
