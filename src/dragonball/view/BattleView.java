package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import dragonball.model.attack.Attack;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class BattleView extends GameVeiw implements Serializable  {
private battleEndedView parent ; 
private Game game ;
private Font customFont;
private Font customFont2;
private Font customFont3; 
private Battle battle ;
private JLabel MyGround ; 
private JLabel foeGround ; 
private JPanel meStats ; 
private JPanel foeStats ; 
private JLabel SenzoImage ; 
private JLabel AttackAction ; 
private JLabel BlockAction ; 
private JLabel MyFighter ; 
private JLabel FoeFighter ;
private JButton Exit;
private Font JcustomFont;
private final static int BUTTONWIDTH = 250 ; 
private final static int BUTTONHEIGHT= 100  ;
private JButton Use ; 
private JButton Attack ; 
private JButton Block ; 
private JComboBox <Attack> AttacksList ; 
private ArrayList <Attack> myAttacks ; 
private Attack [] myAttacksArray ; 
private BattleOpponent meFighter ; 
private BattleOpponent foeFighter ; 
private Icon StrongHealth ; 
private Icon WeakHealth ; 
private Icon NormalHealth ; 
private Icon HealthFrame ;
private Icon Senzuu ; 
private JLabel StrongMe ; 
private JLabel StrongFoe ; 
private JLabel NormalMe ; 
private JLabel NormalFoe ; 
private JLabel WeakMe ; 
private JLabel WeakFoe ;
private Font TextcustomFont3;
private JLabel MaxHealth;
private JLabel MaxHealthnumber;
private JLabel MaxKI;
private JLabel Maxkinumber;
private JLabel MaxStamina;
private JLabel MAxstNumber;
private JLabel FMaxStamina;
private JLabel FMaxHealth;
private JLabel FMaxHealthnumber;
private JLabel FMaxKI;
private JLabel FMaxkinumber;
private JLabel FMAxstNumber; 
private JLabel BrolyFoe ; 
//private JLabel BuuFoe ; 
private JLabel Buu_maya ; 
private JLabel CellFoe ; 
private JLabel freiza ; 
private JLabel Goku_maya ; 
private JLabel goku_ss ; 
private JLabel HasLongNameFoe ; 
private JLabel Master_Roshy ; 
private JLabel Picolo_Maya ; 
private JLabel RaditzFoe ; 
private JLabel [] WeakFoes ; 
private JLabel [] StrongFoes ; 
private JLabel MyFighterIcon ; 
private JLabel FoeIcon ; 
private JLabel ActionUse ;
private JProgressBar FoeProgressbar;
private JProgressBar MeProgressbar; 
private JLabel SayianAttack ; 
private JLabel Ki ; 
private JLabel Stamina ;
private ImageIcon Saiyan;
private ImageIcon Guko; 
private JLabel MyName ; 
private JLabel MyLevel ; 
private JLabel FoeName ; 
private JLabel FoeLevel ; 
private JPanel MeKi ; 
private JPanel FoeKi ; 
private JPanel MeStamina ; 
private JPanel FoeStamina ; 
private Icon StaminaIcon ; 
private Icon KiIcon ; 
private int currLevel ;
private JLabel cloud;
private JLabel cloud1;
private JLabel nr;
private JLabel NearAttack2;
private JLabel NearAttack3;
private Thread tt1;
int previousMeHealth ; 
int previousFoeHealth ;
private int Counter1; 
private int Counter2 ;
private boolean flag1 = true ; 
private JLabel NearUltimate ; 
private JLabel NearUltimate1 ;
private JLabel DefendedAction;
private Thread UltimateShiftNear;
private Thread UltimateNearTornado;
private JLabel farAttack1;
private JLabel farAttack2;
private JLabel farAttack3;
private Thread UltimateFarTornado;
private Thread UltimateShiftFar;
private JLabel NearAttack1;
private Thread AttackSound;
private Thread AttackSoundHelper; 
private boolean One ; 
private boolean Two ; 
private boolean Three ;
	public BattleView(Game game, Battle battle ) { 
		super(game);
		One = false ; 
		Two = false ; 
		Three = false ;
		NearUltimate = new JLabel(new ImageIcon(getClass().getResource("UltimateNear.png"))) ; 
		NearUltimate1 = new JLabel(new ImageIcon(getClass().getResource("UltimateNear.png"))) ; 
		Saiyan = new ImageIcon(getClass().getResource("goku ss.png"));
		Guko = new ImageIcon(getClass().getResource("Goku maya.png"));
		BrolyFoe = new JLabel(new ImageIcon(getClass().getResource("BrolyFoe.png"))) ; 
		Buu_maya = new JLabel(new ImageIcon(getClass().getResource("Buu maya.png"))) ; 
		CellFoe = new JLabel(new ImageIcon(getClass().getResource("CellFoe.png"))) ;
		freiza = new JLabel(new ImageIcon(getClass().getResource("freiza.png"))) ; 
		Goku_maya = new JLabel(new ImageIcon(getClass().getResource("Goku maya.png"))) ; 
		goku_ss = new JLabel(new ImageIcon(getClass().getResource("goku ss.png"))) ;
		HasLongNameFoe = new JLabel(new ImageIcon(getClass().getResource("HasLongNameFoe.png"))) ; 
		Master_Roshy = new JLabel(new ImageIcon(getClass().getResource("Master Roshy.png"))) ;
		Picolo_Maya = new JLabel(new ImageIcon(getClass().getResource("Picolo Maya.png"))) ;
		RaditzFoe = new JLabel(new ImageIcon(getClass().getResource("RaditzFoe.png"))) ; 
		ActionUse = new JLabel(new ImageIcon(getClass().getResource("Senzpic.png"))) ; 
		SayianAttack = new JLabel(new ImageIcon(getClass().getResource("tumblr_static_goku_ssj_normal_speed_.gif"))); 
		StaminaIcon = new ImageIcon(getClass().getResource("Stamina.png")) ;
		KiIcon = new ImageIcon(getClass().getResource("KiBar.png")) ;
		
		
		WeakFoes = new JLabel []  {BrolyFoe , CellFoe } ;  
		StrongFoes = new JLabel [] { HasLongNameFoe , RaditzFoe } ; 
		
		if (((Fighter)battle.getMe()) instanceof Earthling) { 
			MyFighterIcon = Master_Roshy ; 
			
		}
		else if (((Fighter)battle.getMe()) instanceof Saiyan) {
			MyFighterIcon = Goku_maya ; 
		}
		else if (((Fighter)battle.getMe()) instanceof Frieza) { 
			MyFighterIcon = freiza ; 
		}
		else if (((Fighter)battle.getMe()) instanceof Majin) { 
			MyFighterIcon = Buu_maya ; 
		}else if (((Fighter)battle.getMe()) instanceof Namekian) { 
			MyFighterIcon = Picolo_Maya ; 
		}
		
		if (((NonPlayableFighter)battle.getFoe()).isStrong() ) { 
			FoeIcon = StrongFoes [(int)(Math.random()*StrongFoes.length)] ; 
		}
		else { 
			FoeIcon = WeakFoes [(int)(Math.random()*WeakFoes.length)] ; 
		}
		
		
		
		this.game = game ; 
		 
		this.battle = battle ; 
		game.setListener(this);
		getGame().setListener(this);
		// TODO Auto-generated constructor stub
		this.meFighter = battle.getMe() ; 
		this.foeFighter = battle.getFoe() ; 
		
	    myAttacks= battle.getAssignedAttacks() ; 
	    previousMeHealth = ((Fighter) battle.getMe()).getMaxHealthPoints() ; 
	    previousFoeHealth= ((Fighter)battle.getFoe()).getMaxHealthPoints() ; 
 	    
//	    StrongHealth = new  ImageIcon(getClass().getResource("Dragon-Ball-Z-Son-Goku-HD-Wallpaper.jpg")) ; 
//	    WeakHealth = new  ImageIcon(getClass().getResource("Dragon-Ball-Z-Son-Goku-HD-Wallpaper.jpg")) ;
//	    NormalHealth = new  ImageIcon(getClass().getResource("Dragon-Ball-Z-Son-Goku-HD-Wallpaper.jpg")) ;
//	    HealthFrame = new  ImageIcon(getClass().getResource("Dragon-Ball-Z-Son-Goku-HD-Wallpaper.jpg")) ;
//	    
	    Icon i3 = new  ImageIcon(getClass().getResource("Battle Background.jpg")) ;
		JLabel temp22  = new JLabel(i3) ;
		setContentPane(temp22);
	  
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
				customFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(30f);
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
				Font5Text = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(30f);
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
			
			TextcustomFont3= new Font("Serif",Font.PLAIN,14);
			try {
			    //create the font to use. Specify the size!
			   TextcustomFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(50f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
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
			  Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
			  setSize(DimMax);
			  setUndecorated(true); 
			  currLevel = ((Fighter) battle.getMe()).getLevel() ; 
			 
			DefendedAction = new JLabel("DEFENDED" ) ; 
			DefendedAction.setForeground(Color.red); 
			DefendedAction.setFont(customFont3); 
			DefendedAction.setSize(DefendedAction.getPreferredSize()); 
			DefendedAction.setLocation(getWidth()/2 - DefendedAction.getWidth()/2 , getHeight() /2 - DefendedAction.getHeight()/2);
			DefendedAction.setVisible(false);
			    add(DefendedAction); 
			    
		    BlockAction = new JLabel("BLOCK" ) ; 
		    BlockAction.setForeground(Color.red); 
		    BlockAction.setFont(customFont3); 
		    BlockAction.setSize(BlockAction.getPreferredSize());  
		    
		    BlockAction.setLocation(getWidth()/2 - BlockAction.getWidth()/2 , getHeight() /2 - BlockAction.getHeight()/2);
		BlockAction.setVisible(false);
	    add(BlockAction); 
		    
			    
		    AttackAction = new JLabel("---") ; 
		    AttackAction.setForeground(Color.red); 
		    AttackAction.setFont(TextcustomFont3); 
		    AttackAction.setSize(AttackAction.getPreferredSize());  
	        AttackAction.setLocation(getWidth()/2 - AttackAction.getWidth()/2 , getHeight()/2 - AttackAction.getHeight()/2);
	        AttackAction.setVisible(false);
		
		    add(AttackAction); 
			    
			    
			     
			    ActionUse.setSize(400,400);  
			    ActionUse.setLocation(getWidth()/2 - ActionUse.getWidth()/2 , getHeight()/2 - ActionUse.getHeight()/2);
			   ActionUse.setVisible(false);
			    add(ActionUse); 
		
			addMouseListener(new MouseListener() {
				
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
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			 MyGround = new JLabel() ; 
			 MyGround . setSize(getWidth()/2 , 350);
			 MyGround.setLocation(0, getHeight()-MyGround.getHeight()); 
			 
			 
			 MyFighter = new JLabel() ; 
			 MyFighter.setSize(getWidth()/2, getHeight()/3); 
			 MyFighter.setLocation(5, MyGround.getY()+MyFighter.getHeight());
			 
			 meStats = new JPanel() ; 
			 
			 meStats.setSize(getWidth()/2 , 200); 
			 meStats.setLocation(getWidth()- meStats.getWidth()+200 , getHeight()/2 );
			 //insert a progress bar here 
			 
			 Block = new JButton("BLOCK") ; 
			 Block.setForeground(Color.red);
			 Block.setBackground(null);
		   	Block.setFont(customFont);
	       	Block.setSize(Block.getPreferredSize());
				Block.setOpaque(false);
				Block.setContentAreaFilled(false);
				Block.setBorderPainted(false);
				Block.setFocusable(false);
				Block.setLocation(meStats.getX()-5, meStats.getY()+meStats.getHeight());
				Block.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						battle.block();
					}
				});
			 Block.addMouseListener(new MouseListener() {
				
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
					Block.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Block.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			 SayianAttack.setSize(500,360) ;
				SayianAttack.setLocation((1920/2)-250, (1080/2)-180);
				SayianAttack.setVisible(false); 
				add(SayianAttack) ;
			 
		    Use = new JButton("USE") ; 
		    Use.setForeground(Color.red);
		    Use.setBackground(null);
		    Use.setFont(customFont);
		    Use.setSize(Use.getPreferredSize());
		    Use.setOpaque(false);
		    Use.setContentAreaFilled(false);
		    Use.setBorderPainted(false);
		    Use.setFocusable(false);
		    Use.setLocation(meStats.getX()+Block.getWidth(), meStats.getY()+meStats.getHeight());
		    Use.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						battle.use(game.getPlayer(), Collectible.SENZU_BEAN);
					} catch (NotEnoughSenzuBeansException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "Opps , You donot have enough Senzu Beans ", "Error",  JOptionPane.OK_OPTION);
					}				}
			});
			Use.addMouseListener(new MouseListener() {
				
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
					Use.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Use.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			 cloud = new JLabel (new ImageIcon(getClass().getResource("cloud.png"))) ; 
			cloud.setSize(cloud.getPreferredSize()); 
			cloud.setBackground(null);
			
			cloud.setLocation(-1*cloud.getWidth(), 0); 
			
			 
			Runnable r = new Runnable( ) {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = cloud.getX(); i <= 1920+cloud.getWidth(); i++) {
						
						cloud.setLocation(i, 0 );
						
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						validate() ; 
						repaint() ;
						if (i== 1920+cloud.getWidth()) {
							i = -1*cloud.getWidth() ; 
						}
					}
					
				}
			};
			Thread t = new Thread (r) ; 
			t.start();
			

			 cloud1 = new JLabel (new ImageIcon(getClass().getResource("cloud1.png"))) ; 
			 cloud1.setSize(cloud1.getPreferredSize()); 
			 cloud1.setBackground(null);
			
			 cloud1.setLocation(400, 1080/2 -40); 
		
			Runnable r1 = new Runnable( ) {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = cloud1.getX(); i <= 1920+cloud1.getWidth(); i++) {
						
						cloud1.setLocation(i, 1080/2 -40 );
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						validate() ; 
						repaint() ;
						if (i== 1920+cloud1.getWidth()) {
							i = -1*cloud1.getWidth() ; 
						}
					}
					
				}
			};
			Thread tt = new Thread (r1) ; 
			tt.start();
			
			MyName = new JLabel(((Fighter)battle.getMe()).getName() + "   Level") ; 
			MyName.setFont(Font5Text); 
			MyName.setForeground(Color.red);
			MyName.setSize(MyName.getPreferredSize()) ; 
			MyName.setLocation(Block.getX(),Block.getY()+Block.getHeight()+10);
			MyLevel = new JLabel(" : "+((Fighter)battle.getMe()).getLevel()) ; 
			MyLevel.setSize(200,20);
			MyLevel.setForeground(Color.red);
			MyLevel.setLocation(MyName.getX()+MyName.getWidth(), MyName.getY()
					); 
			MyLevel.setFont(customFont5); 
			add(MyLevel);
			
			add(MyName);
			  MaxHealth = new JLabel("Health ") ; 
			    MaxHealth.setFont(Font5Text); 
				    MaxHealth.setSize(100,50);
		    MaxHealth.setLocation(Block.getX(),Block.getY()+Block.getHeight()+MyName.getHeight()+15);
