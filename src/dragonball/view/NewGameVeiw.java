package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dragonball.controller.BackHandler;
import dragonball.controller.Next1Handler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class NewGameVeiw extends GameVeiw implements Serializable  {
	private JPanel CreatePlayer ; 
	private JTextField PlayerName;  
	private JButton Next1 ;
	private StartGameVeiw parent ;  
	private JLabel PlayerNameText ;   
	private JLabel Create ; 
	private JButton Back ; 
	private JButton Exit ;
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	private final static int PANELWIDTH = (int) (BUTTONWIDTH*1.5) ; 
	private final static int PANELHEIGHT =  (int) (BUTTONHEIGHT*1.5) ;
	private Font customFont ; 
	private Font customFont2 ; 
	private Font customFont3 ; 
	private CreateFighterVeiw child ;
	private Font JcustomFont;
	public NewGameVeiw(StartGameVeiw Parent,Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		
Font cFont = new Font("Serif",Font.BOLD,42) ;  
  
		
		try {
		    //create the font to use. Specify the size!
		   cFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(50f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		this.parent=Parent ; 
		Icon i = new  ImageIcon(getClass().getResource("dragon-ball-kid-goku-wide-wallpaper.jpg")) ;
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
		 customFont2= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(80f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		customFont3= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
		   customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(50f);
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
		
		Create = new JLabel("Create A Player ..");
		Create.setFont(customFont2);
		Create.setSize(Create.getPreferredSize());
		Create.setForeground(new Color(204, 0, 51));
		Create.setLocation(getWidth()/2-Create.getWidth()/2 , 50);
	    add(Create) ;
		
	    CreatePlayer = new JPanel() ; 
	    CreatePlayer.setSize(getWidth()-(2*PANELWIDTH),getHeight()-(Create.getHeight()+PANELHEIGHT+100));
	    CreatePlayer.setLocation(PANELWIDTH,Create.getHeight()+100);
	    CreatePlayer.setLayout(null);
	    CreatePlayer.setBackground(null);
	    CreatePlayer.setOpaque(false);
	    
	    PlayerNameText = new JLabel("Player name :") ;
	    PlayerNameText.setFont(customFont3);
	    PlayerNameText.setForeground(Color.red);
	    PlayerNameText.setSize(PlayerNameText.getPreferredSize());
	    PlayerNameText.setLocation(40, 200); 
	    CreatePlayer.add(PlayerNameText) ; 
	    
	    PlayerName = new JTextField() ; 
	    PlayerName.setFont(cFont);
	    PlayerName.setOpaque(false);
	    PlayerName.setForeground(Color.red);
	    PlayerName.setSize((CreatePlayer.getWidth()-PlayerNameText.getWidth())/2,PlayerNameText.getHeight());
	    PlayerName.setLocation(PlayerNameText.getWidth()+15 , PlayerNameText.getY()) ; 
	    PlayerName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					System.out.println("Here ");
				 Next1.doClick();
				}
			}
		});
	    
	 
	    CreatePlayer.add(PlayerName);
	    Icon NextIcon = new ImageIcon(getClass().getResource("NextRed.png"));
	    Icon rev = new ImageIcon(getClass().getResource("Nextblue.png"));
	    Next1 = new JButton(NextIcon) ; 
	    Next1.setRolloverIcon(rev); 
	    Next1.setSize(BUTTONWIDTH,BUTTONHEIGHT);
	    Next1.setLocation(CreatePlayer.getWidth()-BUTTONWIDTH,CreatePlayer.getHeight()-BUTTONHEIGHT);
	    Next1.setOpaque(false);
	    Next1.setContentAreaFilled(false);
	    Next1.setBorderPainted(false);
	    Next1.setFocusable(false);
	    Next1.addActionListener(new Next1Handler(this, child, PlayerName, super.getGame()) ) ; 
		
	    
		CreatePlayer.add(Next1) ; 
		
		
		
		
		
		
		add(CreatePlayer);
		
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
	public JPanel getCreatePlayer() {
		return CreatePlayer;
	}
	public void setCreatePlayer(JPanel createPlayer) {
		CreatePlayer = createPlayer;
	}
	 
	public JTextField getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(JTextField playerName) {
		PlayerName = playerName;
	}
	 
	public JButton getNext1() {
		return Next1;
	}
	public void setNext1(JButton next1) {
		Next1 = next1;
	}
	 
	public StartGameVeiw getParent() {
		return parent;
	}
	public void setParent(StartGameVeiw parent) {
		this.parent = parent;
	}
	 
	public JLabel getCreate() {
		return Create;
	}
	public void setCreate(JLabel playerText) {
		Create = playerText;
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
	public Font getCustomFont() {
		return customFont;
	}
	public void setCustomFont(Font customFont) {
		this.customFont = customFont;
	}
	public Font getCustomFont2() {
		return customFont2;
	}
	public void setCustomFont2(Font customFont2) {
		this.customFont2 = customFont2;
	}
	
	public static int getButtonwidth() {
		return BUTTONWIDTH;
	}
	public static int getButtonheight() {
		return BUTTONHEIGHT;
	}
	public JLabel getPlayerNameText() {
		return PlayerNameText;
	}
	public void setPlayerNameText(JLabel playerNameText) {
		PlayerNameText = playerNameText;
	}
	public CreateFighterVeiw getChild() {
		return child;
	}
	public void setChild(CreateFighterVeiw child) {
		this.child = child;
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
