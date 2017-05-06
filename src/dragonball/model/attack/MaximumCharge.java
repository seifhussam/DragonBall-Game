package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.exceptions.NotEnoughKiException;

public class MaximumCharge extends SuperAttack {

	public MaximumCharge() {
		super("Maximum Charge", 0);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getAppliedDamage(BattleOpponent attacker) {
		return 0;
		
	}
	@Override
	public void onUse(BattleOpponent attacker, BattleOpponent defender,
			boolean defenderBlocking) throws NotEnoughKiException {
		
		
	Fighter Attacker = (Fighter) attacker ;
	Attacker.setKi(Attacker.getKi()+3);
	attacker = Attacker;
		
	

}
}