////				    add(MaxHealth); 
				    
				    
				    MeProgressbar = new JProgressBar(0, ((Fighter)battle.getMe()).getMaxHealthPoints());
			        MeProgressbar.setValue(((Fighter)battle.getMe()).getMaxHealthPoints());
			        MeProgressbar.setString(""+((Fighter)battle.getMe()).getHealthPoints());
			        MeProgressbar.setStringPainted(true);
			        MeProgressbar.setFont(customFont5); 
			        MeProgressbar.setForeground(Color.green); 
			        MeProgressbar.setSize(500,40);
			        MeProgressbar.setLocation(Block.getX(),Block.getY()+Block.getHeight()+45);
			        add(MeProgressbar) ; 
//				     MaxHealthnumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getHealthPoints()) ; 
//				    MaxHealthnumber.setFont(customFont5); 
//				    MaxHealthnumber.setSize(400,50);
//				    MaxHealthnumber.setLocation(MaxHealth.getX() +MaxHealth.getWidth(),MaxHealth.getY());
//				    add(MaxHealthnumber);
					
				    MaxKI = new JLabel("Ki ") ; 
				    MaxKI.setFont(Font5Text); 
				    MaxKI.setSize(MaxKI.getPreferredSize());
				    MaxKI.setLocation(MaxHealth.getX(),MaxHealth.getY()+MaxHealth.getHeight()+20);
				  //  add(MaxKI);
				    MeKi = generateImages(MaxKI.getX(), MaxKI.getY(), (ImageIcon) KiIcon, ((Fighter)battle.getMe()).getKi()) ; 
				    MeKi.setOpaque(false);
				    add(MeKi) ; 
				    Maxkinumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getKi()) ; 
				    Maxkinumber.setFont(customFont5); 
				    Maxkinumber.setSize(400,20);
				    Maxkinumber.setLocation(MaxKI.getX() +MaxKI.getWidth(),MaxKI.getY());
				//    add(Maxkinumber);
				    
				    MaxStamina = new JLabel("Stamina ") ;
				    MaxStamina.setFont(Font5Text); 
				    MaxStamina.setSize(MaxStamina.getPreferredSize());
				    MaxStamina.setLocation(MaxHealth.getX(),MaxKI.getY()+MaxKI.getHeight()+20);
				//    add(MaxStamina);
				    
				    MeStamina = generateImages(MaxStamina.getX(), MaxStamina.getY(), (ImageIcon) StaminaIcon, ((Fighter)battle.getMe()).getStamina()) ; 
				    MeStamina.setOpaque(false);
				    add(MeStamina) ; 
					
				    MAxstNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxStamina()) ; 
				    MAxstNumber.setFont(customFont5); 
				    MAxstNumber.setSize(400,20);
				    MAxstNumber.setLocation(MaxStamina.getX() +MaxStamina.getWidth(),MaxStamina.getY());
				//    add(MAxstNumber);
				    
				    
				    FMaxHealth = new JLabel("Health ") ; 	    FMaxHealth.setFont(Font5Text); 
			    FMaxHealth.setSize(100,50);
			    FMaxHealth.setLocation(800,254);
