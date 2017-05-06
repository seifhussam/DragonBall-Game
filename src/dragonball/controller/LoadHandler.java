package dragonball.controller;

import java.awt.FlowLayout;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dragonball.model.game.Game;
import dragonball.view.AudioFilePlayer;
import dragonball.view.ModeVeiw;
import dragonball.view.StartGameVeiw;

public class LoadHandler implements ActionListener{
private ModeVeiw child1; 
private Game game ;
private StartGameVeiw parent ;
	public LoadHandler(ModeVeiw child1, Game game ,StartGameVeiw parent  ) {
		// TODO Auto-generated constructor stub
		this.child1 = child1;
		this.game = game ;
		this.parent=parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

        AudioFilePlayer.ButtonPressed();
		// TODO Auto-generated method stub
        try {
			game.load("save.ser");
			child1 = new ModeVeiw(parent,game) ;
			child1.setVisible(true);
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
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null ,"There are no saved data", "Load Error",  JOptionPane.OK_OPTION);
		}
	
	}

	public ModeVeiw getChild1() {
		return child1;
	}

	public void setChild1(ModeVeiw child1) {
		this.child1 = child1;
	}

}
