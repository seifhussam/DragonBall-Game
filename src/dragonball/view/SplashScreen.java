package dragonball.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.game.Game;

	public class SplashScreen  extends JFrame implements Serializable  {
		private MainMenuVeiw m;
		private Cursor cursor;
		static Thread sound;
		
		public SplashScreen () {
			// TODO Auto-generated constructor stub
			m = new MainMenuVeiw(new Game());
			 System.setProperty("awt.useSystemAAFontSettings","on");
			 System.setProperty("swing.aatext", "true");
			 Toolkit toolkit = Toolkit.getDefaultToolkit();
		        Image image = toolkit.getImage(getClass().getResource("4star_dragonball_by_chibi_fej-d4frd47.png"));
		        Point hotspot = new Point(0, 0);
		         cursor = toolkit.createCustomCursor(image, hotspot, "Stone");
		      
		        setCursor(cursor);
			    
			    setLayout(null);
				Icon i = new  ImageIcon(getClass().getResource("686150.jpg")) ;
				JLabel temp  = new JLabel(i) ;
				
				setContentPane(temp);
				
				Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
			    setSize(DimMax);
				setUndecorated(true); 
				setVisible(true);
			 Runnable r = new Runnable() {
				   public void run() {
				    try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				    m.setVisible(true);
				    
				    Runnable r1 = new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(1000) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							setVisible(false);
							validate();
						}
					};
				    Thread t1 = new Thread(r1) ; 
				    t1.start();
				   }
				 };
		
			Thread t  = new Thread(r) ; 
			t.start();
			
			music(true);
			
		}
		public void music(boolean a){
			Runnable soundRun = new Runnable() {
				   public void run() {
				    while(true){
					   AudioFilePlayer.PlayThemeMusic();
				    }
				   }
				 };
				 
			 sound = new Thread(soundRun) ;
			 
				sound.start();
	
			
		}

	}

