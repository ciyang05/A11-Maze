import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class SolveMaze {

    public static Scanner readMaze(String fname) {
        Scanner file = null;
        try {
            file = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }
        return file;
    }

    public static Maze buildMaze(Scanner file) {
        ArrayList<String> lines = new ArrayList<>();

        while (file.hasNextLine()) {
            lines.add(file.nextLine());
        }
        file.close();

        int height = lines.size();
        int width = lines.get(0).length();

        Maze maze = new Maze();
        maze.height = height;
        maze.width = width;
        maze.mazeGrid = new MazeContents[height][width];

        for (int r = 0; r < height; r++) {
            String line = lines.get(r);
            for (int c = 0; c < width; c++) {
                char ch = line.charAt(c);

                if (ch == '#') {
                    maze.mazeGrid[r][c] = MazeContents.WALL;
                } else if (ch == '.' || ch == ' ') {
                    maze.mazeGrid[r][c] = MazeContents.OPEN;
                } else if (ch == 'S') {
                    maze.mazeGrid[r][c] = MazeContents.OPEN;
                    maze.start = new MazeLocation(r, c);
                } else if (ch == 'F') {
                    maze.mazeGrid[r][c] = MazeContents.OPEN;
                    maze.finish = new MazeLocation(r, c); // fixed
                } else {
                    System.out.println("Invalid character in maze: " + ch);
                    System.exit(-1);
                }
            }
        }

        return maze;
    }


  
  public static void main(String[] args) {
    if(args.length <= 0){
      System.err.println("Please provide the name of the maze file.");
      System.exit(-1);
    }
    Scanner file = readMaze(args[0]);

    Maze maze = buildMaze(file);
    boolean solved = maze.solve();

    if (solved){
      System.out.println("Maze solved!");
    } else {
      System.out.println("No solutions found.");
    }
    
    // Maze maze = new Maze();
    // MazeViewer viewer = new MazeViewer(maze);
  }
}