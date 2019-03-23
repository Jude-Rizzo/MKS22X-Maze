import java.util.*;
import java.io.*;
public class Maze{


  private char[][]maze;
  private int[] moves = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
  private boolean animate;//false by default
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
  public Maze(String filename) throws FileNotFoundException {
           File text = new File(filename);
           Scanner s = new Scanner(text);
           int row = 0;
           int col = 0;
           int scount = 0;
           int ecount = 0;
           while (s.hasNextLine()) {
                   String line = s.nextLine();
                   col = line.length();
                   row++;
           }

           s = new Scanner(text);
           maze = new char[row][col];
           int countRow = 0;

           while (s.hasNextLine()) {
                   String line = s.nextLine();
                   for (int i = 0; i < line.length(); i++) {
                           maze[countRow][i] = line.charAt(i);
                           if(line.charAt(i) == 'S'){
                             startRow = countRow;
                             startCol = i;
                             scount ++;
                           }
                           if(line.charAt(i) == 'E'){
                             endRow = countRow;
                             endCol = i;
                             ecount ++;
                           }
                   }
                   countRow++;
           }
           animate = false;
           if(scount !=1 || ecount != 1) throw new IllegalStateException();

   }


  public String toString(){
    String output = "";
    for (int r = 0; r < maze.length; r++){
      for (int c = 0; c < maze[r].length; c++){
        output += maze[r][c];
      }
      output += "\n";
    }
    return output;
  }

  public void copyToArray(String m, int size, int length){
    int r = 0;
    int c = 0;
    for(int i = 0; i < m.length(); i++){
      if (r < size){
        if (m.charAt(i) == '\n'){
          r++;
        }
        if (c >= length){
          c = 0;
        }
        else{
          maze[r][c] = m.charAt(i);
          c++;
        }
      }
    }
  }


  public static void main(String[] args) throws FileNotFoundException{
    Maze m = new Maze("Maze1.txt");
    m.solve();
    System.out.println(m);
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
    //erase terminal, go to top left of screen
    System.out.println("\033[2J\033[1;1H");

  }



  /*Wrapper Solve Function returns the helper function

  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

  */
  public int solve(){
    maze[startRow][startCol] = ' ';
      return solve(startRow,startCol,0);

  }

  private int solve(int row, int col, int count){
      //automatic animation! You are welcome.
      if(animate){
        clearTerminal();
        System.out.println(this);
        wait(10);
      }
      //if end is reached
      if (maze[row][col] == 'E'){
        return count;
      }
      //if the loc is not an empty spot
      if (maze[row][col] != ' '){
        return -1;
      }
      //loop through each moves
      for (int i = 0; i < moves.length; i+=2){
        //mark the place you are with @
        maze[row][col] = '@';
        int next = solve(row + moves[i],col + moves[i+1],count+1);
        if (next != -1){
          return next;
        }
        //mark the place you been to with a period
        maze[row][col] = '.';
      }
      return -1;
    }



}
