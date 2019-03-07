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
      //System.out.println(toString(lake));
      //
      for (int row = 0; row < stomps.length; row++){
        int max = 0;
        int ro = stomps[row][0] - 1;
        int co = stomps[row][1] - 1;
        int le = stomps[row][2];
        for (int y = ro; y < ro + 3 && y < r; y++){
          for (int x = co; x < co + 3 && x < c; x++){
            if (lake[y][x] - le > max){
              max = lake[y][x] - le;
            }
          }
        }
        for (int y = ro; y < ro + 3 && y < r; y++){
          for (int x = co; x < co + 3 && x < c; x++){
            if (lake[y][x] > max){
              lake[y][x] = max;
            }
          }
        }
        //System.out.println(ro + " " + co + " " + le);
        //System.out.println(toString(lake));
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

      return depths * 72 * 72;
    }
    catch(FileNotFoundException e){}
    return 0;
  }

  public static int silver(String filename){
    return 0;
  }

  public static String toString(int[][] array){
     String output = "";
     for (int y = 0; y < array.length; y++){
       for (int x = 0; x < array[0].length; x++){
         output += array[y][x] + " ";
       }
       output += "\n";
     }
     return output;
}

  public static void main(String[] args) {
    System.out.println(USACO.bronze("makelake.2.in") + " = 102762432");
  }
}
