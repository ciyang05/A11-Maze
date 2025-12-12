/* This class should implement the DisplayableMaze interface */
public class Maze implements DisplayableMaze{
  private int height;
  
  private int width;

  private MazeContents [] [] mazeGrid;

  private MazeLocation start;
  
  private MazeLocation finish;


    /** @return height of maze grid */
    public int getHeight(){
      return height;

    }

    /** @return width of maze grid */
    public int getWidth(){
      return width;

    }

    /** @return contents of maze grid at row i, column j */
    public MazeContents getContents(int i, int j){
      return mazeGrid[i][j];

    }

    /**
     * @param i
     * @param j
     * @param value
     */
    public void setContents(int i, int j, MazeContents value) {
      mazeGrid[i][j] = value;
  }
  

    /** @return return True or False to indicate whether the maze grid is explorable at row i, column j */
    public Boolean checkExplorable(int i, int j){
      return isExplorable(i, j);

    }

    /** @return location of maze start point */
    public MazeLocation getStart(){
      return start ;
  

    }

    /** @return location of maze finish point */
    public MazeLocation getFinish(){
      return finish;

    }

    public boolean isExplorable(int i, int j){

        if ((0 > i) || (0 > j)){
        return false;
      } else if(i >= height || j >= width){
        return false;
      } else if (mazeGrid[i][j] == MazeContents.WALL){
        return false;
      } else if (mazeGrid[i][j] == MazeContents.VISITED){
        return false;
      } else {
        return true;
      }
}

/**
 * starts solving the maze from the start location using recursion
 * @return true if a path to the finish is found and false if not
 */
public boolean solve(){
  return solveRecursive(getStart());
}

/**
 * explore the maze from a given location recursively
 * marks cells as visited, dead ends, or part of the path
 * includes a small delay to allow animation in the viewer
 * @param current the location that is being explored currently
 * @return true if the finish can be reached from this location
 */
private boolean solveRecursive(MazeLocation current) {
  
  // add a short delay so the viewer can animate the search
  try {
    Thread.sleep(7);
  } catch (InterruptedException e) {}

  int row = current.getRow();
  int col = current.getCol();

  //if we reached the finish, mark it as part of the path and return true
  if (current.equals(getFinish())){
    mazeGrid[row][col]= MazeContents.PATH;
    return true;
  }

  //if this cell is not explorable, stop exploring this path
  if (!isExplorable(row, col)){
    return false;
  }

  //mark current cell as visited before checking neighbors 
  mazeGrid[row][col] = MazeContents.VISITED;

  // try all four directions: north, south, east, west
  boolean found = solveRecursive(current.neighbor(MazeDirection.NORTH));
  if (!found) found = solveRecursive(current.neighbor(MazeDirection.SOUTH));
  if (!found) found = solveRecursive(current.neighbor(MazeDirection.EAST));
  if (!found) found = solveRecursive(current.neighbor(MazeDirection.WEST));

  //after exploring, mark cell as path or dead end 
  if (found) {
    mazeGrid[row][col] = MazeContents.PATH;
  } else {
    mazeGrid[row][col] = MazeContents.DEAD_END;
  }

  return found;
}


