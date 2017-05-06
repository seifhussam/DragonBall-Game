package dragonball.model.character.fighter;

import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Majin extends PlayableFighter {

	public Majin(String name, int level, int xp, int targetXp, int maxHealthPoints,
			int blastDamage, int physicalDamage, int abilityPoints, int maxKi, int maxStamina,
			ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack> ultimateAttacks)
	{
		super(name,level,xp,targetXp,maxHealthPoints,blastDamage,physicalDamage,abilityPoints,maxKi,maxStamina,superAttacks,ultimateAttacks);
	

	}
	public Majin(String name)
	{
		super(name,1500,50,50,3,6,new ArrayList<SuperAttack> (),new ArrayList<UltimateAttack> ());


	}
	@Override
	public void onAttackerTurn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDefenderTurn() {
		// TODO Auto-generated method stub
		setStamina(getStamina()+1 );
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ " Type : Majin  ";
	}
}

