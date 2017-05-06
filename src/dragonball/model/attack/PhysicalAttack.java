package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;

public class PhysicalAttack extends Attack {
public PhysicalAttack (){
	super("Physical Attack" , 50) ; 
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
	super.onUse(attacker, defender, defenderBlocking);
	Fighter Attacker = (Fighter) attacker ;
	Attacker.setKi(Attacker.getKi()+1 );
	attacker = Attacker ;
			
	


}

}
