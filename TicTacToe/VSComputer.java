// VSComputer.java
import java.util.Scanner;
public class VSComputer {
 public static void main(String[] args){
  Scanner s = new Scanner(System.in);
  Player p1 = new UserPlayer(s,"X");// scanner is  s and name is X
  Player p2 = new AIPlayer("O",p1);// name is O and opponent is p1
  TicTacToe board = new TicTacToe(p1,p2);// player x is p1 and player o is p2

  while(!board.checkWin(p1) && !board.checkWin(p2) && !board.checkDraw()){
   board = p1.chooseMove(board);
   Player tmp = p1;
   p1 = p2;
   p2 = tmp;
  }
  if(board.checkWin(p1)){
   System.out.println("Player ["+p1+"] wins!");
  } else if(board.checkWin(p2)){
   System.out.println("Player ["+p2+"] wins!");
  } else if(board.checkDraw()){
   System.out.println("Draw");
  }
  System.out.println("Final game board:");
  System.out.println(board);  
 }
}