package dragonball.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dragonball.model.attack.Attack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public class battleEndedView extends GameVeiw implements Serializable  {
private Game game ; 
private WorldVeiw parent ;
private JLabel WinorLost ; 
private JLabel Xp ; 
private JLabel SuperAttacks ; 
private JLabel UltimateAttacks ; 
private Battle battle ; 
private JLabel Title ;
private Font customFont;
private Font customFont2;
private Font customFont3; 
private BattleEvent e ; 
private JLabel xpText ; 
private JLabel xpnumber ; 
private JLabel AttacksWon ; 
private int currLevel ;
private Font NumberscustomFont3; 

 
	public battleEndedView(Battle battle, Game game, BattleEvent e2, int currLevel) {
		super(game);
		this.e = e2 ; 
		this.game = game ; 
		this.battle = battle ; 
		this.currLevel = currLevel ; 
		Font cFont = new Font("Serif",Font.BOLD,42) ; 
		cFont= new Font("Serif",Font.PLAIN,14);
			
			try {
			    //create the font to use. Specify the size!
				cFont = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(30f);
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
				customFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")).deriveFont(20f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Saiyan-Sans Right Oblique.ttf")));
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
			
			NumberscustomFont3= new Font("Serif",Font.PLAIN,14);
			try {
			    //create the font to use. Specify the size!
				NumberscustomFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("Grinched.ttf")).deriveFont(50f);
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
			
			
			
			parent = new WorldVeiw(new ModeVeiw(new StartGameVeiw(new MainMenuVeiw(getGame()), getGame()), getGame()),getGame());  
		
			setLayout(null);
			Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(DimMax); 
			setUndecorated(true);
			Icon ii = new  ImageIcon(getClass().getResource("LostBattle.png")) ;
			Icon i1 = new  ImageIcon(getClass().getResource("WonBattle.jpg")) ;
			JLabel temp  = new JLabel(ii) ;
			JLabel temp1  = new JLabel(i1) ;
			if (battle.getMe() == e.getWinner()) {
			setContentPane(temp1);
				Title = new JLabel("You Won") ; 
				Title.setFont(customFont2) ; 
				Title.setSize(Title.getPreferredSize());
				Title.setLocation(getWidth()/2 - Title.getWidth()/2 , 100 );
				Title.setForeground(java.awt.Color.RED); 
				add(Title) ; 
				
				if (currLevel != ( (Fighter)battle.getMe() ).getLevel()) {
					JLabel LevelText = new JLabel("CONGRATULATIONS YOU ARE NOW LEVEL") ; 
					LevelText.setFont(customFont3) ; 
					LevelText.setSize(LevelText.getPreferredSize()); 
					LevelText.setLocation(getWidth()/2 - LevelText.getWidth()/2 , 250 ) ; 
					LevelText.setForeground(java.awt.Color.RED); 
					add(LevelText) ;  
					
					JLabel LevelNumber = new JLabel(" "+  ((Fighter)battle.getMe() ).getLevel()) ; 
					LevelNumber.setFont(NumberscustomFont3) ; 
					LevelNumber.setSize(LevelNumber.getPreferredSize()); 
					LevelNumber.setLocation(LevelText.getX() +LevelText.getWidth(), 250 ) ; 
					LevelNumber.setForeground(java.awt.Color.RED); 
					add(LevelNumber) ;  
					
					JLabel XpText = new JLabel("YOUR CURRENT XP IS ") ; 
					XpText.setFont(Font5Text) ; 
					XpText.setSize(XpText.getPreferredSize()); 
					XpText.setLocation(10 , 350 ) ; 
					XpText.setForeground(java.awt.Color.RED); 
					add(XpText) ;  
					
					JLabel XpNumber = new JLabel(" "+  ((PlayableFighter)battle.getMe() ).getXp()) ; 
					XpNumber.setFont(cFont) ; 
					XpNumber.setSize(XpNumber.getPreferredSize()); 
					XpNumber.setLocation(10+XpText.getWidth(), 350 ) ; 
					XpNumber.setForeground(java.awt.Color.RED); 
					add(XpNumber) ;  
					
					JLabel TargetXpText = new JLabel("YOUR TARGET XP IS ") ; 
					TargetXpText.setFont(Font5Text) ; 
					TargetXpText.setSize(TargetXpText.getPreferredSize()); 
					TargetXpText.setLocation(10 , 400 ) ; 
					TargetXpText.setForeground(java.awt.Color.RED); 
					add(TargetXpText) ;  
					
					JLabel TargetXpNumber = new JLabel(" "+  ((PlayableFighter)battle.getMe() ).getTargetXp()) ; 
					TargetXpNumber.setFont(cFont) ; 
					TargetXpNumber.setSize(TargetXpNumber.getPreferredSize()); 
					TargetXpNumber.setLocation(10+TargetXpText.getWidth(),400 ) ; 
					TargetXpNumber.setForeground(java.awt.Color.RED); 
					add(TargetXpNumber) ;  
					
					JLabel aPILITYText = new JLabel("YOUR GAINED APILITYPOINTS ARE") ; 
					aPILITYText.setFont(Font5Text) ; 
					aPILITYText.setSize(aPILITYText.getPreferredSize()); 
					aPILITYText.setLocation(10 , 450 ) ; 
					aPILITYText.setForeground(java.awt.Color.RED); 
					add(aPILITYText) ;  
					
					JLabel abilityNumber = new JLabel("  "+  ((Fighter) battle.getFoe()).getLevel()* 5) ; 
					abilityNumber.setFont(cFont) ; 
					abilityNumber.setSize(abilityNumber.getPreferredSize()); 
					abilityNumber.setLocation(10+aPILITYText.getWidth(), 450 ) ; 
					abilityNumber.setForeground(java.awt.Color.RED); 
					add(abilityNumber) ;  
					
					JLabel unlockedAttacks = new JLabel("YOU HAVE UNLOCKED NEW SKILLS")   ; 
					unlockedAttacks.setFont(Font5Text) ; 
					unlockedAttacks.setSize(unlockedAttacks.getPreferredSize()); 
					unlockedAttacks.setLocation(10 ,550 ) ; 
					unlockedAttacks.setForeground(java.awt.Color.RED); 
					add(unlockedAttacks) ;  
					 ArrayList <String> FoeSkills = new ArrayList<String>() ;  
					for (int i = 0; i < ((Fighter) battle.getFoe()).getSuperAttacks().size(); i++) {
						FoeSkills.add( ((Fighter) battle.getFoe()).getSuperAttacks().get(i).getName()) ; 
//						JLabel SA = new JLabel()   ; 
//						SA.setFont(customFont5) ; 
//						SA.setSize(XpText.getPreferredSize()); 
//						SA.setLocation(20 , 450 + i*SA.getHeight() + 10 ) ; 
//						SA.setForeground(java.awt.Color.RED); 
//						add(SA) ;  
					}
					
					
                   for (int i = 0; i < ((Fighter) battle.getFoe()).getUltimateAttacks().size(); i++) {
                	   FoeSkills.add( ((Fighter) battle.getFoe()).getUltimateAttacks().get(i).getName()) ; 
//                	   JLabel UA = new JLabel( ((Fighter) battle.getFoe()).getUltimateAttacks().get(i).getName())   ; 
//                	   UA.setFont(customFont5) ; 
//                	   UA.setSize(XpText.getPreferredSize()); 
//                	   UA.setLocation(20 , 450 + i*UA.getHeight() + 10 ) ; 
//                	   UA.setForeground(java.awt.Color.RED); 
//						add(UA) ;  
					}
					
                   for (int i = 0; i < FoeSkills.size(); i++) {
                	   JLabel SA = new JLabel(FoeSkills.get(i))   ; 
			         	SA.setFont(customFont5) ; 
						SA.setSize(XpText.getPreferredSize()); 
						SA.setLocation(20 , 600 + i*SA.getHeight() + 10 ) ; 
						SA.setForeground(java.awt.Color.RED); 
    					add(SA) ;  
				}
                   
					
				}
				else 
				{
					JLabel XpText = new JLabel("YOUR CURRENT XP IS ") ; 
					XpText.setFont(Font5Text) ; 
					XpText.setSize(XpText.getPreferredSize()); 
					XpText.setLocation(10 , 300 ) ; 
					XpText.setForeground(java.awt.Color.RED); 
					add(XpText) ;  
					
					JLabel XpNumber = new JLabel(" "+  ((PlayableFighter)battle.getMe() ).getXp()) ; 
					XpNumber.setFont(cFont) ; 
					XpNumber.setSize(XpNumber.getPreferredSize()); 
					XpNumber.setLocation(10+XpText.getWidth(), 300 ) ; 
					XpNumber.setForeground(java.awt.Color.RED); 
					add(XpNumber) ;  
					
					JLabel unlockedAttacks = new JLabel("YOU HAVE UNLOCKED NEW SKILLS")   ; 
					unlockedAttacks.setFont(Font5Text) ; 
					unlockedAttacks.setSize(unlockedAttacks.getPreferredSize()); 
					unlockedAttacks.setLocation(10 , 450 ) ; 
					unlockedAttacks.setForeground(java.awt.Color.RED); 
					add(unlockedAttacks) ;  
					 ArrayList <String> FoeSkills = new ArrayList<String>() ;  
					for (int i = 0; i < ((Fighter) battle.getFoe()).getSuperAttacks().size(); i++) {
						FoeSkills.add( ((Fighter) battle.getFoe()).getSuperAttacks().get(i).getName()) ; 
//						JLabel SA = new JLabel()   ; 
//						SA.setFont(customFont5) ; 
//						SA.setSize(XpText.getPreferredSize()); 
//						SA.setLocation(20 , 450 + i*SA.getHeight() + 10 ) ; 
//						SA.setForeground(java.awt.Color.RED); 
//						add(SA) ;  
					}
					
					
                   for (int i = 0; i < ((Fighter) battle.getFoe()).getUltimateAttacks().size(); i++) {
                	   FoeSkills.add( ((Fighter) battle.getFoe()).getUltimateAttacks().get(i).getName()) ; 
//                	   JLabel UA = new JLabel( ((Fighter) battle.getFoe()).getUltimateAttacks().get(i).getName())   ; 
//                	   UA.setFont(customFont5) ; 
//                	   UA.setSize(XpText.getPreferredSize()); 
//                	   UA.setLocation(20 , 450 + i*UA.getHeight() + 10 ) ; 
//                	   UA.setForeground(java.awt.Color.RED); 
//						add(UA) ;  
					}
					
                   for (int i = 0; i < FoeSkills.size(); i++) {
                	   JLabel SA = new JLabel(FoeSkills.get(i))   ; 
			         	SA.setFont(customFont5) ; 
						SA.setSize(SA.getPreferredSize()); 
						SA.setLocation(20 , 500 + i*SA.getHeight() + 10 ) ; 
						SA.setForeground(java.awt.Color.RED); 
    					add(SA) ;  
				}
                   
				}
				
				if (((NonPlayableFighter) battle.getFoe()).isStrong() ) {
					JLabel unlockedAttacks = new JLabel("YOU HAVE UNLOCKED A NEW MAP")   ; 
					unlockedAttacks.setFont(Font5Text) ; 
					unlockedAttacks.setSize(unlockedAttacks.getPreferredSize()); 
					unlockedAttacks.setLocation(10 ,900 ) ; 
					unlockedAttacks.setForeground(java.awt.Color.RED); 
					add(unlockedAttacks) ;  
				}
			
			
			
			
			
			
			validate() ; 
			
             Runnable r = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub 
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						parent.setVisible(true); 
						Runnable r = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									Thread.sleep(1000) ;
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
				};
				Thread t = new Thread(r) ; 
				t.start();
			
			
			
			}
			else { 
				setContentPane(temp);
				Title = new JLabel("You Lost") ; 
				Title.setFont(customFont2) ; 
				Title.setSize(Title.getPreferredSize());
				Title.setLocation(getWidth()/2 - Title.getWidth()/2 -300 , 250 );
				Title.setForeground(java.awt.Color.RED); 
		//		add(Title) ; 
				
				
				validate() ; 
				
				Runnable r = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub 
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						parent.setVisible(true); 
						Runnable r = new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									Thread.sleep(1000) ;
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
				};
				Thread t = new Thread(r) ; 
				t.start();
			}
			
		
		
		
		
		// TODO Auto-generated constructor stub
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
