/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class UserPlayer extends Player {
  
  /* ADD YOUR CODE HERE */
  //this class will be used to debug other classes as well
  //we can play the game using PVPGame 
  private String name;
  private Scanner input;
  public UserPlayer(Scanner input,String name){
    this.name = name;
    this.input = input;
  }
  public String toString(){
    return name;
  }
  private void print(char[][] board){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
  public TicTacToe chooseMove(TicTacToe game){
    // first print the current setting of the board
    print(game.getBoard());
    //***** now use possible moves method to print all possible moves
    char[][][] possiblemoves = game.possibleMoves(this);
    System.out.println("The possible moves are - ");
    for(int i=0;i<possiblemoves.length;i++){
      print(possiblemoves[i]);
    }
    System.out.println("Which move among these would you like to play(enter a number 1 if you want to select 1st configuration)?");
    int n = input.nextInt();
    game.setBoard(possiblemoves[n-1]);
    return game;
    //***** ask the user to provide the moves he wishes to make
    //***** return the tictactoe board chosen by the user 
    //assume the user will always enter a valid board
  }
}