    /** This DemoMaze method will allow you to generate a simple maze
     * to test your code on as you develop it. Ultimately, you need
     * to accept maze files as command line inputs or standard input.
     * You will need to implement the DisplayableMaze interface before you
     * can run the initDemoMaze method.
     * * @author Tianah Gooden
     * * @version October 17th 2023
     */
    public void initDemoMaze(){ //String fileName, 
        this.height = 10;
        this.width = 8;
        this.mazeGrid = new MazeContents[height][width];
        this.start = new MazeLocation(1,1);
        this.finish = new MazeLocation(8,6);

        this.mazeGrid[0][0] = MazeContents.WALL; this.mazeGrid[0][1] = MazeContents.WALL; this.mazeGrid[0][2] = MazeContents.WALL; this.mazeGrid[0][3] = MazeContents.WALL; this.mazeGrid[0][4] = MazeContents.WALL; this.mazeGrid[0][5] = MazeContents.WALL; this.mazeGrid[0][6] = MazeContents.WALL; this.mazeGrid[0][7] = MazeContents.WALL;
        this.mazeGrid[1][0] = MazeContents.WALL; this.mazeGrid[1][1] = MazeContents.OPEN; this.mazeGrid[1][2] = MazeContents.OPEN; this.mazeGrid[1][3] = MazeContents.OPEN; this.mazeGrid[1][4] = MazeContents.OPEN; this.mazeGrid[1][5] = MazeContents.OPEN; this.mazeGrid[1][6] = MazeContents.WALL; this.mazeGrid[1][7] = MazeContents.WALL;
        this.mazeGrid[2][0] = MazeContents.WALL; this.mazeGrid[2][1] = MazeContents.WALL; this.mazeGrid[2][2] = MazeContents.OPEN; this.mazeGrid[2][3] = MazeContents.WALL; this.mazeGrid[2][4] = MazeContents.WALL; this.mazeGrid[2][5] = MazeContents.OPEN; this.mazeGrid[2][6] = MazeContents.WALL; this.mazeGrid[2][7] = MazeContents.WALL;
        this.mazeGrid[3][0] = MazeContents.WALL; this.mazeGrid[3][1] = MazeContents.OPEN; this.mazeGrid[3][2] = MazeContents.WALL; this.mazeGrid[3][3] = MazeContents.OPEN; this.mazeGrid[3][4] = MazeContents.OPEN; this.mazeGrid[3][5] = MazeContents.OPEN; this.mazeGrid[3][6] = MazeContents.WALL; this.mazeGrid[3][7] = MazeContents.WALL;
        this.mazeGrid[4][0] = MazeContents.WALL; this.mazeGrid[4][1] = MazeContents.OPEN; this.mazeGrid[4][2] = MazeContents.OPEN; this.mazeGrid[4][3] = MazeContents.OPEN; this.mazeGrid[4][4] = MazeContents.WALL; this.mazeGrid[4][5] = MazeContents.WALL; this.mazeGrid[4][6] = MazeContents.OPEN; this.mazeGrid[4][7] = MazeContents.WALL;
        this.mazeGrid[5][0] = MazeContents.WALL; this.mazeGrid[5][1] = MazeContents.OPEN; this.mazeGrid[5][2] = MazeContents.WALL; this.mazeGrid[5][3] = MazeContents.OPEN; this.mazeGrid[5][4] = MazeContents.OPEN; this.mazeGrid[5][5] = MazeContents.WALL; this.mazeGrid[5][6] = MazeContents.WALL; this.mazeGrid[5][7] = MazeContents.WALL;
        this.mazeGrid[6][0] = MazeContents.WALL; this.mazeGrid[6][1] = MazeContents.OPEN; this.mazeGrid[6][2] = MazeContents.WALL; this.mazeGrid[6][3] = MazeContents.WALL; this.mazeGrid[6][4] = MazeContents.OPEN; this.mazeGrid[6][5] = MazeContents.OPEN; this.mazeGrid[6][6] = MazeContents.OPEN; this.mazeGrid[6][7] = MazeContents.WALL;
        this.mazeGrid[7][0] = MazeContents.WALL; this.mazeGrid[7][1] = MazeContents.OPEN; this.mazeGrid[7][2] = MazeContents.WALL; this.mazeGrid[7][3] = MazeContents.OPEN; this.mazeGrid[7][4] = MazeContents.OPEN; this.mazeGrid[7][5] = MazeContents.WALL; this.mazeGrid[7][6] = MazeContents.OPEN; this.mazeGrid[7][7] = MazeContents.WALL;
        this.mazeGrid[8][0] = MazeContents.WALL; this.mazeGrid[8][1] = MazeContents.OPEN; this.mazeGrid[8][2] = MazeContents.OPEN; this.mazeGrid[8][3] = MazeContents.WALL; this.mazeGrid[8][4] = MazeContents.OPEN; this.mazeGrid[8][5] = MazeContents.WALL; this.mazeGrid[8][6] = MazeContents.OPEN; this.mazeGrid[8][7] = MazeContents.WALL;
        this.mazeGrid[9][0] = MazeContents.WALL; this.mazeGrid[9][1] = MazeContents.WALL; this.mazeGrid[9][2] = MazeContents.WALL; this.mazeGrid[9][3] = MazeContents.WALL; this.mazeGrid[9][4] = MazeContents.WALL; this.mazeGrid[9][5] = MazeContents.WALL; this.mazeGrid[9][6] = MazeContents.WALL; this.mazeGrid[9][7] = MazeContents.WALL;
  }
  
  //Testing
  public static void main(String args[]){
    Maze maze = new Maze();
    maze.initDemoMaze();

    System.out.println("Height" + maze.getHeight());
    System.out.println("Width" + maze.getWidth());
    System.out.println("Start" + maze.getStart());
    System.out.println("Finish" + maze.getFinish());
    System.out.println("Contents at (1,1)" + maze.getContents(1, 1));
    System.out.println("Check (1,1)" + maze.checkExplorable(1, 1));
    System.out.println("Check (0,0)"+ maze.checkExplorable(0, 0));
  }
}
