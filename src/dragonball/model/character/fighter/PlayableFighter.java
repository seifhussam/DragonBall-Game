package dragonball.model.character.fighter;

import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.character.PlayableCharacter;

abstract public class PlayableFighter extends Fighter implements PlayableCharacter{
	private int xp;
	private int targetXp;
	private int abilityPoints;
	
	public PlayableFighter(String name, int level, int xp, int targetXp, int maxHealthPoints,
			int blastDamage, int physicalDamage, int abilityPoints, int maxKi, int maxStamina,
			ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack> ultimateAttacks)
	{
		super(name,level,maxHealthPoints,blastDamage,physicalDamage,maxKi,maxStamina,superAttacks,ultimateAttacks);
		this.xp=xp;
		this.targetXp=targetXp;
		this.abilityPoints=abilityPoints;
		super.setHealthPoints(maxHealthPoints);
		super.setStamina(maxStamina);
		super.setKi(0);
		
		
	}
	 public PlayableFighter(String name ,int maxHealthPoints, int blastDamage, int physicalDamage,
			int maxKi, int maxStamina, ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack>
			ultimateAttacks)
	{
		super(name,1,maxHealthPoints,blastDamage,physicalDamage,maxKi,maxStamina,superAttacks,ultimateAttacks);
		super.setHealthPoints(maxHealthPoints);
		super.setStamina(maxStamina);
		super.setKi(0);
		this.xp=0;
		this.targetXp=10;
		this.abilityPoints=0;
		
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		while (xp>=targetXp){
			xp=xp-targetXp ; 
			targetXp+= 20 ; 
		    abilityPoints+=2 ;
			setLevel(getLevel()+1);
			
		}
		this.xp= xp;
		
	}
	public int getTargetXp() {
		return targetXp;
	}

	public void setTargetXp(int targetXp) {
		this.targetXp = targetXp;
	}

	public int getAbilityPoints() {
		return abilityPoints;
	}

	public void setAbilityPoints(int abilityPoints) {
		this.abilityPoints = abilityPoints;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : "+getName()+" | Level : "+getLevel() + " |";
	}
}
