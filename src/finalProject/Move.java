package finalProject;

import java.util.ArrayList;
import java.util.List;
import finalProject.Mark.Color;
import finalProject.Exceptions.NotValidMoveException;

public class Move {
	// returns a list of direction where the directions has the Color.O which is
	// empty
	/**
	 * this method specifies the valid moves while player want to move only one marble.
	 * @param a represents the coordinates
	 * @param b represents the coordinates
	 * @param board board that already created in the board class
	 * @return a list of direction where the directions has the Color.O which is empty
	 */
	public List<Direction> ValidMoves(int a, int b, Board board) {
		List<Direction> result = new ArrayList<Direction>();
		if (a < 4) {
			if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) == Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) == Color.O) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NE);
			}
		}

		if (a > 4) {
			if (board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if ((a != 8 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SE);
			}
			if ((a != 8 && b != 0) && board.colorFinder(a + 1, b - 1) == Color.O) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) == Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) == Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) == Color.O) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NE);
			}
		}
		return result;
	}
	/**
	 * shows the friendly marbles around the specified coordinates
	 * @param a coordinates
	 * @param b coordinates
	 * @param board board
	 * @return a list of direction where the direction has the same Color or Team Member(to be implemented)
	 */
	// returns a list of direction where the direction has the same Color or Team
	// Member(to be implemented)
	public List<Direction> whereFriend(int a, int b, Board board) {
		List<Direction> result = new ArrayList<Direction>();
		Color color = board.colorFinder(a, b);
		if (a < 4) {
			if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) == color) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NE);
			}
		}
		if (a > 4) {
			if (board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if ((a != 9 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SE);
			}
			if ((a != 9 && b != 0) && board.colorFinder(a + 1, b - 1) == color) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) == color) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) == color) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NE);
			}
		}
		return result;
	}

	// returns a list of direction where the direction has the same Color or Team
	// Member(to be implemented)
	/**
	 * shows the enemy marbles around the specified coordinates
	 * @param a coordinates
	 * @param b coordinates
	 * @param board Board
	 * @return a list of direction where the direction has the same Color or Team Member(to be implemented)
	 */
	public List<Direction> whereEnemy(int a, int b, Board board) {
		List<Direction> result = new ArrayList<Direction>();
		Color color = board.colorFinder(a, b);
		if (a < 4) {
			if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) != color
					&& board.colorFinder(a - 1, b - 1) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) != color && board.colorFinder(a + 1, b + 1) != Color.O) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) != color && board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) != color
					&& board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a > 4) {
			if (board.colorFinder(a - 1, b) != color && board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if ((a != 9 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) != color
					&& board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SE);
			}
			if ((a != 9 && b != 0) && board.colorFinder(a + 1, b - 1) != color
					&& board.colorFinder(a + 1, b - 1) != Color.O) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) != color && board.colorFinder(a - 1, b + 1) != Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) != color && board.colorFinder(a - 1, b - 1) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) != color
					&& board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) != color && board.colorFinder(a + 1, b - 1) != Color.O) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) != color
					&& board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NE);
			}
		}
		return result;
	}

	// returns the field on that direction (you can pull the x and y components)
	/**
	 * this method helps player to find the coordinate of the cell that wants to go(direction specification needed)
	 * @param a coordinates
	 * @param b coordinates
	 * @param d Direction
	 * @param board
	 * @return the field on that direction (you can pull the x and y components)
	 */
	public Field findField(int a, int b, Direction d, Board board) {
		Field result = null;
		if (a < 4) {
			if (b != board.alist.get(a).size() - 1 && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if (b != 0 && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if (d == Direction.SE) {
				result = board.alist.get(a + 1).get(b + 1);
			}
			if (d == Direction.SW) {
				result = board.alist.get(a + 1).get(b);
			}
			if (a != 0 && b != board.alist.get(a).size() - 1 && d == Direction.NE) {
				result = board.alist.get(a - 1).get(b);
			}
			if ((a != 0 && b != 0) && d == Direction.NW) {
				result = board.alist.get(a - 1).get(b - 1);
			}
		}
		if (a > 4) {
			if ((b != board.alist.get(a).size() - 1) && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if ((b != 0) && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if ((a != 8 && b != board.alist.get(a).size() - 1) && d == Direction.SE) {
				result = board.alist.get(a + 1).get(b);
			}
			if ((a != 8 && b != 0) && d == Direction.SW) {
				result = board.alist.get(a + 1).get(b - 1);
			}
			if (d == Direction.NE) {
				result = board.alist.get(a - 1).get(b + 1);
			}
			if (d == Direction.NW) {
				result = board.alist.get(a - 1).get(b);
			}
		}
		if (a == 4) {
			if ((b != board.alist.get(a).size() - 1) && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if ((b != 0) && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if ((b != board.alist.get(a).size() - 1) && d == Direction.SE) {
				result = board.alist.get(a + 1).get(b);
			}
			if ((b != 0) && d == Direction.SW) {
				result = board.alist.get(a + 1).get(b - 1);
			}
			if ((b != board.alist.get(a).size() - 1) && d == Direction.NE) {
				result = board.alist.get(a - 1).get(b);
			}
			if ((b != 0) && d == Direction.NW) {
				result = board.alist.get(a - 1).get(b - 1);
			}
		}
		return result;
	}
	/**
	 * this method makes move for one marble. If player want to move more tha one marble, he/she needs to check other methods
	 * @param a coordinate
	 * @param b coordinate
	 * @param d Direction
	 * @param board Board
	 * @throws NotValidMoveException
	 */
	public void MakeMoveforOne(int a, int b, Direction d, Board board) throws NotValidMoveException {
		Color color = board.colorFinder(a, b);
		if (!ValidMoves(a, b, board).contains(d)) {
			throw new NotValidMoveException(d.toString() + " not a valid move.");

		} else if (ValidMoves(a, b, board).contains(d)) {
			board.alist.get(a).get(b).setMark(Color.O);
			if (a < 4) {
				if (d == Direction.EE) {

					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {

					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b - 1).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b + 1).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
			if (a > 4) {
				if (d == Direction.EE) {

					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {

					board.alist.get(a - 1).get(b + 1).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b - 1).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
			if (a == 4) {
				if (d == Direction.EE) {

					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {

					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b - 1).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b - 1).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
		}
	}
	/**
	 * This method is for pushing marbles and moving two or three marbles at the same time
	 * @param a1 coordinates of the initial marble
	 * @param b1 coordinates of the initial marble
	 * @param a2 coordinates of second initial marble
	 * @param b2 coordinates of second initial marble
	 * @param d Direction
	 * @param b Board
	 * @param p Player who is going to make move
	 * @throws NotValidMoveException
	 */
	public void Sumito(int a1, int b1, int a2, int b2, Direction d, Board b, Player p) throws NotValidMoveException {
		Field enemy = findField(a2, b2, d, b);
		Field enemy2 = findField(enemy.x, enemy.y, d, b);
		Field middle = null;
		if (findPlayedMarks(a1, b1, a2, b2, d, b) == 3) {
			if ((a1 == 3 && a2 == 5) || (a1 == 5 && a2 == 3)) {
				middle = new Field(b, (a1 + a2) / 2, ((b1 + b2) / 2) + 1);

			}
			else {
				middle = new Field(b, (a1 + a2) / 2, (b1 + b2) / 2);
			}
		}
		if (enemy.getMark().getColor() == p.getColor()) {
			throw new NotValidMoveException("");
		}
		// this method is just for 4 player games because it consist teams and it would
		// be easier to implement by a diffrent function..
		if (b.howManyColorsInGame() == 4) {
			if (findPlayedMarks(a1, b1, a2, b2, d, b) == 1) {
				if (b.colorFinder(a1, b1) == p.getColor() && findField(a1, b1, d, b).getMark().getColor() == Color.O) {
					MakeMoveforOne(a1, b2, d, b);
				} else {
					System.out.println("Invalid move..");
				}
			}
			// linestep, sidestep and pushing
			else if (findPlayedMarks(a1, b1, a2, b2, d, b) == 2) {
				// linestep and sidestep
				if (enemy.getMark().getColor() == Color.O && b.colorFinder(a1, b1) == p.getColor()
						&& (b.colorFinder(a2, b2) == p.getColor()
								|| b.colorFinder(a2, b2) == p.getOtherMemberColor(p))) {
					// linestep
					if (findField(a1, b1, d, b) == b.alist.get(a2).get(b2)) {
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					// sidestep
					else if (findField(a1, b1, d, b) != b.alist.get(a2).get(b2)
							&& findField(a1, b1, d, b).getMark().getColor() == Color.O) {
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}

				}
				// pushing
				else if (p.enemyColors(p).contains(enemy.getMark().getColor())) {
					if (findField(enemy.x, enemy.y, d, b).getMark().getColor() == Color.O) {
						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
					} else if (((enemy.y == 0 && d == Direction.WW)
							|| (enemy.y == 0 && enemy.x <= 4 && d == Direction.NW) // this is checking that if the
																					// pushing
							|| (enemy.y == 0 && enemy.x >= 4 && d == Direction.SW) // is going to move a mark that is on
							|| (enemy.x == 0 && d == (Direction.NE) && d == Direction.NW) // border or not, if its on
																							// border
							|| (enemy.x == 8 && d == (Direction.SE) && d == Direction.SW) // kick the mark and -1 point
																							// to
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && d == Direction.EE) // the given player.
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x <= 4 && d == Direction.NW)
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x >= 4 && d == Direction.SE))) {
						b.alist.get(enemy.x).get(enemy.y).setMark(Color.O);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
						p.setTeamScore(p.getTeamScore() + 1);
					}
				}
			}
			else if (findPlayedMarks(a1, b1, a2, b2, d, b) == 3) {
				// linestep
				if (enemy.getMark().getColor() == Color.O && b.colorFinder(a1, b1) == p.getColor()
						&& (b.colorFinder(a2, b2) == p.getColor() || b.colorFinder(a2, b2) == p.getOtherMemberColor(p))
						&& (b.colorFinder(middle.x, middle.y) == p.getColor()
								|| b.colorFinder(middle.x, middle.y) == p.getOtherMemberColor(p))) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(middle.x, middle.y, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
				// sidestep
				else if (findField(a1, b1, d, b).getMark().getColor() == Color.O
						&& findField(middle.x, middle.y, d, b).getMark().getColor() == Color.O
						&& findField(a2, b2, d, b).getMark().getColor() == Color.O
						&& b.alist.get(a1).get(b1) != findField(middle.x, middle.y, d.DirectionOther(), b)
						&& b.colorFinder(a1, b1) == p.getColor()
						&& (b.colorFinder(a2, b2) == p.getColor() || b.colorFinder(a2, b2) == p.getOtherMemberColor(p))
						&& (b.colorFinder(middle.x, middle.y) == p.getColor()
								|| b.colorFinder(middle.x, middle.y) == p.getOtherMemberColor(p))) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(middle.x, middle.y, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
				// pushing
				
				else if (enemy.getMark().getColor() != Color.O && enemy.getMark().getColor() != p.getColor()
						&& enemy.getMark().getColor() != p.getOtherMemberColor(p)
						&& b.colorFinder(a1, b1) == p.getColor()
						&& (b.colorFinder(a2, b2) == p.getColor() || b.colorFinder(a2, b2) == p.getOtherMemberColor(p))
						&& (b.colorFinder(middle.x, middle.y) == p.getColor() || b.colorFinder(middle.x, middle.y) == p.getOtherMemberColor(p))) {			
					// pushing 1 to outside
					if ((((enemy.y == 0 && d == Direction.WW)
							|| (enemy.y == 0 && enemy.x <= 4 && d == Direction.NW)
							|| (enemy.y == 0 && enemy.x >= 4 && d == Direction.SW)
							|| (enemy.x == 0 && (d == (Direction.NE) || d == Direction.NW))
							|| (enemy.x == 8 && (d == (Direction.SE) || d == Direction.SW))
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && d == Direction.EE)
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x <= 4 && d == Direction.NW)
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x >= 4 && d == Direction.SE)))) {
						b.alist.get(enemy.x).get(enemy.y).setMark(Color.O);
						p.setTeamScore(p.getTeamScore()+1);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					else if (findField(enemy.x, enemy.y, d, b).getMark().getColor() == Color.O) {
						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					// pushing 2
					else if (enemy2.getMark().getColor() != Color.O && enemy2.getMark().getColor() != p.getColor()
							&& enemy2.getMark().getColor() != p.getOtherMemberColor(p)
							&& findField(enemy2.x, enemy2.y, d, b).getMark().getColor() == Color.O) {
						MakeMoveforOne(enemy2.x, enemy2.y, d, b);
						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					// pushing 2 to outside
					else if (((enemy2.y == 0 && d == Direction.WW)
							|| (enemy2.y == 0 && enemy2.x <= 4 && d == Direction.NW) // this is checking that if the
																						// pushing
							|| (enemy2.y == 0 && enemy2.x >= 4 && d == Direction.SW) // is going to move a mark that is
																						// on
							|| (enemy2.x == 0 && (d == (Direction.NE) || d == Direction.NW)) // border or not, if its on
																							// border
							|| (enemy2.x == 8 && (d == (Direction.SE) || d == Direction.SW)) // kick the mark and +1 point
																							// to
							|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && d == Direction.EE) // the given player.
							|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && enemy2.x <= 4 && d == Direction.NW)
							|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && enemy2.x >= 4 && d == Direction.SE))) {
						b.alist.get(enemy2.x).get(enemy2.y).setMark(Color.O);
						p.setTeamScore(p.getTeamScore()+1);
						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
				}
			}
		}
		else if (b.colorFinder(a1, b1) != Color.O && b.colorFinder(a2, b2) != Color.O
				&& b.colorFinder(a1, b1) == b.colorFinder(a2, b2) && p.getColor() == b.colorFinder(a1, b1)
				&& p.getColor() == b.colorFinder(a2, b2)) {
			// linestep to an empty field
			if (enemy.getMark().getColor() == Color.O) {
				if (findPlayedMarks(a1, b1, a2, b2, d, b) == 1) {
					MakeMoveforOne(a2, b2, d, b);
				}
				// check if it only choose 2 fields and the direction will make the marks
				// linestep
				else if (findPlayedMarks(a1, b1, a2, b2, d, b) == 2) {
					if (b.alist.get(a1).get(b1) == findField(a2, b2, d.DirectionOther(), b)) {
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					// check if it only chooses 2 field and the direction is diffrent which is
					// sidestepping
					else if ((a1 != findField(a2, b2, d.DirectionOther(), b).x
							&& b1 != findField(a2, b2, d.DirectionOther(), b).y)
							&& findPlayedMarks(a1, b1, a2, b2, d, b) == 2) {
						if (findField(a1, b1, d, b).getMark().getColor() == Color.O) {

							MakeMoveforOne(a2, b2, d, b);
							MakeMoveforOne(a1, b1, d, b);
						}
					}
				}
				// 3 marks to an empty field
				// there is an problem with finding middle
				// ask how to round numbers to the higher number
				else if (findPlayedMarks(a1, b1, a2, b2, d, b) == 3) {
//					checks if its an sidestep
					if (b.alist.get(a1).get(b1) != findField(middle.x, middle.y, d.DirectionOther(), b)
							&& findField(a1, b1, d, b).getMark().getColor() == Color.O
							&& findField(middle.x, middle.y, d, b).getMark().getColor() == Color.O
							&& findField(a2, b2, d, b).getMark().getColor() == Color.O) {

						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}

//					checks if its an Linestep
					else if (middle.x == findField(a1, b1, d, b).x && middle.y == findField(a1, b1, d, b).y
							&& findField(a2, b2, d, b).getMark().getColor() == Color.O) {
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
				}
			}

			// pushing someone
			else if (enemy.getMark().getColor() != Color.O && enemy.getMark().getColor() != b.colorFinder(a2, b2)) {

				if (findPlayedMarks(a1, b1, a2, b2, d, b) == 2) {
					if (whereFriend(a1, b1, b).contains(d) && whereEnemy(a2, b2, b).contains(d)
							&& !whereFriend(enemy.x, enemy.y, b).contains(d)
							&& !whereEnemy(enemy.x, enemy.y, b).contains(d)
							&& ((enemy.y == 0 && d == Direction.WW)
									|| (enemy.y == 0 && enemy.x <= 4 && d == Direction.NW) // this is checking that if
																							// the pushing
									|| (enemy.y == 0 && enemy.x >= 4 && d == Direction.SW) // is going to move a mark
																							// that is on
									|| (enemy.x == 0 && (d == (Direction.NE) || d == Direction.NW)) // border or not, if
																									// its on border
									|| (enemy.x == 8 && (d == (Direction.SE) || d == Direction.SW)) // kick the mark and
																									// -1 point to
									|| (enemy.y == b.alist.get(enemy.x).size() - 1 && d == Direction.EE) // the given
																											// player.
									|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x <= 4 && d == Direction.NW)
									|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x >= 4
											&& d == Direction.SE))) { // only for 2 pushing 1
						// this is checking the color and finds the player with the color;
						p.setPoint(p.getPoint() + 1);
						b.alist.get(enemy.x).get(enemy.y).setMark(Color.O);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);

					}

					else if (whereFriend(a1, b1, b).contains(d) && whereEnemy(a2, b2, b).contains(d)
							&& !whereFriend(enemy.x, enemy.y, b).contains(d)
							&& !whereEnemy(enemy.x, enemy.y, b).contains(d)) {
						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
				}
				if (findPlayedMarks(a1, b1, a2, b2, d, b) == 3) {
					
					// pushing 1 enemy with 3 mark 
					
					if (b.colorFinder(middle.x, middle.y) == b.colorFinder(a1, b1) && b.colorFinder(middle.x, middle.y) == b.colorFinder(a2, b2) &&
							(((enemy.y == 0 && d == Direction.WW)
							|| (enemy.y == 0 && enemy.x <= 4 && d == Direction.NW)
							|| (enemy.y == 0 && enemy.x >= 4 && d == Direction.SW)
							|| (enemy.x == 0 && (d == (Direction.NE) || d == Direction.NW))
							|| (enemy.x == 8 && (d == (Direction.SE) || d == Direction.SW))
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && d == Direction.EE)
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x <= 4 && d == Direction.NW)
							|| (enemy.y == b.alist.get(enemy.x).size() - 1 && enemy.x >= 4 && d == Direction.SE)))) {

					
						b.alist.get(enemy.x).get(enemy.y).setMark(Color.O);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
						p.points++;
					} else if (whereEnemy(a2, b2, b).contains(d) && !whereEnemy(enemy.x, enemy.y, b).contains(d)
							&& findField(enemy.x, enemy.y, d, b).getMark().getColor() == Color.O
							&& !whereFriend(enemy.x, enemy.y, b).contains(d)) {

						MakeMoveforOne(enemy.x, enemy.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}

					// pushing 2 enemies with 3 mark
					if (whereEnemy(a2, b2, b).contains(d) && findField(enemy.x, enemy.y, d, b) == enemy2
							&& whereFriend(enemy.x, enemy.y, b).contains(d)
							&& ((enemy2.y == 0 && d == Direction.WW) 
									|| (enemy2.y == 0 && enemy2.x <= 4 && d == Direction.NW)
									|| (enemy2.y == 0 && enemy2.x >= 4 && d == Direction.SW)
									|| (enemy2.x == 0 && (d == (Direction.NE) || d == Direction.NW))
									|| (enemy2.x == 8 && (d == (Direction.SE) || d == Direction.SW))
									|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && d == Direction.EE)
									|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && enemy2.x <= 4
											&& d == Direction.NW)
									|| (enemy2.y == b.alist.get(enemy2.x).size() - 1 && enemy2.x >= 4
											&& d == Direction.SE))) {

						int xx1 = enemy2.x;
						int yy1 = enemy2.y;
						b.alist.get(xx1).get(yy1).setMark(Color.O);
						int xx = enemy.x;
						int yy = enemy.y;

						MakeMoveforOne(xx, yy, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
						p.setPoint(p.getPoint() + 1);
					} else if (whereFriend(enemy.x, enemy.y, b).contains(d) && 
							findField(enemy.x, enemy.y, d, b) == enemy2 
							&& enemy2.getMark().getColor() == Color.O) {
						int xx1 = enemy2.x;
						int yy1 = enemy2.y;
						MakeMoveforOne(xx1, yy1, d, b);
						int xx = enemy.x;
						int yy = enemy.y;
						MakeMoveforOne(xx, yy, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					else {
						throw new NotValidMoveException("");
					}

				}
			}
		}
		// 24
		else if (p.getColor() != b.colorFinder(a1, b1)) {
			System.out.println("Wrong mark! Please play again..");
		}
	}

	// finds the number of played marks per turn..

	/**
	 * finds the number of played marks per turn.
	 * @param a1 coordinates of the initial marble
	 * @param b1 coordinates of the initial marble
	 * @param a2 coordinates of second initial marble
	 * @param b2 coordinates of second initial marble
	 * @param d Direction
	 * @param b Board
	 * @return the marks which were already played
	 */
	public int findPlayedMarks(int a1, int b1, int a2, int b2, Direction d, Board b) {
		int result = 0;
		if (a1 == a2 && b1 == b2) {
			result = 1;
		}
		else if (Math.abs(a1 - a2) == 1 || Math.abs(b1 - b2) == 1) {
			result = 2;
		}
		// this is not else if because the some 3 mark rows could have (b1-b2) == 1
		if (Math.abs(a1 - a2) == 2 || Math.abs(b1 - b2) == 2) {
			result = 3;
		}
		return result;
	}

}
