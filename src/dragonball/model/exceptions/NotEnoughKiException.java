package dragonball.model.exceptions;

public class NotEnoughKiException extends NotEnoughResourcesException {
	private int availableKi ; 
	private int requiredKi;
	public NotEnoughKiException(int r ,int a ) {
		// TODO Auto-generated constructor stub
		super("NotEnoughKiException  "+ r + " "+a ) ; 
		availableKi= a ; 
		requiredKi = r ; 
	}
	public NotEnoughKiException() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getAvailableKi() {
		return availableKi;
	}
	
	public int getRequiredKi() {
		return requiredKi;
	}
	

}
