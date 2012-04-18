package edu.ycp.cs496.model;

public enum Terrain 
{
	BLANK (0), PLAYER (1), COLLECTIBLE (2), ENEMY (3), START (4), FINISH (5), PATH (6);
	
	private int value;
	
	private Terrain(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean isBlank(int i)
	{
		if(i == BLANK.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isPlayer(int i)
	{
		if(i == PLAYER.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isCollectible(int i)
	{
		if(i == COLLECTIBLE.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isEnemy(int i)
	{
		if(i == ENEMY.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isStart(int i)
	{
		if(i == START.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isFinish(int i)
	{
		if(i == FINISH.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isPath(int i)
	{
		if(i == PATH.getValue())
		{
			return true;
		}
		
		return false;
	}
}
