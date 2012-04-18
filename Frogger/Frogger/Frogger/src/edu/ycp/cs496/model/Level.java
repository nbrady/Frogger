package edu.ycp.cs496.model;

import java.util.ArrayList;

public class Level {
	private Map currentMap;
	private Player currentPlayer;
	private ArrayList<Collectible> collectibles; //collectibles that have not been collected yet
	private ArrayList<Enemy> enemies;
	private int levelNumber; 
	
	
	public Level(int levelNumber){
		enemies = new ArrayList<Enemy>();
		currentMap = new Map(levelNumber, enemies);
		this.currentPlayer = new Player(currentMap.getPlayerStartingLocation());
		this.collectibles = new ArrayList<Collectible>(currentMap.getCollectibleList());
		//this.enemies = new ArrayList<Enemy>(currentMap.getEnemyList());
		this.levelNumber = currentMap.getLevelNumber();		
	}
	
	public void setCurrentMap(Map currentMap){
		this.currentMap = currentMap;
	}
	
	public void setCurrentPlayer(Player currentPlayer){
		this.currentPlayer = currentPlayer;
	}
	
	public void setCollectibles(ArrayList<Collectible> collectibles){
		this.collectibles = collectibles; 
	}
	
	public void setEnemies(ArrayList<Enemy> enemies){
		this.enemies = enemies;
	}
	
	public void setLevelNumber(int levelNumber){
		this.levelNumber = levelNumber;
	}
	
	public Map getCurrentMap(){
		return currentMap;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public ArrayList<Collectible> getCollectibles(){
		return collectibles;
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public int getLevelNumber(){
		return levelNumber;
	}
}
