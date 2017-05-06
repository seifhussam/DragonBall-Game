package dragonball.model.tournament;

import java.util.EventListener;

import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleOpponent;

public interface TournamentListener extends EventListener  {

public void onTournamentChange(TournamentStatus status);
public void onStageComplete(int Stage);
public void onMatchStatusChange(BattleEvent e, TournamentMatch match);

}
