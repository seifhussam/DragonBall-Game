package dragonball.model.exceptions;

import dragonball.model.attack.Attack;

public class DuplicateAttackException extends InvalidAssignAttackException {
private Attack attack ; 
	public DuplicateAttackException(Attack attack) {
		// TODO Auto-generated constructor stub
		super("DuplicateAttackException");
		this.attack =attack;
	}
	public Attack getAttack() {
		return attack;
	}
	

}
