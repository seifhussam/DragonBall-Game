package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.controller.DragonViewHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class DragonView extends GameVeiw implements Serializable  {
	
	private JLabel Dragon ; 
	
	private Game game ;
	private static final long serialVersionUID = 1L;
	private MouseListener hover1;
	private MouseListener hover2;
	private MouseListener hover3;
	private MouseListener hover4;
	Font customFont;
	private JLabel  Message;
	private JButton SenzuBeans ; 
	private JButton AbilityPoints ; 
	private JButton SuperAttack ; 
	private JButton UltimateAttack ;
	private JLabel Welcome;
	private WorldVeiw parent ; 
	private GameVeiw gameView ; 
	private Dragon dragon;
	
	
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;
	
	//public DragonView(GameVeiw gameView ,WorldVeiw  parent){
	public DragonView(WorldVeiw parent , Game game, Dragon dragon ){
		super(game);
		this.game = game ; 
		this.dragon = dragon ; 
		this.parent = parent ; 
	System.out.println("Created");
		customFont= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
		   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(50f);
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
		 
		
		Welcome = new JLabel("Please Select a Wish");
		Welcome.setSize(2000,50);
		Welcome.setBorder(null);
		Welcome.setFont(customFont);
		Welcome.setLocation(660,50);
		Welcome.setForeground(Color.blue);
		
		SenzuBeans = new JButton("Senzu Beans"); 
		SenzuBeans.setFont(customFont);
		SenzuBeans.setSize(SenzuBeans.getPreferredSize());
		SenzuBeans.setContentAreaFilled(false);
		SenzuBeans.setBorderPainted(false);
		SenzuBeans.setFocusable(false);
		SenzuBeans.setForeground(Color.red) ; 
		
		 
		AbilityPoints = new JButton("Ability Points"); 
		AbilityPoints.setFont(customFont);
		AbilityPoints.setSize(AbilityPoints.getPreferredSize());
		AbilityPoints.setForeground(Color.red) ; 
		AbilityPoints.setContentAreaFilled(false);
		AbilityPoints.setBorderPainted(false);
		AbilityPoints.setFocusable(false);
		
		SuperAttack = new JButton("New Random Super Attack"); 
		SuperAttack.setFont(customFont);
		SuperAttack.setSize(SuperAttack.getPreferredSize());
		SuperAttack.setContentAreaFilled(false);
		SuperAttack.setBorderPainted(false);
		SuperAttack.setFocusable(false);
		SuperAttack.setForeground(Color.red) ; 
		
		
		UltimateAttack = new JButton("New Random Ultimate Attack"); 
		UltimateAttack.setFont(customFont);
		UltimateAttack.setSize(UltimateAttack.getPreferredSize());
		UltimateAttack.setContentAreaFilled(false);
		UltimateAttack.setBorderPainted(false);
		UltimateAttack.setFocusable(false);
		UltimateAttack.setForeground(Color.red) ; 
		
		//Defining Action Listener
		AbilityPoints.addActionListener(new colorbutton());
		SenzuBeans.addActionListener(new colorbutton());
		UltimateAttack.addActionListener(new colorbutton()); 
		SuperAttack.addActionListener(new colorbutton()); 
	
		
		AbilityPoints.addActionListener(new DragonViewHandler(getGame(),dragon,AbilityPoints,parent ,this));
		SenzuBeans.addActionListener(new DragonViewHandler(getGame(),dragon,SenzuBeans,parent,this));
		SuperAttack.addActionListener(new DragonViewHandler(getGame(),dragon,SuperAttack,parent,this));
		UltimateAttack.addActionListener(new DragonViewHandler(getGame(),dragon,UltimateAttack,parent,this));
		hover1 = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	UltimateAttack.setForeground(Color.green);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	UltimateAttack.setForeground(Color.red);
		    }
		};
		
		
		hover2 = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	SuperAttack.setForeground(Color.green);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	SuperAttack.setForeground(Color.red);
		    }
		};
		
		
		hover3 = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	SenzuBeans.setForeground(Color.green);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	SenzuBeans.setForeground(Color.red);
		    }
		};
		
		
		hover4 = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	AbilityPoints.setForeground(Color.green);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	AbilityPoints.setForeground(Color.red);
		    }
		};
		
		
		UltimateAttack.addMouseListener(hover1);
		SuperAttack.addMouseListener(hover2);
		SenzuBeans.addMouseListener(hover3);
		AbilityPoints.addMouseListener(hover4);

		
	Icon d = new  ImageIcon(getClass().getResource("DragonWide.gif")) ;		Dragon = new JLabel(d);
	setContentPane(Dragon);
		
		SuperAttack.setLocation(720,650);
		UltimateAttack.setLocation(1300,700);
		AbilityPoints.setLocation(400,600);
		SenzuBeans.setLocation(100,550);
		
		add(Welcome);
		add(SenzuBeans);
		add(AbilityPoints);
		add(SuperAttack);
		add(UltimateAttack);	
		
		
		 validate();

	}
	
 public class colorbutton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == AbilityPoints) {
			AbilityPoints.setForeground(Color.green);
			SenzuBeans.setForeground(Color.red);
			SuperAttack.setForeground(Color.red);
			UltimateAttack.setForeground(Color.red);
			AbilityPoints.removeMouseListener(hover4);
			ShowMessage(1);
		}else if (arg0.getSource() == SenzuBeans) {
			SenzuBeans.setForeground(Color.green);
			AbilityPoints.setForeground(Color.red);
			SuperAttack.setForeground(Color.red);
			UltimateAttack.setForeground(Color.red);
			SenzuBeans.removeMouseListener(hover3);
			ShowMessage(2);
		}else if (arg0.getSource() == SuperAttack) {
			AbilityPoints.setForeground(Color.red);
			SenzuBeans.setForeground(Color.red);
			SuperAttack.setForeground(Color.green);
			UltimateAttack.setForeground(Color.red);
			SuperAttack.removeMouseListener(hover2);
			ShowMessage(3);
		}else if (arg0.getSource() == UltimateAttack) {
			AbilityPoints.setForeground(Color.red);
			SenzuBeans.setForeground(Color.red);
			SuperAttack.setForeground(Color.red);
			UltimateAttack.setForeground(Color.green);
			UltimateAttack.removeMouseListener(hover1);
			ShowMessage(4);
		}
		
	
			
			
     
		
	}

	private void ShowMessage(int n) {
		switch(n){
		case 1:
			Message = new JLabel(dragon.getName()+" HAS GRANTED YOU ABILITY POINTS");
			
			SenzuBeans.setVisible(false);
			SuperAttack.setVisible(false);
			UltimateAttack.setVisible(false);
			break;
		case 2: 
			Message = new JLabel(dragon.getName()+" HAS GRANTED YOU SENZU BEANS");
			
			AbilityPoints.setVisible(false);
			SuperAttack.setVisible(false);
			UltimateAttack.setVisible(false);
			break;
		case 3: 
			Message = new JLabel(dragon.getName()+" HAS GRANTED YOU A NEW RANDOM SUPER ATTACK");
			
			AbilityPoints.setVisible(false);
			SenzuBeans.setVisible(false);
			UltimateAttack.setVisible(false);
			break;
		case 4: 
			Message = new JLabel(dragon.getName()+" HAS GRANTED YOU A NEW RANDOM ULTIMATE ATTACK");
			
			AbilityPoints.setVisible(false);
			SuperAttack.setVisible(false);
			SenzuBeans.setVisible(false);
			break;
		}
				
		customFont.deriveFont(65f);
		Message.setSize(1200,80);
		Message.setFont(customFont);
		Message.setForeground(Color.cyan);
		Message.setBorder(null);
		//System.out.println(Message.getPreferredSize());
		add(Message);
		Message.setLocation(450,800);
		validate();	
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