//				    add(FMaxHealth); 
//				    
//				    FMaxHealthnumber =  new JLabel(": "+((Fighter)battle.getFoe()).getHealthPoints()) ; 
//				    FMaxHealthnumber.setFont(customFont5); 
//				    FMaxHealthnumber.setSize(400,50);
//				    FMaxHealthnumber.setLocation(FMaxHealth.getX() +FMaxHealth.getWidth(),FMaxHealth.getY());
//				    add(FMaxHealthnumber);
				    
				    
				    FoeProgressbar = new JProgressBar(0, ((Fighter)battle.getFoe()).getMaxHealthPoints());
				    FoeProgressbar.setValue(((Fighter)battle.getFoe()).getMaxHealthPoints());
				    FoeProgressbar.setString(""+((Fighter)battle.getFoe()).getHealthPoints());
				    FoeProgressbar.setStringPainted(true);
				    FoeProgressbar.setFont(customFont5); 
				    FoeProgressbar.setForeground(Color.green); 
				    FoeProgressbar.setSize(500,40);
				    FoeProgressbar.setLocation(700,254);
			        add(FoeProgressbar) ; 
			        
			        FoeName = new JLabel(((Fighter)battle.getFoe()).getName() + "   Level") ; 
			        FoeName.setFont(Font5Text); 
			        FoeName.setForeground(Color.red);
			        FoeName.setSize(FoeName.getPreferredSize()) ; 
			        FoeName.setLocation(FoeProgressbar.getX(),FoeProgressbar.getY()-40);
					FoeLevel = new JLabel(" : "+((Fighter)battle.getFoe()).getLevel()) ; 
					
					FoeLevel.setForeground(Color.red);
					FoeLevel.setLocation(FoeName.getX()+FoeName.getWidth(), FoeName.getY()); 
					FoeLevel.setFont(customFont5); 
					FoeLevel.setSize(FoeLevel.getPreferredSize());
					
					add(FoeLevel);
					
					add(FoeName);
					
				    FMaxKI = new JLabel("Ki ") ; 
				    FMaxKI.setFont(Font5Text); 
				    FMaxKI.setSize(FMaxKI.getPreferredSize());
				    FMaxKI.setLocation(FoeProgressbar.getX(),FMaxHealth.getY()+FMaxHealth.getHeight()+20);
				//    add(FMaxKI);
                    FoeKi = generateImages(FoeProgressbar.getX(),FMaxHealth.getY()+FMaxHealth.getHeight()+20, (ImageIcon) KiIcon, ((Fighter)battle.getFoe()).getKi()) ; 
                    FoeKi.setOpaque(false);
				    add(FoeKi) ; 
				    FMaxkinumber =  new JLabel(": "+((Fighter)battle.getFoe()).getKi()) ; 
				    FMaxkinumber.setFont(customFont5); 
				    FMaxkinumber.setSize(FMaxkinumber.getPreferredSize());
				    FMaxkinumber.setLocation(FMaxKI.getX() +FMaxKI.getWidth(),FMaxKI.getY());
				//    add(FMaxkinumber);
				    
				    FMaxStamina = new JLabel("Stamina ") ;
				    FMaxStamina.setFont(Font5Text); 
				    FMaxStamina.setSize(FMaxStamina.getPreferredSize());
				    FMaxStamina.setLocation(FoeProgressbar.getX(),FMaxKI.getY()+FMaxKI.getHeight()+20);
				  //  add(FMaxStamina);
				    
				    FoeStamina = generateImages(FoeProgressbar.getX(),FMaxKI.getY()+FMaxKI.getHeight()+20, (ImageIcon) StaminaIcon, ((Fighter)battle.getFoe()).getStamina()) ; 
				    FoeStamina.setOpaque(false);
				    add(FoeStamina) ; 
					
				    FMAxstNumber =  new JLabel(": "+((Fighter)battle.getFoe()).getStamina()) ; 
				    FMAxstNumber.setFont(customFont5); 
				    FMAxstNumber.setSize(FMaxStamina.getPreferredSize());
				    FMAxstNumber.setLocation(FMaxStamina.getX() +FMaxStamina.getWidth(),FMaxStamina.getY());
				 //   add(FMAxstNumber);
				    
			    
			  myAttacksArray = new Attack [myAttacks.size()] ; 
			  
	 			 for (int i = 0; i < myAttacksArray.length; i++) {
				myAttacksArray[i] = myAttacks.get(i) ; 	
				}
				 AttacksList = new JComboBox<Attack>(myAttacksArray ) ; 
				 
				 
				 AttacksList.setForeground(Color.red); 
			     AttacksList.setBackground(Color.blue);	 
				 AttacksList.setSize(220,40);
				 AttacksList.setLocation(meStats.getX()+Block.getWidth()+Use.getWidth(), meStats.getY()+meStats.getHeight());
				 AttacksList.setFont(customFont);
			      AttacksList.setSelectedIndex(0);
				 
			 Attack = new JButton("ATTACK") ; 
			 Attack.setForeground(Color.red);
			 Attack.setBackground(null);
			 Attack.setFont(customFont);
			 Attack.setSize(Attack.getPreferredSize());
			 Attack.setOpaque(false);
			 Attack.setContentAreaFilled(false);
			 Attack.setBorderPainted(false);
			 Attack.setFocusable(false);
			 Attack.setLocation(meStats.getX()+Block.getWidth()+Use.getWidth()+AttacksList.getWidth(), meStats.getY()+meStats.getHeight());
			 
			 Attack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						battle.attack((dragonball.model.attack.Attack) AttacksList.getSelectedItem());
					} catch (NotEnoughKiException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Opps , You donot have enough Ki Bars ", "Error",  JOptionPane.OK_OPTION);
					}
				}
			});
			 Attack.addMouseListener(new MouseListener() {
					
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
						Attack.setForeground(Color.red);
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						Attack.setForeground(Color.blue);
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			NearUltimate.setSize(1240,1080); 
			NearUltimate.setLocation(-250,0) ; 
			NearUltimate.setVisible(false);
			add(NearUltimate) ;
			
			NearUltimate1.setSize(1240,1080); 
			NearUltimate1.setLocation(-100,0) ; 
			NearUltimate1.setVisible(false) ; 
		//	add(NearUltimate1) ;
			  
			  Runnable rrr = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					 
					for (int i = 0; i <= 2; i++) {
						if (i==0) {
						
						NearUltimate.setVisible(true);
						try {
							Thread.sleep(80) ;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						
						} 
						}
						else if (i!=0) {
							i=-1;
							
							NearUltimate.setVisible(false);
							try {
								Thread.sleep(80) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
							
							} 
							
						
						}
						
					

						
						validate(); 
						repaint();
					}
				}
			};
			
      Runnable rrrr = new Runnable() {
 				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					 
					for (int i = -400; i <= -99; i++) {
						
						if (i == -100 ) {
							for (i = -100; i >=-400; i--) {
								NearUltimate.setLocation(i,0);
								try {
									Thread.sleep(2) ;
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
								
								} 
								validate(); 
								repaint();
							}

							
						}
						NearUltimate.setLocation(i,0);
						
						try {
							Thread.sleep(2) ;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						
						} 
						
						
						validate(); 
						repaint();
					}
				}
			};
