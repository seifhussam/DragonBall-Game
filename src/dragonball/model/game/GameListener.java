package dragonball.model.game;

import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.tournament.MatchStatus;
import dragonball.model.tournament.TournamentStatus;

public interface GameListener  {
	public void onDragonCalled(Dragon dragon) ;
	public void onCollectibleFound(Collectible collectible) ;
	public void onBattleEvent(BattleEvent e) ;
    public void onTournamentMatchEvent( BattleEvent e ,MatchStatus matchStatus);
	public void onTournamentEvent(TournamentStatus status);
	public void onStageComplete(int stage); 
	
}
