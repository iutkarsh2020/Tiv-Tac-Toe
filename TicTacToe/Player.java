/**
 * Auto Generated Java Class.
 */
public abstract class Player {
  
  /* ADD YOUR CODE HERE */
  abstract public TicTacToe chooseMove(TicTacToe board);//returns one of the possible moves
  public double boardValue(TicTacToe board){// will tell how good is this board for current player
    // check checkWin checkLose in TicTacToe class, not an abstract class
    // how good the board is for this player
    double ans = 0;
    if(board.checkWin(this)){
      // this player has won
      ans = 1.0;
    }
    if(board.checkLose(this)){
      ans = -1.0; 
    }
    return ans;
  }
}
