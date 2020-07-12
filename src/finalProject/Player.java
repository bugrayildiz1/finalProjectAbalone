/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;



import java.util.ArrayList;
import java.util.List;

import finalProject.Move;
import finalProject.Mark.Color;
import finalProject.Exceptions.NotValidMoveException;


/**
 *
 * @author Btbdn
 */



public abstract class Player {

	/**
	 * representing default team colors
	 */
    public enum Team {
        RY, //redyellow
        BW,//blackwhite
        OO//PLAYERS WITHOUT TEAM WHICH 3 player game and 2 player
    }
 
    
    
    
    public Player(String name,Color color) {
       setName(name);
       setColor(color);
       setPoint(0);
       setTeam(Team.OO);
    }
    
    private String name;
    private Color color;
    int playerno;
    int points;
    int Teamscore = 0;
    Team team;

	/**
	 *
	 * @param p
	 * @return
	 */
	public List<Color> enemyColors(Player p){
    	List<Color> result = new ArrayList<Color>();
    	if (p.getColor() == Color.W || p.getColor() == Color.B) {
    		result.add(Color.R);
    		result.add(Color.Y);
    	}
    	else {
    		result.add(Color.B);
    		result.add(Color.W);
    	}
    	return result;
    }

	/**
	 *
	 * @param p
	 * @return
	 */
	public Color getOtherMemberColor (Player p) {
    	Color result = Color.O;
    	if (p.getColor() == Color.B) {
    		result = Color.W;
    	}
    	else if (p.getColor() == Color.W) {
    		result = Color.B;
    	}
    	else if (p.getColor() == Color.R) {
    		result = Color.Y;
    	}
    	else if (p.getColor() == Color.Y) {
    		result = Color.R;
    	}
    		
    	return result;
    }
    public void setTeamScore(int newScore) {
    	this.Teamscore = newScore;
    }
    public int getTeamScore() {
    	return Teamscore;
    }
    public Team getTeam() {
    	return this.team;
    }

	/**
	 *  sets the team
	 * @param t
	 */
	public void setTeam(Team t) {
    	this.team = t;
    }
    public int getPoint() {
        return points;
    }

    public void setPoint(int Point) {
        this.points = Point;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/**
	 * when the client write the move command's direction, this method changes the string into the actual direction from the class "Direction".
	 * @param s
	 * @return
	 */
    public Direction findDirection (String s) {
    	Direction result = null;
    	if (s.equals("SW")) {
    		result = Direction.SW;
    	}
    	else if (s.equals("EE")) {
    		result = Direction.EE;
    	}
    	else if (s.equals("WW")) {
    		result = Direction.WW;
    	}
    	else if (s.equals("SE")) {
    		result = Direction.SE;
    	}
    	else if (s.equals("NW")) {
    		result = Direction.NW;
    	}
    	else if (s.equals("NE")) {
    		result = Direction.NE;
    	}
    	return result;
    }
    @Override
    public String toString() {
        return getName() + " - " + getColor() + " - " + getPoint();
    }
    public String toTeamString() {
    	 return getName() + " - " + getTeam() + " - " + getTeamScore();
    }
    public abstract String determineMove(Board board);

	/**
	 * this method checks the client's moves if they are valid moves or invalid moves. If they are not valid moves, it prints the error message from its Exception class
	 * @param board
	 * @throws NotValidMoveException
	 */
	protected  void makeMove(Board board) throws NotValidMoveException {
		try {
			Move m = new Move();
			String answer = determineMove(board);
			String[] cmds = answer.split(";");
			String location1 = cmds[1];
			int x1 = Character.getNumericValue(location1.charAt(0));
			int y1 = Character.getNumericValue(location1.charAt(1));
			String location2 = cmds[2];
			int x2 = Character.getNumericValue(location2.charAt(0));
			int y2 = Character.getNumericValue(location2.charAt(1));
			String direction = cmds[3];

			m.Sumito(x1, y1, x2, y2, findDirection(direction), board, this);
			}
			catch (Exception e) {
//				throw new NotValidMoveException("");
				
				
			}
	}
    
}
