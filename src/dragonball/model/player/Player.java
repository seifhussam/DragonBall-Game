package dragonball.model.player;

import java.io.Serializable;
import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;

public class Player implements Serializable {
private PlayerListener playerListener ; 
private String name ; 
private ArrayList<PlayableFighter> fighters ; 
private ArrayList<UltimateAttack> ultimateAttacks;
private int senzuBeans ; 
private int dragonBalls ;
private PlayableFighter activeFighter ; 
private int exploredMaps ; 
private ArrayList<SuperAttack> superAttacks ; 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<PlayableFighter> getFighters() {
	return fighters;
}
public void setFighters(ArrayList<PlayableFighter> fighters) {
	this.fighters = fighters;
}
public ArrayList<SuperAttack> getSuperAttacks() {
	return superAttacks;
}
public void setSuperAttacks(ArrayList<SuperAttack> superAttacks) {
	this.superAttacks = superAttacks;
}
public ArrayList<UltimateAttack> getUltimateAttacks() {
	return ultimateAttacks;
}
public void setUltimateAttacks(ArrayList<UltimateAttack> ultimateAttacks) {
	this.ultimateAttacks = ultimateAttacks;
}
public int getSenzuBeans() {
	return senzuBeans;
}

public void setSenzuBeans(int senzuBeans) {
	this.senzuBeans = senzuBeans;
}
public int getDragonBalls() {
	return dragonBalls;
}
public void setDragonBalls(int dragonBalls) {
	this.dragonBalls = dragonBalls;
}
public PlayableFighter getActiveFighter() {
	return activeFighter;
}
public void setActiveFighter(PlayableFighter activeFighter) {
	this.activeFighter = activeFighter;
}
public int getExploredMaps() {
	return exploredMaps;
}
public void setExploredMaps(int exploredMaps) {
	this.exploredMaps = exploredMaps;
}
public Player(String name, ArrayList<PlayableFighter> fighters ,	ArrayList<SuperAttack>
superAttacks, ArrayList<UltimateAttack> ultimateAttacks, int senzuBeans, int dragonBalls,
PlayableFighter activeFighter, int exploredMaps) {
	this.name = name ; 
	this.fighters = fighters ; 
	this.superAttacks = superAttacks ; 
	this.ultimateAttacks = ultimateAttacks;
	this.senzuBeans = senzuBeans ; 
	this.dragonBalls = dragonBalls ; 
	this.activeFighter = activeFighter ; 
	this.exploredMaps =exploredMaps ; 
}
public Player (String name){
	this.name= name ; 
	fighters = new ArrayList<PlayableFighter>() ; 
	superAttacks = new ArrayList<SuperAttack>();
	ultimateAttacks = new ArrayList<UltimateAttack>() ; 
	
	senzuBeans =0 ; 
	dragonBalls = 0 ; 
	exploredMaps = 0 ;
}
public int getMaxFighterLevel(){
	int maxlevel = fighters.get(0).getLevel() ; 
	for (int i = 1; i < fighters.size() ; i++) {
		if (maxlevel<fighters.get(i).getLevel())
			maxlevel = fighters.get(i).getLevel() ; 
	}
	return maxlevel ;
}
public void callDragon () {
	this.dragonBalls = 0 ;
	if(playerListener!=null){
	playerListener.onDragonCalled();
	
	}
}
public void chooseWish(DragonWish wish) {
	if (wish.getType().equals(DragonWishType.ABILITY_POINTS))
		activeFighter.setAbilityPoints(activeFighter.getAbilityPoints()+wish.getAbilityPoints()) ; 
	if (wish.getType().equals(DragonWishType.SENZU_BEANS))
		this.senzuBeans+= wish.getSenzuBeans() ; 
	if (wish.getType().equals(DragonWishType.SUPER_ATTACK))
		this.superAttacks.add(wish.getSuperAttack()) ; 
	else if(wish.getType().equals(DragonWishType.ULTIMATE_ATTACK))
		this.ultimateAttacks.add(wish.getUltimateAttack()) ; 
	if(playerListener!= null)
	playerListener.onWishChosen(wish);
}
public void createFighter(char race , String name ) {
	PlayableFighter f = null;
	switch (race) {
	case 'E' : f = new Earthling(name) ; break ; 
	case 'S' : f = new Saiyan(name) ; break ;
	case 'N' :f = new Namekian(name) ; break ; 
	case 'F' :f = new Frieza(name) ; break ; 
	case 'M' :f = new Majin(name) ; break ;
		
	}

	
	if (!fighters.contains(f))
	fighters.add(f) ; 
	if (fighters.size()==1) 
		activeFighter = f ;
	
}
public void upgradeFighter (PlayableFighter fighter , char fighterAttribute ) throws NotEnoughAbilityPointsException {
	if(fighter.getAbilityPoints()>0){
	int i ; 
	for (i = 0; i < fighters.size(); i++) {
		if(fighters.get(i).getName().equals(fighter.getName()))
			break ;
	}
	switch(fighterAttribute) {
	case'H':fighters.get(i).setMaxHealthPoints(fighters.get(i).getMaxHealthPoints()+50);break;
	case'B':fighters.get(i).setBlastDamage(fighters.get(i).getBlastDamage()+50);break;
	case'P':fighters.get(i).setPhysicalDamage(fighters.get(i).getPhysicalDamage()+50);break;
	case'K':fighters.get(i).setMaxKi(fighters.get(i).getMaxKi()+1);break;
	case'S':fighters.get(i).setMaxStamina(fighters.get(i).getMaxStamina()+1);break;
	}
	fighters.get(i).setAbilityPoints(fighters.get(i).getAbilityPoints()-1);
	}
	else {
		throw new NotEnoughAbilityPointsException() ;
	}
}
public void assignAttack(PlayableFighter fighter , SuperAttack newAttack , SuperAttack oldAttack) throws DuplicateAttackException, MaximumAttacksLearnedException {
	for (int i = 0; i < fighter.getSuperAttacks().size(); i++) {
		if (newAttack.getName().equals(fighter.getSuperAttacks().get(i).getName()) &&
				newAttack.getDamage() == fighter.getSuperAttacks().get(i).getDamage()){
			
		
			throw new DuplicateAttackException(newAttack);
	}}

	if (fighter.getSuperAttacks().size()>= 4 && oldAttack == null ){
		throw new MaximumAttacksLearnedException();
	}
	if (oldAttack==null) {
		fighter.getSuperAttacks().add(newAttack);
	}
else {
	ArrayList<SuperAttack > s =  fighter.getSuperAttacks() ; 
	for (int i = 0; i < fighter.getSuperAttacks().size() ; i++) {
	if (s.get(i).equals(oldAttack))	{
		s.remove(i);
		if (s.size()<4){
		s.add(newAttack);
		break ; 
		}
	}
 	}
	
}
}
public void assignAttack(PlayableFighter fighter , UltimateAttack newAttack , UltimateAttack oldAttack) throws NotASaiyanException, DuplicateAttackException, MaximumAttacksLearnedException {
	if (! (fighter instanceof Saiyan)){
		if (newAttack instanceof SuperSaiyan){
			throw new NotASaiyanException() ; 
		}
	}
	for (int i = 0; i < fighter.getUltimateAttacks().size(); i++) {
		if (newAttack.getName().equals(fighter.getUltimateAttacks().get(i).getName()) &&
				newAttack.getDamage() == fighter.getUltimateAttacks().get(i).getDamage()){
			
		
			throw new DuplicateAttackException(newAttack);
	}
		}
	if (fighter.getUltimateAttacks().size()>= 2 && oldAttack == null ){
		throw new MaximumAttacksLearnedException();
	}
	if (oldAttack==null) {
		fighter.getUltimateAttacks().add(newAttack);
	}
	else {
		ArrayList<UltimateAttack > s =  fighter.getUltimateAttacks() ; 
		for (int i = 0; i < fighter.getUltimateAttacks().size() ; i++) {
		if (s.get(i).equals(oldAttack))	{
			s.remove(i);
			if (s.size()<2){
			s.add(newAttack);
			break ; 
			}
		}
	 	}
		
	}
}
public PlayerListener getPlayerListener() {
	return playerListener;
}
public void setPlayerListener(PlayerListener playerListener) {
	this.playerListener = playerListener;
}

}
