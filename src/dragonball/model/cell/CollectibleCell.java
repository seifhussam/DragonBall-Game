package dragonball.model.cell;

public class CollectibleCell extends Cell {
 private Collectible collectible ; 
 public CollectibleCell(Collectible collectible) {
	// TODO Auto-generated constructor stub
	 this.collectible = collectible ;
}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (collectible.equals(Collectible.SENZU_BEAN))
			return "[s]" ;
		 return "[d]" ;
			
	}
	public Collectible getCollectible() {
		return collectible;
	}
	public void onStep() {
		if(getCellListener()!=null)
		getCellListener().onCollectibleFound(collectible);
	
	}

}
