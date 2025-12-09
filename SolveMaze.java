import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class SolveMaze {

  public static Scanner readMaze(String fname){
    Scanner file = null;
    try {
      file = new Scanner(new File(fname));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);  
    }

    // arraylist that'll hold each line of file
    ArrayList<String> tempMaze = new ArrayList<>();

    // read each line in the file and add it to an arraylist
    while (file.hasNextLine()) {
      String line = file.nextLine();
      tempMaze.add(line);
    }

    // convert the arraylist tempMaze to an array
    String[] maze = tempMaze.toArray(new String[0]);
    encodeMaze(maze);

    // ask why we are returning the file
    return file;
  }

  public static void encodeMaze(String[] maze) {
    if (c == '#') {
      
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
