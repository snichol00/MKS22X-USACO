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
      int[][] pasture = new int[n][m];
      for (int row = 0; row < n; row++){
        String line = inf.next();
        for (int col = 0; col < m; col++){
          if (line.charAt(col) == '*'){
            pasture[row][col] = -1;
          }
          else{
            pasture[row][col] = 0;
          }
        }
      }

      // make variables for given rows and columns
      int r1 = inf.nextInt() - 1;
      int c1 = inf.nextInt() - 1;
      int r2 = inf.nextInt() - 1;
      int c2 = inf.nextInt() - 1;

      //System.out.println(n + " " + m + " " + t + " " + r1 + " " + c1 + " " + r2 + " " + c2);
      //make first move
      pasture[r1][c1] = 1;
      //System.out.println(toString(pasture));
      int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};
      for (int time = t; time > 0; time--){
        int[][] tester = new int[n][m];
        //initializes tester
        for (int r = 0; r < n; r++){
          for (int c = 0; c < m; c++){
            tester[r][c] = pasture[r][c];
          }
        }
        //loops through tester
        for (int x = 0; x < n; x++){
          for (int y = 0; y < m; y++){
            //loops through possible moves
  //          for (int move = 0; move < 4; move++){
  //            int newR = x + moves[move][0];
  //            int newC = y + moves[move][1];
            //checks to see if in bounds
  //            if (newR < n && newC < m && newR >= 0 && newC >= 0){
                //if there is a move there, then add it
    //            if (pasture[newR][newC] > 0 && pasture[x][y] >= 0){
                  tester[x][y] = posMoves(x, y, pasture);//+= pasture[newR][newC];
    //            }
    //          }
    //        }
          }
        }
        pasture = tester;
        //System.out.println(toString(pasture));
      }
      //System.out.println(toString(pasture));
      return pasture[r2][c2];
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
private static int posMoves(int r, int c, int[][] pasture) {
    int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int numMoves = 0;
    if (pasture[r][c] < 0){
      return -1;
    }
    for (int move = 0; move < 4; move++) {
      int newR = r + moves[move][0];
      int newC = c + moves[move][1];
      //checks if in bounds
      try {
        //if new moves possible, add
        if (pasture[newR][newC] > 0){
          numMoves += pasture[newR][newC];
        }
      }
      catch (IndexOutOfBoundsException e){}
    }
    return numMoves;
}

}
