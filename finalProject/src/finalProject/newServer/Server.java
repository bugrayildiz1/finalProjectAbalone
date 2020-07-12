package finalProject.newServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import finalProject.Board;
import finalProject.Game;
import finalProject.HumanPlayer;
import finalProject.Mark.Color;
import finalProject.Move;
import finalProject.Player;
import finalProject.Client.Client;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;



public class Server {
	Map<String, Integer> games = new HashMap<String,Integer>(); 
	Move move;
	public BufferedReader in;
	BufferedWriter out;
	List<Player> people = new ArrayList<Player>();
	private Board board;
	Map <String,Client> clients = new HashMap<>();
	Game game;
	Socket sock;
	ClientHandler server1;
	public static Vector<ClientHandler> ar = new Vector<>();
	
	/**
	 * Never used however because of our technical problems we couldnt finised the server part but we were planning to use.
	 * @param msgToSend
	 * @param ipAddress
	 * @param clients
	 */
	public void SendtoOneClient(String msgToSend, String ipAddress, Map<String, Client> clients) {
		Client c = clients.get(ipAddress);
		Socket sock = c.getSocket();
		try {
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			out.write(msgToSend);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Constructor of the class which called in main method in order to run the server.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Server() throws IOException, InterruptedException {
		int port = 8189;
		System.out.println("Server starting...");
			try (ServerSocket s = new ServerSocket(port)) {
				while(true) {
					try {
						
						Socket incoming = s.accept();
						
				        this.out = new BufferedWriter(new OutputStreamWriter(incoming.getOutputStream()));
				        Client c = new Client( incoming.getInetAddress().toString(), incoming, this);
				        clients.put(incoming.getInetAddress().toString(), c);
				        out.write("Client connected..");
				        out.newLine();
				        out.flush();

						server1 = new ClientHandler(incoming, this);
						Thread streamInputHandler = new Thread(server1);
						streamInputHandler.start();
						ar.add(server1);
					}
					catch (SocketException e) {
						e.printStackTrace();
					}
			}
		}
	}

	/**
	 * gets board
	 * @return board that has defined
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * this method finds the games that has created in the server
	 */
	public synchronized void findGames() {
		try {
			out.write(games.toString()+" has "+ people.size() + " players.");
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * players are able to create a new game with filling the game name, 
	 * username and the number of players specifications the game does not start because the 
	 * game should be full to start game.
	 * @param numberofPlayer player number in the game
	 * @param gameName name of the game
	 * @param name username
	 * @throws IOException
	 */
	
	public void CreateGame(int numberofPlayer, String gameName, String name) throws IOException {
		
		board = new Board();
		people.add(new HumanPlayer(name, Color.W));
		games.put(gameName, numberofPlayer);
		out.write("Waiting...");
		out.newLine();
		out.flush();
	}
	/**
	 * Creates the current board to all avaiable clients
	 */
	public void CreateBoardforAllClients () throws IOException {
		for (ClientHandler arr: Server.ar) {
			arr.out.write(game.getBoard().createBoardtoString());
			arr.out.newLine();
			arr.out.flush();
			
			}
	}
	/**
	 * sends the parameter to all avaiable clients
	 * @param write
	 * @throws IOException
	 */
	public void WriteforAllClients (String write) throws IOException {
		for (ClientHandler arr: Server.ar) {
			arr.out.write(write);
			arr.out.newLine();
			arr.out.flush();
			
			}
	}
	/**
	 * Checks the turn by counting.
	 */
	public Player WhosTurn() {
		if ((game.whosturn == 4 && people.size() == 4)||
				(game.whosturn == 3 && people.size() == 3)||
				(game.whosturn == 2 && people.size() == 2)){
			game.whosturn = 0;
		}
		return people.get(game.whosturn);
	}
	/**
	 * This method checks if the created room is avaiable to join and checks its capacity and if the capaticity is full t will start the game.
	 * @param gamename is the name of the game which is specified by thre host of the game
	 * @param playername name of the players
	 * @throws IOException
	 */
	public void JoinGame (String gamename , String playername) throws IOException, NotValidPlayerException {
		
		for (Entry<String, Integer> e: games.entrySet()) {
			if (e.getKey().contains(gamename)) {
				
				if (e.getValue() <= people.size()) {
					out.write("The game currently is full sorry");
					out.newLine();
					out.flush();
				}
				else if (e.getValue() < people.size()-1) {
					if (people.size() == 1) {
						people.add(new HumanPlayer(playername, Color.B));
						out.write("Waiting...");
						out.newLine();
						out.flush();
					}
					else if (people.size() == 2) {
						people.add(new HumanPlayer(playername, Color.R));
						out.write("Waiting...");
						out.newLine();
						out.flush();
					}
					
				}
				else if (e.getValue() == people.size()+1) {
					if (e.getValue() == 2) {
						people.add(new HumanPlayer(playername, Color.B));
						game = new Game (people.get(0), people.get(1), e.getKey());
						System.out.println(people.toString());
						game.getBoard().setup(ar.size());
						board.createBoard();
						for (ClientHandler arr: Server.ar) {
							arr.out.write("STARTING");
							arr.out.newLine();
							arr.out.write(game.getBoard().createBoardtoString());
							arr.out.newLine();
							arr.out.flush();
							
							}
						
					}
						
					else if (e.getValue() == 3) {
						people.add(new HumanPlayer(playername, Color.R));
						game = new Game (people.get(0), people.get(1),people.get(2), e.getKey());
						out.write("Starting... \n");
						out.newLine();
						out.flush();
					
					}
					else if(e.getValue() == 4) {
						people.add(new HumanPlayer(playername, Color.Y));
						game = new Game (people.get(0), people.get(1),people.get(2),people.get(3) ,e.getKey());
						out.write("Starting...");
						out.newLine();
						out.flush();
						
					}
					
				}
				else {
					out.write("there is a problem:(");
					out.newLine();
					out.flush();
				}
				
			}
			else {
				out.write("Not a valid gameName");
				out.newLine();
				out.flush();
			}
		}
		
	}
	

	
	
	/** 
	 * 
	 * @throws IOException
	 * @throws NotValidMoveException 
	 * @throws NotValidPlayerException 
	 * @throws InterruptedException */
	public static void main(String[] args) throws IOException, NotValidMoveException, NotValidPlayerException, InterruptedException {
		new Server();
	}
		
		
		
	
} // end of class Server
