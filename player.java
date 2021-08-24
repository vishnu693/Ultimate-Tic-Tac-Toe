
public class player {
	//Variables to keep track of player's info
	private String name; 
	private String symbol;
	private boolean AI;

	//constructor
	player(String name, String symbol)
	{
		this.name = name;
		this.symbol = symbol;
		AI = false;
	}

	//returns a player symbol
	public String getSymbol()
	{
		return this.symbol;
	}

	//returns a player name
	public String getName()
	{
		return this.name;
	}

	//Sets a player to AI 
	public void setAI()
	{
		AI = true;
	}

	//Checks if a player is an AI
	public boolean isAI()
	{
		return AI;
	}


}
