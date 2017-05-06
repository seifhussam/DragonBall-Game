 package dragonball.model.cell;

import java.io.Serializable;

abstract public class Cell implements Serializable {
	//ToString Should be overridden in all sub- classes of Cell
	private CellListener cellListener ;
	@Override
	abstract public String toString();
	 abstract public void onStep() ; 
	public CellListener getCellListener() {
		return cellListener;
	}
	public void setCellListener(CellListener cellListener) {
		this.cellListener = cellListener;
	}
	
	
}
