package edu.ycp.cs496.model;

import java.util.ArrayList;
import java.util.List;

public class Map {
	// 0 is blank space, 1 is player starting location, 2 is collectible location, 3 is starting location for an enemy, 4 is a finishing point
	int [][] mapArray;
	int levelNumber;
	int GRID_SIZE = 10;
	
	public Map (int levelNumber, ArrayList<Enemy> EnemiesList){
		mapArray = loadMap(levelNumber, EnemiesList);
		this.levelNumber = levelNumber;
		EnemiesList = new ArrayList<Enemy>();
	}
	
	public void setMapArray(int [][] mapArray){
		this.mapArray = mapArray;
	}
	
	public void setLevelNumber(int levelNumber){
		this.levelNumber = levelNumber;
	}
	
	public int[][] getMapArray(){
		return mapArray;
	}
	
	public int getLevelNumber(){
		return levelNumber;
	}
	
	public Location getPlayerStartingLocation(){
		for(int i = 0; i < mapArray.length; i++){
			for(int j = 0; j < mapArray[i].length; j++){
				if (mapArray[i][j] == Terrain.PLAYER.getValue()){
					return new Location(i, j);
				}
			}
		}
		// this shouldn't happen because every map should have a starting location for a player
		return null;
	}
	
	public ArrayList<Collectible> getCollectibleList(){
		ArrayList<Collectible> list = new ArrayList<Collectible>();
		for(int i = 0; i < mapArray.length; i++){
			for(int j = 0; j < mapArray[i].length; j++){
				if (mapArray[i][j] == Terrain.COLLECTIBLE.getValue()){
					list.add(new Collectible(new Location(i, j)));
				}
			}
		}
		return list;
	}
	
	/*public ArrayList<Enemy> getEnemyList(){
		ArrayList<Enemy> list = new ArrayList<Enemy>();
		// set the starting location of the enemies
		for(int i = 0; i < mapArray.length; i++){
			for(int j = 0; j < mapArray[i].length; j++){
				if (mapArray[i][j] == Terrain.ENEMY.getValue()){
					list.add(new Enemy(new Location(i, j), null));
				}
			}
		}
		
		// TODO: set the array of locations for each enemy
		
		
		
		return list;
	}*/
	
	public boolean isFinishingPoint(Location loc){
		if (mapArray[loc.getX()][loc.getY()] == Terrain.FINISH.getValue()){
			return true;
		}
		return false;
	}
	
	private int[][] loadMap(int levelNumber, ArrayList<Enemy> EnemiesList) {
		//TODO
		Location startLoc;		//Keep track of enemy starting location and move locations
		List<Location> moveLoc = new ArrayList<Location>();
		
		mapArray = new int[GRID_SIZE][GRID_SIZE];	//Initialize the map
		
		for(int i = 0; i < GRID_SIZE; i ++)
		{
			for(int j = 0; j < GRID_SIZE; j ++)
			{
				mapArray[i][j] = Terrain.BLANK.getValue();
			}
		}
		
		//load appropriate array based on levelNumber
		
		//The map creation will have to be hard code - they are set for a 10x10 grid_size
		//(0,0) is the bottom left corner - Cartesian
		switch(levelNumber){
			case 1:
				for(int i = 0; i < 2; i ++)
				{
					for(int j = 0; j < GRID_SIZE; j ++)
					{
						mapArray[i][j] = Terrain.PATH.getValue();
					}
				}
				for(int i = 0; i < 2; i ++)
				{
					for(int j = 2; j < GRID_SIZE; j ++)
					{
						mapArray[j][i] = Terrain.PATH.getValue();
					}
				}
				mapArray[0][9] = Terrain.PLAYER.getValue();
				
				mapArray[0][5] = Terrain.ENEMY.getValue();
				startLoc = new Location(0, 5);
				moveLoc.add(startLoc);
				moveLoc.add(new Location(1, 5));
				EnemiesList.add(new Enemy(startLoc, moveLoc));
				
				mapArray[3][1] = Terrain.ENEMY.getValue();
				startLoc = new Location(3, 1);
				moveLoc.add(startLoc);
				moveLoc.add(new Location(3, 0));
				EnemiesList.add(new Enemy(startLoc, moveLoc));
				
				mapArray[9][0] = Terrain.FINISH.getValue();
				break;
			case 2:
				
				break;
			default:
				break;		
			//etc ... 
		}
		return null;
		
	}
}
