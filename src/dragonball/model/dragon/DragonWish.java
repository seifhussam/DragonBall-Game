package dragonball.model.dragon;

import java.util.EventObject;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class DragonWish extends EventObject {
private DragonWishType type ; 
private int senzuBeans ; 
private int abilityPoints ; 
private SuperAttack superAttack ;
private UltimateAttack ultimateAttack ; 

	public DragonWishType getType() {
	return type;
}

public int getSenzuBeans() {
	return senzuBeans;
}

public int getAbilityPoints() {
	return abilityPoints;
}

public SuperAttack getSuperAttack() {
	return superAttack;
}

public UltimateAttack getUltimateAttack() {
	return ultimateAttack;
}

	public DragonWish(Dragon dragon, DragonWishType type) {
		super(dragon);
		this.type = type ;
		// TODO Auto-generated constructor stub
	}
	public DragonWish(Dragon dragon, DragonWishType type, int senzuBeansOrAbilityPoints){
		this(dragon, type);
		if(type.equals(DragonWishType.ABILITY_POINTS))
			this.abilityPoints = senzuBeansOrAbilityPoints ; 
		else 
			this.senzuBeans = senzuBeansOrAbilityPoints;
	}
	public DragonWish(Dragon dragon, DragonWishType type, SuperAttack superAttack){
		this(dragon, type);
		this.superAttack = superAttack;
	}
	public DragonWish(Dragon dragon, DragonWishType type, UltimateAttack ultimateAttack){
		this(dragon, type); 
		this.ultimateAttack= ultimateAttack;
	}
}
