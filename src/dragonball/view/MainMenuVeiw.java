package dragonball.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.controller.OptionHandler;
import dragonball.controller.StartButtonHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;
import dragonball.view.WorldVeiw.buttonMouse;


public class MainMenuVeiw extends GameVeiw implements Serializable{
private JButton StartGame ; 
private JButton Options ; 
private JButton Exit ; 
private Font customFont ;
final static int BUTTONWIDTH = 250 ; 
final static int BUTTONHEIGHT= 100  ;
private StartGameVeiw Child1 ; 
private OptionVeiw Child2 ;
private JPanel Menu ; 
private JLabel Title ;
private JLabel MainMenu ;
private Font JcustomFont; 

public MainMenuVeiw(Game game ) {
	// TODO Auto-generated constructor stu
	 super(game) ;
	 System.setProperty("awt.useSystemAAFontSettings","on");
	 System.setProperty("swing.aatext", "true");
	Icon Start = new ImageIcon(getClass().getResource("StartGameRed.png"));
	Icon Startrev = new ImageIcon(getClass().getResource("StartGameBlue.png"));
	Icon Options1 = new ImageIcon(getClass().getResource("OptionsRed.png"));
	Icon Optionsrev = new ImageIcon(getClass().getResource("OptionsBlue.png"));
	Icon Exit1 = new ImageIcon(getClass().getResource("ExitMainRed.png"));
	Icon Exitrev = new ImageIcon(getClass().getResource("ExitMainBlue.png"));
	 customFont= new Font("Serif",Font.PLAIN,14);
	try {
	    //create the font to use. Specify the size!
	   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(72f);
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    //register the font
	    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
	} catch (IOException e) {
	    e.printStackTrace();
	} catch(FontFormatException e) {
	    e.printStackTrace();
	}
	
	Font customFont1= new Font("Serif",Font.PLAIN,14);
	try {
	    //create the font to use. Specify the size!
	   customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(72f);
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    //register the font
	    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
	} catch (IOException e) {
	    e.printStackTrace();
	} catch(FontFormatException e) {
	    e.printStackTrace();
	}
	
	 Font CcustomFont= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			CcustomFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(100f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
	
	setLayout(null);
	Icon i = new  ImageIcon(getClass().getResource("686146.jpg")) ;
	JLabel temp  = new JLabel(i) ;
	setContentPane(temp);
	Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(DimMax);
	setUndecorated(true); 
	
	

	
	Title = new JLabel("Dragon Ball Z") ; 
	Title.setFont(CcustomFont);
	Title.setForeground(new Color(204, 0, 51)); 
	Title.setSize(Title.getPreferredSize());
	Title.setLocation((getWidth()-Title.getWidth())/2, 100);
	add(Title);
	Menu = new JPanel() ; 
	Menu.setLayout(null);
      Menu.setOpaque(false);
   
	Menu.setSize(397,400); 
	MainMenu = new JLabel("Main Menu");
	MainMenu.setFont(customFont1);
	MainMenu.setForeground(Color.red);
	MainMenu.setSize(294,100); 
	MainMenu.setLocation((Menu.getWidth()-MainMenu.getWidth())/2, 0);
	
	//Menu.add(MainMenu);
	Menu.setLocation(12, 300);
	
	StartGame = new JButton(Start);
	StartGame.setRolloverIcon(Startrev);
	StartGame.setForeground(Color.red); 
	StartGame.setFont(customFont);
	StartGame.setSize(397,BUTTONHEIGHT);
    StartGame.setFocusable(false);
	StartGame.setOpaque(false);
	StartGame.setContentAreaFilled(false);
	StartGame.setBorderPainted(false);
	
	
	Options = new JButton("About"); 
	Options.setForeground(Color.red); 
    Options.setRolloverIcon(Optionsrev);
	Options.setBackground(null);
	Options.setFont(customFont);
	Options.setSize(397,BUTTONHEIGHT);
	Options.setOpaque(false);
	Options.setContentAreaFilled(false);
	Options.setBorderPainted(false);
	Options.setFocusable(false);
    Options.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Options.setForeground(Color.red);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Options.setForeground(Color.blue);
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	Exit = new JButton(Exit1);

	Exit.setRolloverIcon(Exitrev);
	Exit.setFont(customFont);
	Exit.setSize(397,BUTTONHEIGHT);
	Exit.setForeground(Color.red); 
	Exit.setFocusable(false);
	Exit.setOpaque(false);
	Exit.setContentAreaFilled(false);
	Exit.setBorderPainted(false);

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
	Menu.add(StartGame); 
	Menu.add(Options); 
	Menu.add(Exit);
	
	StartGame.setLocation(0, 100);
	Options.setLocation(0, 200);	
	Exit.setLocation(0, 300);
	add(Menu);
	StartGame.addActionListener(new StartButtonHandler(Child1,this,getGame()));
	Options.addActionListener(new OptionHandler(Child2, this,getGame()));

    validate();
    
}

public JButton getStartGame() {
	return StartGame;
}
public void setStartGame(JButton startGame) {
	StartGame = startGame;
}
public JButton getOptions() {
	return Options;
}
public void setOptions(JButton options) {
	Options = options;
}
public JButton getExit() {
	return Exit;
}
public void setExit(JButton exit) {
	Exit = exit;
}
public Font getCustomFont() {
	return customFont;
}
public void setCustomFont(Font customFont) {
	this.customFont = customFont;
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
