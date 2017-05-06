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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.controller.BackHandler;
import dragonball.controller.MainMenuBackHandler;
import dragonball.controller.SelectHandler;
import dragonball.controller.StartTournamentHandler;
import dragonball.controller.WorldHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class ModeVeiw extends GameVeiw implements Serializable {
	private JButton WorldMode ; 
	private JButton TournamentMode; 
	private JButton Back ; 
	private JButton Exit ;
	private JFrame Parent ; 
	private Font customFont ;
	private JLabel  picture ;
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	private WorldVeiw child ; 
	private SelectFighterView child2;
	private Font JcustomFont;



public ModeVeiw ( JFrame  startGameVeiw,Game game) {
	// TODO Auto-generated constructor stub
	super(game);

	this.Parent=startGameVeiw ; 
	Icon world = new ImageIcon(getClass().getResource("WorldRed.png")) ;
	Icon worldrev = new ImageIcon(getClass().getResource("WorldBlue.png")) ;
	Icon Tournament = new ImageIcon(getClass().getResource("TournamentRed.png")) ;
	Icon TournamentRev = new ImageIcon(getClass().getResource("Tournament.png")) ;
	
	Icon i = new  ImageIcon(getClass().getResource("dragon-ball_00290641.jpg")) ;
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
		Font custom1= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
		   custom1 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(100f);
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
		
		picture = new JLabel("Select A Mode");
		picture.setFont(custom1);
		picture.setSize(picture.getPreferredSize());
		picture.setForeground(new Color(204, 0, 51));
		picture.setLocation(getWidth()/2-picture.getWidth()/2 , 50);
	
		add(picture);
		
		WorldMode = new JButton(world) ;
		WorldMode.setRolloverIcon(worldrev);
		WorldMode.setSize(WorldMode.getPreferredSize());
		WorldMode.setFont(customFont);
		WorldMode.setLocation(getWidth()*3/10, getHeight()/2);
		WorldMode.setFocusable(false);
		WorldMode.setOpaque(false);
		WorldMode.setContentAreaFilled(false);
		WorldMode.setBorderPainted(false);
		WorldMode.addActionListener(new WorldHandler(this, child, getGame())) ; 
	
	add(WorldMode) ; 
		
	TournamentMode = new JButton(Tournament) ; 
	TournamentMode.setRolloverIcon(TournamentRev);
	TournamentMode.setSize(TournamentMode.getPreferredSize());
	TournamentMode.setFont(customFont);
	TournamentMode.setLocation(getWidth()*6/10,getHeight()/2); 
	TournamentMode.setFocusable(false);
	TournamentMode.setOpaque(false);
	TournamentMode.setContentAreaFilled(false);
	TournamentMode.setBorderPainted(false);
	TournamentMode.addActionListener(new SelectHandler(this,child2  , game ));
	add(TournamentMode) ; 
	
	
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
        Back.addActionListener(new BackHandler(new StartGameVeiw( new MainMenuVeiw(game), getGame()),this));
        add(Back);
		validate();
		
}
public JButton getWorldMode() {
	return WorldMode;
}
public void setWorldMode(JButton newGame) {
	WorldMode = newGame;
}
public JButton getTournamentMode() {
	return TournamentMode;
}
public void setTournamentMode(JButton loadGame) {
	TournamentMode = loadGame;
}
public JButton getBack() {
	return Back;
}
public void setBack(JButton back) {
	Back = back;
}
public JButton getExit() {
	return Exit;
}
public void setExit(JButton exit) {
	Exit = exit;
}
public JFrame getParent() {
	return Parent;
}
public void setParent(JFrame parent) {
	Parent = parent;
}
public Font getCustomFont() {
	return customFont;
}
public void setCustomFont(Font customFont) {
	this.customFont = customFont;
}

public JLabel getPicture() {
	return picture;
}
public void setPicture(JLabel picture) {
	this.picture = picture;
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


