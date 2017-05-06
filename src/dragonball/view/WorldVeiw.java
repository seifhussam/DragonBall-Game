package dragonball.view;

import java.awt.BorderLayout;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import dragonball.controller.BackHandler;
import dragonball.controller.FighterOptionsVeiwHandler;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;


public class WorldVeiw extends GameVeiw implements Serializable{
	private DragonView child2 ; 
	private BattleView child ; 
	private Font customFont ; 
	private Font customFont2 ; 
	private Font customFont3 ; 
	private JFrame parent ;
	private JPanel Senzu ; 
	private JLabel SenzuB ; 
	private JPanel DragonB ; 
	private JLabel DragonBall; 
	private JPanel ExploredMaps; 
	private JLabel Explored ; 
	private JLabel PlayerName ; 
	private JButton Back ; 
	private JButton Exit ;
	private JButton UpgradeFighter ; 
	private JButton SwitchFighter ; 
	private JButton AddFighter ; 
	private JPanel Playerinfo ; 
	private JPanel Map ;
	private Icon Dragonballmapicon ; 
	private Icon SenzuImage ; 
	private Icon [] DragonBallImage ;
	private Icon MapButtonBackground ; 
	private JLabel Title1 ; 
	private JButton [] [] Buttons ;
	private JLabel SenzuNumber ; 
	private JLabel Level;
	private JLabel MaxHealth;
	private JLabel MaxKI;
	private JLabel MaxStamina;
	private JLabel PhysicalDamage;
	private JLabel BlastDamage;
	//Sherif's Add ons
	private JComboBox Fighters;
	private JLabel	Fighter;
	private JButton	FighterIcon;
	private JPanel FighterArea;
	private JPanel AbilityPoint ; 
	private JLabel AbilityPoints ; 
	private JLabel AbilityPointNumber ;
	private FighterOptionsVeiw child1 ;
	private JLabel MaxHealthnumber;
	private JLabel LevelNumber;
	private JLabel Maxkinumber;
	private JLabel MAxstNumber;
	private JLabel PhysicalNumber;
	private JLabel BDnumber;
	private JProgressBar XpProgressBar;
	private JLabel XpProgress; 
	private Game game ; 
	private Icon MapBPlayer ; 
	private Icon MapBBoss ;
	private JLabel ExploredNumber; 
	private JLabel MessageText ;
	private Font JcustomFont;
	private JLabel APNumber;
	private JButton Save; 

	
	public void setGame (Game game ) {
		setGame(game); 
		this.game = game ;
	}
	
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	private final static int DEFAULTHEIGHT= 50;
	@SuppressWarnings("unchecked")
	public WorldVeiw(JFrame Parent, Game game ) {
		super(game);
		// TODO Auto-generated constructor stub
		getGame().getWorld().setWorldListener(game);
		//getGame().getPlayer().getActiveFighter().setPhysicalDamage(400);

	

// getGame().getPlayer().getActiveFighter().getUltimateAttacks().add(new UltimateAttack("Ultimate " , 500)) ;
 //getGame().getPlayer().getActiveFighter().getSuperAttacks().add(new SuperAttack("Super " , 500)) ;
	//getGame().getPlayer().setDragonBalls(6);
		game.setListener(this);
		getGame().setListener(this);
		this.game =game ; 
 		this.parent=Parent ;
 		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				game.getWorld().getMap()[i][j].setCellListener(getGame().getWorld());
			}
		}
 		super.setGame(game);
 		
 		
 		DragonBallImage = new Icon [8] ; 
		for (int i = 0; i < DragonBallImage.length; i++) {
		DragonBallImage[i] = 	new ImageIcon(getClass().getResource("dragonball"+i+".png")) ; 
	
		}
		Font cFont = new Font("Serif",Font.BOLD,42) ; 
	cFont= new Font("Serif",Font.PLAIN,14);
		
		try {
		    //create the font to use. Specify the size!
			cFont = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(42f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		Font customFont5= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			customFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(23f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		Font Font5Text = new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			Font5Text = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(23f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		customFont= new Font("Serif",Font.PLAIN,14);
		
		try {
		    //create the font to use. Specify the size!
		   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(30f);
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
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(140f);
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
		Font customFont4= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
		   customFont4 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(50f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		} 
		
		
		
	
	
		setLayout(null);
		setForeground(Color.red);
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		Icon ii = new  ImageIcon(getClass().getResource("WDF_703597.jpg")) ;
		JLabel temp  = new JLabel(ii) ;
		setContentPane(temp);
	    setSize(DimMax);
		
		MessageText = new JLabel("") ; 
		MessageText .setLocation(10, 900);
		MessageText.setFont(customFont);
		MessageText.setSize(400,100);
		MessageText.setForeground(Color.red);
		
		add(MessageText);
	    
	    Icon Exit1 = new ImageIcon(getClass().getResource("ExitRed.png")); 
		Icon Exitrev = new ImageIcon(getClass().getResource("ExitBlue.png"));	
		

		Exit = new JButton(Exit1) ; 
		Exit.setRolloverIcon(Exitrev);
		Exit.setFont(customFont);  
		Exit.setContentAreaFilled(false);
	
		Exit.setFocusable(false);	
		Exit.setBorderPainted(false);
		Exit.setSize(100,BUTTONHEIGHT);
        Exit.setLocation(0,DEFAULTHEIGHT-20);
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
			Back.setSize(150,BUTTONHEIGHT);          
			Back.setFont(customFont);
	        Back.setLocation(100, DEFAULTHEIGHT-20);
	        Back.addActionListener(new BackHandler(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(game), game), game),this));
	        add(Back);
	        
	    	Save = new JButton("Save");   
		
	    	Save.setContentAreaFilled(false);
	    	Save.setBorderPainted(false);
	    	Save.setFocusable(false);
	    	Save.setForeground(Color.red);
	    	Save.setSize(150,BUTTONHEIGHT);          
	    	Save.setFont(customFont3);
	    	Save.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					Save.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					Save.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	    	Save.setLocation(220, DEFAULTHEIGHT-20);
	    	Save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					MessageText.setText("          Saved .") ; 
					MessageText.setVisible(true);
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								game.save("save.ser");
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							MessageText.setText("");
						
						}
					}).start();
				}
	    	}
	    	);
	        add(Save);
	    
	    PlayerName=new JLabel("Player " +game.getPlayer().getName());
	    PlayerName.setFont(customFont4);
	    PlayerName.setForeground(Color.red);
	    PlayerName.setSize(PlayerName.getPreferredSize());
	   
	    PlayerName.setLocation(10,2*BUTTONHEIGHT) ; 
	    add(PlayerName);
	  
	   
	    
	  
	   // Fighter.setLocation(PlayerName.getWidth()+100,50);



	    
	    FighterIcon =new JButton(setFighterIcon(getGame().getPlayer().getActiveFighter()));
	    FighterIcon.setSize(FighterIcon.getPreferredSize());
	    FighterIcon.setLocation(10,3*BUTTONHEIGHT);
	    FighterIcon.setContentAreaFilled(false);
	    FighterIcon.setOpaque(false);
	    FighterIcon.setFocusable(false);	
	    FighterIcon.setBorderPainted(false);
	    FighterIcon.setToolTipText("Click for fighter options");
	    FighterIcon.addActionListener(new FighterOptionsVeiwHandler(this, game,child1) ); 
	    
	    
	    Fighter= new JLabel("Name " +getGame().getPlayer().getActiveFighter().getName() );
	    Fighter.setForeground(Color.red);
	    Fighter.setFont(Font5Text);
	    Fighter.setSize(Fighter.getPreferredSize());
	    Fighter.setLocation(FighterIcon.getX()+ FighterIcon.getWidth()+20, FighterIcon.getY());
	    //FighterIcon.setBounds(0, 0, 25, 25);
	    
	 //   JSeparator sep=new JSeparator(SwingConstants.HORIZONTAL);
	   // sep.setSize(FighterIcon.getWidth(),2);
	    
	    Level = new JLabel("Level "+game.getPlayer().getActiveFighter().getLevel()) ; 
	    Level.setFont(Font5Text); 
	    Level.setForeground(Color.red);
	    Level.setSize(Level.getPreferredSize());
	    Level.setLocation(Fighter.getX(),Fighter.getY()+Fighter.getHeight()+20);
	    add(Level);
	     LevelNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getLevel()) ; 
	    LevelNumber.setFont(customFont5); 
	    LevelNumber.setForeground(Color.red);
	    LevelNumber.setSize(LevelNumber.getPreferredSize());
	    LevelNumber.setLocation(Level.getX() +Level.getWidth(),Level.getY());
	    add(LevelNumber);
		
	    MaxHealth = new JLabel("Max Health ") ; 
	    MaxHealth.setFont(Font5Text); 
	    MaxHealth.setForeground(Color.red);
	    MaxHealth.setSize(MaxHealth.getPreferredSize());
	    MaxHealth.setLocation(Fighter.getX(),Level.getY()+Level.getHeight()+20);
	    add(MaxHealth); 
	    
	     MaxHealthnumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxHealthPoints()) ; 
	    MaxHealthnumber.setFont(customFont5); 
	    MaxHealthnumber.setForeground(Color.red);
	    MaxHealthnumber.setSize(MaxHealthnumber.getPreferredSize());
	    MaxHealthnumber.setLocation(MaxHealth.getX() +MaxHealth.getWidth(),MaxHealth.getY());
	    add(MaxHealthnumber);
		
	    MaxKI = new JLabel("Max Ki ") ; 
	    MaxKI.setFont(Font5Text); 
	    MaxKI.setForeground(Color.red);
	    MaxKI.setSize(MaxKI.getPreferredSize());
	    MaxKI.setLocation(Fighter.getX(),MaxHealth.getY()+MaxHealth.getHeight()+20);
	    add(MaxKI);
	    
	    Maxkinumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxKi()) ; 
	    Maxkinumber.setFont(customFont5); 
	    Maxkinumber.setForeground(Color.red);
	    Maxkinumber.setSize(Maxkinumber.getPreferredSize());
	    Maxkinumber.setLocation(MaxKI.getX() +MaxKI.getWidth(),MaxKI.getY());
	    add(Maxkinumber);
	    
	    MaxStamina = new JLabel("Max Stamina ") ;
	    MaxStamina.setFont(Font5Text); 
	    MaxStamina.setForeground(Color.red);
	    MaxStamina.setSize(MaxStamina.getPreferredSize());
	    MaxStamina.setLocation(Fighter.getX(),MaxKI.getY()+MaxKI.getHeight()+20);
	    add(MaxStamina);
		
	    MAxstNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxStamina()) ; 
	    MAxstNumber.setFont(customFont5); 
	    MAxstNumber.setForeground(Color.red);
	    MAxstNumber.setSize(MAxstNumber.getPreferredSize());
	    MAxstNumber.setLocation(MaxStamina.getX() +MaxStamina.getWidth(),MaxStamina.getY());
	    add(MAxstNumber);
	    
	    
	    PhysicalDamage = new JLabel("Physical Damage ") ; 
	    PhysicalDamage.setFont(Font5Text); 
	    PhysicalDamage.setForeground(Color.red);
	    PhysicalDamage.setSize(PhysicalDamage.getPreferredSize());
	    PhysicalDamage.setLocation(Fighter.getX(),MaxStamina.getY()+MaxStamina.getHeight()+20);
	    add(PhysicalDamage);
		
	    PhysicalNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getPhysicalDamage()) ; 
	    PhysicalNumber.setFont(customFont5);
	    PhysicalNumber.setForeground(Color.red);
	    PhysicalNumber.setSize(PhysicalNumber.getPreferredSize());
	    PhysicalNumber.setLocation(PhysicalDamage.getX() +PhysicalDamage.getWidth(),PhysicalDamage.getY());
	    add(PhysicalNumber);
	    
	    
	    BlastDamage = new JLabel("Blast Damage ") ;  
	    BlastDamage.setFont(Font5Text); 
	    BlastDamage.setForeground(Color.red);
	    BlastDamage.setSize(BlastDamage.getPreferredSize());
	    BlastDamage.setLocation(Fighter.getX(),PhysicalDamage.getY()+PhysicalDamage.getHeight()+20);
	    add(BlastDamage);
	    
	    BDnumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getBlastDamage()) ; 
	    
	    BDnumber.setFont(customFont5); 
	    BDnumber.setForeground(Color.red);
	    BDnumber.setSize(BDnumber.getPreferredSize());
	    BDnumber.setLocation(BlastDamage.getX() +BlastDamage.getWidth(),BlastDamage.getY());
	    add(BDnumber);
	    
	    AbilityPoints = new JLabel("Ability Points ") ; 
	    AbilityPoints.setFont(Font5Text); 
	    AbilityPoints.setForeground(Color.red);
	    AbilityPoints.setSize(AbilityPoints.getPreferredSize());
	    AbilityPoints.setLocation(Fighter.getX(),BlastDamage.getY()+BlastDamage.getHeight()+20);
	    add(AbilityPoints);
	    APNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getAbilityPoints()) ; 
	    APNumber.setFont(customFont5); 
	    APNumber.setForeground(Color.red);
	    APNumber.setSize(APNumber.getPreferredSize());
	    APNumber.setLocation(AbilityPoints.getX()+AbilityPoints.getWidth(),AbilityPoints.getY());
	    add(APNumber) ;
	    
	    
	    FighterArea=new JPanel();
	    FighterArea.setLocation(10,500);

	    FighterArea.setLayout(new BorderLayout());
	    add(FighterIcon);
	  //  FighterArea.add(sep, BorderLayout.CENTER);
	    add(Fighter);
	    //FighterArea.setSize(getPreferredSize());
	    //add(FighterArea);

	    
	    /* ArrayList<PlayableFighter> x= game.getPlayer().getFighters();
	   String[] names=new String[x.size()];
	   for (int i = 0; i < names.length; i++) {
		names[i]=x.get(i).getName();
	}
	    
	    Fighters= new JComboBox(names);
	    Fighters.setFont(customFont);
	    Fighters.setSize(Fighters.getPreferredSize());
	    Fighters.setLocation(Fighter.getX()+Fighter.getWidth(),40);
	    Fighters.addItemListener(new ItemListener() {				//CHECK
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					game.getPlayer().setActiveFighter(game.getPlayer().getFighters().get(Fighters.getSelectedIndex()));
				}
			}
		});
	    add(Fighters);*/
	   
		Title1 = new JLabel("The World") ; 
		Title1.setForeground(Color.red); 
		Title1.setFont(customFont2); 
		Title1.setSize(Title1.getPreferredSize());
		
		Title1.setLocation(getWidth()/2-Title1.getWidth()/2, 30); 
		add(Title1) ;
		
		DragonB = new JPanel() ;
		DragonB.setOpaque(false);
		DragonB.setLocation(getWidth()-(150+170+190),0);
		DragonB.setSize(150, 175); 
	
		
		DragonBall = new JLabel(DragonBallImage[getGame().getPlayer().getDragonBalls()]); 
		DragonBall.setOpaque(false);
		DragonB.add(DragonBall) ; 
		add(DragonB) ;
		
		Senzu = new JPanel() ;
		Senzu.setOpaque(false);
		Senzu.setLocation(getWidth()-(170+190),50);
		Senzu.setSize(170, 80);
		Senzu.setLayout(new BorderLayout());
		SenzuB = new JLabel(" SenzuBeans") ; 
		SenzuB.setForeground(Color.red);
		SenzuB.setFont(customFont);
		SenzuB.setOpaque(false);
		Senzu.add(SenzuB,BorderLayout.NORTH) ; 
		add(Senzu) ; 
		SenzuNumber = new JLabel("       "+game.getPlayer().getSenzuBeans()); 
		SenzuNumber.setFont(cFont);
		SenzuNumber.setForeground(Color.red);
		SenzuNumber.setBackground(null);
		SenzuNumber.setSize(getPreferredSize());
		Senzu.add(SenzuNumber,BorderLayout.SOUTH);
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
				SenzuNumber.setText("       "+game.getPlayer().getSenzuBeans());
				SenzuNumber.setSize(SenzuNumber.getPreferredSize());
				APNumber.setText(": "+game.getPlayer().getActiveFighter().getAbilityPoints()) ; 
				APNumber.setSize(APNumber.getPreferredSize());
				  BDnumber .setText(": "+game.getPlayer().getActiveFighter().getBlastDamage()) ; 
				  BDnumber.setSize(BDnumber.getPreferredSize());
				  PhysicalNumber.setText(": "+game.getPlayer().getActiveFighter().getPhysicalDamage()) ;
				  PhysicalNumber.setSize(PhysicalNumber.getPreferredSize());
				  MAxstNumber.setText(": "+game.getPlayer().getActiveFighter().getMaxStamina()) ; 
				  MAxstNumber.setSize(MAxstNumber.getPreferredSize());
				  Maxkinumber.setText(": "+game.getPlayer().getActiveFighter().getMaxKi()) ; 
				  Maxkinumber.setSize(Maxkinumber.getPreferredSize());
				  MaxHealthnumber.setText(": "+game.getPlayer().getActiveFighter().getMaxHealthPoints()) ; 
				  MaxHealthnumber.setSize(MaxHealthnumber.getPreferredSize());
				LevelNumber.setText(": "+game.getPlayer().getActiveFighter().getLevel()) ; 
				LevelNumber.setSize(LevelNumber.getPreferredSize());
				repaint() ;
				validate() ;
				}
			}
		}).start();
		