//			new Thread(rrrr).start();
//			Thread xtx = new Thread(rrr) ; 
//			xtx.start() ;
			 farAttack1 = new JLabel(new ImageIcon(getClass().getResource("FarAttack1.png"))) ; 
			 farAttack1.setSize(342,452); 
			 farAttack1.setLocation(1920-620,0);
			 farAttack1.setVisible(false);
				  add(farAttack1);
			
				  farAttack2 = new JLabel(new ImageIcon(getClass().getResource("FarAttack2.png"))) ; 
					 farAttack2.setSize(342,452); 
					 farAttack2.setLocation(1920-620,0);
					 farAttack2.setVisible(false);
						  add(farAttack2);
						  
						  farAttack3 = new JLabel(new ImageIcon(getClass().getResource("FarAttack3.png"))) ; 
							 farAttack3.setSize(640,452); 
							 farAttack3.setLocation(1200,0);
							 farAttack3.setVisible(false);
								  add(farAttack3);
			
			
			 NearAttack2 = new JLabel(new ImageIcon(getClass().getResource("NearAttack.png"))) ; 
			 NearAttack2.setSize(1240,1080); 
			 NearAttack2.setLocation(0,0);
			 NearAttack2.setVisible(false);
				  add(NearAttack2);
			  NearAttack1 = new JLabel(new ImageIcon(getClass().getResource("NearAttack3.png"))) ; 
			  NearAttack1.setSize(1240,1080); 
			  NearAttack1.setLocation(0,0);
			  NearAttack1.setVisible(false);
				  add(NearAttack1);
				  NearAttack3 = new JLabel(new ImageIcon(getClass().getResource("NearAttack2.png"))) ; 
				  NearAttack3.setSize(1240,1080); 
				  NearAttack3.setLocation(0,0);
				  NearAttack3.setVisible(false);
					  add(NearAttack3);
					  
					  Runnable rr = new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							for (int i = 0; i <= 2; i++) {
								if (i==0) {
					
									 NearAttack2.setVisible(false);
									 NearAttack3.setVisible(false);
									 try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else if (i==1) {
						
									 NearAttack2.setVisible(true);
									 NearAttack3.setVisible(false);
								}
								else 
								     if (i==2) {
								    	
										 NearAttack2.setVisible(false);
										 NearAttack3.setVisible(true);
									i = 0 ; 
								}
								try {
									Thread.sleep(10) ;
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									NearAttack2.setVisible(false);
									 NearAttack3.setVisible(false);
								} 
								validate(); 
								repaint();
							}
						}
					};
					
					
				  
				 MyFighterIcon.setSize(MyFighterIcon.getPreferredSize()) ; 
				 MyFighterIcon.setLocation(10, 400);
				 add(MyFighterIcon) ; 
				
				 
				 FoeIcon.setSize(FoeIcon.getPreferredSize()) ; 
				 FoeIcon.setLocation(1300, 110);
				 add(FoeIcon) ; 
			 
			 add(Block) ; 
			 add(Attack) ;
			 add(AttacksList) ; 
			 add(Use) ; 
			 
			
			  
			 
			 
			 
			 
	
			 
			 
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
				
		        add(Exit) ; 
		    	add(cloud1) ;
		    	add(cloud) ;
		  
			 validate () ; 
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
		
