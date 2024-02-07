/**
 * Auto Generated Java Class.
 */
// this class will model the game board itself
public class TicTacToe {
  
  /* ADD YOUR CODE HERE */
  private char[][] board;// will be a 3*3 board
  private Player x;
  private Player o;
  // 2 private fields that will be references to player subclasses will come here
  public TicTacToe(Player x,Player o){
    this.x = x;
    this.o = o;
    board = new char[3][3];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        board[i][j] = '_'; 
      }
    }
  }
  public int countBlanks(){
    int n = 0;
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='_')
          n++;
      }
    }
    return n;
  }
  public char markerForPlayer(Player p){
    if(p.equals(x))
      return 'X';
    else
      return 'O';
  }
  public boolean checkwin(char c){
    if((board[0][0]==c && board[0][1]==c && board[0][2]==c) || (board[1][0]==c && board[1][1]==c && board[1][2]==c) || (board[2][0]==c && board[2][1]==c && board[2][2]==c))
      return true;
    if((board[0][0]==c && board[1][0]==c && board[2][0]==c) ||(board[0][1]==c && board[1][1]==c && board[2][1]==c) || (board[0][2]==c && board[1][2]==c && board[2][2]==c))
      return true;
    if((board[0][0]==c && board[1][1]==c && board[2][2]==c) ||(board[0][2]==c && board[1][1]==c && board[2][0]==c))
      return true;
    return false;
  }
  public boolean checkWin(Player p){
    if(p.equals(x)){
      return checkwin('X');
    }
    else
      return checkwin('O');
  }
  public boolean checkLose(Player p){
    if(p.equals(x)){
      return (!checkwin('X'));
    }
    else
      return (!checkwin('O'));
  }
  public boolean checkDraw(){
    // will return true if match is a draw
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='_')
          return false;
      }
    }
    return !(checkWin(o) || checkWin(x));
  }
  public String toString(){
    // converting the current board to a string
    String s ="";
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        s = s+board[i][j];
      }
      if(i<2)
        s = s+"\n";
    }
    return s;
  }
  private char[][] makecopy(){
    char[][] ans = new char[3][3];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        ans[i][j] = board[i][j];
      }
    }
    return ans;
  }
  public char[][][] possibleMoves(Player p){
    // returns possible array of tictactoe boards
    int size = countBlanks();
    char[][][] ans = new char[size][3][3];
    char playerchar = markerForPlayer(p);
    int k=0;
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='_'){
          char[][] deepcopy = makecopy();// making a deepcopy of this board
          deepcopy[i][j] = playerchar;
          ans[k] = deepcopy;
          k++;
        }
      }
    }
    return ans;
  }
  public Player getPlayerx(){
   return x; 
  }
  public void setPlayerx(Player x){
    this.x = x;
  }
  public Player getPlayero(){
   return o; 
  }
  public void setPlayero(Player o){
    this.o = o;
  }
  public char[][] getBoard(){
    return board;
  }
  public void setBoard(char[][] b){
    board = b;
  }
}
