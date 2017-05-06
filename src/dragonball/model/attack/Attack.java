package dragonball.model.attack;

import java.io.Serializable;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;

abstract public class Attack implements Serializable {
	 private String name ; 
	private int damage ;
	
		public Attack(String name , int damage ) {
			this.name = name ; 
			this.damage = damage ; 
		}

		public String getName() {
			return name;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name ;
		}

		public int getDamage() {
			return damage;
		}
		public abstract int getAppliedDamage(BattleOpponent attacker);

			 public void onUse  (BattleOpponent attacker, BattleOpponent defender,
					boolean defenderBlocking)throws NotEnoughKiException {
				 Fighter Attacker = (Fighter) attacker ; 
					Fighter Defender = (Fighter) defender ; 
					int damage = getAppliedDamage(attacker) ;
					
				
						if (defenderBlocking) {
							while(damage > 0 && Defender.getStamina() > 0 ) {
								 Defender.setStamina(Defender.getStamina()-1);
								damage -=100 ; 
								
							}
						}
						
							if (damage > 0 ) {
								
								Defender.setHealthPoints(Defender.getHealthPoints()- damage );
							
							}
						
					
					attacker = Attacker ; 
					defender = Defender ;
		
	
 
}
}
