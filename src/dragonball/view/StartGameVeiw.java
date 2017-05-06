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

import dragonball.controller.BackHandler;
import dragonball.controller.LoadHandler;
import dragonball.controller.NewGameHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class StartGameVeiw extends GameVeiw implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private JButton NewGame ; 
	private JButton LoadGame; 
	private JButton Back ; 
	private JButton Exit ;
	private MainMenuVeiw Parent ; 
	private Font customFont ;
	private ModeVeiw Child1;
	private NewGameVeiw child2 ; 
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	private JLabel Title ;
	private Font JcustomFont; 
	
public StartGameVeiw(MainMenuVeiw Parent, Game game) {
	// TODO Auto-generated constructor stu
	super(game);
	this.Parent=Parent ; 
	Icon NewGame1 = new ImageIcon(getClass().getResource("NewGameRed.png"));
	Icon NewGamerev = new ImageIcon(getClass().getResource("NewGameBlue.png"));
	Icon LoadGame1 = new ImageIcon(getClass().getResource("LoadGameRed.png"));
	Icon LoadGAmeRev = new ImageIcon(getClass().getResource("LoadGameBlue.png"));
	 
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
		Font customFont1= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
		   customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(100f);
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
		
		Icon i = new  ImageIcon(getClass().getResource("lFFTnhC.jpg")) ;
		JLabel temp1  = new JLabel(i) ;
		setContentPane(temp1);
		
		Title = new JLabel("Please Choose One") ; 
		Title.setFont(customFont1);
		Title.setForeground(new Color(204, 0, 51)); 
		Title.setSize(Title.getPreferredSize());
		Title.setLocation((getWidth()-Title.getWidth())/2, 100);
		add(Title);
		
		NewGame = new JButton(NewGame1) ; 
		NewGame.setSize(NewGame.getPreferredSize());
		NewGame.setFont(customFont);
		NewGame.setLocation(getWidth()*3/10, getHeight()/2); 
		NewGame.setOpaque(false); 
		NewGame.setRolloverIcon(NewGamerev);
        NewGame.setContentAreaFilled(false);
		NewGame.setBorderPainted(false);
		NewGame.setFocusable(false);
	
	boolean temp = false ;
	NewGame.addActionListener(new NewGameHandler(child2,super.getGame(),this));
	add(NewGame) ; 
		
	    LoadGame = new JButton(LoadGame1) ; 
	    LoadGame.setRolloverIcon(LoadGAmeRev);
	    LoadGame.setContentAreaFilled(false);
		LoadGame.setBorderPainted(false);
		LoadGame.setSize(LoadGame.getPreferredSize());
		LoadGame.setFont(customFont);
		LoadGame.setFocusable(false);
	LoadGame.setLocation(getWidth()*6/10,getHeight()/2); 

	LoadGame.addActionListener(new LoadHandler(Child1,super.getGame(),this));
	add(LoadGame) ; 
	
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
        Back.addActionListener(new BackHandler(Parent,this));
        add(Back);
		
		validate();
		
}
public JButton getNewGame() {
	return NewGame;
}
public void setNewGame(JButton newGame) {
	NewGame = newGame;
}
public JButton getLoadGame() {
	return LoadGame;
}
public void setLoadGame(JButton loadGame) {
	LoadGame = loadGame;
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
public MainMenuVeiw getParent() {
	return Parent;
}
public void setParent(MainMenuVeiw parent) {
	Parent = parent;
}
public Font getCustomFont() {
	return customFont;
}
public void setCustomFont(Font customFont) {
	this.customFont = customFont;
}

public NewGameVeiw getChild2() {
	return child2;
}
public void setChild2(NewGameVeiw child2) {
	this.child2 = child2;
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
