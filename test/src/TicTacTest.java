/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrick
 */
public class TicTacTest {
    
    TicTacToeImpl game;
    
    
    @Before
    public void setUp() {
        
        game = new TicTacToeImpl();
    }
    
  

    @Test
    public void BoardMustHaveNineFields(){
        
        int i;
        int j;
        
        game.CreateBoard();//initialize game board
        
        for(i = 0; i < 3; i++){//iterate through newly made 3x3 char matrix
            for(j = 0; j < 3; j++){
                assertEquals("Board should initialize with 9 empty fields.", '\u0000', game.board[i][j]);
            }
        }
    }
    
    @Test
    public void CurrentPlayerSymbolIs_X_ForIDZero(){
       
        assertEquals("Player Zero uses X as symbol.", 'X', game.CurrentPlayer());
    }
    
    @Test
    public void CurrentPlayerSymbolIs_O_ForIDOne(){
        
        game.ChangePlayer();
        
        assertEquals("Player One uses O as symbol.", 'O', game.CurrentPlayer());
    }
    
    @Test
    public void ShouldPlace_X_WhenIDZeroMakesMove(){
        
        //targets describe field in whicht to insert symbol
        int targetRow = 1;
        int targetCol = 2;
        game.CreateBoard();
        game.MakeMove(targetRow, targetCol);
        
        assertEquals("Current Player should have placed X in target field.", 'X', game.board[targetRow][targetCol]);
    }
    
    @Test
    public void ShouldPlace_O_WhenIDOneMakesMove(){
    
        int targetRow = 1;
        int targetCol = 2;
        game.CreateBoard();
        game.ChangePlayer();
        game.MakeMove(targetRow, targetCol);
        
        assertEquals("Current Player should have placed O in target field.", 'O', game.board[targetRow][targetCol]);
        
        
        
    }
    
    @Test
    public void ShouldNotPlaceSymbolInOccupiedField(){
        
        int targetRow = 1;
        int targetCol = 2;
        game.CreateBoard();
        game.MakeMove(targetRow, targetCol);
        game.ChangePlayer();
        
        assertEquals("Current player should NOT be able to place O in same field as previous player's X.", false, game.MakeMove(targetRow, targetCol));
    }
}
