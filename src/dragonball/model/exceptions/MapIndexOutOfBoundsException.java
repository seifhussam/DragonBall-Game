package dragonball.model.exceptions;

public class MapIndexOutOfBoundsException extends IndexOutOfBoundsException {
private int row ;
private int column ; 
	public MapIndexOutOfBoundsException(int x ,int y ) {
		// TODO Auto-generated constructor stub
		super();
		row = x ; 
		column = y ; 
	}
	public MapIndexOutOfBoundsException(String message , int x ,int y ) {
		// TODO Auto-generated constructor stub
		super(message);
		row = x ; 
		column = y ; 
	}
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
	

}
