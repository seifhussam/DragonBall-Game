package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;

public class UltimateAttack extends Attack {
public UltimateAttack(String name, int damage) {
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
	if(((Fighter)attacker).getKi()<=2)
		throw new NotEnoughKiException(3, ((Fighter)attacker).getKi()) ;
	else {
	super.onUse(attacker, defender, defenderBlocking);
	Fighter Attacker = (Fighter) attacker ;
	if (this instanceof SuperSaiyan){
     ((Saiyan)Attacker).setTransformed(true);
	}
	else 
	Attacker.setKi(Attacker.getKi()-3 );
	attacker = Attacker ;
}
}
}