if (e.getType() == BattleEventType.ATTACK){
		Runnable rrrrr = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						AudioFilePlayer.PlaySound();
						
					}
				}).start();
				
			}
		};
		AttackSound = new Thread(rrrrr) ;
		
			if (e.getAttack() instanceof UltimateAttack){
			if (((UltimateAttack)e.getAttack()) instanceof SuperSaiyan) {
				
				SayianAttack.setSize(500,360) ;
				SayianAttack.setLocation(1920/2-250, 1080/2-180);
				SayianAttack.setVisible(true);
				MyFighterIcon.setIcon(Saiyan);
				validate() ; 
				   new Thread (new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(2500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								SayianAttack.setVisible(false);
								battle.play();
							} catch (NotEnoughKiException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();
				
			}
			else {
				
				if (e.getCurrentOpponent() == battle.getMe()){
					int CurrentFoeHealth = ((Fighter) battle.getFoe()).getHealthPoints() ;  
					if (CurrentFoeHealth<previousFoeHealth) { 
						int difference = previousFoeHealth - CurrentFoeHealth ; 
						
						  
						  Runnable rrr = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								 
								for (int i = 0; i <= 2; i++) {
									if (i==0) {
									
									farAttack3.setVisible(true);
									}
									else if (i!=0) {
										i=-1;
										
										farAttack3.setVisible(false);
										
									
									}
									
									try {
										Thread.sleep(80) ;
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
									farAttack3.setVisible(false);
									} 

									
									validate(); 
									repaint();
								}
							}
						};
						
			      Runnable rrrr = new Runnable() {
			 				
							@Override
							public void run() {
								// TODO Auto-generated method stub
								 
								for (int i = 1050; i <= 1250; i++) {
									
									if (i == 1250 ) {
										for (i = 1250; i >=1050; i--) {
											
											farAttack3.setLocation(i,0);
											try {
												Thread.sleep(2) ;
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												farAttack3.setVisible(false);
											
											} 
											validate(); 
											repaint();
										}

										
									}
									farAttack3.setLocation(i,0);
									
									try {
										Thread.sleep(2) ;
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										farAttack3.setVisible(false);
									
									} 
									
									
									validate(); 
									repaint();
								}
							}
						};
						 UltimateShiftFar = new Thread(rrrr) ; 
						 UltimateFarTornado = new Thread(rrr) ; 
						 UltimateShiftFar.start() ;
						 UltimateFarTornado.start();
						 AttackSoundHelper = new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								while (UltimateFarTornado.isAlive()) {
									try {
										AttackSound.run();
										Thread.sleep(300);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									
								}
								
							}
						}); 
						 AttackSoundHelper.start();
						
						
						
						
						changeFoeprogressBar(e,CurrentFoeHealth,previousFoeHealth,difference) ;
						previousFoeHealth = CurrentFoeHealth ; 
				
						
						
						
					}
				}
				else {
					int CurrentMeHealth = ((Fighter) battle.getMe()).getHealthPoints() ;  
					if (CurrentMeHealth<previousMeHealth) { 
						int difference = previousMeHealth - CurrentMeHealth ; 
						  
						  Runnable rrr = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								 
								for (int i = 0; i <= 2; i++) {
									if (i==0) {
									
									NearUltimate.setVisible(true);
									}
									else if (i!=0) {
										i=-1;
										
										NearUltimate.setVisible(false);
										
									
									}
									
									try {
										Thread.sleep(80) ;
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										NearUltimate.setVisible(false);
									} 

									
									validate(); 
									repaint();
								}
							}
						};
						
			      Runnable rrrr = new Runnable() {
			 				
							@Override
							public void run() {
								// TODO Auto-generated method stub
								 
								for (int i = -400; i <= -99; i++) {
									
									if (i == -100 ) {
										for (i = -100; i >=-400; i--) {
											NearUltimate.setLocation(i,0);
											try {
												Thread.sleep(2) ;
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												
											
											} 
											validate(); 
											repaint();
										}

										
									}
									NearUltimate.setLocation(i,0);
									
									try {
										Thread.sleep(2) ;
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
									
									} 
									
									
									validate(); 
									repaint();
								}
							}
						};
						 UltimateShiftNear = new Thread(rrrr) ; 
						 UltimateNearTornado = new Thread(rrr) ; 
						 UltimateShiftNear.start() ;
						 UltimateNearTornado.start();
				
						 AttackSoundHelper = new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								while (UltimateNearTornado.isAlive()) {
									try {
										AttackSound.run();
										Thread.sleep(300);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									
								}
								
							}
						}); 
						 AttackSoundHelper.start();
						 
						changeMeprogressBar(e,CurrentMeHealth,previousMeHealth,difference) ;
						previousMeHealth = CurrentMeHealth ; 
						
				}
			}
			}
			}
			else if (e.getAttack() instanceof MaximumCharge) { 
				AttackAction.setText("Maximum Charge"); 
				AttackAction.setVisible(true); 
				if (e.getCurrentOpponent() == battle.getMe()) {
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(2000) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								AttackAction.setVisible(false);
							} 
							AttackAction.setVisible(false);
							try {
								battle.play();
							} catch (NotEnoughKiException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								Thread.sleep(2000) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
						}
					}).start();
				}
				else {
                        new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(2000) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							AttackAction.setVisible(false);
						
							
							try {
								Thread.sleep(2000) ;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
						}
					}).start();
				}
			}

			else {
				
				if (e.getCurrentOpponent() == battle.getMe()){
					int CurrentFoeHealth = ((Fighter) battle.getFoe()).getHealthPoints() ;  
					if (CurrentFoeHealth<previousFoeHealth) { 
						int difference = previousFoeHealth - CurrentFoeHealth ; 
						Runnable rr = null ; 
						  if (e.getAttack() instanceof SuperAttack){
							  rr = new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										for (int i = 0; i <= 2; i++) {
											if (i==0) {
								
												 farAttack1.setVisible(false);
												 farAttack2.setVisible(false);
												 try {
													Thread.sleep(10);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													farAttack1.setVisible(false);
													 farAttack2.setVisible(false);
													e.printStackTrace();
												}
											}
											else if (i==1) {
									
												farAttack1.setVisible(true);
												farAttack2.setVisible(false);
											}
											else 
											     if (i==2) {
											    	
											    	 farAttack1.setVisible(false);
											    	 farAttack2.setVisible(true);
												i = 0 ; 
											}
											try {
												Thread.sleep(10) ;
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												farAttack1.setVisible(false);
												farAttack2.setVisible(false);
											} 
											validate(); 
											repaint();
										}
									}
								};
							  }
							  else if (e.getAttack().getName().equals("Physical Attack")) {
								  
								  rr = new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											for (int i = 0; i <= 2; i++) {
												if (i==0) {
									
													farAttack1.setVisible(false);
													farAttack2.setVisible(false);
													 try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														farAttack1.setVisible(false);
														farAttack2.setVisible(false);
														e.printStackTrace();
													}
												}
												else if (i==1) {
										
													farAttack2.setVisible(false);
													farAttack1.setVisible(true);
												}
												else 
												     if (i==2) {
												    	
												    	 farAttack1.setVisible(false);
														 farAttack1.setVisible(false);
													i = 0 ; 
												}
												try {
													Thread.sleep(10) ;
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													farAttack1.setVisible(false);
													farAttack1.setVisible(false);
												} 
												validate(); 
												repaint();
											}
										}
									};
							  }
							 tt1 =new Thread(rr) ; 
							tt1.start();
							
							 AttackSoundHelper = new Thread(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										while (tt1.isAlive()) {
											try {
												AttackSound.run();
												Thread.sleep(300);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} 
											
										}
										
									}
								}); 
								 AttackSoundHelper.start();
							
						changeFoeprogressBar(e,CurrentFoeHealth,previousFoeHealth,difference) ;
						previousFoeHealth = CurrentFoeHealth ; 
				
						
						
						
					}
					else if (CurrentFoeHealth == previousFoeHealth && (battle.isFoeBlocking()|| battle.isMeBlocking() )) {
						DefendedAction.setVisible(true ) ; 
						validate() ; 
						repaint () ; 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						battle.play();
					} catch (NotEnoughKiException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								DefendedAction.setVisible(false);
								validate() ; 
								repaint () ; 
						 
					}
					
					
