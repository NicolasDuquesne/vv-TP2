package simpleGame.simpleGame.test;

//It is recommended to import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

// Eclipse might not find this one automatically:
import org.mockito.runners.MockitoJUnitRunner;

import simpleGame.core.Board;
import simpleGame.core.Pawn;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by nduquesne on 25/09/15.
 */

@RunWith(MockitoJUnitRunner.class) // This is required for mocks to work
public class TestBoard {

    @Test
    public void getSizeTest() {
        // Creating context
        Board myBoard = new Board(20, 6, 6, 3, 3);
        // Calling the tested operation

        // Oracle
        assertEquals(6, myBoard.getXSize());
        assertEquals(6, myBoard.getYSize());
    }

   /* @Test
    public void getSquareContentTest(){
        Pawn mockPawn = mock(Pawn.class);
        when(mockPawn).getMock();
        
        when(mockPawn.getX()).thenReturn(4);
        when(mockPawn.getY()).thenReturn(5);

        Board myBoard = new Board(20, 6, 6, 3, 3);

        int x = 4, y = 5;

        assertEquals(mockPawn, myBoard.getSquareContent(x, y));
        
        int xNull = 3, yNull = 2;
        
        assertEquals(mockPawn, myBoard.getSquareContent(xNull, yNull));
    }*/

	@Test
	public void addPawnsTest(){
		Pawn mockPawn = mock(Pawn.class);
        when(mockPawn.getX()).thenReturn(4);
        when(mockPawn.getY()).thenReturn(5);
        
        Board myBoard = new Board(2, 6, 6, 3, 3);
        
        myBoard.addPawn(mockPawn);
        
        assertEquals(3, myBoard.numberOfPawns());        
	}

}

