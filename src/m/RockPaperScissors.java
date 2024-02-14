package m;

import java.util.Scanner;

/**
 * @author Clinio Marcelino
 * 
 * @descripton Program to play Rock - Paper - Scissors 
 * @rules rock wins scissor<br>scissors wins paper<br>paper wins rock
 * @user is asked to choose between rock paper and scissors, in the form of numbers, [1,3]
 * @precondition user input is: (1=< input <=3)
 * 
 * @user is asked if wants to keep playing, in the form of answering y/Y
 * @postcondition if keep playing is desired, repeat, else, show results and end
 * 
 * @date February 14 2024
 * @version 1.0
 * 
 * @Obs Only one method <b>play()</b> is not private.<br>It should be called to beguin the game
 * 
 */

public class RockPaperScissors {
	/**
	 * @varibles user, bot, tie are static counters for score
	 */
	private static int user = 0;
	private static int bot = 0;
	private static int tie = 0;
	
	public static void main(String[] args) {
		RockPaperScissors.play();
	}
	
	/**
	 * @usage Start game
	 */
	public static void play() {
		Scanner sc = new Scanner(System.in);
		
		gameStart();
		while(true) {
			gameOptions();
			int bot = (int)(Math.random()*3)+1;
			
			gameResult(validateInputRpS(sc.nextLine()),bot);
			
			gameAgain();
			if (playAgain(sc.nextLine()))
				break;
			
		}
		gameGoodbye();
	}
	
	/**
	 * Receives an string and verifies that is an integer
	 * 
	 * @param input -> string 
	 * @precondition 1>=input<=3
	 * @return integer for @method gameResult()
	 * @postcondition integer
	 * @throws NumberFormatException
	 */
	private static int validateInputRpS(String input) {
		int output=-1;
		try {
			output = Integer.parseInt(input);
		}catch(Exception e) {
			return output;
		}
		return output;
		
	}
	
	/**
	 * Receives user input and bot random choice and defines the round winner, tie.<br>
	 * If there is no winner or not a tie means that was an incorrect user input.<br><br>
	 * Deliver to the gameWinner() method so that it prints the winners message
	 * 
	 * @param user -> integer 
	 * @param bot -> integer
	 * 
	 */
	private static void gameResult(int user,int bot) {
		if(user==bot) 
			gameWinner(0,user,bot);
		else if(user==1)
			if (bot==2) 
				gameWinner(2,user,bot);	
			else 
				gameWinner(1,user,bot);
		else if (user==2)
			if (bot==1)
				gameWinner(1,user,bot);
			else
				gameWinner(2,user,bot);
		else if (user==3)
			if(bot==1)
				gameWinner(2,user,bot);
			else
				gameWinner(1,user,bot);
		else
			System.out.println("Incorrect input. Can only be 1,2 or 3. (Rock,Paper,Scissors");
		
	}
	
	/**
	 * Greet user and show the game rules -> gameRules()
	 *
	 */
	private static void gameStart() {
		System.out.println("Welcome to Rock, Paper and Scissors game! These are the rules:\n");
		gameRules();
		System.out.println("You are playing against a bot that choses before you => (he is not cheating...)\n");
		
	}
	
	/**
	 * Show the game Rules
	 */
	private static void gameRules() {
		System.out.println("Rock smashs Scissors");
		System.out.println("Scissor cuts Paper");
		System.out.println("Paper packs Rock");
	}
	
	
	/**
	 * Guide and show player the options they can choose
	 */
	private static void gameOptions() {
		System.out.println("Choose your play according to chart below:");
		System.out.println("1 - Rock\n2 - Paper\n3 - Scissors");
	}
	
	/**
	 * Converts the integer input, <b>play</b>, to the according material
	 * 
	 * @param play -> what was the play
	 * @return String according to the play:<br>1 -> Rock<br>2 -> Paper<br>3 -> Scissors
	 * 
	 */
	private static String rPs(int play) {
		
		switch(play) {
		case 1:
			return "Rock";
		
		case 2:
			return "Paper";
		
		case 3:
			return "Scissors";
		default:
			return "";
			
		}
	}
	
	/**
	 * Method for showing the correct message for the game winner.
	 * 
	 * @param win -> received from the <b>gameResult()</b> used to show the correct message
	 * @param user -> user input for be tranformed by the <b>rPs()</b> method
	 * @param bot -> bot random to be tranformed by the <b>rPs()</b> method
	 */
	private static void gameWinner(int win,int user, int bot) {	
		if(win==1) {
			System.out.println("Congratulations, YOU WON!!\n"+rPs(user)+" beats "+rPs(bot));
			RockPaperScissors.user++;
		}
		else if (win==2) {
			System.out.println("Bot beatead you!\n"+rPs(bot)+" beats "+rPs(user));
			RockPaperScissors.bot++;
		}
		else {
			System.out.println("It's a Tie!!! Both choosed "+rPs(bot));
			RockPaperScissors.tie++;
		}
	}
	
	/**
	 * Method for instructions upon asking if player wants to play one more time
	 */
	private static void gameAgain() {
		System.out.println("\nWanna play again?");
		System.out.println("Press Y or y, to play again, and any other key to exit");
	}
	
	/**
	 * Method to verify if user wants to keep playing<br>
	 * In case of one more round <b>returns false</b> so that while loop continues
	 * 
	 * @precondition user inputs y/Y
	 * 
	 * @param s -> user input
	 * @return true or false
	 */
	private static boolean playAgain(String s) {
		if (s.equalsIgnoreCase("y"))
			return false;
		return true;
	}
	
	/**
	 * Method when game ends.<br>
	 * Greet the player and show scores
	 */
	private static void gameGoodbye() {
		System.out.println("Thanks for playing! The final score is:");
		System.out.println("USER: "+RockPaperScissors.user);
		System.out.println("BOT: "+RockPaperScissors.bot);
		System.out.println("TIES: "+RockPaperScissors.tie);
	}
	
}
