package dragonball.model.tournament;

import java.io.Serializable;
import java.util.Random;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleListener;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;

public class TournamentMatch implements BattleListener ,Serializable{
private Battle battle ; 
private MatchStatus matchStatus ; 
private int matchNumber ;
private BattleOpponent player1 ; 
private BattleOpponent player2 ;
private MatchListener listener ; 
private BattleOpponent Winner ; 

public TournamentMatch(int matchNumber,Battle battle,
		BattleOpponent player1, BattleOpponent player2) {
	this.matchNumber = matchNumber ;
	this.battle = battle;
	this.matchStatus = MatchStatus.NOTPLAYEDYET;
	this.player1 = player1;
	this.player2 = player2;
	this.battle.setListener(this); 
}
public void startMatch() {
	matchStatus = MatchStatus.PlAYING ; 
	battle.setListener(this);
	battle.start();
	System.out.println("Start Match");
	
	
}
public void MatchEnded(){
	matchStatus = MatchStatus.ENDED ; 

}
public Battle getBattle() {
	return battle;
}

public void setBattle(Battle battle) {
	this.battle = battle;
}

public MatchStatus getMatchStatus() {
	return matchStatus;
}

public void setMatchStatus(MatchStatus matchStatus) {
	this.matchStatus = matchStatus;
}

public BattleOpponent getPlayer1() {
	return player1;
}

public void setPlayer1(BattleOpponent player1) {
	this.player1 = player1;
}

public BattleOpponent getPlayer2() {
	return player2;
}

public void setPlayer2(BattleOpponent player2) {
	this.player2 = player2;
}

public MatchListener getListener() {
	return listener;
}

public void setListener(MatchListener listener) {
	this.listener = listener;
}
@Override
public void onBattleEvent(BattleEvent e) {
	// TODO Auto-generated method stub

	if (e.getType().equals(BattleEventType.ENDED)){
		Winner = e.getWinner() ; 
	
		MatchEnded();
	}
	if (e.getType() == BattleEventType.STARTED){
	if (listener!=null){
		System.out.println("Tournament Match");
		listener.onMatchStatusChange(e,this);
	}
	}
	else 
		if (listener!=null){
		
			listener.onMatchStatusChange(e,this);
		}
		
}
public BattleOpponent getWinner() {
	return Winner;
}
public void setWinner(BattleOpponent winner) {
	Winner = winner;
}
public int getMatchNumber() {
	return matchNumber;
}
public void setMatchNumber(int matchNumber) {
	this.matchNumber = matchNumber;
}
public void simMatch() {
	// TODO Auto-generated method stub
	Fighter p1 = (Fighter) player1 ; 
	Fighter p2 = (Fighter) player2 ; 
	
	if (p1.getLevel()>p2.getLevel()) {
		Winner = p1 ; 
	}
	else if (p1.getLevel()<p2.getLevel()){
		Winner = p2 ; 
	}
	else {
		if (((int) (Math.random()*2))==1) {
			Winner = p2 ;
		}
		else {
			Winner = p1 ; 
		}
	}
	
	onBattleEvent(new BattleEvent(battle, BattleEventType.ENDED, Winner));
} 


}
