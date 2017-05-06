package dragonball.model.character.fighter;

import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Namekian extends PlayableFighter{
	public Namekian(String name, int level, int xp, int targetXp, int maxHealthPoints,
			int blastDamage, int physicalDamage, int abilityPoints, int maxKi, int maxStamina,
			ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack> ultimateAttacks)
	{
		super(name,level,xp,targetXp,maxHealthPoints,blastDamage,physicalDamage,abilityPoints,maxKi,maxStamina,superAttacks,ultimateAttacks);
	

	}
	public Namekian(String name)
	{
		super(name,1350,0,50,3,5,new ArrayList<SuperAttack> (),new ArrayList<UltimateAttack> ());


	}
	@Override
	public void onAttackerTurn() {
		// TODO Auto-generated method stub
		setStamina(getStamina()+1 );
		setHealthPoints(getHealthPoints()+50);
	}
	@Override
	public void onDefenderTurn() {
		// TODO Auto-generated method stub
		setStamina(getStamina()+1 );
		setHealthPoints(getHealthPoints()+50);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ " Type : Namekian  ";
	}
}
