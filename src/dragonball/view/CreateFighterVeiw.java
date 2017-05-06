 package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dragonball.controller.BackHandler;
import dragonball.controller.Next2Handler;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class CreateFighterVeiw extends GameVeiw implements Serializable {
	private JPanel CreateFighter ; 
	private JTextField FighterName;  
	private JButton Next2 ;
	private JFrame parent ;  
	private JLabel FighterNameText ;   
	private JLabel Create ; 
	private JButton Back ; 
	private JButton Exit ;
	private String PlayerName;
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	private final static int PANELWIDTH = (int) (BUTTONWIDTH*1.5) ; 
	private final static int PANELHEIGHT =  (int) (BUTTONHEIGHT*1.5) ;
	private Font customFont ; 
	private Font customFont2 ; 
	private Font customFont3 ; 
	private ModeVeiw child ; 
	private JButton temp ; 
	private JButton temp1; 
	private JButton temp2 ; 
	private JButton temp3 ; 
	private JButton temp4 ; 
	private JPanel EarthlingPanel ; 
	private JPanel FriezaPanel ; 
	private JPanel MaijinPanel ; 
	private JPanel SayianPanel ; 
	private JPanel NamikianPanel ;
	private JLabel FighterrType ; 
	private String Ftype = "Earthling" ; 
	private Icon i ; 
	private Icon i1 ; 
	private Icon i2 ; 
	private Icon i33 ; 
	private Icon i4 ; 
	private Icon irev;
	private Icon i1rev;
	private Icon i2rev ; 
	private Icon i33rev ; 
	private Icon i4rev ;
	private Font JcustomFont; 

  
	public CreateFighterVeiw( JFrame Parent, String playername, Game game) {
		// TODO Auto-generated constructor stub
	super(game);
		this.parent=Parent ; 
		this.PlayerName = playername ;
	
	//
		 System.setProperty("awt.useSystemAAFontSettings","on");
		 System.setProperty("swing.aatext", "true");
		Icon i3 = new  ImageIcon(getClass().getResource("dragon-ball-kid-goku-wide-wallpaper.jpg")) ;
		JLabel temp22  = new JLabel(i3) ;
		setContentPane(temp22);
Font cFont = new Font("Serif",Font.BOLD,42) ;  
 SuperAttack A = new SuperAttack("sss", 10) ; 
// getGame().getPlayer().getSuperAttacks().add(A) ;
// 
// UltimateAttack A1 = new UltimateAttack("sss", 10) ; 
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
// getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ; getGame().getPlayer().getSuperAttacks().add(A) ;
// getGame().getPlayer().getUltimateAttacks().add(A1) ;
 		
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
		
		Create = new JLabel("Welcome " + PlayerName);
		Create.setFont(customFont2);
		Create.setSize(Create.getPreferredSize());
		Create.setForeground(new Color(204, 0, 51));
		Create.setLocation(getWidth()/2-Create.getWidth()/2 , 50);
	    add(Create) ;
		
	    CreateFighter = new JPanel() ; 
	    CreateFighter.setSize(getWidth()-(2*PANELWIDTH),getHeight()-(Create.getHeight()+PANELHEIGHT+100));
	    CreateFighter.setLocation(PANELWIDTH,Create.getHeight()+100);
	  
	    CreateFighter.setLayout(null);
	    CreateFighter.setBackground(null);
	    CreateFighter.setOpaque(false);
	    
	    FighterNameText = new JLabel("Fighter name :") ;
	    FighterNameText.setFont(customFont3);
	    FighterNameText.setForeground(Color.red);
	    FighterNameText.setSize(FighterNameText.getPreferredSize());
	    FighterNameText.setLocation(40, 100); 
	    CreateFighter.add(FighterNameText) ; 
	    
	    FighterName = new JTextField() ; 
	    FighterName.setFont(cFont);
	    FighterName.setForeground(Color.red); 
	    FighterName.setOpaque(false);
	    FighterName.setSize((CreateFighter.getWidth()-FighterNameText.getWidth())/2,FighterNameText.getHeight());
	    FighterName.setLocation(FighterNameText.getWidth()+15 , FighterNameText.getY()) ; 
	    
	    CreateFighter.add(FighterName);
		
	    EarthlingPanel = new JPanel() ; 
	     i = new ImageIcon(getClass().getResource("Earthling_icon.png"));
	     
	      irev = new  ImageIcon(getClass().getResource("Earthling_icon_selected.png"));
	      temp = new JButton(irev) ;
	    EarthlingPanel.add(temp);
	    EarthlingPanel.setSize(200,400) ; 
	    EarthlingPanel.setLocation(50,FighterName.getY()+FighterName.getHeight()+50);
	    EarthlingPanel.setOpaque(false);
	    
	    temp.setBackground(null); 
	    temp.setFocusable(false);
	    temp.setOpaque(false);
	    temp.setContentAreaFilled(false);
	    temp.setBorderPainted(false);
	    temp.addActionListener(new ImageListener());
 	    EarthlingPanel.setBackground(null);
	    CreateFighter.add(EarthlingPanel) ;
	   
	    
	    
	    FriezaPanel = new JPanel() ; 
	      i1 = new ImageIcon(getClass().getResource("Frieza_icon.png"));
	      i1rev = new  ImageIcon(getClass().getResource("Frieza_icon_selected.png"));
	     temp1 = new JButton(i1) ;
	    temp1.addActionListener(new ImageListener());
	     FriezaPanel.add(temp1);
	     temp1.setFocusable(false);
	        temp1.setFocusable(false);
		    temp1.setOpaque(false);
		    temp1.setContentAreaFilled(false);
		    temp1.setBorderPainted(false);
	     FriezaPanel.setSize(200,400) ; 
	     FriezaPanel.setOpaque(false);
	     FriezaPanel.setLocation(15+EarthlingPanel.getX()+EarthlingPanel.getWidth(),FighterName.getY()+FighterName.getHeight()+50);
	     temp1.setBackground(null);
	     FriezaPanel.setBackground(null);
	    CreateFighter.add(FriezaPanel) ;
	    
	   
	    
	    
	    MaijinPanel = new JPanel() ; 
	        i2 = new ImageIcon(getClass().getResource("Majin_icon.png"));
	        i2rev = new  ImageIcon(getClass().getResource("Majin_icon_selected.png"));
	      temp2 = new JButton(i2) ;
	        temp2.setFocusable(false);
		    temp2.setOpaque(false);
		    temp2.setContentAreaFilled(false);
		    temp2.setBorderPainted(false);
	      temp2.addActionListener(new ImageListener());
	     temp2.setFocusable(false);
	     MaijinPanel.add(temp2);
	     MaijinPanel.setSize(200,400) ; 
	     MaijinPanel.setOpaque(false);
	     MaijinPanel.setLocation(15+FriezaPanel.getX()+FriezaPanel.getWidth() ,FighterName.getY()+FighterName.getHeight()+50);
	     temp2.setBackground(null);
	     MaijinPanel.setBackground(null);
	    CreateFighter.add(MaijinPanel) ;
	    
	   
	    
	    NamikianPanel = new JPanel() ; 
	      i33 = new ImageIcon(getClass().getResource("Namkian_icon.png"));
	      i33rev = new  ImageIcon(getClass().getResource("Namkian_icon_selected.png"));
	      temp3 = new JButton(i33) ;
	     temp3.setBackground(null);
	     temp3.addActionListener(new ImageListener());
	     temp3.setFocusable(false);
	        temp3.setFocusable(false);
		    temp3.setOpaque(false);
		    temp3.setContentAreaFilled(false);
		    temp3.setBorderPainted(false);
		    
	     NamikianPanel.add(temp3);
	     NamikianPanel.setOpaque(false);
	     NamikianPanel.setSize(200,400) ; 
	     NamikianPanel.setLocation(15+MaijinPanel.getX()+MaijinPanel.getWidth(),FighterName.getY()+FighterName.getHeight()+50);
	   
	     NamikianPanel.setBackground(null);
	    CreateFighter.add(NamikianPanel) ;
	    
	   
	    
	    SayianPanel = new JPanel() ; 
	     i4 = new ImageIcon(getClass().getResource("Sayian_icon.png"));
	     i4rev = new  ImageIcon(getClass().getResource("Sayian_icon_selected.png"));
	      temp4 = new JButton(i4) ;
	     temp4.setBackground(null);
	     temp4.setFocusable(false);
	        temp4.setFocusable(false);
		    temp4.setOpaque(false);
		    temp4.setContentAreaFilled(false);
		    temp4.setBorderPainted(false);
	     temp4.addActionListener(new ImageListener());
	     SayianPanel.add(temp4);
	     SayianPanel.setSize(200,400) ; 
	     SayianPanel.setOpaque(false);
	     SayianPanel.setLocation(15+NamikianPanel.getX()+NamikianPanel.getWidth(),FighterName.getY()+FighterName.getHeight()+50);
	 
	     SayianPanel.setBackground(null);
	    CreateFighter.add(SayianPanel) ;
	    
	   
	    
	    Icon NextIcon = new ImageIcon(getClass().getResource("NextRed.png"));
	    Icon rev = new ImageIcon(getClass().getResource("Nextblue.png"));
	    Next2 = new JButton(NextIcon) ; 
	    Next2.setRolloverIcon(rev);
	    Next2.setOpaque(false);
	    Next2.setContentAreaFilled(false);
	    Next2.setBorderPainted(false);
	    Next2.setFocusable(false );
	    Next2.setFont(customFont);  
	    Next2.setSize(BUTTONWIDTH,BUTTONHEIGHT);
	    Next2.setLocation(CreateFighter.getWidth()-BUTTONWIDTH,CreateFighter.getHeight()-BUTTONHEIGHT);
	    FighterName.addKeyListener(new KeyListener() {
			
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
				 Next2.doClick();
				}
			}
		});

		
		
		CreateFighter.add(Next2) ; 
		
		FighterrType = new JLabel(Ftype) ; 
		FighterrType.setFont(customFont2);
		FighterrType.setForeground(Color.red); 
		FighterrType.setSize(FighterrType.getPreferredSize()) ; 
		FighterrType.setLocation((CreateFighter.getWidth()/2)- (FighterrType.getWidth()/2), CreateFighter.getHeight()- FighterrType.getHeight()*2);
		FighterrType.setVisible(true);
		CreateFighter.add(FighterrType) ; 
	    Next2.addActionListener(new Next2Handler(  this,child, FighterName,super.getGame(),FighterrType));
		add(CreateFighter);
		
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
		CreateFighter.validate();
		Create.validate();
		validate();
		
	}

	public JPanel getCreateFighter() {
		return CreateFighter;
	}

	public void setCreateFighter(JPanel createFighter) {
		CreateFighter = createFighter;
	}

	public JTextField getFighterName() {
		return FighterName;
	}

	public void setFighterName(JTextField fighterName) {
		FighterName = fighterName;
	}

	public JButton getNext2() {
		return Next2;
	}

	public void setNext2(JButton next2) {
		Next2 = next2;
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	public JLabel getFighterNameText() {
		return FighterNameText;
	}

	public void setFighterNameText(JLabel fighterNameText) {
		FighterNameText = fighterNameText;
	}

	public JLabel getCreate() {
		return Create;
	}

	public void setCreate(JLabel create) {
		Create = create;
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

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
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



	public ModeVeiw getChild() {
		return child;
	}

	public void setChild(ModeVeiw child) {
		this.child = child;
	}



	public JPanel getEarthlingPanel() {
		return EarthlingPanel;
	}

	public void setEarthlingPanel(JPanel earthlingPanel) {
		EarthlingPanel = earthlingPanel;
	}

	public JPanel getFriezaPanel() {
		return FriezaPanel;
	}

	public void setFriezaPanel(JPanel friezaPanel) {
		FriezaPanel = friezaPanel;
	}

	public JPanel getMaijinPanel() {
		return MaijinPanel;
	}

	public void setMaijinPanel(JPanel maijinPanel) {
		MaijinPanel = maijinPanel;
	}

	public JPanel getSayianPanel() {
		return SayianPanel;
	}

	public void setSayianPanel(JPanel sayianPanel) {
		SayianPanel = sayianPanel;
	}

	public JPanel getNamikianPanel() {
		return NamikianPanel;
	}

	public void setNamikianPanel(JPanel namikianPanel) {
		NamikianPanel = namikianPanel;
	}

	
public JLabel getFighterrType() {
		return FighterrType;
	}

	public void setFighterrType(JLabel fighterrType) {
		FighterrType = fighterrType;
	}


public String getFtype() {
		return Ftype;
	}

	public void setFtype(String ftype) {
		Ftype = ftype;
	}


public class ImageListener implements ActionListener  {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==temp) { 
			FighterrType.setText(Ftype="Earthling");
			temp.setIcon(irev);
			temp1.setIcon(i1);
			temp2.setIcon(i2);
			temp3.setIcon(i33);
			temp4.setIcon(i4);
		
		}
		else 
			if (e.getSource()== temp1 ){
				FighterrType.setText(Ftype="Frieza"); 
				temp.setIcon(i);
				temp1.setIcon(i1rev);
				temp2.setIcon(i2);
				temp3.setIcon(i33);
				temp4.setIcon(i4);
			}
			else if (e.getSource()==temp2) {
				FighterrType.setText(Ftype="Majin");
				temp.setIcon(i);
				temp1.setIcon(i1);
				temp2.setIcon(i2rev);
				temp3.setIcon(i33);
				temp4.setIcon(i4);
			}
			else if (e.getSource()==temp3) {
				FighterrType.setText(Ftype="Namekian");
				temp.setIcon(i);
				temp1.setIcon(i1);
				temp2.setIcon(i2);
				temp3.setIcon(i33rev);
				temp4.setIcon(i4);
			}
			else if (e.getSource()==temp4){
				FighterrType.setText(Ftype="Saiyan");
				temp.setIcon(i);
				temp1.setIcon(i1);
				temp2.setIcon(i2);
				temp3.setIcon(i33);
				temp4.setIcon(i4rev);
			}
		
	}
	
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
