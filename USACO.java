import java.io.*;
import java.util.*;

public class USACO{
  public static int bronze(String filename){
    try{
      //read in file
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      ArrayList<String> lines = new ArrayList<String>();

      // make variables for the params
      int r = inf.nextInt();
      int c = inf.nextInt();
      int e = inf.nextInt();
      int n = inf.nextInt();

      // makes an array for the lake values
      int[][] lake = new int[r][c];
      for (int row = 0; row < r; row++){
        for (int col = 0; col < c; col++){
          lake[row][col] = inf.nextInt();
        }
      }

      //makes an array of all the stomp commands
      int[][] stomps = new int[n][3];
      for (int row = 0; row < n; row++){
        for (int col = 0; col < 3; col++){
          // each row contained the three params of stomp
          stomps[row][col] = inf.nextInt();
        }
      }
      //System.out.println(toString(lake));

      //loops through stomp commands
      for (int row = 0; row < stomps.length; row++){
        // keeps track of the highest stomp elevation
        int max = 0;
        //store params
        int ro = stomps[row][0] - 1;
        int co = stomps[row][1] - 1;
        int le = stomps[row][2];
        //loop through the squares with cows on them
        for (int y = ro; y < ro + 3 && y < r; y++){
          for (int x = co; x < co + 3 && x < c; x++){
            //if greater than current max, set max
            if (lake[y][x] - le > max){
              max = lake[y][x] - le;
            }
          }
        }
        for (int y = ro; y < ro + 3 && y < r; y++){
          for (int x = co; x < co + 3 && x < c; x++){
            // if the cows will reach square's level
            if (lake[y][x] > max){
              //set the square to the new max el
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
          //not possible for depth to be negative
          if (e - lake[row][col] > 0){
            //add to total
            depths += (e - lake[row][col]);
          }
        }
      }
      //return volume
      return depths * 72 * 72;
    }
    //if no file
    catch(FileNotFoundException e){}
    return 0;
  }

  public static int silver(String filename){
    try{
      //read in file
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      ArrayList<String> lines = new ArrayList<String>();

      // make variables for the params
      int n = inf.nextInt();
      int m = inf.nextInt();
      int t = inf.nextInt();

      // makes an array for the pasture map
      char[][] pasture = new char[n][m];
      for (int row = 0; row < n + 1; row++){
        String line = inf.next();
        for (int col = 0; col < m + 1; col++){
          pasture[row][col] = line.charAt(col);
        }
      }

      // make variables for given rows and columns
      int r1 = inf.nextInt();
      int c1 = inf.nextInt();
      int r2 = inf.nextInt();
      int c2 = inf.nextInt();

      int row = r1
      int col = c1
      int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};
      int solutions = 0;
      for (int time = t; time > 0; time--){
        //loops that sets permanent
        for (int x = 0; x < r; x++){
          //loops through possible moves
          for (int y = 0; y < 4; y++){
            int newR = row + moves[y][0];
            int newC = col + moves[y][1];
            if (pasture[newR][newC] == '.'){
              row = newR;
              col = newC;
            }
          }
        }
      }
      return solutions;
    }
    catch(FileNotFoundException e){}
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
    System.out.println(USACO.bronze("makelake.4.in") + " = 753121152");
  }
}