//					int x = e.getAttack().getAppliedDamage(e.getCurrentOpponent()) ; 
//					if (x>((Fighter) battle.getFoe()).getHealthPoints() ) { 
//						x = ((Fighter) battle.getFoe()).getHealthPoints() ; 
//					}
//					
//					for (int i = 0; i <= x; i++) {
//						
//						AttackAction.setText( "" + e.getAttack().getName() + " - " +i);
//						AttackAction.setSize(AttackAction.getPreferredSize()); 
//					 	AttackAction.setLocation(1920/2- AttackAction.getWidth()/2, 1080/2- AttackAction.getHeight()/2);
//					    AttackAction.setVisible(true);
//					    FoeProgressbar.setValue(((Fighter)battle.getFoe()).getHealthPoints()+x-i);
//						 
//					    FoeProgressbar.setString(""+(((Fighter)battle.getFoe()).getHealthPoints()+x-i));
//				
//						 if(FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()+x-i)  <= 75 && FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()+x-i) >25) {
//							 FoeProgressbar.setForeground(Color.orange);
//						 }
//						 else if (FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()+x-i) <= 25) {
//							 FoeProgressbar.setForeground(Color.red);
//						 }
//						 else {
//							 FoeProgressbar.setForeground(Color.green);
//						 }
//					 
//					 repaint();
//					 validate();
//				
//						
//					}
			} 
				else {
			
						int CurrentMeHealth = ((Fighter) battle.getMe()).getHealthPoints() ;  
						if (CurrentMeHealth<previousMeHealth) { 
							int difference = previousMeHealth - CurrentMeHealth ; 
							  Runnable rr = null ; 
							  if (e.getAttack() instanceof SuperAttack){
							  rr = new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										for (int i = 0; i <= 2; i++) {
											if (i==0) {
								
												 NearAttack2.setVisible(false);
												 NearAttack3.setVisible(false);
												 try {
													Thread.sleep(10);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													 NearAttack2.setVisible(false);
													 NearAttack3.setVisible(false);
													e.printStackTrace();
												}
											}
											else if (i==1) {
									
												 NearAttack2.setVisible(true);
												 NearAttack3.setVisible(false);
											}
											else 
											     if (i==2) {
											    	
													 NearAttack2.setVisible(false);
													 NearAttack3.setVisible(true);
												i = 0 ; 
											}
											try {
												Thread.sleep(10) ;
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												NearAttack2.setVisible(false);
												 NearAttack3.setVisible(false);
											} 
											validate(); 
											repaint();
										}
									}
								};
							  }
							  else if (e.getAttack().getName().equals("Physical Attack")) {
								  
								  rr = new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											for (int i = 0; i <= 2; i++) {
												if (i==0) {
									
													 NearAttack2.setVisible(false);
													 NearAttack3.setVisible(false);
													 try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														 NearAttack2.setVisible(false);
														 NearAttack3.setVisible(false);
													}
												}
												else if (i==1) {
										
													 NearAttack2.setVisible(false);
													 NearAttack3.setVisible(true);
												}
												else 
												     if (i==2) {
												    	
														 NearAttack2.setVisible(false);
														 NearAttack3.setVisible(false);
													i = 0 ; 
												}
												try {
													Thread.sleep(10) ;
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													NearAttack2.setVisible(false);
													 NearAttack3.setVisible(false);
												} 
												validate(); 
												repaint();
											}
										}
									};
							  }
							 tt1 =new Thread(rr) ; 
							tt1.start();
							 AttackSoundHelper = new Thread(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										while (tt1.isAlive()) {
											try {
												AttackSound.run();
												Thread.sleep(300);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} 
										
										}
										
									}
								}); 
								 AttackSoundHelper.start();
					
							changeMeprogressBar(e,CurrentMeHealth,previousMeHealth,difference) ;
							previousMeHealth = CurrentMeHealth ; 
					
							
							
							
						
					} else if (CurrentMeHealth == previousMeHealth && (battle.isFoeBlocking()|| battle.isMeBlocking() )) {
						DefendedAction.setVisible(true ) ; 
						
						validate() ; 
						repaint () ; 
						new Thread (new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									Thread.sleep(2500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								DefendedAction.setVisible(false);
								validate() ; 
								repaint () ; 
							
							}
						}).start() ; 
					}
				}
				
				 repaint();
				 validate();
	
	}
			
		
		}
		else if (e.getType() == BattleEventType.BLOCK) {
		
		    BlockAction.setSize(400,60);  
		    
		    BlockAction.setLocation(getWidth()/2 - BlockAction.getWidth()/2 , getHeight() /2 - BlockAction.getHeight()/2);
		   BlockAction.setVisible(true);
		   new Thread (new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					BlockAction.setVisible(false);
					try {
						if(battle.getAttacker() == battle.getFoe())
						battle.play();
					} catch (NotEnoughKiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}).start();
			validate() ; 
		}
		else if (e.getType() == BattleEventType.USE) { 
			  ActionUse.setSize(400,400);  
			    ActionUse.setLocation(getWidth()/2 - ActionUse.getWidth()/2 , getHeight()/2 - ActionUse.getHeight()/2);
			   
			   ActionUse.setVisible(true);
			   new Thread (new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (e.getCurrentOpponent() == battle.getMe()) { 
					for (int i = previousMeHealth; i <= ((Fighter) e.getCurrentOpponent()).getMaxHealthPoints(); i++) {
						try {
							Thread.sleep(12) ;
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
							 MeProgressbar.setValue(i);
							 
							 previousMeHealth = i ; 
							 
							    MeProgressbar.setString(""+i);
							   
								 if(MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints())  <= 75 && MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints()) >25) {
									 MeProgressbar.setForeground(Color.orange);
								 }
								 else if (MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints()) <= 25) {
									 MeProgressbar.setForeground(Color.red);
								 }
								 else {
									 MeProgressbar.setForeground(Color.green);
								 }
								 repaint(); validate();
					}
								
					}
					else {
						for (int i = previousFoeHealth ; i <= ((Fighter) e.getCurrentOpponent()).getMaxHealthPoints(); i++) {
							try {
								Thread.sleep(12) ;
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 previousFoeHealth = i ; 
							 FoeProgressbar.setValue(i);
							 
							    FoeProgressbar.setString(""+i);
							   						
								 if(FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints())  <= 75 && FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()) >25) {
									 FoeProgressbar.setForeground(Color.orange);
								 }
								 else if (FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()) <= 25) {
									 FoeProgressbar.setForeground(Color.red);
								 }
								 else {
									 FoeProgressbar.setForeground(Color.green);
								 }
								 repaint();
								 validate();
					}
							
						
						
					
 					}
					
					 ActionUse.setVisible(false);
					  try {
						  try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							battle.play();
						} catch (NotEnoughKiException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}).start();
			 
			
		}
		else 
		if (e.getType() == BattleEventType.NEW_TURN) {
			if (((PlayableFighter)battle.getMe())instanceof Saiyan) {
				if (!((Saiyan)battle.getMe()).isTransformed() ) {
					MyFighterIcon.setIcon(Guko) ;
					validate() ;
				}
			}
			
			
			
			 MeKi.setVisible(false);
			 MeStamina.setVisible(false);
			 FoeKi.setVisible(false);
			 FoeStamina.setVisible(false);
			
			 MeKi = generateImages(MaxKI.getX(), MaxKI.getY(), (ImageIcon) KiIcon, ((Fighter)battle.getMe()).getKi()) ; 
			 MeKi.setOpaque(false);
			  MeKi.setVisible(true);
				
		     add(MeKi) ; 
		     MeStamina = generateImages(MaxStamina.getX(), MaxStamina.getY(), (ImageIcon) StaminaIcon, ((Fighter)battle.getMe()).getStamina()) ; 
		     MeStamina.setOpaque(false);
		     MeStamina.setVisible(true);
			
		     add(MeStamina) ; 
		
			 FoeKi = generateImages(FoeProgressbar.getX(),FMaxHealth.getY()+FMaxHealth.getHeight()+20, (ImageIcon) KiIcon, ((Fighter)battle.getFoe()).getKi()) ; 
             FoeKi.setOpaque(false);
             FoeKi.setVisible(true);
			 
             add(FoeKi) ; 
			
	    	 FoeStamina = generateImages(FoeProgressbar.getX(),FMaxKI.getY()+FMaxKI.getHeight()+20, (ImageIcon) StaminaIcon, ((Fighter)battle.getFoe()).getStamina()) ; 
		     FoeStamina.setOpaque(false);
		     FoeStamina.setVisible(true);
		     add(FoeStamina) ; 
			  
			   repaint();
			   validate() ; 
		    


					
					if (battle.getMe() == battle.getAttacker()) { 
						
						
						Runnable tt = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									 
									Thread.sleep(3000);
									Use.setEnabled(true); 
									Attack.setEnabled(true); 
									Block.setEnabled(true) ; 
									AttacksList.setEnabled(true);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						};
						Thread xx = new Thread(tt) ; 
						xx.start(); 
					}
					else {
						
						Use.setEnabled(false); 
						Attack.setEnabled(false); 
						Block.setEnabled(false) ; 
						AttacksList.setEnabled(false);
				
						
						validate() ;
				}
			}
			
		
			
		
		
		else if (e.getType()==BattleEventType.ENDED) { 
		
		
			new Thread (new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (tt1!=null) {
						while (tt1.isAlive()) {
							validate();
							repaint();
						}
					}
					if (UltimateFarTornado != null) {
						while (UltimateFarTornado.isAlive()) {
							validate();
							repaint();
						}
					}
					if (UltimateNearTornado!=null) {
						while (UltimateNearTornado.isAlive()) {
							validate();
							repaint();
						}
					}
					parent = new battleEndedView((Battle) e.getSource() ,getGame(),e,currLevel); 
					parent.setVisible(true);
					Runnable r = new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							setVisible(false);
						}
					};
					Thread t = new Thread(r) ; 
					t.start();
					
				}
			}).start();
			
		
 		}
	}


	private void changeFoeprogressBar(BattleEvent e ,int currentFoeHealth,
			int previousFoeHealth2, int difference) {
		// TODO Auto-generated method stub
		
		NearAttack1.setVisible(false); 
		NearAttack2.setVisible(false); 
		NearAttack3.setVisible(false); 
		NearUltimate.setVisible(false); 
		NearUltimate1.setVisible(false);
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int x = FoeIcon.getX() ; 
					int y = FoeIcon.getY() ;
					Thread meT =new Thread (new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							int z = 0 ; 
							while(true) {
								if (z%2 == 0 )
									FoeIcon.setLocation(x, y+5);
								else 
									FoeIcon.setLocation(x, y-5);
								
								z++ ; 
								validate();
								repaint();
							}
							
						}
					});
					meT.start();
					
					for ( Counter1 = previousFoeHealth2, Counter2= 0; Counter1 >= currentFoeHealth&&Counter2<=difference; Counter1--,Counter2++) {
					AttackAction.setText( "" + e.getAttack().getName() + " - " +Counter2);
					AttackAction.setSize(AttackAction.getPreferredSize()); 
				 	AttackAction.setLocation(1920/2- AttackAction.getWidth()/2, 1080/2- AttackAction.getHeight()/2);
				    AttackAction.setVisible(true);
				    FoeProgressbar.setValue(Counter1);
					 
				    FoeProgressbar.setString(""+Counter1);
			
					 if(FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints())  <= 75 && FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()) >25) {
						 FoeProgressbar.setForeground(Color.orange);
					 }
					 else if (FoeProgressbar.getValue()*100/(((Fighter)battle.getFoe()).getMaxHealthPoints()) <= 25) {
						 FoeProgressbar.setForeground(Color.red);
					 }
					 else {
						 FoeProgressbar.setForeground(Color.green);
					 }
				 
				 repaint();
				 validate();
					try {
						Thread.sleep(15) ;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
					Runnable xxx = new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							SayianAttack.setVisible(false);
							AttackAction.setVisible(false);
							BlockAction.setVisible(false);
				        	ActionUse.setVisible(false);

							if (UltimateShiftFar!=null)
								UltimateShiftFar.stop() ;
							if(UltimateFarTornado!=null)
								UltimateFarTornado.stop();
							if (tt1!=null)
									tt1.stop();
							new Thread (new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									meT.stop(); 
									FoeIcon.setLocation(x, y); 
									repaint() ; 
									validate(); 
									
									farAttack1.setVisible(false); 
									farAttack2.setVisible(false); 
									farAttack3.setVisible(false); 
									NearAttack1.setVisible(false); 
									NearAttack2.setVisible(false); 
									NearAttack3.setVisible(false); 
									NearUltimate.setVisible(false); 
									NearUltimate1.setVisible(false);
									 repaint();
									 validate();
								}
							}).start();
							 repaint();
							 validate();
							 try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				        	try {
								if(battle.getAttacker() == battle.getFoe())
								battle.play();
								
							} catch (NotEnoughKiException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					};
					new Thread(xxx).start();
						
				}
			};
			Thread t = new Thread(r) ; 
			t.start();
		
		
		
	}
	
	private void changeMeprogressBar(BattleEvent e , int currentFoeHealth,
			int previousFoeHealth2, int difference) {
		// TODO Auto-generated method stub
		farAttack1.setVisible(false); 
		farAttack2.setVisible(false); 
		farAttack3.setVisible(false); 
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int x = MyFighterIcon.getX() ; 
				int y = MyFighterIcon.getY() ;
				Thread meT =new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int z = 0 ; 
						while(true) {
							if (z%2 == 0 )
							MyFighterIcon.setLocation(x, y+5);
							else 
								MyFighterIcon.setLocation(x, y-5);
							
							z++ ; 
							validate();
							repaint();
						}
						
					}
				});
				meT.start();
				for ( Counter1 = previousFoeHealth2, Counter2= 0; Counter1 >= currentFoeHealth&&Counter2<=difference; Counter1--,Counter2++) {
				AttackAction.setText( "" + e.getAttack().getName() + " - " +Counter2);
				AttackAction.setSize(AttackAction.getPreferredSize()); 
			 	AttackAction.setLocation(1920/2- AttackAction.getWidth()/2, 1080/2- AttackAction.getHeight()/2);
			    AttackAction.setVisible(true);
			    MeProgressbar.setValue(Counter1);
				 
			    MeProgressbar.setString(""+Counter1);
		
				 if(MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints())  <= 75 && MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints()) >25) {
					 MeProgressbar.setForeground(Color.orange);
				 }
				 else if (MeProgressbar.getValue()*100/(((Fighter)battle.getMe()).getMaxHealthPoints()) <= 25) {
					 MeProgressbar.setForeground(Color.red);
				 }
				 else {
					 MeProgressbar.setForeground(Color.green);
				 }
			 
			 repaint();
			 validate();
				try {
					Thread.sleep(15) ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
				
				
				
				
				new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
                         meT.stop();
                         MyFighterIcon.setLocation(x, y);
                         validate() ; 
                         repaint();
						if (UltimateShiftNear!=null)
						 UltimateShiftNear.stop() ;
						if(UltimateNearTornado!=null)
						 UltimateNearTornado.stop();
						if (tt1!=null)
						 tt1.stop();
						farAttack1.setVisible(false); 
						farAttack2.setVisible(false); 
						farAttack3.setVisible(false); 
						NearAttack1.setVisible(false); 
						NearAttack2.setVisible(false); 
						NearAttack3.setVisible(false); 
						NearUltimate.setVisible(false); 
						NearUltimate1.setVisible(false);
						 repaint();
						 validate();
					}
				}).start();
				
				 repaint();
				 validate();
						Runnable xxx = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								SayianAttack.setVisible(false);
								AttackAction.setVisible(false);
								BlockAction.setVisible(false);
					        	ActionUse.setVisible(false);
					        	Use.setEnabled(true); 
								Attack.setEnabled(true); 
								Block.setEnabled(true) ; 
								AttacksList.setEnabled(true);
							}
						};
						new Thread(xxx).start();
				NearAttack2.setVisible(false); 
				NearAttack3.setVisible(false);
				repaint();
				 validate();
				
			}
		};
		Thread t = new Thread(r) ; 
		t.start();
	
	
	
		
	}

	@Override
	public void onTournamentEvent(TournamentStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStageComplete(int stage) {
		// TODO Auto-generated method stub
		
	}
	public  JPanel generateImages(int StartX , int StartY , ImageIcon i , int n) {
		JPanel p = new JPanel() ; 
		p.setLayout(null);
		p.setLocation(StartX,StartY);
		for(int i1 = 0 ; i1 < n ; i1++) {
			JLabel j = new JLabel(i) ; 
			j.setSize(25,13) ; 
			if (i1 == 0 )
			j.setLocation(25*(i1), 0 ); 
			else
				j.setLocation(25*(i1), 0 ); 
				
			p.add(j); 
		}
		p.setSize (400,20) ; 
		return p ; 
	}

	@Override
	public void onTournamentMatchEvent(BattleEvent e, MatchStatus matchStatus) {
		// TODO Auto-generated method stub
		
	}

}
