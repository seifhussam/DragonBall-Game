package dragonball.model.exceptions;

public class UnknownAttackTypeException extends InvalidFormatException{

	private String unknownType ;

	public String getUnknownType() {
		return unknownType;
	}
	public UnknownAttackTypeException(String sourceFile, int sourceLine ,String type ) {
		super(sourceFile, sourceLine);
		// TODO Auto-generated constructor stub
		this.unknownType = type ; 
	}
public UnknownAttackTypeException(String message, String sourceFile,
		int sourceLine, String type) {
	// TODO Auto-generated constructor stub
	super(message, sourceFile, sourceLine);
	this.unknownType = type ; 
	
}
	

}
