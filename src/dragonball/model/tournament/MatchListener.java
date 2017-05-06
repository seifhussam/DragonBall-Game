package dragonball.model.tournament;

import java.util.EventListener;

import dragonball.model.battle.BattleEvent;





public interface MatchListener extends EventListener {
	public void onMatchStatusChange(BattleEvent e,TournamentMatch match) ; 
}
