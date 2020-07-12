package finalProject.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import finalProject.Board;
import finalProject.Direction; 
import finalProject.Move;
import finalProject.Exceptions.NotValidPlayerException;

public class MoveTest {
	
	Board b;
	Move m;
	@BeforeEach
	public void setup () throws NotValidPlayerException {
		b = new Board();
		b.setup(2);
		m = new Move();
		
	}

	@Test
	public void ValidMovesTest1() throws NotValidPlayerException {
		assertFalse(m.ValidMoves(6, 2, b).contains(Direction.SW));		
	}
	@Test
	public void ValidMovesTest2() {
		assertTrue(m.ValidMoves(0, 0, b).size() == 0);
	}
	@Test
	public void ValidMovesTest3() {
		List<Direction> a = new ArrayList<Direction>(2);
		a.add(Direction.NW);
		a.add(Direction.NE);
		assertEquals(a , m.ValidMoves(6, 3, b));
	}
	@Test
	public void whereFriendTest() {
		assertTrue(m.whereFriend(6,2,b).contains(Direction.SE));
		assertFalse(m.whereEnemy(1,1,b).contains(Direction.NE));
		assertFalse(m.whereFriend(2,0,b).contains(Direction.WW));
	}
	@Test
	public void whereEnemyTest(){
		assertFalse((m.whereEnemy(1,0,b).contains(Direction.EE)));
		assertFalse(m.whereEnemy(1,1,b).contains(Direction.WW));
	}
	
}