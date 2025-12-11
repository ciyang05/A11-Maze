import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class SolveMaze {

  /**
   * reads a file then adds each line into an array
   * adds each array into a temporary arraylist then converts into array, calling encodeMaze
   * @param fname
   * @return
   */
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
    char[][] maze = tempMaze.toArray(new char[tempMaze.size()][]);
    encodeMaze(maze);


    return file;
  }

  /**
   * encodes each maze location with the maze content
   * @param maze
   */
  public static void encodeMaze(char[][] maze) {
    // rows of the maze array
    int height = maze.length;
    // columns of the maze array
    int width = maze[0].length;

    // creates a new 2D array holding the MazeLocations
    MazeLocation[][] locations = new MazeLocation[height][width];

    // creates a new 2D array holding the maze contents
    MazeContents[][] contents = new MazeContents[height][width];

    // iterates through the maze, enumerating the appropriate character,
    // storing it into contents. Also creates a new maze location, holding that in locations
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (maze[i][j] == '#') {
          locations[i][j] = new MazeLocation(i, j);
          MazeContents m = MazeContents.WALL;
          contents[i][j] = m;
        }
        if (maze[i][j] == '.') {
          locations[i][j] = new MazeLocation(i, j);
          MazeContents n = MazeContents.OPEN;
          contents[i][j] = n;
        }
        if (maze[i][j] == 'S') {
          locations[i][j] = new MazeLocation(i, j);
        }
        if (maze[i][j] == 'F') {
          locations[i][j] = new MazeLocation(i, j);
        }
      }
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
