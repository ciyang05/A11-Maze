import java.util.*;


public class ShortestPath {
  
   private static final int INF = Integer.MAX_VALUE;


   public static void main(String[] args) {
       Maze maze = new Maze();
       maze.initDemoMaze();


       MazeLocation start = maze.getStart();
       MazeLocation finish = maze.getFinish();


       Map<MazeLocation,Integer> distance = new HashMap<>();


       Map<MazeLocation,MazeLocation> prev = new HashMap<>();


       distance.put(start,0);


       PriorityQueue<MazeLocation> prique = new PriorityQueue<>(new Comparator<MazeLocation>(){
           @Override
           public int compare(MazeLocation a, MazeLocation b){
               return Integer.compare(distance.get(a), distance.get(b));
           }
       });
       prique.add(start);


       MazeDirection[] directions = { MazeDirection.NORTH, MazeDirection.SOUTH, MazeDirection.EAST, MazeDirection.WEST };


       while(!prique.isEmpty()){
           MazeLocation current = prique.poll();


           if (current.equals(finish)){
               break;
           }


           for (MazeDirection dir : directions) {
               MazeLocation neighbor = current.neighbor(dir);
               int row = neighbor.getRow();
               int col = neighbor.getCol();


               if (row >= 0 && row < maze.getHeight() && col >= 0 && col < maze.getWidth()) {
                   MazeContents content = maze.getContents(row, col);
                   if (content != MazeContents.WALL) {
                       int newDist = distance.get(current) + 1;
                       if (!distance.containsKey(neighbor) || newDist < distance.get(neighbor)) {
                           distance.put(neighbor, newDist);
                           prev.put(neighbor, current);
                           prique.add(neighbor);


                   }
               }
              


           }
       }


      
       MazeLocation pathNode = finish;
       while(pathNode != null && !pathNode.equals(start)){
               maze.setContents(pathNode.getRow(), pathNode.getCol(), MazeContents.PATH);
               pathNode = prev.get(pathNode);
           }




   }


}
  






}
