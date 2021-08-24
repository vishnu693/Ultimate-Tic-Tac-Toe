
public class gameBoard {
	//The 2d array will hold each individual board in it
	String [][] board;
	// The array will hold the winners of each board in it
	String [] finalBoard;

	//constructor
	gameBoard()
	{
		//Initialize each board to be a tic tac toe board 
		finalBoard = new String[9];
		board = new String[9][9];

		//Set default values to both boards
		for(int i =0; i< 9; i++)
		{
			for(int j =0; j <9; j++)
			{
				//Set default values the board to the index number 
				board[i][j] = ""+j;

			}
			//Set default values the finalBoard to be an empty string 
			finalBoard[i] = "";

		}
	}

	//Function to display the board
	public void printBoard()
	{
		System.out.print("    ");
		int m =0;
		int n =0;

		//loops through each board and prints the values based on the format
		for(int j =m; j< 3+m; j++)
		{
			System.out.print("Board#" + j + " |");
			for(int k =n; k < 3+n; k++)
			{
				System.out.print(" "+board[j][k] +" |");

				if((j+1)%3 == 0 && (k+1)%3 == 0)
				{
					if(k == 8)
					{
						m = m+3;
						n =0;
						//j = j+2;
						System.out.println();
						System.out.println();
						break;
					}
					n= n+3;
					//m =0;
					j =m-1;
					System.out.println();
					break;
				}
			}
			if(j == 8)
			{
				break;
			}
			System.out.print("    ");
		}

		//Displays the winners of each board
		for(int i =0; i< 9; i++)
		{
			//Onlu displays if there is a winner
			if(!finalBoard[i].equals(""))
			{
				System.out.println("The Board#"+i+" winner is " + finalBoard[i]);
			}
		}
		System.out.println();

	}

	//returns the symbol at a particular index
	public String getSymbol(int i, int j)
	{
		if(i == 9)
		{
			return finalBoard[j];
		}
		return board[i][j];
	}

	//Checks to see if a specific board is full and returns a boolean
	public boolean isFull(int i)
	{
		//If a board is full 
		for(int j =0; j < 9; j++ )
		{
			char[] c = board[i][j].toCharArray();
			if(Character.isDigit(c[0]))
			{
				return false;
			}
		}
		return true;		
	}

	//Checks to see if the game is over
	public boolean gameOver()
	{
		//Sees if the overall game had a winner
		//Checks the columns, rows and diagonals
		if(checkCol(9, finalBoard, "X") || checkRow(9, finalBoard, "X")||checkDLR(9, finalBoard, "X")||checkDRL(9, finalBoard, "X"))
		{
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("X won the Game");
			System.out.println();
			return true;
		}
		if(checkCol(9, finalBoard, "O")||checkRow(9, finalBoard, "O")||checkDLR(9, finalBoard, "O")||checkDRL(9, finalBoard, "O"))
		{
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("O won the Game");
			System.out.println();
			return true;
		}

		//If there is no winner, checks if there is still any open boards left to win
		for(int i =0; i< 9; i++)
		{
			if(finalBoard[i].equals(""))
			{
				return false;
			}
		}

		//if no winner and and no open baords, then the game is a tie
		System.out.println("The Game is a Tie");
		return true;
	}

	//Places a symbol at a particular position on the board
	public void insert(int i, int j, String symbol)
	{
		board[i][j] = symbol;
	}

	//Checks to see if a spot is taken or empty
	public boolean spotAvailable(int i, int j)
	{
		char[] c = board[i][j].toCharArray();
		if(Character.isDigit(c[0]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Checks to see if a board has a winner
	public boolean hasWinner(int i)
	{
		//Checks the columns, rows and diagonals for a winner
		if(checkCol(i, board[i], "X") || checkRow(i, board[i], "X")||checkDLR(i, board[i], "X")||checkDRL(i, board[i], "X") )
		{
			System.out.println("X won board " + i);
			System.out.println();
			//Marks the winner in the final board array
			finalBoard[i] = "X";
			return true;
		}
		if(checkCol(i, board[i], "O")||checkRow(i, board[i], "O")||checkDLR(i, board[i], "O")||checkDRL(i, board[i], "O"))
		{
			System.out.println("O won board " + i);
			System.out.println();
			finalBoard[i] = "O";
			return true;
		}

		//If the baord is full and there is still no winner, they it makes it a tie
		if(isFull(i) && !(finalBoard[i].equals("X") ||finalBoard[i].equals("O")) )
		{
			//Marks the tie in the final board array
			finalBoard[i] = "T";
		}

		return false;
	}

	//Checks the columns on a board for 3 in a row
	public boolean checkCol(int i, String [] nums,String symbol)
	{
		for(int j =0; j< 3; j++)
		{
			if(getSymbol(i,j).equals(symbol) && getSymbol(i,j+3).equals(symbol) && getSymbol(i,j+6).equals(symbol))
			{
				return true;
			}
		}
		return false;
	}

	//Checks the rows on a board for 3 in a row
	public boolean checkRow(int i, String [] nums,String symbol)
	{
		for(int j =0; j< 3; j++)
		{
			if(getSymbol(i,3*j).equals(symbol) && getSymbol(i,(3*j)+1).equals(symbol) && getSymbol(i,(3*j)+2).equals(symbol))
			{
				return true;
			}
		}
		return false;
	}

	//Checks the left to right diagonal on a board for 3 in a row
	public boolean checkDLR(int i, String [] nums,String symbol)
	{
		if(getSymbol(i,0).equals(symbol) && getSymbol(i,4).equals(symbol) && getSymbol(i,8).equals(symbol))
		{
			return true;
		}
		return false;
	}

	//Checks the right to left diagonal on a board for 3 in a row
	public boolean checkDRL(int i, String [] nums,String symbol)
	{
		if(getSymbol(i,2).equals(symbol) && getSymbol(i,4).equals(symbol) && getSymbol(i,6).equals(symbol))
		{
			return true;
		}
		return false;
	}

	public boolean findWinner(int i)
	{
		//Checks the columns, rows and diagonals for a winner
		if(checkCol(i, board[i], "X") || checkRow(i, board[i], "X")||checkDLR(i, board[i], "X")||checkDRL(i, board[i], "X") )
		{
			return true;
		}
		if(checkCol(i, board[i], "O")||checkRow(i, board[i], "O")||checkDLR(i, board[i], "O")||checkDRL(i, board[i], "O"))
		{
			return true;
		}

		return false;
	}

	public void remove(int i, int j)
	{

		board[i][j] = "" +j;
	}

}




