package dragonball.model.character.fighter;

import java.util.ArrayList;



import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Saiyan extends PlayableFighter{
	private boolean transformed;
	public Saiyan(String name, int level, int xp, int targetXp, int maxHealthPoints,
			int blastDamage, int physicalDamage, int abilityPoints, int maxKi, int maxStamina,
			ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack> ultimateAttacks)
	{
		super(name,level,xp,targetXp,maxHealthPoints,blastDamage,physicalDamage,abilityPoints,maxKi,maxStamina,superAttacks,ultimateAttacks);

	}
	public Saiyan(String name)
	{
		super(name,1000,150,100,5,3,new ArrayList<SuperAttack> (),new ArrayList<UltimateAttack> ());
		

	}
	public boolean isTransformed() {
		return transformed;
	}
	public void setTransformed(boolean transformed) {
		this.transformed = transformed;
	}
	@Override
	public void onAttackerTurn() {
		// TODO Auto-generated method stub
		if(transformed){
			setKi(getKi()-1) ;
			setStamina(getStamina()+1);
			if (getKi()== 0 ){
				setStamina(0);
			    transformed = false  ; 
			}
		}
		else 
			setStamina(getStamina()+1);
	}
	@Override
	public void onDefenderTurn() {
		// TODO Auto-generated method stub
		
		if(transformed){
			setKi(getKi()-1) ;
			setStamina(getStamina()+1);
			if (getKi()== 0 ){
				setStamina(0);
			    transformed = false  ; 
			}
		}
		else 
			setStamina(getStamina()+1);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ " Type : Saiyan  ";
	}
}
