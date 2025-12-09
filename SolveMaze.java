import java.io.*;
import java.util.Scanner;

class SolveMaze {

  public static Scanner readMaze(String fname){
    Scanner file = null;
    try {
      file = new Scanner(new File(fname));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);  
    }

    while (file.hasNextLine()) {
      String line = file.nextLine();
      encodeMaze(line);
    }

    // ask why we are returning the file
    return file;
  }

  public static void encodeMaze(String line) {
    if (c == #) {
      
    }

  }
  
  public static void main(String[] args) {
    if(args.length <= 0){
      System.err.println("Please provide the name of the maze file.");
      System.exit(-1);
    }
    Scanner file = readMaze(args[0]);
    
    // Maze maze = new Maze();
    // MazeViewer viewer = new MazeViewer(maze);
  }
}
