package simpleGame.core;

//It is recommended to import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

//Eclipse might not find this one automatically:
import org.mockito.runners.MockitoJUnitRunner;

import simpleGame.core.Board;
import simpleGame.core.Direction;
import simpleGame.core.Pawn;
import simpleGame.exception.OutOfBoardException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class) // This is required for mocks to work
public class TestPawn {

	/**
	 * Test de l'ensemble des getters.
	 * On initialise un Board avec mockito et un pawn
	 * On vérifie que les méthodes getX(), getY(), getLetter() et getGold()
	 * retournent les bonnes valeurs.
	 */
	@Test
	public void getTest() {
		//Stub d'un board.
		Board mockBoard = mock(Board.class);
		
		//Initialisation d'un Pawn.
		Pawn myPawn = new Pawn('l', 2, 4, mockBoard);
		
		//On vérifie le retour des getters.
		assertEquals(2, myPawn.getX());
		assertEquals(4, myPawn.getY());
		assertEquals('l', myPawn.getLetter());
		assertEquals(0, myPawn.getGold());        
    }
	
	/**
	 * Test de la méthode move().
	 * On initialise un Board avec mockito et un Pawn
	 * On faut bouger le Pawn et on vérifie au fur et à mesure que la position
	 * de celui-ci change.
	 */
	@Test
    public void moveTest() throws OutOfBoardException{
		//Stub d'un board.
		Board mockBoard = mock(Board.class);
        when(mockBoard.getXSize()).thenReturn(4);
        when(mockBoard.getYSize()).thenReturn(4);
        
        //Initialisation du Pawn.
		Pawn myPawn = new Pawn('l', 1, 3, mockBoard);
		
		//On bouge le Pawn et on vérifie en même temps.
		myPawn.move(Direction.Right);
		assertEquals(2, myPawn.getX());
		
		myPawn.move(Direction.Down);
		assertEquals(2, myPawn.getY());
		
		myPawn.move(Direction.Left);
		assertEquals(1, myPawn.getX());
		
		myPawn.move(Direction.Up);
		assertEquals(3, myPawn.getY());
	}

	/**
	 * Test de la méthode isDead().
	 */
	@Test
    public void isDeadTest() throws OutOfBoardException {
		//Stub d'un board.
		Board mockBoard = mock(Board.class);
        when(mockBoard.getXSize()).thenReturn(4);
        when(mockBoard.getYSize()).thenReturn(4);
        when(mockBoard.isBonusSquare(2,2)).thenReturn(true);
        when(mockBoard.numberOfPawns()).thenReturn(0);
        
        Pawn myPawn1 = new Pawn('l', 2, 2, mockBoard);        
		Pawn myPawn2 = new Pawn('m', 1, 2, mockBoard);
		myPawn2.move(Direction.Right);
		myPawn1.move(Direction.Left);
		myPawn2.move(Direction.Left);
		
		assertFalse(myPawn1.isDead());
    }
}
