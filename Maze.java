import java.util.*;
import java.io.*;
public class Maze{


  private char[][]maze;
  private boolean animate;//false by default
  private int[] direction = new int[]{0, -1, 0, 1, 1, 0, -1, 0};
  private int startRow, startCol, endRow, endCol;
  /*Constructor loads a maze text file, and sets animate to false by default.
  1. The file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)
  'S' - the location of the start(exactly 1 per file)
  2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
  3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
  throw a FileNotFoundException or IllegalStateException
  */
  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    File f = new File(filename);
    Scanner s = new Scanner(f);
    int row = 0;
    int col = 0;
    int start = 0;
    int end = 0;
    //get dimensions and copy into the next file for easier access
    while (s.hasNextLine()){
      String str = s.nextLine();
      row++;
      col = str.length();
    }
    fixScanner(filename, start, end, row, col, f);
  }

private void fixScanner(String filename, int start, int end, int row, int col, File f) throws FileNotFoundException{
Scanner file = new Scanner(f);
char[][] m = new char[row][col];

for(int i = 0; i < row; i++){
  String line = file.nextLine();
  for (int j = 0; j < col; j++){
    char c = line.charAt(j);
    if (c == 'S'){
      start++;
      startRow = i;
      startCol = j;
    }
    if (c == 'E'){
      end++;
      endRow = i;
      endCol = j;
    }
    m[i][j] = c;
  }
}
if (start > 1 || end > 1) throw new IllegalStateException("Too many STARTS OR ENDS");
if (start == 0 || end == 0) throw new IllegalStateException("Please make sure there is a start and end point");
}


    public static void main(String[] args) throws FileNotFoundException{
      Maze m = new Maze("Maze1.txt");
    }


    private void wait(int millis){
      try {
        Thread.sleep(millis);
      }
      catch (InterruptedException e) {
      }
    }


    public void setAnimate(boolean b){

      animate = b;

    }


    public void clearTerminal(){

      //erase terminal, go to top left of screen.

      System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
      return 1;
      //find the location of the S.


      //erase the S


      //and start solving at the location of the s.

      //return solve(???,???);

    }

    /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.


    Postcondition:

    The S is replaced with '@' but the 'E' is not.

    All visited spots that were not part of the solution are changed to '.'

    All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private


      //automatic animation! You are welcome.
      if(animate){

        clearTerminal();
        System.out.println(this);

        wait(20);
      }

      //COMPLETE SOLVE

      return -1; //so it compiles
    }


  }
