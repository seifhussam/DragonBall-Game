package dragonball.model.dragon;

import java.io.Serializable;
import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Dragon implements Serializable {
	private String name ; 
	private ArrayList <SuperAttack> superAttacks ; 
	private ArrayList<UltimateAttack> ultimateAttacks ;
	private int senzuBeans ; 
	private int abilityPoints;
	public Dragon(String name , ArrayList<SuperAttack> superAttack , ArrayList<UltimateAttack> ultimateAttack , int senzuBeans , int abilityPoints) {
		// TODO Auto-generated constructor stub
		this.name = name ; 
		this.superAttacks = superAttack ; 
		this.ultimateAttacks = ultimateAttack ;
		this.senzuBeans = senzuBeans ; 
		this.abilityPoints = abilityPoints ; 
	}
	public String getName() {
		return name;
	}
	public ArrayList<SuperAttack> getSuperAttacks() {
		return superAttacks;
	}
	public ArrayList<UltimateAttack> getUltimateAttacks() {
		return ultimateAttacks;
	}
	public int getSenzuBeans() {
		return senzuBeans;
	}
	public int getAbilityPoints() {
		return abilityPoints;
	} 
	
	public DragonWish[] getWishes() {
		DragonWish dragonWish [] = new DragonWish [4] ; 
		DragonWish dw1 = new DragonWish(this, DragonWishType.ABILITY_POINTS, abilityPoints) ; 
		DragonWish dw2 = new DragonWish(this , DragonWishType.SENZU_BEANS,senzuBeans) ; 
		DragonWish dw3 = new DragonWish(this , DragonWishType.SUPER_ATTACK,superAttacks.get((int) (Math.random()* superAttacks.size()))) ; 
		DragonWish dw4 = new DragonWish(this, DragonWishType.ULTIMATE_ATTACK, ultimateAttacks.get((int) (Math.random()* ultimateAttacks.size()))) ; 
		dragonWish[0] = dw1 ; 
		dragonWish[1] = dw2 ; 
		dragonWish[2] = dw3 ; 
		dragonWish[3] = dw4 ; 
		return dragonWish ; 
	}

}
