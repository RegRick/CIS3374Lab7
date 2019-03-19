
package src;

/**
 *
 * @author patrick
 */
public interface TicTacToe {
    
    public void CreateBoard();
    
    public char CurrentPlayer();
    
    public void ChangePlayer();
    
    public boolean MakeMove(int row, int col);
    
    public boolean SpaceIsOccupied(int row, int col);
    
}
