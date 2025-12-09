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

    // arraylist that'll hold arrays 
    // each array will consist of a line's characters
    ArrayList<char[]> tempMaze = new ArrayList<>();

    // read each line in the file and convert it into an array
    // add the array to tempMaze
    while (file.hasNextLine()) {
      char[] charArray = file.nextLine().toCharArray();
      tempMaze.add(charArray);
    }

    // convert the arraylist tempMaze to an array
    char[][] maze = tempMaze.toArray(new char[0]);
    encodeMaze(maze);


    return file;
  }

  public static void encodeMaze(char[][] maze) {
    int height = maze.length;
    int width = maze.

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
