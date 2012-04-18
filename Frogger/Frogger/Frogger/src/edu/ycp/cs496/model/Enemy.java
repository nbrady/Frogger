package edu.ycp.cs496.model;

import java.util.List;

public class Enemy extends The_Superclass {
	private Location loc;
	private int xSpeed;
	private int ySpeed;
	private List<Location> locations;
	
	public Enemy (Location loc, List<Location> locations){
		this.loc = loc;
		this.xSpeed = 10; // Enemy Location is current set to be static
		this.ySpeed = 10; // in both directions
		this.locations = locations;
	}

	public void setLocation(Location loc){
		this.loc = loc;
	}
	
	public void setXSpeed(int xSpeed){
		this.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed){
		this.ySpeed = ySpeed;
	}
	
	public void setLocationList(List<Location> locations){
		this.locations = locations;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public int getXSpeed(){
		return xSpeed;
	}
	
	public int getYSpeed(){
		return ySpeed;
	}
	
	public List<Location> getLocationList(){
		return locations;
	}
		
	public Location move(){	//Changed here - make sure it works
		boolean flag = false;
		for(Location l : locations)
		{
			if(flag)
			{
				return l;
			}
			if(loc.equals(l))
			{
				flag = !flag;
			}
		}
		
		return locations.get(0);
		
		
		//return locations.get(locations.indexOf(loc) + 1);
	}
	
	public boolean equals(Enemy enemy){
		if (loc.equals(enemy.getLocation()) && xSpeed == enemy.getXSpeed() 
				&& ySpeed == enemy.getYSpeed() && locations.equals(enemy.getLocationList())){
			return true;
		}
		return false;
	}
	
}
