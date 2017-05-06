package dragonball.model.world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import dragonball.model.battle.Battle;
import dragonball.model.cell.Cell;
import dragonball.model.cell.CellListener;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.CollectibleCell;
import dragonball.model.cell.EmptyCell;
import dragonball.model.cell.FoeCell;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.player.Player;

public class World implements CellListener, Serializable{
	private WorldListener worldListener ; 
private Cell [] [] map ; 
private  int  playerColumn ;
private   int  playerRow ; 
public World () {
	this.playerColumn = 9 ;
	this.playerRow=9;
	this.map= new Cell [10] [10] ;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
		map[i][j]= new EmptyCell();		
		}
	}
	for (int i = 0; i < this.getMap().length; i++) {
		for (int j = 0; j < this.getMap()[i].length; j++) {
			this.getMap()[i][j].setCellListener(this);
		}
	}

	
}

public void setWorldListener(WorldListener worldListener) {
	this.worldListener = worldListener;
}

public WorldListener getWorldListener() {
	return worldListener;
}

public Cell[][] getMap() {
	return map;
}

public int getPlayerColumn() {
	return playerColumn;
}

public int getPlayerRow() {
	return playerRow;
}
public void setPlayerColumn(int playerColumn) {
	this.playerColumn = playerColumn;
}

public void setPlayerRow(int playerRow) {
	this.playerRow = playerRow;
}

private static int randomFoes(ArrayList<NonPlayableFighter>  Foes) {
	int x = Foes.size();
	return (int) (Math.random()*x) ;  
}
private static int randomCell() {
	return (int) (Math.random() * 9) + 1 ; 
}
public void generateMap(ArrayList<NonPlayableFighter> weakFoes, ArrayList<NonPlayableFighter> strongFoes) {
	
	for (int i = 0; i < this.getMap().length; i++) {
		for (int j = 0; j < this.getMap()[i].length; j++) {
			this.getMap()[i][j].setCellListener(this);
		}
	}
	boolean [] [] b = new boolean [10] [10] ; 
	
	b[0][0] = true ; 
	FoeCell temp1 = new FoeCell(strongFoes.get(randomFoes(strongFoes))); 
     map [0][0] = temp1  ; 
	b[9][9] = true ; 
	
	int NumberOfWeakFoes = 15 ; 
	while(NumberOfWeakFoes -- > 0 ) {
		 int x = randomCell();
		 int y = randomCell() ;
		while (b[x][y]) {
			  x = randomCell(); 
			  y = randomCell();
			
		}
		
		FoeCell temp = new FoeCell(weakFoes.get(randomFoes(weakFoes))); 
	     map [x][y] = temp  ; 
		b[x][y] = true ; 
	} 
	
	int NumberOfSenzuBeans =(int) (Math.random()*3 ) +3  ;
	while (NumberOfSenzuBeans-- >0 ) {
		int x = randomCell(); 
		int y = randomCell() ; 
		while (b[x][y] ) {
			 x = randomCell(); 
			 y = randomCell() ; 
		}
		b[x][y] = true ; 
		CollectibleCell temp = new CollectibleCell(Collectible.SENZU_BEAN) ; 
		map [x][y]=temp  ;
	}

	int x = randomCell(); 
	int y = randomCell() ; 
	while (b[x][y] ) {
		 x = randomCell(); 
		 y = randomCell() ; 
	}
	b[x][y] = true ; 
	CollectibleCell temp = new CollectibleCell(Collectible.DRAGON_BALL) ; 
	map [x][y]=temp  ;
	
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
	String s = "" ; 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				s+=map[i][j];
				// Shazly 7ataha 
			}
			s+= "\n";
		}
		return s ; 
	}
public void resetPlayerPosition() {
	this.playerColumn = 9 ; 
	this.playerRow = 9 ; 
}
public void moveUp() {
	playerRow -- ;
	if (playerRow < 0 ) {
		playerRow = 0 ; 
		throw new MapIndexOutOfBoundsException("map["+playerRow+"] ["+playerColumn+"] ",playerRow, playerColumn);
	}
	map[playerRow][playerColumn].setCellListener(this);
	map[playerRow][playerColumn].onStep();
}
public void moveDown() {
	playerRow ++ ;
	if (playerRow > 9 ) {
		playerRow = 9 ; 
		throw new MapIndexOutOfBoundsException("map["+playerRow+"] ["+playerColumn+"] ",playerRow, playerColumn);
		
	}
	map[playerRow][playerColumn].setCellListener(this);
	map[playerRow][playerColumn].onStep();
}
public void moveLeft() {
	playerColumn--;
	if(playerColumn< 0 ) {
		playerColumn =0 ; 
		throw new MapIndexOutOfBoundsException("map["+playerRow+"] ["+playerColumn+"] ",playerRow, playerColumn);
	}
	map[playerRow][playerColumn].setCellListener(this);
	map[playerRow][playerColumn].onStep();
}
public void  moveRight() {
	playerColumn++;
	if(playerColumn> 9) {
		playerColumn =9 ; 
		throw new MapIndexOutOfBoundsException("map["+playerRow+"] ["+playerColumn+"] ",playerRow, playerColumn);
	}
	map[playerRow][playerColumn].setCellListener(this);
	map[playerRow][playerColumn].onStep();

}
@Override
public void onFoeEncountered(NonPlayableFighter foe) {
	// TODO Auto-generated method stub
 
	if (worldListener!=null)
	worldListener.onFoeEncountered(foe);
	
}

@Override
public void onCollectibleFound(Collectible collectible) {
	// TODO Auto-generated method stub
	if(worldListener!=null)
	worldListener.onCollectibleFound(collectible);
	
	map[playerRow][playerColumn] = new EmptyCell();
}

}


