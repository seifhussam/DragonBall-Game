package dragonball.model.battle;

import java.io.Serializable;
import java.util.ArrayList;

import dragonball.model.attack.Attack;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.player.Player;
import dragonball.view.AudioFilePlayer;

public class Battle implements Serializable {
private BattleOpponent me ;
private BattleOpponent foe ; 
private BattleOpponent attacker ;
private boolean meBlocking ; 
private boolean foeBlocking;
private BattleListener Listener ;
private int blockednumber ; 

public void setMe(BattleOpponent me) {
	this.me = me;
	 attacker = me ;
}

public void setFoe(BattleOpponent foe) {
	this.foe = foe;
}

public BattleListener getListener() {
	return Listener;
}

public void setListener(BattleListener listener) {
	Listener = listener;
}

public boolean isMeBlocking() {
	return meBlocking;
}
public boolean isFoeBlocking() {
	return foeBlocking;
}
public Battle(BattleOpponent me ,BattleOpponent foe ) {
	// TODO Auto-generated constructor stub
	Fighter m = (Fighter) me ; 
	
	m.setHealthPoints(m.getMaxHealthPoints());
	m.setStamina(m.getMaxStamina());
	m.setKi(0);
	if (m instanceof Saiyan) {
			((Saiyan)m).setTransformed(false);
	} 
	this.me = m ; 
	Fighter m1 = (Fighter) foe ; 

	m1.setHealthPoints(m1.getMaxHealthPoints());
	m1.setStamina(m1.getMaxStamina());
	m1.setKi(0);
	if (m1 instanceof Saiyan) {
		((Saiyan)m1).setTransformed(false);
	
} 
	blockednumber = 0 ; 
	this.foe = m1 ; 
	 attacker = me ;
}
public ArrayList<Attack> getAssignedAttacks() {
	ArrayList<Attack> Attacks = new ArrayList<Attack>();
	Fighter current = (Fighter) attacker ; 
	Attacks.add(new PhysicalAttack()) ; 
	Attacks.addAll(current.getSuperAttacks()) ; 
	Attacks.addAll(current.getUltimateAttacks()) ; 
	return Attacks ; 
}
public ArrayList<Attack> getAssignedFoeAttacks(int foeKi) {
	ArrayList<Attack> Attacks = new ArrayList<Attack>();
	Fighter current = (Fighter) foe ; 
	Attacks.add(new PhysicalAttack()) ; 
	if (foeKi >0){
	Attacks.addAll(current.getSuperAttacks()) ; 
	}
	if(foeKi>2){
	Attacks.addAll(current.getUltimateAttacks()) ; 
	}
	return Attacks ; 
}

public void attack(Attack attack) throws NotEnoughKiException {
	if(getAttacker() == me )
	attack.onUse(me, foe, isFoeBlocking());
	else 
		attack.onUse(foe, me, isMeBlocking());
	
	if(Listener!=null){
		
		Listener.onBattleEvent( new BattleEvent(this, BattleEventType.ATTACK ,attack ) ); 
	}
	endTurn();
	
	
}
public void block (){
	if (getAttacker()== me )
	meBlocking = true ; 
	else 
		foeBlocking = true ; 
	
	if(Listener!=null)
		Listener.onBattleEvent(new BattleEvent(this, BattleEventType.BLOCK));
	endTurn();
}
public void use(Player player , Collectible collectible) throws NotEnoughSenzuBeansException {
	if(player.getSenzuBeans()>0 ) {
		AudioFilePlayer.ButtonPressed();
		player.setSenzuBeans(player.getSenzuBeans()-1 );
		((Fighter) getAttacker()).setStamina(player.getActiveFighter().getMaxStamina());
		((Fighter) getAttacker()).setHealthPoints(player.getActiveFighter().getMaxHealthPoints());
	if(Listener!=null)
		Listener.onBattleEvent(new BattleEvent(this, BattleEventType.USE, collectible));
	
	endTurn();
	}
	else {
		throw new NotEnoughSenzuBeansException() ; 
	}
}
public BattleOpponent getDefender () {
	if(attacker==me) 
		return foe ; 
	else 
		return me ; 
}

private Attack GetBestAttack (ArrayList<Attack> attacks, BattleOpponent b) {
	int bestDamage = attacks.get(0).getAppliedDamage(b) ; 
	Attack best = attacks.get(0) ; 
	for (int i = 1; i <attacks.size(); i++) {
		if (attacks.get(i).getAppliedDamage(b) > bestDamage ) {
			best = attacks.get(i); 
		}
	}
	return best ; 
 }



private UltimateAttack GetBestUAttack(ArrayList<UltimateAttack> ultimateAttacks,
		Fighter b) {
	if (ultimateAttacks.size()>0) {
	int bestDamage = ultimateAttacks.get(0).getAppliedDamage(b) ; 
	UltimateAttack best = ultimateAttacks.get(0) ; 
	for (int i = 1; i <ultimateAttacks.size(); i++) {
		if (ultimateAttacks.get(i).getAppliedDamage(b) > bestDamage ) {
			best = ultimateAttacks.get(i); 
		}
	}
	return best ; 
	} 
	return null ; 
}
private SuperAttack GetBestSAttack(ArrayList<SuperAttack> superAttacks,
		Fighter b) {
	if(superAttacks.size()> 0 ){
	int bestDamage = superAttacks.get(0).getAppliedDamage(b) ; 
	SuperAttack best = superAttacks.get(0) ; 
for (int i = 1; i <superAttacks.size(); i++) {
		if (superAttacks.get(i).getAppliedDamage(b) > bestDamage ) {
			best = superAttacks.get(i); 
		}
	}
	return best ; 
	
	}
	return null ; 
}

public void play () throws NotEnoughKiException { 
	
//	ArrayList<Attack> foeAttacks = getAssignedAttacks() ;  
//	int random = (int) ((Math.random() * (foeAttacks.size())  )) +1;
//	if (random == foeAttacks.size()) 
//		block() ; 
//	
//	else {
//		
//		Attack a = foeAttacks.get(random) ; 
//		if  ( a instanceof MaximumCharge) {
//			 attack(new MaximumCharge()) ;  
//		} else if (a instanceof SuperAttack) {
//			attack(new SuperAttack(a.getName(), a.getDamage())) ;
//		}
//		else if ( a instanceof SuperSaiyan){
//			attack(new SuperSaiyan()) ;  
//		}
//		else if (a instanceof UltimateAttack ) {
//			attack(new UltimateAttack(a.getName(), a.getDamage())); 
//		} 
//		else 
//			attack(new PhysicalAttack());
//		
//	}
//}
	
	Fighter foe = (Fighter) this.foe ; 
	Fighter me = (Fighter) this.me ; 
	int meKi = me.getKi() ; 
	if(me instanceof Earthling ) 
		meKi ++ ;
 
	ArrayList<Attack> AvaibleMe = getAssignedFoeAttacks(meKi) ; 
	Attack bestMe = GetBestAttack(AvaibleMe, me) ; 
SuperAttack Superfoe = GetBestSAttack(foe.getSuperAttacks(), foe) ; 
	UltimateAttack Ultimatefoe = GetBestUAttack(foe.getUltimateAttacks(), foe);
	int PhysicalFoe = new PhysicalAttack().getAppliedDamage(foe) ; 
	ArrayList <Attack> foea = new ArrayList<Attack>();
	foea.addAll(foe.getSuperAttacks()) ;
	foea.addAll(foe.getUltimateAttacks()) ;
	foea.add(new PhysicalAttack());
	int SuperFoeAttack = 0 ; 
	if (Superfoe!= null)
	 SuperFoeAttack = Superfoe.getAppliedDamage(foe) ; 
	int UltimateFoeAttack = 0 ; 
	if (Ultimatefoe!= null)
	 UltimateFoeAttack = Ultimatefoe.getAppliedDamage(foe) ; 
	double ratio = 2 ;
	if(UltimateFoeAttack!=0)
	 ratio = (2*SuperFoeAttack+2*new PhysicalAttack().getAppliedDamage(foe)) / (UltimateFoeAttack+3*new PhysicalAttack().getAppliedDamage(foe)) ; 
	int foeStamina = foe.getStamina();
	foeStamina =  foe.getStamina()<foe.getMaxStamina() ? foeStamina+1 : foeStamina ; 
	int mybestDamage = bestMe.getAppliedDamage(me) ; 
  	int blockedHealh = foe.getHealthPoints() + (100*foe.getStamina()) ; 
 	int meHP = me.getHealthPoints() ; 
 	int meBlock = 100*me.getStamina () ; 
 	if (meBlocking) {
 		meHP += (100*me.getStamina()) ; 
 	}
// 	System.out.println("-----------------------------------------------------"); 
// 	System.out.println("Foe Health : " + foe.getHealthPoints()); 
// 	System.out.println("Foe Blocked Health "+blockedHealh); 
// 	System.out.println("My Best Attack Damage "+mybestDamage );
// 
// 	
 	
 	if ((blockedHealh>mybestDamage&& foe.getHealthPoints()<mybestDamage) &&(!canbeDefeated(foea, meHP)) && blockednumber < 4){
 		block() ; 
 		if(Listener!=null)
 			Listener.onBattleEvent(new BattleEvent(this, BattleEventType.BLOCK));
 	  blockednumber ++ ; 

 	  return ;
 		
 	} else if (containsSuperSaiyan(foe.getUltimateAttacks()) && !(UltimateFoeAttack >= meHP || SuperFoeAttack >=meHP) && foe.getStamina() > foe.getMaxStamina()/2 && foe.getKi()>2  ) {
			BattleEvent E2 = new BattleEvent(this,BattleEventType.ATTACK, new SuperSaiyan()); 
			attack(new SuperSaiyan());
		 	 blockednumber = 0 ;
			 return ;
		} 
 	else 	if (foe.getKi() < 3 && containsMaximumCharge(foe.getSuperAttacks() ) && !(UltimateFoeAttack >= meHP || SuperFoeAttack >=meHP) ){
			BattleEvent E = new BattleEvent (this, BattleEventType.ATTACK , new MaximumCharge()) ; 
			attack(new MaximumCharge());
		 	 blockednumber = 0 ;
			 return ;
		 
		} 
 	else if (ratio >=  1 ){
	 if ( UltimateFoeAttack >= meHP && foe.getKi() > 2 && Ultimatefoe!= null ) {
 		BattleEvent E = new BattleEvent(this, BattleEventType.ATTACK, Ultimatefoe) ; 
 		attack(Ultimatefoe);
 	 	 blockednumber = 0 ;
 		 return ;
 	
 	}   else if (((meBlocking && !canbeDefeated(AvaibleMe, meHP) ) && SuperFoeAttack <meBlock) || foe.getKi() == 0  ) { 
		BattleEvent E = new BattleEvent (this, BattleEventType.ATTACK, new PhysicalAttack()) ; 
			attack(new PhysicalAttack());
		 	 blockednumber = 0 ;
			 return ;
		}
	else
		if (foe.getKi() != 0 && Superfoe!= null) {
        	attack(Superfoe);
        	 blockednumber = 0 ;
			 return ;
				
 			
 		}  
 		
 		
 	}
		
 	 else {
 		

 		if ( foe.getKi() > 0 && SuperFoeAttack >= meHP && Superfoe != null) {
 			BattleEvent E = new BattleEvent (this , BattleEventType.ATTACK , Superfoe) ;
 			attack(Superfoe);
 		 	 blockednumber = 0 ;
 			 return ;
 			//if(Listener!=null)
				//Listener.onBattleEvent(E);
 		}
 		else  if ((meBlocking && ! canbeDefeated(AvaibleMe, meHP) && UltimateFoeAttack < meBlock  )|| foe.getKi() < 2 ) {
	 			BattleEvent E1 = new BattleEvent (this, BattleEventType.ATTACK, new PhysicalAttack()) ; 
	attack(new PhysicalAttack()) ; 
	 blockednumber = 0 ;
	 return ;
	//if(Listener!=null)
	//Listener.onBattleEvent(E1);
	}
 			
 		else if (foe.getKi() >2 && Ultimatefoe != null ) {
 			BattleEvent E = new BattleEvent(this, BattleEventType.ATTACK, Ultimatefoe) ; 
 			attack(Ultimatefoe);
 		 	 blockednumber = 0 ;
			//if(Listener!=null){
 			//Listener.onBattleEvent(E);
 		//}
 		
 			 return ;
 		
 	}
 		
 	}
 	 
 	
			attack(new PhysicalAttack()) ; 
		 	 blockednumber = 0 ;
		
 	}
	
private  boolean canbeDefeated(ArrayList<Attack> a , int Health) { 
	for (int i = 0; i < a.size(); i++) {
		if (a.get(i).getAppliedDamage(foe) >= Health) {
			return true ; 
		}
	}
	return false ;
}

private static boolean containsMaximumCharge(ArrayList<SuperAttack> superAttacks) {
	for (int i = 0; i < superAttacks.size(); i++) {
		if (superAttacks.get(i) instanceof MaximumCharge)
			return true ; 
	}
	return false ; 
}
private static boolean containsSuperSaiyan(ArrayList<UltimateAttack> ultimateAttacks) {
	for (int i = 0; i < ultimateAttacks.size(); i++) {
		if (ultimateAttacks.get(i) instanceof SuperSaiyan)
			return true ; 
	}
	return false ; 
}

public void start() {
  
	BattleEvent E = new BattleEvent(this, BattleEventType.STARTED) ; 
	if(Listener!= null)	{
		Listener.onBattleEvent(E);
	}else {
		
	}
}
public void switchTurn () { 
if (me==attacker) {
	attacker = foe ; 
	foeBlocking = false ; 
}
else {
	attacker = me ; 
	meBlocking = false ; 
}

}

public void endTurn () {
	switchTurn();
	if (((Fighter)me).getHealthPoints() <= 0) {
		BattleEvent E = new BattleEvent(this, BattleEventType.ENDED, foe) ; 
		if(Listener!= null)
			Listener.onBattleEvent(E);
	}
	else if (((Fighter)foe).getHealthPoints() <= 0) {
		BattleEvent E = new BattleEvent(this, BattleEventType.ENDED, me) ; 
		if(Listener!= null)
			Listener.onBattleEvent(E);
	}
	else {
		if (attacker.equals(foe)){
			
			foeBlocking = false ; 
			me.onDefenderTurn();
			foe.onAttackerTurn();
			
		}
		else {
			
			meBlocking= false ; 
			me.onAttackerTurn();
			foe.onDefenderTurn();
			
		}
		BattleEvent E = new BattleEvent(this, BattleEventType.NEW_TURN);
		if(Listener!= null)
			Listener.onBattleEvent(E);
	}
}

public BattleOpponent getMe() {
	return me;
}
public BattleOpponent getFoe() {
	return foe;
}
public BattleOpponent getAttacker() {
	return attacker;
}



}
