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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import dragonball.controller.BackHandler;
import dragonball.controller.CreateFighterInTournamentHandler;
import dragonball.controller.StartTournamentHandler;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class SelectFighterView extends GameVeiw implements Serializable  {
	private JButton StartTournament ; 
	private JButton Back ; 
	private JButton Exit ; 
	private Font customFont ; 
	private final static int BUTTONWIDTH = 250 ; 
	private final static int BUTTONHEIGHT= 100  ;

	private JLabel SelectText ; 
	private JFrame parent ;
	private ArrayList<PlayableFighter> selectedFighters ; 
	private ArrayList<PlayableFighter> AllFighters ; 
	private Fighter fighters [] ; 
	private JPanel Left  ; 
	private JPanel Right ; 
	private JList  leftlist ; 
	private JList  rightlist ; 
	private JButton Select  ;
	private JButton ClearLeft ; 
	private JButton ClearRight ;
    private TournamentView child ; 
    private JButton CreateFighter ; 
    private AddAnotherFighter child2 ; 
    private PlayableFighter [] selectedArray ;
	private Font JcustomFont; 
    

	public SelectFighterView(JFrame parent, Game game) {
		super(game);
		this.parent = parent;
		// TODO Auto-generated constructor stub
		AllFighters = getGame().getPlayer().getFighters() ; 
		fighters = new Fighter [AllFighters.size()] ; 
		for (int i = 0; i < fighters.length; i++) {
			fighters[i] = AllFighters.get(i) ; 
		}
		Icon i3 = new  ImageIcon(getClass().getResource("686152.jpg")) ;
		JLabel temp22  = new JLabel(i3) ;
		setContentPane(temp22);
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
			   customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(72f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
			} catch (IOException e) {
			    e.printStackTrace();
			} catch(FontFormatException e) {
			    e.printStackTrace();
			}
			Font cFont = new Font("Serif",Font.BOLD,42) ;  
			  
			
			try {
			    //create the font to use. Specify the size!
			   cFont = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(50f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")));
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
			Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		    setSize(DimMax);
			setUndecorated(true);
			

			SelectText = new JLabel("Fighters Selection") ; 
			SelectText.setFont(CcustomFont);
			SelectText.setForeground(Color.red); 
			SelectText.setSize(SelectText.getPreferredSize());
			SelectText.setLocation(getWidth()/2-SelectText.getWidth()/2, 100);
			add(SelectText);
			
			JLabel info  = new JLabel("  Hint : To select multiple fighters hold Ctrl ") ; 
			info.setFont(customFont);
			info.setForeground(new Color(204, 0, 51)); 
			info.setSize(info.getPreferredSize());
			info.setLocation(0,getHeight()-150);
			add(info);
			
			Left = new JPanel() ; 
			Left.setBorder(null);
			Left.setBackground(null);
			
			 leftlist = new JList(fighters) ; 
			 leftlist.setVisibleRowCount(4); 
			 leftlist.setFont(cFont); 
			 leftlist.setBorder(null);
			 leftlist.setLocation(0, 0);
			 leftlist.setForeground(Color.red);
			 leftlist.setBackground(new Color(30,40,41));
			
			 
			 leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane temp =  new JScrollPane(leftlist); 
			 temp.setBorder(null);
			 temp.setLocation(0, 0);
			 Left.add(temp) ; 
			 Left.setSize(Left.getPreferredSize());
			 
			 leftlist.setSize(Left.getSize());
			 Left.setLocation(20 , getHeight()/4 );
			 
			 ClearLeft = new JButton("Clear") ; 
			 ClearLeft.setFont(customFont);  
			 ClearLeft.setForeground(Color.red);
			 ClearLeft.setContentAreaFilled(false);
			 ClearLeft.setBorderPainted(false);
			 ClearLeft.setFocusable(false);
			 ClearLeft.setSize(ClearLeft.getPreferredSize());
			 ClearLeft.addMouseListener(new MouseListener() {
					
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
						ClearLeft.setForeground(Color.red);
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						ClearLeft.setForeground(Color.blue);
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			 
			 ClearLeft.setLocation(Left.getX()+Left.getWidth(),Left.getY()+Left.getHeight()/2-ClearLeft.getHeight()/2);
			 
			 ClearLeft.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					leftlist.clearSelection();
				}
			});
			 add(ClearLeft) ; 
			 
			add(Left);
			
             Right = new JPanel() ; 
			Right.setLayout(null);
			
             Right.setBackground(null);
             rightlist=new JList() ; 
             rightlist.setBorder(null);
			 rightlist.setVisibleRowCount(4); 
			 rightlist.setFont(cFont); 
			
			
			 rightlist.setLocation(0, 0);
			 rightlist.setForeground(Color.red);
			 rightlist.setBackground(new Color(30,40,41));
			 rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			 Right.setSize(Left.getWidth()+8,Left.getHeight()+8);
			 JScrollPane tempo = new JScrollPane(rightlist) ;
		
			 tempo.setSize(Left.getSize());
			 tempo.setLocation(4, 4);
			 Right.add(tempo) ; 
			
			 
			 Right.setLocation(20 , Left.getHeight()+Left.getY()+100 );
			 
			 ClearRight = new JButton("Clear") ; 
			 ClearRight.setFont(customFont);  
			 ClearRight.setForeground(Color.red);
			 ClearRight.setContentAreaFilled(false);
			 ClearRight.setBorderPainted(false);
			 ClearRight.setFocusable(false);
			 ClearRight.setSize(ClearRight.getPreferredSize());
			 ClearRight.setLocation(ClearLeft.getX(),Right.getY()+Right.getHeight()/2-ClearRight.getHeight()/2);
			 ClearRight.addMouseListener(new MouseListener() {
					
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
						ClearRight.setForeground(Color.red);
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						ClearRight.setForeground(Color.blue);
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			 ClearRight.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					selectedFighters = new ArrayList<PlayableFighter>() ;
					PlayableFighter temp [] = new PlayableFighter [selectedFighters.size()] ; 
					 rightlist.setListData(temp);
				}
			 });
			 add(ClearRight) ; 
			 
			add(Right);
			
			
			
			
			
			Select = new JButton("Select") ; 
			Select.setFont(customFont);  
			Select.setForeground(Color.red);
			Select.setContentAreaFilled(false);
			Select.setBorderPainted(false);
			Select.setFocusable(false);
			Select.setSize(200,100);
			Select.setLocation((Left.getX()+Left.getWidth())/2,Left.getY()+Left.getHeight()); 
			selectedFighters = new ArrayList<PlayableFighter>() ;
			Select.addMouseListener(new MouseListener() {
				
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
					Select.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Select.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			Select.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					selectedArray = new PlayableFighter [leftlist.getSelectedValuesList().size()] ; 
					
					for (int i = 0; i < leftlist.getSelectedValuesList().size(); i++) {
					 selectedArray[i] = (PlayableFighter) leftlist.getSelectedValuesList().get(i) ; 
					 if (!selectedFighters.contains(selectedArray[i]) ) 
					 selectedFighters.add(selectedArray[i]) ; 
					
					}
					
					rightlist.setListData(selectedArray);
					 rightlist.setSize(Left.getSize());
				}
			});
			add(Select) ; 
			StartTournament = new JButton("Start Tournament") ; 
			StartTournament.setFont(customFont);  
			StartTournament.setForeground(Color.red);
			StartTournament.setContentAreaFilled(false);
			StartTournament.setBorderPainted(false);
			StartTournament.setFocusable(false);
			StartTournament.setSize(300,100);
			StartTournament.setLocation(BUTTONWIDTH+300, getHeight()-100 ); 
			StartTournament.addMouseListener(new MouseListener() {
				
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
					StartTournament.setForeground(Color.red);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					StartTournament.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		 
			StartTournament.addActionListener(new StartTournamentHandler(selectedFighters,this,child,getGame()));
			add(StartTournament) ; 
			CreateFighter = new JButton("Add Fighter") ; 
			CreateFighter.setFont(customFont);  
			CreateFighter.setForeground(Color.red);
			CreateFighter.setContentAreaFilled(false);
			CreateFighter.setBorderPainted(false);
			CreateFighter.setFocusable(false);
			CreateFighter.setSize(300,100);
			CreateFighter.setLocation(BUTTONWIDTH, getHeight()-100 ); 
		    CreateFighter.addActionListener(new CreateFighterInTournamentHandler (this,child2,game ) );
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
			add(CreateFighter) ; 
			
		
			
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
	        Back.addActionListener(new BackHandler(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(game), game), game), this));
	        add(Back);
		this.validate();
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
