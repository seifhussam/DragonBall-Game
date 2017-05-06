package dragonball.model.tournament;

import java.io.Serializable;
import java.util.ArrayList;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.game.Game;

public class Tournament implements MatchListener,Serializable {
private BattleOpponent [] players ; 
private TournamentStage currentStage ; 
private int playersnumber ;
private TournamentListener Listener ;
private int StageNumber ; 
private ArrayList<NonPlayableFighter> foes ; 
private ArrayList<PlayableFighter> myFighters ; 
private TournamentMatch tournamentMatch [] ;
private boolean ChosenPlayers [] ; 
private boolean MatchPlayed [] ;
private TournamentMatch CurrentMatch ; 
private Game game ; 

public Tournament(Game game , ArrayList<NonPlayableFighter> weakfoes  , ArrayList<PlayableFighter> myFighters ) {
	// TODO Auto-generated constructor stub
	this.game = game ; 
	this.setListener(this.game);
	this.playersnumber = myFighters.size() ; 
	foes = new ArrayList<NonPlayableFighter>() ; 
	foes.addAll(weakfoes); 
	this.setMyFighters(myFighters) ; 
	StageNumber = 16 ;
	players = new BattleOpponent[32] ; 
	int i ;
	for ( i = 0; i < myFighters.size(); i++) {
		players[i]=myFighters.get(i) ; 
	}
	
	for (int j= i;j < players.length;j++) {
		int random = (int) (Math.random()*foes.size()) ;
		while(containBattleOponent(foes.get(random))){
			random = (int) (Math.random()*foes.size()) ;
		}
	
		players[j] = foes.get(random);
		
	}

	if (Listener!=null) {
		Listener.onTournamentChange(TournamentStatus.STARTED);
		Listener.onStageComplete(32);
	}
}
public boolean containBattleOponent (BattleOpponent bo){
	for (int i = 0; i < players.length; i++) {
		if (players[i] == bo){
			return true ;
		}
	}
	
	return false ;
}
public void generateTournamentStage (int StageNumber) {
	switch(StageNumber) { 
	case 1 : currentStage = TournamentStage.STAGE1 ; break ; 
	case 2 : currentStage = TournamentStage.STAGE2 ;break ; 
	case 4 : currentStage = TournamentStage.STAGE4 ;break ; 
	case 8 : currentStage = TournamentStage.STAGE8 ;break ; 
	case 16 : currentStage = TournamentStage.STAGE16 ;break ; 
	}
	
	
	ChosenPlayers = new boolean [StageNumber*2] ; 
   tournamentMatch = new TournamentMatch [StageNumber] ; 
   MatchPlayed = new boolean [StageNumber] ;
   for (int i = 0; i < tournamentMatch.length; i++) {
	int randomplayer1 =(int) (Math.random()*players.length);
	while(ChosenPlayers[randomplayer1]||players[randomplayer1]==null){
		randomplayer1 =(int) (Math.random()*players.length);
	}
	BattleOpponent Player1 = players[randomplayer1] ; 
	ChosenPlayers[randomplayer1]=true ; 
	int randomplayer2 =(int) (Math.random()*players.length);
	while(ChosenPlayers[randomplayer2]||players[randomplayer2]==null){
		randomplayer2 =(int) (Math.random()*players.length);
	}
	BattleOpponent Player2 = players[randomplayer2] ; 
	ChosenPlayers[randomplayer2]=true ;
	if (Player1 instanceof PlayableFighter) {
	Battle battle = new Battle(Player1, Player2);
	tournamentMatch[i] = new TournamentMatch(i,battle, Player1, Player2);
	}
	else if (Player2 instanceof PlayableFighter) {
		Battle battle = new Battle(Player2, Player1);
		tournamentMatch[i] = new TournamentMatch(i,battle, Player2, Player1);
	} else {
		Battle battle = new Battle(Player1, Player2);
		tournamentMatch[i] = new TournamentMatch(i,battle, Player1, Player2);
		}
	
	tournamentMatch[i].setListener(this);
}
 
}


public void simulateMatch () { 
	CurrentMatch.simMatch();
}


public BattleOpponent[] getPlayers() {
	return players;
}
public void setPlayers(BattleOpponent[] players) {
	this.players = players;
}

public TournamentStage getCurrentStage() {
	return currentStage;
}
public void setCurrentStage(TournamentStage currentStage) {
	this.currentStage = currentStage;
}
public int getPlayersnumber() {
	return playersnumber;
}
public void setPlayersnumber(int playersnumber) {
	this.playersnumber = playersnumber;
}
public TournamentListener getListener() {
	return Listener;
}
public void setListener(TournamentListener listener) {
	Listener = listener;
}


public int getStageNumber() {
	return StageNumber;
}


public void setStageNumber(int stageNumber) {
	StageNumber = stageNumber;
}
public ArrayList<NonPlayableFighter> getFoes() {
	return foes;
}
public void setFoes(ArrayList<NonPlayableFighter> foes) {
	this.foes = foes;
}
public TournamentMatch[] getTournamentMatch() {
	return tournamentMatch;
}
public void setTournamentMatch(TournamentMatch tournamentMatch[]) {
	this.tournamentMatch = tournamentMatch;
}
public ArrayList<PlayableFighter> getMyFighters() {
	return myFighters;
}
public void setMyFighters(ArrayList<PlayableFighter> myFighters) {
	this.myFighters = myFighters;
}
public boolean[] getMatchPlayed() {
	return MatchPlayed;
}
public void setMatchPlayed(boolean matchPlayed[]) {
	MatchPlayed = matchPlayed;
}
@Override
public void onMatchStatusChange(BattleEvent e ,TournamentMatch match) {
	// TODO Auto-generated method stub

	if (e.getType() == BattleEventType.ENDED){
		MatchPlayed[match.getMatchNumber()] = true ; 
		if (CheckStage()&&MatchPlayed.length == 1  ){
			if(Listener!= null) {
				Listener.onTournamentChange(TournamentStatus.ENDED);
			}
		}
		else 
		if (CheckStage()){
			System.out.println("StageEnded");
			players= new BattleOpponent[StageNumber] ; 
			for (int i = 0; i < players.length; i++) {
				players[i]= tournamentMatch[i].getWinner(); 
			}
			StageNumber = StageNumber/2 + StageNumber%2 ; 
			generateTournamentStage(StageNumber);
			
			if(Listener!=null){
				Listener.onStageComplete(StageNumber);
			}
		}
		else {
 
			if (Listener!=null) {
				Listener.onMatchStatusChange(e,match);
			}
		}
		
	}
	else if (Listener!=null) { 
		Listener.onMatchStatusChange(e,match);
		
	}
	
}
public boolean CheckStage(){
	for (int i = 0; i < MatchPlayed.length; i++) {
		if (!MatchPlayed[i]){
			return false ; 
		}
	}
	return true ; 
}
public TournamentMatch getCurrentMatch() {
	return CurrentMatch;
}
public void setCurrentMatch(TournamentMatch currentMatch) {
	CurrentMatch = currentMatch;
} 


}
