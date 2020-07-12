package finalProject.newServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import finalProject.Game;
import finalProject.Move;
import finalProject.Player;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;
import java.net.Socket;


public class ClientHandler implements Runnable {
	public static final String EXIT = "exit";
	protected String name;
	protected Socket sock;
	public BufferedReader in;
	
	public BufferedWriter out;
    protected boolean closed = false;
    Player player;
    Server server;
	Game game;
	boolean start = true;
	/**
	 * This method specifies the parameters that the class has
	 * @param socket is the socket that tht we already specified while we were creating our server
	 * @param server server is our server that already exist in the server class
	 * @throws IOException
	 */
    public ClientHandler (Socket socket,Server server) throws IOException {
    	this.sock = socket;
    	this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		this.server = server;
			
    }
    public Socket getSocket() {
    	return this.sock;
    }
	public void SetName (String name) {
		this.name = name;
	}
	@Override
	public synchronized void run() {
		while (true) {
			if (server.game != null) {
    			Player currentplayer = server.WhosTurn();
        		try {
					server.WriteforAllClients(currentplayer.getName()+ "`s turn:");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
	   		String msg = null;
	   		
	   		try {
				msg = in.readLine();
				
        		
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {			
				
				try {
					handleCommand(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (NotValidMoveException e) {
				// TODO Auto-generated catch block
				
				shutDown();
			} catch (NotValidPlayerException e) {
				
				e.printStackTrace();
			}
			}
	}

	/**
	 * ends the connection
	 */
    public void shutDown() {
    	try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * create a switch statement that will check all the inputs that client made and it will do the protocols according to that;
	 * @param line
	 * @throws NotValidMoveException
	 * @throws NotValidPlayerException
	 * @throws IOException 
	 */
    public synchronized void handleCommand(String line) throws NotValidMoveException, NotValidPlayerException, IOException {
   	 
   	 // create a switch statement that will check all the inputs that client made and it will do the protocols according to that;
    		
            try {
                String[] cmds = line.split(";");
                switch (cmds[0]) {
                	case "MOVE":
                		
                			if (cmds.length < 4) {
                    			out.write("TOOFEWARGUMENTS..");
                    			out.newLine();
                    			out.flush();
                    			break;
                    		}
                			else {
                				Player currentplayer = server.WhosTurn();
                				server.game.whosturn++;
                        		Move m = new Move();
                        		
                        		String location1 = cmds[1];
                        		int x1 = Character.getNumericValue(location1.charAt(0));
                        		int y1 = Character.getNumericValue(location1.charAt(1));
                        		String location2 = cmds[2];
                        		int x2 = Character.getNumericValue(location2.charAt(0));
                        		int y2 = Character.getNumericValue(location2.charAt(1));
                        		String direction = cmds[3];
                        		
                        		
                        		m.Sumito(x1, y1, x2, y2, currentplayer.findDirection(direction), server.game.getBoard(), currentplayer);
                        		server.CreateBoardforAllClients();
                        		server.WriteforAllClients(server.people.toString());
                        		break;
                			}
                    		
                		
                		
                	case "LEAVEGAME":
                		shutDown();
                		break;
                	case "CREATEGAME":
                		out.write("Game Created..");
                		out.newLine();
                		out.flush();
                		int noplayer = Character.getNumericValue(cmds[1].charAt(0));
                		String gamename = cmds[2];
                		String username = cmds[3];
                   		server.CreateGame(noplayer ,gamename, username);
                   		break;
                		
                		
                	case "JOINGAME":
                		String gamename1 = cmds[1];
                		String username1 = cmds[2];
                		server.JoinGame(gamename1, username1);
                		break;
                	case "SENDMESSAGE":
//                		try {
//                			ChatClient.main(new String[0]);
//                		} catch(Exception e) {
//                			e.printStackTrace();
//                		}
                		break;
                	case "FINDGAMES":
                		server.findGames();
                		break;
                
                }
            }
             catch (IOException e) {
                e.printStackTrace();
            }
    	
            
	}
}
    
