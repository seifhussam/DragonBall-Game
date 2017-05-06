package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.ScrollPane;
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

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dragonball.controller.BackHandler;
import dragonball.controller.CreateFighterInTournamentHandler;
import dragonball.controller.Next2Handler;
import dragonball.controller.SpecialBackHandler;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class FighterOptionsVeiw extends GameVeiw implements Serializable  {
	private JFrame parent ;
	private JButton Back ; 
	private Font customFont ; 
	private Font customFont2 ; 
	private Font customFont3 ; 
	private JComboBox Fighters;
	private JLabel FighterOptions;
	private JLabel FighterIcon;
	private JLabel Level;
	private JLabel MaxHealth;
	private JLabel MaxKI;
	private JLabel MaxStamina;
	private JLabel PhysicalDamage;
	private JLabel BlastDamage;
	private JLabel AbilityPoints;
	private JProgressBar XpProgressBar;
	private JLabel XpProgress;
	private JLabel SuperAttacksLabel;
	private JLabel UltimateAttacksLabel;
	private JLabel FSuperAttacksLabel;
	private JLabel FUltimateAttacksLabel;
	private JPanel PSuperAttacks;
	private JPanel PUltimateAttacks;
	private JButton MoveS;
	private JButton MoveU;
	private JPanel FSuperAttacks;
	private JPanel FUltimateAttacks;
	private JButton CreateFighter;
	private JLabel AttacksInstructions;
	private JButton PlusH;
	private JButton PlusST;
	private JButton PlusKI;
	private JButton PlusPD;
	private JButton PlusBD;
	private AddAnotherFighter child2 ; 

	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
    private Game game ;
	private JLabel LevelNumber;
	private JLabel MaxHealthnumber;
	private JLabel Maxkinumber;
	private JLabel MAxstNumber;
	private JLabel PhysicalNumber;
	private JLabel BDnumber;
	private Font JcustomFont;
	private JLabel APNumber; 
	private WorldVeiw child ;
	private SpecialBackHandler s;
	private JList PSuperAttacksList;
	private JList FSuperAttacksList;
	private JList PUltimateAttacksList;
	private JList FUltimateAttacksList;
	private JScrollPane ScrollPSuper;
	private JScrollPane ScrollFSuper;
	private JScrollPane ScrollPUltimate;
	private JScrollPane ScrollFUltimate; 
	public FighterOptionsVeiw(WorldVeiw parent, Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		this.game = game ;
		this.parent=parent ; 
		
		setLayout(null);
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(DimMax);
	    Icon ii = new  ImageIcon(getClass().getResource("Dragon-Ball-Z-Son-Goku-HD-Wallpaper.jpg")) ;
		JLabel temp  = new JLabel(ii) ;
		setContentPane(temp);
		try {
		    //create the font to use. Specify the size!
		   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(27f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		Font Button = null ;
		try {
		    //create the font to use. Specify the size!
			Button = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(24f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
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
		   customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(20f);
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
		   customFont4 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		Font customFont5= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			customFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		

	    Icon Exit1 = new ImageIcon(getClass().getResource("ExitRed.png")); 
		Icon Exitrev = new ImageIcon(getClass().getResource("ExitBlue.png"));
		JButton Exit = new JButton(Exit1) ; 
		Exit.setRolloverIcon(Exitrev);
		Exit.setFont(customFont);  
		Exit.setContentAreaFilled(false);
		Exit.setBorderPainted(false);
		Exit.setFocusable(false);
		Exit.setSize(100,BUTTONHEIGHT);
        Exit.setLocation(0,0);
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
        Back.setLocation(100, 0);
  	  child =  new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(getGame()), getGame()), getGame()), getGame()) ; 
         s =    new SpecialBackHandler(child,this);
        Back.addActionListener(s);
        add(Back);
        

        
        FighterOptions = new JLabel("Fighter Options") ;  
        FighterOptions.setFont(customFont2); 
        FighterOptions.setForeground(Color.RED);
        FighterOptions.setSize(FighterOptions.getPreferredSize());
        FighterOptions.setLocation(getWidth()/2-FighterOptions.getWidth()/2, 30);
		add(FighterOptions);
        
        FighterIcon= new JLabel(setFighterIconLarge(game.getPlayer().getActiveFighter()));
       FighterIcon.setSize(FighterIcon.getPreferredSize());
        FighterIcon.setLocation(Back.getWidth(),200);
        add(FighterIcon);
        
        
        XpProgressBar=new JProgressBar(0,game.getPlayer().getActiveFighter().getTargetXp());
        XpProgressBar.setValue(game.getPlayer().getActiveFighter().getXp());
        XpProgressBar.setSize(200,10);
        XpProgressBar.setLocation(Back.getWidth(),FighterIcon.getY()+FighterIcon.getHeight()+20);
        XpProgressBar.setForeground(Color.red);
        add(XpProgressBar);
        
        
        XpProgress=new JLabel("XP: "+XpProgressBar.getValue()+" out of "+XpProgressBar.getMaximum());
        XpProgress.setSize(200,10);
        XpProgress.setLocation(XpProgressBar.getX()+60,XpProgressBar.getY()+XpProgressBar.getHeight()+20);
        add(XpProgress);
        
        
        ArrayList<PlayableFighter> x= game.getPlayer().getFighters();
 	   String[] names=new String[x.size()];
 	   for (int i = 0; i < names.length; i++) {
 		names[i]=x.get(i).getName(); 
 	   }
 		
		Font Font5Text = new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			Font5Text = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		int n = 0 ; 
		for (n= 0; n < names.length; n++) {
			if (getGame().getPlayer().getFighters().get(n).getName().equalsIgnoreCase(names[n])) {
				break ;
			}
		}
 	    Fighters= new JComboBox(names);
	    Fighters.setFont(customFont);
	    Fighters.setSelectedIndex(n);
	    Fighters.setSize(Fighters.getPreferredSize());
	    Fighters.setLocation(FighterIcon.getX()+FighterIcon.getWidth()+100,250);
	    Fighters.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getGame().getPlayer().setActiveFighter(getGame().getPlayer().getFighters().get(Fighters.getSelectedIndex()));
			FighterIcon.setIcon( setFighterIconLarge(getGame().getPlayer().getActiveFighter())) ;
			 
			 LevelNumber.setText((": "+getGame().getPlayer().getActiveFighter().getLevel())); 
			 LevelNumber.setSize(Level.getPreferredSize());
			  MaxHealthnumber.setText(": "+getGame().getPlayer().getActiveFighter().getMaxHealthPoints()) ; 
			  MaxHealthnumber.setSize(MaxHealth.getPreferredSize());
			  Maxkinumber.setText(": "+getGame().getPlayer().getActiveFighter().getMaxKi()) ; 
			  Maxkinumber.setSize(MaxKI.getPreferredSize());
			  MAxstNumber.setText (": "+getGame().getPlayer().getActiveFighter().getMaxStamina()) ;
			  MAxstNumber.setSize(MaxStamina.getPreferredSize());
			  PhysicalNumber.setText(": "+getGame().getPlayer().getActiveFighter().getPhysicalDamage()) ;
			  PhysicalNumber.setSize(PhysicalDamage.getPreferredSize());
			  BDnumber.setText(": "+getGame().getPlayer().getActiveFighter().getBlastDamage()) ; 
			  BDnumber.setSize(BlastDamage.getPreferredSize());
			   XpProgressBar.setMaximum(getGame().getPlayer().getActiveFighter().getTargetXp());
			   XpProgressBar.setValue(getGame().getPlayer().getActiveFighter().getXp());
			   ArrayList<SuperAttack> y= getGame().getPlayer().getSuperAttacks();
			   XpProgress.setText("XP: "+XpProgressBar.getValue()+" out of "+XpProgressBar.getMaximum());
			   
			   ArrayList<SuperAttack> b= getGame().getPlayer().getActiveFighter().getSuperAttacks();
		 	   String[] SA=new String[b.size()];
		 	   for (int i = 0; i < SA.length; i++) {
		 		SA[i]=b.get(i).getName(); 
		 	   }
		 	   
		 	 ArrayList<UltimateAttack> z= getGame().getPlayer().getActiveFighter().getUltimateAttacks();
		 	  String[] UA=new String[z.size()];
		 	  for (int i = 0; i < UA.length; i++) {
		 		 UA[i]=z.get(i).getName(); 
		 	   }
		 	 FSuperAttacksList.setListData(SA);
			 FUltimateAttacksList.setListData(UA);
			   
		    child =  new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(getGame()), getGame()), getGame()),getGame()) ; 
			s.setChild(child);
		}
	});
	    
	    add(Fighters);
	    
	    Icon plus=new ImageIcon(getClass().getResource("plus.png"));
	    Icon plusRev=new ImageIcon(getClass().getResource("plusrev.png"));
	    
	    
	    Level = new JLabel("Level ") ; 
	    Level.setFont(Font5Text); 
	    Level.setSize(Level.getPreferredSize());
	    Level.setForeground(Color.red);
	    Level.setLocation(Fighters.getX(),Fighters.getY()+Fighters.getHeight()+20);
	    add(Level);
	     LevelNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getLevel()) ; 
	    LevelNumber.setFont(customFont5); 
	    LevelNumber.setForeground(Color.red);
	    LevelNumber.setSize(LevelNumber.getPreferredSize());
	    LevelNumber.setLocation(Level.getX() +Level.getWidth(),Level.getY());
	    add(LevelNumber);
	    
	    
	    AbilityPoints = new JLabel("Ability Points ") ; 
	    AbilityPoints.setFont(Font5Text); 
	    AbilityPoints.setForeground(Color.red);
	    AbilityPoints.setSize(AbilityPoints.getPreferredSize());
	    AbilityPoints.setLocation(Fighters.getX(),Level.getY()+Level.getHeight()+20);
	    add(AbilityPoints);
	    APNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getAbilityPoints()) ; 
	    APNumber.setFont(customFont5); 
	    APNumber.setForeground(Color.red);
	    APNumber.setSize(APNumber.getPreferredSize());
	    APNumber.setLocation(AbilityPoints.getX() +AbilityPoints.getWidth(),AbilityPoints.getY());
	    add(APNumber) ;
	    
	    MaxHealth = new JLabel("Max Health ") ; 
	    MaxHealth.setFont(Font5Text); 
	    MaxHealth.setForeground(Color.red);
	    MaxHealth.setSize(MaxHealth.getPreferredSize());
	    MaxHealth.setLocation(Fighters.getX(),AbilityPoints.getY()+AbilityPoints.getHeight()+20);
	    add(MaxHealth); 
	    
	     MaxHealthnumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxHealthPoints()) ; 
	    MaxHealthnumber.setFont(customFont5); 
	    MaxHealthnumber.setForeground(Color.red);
	    MaxHealthnumber.setSize(MaxHealthnumber.getPreferredSize());
	    MaxHealthnumber.setLocation(MaxHealth.getX() +MaxHealth.getWidth(),MaxHealth.getY());
	    add(MaxHealthnumber);
	    
	    PlusH= new JButton(plus);
	    PlusH.setRolloverIcon(plusRev);
	    PlusH.setContentAreaFilled(false);
	    PlusH.setBorderPainted(false);
	    PlusH.setFocusable(false);
	    PlusH.setSize(30,30);
	    PlusH.setLocation(Fighters.getX()-50, MaxHealth.getY());
	    PlusH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'H');
				} catch (NotEnoughAbilityPointsException e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "You don't have enough ability points to upgrade ", "Error",  JOptionPane.OK_OPTION);
					
				}
				//adjust ability points labels 
				MaxHealthnumber.setText(": "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
				MaxHealthnumber.setSize(MaxHealthnumber.getPreferredSize());
					
				
			}
		});
	    add(PlusH);
	    
		
	    MaxKI = new JLabel("Max Ki: ") ; 
	    MaxKI.setFont(Font5Text); 
	    MaxKI.setForeground(Color.red);
	    MaxKI.setSize(MaxKI.getPreferredSize());
	    MaxKI.setLocation(Fighters.getX(),MaxHealth.getY()+MaxHealth.getHeight()+20);
	    add(MaxKI);
	    
	    Maxkinumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxKi()) ; 
	    Maxkinumber.setFont(customFont5); 
	    Maxkinumber.setForeground(Color.red);
	    Maxkinumber.setSize(Maxkinumber.getPreferredSize());
	    Maxkinumber.setLocation(MaxKI.getX() +MaxKI.getWidth(),MaxKI.getY());
	    add(Maxkinumber);
	    
	    PlusKI= new JButton(plus);
	    PlusKI.setRolloverIcon(plusRev);
	    PlusKI.setContentAreaFilled(false);
	    PlusKI.setBorderPainted(false);
	    PlusKI.setFocusable(false);
	    PlusKI.setSize(30,30);
	    PlusKI.setLocation(Fighters.getX()-50, MaxKI.getY());
	    PlusKI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'K');
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "You don't have enough ability points to upgrade ", "Error",  JOptionPane.OK_OPTION);
				}
				//adjust ability points labels 
				Maxkinumber.setText(": "+game.getPlayer().getActiveFighter().getMaxKi());
				Maxkinumber.setSize(Maxkinumber.getPreferredSize());
					
				
			}
		});
	    add(PlusKI);
	    
	    
	    MaxStamina = new JLabel("Max Stamina ") ;
	    MaxStamina.setFont(Font5Text); 
	    MaxStamina.setForeground(Color.red);
	    MaxStamina.setSize(MaxStamina.getPreferredSize());
	    MaxStamina.setLocation(Fighters.getX(),MaxKI.getY()+MaxKI.getHeight()+20);
	    add(MaxStamina);
		
	    MAxstNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getMaxStamina()) ; 
	    MAxstNumber.setFont(customFont5); 
	    MAxstNumber.setForeground(Color.red);
	    MAxstNumber.setSize(MAxstNumber.getPreferredSize());
	    MAxstNumber.setLocation(MaxStamina.getX() +MaxStamina.getWidth(),MaxStamina.getY());
	    add(MAxstNumber);
	    
	    PlusST= new JButton(plus);
	    PlusST.setRolloverIcon(plusRev);
	    PlusST.setContentAreaFilled(false);
	    PlusST.setBorderPainted(false);
	    PlusST.setFocusable(false);
	    PlusST.setSize(30,30);
	    PlusST.setLocation(Fighters.getX()-50, MaxStamina.getY());
	    PlusST.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'S');
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "You don't have enough ability points to upgrade ", "Error",  JOptionPane.OK_OPTION);
				}
				//adjust ability points labels 
				MAxstNumber.setText(": "+game.getPlayer().getActiveFighter().getMaxStamina());
				MAxstNumber.setSize(MAxstNumber.getPreferredSize());
			}
				
		});
	    add(PlusST);
	    
	    PhysicalDamage = new JLabel("Physical Damage ") ; 
	    PhysicalDamage.setFont(Font5Text); 
	    PhysicalDamage.setForeground(Color.red);
	    PhysicalDamage.setSize(PhysicalDamage.getPreferredSize());
	    PhysicalDamage.setLocation(Fighters.getX(),MaxStamina.getY()+MaxStamina.getHeight()+20);
	    add(PhysicalDamage);
	    PhysicalNumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getPhysicalDamage()) ; 
	    PhysicalNumber.setFont(customFont5); 
	    PhysicalNumber.setForeground(Color.red);
	    PhysicalNumber.setSize(PhysicalNumber.getPreferredSize());
	    PhysicalNumber.setLocation(PhysicalDamage.getX() +PhysicalDamage.getWidth(),PhysicalDamage.getY());
	    add(PhysicalNumber);
	    
	    PlusPD= new JButton(plus);
	    PlusPD.setRolloverIcon(plusRev);
	    PlusPD.setContentAreaFilled(false);
	    PlusPD.setBorderPainted(false);
	    PlusPD.setFocusable(false);
	    PlusPD.setSize(30,30);
	    PlusPD.setLocation(Fighters.getX()-50, PhysicalDamage.getY());
	    PlusPD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					try {
						game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'P');
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "You don't have enough ability points to upgrade ", "Error",  JOptionPane.OK_OPTION);
					}
					//adjust ability points labels 
					PhysicalNumber.setText(": "+game.getPlayer().getActiveFighter().getPhysicalDamage());
					PhysicalNumber.setSize(PhysicalNumber.getPreferredSize());
					 
					
				
			}
		});
	    add(PlusPD);
	    
	    
	    BlastDamage = new JLabel("Blast Damage ") ;  
	    BlastDamage.setFont(Font5Text); 
	    BlastDamage.setForeground(Color.red);
	    BlastDamage.setSize(BlastDamage.getPreferredSize());
	    BlastDamage.setLocation(Fighters.getX(),PhysicalDamage.getY()+PhysicalDamage.getHeight()+20);
	    add(BlastDamage);
	    
	    BDnumber =  new JLabel(": "+game.getPlayer().getActiveFighter().getBlastDamage()) ; 
	    BDnumber.setFont(customFont5); 
	    BDnumber.setForeground(Color.red);
	    BDnumber.setSize(BDnumber.getPreferredSize());
	    BDnumber.setLocation(BlastDamage.getX() +BlastDamage.getWidth(),BlastDamage.getY());
	    add(BDnumber);
	    
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
				
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
	    
	    PlusBD= new JButton(plus);
	    PlusBD.setRolloverIcon(plusRev);
	    PlusBD.setContentAreaFilled(false);
	    PlusBD.setBorderPainted(false);
	    PlusBD.setFocusable(false);
	    PlusBD.setSize(30,30);
	    PlusBD.setLocation(Fighters.getX()-50, BlastDamage.getY());
	    PlusBD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'B');
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				
					JOptionPane.showMessageDialog(null, "You don't have enough ability points to upgrade ", "Error",  JOptionPane.OK_OPTION);
				}
				//adjust ability points labels 
				BDnumber.setText(": "+game.getPlayer().getActiveFighter().getBlastDamage());
				BDnumber.setSize(BDnumber.getPreferredSize());
					
				
			}
		});
	    add(PlusBD);
	  
	    CreateFighter=new JButton("Create Fighter");
	   
	    CreateFighter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	new NewFighterVeiwHandler();
			}
		});
	    CreateFighter = new JButton("Add Fighter") ; 
	    CreateFighter.setFont(customFont);
	    CreateFighter.setSize(BUTTONWIDTH,BUTTONHEIGHT);
	    CreateFighter.setLocation(FighterIcon.getX()-20,BlastDamage.getY()+BlastDamage.getHeight()+50);
		CreateFighter.setForeground(Color.red);
		CreateFighter.setContentAreaFilled(false);
		CreateFighter.setBorderPainted(false);
		CreateFighter.setFocusable(false);

		AddFighterInWorld child3 = new AddFighterInWorld(this, game.getPlayer().getName(), game) ; 
		
	    CreateFighter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
				child3.setVisible(true );
			}
		} );
	    CreateFighter.addMouseListener(new MouseListener() {
			
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
				CreateFighter.setForeground(Color.red);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				CreateFighter.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	    add(CreateFighter);
	    
	    ArrayList<SuperAttack> y= game.getPlayer().getSuperAttacks();
	 	   SuperAttack [] SA=new SuperAttack[y.size()];
	 	   for (int i = 0; i < SA.length; i++) {
	 		SA[i]=y.get(i) ;
	 	   }
	 	   
	 	 ArrayList<UltimateAttack> z= game.getPlayer().getUltimateAttacks();
	 	  UltimateAttack [] UA=new UltimateAttack[z.size()];
	 	  for (int i = 0; i < UA.length; i++) {
	 		 UA[i]=z.get(i);
	 	   }
	 	  
		    ArrayList<SuperAttack> yf= game.getPlayer().getActiveFighter().getSuperAttacks();
		    SuperAttack[] FSA=new SuperAttack[yf.size()];
		 	   for (int i = 0; i < FSA.length; i++) {
		 		FSA[i]=yf.get(i);
		 	   }
		 	   
		 	 ArrayList<UltimateAttack> zf= game.getPlayer().getActiveFighter().getUltimateAttacks();
		 	UltimateAttack[] FUA=new UltimateAttack[zf.size()];
		 	  for (int i = 0; i < FUA.length; i++) {
		 		 FUA[i]=zf.get(i);
		 	   }
	    
	    SuperAttacksLabel=new JLabel("Player Super Attacks");
	    SuperAttacksLabel.setFont(customFont);
	    SuperAttacksLabel.setSize( SuperAttacksLabel.getPreferredSize());
	    SuperAttacksLabel.setLocation(10,800);
	    add(SuperAttacksLabel);
	    
	    
	 
	    PSuperAttacks = new JPanel() ; 
	    PSuperAttacks.setOpaque(false);
	    PSuperAttacksList=new JList(SA);
	    PSuperAttacksList.setFont(customFont);
	    PSuperAttacksList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	     PSuperAttacksList.setLayoutOrientation(JList.VERTICAL);
	     PSuperAttacksList.setBackground(null);
	    PSuperAttacks.setLayout(null);
	    PSuperAttacksList.setVisibleRowCount(5);
	    PSuperAttacksList.setBounds(0,0,269,200);
	    ScrollPSuper = new JScrollPane(PSuperAttacksList) ; 
	     ScrollPSuper.setBackground(null);
	    
	    PSuperAttacks.setLocation(SuperAttacksLabel.getX(),SuperAttacksLabel.getY()+SuperAttacksLabel.getHeight()+20);
	    PSuperAttacks.setSize(269,200);
	    ScrollPSuper.setSize(269,200) ; 
	    ScrollPSuper.setLocation(0, 0);
        PSuperAttacks.add(ScrollPSuper);
        PSuperAttacksList.setBackground(null);

		 PSuperAttacksList.setOpaque(false);
		 ScrollPSuper.setOpaque(false);
		 ScrollPSuper.getViewport().setOpaque(false);
	    add(PSuperAttacks);
	    
	    
	    MoveS = new JButton ("Assign -->") ;
	    
	    MoveS.setFont(Button);
	    MoveS.setSize(MoveS.getPreferredSize());
	    MoveS.setFocusable(false);
	    MoveS.setOpaque(false);
	    MoveS.setContentAreaFilled(false);
	    MoveS.setBorderPainted(false);
	    MoveS.setLocation(PSuperAttacks.getX()+PSuperAttacks.getWidth()+20, PSuperAttacks.getY()+(PSuperAttacks.getHeight()/2));
	    MoveS.addActionListener(
	    		new ActionListener() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (PSuperAttacksList.getSelectedValue()!=null){
					if(FSuperAttacksList.getSelectedValue()==null) { 
						try {
							game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), (SuperAttack)PSuperAttacksList.getSelectedValue(), null);
						} 
						catch (Exception e1) {
							if (e1 instanceof DuplicateAttackException)
							JOptionPane.showMessageDialog(null, "This Attack is already assigned ", "Error",  JOptionPane.OK_OPTION);
							else if (e1 instanceof MaximumAttacksLearnedException)
								JOptionPane.showMessageDialog(null, "You cannot choose more than 4 Super Attacks", "Error",  JOptionPane.OK_OPTION);
						}
						
					}
					else {
						
						try {
							game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), (SuperAttack)PSuperAttacksList.getSelectedValue(), (SuperAttack)FSuperAttacksList.getSelectedValue());
						} 
						catch (Exception e1) {
							if (e1 instanceof DuplicateAttackException)
							JOptionPane.showMessageDialog(null, "This Attack is already assigned ", "Error",  JOptionPane.OK_OPTION);
							else if (e1 instanceof MaximumAttacksLearnedException)
								JOptionPane.showMessageDialog(null, "You cannot choose more than 4 Super Attacks", "Error",  JOptionPane.OK_OPTION);
						}
					}
					
						}
						
						SuperAttack []  FSA=new SuperAttack[game.getPlayer().getActiveFighter().getSuperAttacks().size()];
					 	   for (int i = 0; i < FSA.length; i++) {
					 		FSA[i]=game.getPlayer().getActiveFighter().getSuperAttacks().get(i);
					 	   }
					 	  FSuperAttacksList.setListData(FSA);
					
					}
	    		}
				
	    		);
	    add(MoveS);
	    
	    FSuperAttacksLabel =new JLabel("Fighter Super Attacks");
	    FSuperAttacksLabel.setFont(customFont);
	    
	    FSuperAttacksLabel.setSize( FSuperAttacksLabel.getPreferredSize());
	    FSuperAttacksLabel.setLocation(MoveS.getX()+MoveS.getWidth()+25,SuperAttacksLabel.getY());
	    add(FSuperAttacksLabel);
	    
	    FSuperAttacks = new JPanel() ; 
	   
	    FSuperAttacksList=new JList(FSA);
	    FSuperAttacksList.setFont(customFont);
	    FSuperAttacksList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    FSuperAttacksList.setLayoutOrientation(JList.VERTICAL);
	    FSuperAttacks.setLayout(null);
	    FSuperAttacksList.setVisibleRowCount(5);
	    FSuperAttacksList.setBounds(0,0,269,200);
	    ScrollFSuper = new JScrollPane(FSuperAttacksList) ; 
	    ScrollFSuper.setSize(269,200) ; 
	    ScrollFSuper.setLocation(0, 0);
	    FSuperAttacks.add(ScrollFSuper);
	    FSuperAttacksList.setBackground(null);
	    FSuperAttacks.setLocation(MoveS.getX()+MoveS.getWidth()+25,SuperAttacksLabel.getY()+SuperAttacksLabel.getHeight()+20);
	    FSuperAttacks.setSize(269,200);
	    FSuperAttacks.setOpaque(false);
	    ScrollFSuper.getViewport().setOpaque(false);
		  FSuperAttacksList.setOpaque(false);
		  ScrollFSuper.setOpaque(false);
	    add(FSuperAttacks);
	    
	    UltimateAttacksLabel=new JLabel("Player Ultimate Attacks");
	    UltimateAttacksLabel.setFont(customFont);
	    UltimateAttacksLabel.setSize(UltimateAttacksLabel.getPreferredSize());
	    UltimateAttacksLabel.setLocation(1200,800);
	    add(UltimateAttacksLabel);
	    
	    PUltimateAttacks = new JPanel()  ; 
	    PUltimateAttacks.setOpaque(false);
	    PUltimateAttacksList=new JList(UA);
	    PUltimateAttacksList.setFont(customFont);
	    PUltimateAttacksList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    PUltimateAttacksList.setLayoutOrientation(JList.VERTICAL);
	    PUltimateAttacks.setLayout(null);
	    PUltimateAttacksList.setVisibleRowCount(5);
	    PUltimateAttacksList.setBounds(0,0,269,200);
	    PUltimateAttacksList.setBackground(null);
	    ScrollPUltimate = new JScrollPane(PUltimateAttacksList) ; 
	    ScrollPUltimate.setSize(269,200) ; 
	    ScrollPUltimate.setLocation(0, 0);
	    PUltimateAttacks.add(ScrollPUltimate);
	    PUltimateAttacks.setSize(269,200);
	 
	  PUltimateAttacksList.setOpaque(false);
	  ScrollPUltimate.setOpaque(false);
	  ScrollPUltimate.getViewport().setOpaque(false);
	    PUltimateAttacks.setLocation(UltimateAttacksLabel.getX(),UltimateAttacksLabel.getY()+UltimateAttacksLabel.getHeight()+20); 
	    add(PUltimateAttacks);
	    
	    MoveU = new JButton ("Assign -->") ;
	 
	    MoveU.setFont(Button);
	    MoveU.setSize(MoveS.getPreferredSize());
	    MoveU.setFocusable(false);
	    MoveU.setOpaque(false);
	    MoveU.setContentAreaFilled(false);
	    MoveU.setBorderPainted(false);
	    MoveU.setLocation(PUltimateAttacks.getX()+PUltimateAttacks.getWidth()+20, PUltimateAttacks.getY()+(PUltimateAttacks.getHeight()/2));
	    MoveU.addActionListener(
	    		new ActionListener() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
							
						if (PUltimateAttacksList.getSelectedValue()!=null){
							if(FUltimateAttacksList.getSelectedValue()==null) { 
								try {
									
										game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), (UltimateAttack)PUltimateAttacksList.getSelectedValue(), null);
								}
										catch (Exception e1) {
											if (e1 instanceof NotASaiyanException) {
												JOptionPane.showMessageDialog(null, "You Cannot assign Super Saiyan Attack to Non Saiyan Charachter ", "Error",  JOptionPane.OK_OPTION);
											}
											else 
												if (e1 instanceof DuplicateAttackException) {
													JOptionPane.showMessageDialog(null, "This Attack is already assigned ", "Error",  JOptionPane.OK_OPTION);
												}
												else if (e1 instanceof MaximumAttacksLearnedException) { 
													JOptionPane.showMessageDialog(null, "You cannot choose more than 2 Ultimate Attacks ", "Error",  JOptionPane.OK_OPTION);
												}
										// TODO Auto-generated catch block
										
										
									
									 } 
							}
							else {
								
								try {
									game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), (UltimateAttack)PUltimateAttacksList.getSelectedValue(), (UltimateAttack)FUltimateAttacksList.getSelectedValue());
								} catch (Exception e1) {
									if (e1 instanceof NotASaiyanException) {
										JOptionPane.showMessageDialog(null, "You Cannot assign Super Saiyan Attack to Non Saiyan Charachter ", "Error",  JOptionPane.OK_OPTION);
									}
									else 
										if (e1 instanceof DuplicateAttackException) {
											JOptionPane.showMessageDialog(null, "This Attack is already assigned ", "Error",  JOptionPane.OK_OPTION);
										}
										else if (e1 instanceof MaximumAttacksLearnedException){ 
											JOptionPane.showMessageDialog(null, "You cannot choose more than 2 Ultimate Attacks ", "Error",  JOptionPane.OK_OPTION);
										}
								// TODO Auto-generated catch block
								
								
							
							 } 
							}
								}
						UltimateAttack []  FSA=new UltimateAttack[game.getPlayer().getActiveFighter().getUltimateAttacks().size()];
					 	   for (int i = 0; i < FSA.length; i++) {
					 		FSA[i]=game.getPlayer().getActiveFighter().getUltimateAttacks().get(i);
					 	   }
					 	   FUltimateAttacksList.setListData(FSA);
							
							}
							  
						
					
					
				}
	    		);
	    add(MoveU);
	    
	    
	    FUltimateAttacksLabel =new JLabel("Fighter Ultimate Attacks");
	    FUltimateAttacksLabel .setFont(customFont);
	    FUltimateAttacksLabel .setSize( FUltimateAttacksLabel .getPreferredSize());
	    FUltimateAttacksLabel .setLocation(MoveU.getX()+MoveU.getWidth()+25,UltimateAttacksLabel.getY());
	    add(FUltimateAttacksLabel );
	    
	    FUltimateAttacks = new JPanel() ; 
	    FUltimateAttacksList=new JList(FUA);
	    FUltimateAttacksList.setFont(customFont);
	    FUltimateAttacksList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    FUltimateAttacksList.setLayoutOrientation(JList.VERTICAL);
	    FUltimateAttacks.setLayout(null);
	    FUltimateAttacksList.setVisibleRowCount(5);
	    FUltimateAttacksList.setBounds(0,0,269,200);
	    ScrollFUltimate = new JScrollPane(FUltimateAttacksList) ; 
	    ScrollFUltimate.setSize(269,200) ; 
	    ScrollFUltimate.setLocation(0, 0);
	    FUltimateAttacks.add(ScrollFUltimate);
	    FUltimateAttacks.setSize(269,200);
	    FUltimateAttacks.setLocation(MoveU.getX()+MoveU.getWidth()+25,UltimateAttacksLabel.getY()+UltimateAttacksLabel.getHeight()+20);
	    FUltimateAttacks.setOpaque(false);
		  FUltimateAttacksList.setOpaque(false);
		  ScrollFUltimate.setOpaque(false);
		  ScrollFUltimate.getViewport().setOpaque(false);
	    add(FUltimateAttacks);
	    
