package src;

import java.util.*;



/**
 *
 * @author patrick
 */
public class TicTacToeImpl implements TicTacToe{

    char[][] board = null;
    int currentPlayerId = 0;//always start with player 0 (X)
    
    @Override
    public void CreateBoard(){
       this.board = new char[3][3];//create 3x3 char matrix to represent board, initializes to null chars '\u0000'
    }
    
    @Override
    public char CurrentPlayer(){
        
        char playerSym;//symbol to be returned
        
        if(currentPlayerId == 0){
            playerSym = 'X';//player 0 is x
        }
        else{
            playerSym = 'O';//player 1 is O
        }
        
        return playerSym;//return appropriate player symbol
    }
    
    @Override
    public void ChangePlayer(){
        
        if(currentPlayerId == 0){//if the current player is 0, then return to 1, assign to current player
            currentPlayerId = 1;
        }
        else {//if the current player is not 0 (is 1), then return 0, assign to current player
            currentPlayerId = 0;
        }
        
    }
    
    @Override
    public boolean MakeMove(int row, int col){
        if(SpaceIsOccupied(row, col)){
            System.out.println("Space is Occupied!");
            return false;//failure, return false
            
        }
        
        this.board[row][col] = this.CurrentPlayer();
        return true;//success, return true
        
        
    }
    
    @Override
    public boolean SpaceIsOccupied(int row, int col){
        
        return (this.board[row][col] == 'X') || (this.board[row][col] == 'O'); //space is occupied, true. Unoccupied, false
        
    }
    
}
