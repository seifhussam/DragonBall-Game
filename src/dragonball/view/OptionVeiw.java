package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.controller.MainMenuBackHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class OptionVeiw extends GameVeiw implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainMenuVeiw Parentt ; 
	private Font customFont ;
	private JButton Sound ; 
	private JButton Back ; 
	private JButton Exit ;
	private Font JcustomFont;
	private JLabel Paragaph;
	private JLabel FirstSentence;
	private static int soundint = 0 ;
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	public OptionVeiw(MainMenuVeiw Parent,Game game ) {
		super(game);
		this.setParentt(Parent);
		 Icon SoundOn = new ImageIcon(getClass().getResource("SoundOn.png"));
		 Icon SoundOFF= new ImageIcon(getClass().getResource("SoundOFF.png"));
		 //17824_dragon_ball_z.jpg
		 Icon i = new  ImageIcon(getClass().getResource("42171_dragon_ball_z_shenron_dragon.jpg")) ;
			JLabel temp  = new JLabel(i) ;
			setContentPane(temp);
		 customFont= new Font("Serif",Font.PLAIN,14);
			try {
			    //create the font to use. Specify the size!
			   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(42f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
			} catch (IOException e) {
			    e.printStackTrace();
			} catch(FontFormatException e) {
			    e.printStackTrace();
			}
			
			setLayout(null);
			Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		    setSize(DimMax);
			setUndecorated(true);
			
//			Sound = new JButton(SoundOn) ; 
//			Sound.setSize(400,250);
//			Sound.setFont(customFont);
//			Sound.setFocusable(false);
//			Sound.setOpaque(false);
//			Sound.setContentAreaFilled(false);
//			Sound.setBorderPainted(false);
//			Sound.setLocation(this.getWidth()/2-Sound.getWidth()/2, this.getHeight()/2-Sound.getHeight()/2); 
//			Sound.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					// TODO Auto-generated method stub
//					if (Math.abs(++soundint) % 2 == 1 ){
//					Sound.setIcon(SoundOFF);
//					
//					}
//				
//				else {
//					Sound.setIcon(SoundOn);
//					
//				}
//				
//			}
//			});
//			add(Sound) ; 
	
	
			Paragaph = new JLabel(new ImageIcon(getClass().getResource("About.png")));
			Paragaph.setSize(Paragaph.getPreferredSize()) ; 
			Paragaph.setLocation(1920 /2 - Paragaph.getWidth()/2 , 1080);
			Paragaph.setForeground(Color.red);
			add(Paragaph) ; 
			
			new Thread (new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1080; j >= -1 *Paragaph.getHeight() ; j--) {
						
						Paragaph.setLocation(Paragaph.getX() , j); 
						validate() ; 
						repaint() ; 
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						if (j == -1*Paragaph.getHeight()){
							j = 1080;
						}
						
					}
					
				}
			}).start();
			
			
			
			
			
			
			
			Icon Exit1 = new ImageIcon(getClass().getResource("ExitRed.png")); 
			Icon Exitrev = new ImageIcon(getClass().getResource("ExitBlue.png"));	
			
				Exit = new JButton(Exit1) ; 
				Exit.setRolloverIcon(Exitrev);
				Exit.setFont(customFont);  
				Exit.setContentAreaFilled(false);
				Exit.setBorderPainted(false);
				Exit.setFocusable(false);
				Exit.setSize(BUTTONWIDTH,BUTTONHEIGHT);
		        Exit.setLocation(this.getWidth()-BUTTONWIDTH,getHeight()-BUTTONHEIGHT);
		        
		        
		        
		        JcustomFont= new Font("Serif",Font.PLAIN,14);
				try {
				    //create the font to use. Specify the size!
				   JcustomFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(30f);
				    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				    //register the font
				    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
				} catch (IOException e) {
				    e.printStackTrace();
				} catch(FontFormatException e) {
				    e.printStackTrace();
				}
			Exit.addActionListener(new ActionListener() {
				 private JPanel getPanel() {
				        JPanel panel = new JPanel();
				        JLabel label = new JLabel("ARE YOU AWESOME ");
				        label.setFont(JcustomFont);
				       
				        label.setForeground(Color.red); 
				        ImageIcon image = null;
				       
				            image = new ImageIcon(getClass().getResource("son_goku__plans_to_eradicate_the_saiyans__by_delvallejoel-d5vwebz.jpg"));
				        

				        label.setIcon(image);
				        panel.add(label);

				        return panel;
				    }
				@Override
				public void actionPerformed(ActionEvent Event) {
					// TODO Auto-generated method stub
					
					

					int reply = JOptionPane.showConfirmDialog(null, getPanel(), "Exit",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.NO_OPTION)
					{
					   System.exit(0);
					}

				}
			} );
				add(Exit);
				Icon back1 = new ImageIcon(getClass().getResource("BackRed.png")); 
				Icon backrev = new ImageIcon(getClass().getResource("BackBlue.png"));	
				Back = new JButton(back1);   
				Back.setRolloverIcon(backrev);
				Back.setContentAreaFilled(false);
				Back.setBorderPainted(false);
				Back.setFocusable(false);
				Back.setSize(BUTTONWIDTH,BUTTONHEIGHT);          
				Back.setFont(customFont);
		        Back.setLocation(0, this.getHeight()-BUTTONHEIGHT);
		        Back.addActionListener(new MainMenuBackHandler( this, game));
		        add(Back);
			this.validate();
	}
	public MainMenuVeiw getParentt() {
		return Parentt;
	}
	public void setParentt(MainMenuVeiw parentt) {
		Parentt = parentt;
	}
	@Override
	public void onDragonCalled(Dragon dragon) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCollectibleFound(Collectible collectible) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBattleEvent(BattleEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTournamentEvent(TournamentStatus status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStageComplete(int stage) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTournamentMatchEvent(BattleEvent e, MatchStatus matchStatus) {
		// TODO Auto-generated method stub
		
	}
	
}