//	    AttacksInstructions=new JLabel("Highlight four Super Attacks and two Ultimate Attacks to assign them to your fighter");
//	    AttacksInstructions.setFont(customFont4);
//	    AttacksInstructions.setBounds(PSuperAttacks.getX(),PSuperAttacks.getY()+PSuperAttacks.getHeight()+20 , PSuperAttacks.getWidth()+PUltimateAttacks.getWidth()+500, 100);
//	   // add(AttacksInstructions);
//	    
	    System.out.println("Width :" + PSuperAttacks.getWidth() + " Height : " + PUltimateAttacks.getHeight());
	    
	 
	    validate();
		setUndecorated(true);
		setVisible(true);
	}
	public Icon setFighterIconLarge(Fighter x)
	{
		Icon i;
		
		if(x instanceof Saiyan)i=new ImageIcon(getClass().getResource("Sayian_icon.png"));
		else
			if(x instanceof Frieza)i=new ImageIcon(getClass().getResource("Frieza_icon.png"));
			else
				if(x instanceof Majin)i=new ImageIcon(getClass().getResource("Majin_icon.png"));
				else
					if(x instanceof Namekian)i=new ImageIcon(getClass().getResource("Namkian_icon.png"));
					else
						if(x instanceof Earthling)i=new ImageIcon(getClass().getResource("Earthling_icon.png"));
						else
							i=new ImageIcon(getClass().getResource("unknown_icon.png"));
		
		return i;
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
	public JFrame getParent() {
		return parent;
	}
	public void setParent(JFrame parent) {
		this.parent = parent;
	}
	public JButton getBack() {
		return Back;
	}
	public void setBack(JButton back) {
		Back = back;
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
	public JComboBox getFighters() {
		return Fighters;
	}
	public void setFighters(JComboBox fighters) {
		Fighters = fighters;
	}
	public JLabel getFighterOptions() {
		return FighterOptions;
	}
	public void setFighterOptions(JLabel fighterOptions) {
		FighterOptions = fighterOptions;
	}
	public JLabel getFighterIcon() {
		return FighterIcon;
	}
	public void setFighterIcon(JLabel fighterIcon) {
		FighterIcon = fighterIcon;
	}
	public JLabel getLevel() {
		return Level;
	}
	public void setLevel(JLabel level) {
		Level = level;
	}
	public JLabel getMaxHealth() {
		return MaxHealth;
	}
	public void setMaxHealth(JLabel maxHealth) {
		MaxHealth = maxHealth;
	}
	public JLabel getMaxKI() {
		return MaxKI;
	}
	public void setMaxKI(JLabel maxKI) {
		MaxKI = maxKI;
	}
	public JLabel getMaxStamina() {
		return MaxStamina;
	}
	public void setMaxStamina(JLabel maxStamina) {
		MaxStamina = maxStamina;
	}
	public JLabel getPhysicalDamage() {
		return PhysicalDamage;
	}
	public void setPhysicalDamage(JLabel physicalDamage) {
		PhysicalDamage = physicalDamage;
	}
	public JLabel getBlastDamage() {
		return BlastDamage;
	}
	public void setBlastDamage(JLabel blastDamage) {
		BlastDamage = blastDamage;
	}
	public JProgressBar getXpProgressBar() {
		return XpProgressBar;
	}
	public void setXpProgressBar(JProgressBar xpProgressBar) {
		XpProgressBar = xpProgressBar;
	}
	public JLabel getSuperAttacksLabel() {
		return SuperAttacksLabel;
	}
	public void setSuperAttacksLabel(JLabel superAttacksLabel) {
		SuperAttacksLabel = superAttacksLabel;
	}
	public JLabel getUltimateAttacksLabel() {
		return UltimateAttacksLabel;
	}
	public void setUltimateAttacksLabel(JLabel ultimateAttacksLabel) {
		UltimateAttacksLabel = ultimateAttacksLabel;
	}

	
	public JButton getCreateFighter() {
		return CreateFighter;
	}
	public void setCreateFighter(JButton createFighter) {
		CreateFighter = createFighter;
	}
	public JLabel getAttacksInstructions() {
		return AttacksInstructions;
	}
	public void setAttacksInstructions(JLabel attacksInstructions) {
		AttacksInstructions = attacksInstructions;
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
