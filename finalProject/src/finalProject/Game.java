package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import finalProject.Player.Team;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;


public class Game {
	private Board board;
	private List<Player> players = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String name;
	final int win = 6;
	public int rounds;
	public int whosturn = 0;
	private int numberofrounds;	
	//creating a game for 4 players
	public Game (Player p1, Player p2, Player p3, Player p4 , String name ) {
		board = new Board();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		p1.setTeam(Team.BW);
		p2.setTeam(Team.BW);
		p3.setTeam(Team.RY);
		p4.setTeam(Team.RY);
		numberofrounds = 0;
		this.name = name;
	}
	//create a game for 3 players
	public Game (Player p1, Player p2, Player p3, String name) {
		board = new Board();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		numberofrounds = 0;
		this.name = name;
	}
	//create a game for 2 players
	public Game (Player p1, Player p2, String name) {
		board = new Board();
		players.add(p1);
		players.add(p2);
		numberofrounds = 0;
		this.name = name;
	}
	public void start() throws NotValidMoveException, NotValidPlayerException {
		 boolean continueGame = true;
		 while (continueGame) {
			 play();
			 System.out.println("\n> Play another time? (true/false)?");
	            continueGame = sc.hasNextBoolean();
		 }
	}
	public void play() throws NotValidMoveException, NotValidPlayerException {
		board.setup(players.size());
		board.createBoard();
		int rounds = 0;
		while(!isWinner() || numberofrounds == 40 ) {
			Player currentPlayer = players.get(rounds);
			System.out.println(currentPlayer.getName() +"`s turn\n" + currentPlayer.getColor() + " is the mark you need to play");
			Player hint = new ComputerPlayer("hint", currentPlayer.getColor());
			System.out.println("HINT: " +hint.determineMove(getBoard()));
			try {
				currentPlayer.makeMove(board);
			}catch (NotValidMoveException e) {
				System.out.println("Invalid move please try again..");
				currentPlayer.makeMove(board);
			}
			board.createBoard();
	
			if (board.howManyColorsInGame() != 4) {
				System.out.println(players.toString());
			}
			else {
//				
				System.out.println("[BW=>"+(players.get(0).getTeamScore()+players.get(2).getTeamScore())+ " RY=>"+(players.get(1).getTeamScore()+players.get(3).getTeamScore())+"]");

			}
			numberofrounds++;
			rounds++;
		
			if ((rounds == 4 && players.size() == 4)||
					(rounds == 3 && players.size() == 3)||
					(rounds == 2 && players.size() == 2)){
				rounds = 0;
			}
		}
	}
	/**
	 * returns the board of the game.
	 * @return this.board
	 */
	 public Board getBoard() {
		 return this.board;
	 }
	 /**
		 * detects if there is a winner in the game
		 * @return true if there is a winner in the game
		 */
	 public boolean isWinner() {
		 for (int i = 0 ; i < players.size()-1;i++) {
			 if(win ==  players.get(i).getPoint()) {
				 return true;
			 }
			 else if (win == players.get(i).getTeamScore()) {
				 return true;
			 }
		 }
		 if (players.size() == 4 ) {
			 if (players.get(0).getTeamScore()+players.get(2).getTeamScore()==6) {
				 return true;
			 }
			 else if (players.get(0).getTeamScore()+players.get(2).getTeamScore()==6) {
				 return true;
			 }
		 }		 
		return false;
	 }
}

