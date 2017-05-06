package dragonball.model.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import dragonball.model.attack.Attack;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleListener;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.EmptyCell;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.player.Player;
import dragonball.model.player.PlayerListener;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.Tournament;
import dragonball.model.tournament.TournamentListener;
import dragonball.model.tournament.TournamentMatch;
import dragonball.model.tournament.TournamentStatus;
import dragonball.model.world.World;
import dragonball.model.world.WorldListener;

public class Game implements PlayerListener, WorldListener, BattleListener, Serializable,TournamentListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private World world;
	private ArrayList<NonPlayableFighter> weakFoes;
	private ArrayList<NonPlayableFighter> strongFoes;
	private ArrayList<Attack> attacks;
	private ArrayList<Dragon> dragons;
	private GameState state;
	private transient GameListener gameListener;
    private  static String savedBefore ; 
    private ArrayList<NonPlayableFighter> Tournamentfoes ;
    private Tournament tournament ; 

	public String getSavedBefore() {
		return savedBefore;
	}
	public static void setSavedBefore(String savedBefore) {
		Game.savedBefore = savedBefore;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Game()   {
		
		player = new Player("");
		attacks = new ArrayList<Attack>();
		dragons = new ArrayList<Dragon>();
		weakFoes = new ArrayList<NonPlayableFighter>();
		strongFoes = new ArrayList<NonPlayableFighter>();
		setTournamentfoes(new ArrayList<NonPlayableFighter>()) ;
		world = new World();
		player.setPlayerListener(this);
		
		world.setWorldListener(this);
		try {
		try {
			loadAttacks("Database-Attacks.csv");
		}
		catch (MissingFieldException e ) {
			loadAttacks("Database-Attacks-aux.csv");
		}
		catch (UnknownAttackTypeException e ) {
			loadAttacks("Database-Attacks-aux.csv");
		}
		try {
			loadDragons("Database-Dragons.csv");
		}
		catch(MissingFieldException e) {
			loadDragons("Database-Dragons-aux.csv");
			
		}
		try {
			loadFoes("Database-Foes-Range"+getn()+".csv");
		}
		catch (MissingFieldException e ) {
			loadFoes("Database-Foes-aux.csv");
		}
		}
		catch (IOException f ) {
			f.printStackTrace();
		}
		for (int i = 0; i < 4; i++) {
			
		
		try {
			loadTournamentFoes("Database-Foes-Range"+(i+1)+".csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		world.generateMap(weakFoes, strongFoes);
		
		
		
		
		
	state = GameState.WORLD;
		

	}
public void save (String path) {
	
	
	
	try   {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File(path)));
		// Serializing the object and writing it on the hard disk.
		oos.writeObject(this);
		// Updating the last saved file path to the current file.
		savedBefore = path;
		// close the output stream.
		oos.close();
	      } catch(IOException i ) 
	      {
	          i.printStackTrace();
	      }
}
public void load (String fileName) throws IOException, ClassNotFoundException {
	Game g ; 

	
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        g = (Game) in.readObject(); 
        this.dragons = g.dragons ; 
        this.attacks = g.attacks ;
 	   this.gameListener = g.gameListener ; 
 	   this.world = g.world ; 
 	   this.player = g.player ;
 	   System.out.println(g.player.getActiveFighter());
 	   this.player.setActiveFighter(g.player.getActiveFighter() );  
 	   this.player.setPlayerListener(this);
 	   this.world.setWorldListener(this);
 	   this.state = g.state ; 
 	   this.weakFoes = g.weakFoes ; 
 	   this.strongFoes = g.strongFoes ;
               try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        try {
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
    
	}
	
	
	
	    
	   

	public void setListener(GameListener gameListener) {
		this.gameListener = gameListener;
	}

	private int getn() {
		if (player==null){
			return 1 ;
		}
		if(player.getActiveFighter()==null) {
			return 1 ;
		}
		if (player.getActiveFighter().getLevel() <= 10)
			return 1;
		else if (player.getActiveFighter().getLevel() <= 20)
			return 2;
		else if (player.getActiveFighter().getLevel() <= 30)
			return 3;
		else if (player.getActiveFighter().getLevel() <= 40)
			return 4;
		else if (player.getActiveFighter().getLevel() >40)
			return 5;
 return 1 ;
	}

	private LinkedList<String> loadCSV(String path) throws IOException {
		LinkedList<String> result = new LinkedList<String>();
		FileReader fileReader = new FileReader(path);
		BufferedReader bf = new BufferedReader(fileReader);
		String temp = "";
		while ((temp = bf.readLine()) != null) {

			result.add(temp);
		}
      fileReader.close();
		return result;

	}

	private int damageSearch(String name) {
		for (int i = 0; i < this.attacks.size(); i++) {
			if (name.equals(attacks.get(i).getName()))
				return attacks.get(i).getDamage();
		}
		return -1;
	}

	public void loadDragons(String path) throws IOException {
		this.dragons = new ArrayList<>();
		LinkedList<String> Dragons = loadCSV(path);
		if (!path.contains(".csv" )){
			
			loadDragons("Database-Dragons-aux.csv");
		}
		int sourceLine = 0 ; 
		while (!Dragons.isEmpty()) {
			sourceLine++ ; 
			String FirstLine[] = Dragons.removeFirst().split(",");
			
			if(FirstLine.length!=3){
			dragons = new ArrayList<Dragon>()  ; 
				throw new MissingFieldException(path+" "+sourceLine+" "+(3-FirstLine.length),path, sourceLine, 3-FirstLine.length) ; 
			}
			String SecondLine[] = Dragons.removeFirst().split(",");
		
			String ThirdLine[] = Dragons.removeFirst().split(",");
			sourceLine +=2 ;
			ArrayList<SuperAttack> DragonssuperAttacks = new ArrayList<SuperAttack>();
			ArrayList<UltimateAttack> DragonsUltimateAttacks = new ArrayList<UltimateAttack>();
			for (int j = 0; j < SecondLine.length; j++) {
				DragonssuperAttacks.add(new SuperAttack(SecondLine[j],
						damageSearch(SecondLine[j])));
			}
			for (int j = 0; j < ThirdLine.length; j++) {
				DragonsUltimateAttacks.add(new UltimateAttack(ThirdLine[j],
						damageSearch(ThirdLine[j])));
			}
			this.dragons.add(new Dragon(FirstLine[0], DragonssuperAttacks,
					DragonsUltimateAttacks, Integer.parseInt(FirstLine[1]),
					Integer.parseInt(FirstLine[2])));
		}

	}

	public void loadFoes(String path) throws IOException {
		this.strongFoes = new ArrayList<>() ; 
		this.weakFoes = new ArrayList<>() ; 
		LinkedList<String> Foes = loadCSV(path);
		if (!path.contains(".csv")){
			
			loadFoes("Database-Foes-aux.csv");
		}
		int sourceLine = 0 ; 
		while (!Foes.isEmpty()) {
			sourceLine++ ;
			String FirstLine[] = Foes.removeFirst().split(",");
		
			if(FirstLine.length!=8){
				strongFoes = new ArrayList<NonPlayableFighter>() ; 
				weakFoes = new ArrayList<NonPlayableFighter>() ; 
				throw new MissingFieldException(path+" "+sourceLine +" "+(8-FirstLine.length),path, sourceLine, 7-FirstLine.length) ; 
			}
			sourceLine+=2 ;
			String SLine = Foes.removeFirst();
			String SecondLine[] = SLine.split(",");
			String TLine = "" ; 
			
			try {
			 TLine = Foes.removeFirst();
			} 
			catch (Exception e) {
				
			}
			
			String ThirdLine[] = TLine.split(",");
			
			ArrayList<SuperAttack> FoessuperAttacks = new ArrayList<SuperAttack>();
			ArrayList<UltimateAttack> FoesUltimateAttacks = new ArrayList<UltimateAttack>();
			boolean b1 = false;
			boolean b2 = false;
			for (int i = 0; i < SLine.length(); i++) {
				if (SLine.charAt(i) != ' ') {
					b1 = true;
					break;
				}

			}
			for (int i = 0; i < TLine.length(); i++) {
				if (TLine.charAt(i) != ' ') {
					b2 = true;
					break;
				}

			}
			boolean b = Boolean.parseBoolean(FirstLine[7]);

			for (int j = 0; j < SecondLine.length && b1; j++) {
				if (SecondLine[j].equals("Maximum Charge"))
					FoessuperAttacks.add((MaximumCharge) new MaximumCharge());
				else
					FoessuperAttacks.add(new SuperAttack(SecondLine[j],
							damageSearch(SecondLine[j])));
			}
			for (int j = 0; j < ThirdLine.length && b2; j++) {
				if (ThirdLine[j].equals("Super Saiyan"))
					FoesUltimateAttacks.add((SuperSaiyan) new SuperSaiyan());
				else
					FoesUltimateAttacks.add(new UltimateAttack(ThirdLine[j],
							damageSearch(ThirdLine[j])));
			}
			if (b){
				
				this.strongFoes.add(new NonPlayableFighter(FirstLine[0],
						Integer.parseInt(FirstLine[1]), Integer
								.parseInt(FirstLine[2]), Integer
								.parseInt(FirstLine[3]), Integer
								.parseInt(FirstLine[4]), Integer
								.parseInt(FirstLine[5]), Integer
								.parseInt(FirstLine[6]), true,
						FoessuperAttacks, FoesUltimateAttacks));
			}
			else {
				this.weakFoes.add(new NonPlayableFighter(FirstLine[0], Integer
						.parseInt(FirstLine[1]),
						Integer.parseInt(FirstLine[2]), Integer
								.parseInt(FirstLine[3]), Integer
								.parseInt(FirstLine[4]), Integer
								.parseInt(FirstLine[5]), Integer
								.parseInt(FirstLine[6]), false,
						FoessuperAttacks, FoesUltimateAttacks));
			}
		}
	}
	public void loadTournamentFoes(String path) throws IOException {
		
		LinkedList<String> Foes = loadCSV(path);
		if (!path.contains(".csv")){
			
			loadFoes("Database-Foes-aux.csv");
		}
		int sourceLine = 0 ; 
		while (!Foes.isEmpty()) {
			sourceLine++ ;
			String FirstLine[] = Foes.removeFirst().split(",");
		
			if(FirstLine.length!=8){
				strongFoes = new ArrayList<NonPlayableFighter>() ; 
				weakFoes = new ArrayList<NonPlayableFighter>() ; 
				throw new MissingFieldException(path+" "+sourceLine +" "+(8-FirstLine.length),path, sourceLine, 7-FirstLine.length) ; 
			}
			sourceLine++;
			String SLine = Foes.removeFirst();
			String SecondLine[] = SLine.split(",");
			String TLine = "" ;
			
			try {
				sourceLine++;
			 TLine = Foes.removeFirst();
			} 
			catch (Exception e) {
				
			}
			
			String ThirdLine[] = TLine.split(",");
			
			ArrayList<SuperAttack> FoessuperAttacks = new ArrayList<SuperAttack>();
			ArrayList<UltimateAttack> FoesUltimateAttacks = new ArrayList<UltimateAttack>();
			boolean b1 = false;
			boolean b2 = false;
			for (int i = 0; i < SLine.length(); i++) {
				if (SLine.charAt(i) != ' ') {
					b1 = true;
					break;
				}

			}
			for (int i = 0; i < TLine.length(); i++) {
				if (TLine.charAt(i) != ' ') {
					b2 = true;
					break;
				}

			}
			

			for (int j = 0; j < SecondLine.length && b1; j++) {
				if (SecondLine[j].equals("Maximum Charge"))
					FoessuperAttacks.add((MaximumCharge) new MaximumCharge());
				else
					FoessuperAttacks.add(new SuperAttack(SecondLine[j],
							damageSearch(SecondLine[j])));
			}
			for (int j = 0; j < ThirdLine.length && b2; j++) {
				if (ThirdLine[j].equals("Super Saiyan"))
					FoesUltimateAttacks.add((SuperSaiyan) new SuperSaiyan());
				else
					FoesUltimateAttacks.add(new UltimateAttack(ThirdLine[j],
							damageSearch(ThirdLine[j])));
			}
//			System.out.println(FirstLine[0]+" "+FirstLine[6]);
				this.Tournamentfoes.add(new NonPlayableFighter(FirstLine[0],
						Integer.parseInt(FirstLine[1]), Integer
								.parseInt(FirstLine[2]), Integer
								.parseInt(FirstLine[3]), Integer
								.parseInt(FirstLine[4]), Integer
								.parseInt(FirstLine[5]), Integer
								.parseInt(FirstLine[6]),Boolean.parseBoolean(FirstLine[7]),
						FoessuperAttacks, FoesUltimateAttacks));

			
		}
	}

	public void loadAttacks(String path) throws IOException {
		this.attacks = new ArrayList<>() ; 
		LinkedList<String> Attacks = loadCSV(path);
		if (!path.contains(".csv")){
			loadAttacks("Database-Attacks-aux.csv");
		}
        int sourceLine = 0 ; 
		while (!Attacks.isEmpty()) {
			String temp[] = ("" + Attacks.removeFirst()).split(",");
			sourceLine++ ;
			if (temp.length!=3) {
				
				attacks = new ArrayList<Attack>() ; 
				throw new MissingFieldException(path+" "+sourceLine+" "+(3-temp.length),path, sourceLine, 3-temp.length);
			}
			String s = temp[1];
			int x = Integer.parseInt(temp[2]);
			if (temp[0].equals("UA"))
				attacks.add(new UltimateAttack(s, x));
			else if (temp[0].equals("SA"))
				attacks.add(new SuperAttack(s, x));
			else if (temp[0].equals("MC"))
				attacks.add(new MaximumCharge());
			else if (temp[0].equals("SS"))
				attacks.add(new SuperSaiyan());
			else 
				throw new UnknownAttackTypeException(path, sourceLine, temp[0]) ; 
		}
	}

	public GameListener getGameListener() {
		return gameListener;
	}

	public Player getPlayer() {
		return player;
	}

	public World getWorld() {
		return world;
	}

	public ArrayList<NonPlayableFighter> getWeakFoes() {
		return weakFoes;
	}

	public ArrayList<NonPlayableFighter> getStrongFoes() {
		return strongFoes;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public ArrayList<Dragon> getDragons() {
		return dragons;
	}

	public GameState getState() {
		return state;
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		// TODO Auto-generated method stub
		if (e.getType().equals(BattleEventType.STARTED)) {
			state = GameState.BATTLE;

		}
		else if (e.getType().equals(BattleEventType.ENDED)) {
			state = GameState.WORLD;
		        if (e.getWinner()==player.getActiveFighter()){
		        	world.getMap()[world.getPlayerRow()][world.getPlayerColumn()] = new EmptyCell() ; 
		        	
		        	
		      	ArrayList<SuperAttack> sa =((Fighter) ((Battle) e.getSource()).getFoe()).getSuperAttacks();
		      	for (int i = 0; i <sa.size(); i++) {
		      		boolean b = true ; 
		      		int j = 0 ; 
		      		for ( j = 0; j < player.getSuperAttacks().size() ; j++) {
		      			if (sa.get(i).getName().equals(player.getSuperAttacks().get(j).getName()) &&
			    				sa.get(i).getDamage() == player.getSuperAttacks().get(j).getDamage()){
		      				b = false ; 
		      				
			    		}
					}
		      		if (b) { 
		      			player.getSuperAttacks().add(sa.get(i)) ; 
		      		}
		    		
		      	}
		    	ArrayList<UltimateAttack> ua =((Fighter) ((Battle) e.getSource()).getFoe()).getUltimateAttacks();
		      	for (int i = 0; i <ua.size(); i++) {
		      		boolean b = true ; 
		      		int j = 0 ; 
		      		for ( j = 0; j < player.getUltimateAttacks().size() ; j++) {
		      			if (ua.get(i).getName().equals(player.getUltimateAttacks().get(j).getName()) &&
			    				ua.get(i).getDamage() == player.getUltimateAttacks().get(j).getDamage()){
		      				b = false ; 
		      				
			    		}
					}
		      		if (b) { 
		      			player.getUltimateAttacks().add(ua.get(i)) ; 
		      		}
		    		
		      	}
		        
		        
				((PlayableFighter)e.getWinner()).setXp(	((PlayableFighter)e.getWinner()).getXp()+ (((Fighter) e.getCurrentOpponent()).getLevel()* 5));
				if (((NonPlayableFighter) ((Battle)e.getSource()).getFoe()).isStrong()) {
					player.setExploredMaps(player.getExploredMaps() + 1);
					world = new World();
					world.generateMap(weakFoes, strongFoes);
					
				}
		        }
		        }
		        else {
		        	
		        	try {
						load("save.ser") ;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						world = new World () ; 
			        	world.generateMap(weakFoes, strongFoes);
			        	world.resetPlayerPosition();
			        	world.setWorldListener(this);
			        	
						
					} 
		        	}
		        
		        	
		        
			
		
			if (gameListener != null){
				gameListener.onBattleEvent(e);
				
			}
	}

	@Override
	public void onFoeEncountered(NonPlayableFighter foe) {
		// TODO Auto-generated method stub
		
		Battle b = new Battle(player.getActiveFighter(), foe);
		b.setListener(this);
		b.start();
		
		state = GameState.BATTLE;
		
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		// TODO Auto-generated method stub
		if (collectible == Collectible.SENZU_BEAN){
			player.setSenzuBeans(player.getSenzuBeans() + 1);
			if (gameListener != null)
				gameListener.onCollectibleFound(collectible);
		}
		else if(collectible ==Collectible.DRAGON_BALL){
			
			player.setDragonBalls(player.getDragonBalls()+ 1);
			
			if (gameListener != null)
				gameListener.onCollectibleFound(collectible);
			if (player.getDragonBalls() == 7){
		
				player.setDragonBalls(0);
				player.callDragon();
			
				
			}
			
				
			}
		}
		

	

	@Override
	public void onDragonCalled() {
		// TODO Auto-generated method stub
		
		if (dragons.size() != 0 ){
		int random = (int) (Math.random() * dragons.size());
		if (gameListener != null)
			gameListener.onDragonCalled(dragons.get(random));

		state = GameState.DRAGON;
	}
	}

	@Override
	public void onWishChosen(DragonWish wish) {
		// TODO Auto-generated method stub
		state = GameState.WORLD;
	}

	
	@Override
	public void onStageComplete(int Stage) {
		// TODO Auto-generated method stub
		if (gameListener!=null) 
			gameListener.onStageComplete(Stage) ; 
	}
	@Override
	public void onTournamentChange(TournamentStatus status) {
		// TODO Auto-generated method stub
		if (status == TournamentStatus.STARTED){
			state = GameState.TOURNAMENT ; 
		}
		else if (status== TournamentStatus.ENDED){
			state = GameState.MAIN ; 
		}
		if (gameListener!=null){
			gameListener.onTournamentEvent(status) ; 
		}
	}
	public ArrayList<NonPlayableFighter> getTournamentfoes() {
		return Tournamentfoes;
	}
	public void setTournamentfoes(ArrayList<NonPlayableFighter> tournamentfoes) {
		Tournamentfoes = tournamentfoes;
	}
	
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public static void main(String[] args) {
Game g = new Game() ; 
//
//for (int i = 0; i < g.getTournamentfoes().size(); i++) {
//	if (g.getTournamentfoes().get(i).isStrong())
//	System.out.println(g.getTournamentfoes().get(i).getName());
	
//}
		
	}
	@Override
	public void onMatchStatusChange(BattleEvent e, TournamentMatch match) {
		// TODO Auto-generated method stub
		if (gameListener!=null) {
			
			gameListener.onTournamentMatchEvent(e, match.getMatchStatus());
			
		}
		
	}

}
