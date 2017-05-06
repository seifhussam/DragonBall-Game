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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.controller.TournamentBackHandler;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.Tournament;
import dragonball.model.tournament.TournamentMatch;
import dragonball.model.tournament.TournamentStatus;

public class TournamentView extends GameVeiw implements Serializable {
private SelectFighterView parent ; 
private Game game ; 
private Tournament tournament ; 
private ArrayList<PlayableFighter> myFighters ; 
private JLabel Title  ; 
private JLabel Player1 ; 
private JLabel player2 ; 
private JButton Exit ; 
private JButton Back ; 
private final static int BUTTONWIDTH = 250 ; 
private final static int BUTTONHEIGHT= 100  ;
private Font CcustomFont ; 
private Font customFont ; 
private Font customFont1; 
private JPanel Stage16 ; 
private JPanel Stage8 ; 
private JPanel Stage4 ; 
private JPanel Stage2 ; 
private JPanel Stage1 ;
private Font JcustomFont;
private JButton RestartTournament ; 
private BattleMeVsMe child ;
private BattleMevsFoe child2;
private JLabel StageTitle;
private JLabel StageNumber;

	public TournamentView(SelectFighterView parent, Game game,
			ArrayList<PlayableFighter> myFighters) {
		// TODO Auto-generated constructor stub
		super(game) ; 
		this.parent = parent ; 
		this.myFighters = myFighters ; 
		Icon i3 = new  ImageIcon(getClass().getResource("593476.jpg")) ;
		JLabel temp22  = new JLabel(i3) ;
		setContentPane(temp22);
		tournament = new Tournament(game , game.getTournamentfoes(), myFighters) ;
		
		
		this.game = game ; 
		setGame(game);
		this.game.setListener(this);
		getGame().setListener(this); 
		game.setListener(this);
		
 		this.game.setTournament(tournament);
		tournament.generateTournamentStage(16);
		
		Font customFont5= new Font("Serif",Font.PLAIN,14);
		try {
		    //create the font to use. Specify the size!
			customFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(40f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font1
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		 customFont= new Font("Serif",Font.PLAIN,14);
			try {
			    //create the font to use. Specify the size!
			   customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(62f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
			} catch (IOException e) {
			    e.printStackTrace();
			} catch(FontFormatException e) {
			    e.printStackTrace();
			}
			 customFont1= new Font("Serif",Font.PLAIN,14);
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
			
			  CcustomFont= new Font("Serif",Font.PLAIN,14);
				try {
				    //create the font to use. Specify the size!
					CcustomFont = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(40f);
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
		    
			Title = new JLabel("Tournament Mode") ; 
			Title.setFont(customFont1);
			Title.setForeground(new Color(204, 0, 51)); 
			Title.setSize(Title.getPreferredSize());
			Title.setLocation((getWidth()-Title.getWidth())/2, 20);
			add(Title);
		StageTitle = new JLabel("Stage ") ; 
		
		StageTitle.setFont(CcustomFont);
		StageTitle.setForeground(Color.blue); 
		StageTitle.setSize(StageTitle.getPreferredSize());
		StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
		add(StageTitle);
		
		StageNumber = new JLabel("32") ; 
		
		StageNumber.setFont(customFont5);
		StageNumber.setForeground(Color.blue); 
		StageNumber.setSize(StageNumber.getPreferredSize());
		StageNumber.setLocation(StageTitle.getX()+StageTitle.getWidth(), Title.getHeight()+40);
		add(StageNumber);
		
			Stage16 = new JPanel() ; 
			
			Stage16.setOpaque(false);
	        Stage16.setLayout(new GridLayout(4, 4));
	        
			for (int i = 0 ; i < tournament.getTournamentMatch().length;i++) {
				MatchLayout temp = new MatchLayout(tournament.getTournamentMatch()[i], (Fighter)tournament.getTournamentMatch()[i].getPlayer1(),  (Fighter)tournament.getTournamentMatch()[i].getPlayer2());
				temp.setSize(  getWidth()/4 , getHeight()/4);
				temp.setOpaque(false);
		    Stage16.add(temp) ; 
			}
			Stage16.setSize(Stage16.getPreferredSize());
			
			Stage16.setLocation(getWidth()/2 - Stage16.getWidth()/2 ,getHeight()/2 -Stage16.getHeight()/2+50); 
			add(Stage16) ; 
			
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
			RestartTournament = new JButton ("Restart") ; 
			
			RestartTournament.setContentAreaFilled(false);
			RestartTournament.setBorderPainted(false);
			RestartTournament.setFocusable(false);
			RestartTournament.setSize(BUTTONWIDTH,BUTTONHEIGHT);          
			RestartTournament.setFont(customFont);
			RestartTournament.setLocation(getWidth()/2- RestartTournament.getWidth()/2, this.getHeight()-BUTTONHEIGHT);
			add(RestartTournament) ;
			RestartTournament.setForeground(Color.red);
			RestartTournament.setVisible(false);
			System.out.println(RestartTournament.getLocation());
			RestartTournament.addMouseListener(new MouseListener() {
				
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
					RestartTournament.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					RestartTournament.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			RestartTournament.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					TournamentView t =new TournamentView(parent, game, myFighters) ; 
	 				t.setVisible(true); 
	 				  Runnable r = new Runnable() {
	 					   public void run() {
	 					    try {
	 							Thread.sleep(1000);
	 						} catch (InterruptedException e) {
	 							// TODO Auto-generated catch block
	 							e.printStackTrace();
	 						}
	 					    // your Code ... 
	 					    setVisible(false);
	 					   }
	 					 };
	 				Thread t1 = new Thread(r) ;
	 				t1.start();
				}
			});
			
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
		        
		        Back.addActionListener(new TournamentBackHandler(parent, this));
		        add(Back);
		       
			this.validate();
		
	}
	@Override
	public void onTournamentMatchEvent(BattleEvent e, MatchStatus matchStatus) {
		// TODO Auto-generated method stub

		if(e.getType()== BattleEventType.STARTED){
			if (((Battle) e.getSource()).getMe() instanceof PlayableFighter && ((Battle) e.getSource()).getFoe() instanceof PlayableFighter  ) {
				System.out.println("OnTournament Match Event ");
			child=new BattleMeVsMe(getGame(), (Battle) e.getSource(), this) ; 
			child.setVisible(true);
			 Runnable r = new Runnable() {
				   public void run() {
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
			else if (((Battle) e.getSource()).getMe() instanceof PlayableFighter ^ ((Battle) e.getSource()).getFoe() instanceof PlayableFighter ){
				child2=new BattleMevsFoe(getGame(), (Battle) e.getSource(), this) ; 
				child2.setVisible(true);
				 Runnable r = new Runnable() {
					   public void run() {
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
		}
		
	}
	
	public JPanel getStage16() {
		return Stage16;
	}
	public void setStage16(JPanel stage16) {
		Stage16 = stage16;
	}
	public JPanel getStage8() {
		return Stage8;
	}
	public void setStage8(JPanel stage8) {
		Stage8 = stage8;
	}
	public JPanel getStage4() {
		return Stage4;
	}
	public void setStage4(JPanel stage4) {
		Stage4 = stage4;
	}
	public JPanel getStage2() {
		return Stage2;
	}
	public void setStage2(JPanel stage2) {
		Stage2 = stage2;
	}
	public JPanel getStage1() {
		return Stage1;
	}
	public void setStage1(JPanel stage1) {
		Stage1 = stage1;
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
		if (status == TournamentStatus.ENDED) {
           StageTitle.setText("Tournament Winner is  " + ((Fighter) tournament.getTournamentMatch()[0].getWinner()).getName() );
			
			
			StageTitle.setSize(StageTitle.getPreferredSize());
			StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
			RestartTournament.setVisible(true); 
			validate() ;
		}
		
	}

	

	@Override
	public void onStageComplete(int stage) {
		// TODO Auto-generated method stub
		int x = 0 ; 
		if (stage == 8 ) {
			StageTitle.setText("Stage ");
			
		
			StageTitle.setSize(StageTitle.getPreferredSize());
			StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
		
			StageNumber.setText(""+16);
			
		
			StageNumber.setForeground(new Color(204, 0, 51)); 
			StageNumber.setSize(StageNumber.getPreferredSize());
			StageNumber.setLocation(StageTitle.getX()+StageTitle.getWidth(), Title.getHeight()+40);
			
		Stage8 = new JPanel() ; 		
		Stage8.setLayout(new GridLayout(2, 4));
		        
				for (int i = 0 ; i < tournament.getTournamentMatch().length;i++) {
					MatchLayout temp = new MatchLayout(tournament.getTournamentMatch()[i], (Fighter)tournament.getTournamentMatch()[i].getPlayer1(),  (Fighter)tournament.getTournamentMatch()[i].getPlayer2());
					temp.setSize(  getWidth()/4 , getHeight()/4);
					temp.setOpaque(false);
			    Stage8.add(temp) ; 
				}
				Stage8.setSize(Stage8.getPreferredSize());
				Stage8.setOpaque(false);
				Stage8.setLocation(getWidth()/2 - Stage8.getWidth()/2 ,getHeight()/2 -Stage8.getHeight()/4 ); 
				add(Stage8) ; 
				Stage16.setVisible(false );
		}
		else if (stage == 4 ) { 
			StageTitle.setText("Stage ");
			
			
			StageTitle.setSize(StageTitle.getPreferredSize());
			StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
		
			StageNumber.setText(""+8);
			
		
			StageNumber.setForeground(new Color(204, 0, 51)); 
			StageNumber.setSize(StageNumber.getPreferredSize());
			StageNumber.setLocation(StageTitle.getX()+StageTitle.getWidth(), Title.getHeight()+40);
			Stage4 = new JPanel() ; 
			Stage4.setOpaque(false);
			Stage4.setLayout(new GridLayout(2, 2));
			        
					for (int i = 0 ; i < tournament.getTournamentMatch().length;i++) {
						MatchLayout temp = new MatchLayout(tournament.getTournamentMatch()[i], (Fighter)tournament.getTournamentMatch()[i].getPlayer1(),  (Fighter)tournament.getTournamentMatch()[i].getPlayer2());
						temp.setSize(  getWidth()/2 , getHeight()/2);
						temp.setOpaque(false);
						Stage4.add(temp) ; 
					}
					Stage4.setSize(Stage4.getPreferredSize());
					
					Stage4.setLocation(getWidth()/2 - Stage4.getWidth()/2 ,getHeight()/2 -Stage4.getHeight()/2 ); 
					add(Stage4) ; 
					Stage8.setVisible(false );
		}
		else if (stage == 2 ) { 
			StageTitle.setText("Semi Finals ");
			
			
			StageTitle.setSize(StageTitle.getPreferredSize());
			StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
		
			StageNumber.setText("");
			
		
			StageNumber.setForeground(new Color(204, 0, 51)); 
			StageNumber.setSize(StageNumber.getPreferredSize());
			StageNumber.setLocation(StageTitle.getX()+StageTitle.getWidth(), Title.getHeight()+40);
			Stage2 = new JPanel() ; 
			Stage2.setOpaque(false); 
			Stage2.setLayout(new GridLayout(0, 2));
			        
					for (int i = 0 ; i < tournament.getTournamentMatch().length;i++) {
						MatchLayout temp = new MatchLayout(tournament.getTournamentMatch()[i], (Fighter)tournament.getTournamentMatch()[i].getPlayer1(),  (Fighter)tournament.getTournamentMatch()[i].getPlayer2());
						temp.setSize(  getWidth()/2, getHeight()/2);
						temp.setOpaque(false);
						Stage2.add(temp) ; 
					}
					Stage2.setSize(Stage2.getPreferredSize());
					
					Stage2.setLocation(getWidth()/2 - Stage2.getWidth()/2 ,getHeight()/2 -Stage2.getHeight()/2 ); 
					add(Stage2) ; 
					x++ ; 
					Stage4.setVisible(false );
		}
		else if (stage == 1 ) {
          StageTitle.setText("Finals ");
			
			
			StageTitle.setSize(StageTitle.getPreferredSize());
			StageTitle.setLocation((getWidth()-StageTitle.getWidth())/2, Title.getHeight()+40);
			Stage1 = new JPanel() ; 
			Stage1.setOpaque(false );
			Stage1.setLayout(new GridLayout(0, 1));
			        System.out.println(tournament.getTournamentMatch().length);
					for (int i = 0 ; i < tournament.getTournamentMatch().length;i++) {
						MatchLayout temp = new MatchLayout(tournament.getTournamentMatch()[i], (Fighter)tournament.getTournamentMatch()[i].getPlayer1(),  (Fighter)tournament.getTournamentMatch()[i].getPlayer2());
						temp.setSize(  getWidth()/2, getHeight()/2);
						temp.setOpaque(false);
						Stage1.add(temp) ; 
					}
					Stage1.setSize(Stage1.getPreferredSize());
					System.out.println(Stage1.getSize());
					Stage1.setLocation(getWidth()/2 - Stage1.getWidth()/2 ,getHeight()/2 -Stage1.getHeight()/2 ); 
					add(Stage1) ; 
					x++ ; 
					Stage2.setVisible(false );
		}
	
	}
	public class MatchLayout extends JPanel {
		private final static int PanelWidth = 120 ; 
		private final static int  PanelHeight = 215 ; 
		private JLabel Player1 ; 
		private JLabel Player2 ; 
		private JLabel Versus ;
		private JButton Sim ; 
		private JButton Play ; 
		private Fighter p1 ; 
		private Fighter p2 ; 
		private JLabel  matchStatus; 
		private TournamentMatch match ; 
		
		public JLabel getPlayer1() {
			return Player1;
		}

		public void setPlayer1(JLabel player1) {
			Player1 = player1;
		}

		public JLabel getPlayer2() {
			return Player2;
		}

		public void setPlayer2(JLabel player2) {
			Player2 = player2;
		}

		public Fighter getP1() {
			return p1;
		}

		public void setP1(Fighter p1) {
			this.p1 = p1;
		}

		public Fighter getP2() {
			return p2;
		}

		public void setP2(Fighter p2) {
			this.p2 = p2;
		}

		public JLabel getMatchStatus() {
			return matchStatus;
		}

		public void setMatchStatus(JLabel matchStatus) {
			this.matchStatus = matchStatus;
		}

		public TournamentMatch getMatch() {
			return match;
		}

		public void setMatch(TournamentMatch match) {
			this.match = match;
		}

		public MatchLayout (TournamentMatch match , Fighter p1 , Fighter p2) { 
			this.p1 = p1 ; 
			this.p2 = p2 ; 
			this.match = match ;
			this.match.setListener(getGame().getTournament());
	        setLayout(new GridLayout(4,0));
			Player1 = new JLabel(" "+p1.getName().split(" ")[0]) ;  
			Player1.setBounds(0,0,215,30);
			Player1.setFont(CcustomFont) ; 
			
			 
			Versus = new JLabel(" VS ") ; 
			 
			
			Versus.setFont(CcustomFont) ; 
			
			
			
			Player2 = new JLabel(" "+p2.getName().split(" ")[0]) ; 
			
		
			Player2.setFont(CcustomFont) ; 
			
			
			
			String text = " Pending" ; 
			
			add(Player2) ; 
			add(Versus) ; 
			add(Player1) ;
			if (p1 instanceof PlayableFighter || p2 instanceof PlayableFighter) {
				JPanel j = new JPanel() ; 
				j.setLayout(new GridLayout(0,3)); 
	
			matchStatus = new JLabel(text) ; 
			
			matchStatus.setFont(CcustomFont) ;  
			
			
			Play = new JButton(" Play");
			
			Play.setFont(CcustomFont) ;   
			Play.setBackground(null); 
			Play.setFocusable(false);
			Play.setOpaque(false);
			Play.setForeground(Color.blue);
             Play.addMouseListener(new MouseListener() {
				
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
        Play.setForeground(Color.blue);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				
					Play.setForeground(Color.darkGray);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			Play.setContentAreaFilled(false);
			Play.setBorderPainted(false);
			Play.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(match.getMatchStatus() != MatchStatus.ENDED){
					getMatch().startMatch();
					
					
					}
						
				}
			});
            j.add(Play) ;
            j.add(matchStatus) ; 
          
            	
            
			Sim = new JButton(" SIM");
			
			
			Sim.setFont(CcustomFont) ;   
			Sim.setBackground(null); 
			Sim.setFocusable(false);
			Sim.setOpaque(false);
			Sim.setContentAreaFilled(false);
			Sim.setBorderPainted(false);
			Sim.addMouseListener(new MouseListener() {
				
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
					Sim.setForeground(Color.darkGray);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					Sim.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			Sim.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(match.getMatchStatus() != MatchStatus.ENDED) {
				match.simMatch(); 
				
				if (p1==match.getWinner()) { 
					Player1.setForeground(Color.GREEN);
					Player2.setForeground(Color.red); 
				}else  { 
					Player2.setForeground(Color.green);
					Player1.setForeground(Color.red); 
				}
		
				matchStatus.setText(" Ended");
				}
				}
			});
			j.add(Sim) ;  
			j.setBackground(Color.red);
			    add(j) ; 
			}else {
				JPanel j = new JPanel() ; 
				j.setLayout(new GridLayout(0,2)); 
				matchStatus = new JLabel(text) ; 
				
				matchStatus.setFont(CcustomFont) ; 
				j.add(matchStatus) ;
				Sim = new JButton(" SIM");
				
				Sim.setFont(CcustomFont) ;   
				Sim.setBackground(null); 
				Sim.setFocusable(false);
				Sim.setOpaque(false);
				Sim.setContentAreaFilled(false);
				Sim.setBorderPainted(false); 
				Sim.addMouseListener(new MouseListener() {
					
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
						Sim.setForeground(Color.DARK_GRAY);
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						Sim.setForeground(Color.blue);
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				Sim.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(match.getMatchStatus() != MatchStatus.ENDED) {
							match.simMatch(); 
							
							if (p1==match.getWinner()) { 
								Player1.setForeground(Color.GREEN);
								Player2.setForeground(Color.red); 
							}else { 
								Player2.setForeground(Color.green);
								Player1.setForeground(Color.red); 
							}
					
							matchStatus.setText(" Ended");
							}
							}
					
						
						
				});
				j.add(Sim) ; 
				j.setBackground(Color.red);
				add(j) ; 
			
			}
			
			 
			
			
		}

		
		
		
		
		
		
		
		
	}
	
}