//		AbilityPoint = new JPanel() ;
//		
//		AbilityPoint.setLocation(getWidth()-(170+190),50);
//		AbilityPoint.setSize(170, 80);
//		AbilityPoint.setLayout(new BorderLayout());
//		AbilityPoints = new JLabel(" Ability Points") ; 
//		AbilityPoints.setFont(customFont);
//		AbilityPoint.add(AbilityPoints,BorderLayout.NORTH) ; 
//		add(AbilityPoint) ; 
//		AbilityPointNumber = new JLabel("       0"); 
//		AbilityPointNumber.setFont(cFont);
//		AbilityPointNumber.setSize(getPreferredSize());
//		AbilityPoint.add(AbilityPointNumber,BorderLayout.SOUTH);
		
        ExploredMaps = new JPanel() ;
		ExploredMaps.setOpaque(false);
        ExploredMaps.setLocation(getWidth()-(190),50);
        ExploredMaps.setSize(190, 80);
        
        ExploredMaps.setLayout(new BorderLayout());
		Explored = new JLabel(" Explored Maps") ; 
		Explored.setForeground(Color.red);
		Explored.setFont(customFont);
		ExploredMaps.add(Explored,BorderLayout.NORTH) ; 
		add(ExploredMaps) ; 
		  ExploredNumber = new JLabel("       "+game.getPlayer().getExploredMaps()); 
		  ExploredNumber.setForeground(Color.red);
		 ExploredNumber.setFont(cFont);
		 Explored.setOpaque(false);
		 ExploredNumber.setOpaque(false);
		 ExploredNumber.setSize(getPreferredSize());
		 ExploredMaps.add(ExploredNumber,BorderLayout.SOUTH);
	
		Map= new JPanel(); 
		
		
		Map.setBounds(500, 180, getWidth()-500, getHeight()-180);
		Buttons = new JButton [10] [10] ; 
		Map.setLayout(null);
