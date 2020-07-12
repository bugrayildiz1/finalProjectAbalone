package finalProject;

import finalProject.Mark.Color;

public class Field {
	Board board;
	Mark mark ;
	int x;
	int y;

	/**
	 * this class that stores the location of the cells
	 * @param board Board
	 * @param x coordinates
	 * @param y coordinates
	 */
	public Field(Board board, int x, int y) {
		this.x = x;
		this.y = y;
		this.board = board;
		mark = new Mark();
		this.mark.SetColor(Mark.Color.O);
		
	}

	/**
	 *
	 * @return the exact location of the marks
	 */
	public Field getField () {
		return this;
	}

	/**
	 * gets mark
	 * @return mark
	 */
	public Mark getMark() {
		return this.mark;
	}

	/**
	 * sets color
	 * @param w
	 */
	public void setMark(Color w) {
		this.mark.SetColor(w);
	}
	
	public String toString() {
		return this.mark.toString();
		
	}
}
