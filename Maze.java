import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static void main(String[] args) throws FileNotFoundException{
    File text = new File(args[0]);
    Scanner s = new Scanner(text);
    while(s.hasNextLine()){
      String line = s.nextLine();
      System.out.println(line);//hopefully you can do other things with the line
        }
    }
}