//	JLabel jj = new JLabel((Icon)(new ImageIcon(getClass().getResource("MapBackground.jpg")))); 
//		 jj.setLocation(500,180); 
//		 jj.setSize(1420,900);
//		 
//		add(jj);
		int buttonX = 0 ; 
		int buttonY = 0 ; 
		MapButtonBackground = new ImageIcon(getClass().getResource("Map Cell.png"));
		for (int i = 0; i < Buttons.length; i++) {
			for (int j = 0; j < Buttons[i].length; j++) {
				if (i==game.getWorld().getPlayerRow() && j == game.getWorld().getPlayerColumn()) {
					Buttons[i][j]  = new JButton(MapBPlayer) ;  
				}else 
					
				Buttons[i][j]  = new JButton(MapButtonBackground) ; 
				
				Buttons[i][j].setFocusable(false);	
 				Buttons[i][j].setSize(Map.getWidth()/10, (Map.getHeight())/10);
				Buttons[i][j].setLocation(buttonX, buttonY);
				Buttons[i][j].addActionListener(new buttonMouse());
				Map.add(Buttons[i][j]) ;
           buttonX+=(Map.getWidth()/10) ;				
			}
			buttonX = 0 ; 
			buttonY+=((Map.getHeight())/10) ;
		}
		ImageIcon [] Bosses = new ImageIcon [] { new ImageIcon (getClass().getResource("Boss2 Cell.png")) ,  new ImageIcon (getClass().getResource("Boss4 Cell.png"))} ; 
	
		MapBBoss = Bosses[(int) (Math.random()*Bosses.length) ] ;
		Buttons[0][0].setIcon(MapBBoss);
	
		  XpProgressBar=new JProgressBar(0,game.getPlayer().getActiveFighter().getTargetXp());
	        XpProgressBar.setValue(game.getPlayer().getActiveFighter().getXp());
	        XpProgressBar.setSize(200,10);
	        XpProgressBar.setForeground(Color.red);
	        XpProgressBar.setLocation(FighterIcon.getX(),FighterIcon.getY()+FighterIcon.getHeight()+20);
	        add(XpProgressBar);
	        
	        
	        XpProgress=new JLabel("XP: "+XpProgressBar.getValue()+" out of "+XpProgressBar.getMaximum());
	        XpProgress.setSize(200,20);
	        XpProgress.setForeground(Color.red);
	        XpProgress.setLocation(XpProgressBar.getX()+60,XpProgressBar.getY()+XpProgressBar.getHeight()+20);
	        XpProgress.setFont(customFont5);
	        add(XpProgress);
		add(Map) ;
		Map.setFocusable(true);
		Map.requestFocus();
		System.out.println(game.getWorld());

		Map.addKeyListener(new KeyListener() {
			
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
				if (e.getKeyCode()== KeyEvent.VK_UP) {
					
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapButtonBackground);
					try {
						getGame().getWorld().getMap()[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()].setCellListener(getGame().getWorld());
					game.getWorld().moveUp(); 
					}
					catch (Exception ee ) { 
						
					}
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapBPlayer);
					
					
				}
				else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapButtonBackground);
					try {
						game.getWorld().getMap()[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()].setCellListener(getGame().getWorld());
						game.getWorld().moveDown(); 
						}
						catch (Exception ee ) { 
							
						}
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapBPlayer);
					
				}
				else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapButtonBackground);
					try {
						game.getWorld().getMap()[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()].setCellListener(getGame().getWorld());
						game.getWorld().moveRight();
						}
						catch (Exception ee ) { 
							
						}
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapBPlayer);
					
				}
				else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapButtonBackground);
					try {
						
						game.getWorld().getMap()[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()].setCellListener(getGame().getWorld());
						game.getWorld().moveLeft(); 
						}
						catch (Exception ee ) { 
							
						}
					Buttons[getGame().getWorld().getPlayerRow()][getGame().getWorld().getPlayerColumn()] .setIcon(MapBPlayer);
					
				}
				Buttons[0][0].setIcon(MapBBoss);
				
			}
		});
		validate();
		setUndecorated(true);
	
	}
	public Icon setFighterIcon(Fighter x)
	{
		Icon i;
		
		if(x instanceof Saiyan){
			i=new ImageIcon(getClass().getResource("Sayian_icon.png"));
			MapBPlayer = (Icon) (new ImageIcon(getClass().getResource("Super Saiyan Cell.png"))); 
		}
		else
			if(x instanceof Frieza){
				i=new ImageIcon(getClass().getResource("Frieza_icon.png"));
				MapBPlayer = (Icon) (new ImageIcon(getClass().getResource("Frieza Cell.png"))); 
			}
			else
				if(x instanceof Majin){
					i=new ImageIcon(getClass().getResource("Majin_icon.png"));
					MapBPlayer = (Icon) (new ImageIcon(getClass().getResource("Majin Cell.png"))); 
				}
				else
					if(x instanceof Namekian){
						i=new ImageIcon(getClass().getResource("Namkian_icon.png"));
						MapBPlayer = (Icon) (new ImageIcon(getClass().getResource("Namekian Cell.png"))); 
					}
					else
						if(x instanceof Earthling){
							i=new ImageIcon(getClass().getResource("Earthling_icon.png"));
							MapBPlayer = (Icon) (new ImageIcon(getClass().getResource("Saiyan Cell.png"))); 
						}
						else
							i=new ImageIcon(getClass().getResource("unknown_icon.png"));
		
		return i;

	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		// TODO Auto-generated method stub
		DragonBall.setIcon(DragonBallImage[getGame().getPlayer().getDragonBalls()]) ; 
		MessageText.setText("YOU HAVE FOUND A DRAGON BALL");
		validate();
		repaint();
		child2 = new DragonView(this, getGame(),dragon) ; 
		  Runnable r = new Runnable() {
			   public void run() {
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   MessageText.setText("");
			   Map.setEnabled(true);
			   Map.requestFocus();
			   child2.setVisible(true); 
			   Runnable r = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  setVisible(false);
				}
			};
			 Thread t = new Thread(r) ; 
			 t.start();
			   validate();
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
		validate();
		
		
	
		
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		// TODO Auto-generated method stub
		Map.setEnabled(false);
		if(collectible == Collectible.SENZU_BEAN) {
			SenzuNumber.setText("       "+game.getPlayer().getSenzuBeans());
			MessageText.setText("YOU HAVE FOUND A SENZUBEAN ");
			validate();
			repaint();
			
			  Runnable r = new Runnable() {
				   public void run() {
				    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   MessageText.setText("");
				   Map.setEnabled(true);
				   Map.setFocusable(true);
				   Map.requestFocus();
				   validate();
				   }
				 };
			Thread t = new Thread(r) ;
			t.start();
			validate();
		} else { 
			
			DragonBall.setIcon(DragonBallImage[getGame().getPlayer().getDragonBalls()]) ; 
			MessageText.setText("YOU HAVE FOUND A DRAGON BALL");
			validate();
			repaint();
			  Runnable r = new Runnable() {
				   public void run() {
				    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   MessageText.setText("");
				   Map.setEnabled(true);
				   Map.requestFocus();
				   validate();
				   }
				 };
			Thread t = new Thread(r) ;
			t.start();
			validate();
		}
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		
		Map.setEnabled(false);
// TODO Auto-generated method stub
		if (e.getType() == BattleEventType.STARTED) {
		
		
		if (!((NonPlayableFighter)((Battle)e.getSource()).getFoe()).isStrong()){
		MessageText.setText("YOU HAVE FOUND A FOE ");

		child = new BattleView(getGame(), (Battle) e.getSource()) ; 
		validate();
		repaint();
		  Runnable r = new Runnable() {
		   public void run() {
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			   MessageText.setText("");
			   validate();
				
				child.setVisible(true); 
				
				Runnable r = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
						Thread.sleep(1000);
						} 
						catch (Exception e ) { 
							
						}
						setVisible(false);
					}
				};
				Thread t = new Thread(r) ;
				t.start();
			   }
			 };
		Thread t = new Thread(r) ;
		t.start();
		validate();
		}
		else {
			MessageText.setText("YOU HAVE FOUND THE BOSS");

			child = new BattleView(getGame(), (Battle) e.getSource()) ; 
			validate();
			repaint();
			  Runnable r = new Runnable() {
				   public void run() {
				    try {
						Thread.sleep(2000);
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				   MessageText.setText("");
				   validate();
					
					child.setVisible(true); 
					
					Runnable r = new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
							Thread.sleep(1000);
							} 
							catch (Exception e ) { 
								
							}
							setVisible(false);
						}
					};
					Thread t = new Thread(r) ;
					t.start();
			   }
				 };
			Thread t = new Thread(r) ;
			t.start();

			validate();
	}
		
	
		
		}
	}

	

	@Override
	public void onTournamentEvent(TournamentStatus status) {
		// TODO Auto-generated method stub
		
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
	public Font getCustomFont3() {
		return customFont3;
	}
	public void setCustomFont3(Font customFont3) {
		this.customFont3 = customFont3;
	}
	public JFrame getParent() {
		return parent;
	}
	public void setParent(JFrame parent) {
		this.parent = parent;
	}
	public JPanel getSenzu() {
		return Senzu;
	}
	public void setSenzu(JPanel senzu) {
		Senzu = senzu;
	}
	public JLabel getSenzuB() {
		return SenzuB;
	}
	public void setSenzuB(JLabel senzuB) {
		SenzuB = senzuB;
	}
	public JPanel getDragonB() {
		return DragonB;
	}
	public void setDragonB(JPanel dragonB) {
		DragonB = dragonB;
	}
	public JLabel getDragonBall() {
		return DragonBall;
	}
	public void setDragonBall(JLabel dragonBall) {
		DragonBall = dragonBall;
	}
	public JPanel getExploredMaps() {
		return ExploredMaps;
	}
	public void setExploredMaps(JPanel exploredMaps) {
		ExploredMaps = exploredMaps;
	}
	public JLabel getExplored() {
		return Explored;
	}
	public void setExplored(JLabel explored) {
		Explored = explored;
	}
	public JLabel getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(JLabel playerName) {
		PlayerName = playerName;
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
	public JButton getUpgradeFighter() {
		return UpgradeFighter;
	}
	public void setUpgradeFighter(JButton upgradeFighter) {
		UpgradeFighter = upgradeFighter;
	}
	public JButton getSwitchFighter() {
		return SwitchFighter;
	}
	public void setSwitchFighter(JButton switchFighter) {
		SwitchFighter = switchFighter;
	}
	public JButton getAddFighter() {
		return AddFighter;
	}
	public void setAddFighter(JButton addFighter) {
		AddFighter = addFighter;
	}
	public JPanel getPlayerinfo() {
		return Playerinfo;
	}
	public void setPlayerinfo(JPanel playerinfo) {
		Playerinfo = playerinfo;
	}
	public JPanel getMap() {
		return Map;
	}
	public void setMap(JPanel map) {
		Map = map;
	}
	public Icon getDragonballmapicon() {
		return Dragonballmapicon;
	}
	public void setDragonballmapicon(Icon dragonballmapicon) {
		Dragonballmapicon = dragonballmapicon;
	}
	public Icon getSenzuImage() {
		return SenzuImage;
	}
	public void setSenzuImage(Icon senzuImage) {
		SenzuImage = senzuImage;
	}
	public Icon[] getDragonBallImage() {
		return DragonBallImage;
	}
	public void setDragonBallImage(Icon[] dragonBallImage) {
		DragonBallImage = dragonBallImage;
	}
	public Icon getMapButtonBackground() {
		return MapButtonBackground;
	}
	public void setMapButtonBackground(Icon mapButtonBackground) {
		MapButtonBackground = mapButtonBackground;
	}
	public JLabel getTitle1() {
		return Title1;
	}
	public void setTitle(JLabel title) {
		Title1 = title;
	}
	public JButton[][] getButtons() {
		return Buttons;
	}
	public void setButtons(JButton[][] buttons) {
		Buttons = buttons;
	}
	public JLabel getSenzuNumber() {
		return SenzuNumber;
	}
	public void setSenzuNumber(JLabel senzuNumber) {
		SenzuNumber = senzuNumber;
	}
	public JComboBox getFighters() {
		return Fighters;
	}
	public void setFighters(JComboBox fighters) {
		Fighters = fighters;
	}
	public JLabel getFighter() {
		return Fighter;
	}
	public void setFighter(JLabel fighter) {
		Fighter = fighter;
	}
	public JButton getFighterIcon() {
		return FighterIcon;
	}
	public void setFighterIcon(JButton fighterIcon) {
		FighterIcon = fighterIcon;
	}
	public JPanel getFighterArea() {
		return FighterArea;
	}
	public void setFighterArea(JPanel fighterArea) {
		FighterArea = fighterArea;
	}
	public JPanel getAbilityPoint() {
		return AbilityPoint;
	}
	public void setAbilityPoint(JPanel abilityPoint) {
		AbilityPoint = abilityPoint;
	}
	public JLabel getAbilityPoints() {
		return AbilityPoints;
	}
	public void setAbilityPoints(JLabel abilityPoints) {
		AbilityPoints = abilityPoints;
	}
	public JLabel getAbilityPointNumber() {
		return AbilityPointNumber;
	}
	public void setAbilityPointNumber(JLabel abilityPointNumber) {
		AbilityPointNumber = abilityPointNumber;
	}
	@Override
	public void onStageComplete(int stage) {
		// TODO Auto-generated method stub
		
	}
	public class buttonMouse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
				for (int i = 0; i < Buttons.length; i++) {
					for (int j = 0; j < Buttons[i].length; j++) {
						if (e.getSource()==Buttons[i][j]) { 
						
							((JButton)(e.getSource())).setIcon(MapBPlayer); 
							game.getWorld().setPlayerRow(i); 
							game.getWorld().setPlayerColumn(j);
							getGame().getWorld().getMap()[i][j].setCellListener(getGame().getWorld());
							game.getWorld().getMap()[i][j].onStep();
							
						}
						 
						else 
							Buttons[i][j].setIcon(MapButtonBackground); 
						if(i==0 && j == 0 ) 
							Buttons[0][0].setIcon(MapBBoss);
						}
					}
				
		}

	
		
	}
	@Override
	public void onTournamentMatchEvent(BattleEvent e, MatchStatus matchStatus) {
		// TODO Auto-generated method stub
		
	}
}
