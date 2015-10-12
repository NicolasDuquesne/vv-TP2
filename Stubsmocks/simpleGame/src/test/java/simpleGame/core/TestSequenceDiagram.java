package simpleGame.core;

//It is recommended to import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

//Eclipse might not find this one automatically:
import org.mockito.runners.MockitoJUnitRunner;

import simpleGame.core.Board;
import simpleGame.core.Game;
import simpleGame.core.Pawn;
import simpleGame.exception.OutOfBoardException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class) // This is required for mocks to work
public class TestSequenceDiagram {
	
	/**
	 * Test de la méthode maxGold().
	 * On initialise un Board et deux Pawns avec mockito.
	 * On vérifie que maxGold retourne la valeur max de gold parmis les pawns.
	 * On change une valeur de gold et on revérifie.
	 */
	@Test
	public void maxGoldTest() throws OutOfBoardException{
		//Initialisation d'un Board.
        Board myBoard = new Board(1, 6, 6, 3, 3);
        
        //Stub d'un Pawn en position 1x4 avec gold=7.
		Pawn mockPawn1 = mock(Pawn.class);
        when(mockPawn1.getX()).thenReturn(1);
        when(mockPawn1.getY()).thenReturn(4);
        when(mockPawn1.getGold()).thenReturn(7);
        
        //Stub d'un Pawn en position 3x4 avec gold=6.
		Pawn mockPawn2 = mock(Pawn.class);
        when(mockPawn2.getX()).thenReturn(3);
        when(mockPawn2.getY()).thenReturn(4);
        when(mockPawn2.getGold()).thenReturn(6);
        
        //Ajout des deux Pawns.
        myBoard.addPawn(mockPawn1);
        myBoard.addPawn(mockPawn2);
        
        //On vérifie que la méthode maxGold() retourne 7 (mockPawn1).
       	assertEquals(7, myBoard.maxGold());
       	
       	//On change le gold de mockPawn2.
        when(mockPawn2.getGold()).thenReturn(9);
        
        //On vérifie que la méthode maxGold() retourne 9 maintenant.
       	assertEquals(9, myBoard.maxGold());
	}
	
	
	@Test
	public void isGameOverTest(){
		//Initialisation d'un Board.
        Board myBoard = new Board(1, 6, 6, 3, 3);
        myBoard.removeAllPawns();
        
        //Stub d'un Pawn en position 1x4 avec gold=1.
		Pawn mockPawn1 = mock(Pawn.class);
        when(mockPawn1.getX()).thenReturn(2);
        when(mockPawn1.getY()).thenReturn(3);
        when(mockPawn1.getGold()).thenReturn(1);
        
        //Stub d'un Pawn en position 3x4 avec gold=3.
		Pawn mockPawn2 = mock(Pawn.class);
        when(mockPawn2.getX()).thenReturn(1);
        when(mockPawn2.getY()).thenReturn(2);
        when(mockPawn2.getGold()).thenReturn(3);
        
        //Ajout des deux Pawns.
        myBoard.addPawn(mockPawn1);
        myBoard.addPawn(mockPawn2);
	}
}
