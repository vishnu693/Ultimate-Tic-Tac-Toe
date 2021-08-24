/*
 * Name: Vishnu Kommineni
 * Net ID: VXK180041
 * Class: CS 2336
 * Section Number: 006
 * 
 * Extra Credit: Possible legal moves for each player
 * 
 * Analysis:
 * Similar to the previous game, we can use multiple classes to make the implementation of this game easier
 * First start off by creating a gameBoard class that deals with all the functions on the game board
 * It handles marking on the board, printing the board, checking the winner and other small functions required for the game
 * After creating a board class, we can create the player class
 * It contains information about the players 
 * It contains name, symbol and keeps track if the player is AI
 * After creating the player method, we can create a class that implements both the gameBoard and the players
 * The UTTTGame class contains the player and the the board
 * It initializes all the values and starts the game
 * The game keeps running until it is a tie or there is a winner
 * This method also has functions for the AI to make a choices
 * After creating this class, you can create a game class which creates the game
 * 
 * Design:
 * 	Start with the game class
 * 	game class contains a TTTGame object
 *  TTTGame class contains three player classes and one board class
 *  Player class contains the required information of a player 
 *  Board class keeps track of the board 
 *  The Hierarchy:
 *  game
 *  	TTTGame 
 *  		player
 *  		gameBoard
 *  
 * Tests:
 * Manual tests:
 * Check if a player wins on a board by placing 3 pieces in a row
 * 	Checked by placing it in a row
 * 	Checked by placing it in a column 
 *  Checked by placing it in the diagonals 
 *  
 * Checking if player wins by winning 3 boards in a row
 * 	Checked by winning 3 in a row
 * 	Checked by winning 3 in a column 
 *  Checked by winning the diagonals  
 *  
 * Checking if game is tied by tying each board
 * 
 * Checking if game is a tie by tying the overall wins on the boards 
 * 
 *AI Tests:
 *Out of 20 runs:
 *X wins: 9 times -45%
 *O wins: 6 times -30%
 *Tie: 5 times    -25%
 *
 *The reason for the slightly higher win percentage for X is that it was the first to place the move
 *
 *
 *Extra Credit
 * Implemented: Program provides a list of possible legal moves to each player. (Optional – extra 5 points)
 */

public class game {

	public static void main(String[] args)
	{
		//Creates a TTTGame object and starts the game
		TTTGame TTT = new TTTGame();
	}
}
