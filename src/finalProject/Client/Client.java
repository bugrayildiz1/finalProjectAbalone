package finalProject.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import finalProject.Player;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;
import finalProject.newServer.Server;

public class Client {
	public static BufferedReader in;
	public static BufferedReader in1;
    public static BufferedWriter out;
    Player player;
    static ClientReceiver printer; 
    static Server server;
    String userName;
    String ipAddress;
    public Socket socket;
    
    @SuppressWarnings("static-access")
	public Client ( String ipAddress, Socket socket, Server server)
    {
       this.server = server;
       this.ipAddress = ipAddress;
       this.socket = socket;
    }
	/**\
	 * this method is for sending the input from the client
	 * @param sock is the socket thst we specified
	 */
	public static void sendInput(Socket sock) {
    	try{    		
    		out.write(in.readLine());
    		out.newLine();
    		out.flush();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 *
	 * @return this.socket;
	 */
	public Socket getSocket () {
    	return this.socket;
    }
	/**
	 * 
	 * @return ipAddress;
	 */
	public String getIpAddress() {
		return ipAddress;		
	}
	/**
	 * for connecting to the server client needs to type the ip address that he/she wants to connect
	 * and then tui asks for the port number
	 * then, player is free to do any command from the command menu
	 * @param args
	 * @throws NotValidMoveException exception for invalid move
	 * @throws NotValidPlayerException exception for invalid player
	 * @throws IOException exception for input output
	 */
	public static void main (String[] args) throws NotValidMoveException, NotValidPlayerException, IOException {	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		System.out.println("Your IP address is "+InetAddress.getLocalHost()+"\nWhat is the ip address you want to connect?");	
		String addr =  sc.next();
		InetAddress adr = InetAddress.getByName(addr);
		System.out.println("What is the port you want to use?");
		int port = sc.nextInt();
		Socket sock = null;
		try {
			sock = new Socket(adr, port);
			 in = new BufferedReader(new InputStreamReader(System.in));
    		 out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}catch (IOException e) {
			System.out.println("ERROR: could not create a socket on " + addr
					+ " and port " + port);
		}
		printer = new ClientReceiver(sock , server);
		Thread a = new Thread (printer);
		a.start();
		try {
			System.out.println("COMMANDS");
			System.out.println("---------");
			System.out.println("To create game:");
			System.out.println("CREATEGAME;[number of players];[gamename];[username]");
			System.out.println("To find games:");
			System.out.println("FINDGAMES");
			System.out.println("To join a game:");
			System.out.println("JOINGAME;[gamename];[username]");
			System.out.println("To make move;");
			System.out.println("MOVE;[xy];[xy];[DD]");
			System.out.println("To send message:");
			System.out.println("SENDMESSAGE;[message]");
			System.out.println("To leave the game:");
			System.out.println("LEAVEGAME");		
			while(true) {
				sendInput(sock);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}				
	}	
}
