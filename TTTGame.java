import java.util.*;

public class TTTGame {
	//Variables needed for the game
	gameBoard board;
	player player1;
	player player2;
	player cplayer;

	public TTTGame()
	{
		//Default constructor that sets up the game and starts it
		System.out.println("-----------WELCOME TO ULTIMATE TIC-TAC-TOE-----------");
		board = new gameBoard();
		player1 = new player("Player1","X");
		player2 = new player("Player2", "O");
		cplayer= player2;
		board.printBoard();
		setup();
		start();
	}

	//Sets up the game
	//Lets the users choose between player and AI
	public void setup()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Would you like to set the player with symbol X to be: 1) Player or 2) AI\nEnter 1 or 2>>");
		int res = console.nextInt();
		if(res == 2)
		{
			player1.setAI();	
		}
		System.out.println("Would you like to set the player with symbol O to be: 1) Player or 2) AI\nEnter 1 or 2>>");
		res = console.nextInt();
		if(res == 2)
		{
			player2.setAI();	
		}
	}

	//Starts running the game
	public void start()
	{
		Scanner console = new Scanner(System.in);
		//Variables to keep track of the board and square
		int preBoard = 9;
		int square = 9;
		boolean validMove = false;
		//Runs the game till its over
		while(!board.gameOver())
		{
			//variable to keep track if a move is valid
			
			//Switches the player each turn
			switchPlayer();
			System.out.println("Current Player is : " +cplayer.getSymbol());
			//Case when a player is an not an AI
			if(!cplayer.isAI()) {
				while(preBoard == 9 || validMove== false)
				{
					System.out.println("Please select a valid board: ");
					possibleOptions();
					preBoard = console.nextInt();
					validMove = validInput(preBoard);
				}
				//lets user choose a board if the current board is full
				while(board.isFull(preBoard))
				{
					System.out.println("Board " + preBoard + " is full, please select a board: ");
					//Gives user Possible options - EC
					possibleOptions();
					preBoard = console.nextInt();
				}

				System.out.println("Selected Board : " + preBoard);
				validMove= false;
				//Checks if the move is valid and asks again if required
				while(validMove== false) {
					System.out.println("Please select a valid square on the selected board: ");
					//Gives user Possible options - EC
					possibleOptions(preBoard);
					square = console.nextInt();
					validMove = validInput(square);
				}
				System.out.println("Selected Square : " + square);
				//Until player finds an empty spot, it keeps asking the user to select a square 
				while (!board.spotAvailable(preBoard, square))
				{
					System.out.println("The Spot is already taken! Please select a valid square on the selected board: ");
					while(validMove== false) {
						System.out.println("Please select a valid square on the selected board: ");
						//Gives user Possible options - EC
						possibleOptions(preBoard);
						square = console.nextInt();
						validMove = validInput(square);
					}
					System.out.println("Selected Square : " + square);
				}
			}
			//For AI 
			else
			{
				//For every choice, the AI calls a function that chooses a move out of the possible moves
				if(preBoard == 9)
				{
					preBoard = AIBoardSelect();
					validMove = true;
				}
				while(board.isFull(preBoard))
				{
					System.out.println("Board " + preBoard + " is full, please select a board: ");
					preBoard = AIBoardSelect();
				}
				System.out.println("Selected Board : " + preBoard);
				square = AISquareSelect(preBoard);
				System.out.println("Selected Square : " + square);
			}

			board.insert(preBoard,square,cplayer.getSymbol());
			if(board.getSymbol(9,preBoard).equals("")) 
			{
				//checks if there is a winner on a baord
				boolean var = board.hasWinner(preBoard);
			}
			//Prints the board after the selection
			board.printBoard();
			preBoard = square;
		}
	}

	//Function to alternate players
	public void switchPlayer()
	{
		if(cplayer.getSymbol().equals("X"))
		{
			cplayer = player2;			
		}
		else
		{
			cplayer=player1;
		}

	}

	//Checks if the input is valid
	public boolean validInput(int num)
	{
		if(num >= 0 && num <= 8)
		{
			return true;
		}
		return false;
	}

	//Lists out the possible options on a particular board
	public void possibleOptions(int x)
	{
		ArrayList <Integer> ans = new ArrayList<Integer>();


		//Goes through the board and checks if the spot is available and adds it to the array
		for(int i =0; i< 9; i++)
		{
			if(board.spotAvailable(x,i))
			{
				ans.add(i);
			}
		}
		//Prints out all the possible squares
		System.out.println("Possible legal Squares on Board " +x+" are : ");
		for(int i =0; i<ans.size(); i++ )
		{
			System.out.print(ans.get(i)+" ");
		}
		System.out.println();
	}

	//Lists out possible boards for user to select from
	public void possibleOptions()
	{
		ArrayList <Integer> ans = new ArrayList<Integer>();
		for(int i =0; i< 9; i++)
		{
			//checks if a board is not full and adds it to the arraylist 
			if(!board.isFull(i))
			{
				ans.add(i);
			}
		}
		//prints out the possible options
		System.out.println("Possible Board choices are : ");
		for(int i =0; i<ans.size(); i++ )
		{
			System.out.print(ans.get(i)+" ");
		}
		System.out.println();
	}

	//AI selects a open board for the user
	public int AIBoardSelect() 
	{
		ArrayList <Integer> ans = new ArrayList<Integer>();
		//Goes through all the boards and adds open boards to the array
		for(int i =0; i< 9; i++)
		{
			if(!board.isFull(i))
			{
				ans.add(i);
			}
		}

		//randomly selects a possible board and returns it
		int x = (int) (Math.random()*ans.size());

		return ans.get(x);
	}

	public int AISquareSelect(int x)
	{
		ArrayList <Integer> ans = new ArrayList<Integer>();
		//Goes through a board and get the possible open squares
		for(int i =0; i< 9; i++)
		{
			if(board.spotAvailable(x,i))
			{
				ans.add(i);
			}
		}

		//Randomly selects a square and returns it
		int s = (int) (Math.random()*ans.size());

		return ans.get(s);
	}


}
