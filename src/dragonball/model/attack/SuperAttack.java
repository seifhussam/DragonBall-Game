package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;

public class SuperAttack extends Attack {

	public SuperAttack(String name, int damage) {
		super(name, damage);
	}

	@Override
	public int getAppliedDamage(BattleOpponent attacker) {
		// TODO Auto-generated method stub
		double n = 1 ;
		Fighter temp = (Fighter) attacker ; 
		if (temp instanceof Saiyan) {
			if (((Saiyan)temp).isTransformed())
				n=1.25;
		}
		
		return (int) ((((Fighter) attacker).getPhysicalDamage() + getDamage())* n)  ;  
	}

	@Override
	public void onUse(BattleOpponent attacker, BattleOpponent defender,
			boolean defenderBlocking) throws NotEnoughKiException {
		if(((Fighter)attacker).getKi()<=0)
			throw new NotEnoughKiException(1, ((Fighter)attacker).getKi()) ; 
		else {
		
	super.onUse(attacker, defender, defenderBlocking);
	Fighter Attacker = (Fighter) attacker ;
	if(this instanceof MaximumCharge)
	Attacker.setKi(Attacker.getKi()+3);
	else 
	Attacker.setKi(Attacker.getKi()-1 );
	attacker = Attacker;
		}
	

}
}
