import java.io.*;
import java.util.*;

public class USACO{
  public static int bronze(String filename){
    try{
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      ArrayList<String> lines = new ArrayList<String>();

      int r = inf.nextInt();
      int c = inf.nextInt();
      int e = inf.nextInt();
      int n = inf.nextInt();

      int[][] lake = new int[r][c];
      for (int row = 0; row < r; row++){
        for (int col = 0; col < c; col++){
          lake[row][col] = inf.nextInt();
        }
      }

      int[][] stomps = new int[n][3];
      for (int row = 0; row < n; row++){
        for (int col = 0; col < 3; col++){
          stomps[row][col] = inf.nextInt();
        }
      }

      for (int row = 0; row < stomps.length; row++){
        for (int y = stomps[row][0]; y < 3; y++){
          for (int x = stomps[row][1]; x < 3; x++){
            lake[y][x] -= stomps[row][2];
          }
        }
      }

      //find depths
      int depths = 0;
      for (int row = 0; row < r; row++){
        for (int col = 0; col < c; col++){
          if (e - lake[row][col] > 0){
            depths += (e - lake[row][col]);
          }
        }
      }

      return depths * r * c;
    }
    catch(FileNotFoundException e){}
    return 0;
  }

  public static int silver(String filename){
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(USACO.bronze("makelake.2.in"));
  }
}
