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

      int[][] land = new int[r][c];
      for (int row = 0; row < r; row++){
        for (int col = 0; col < c; col++){
          land[row][col] = inf.nextInt();
        }
      }

      int[][] stomps = new int[n][3];
      for (int row = 0; row <= n; row++){
        for (int col = 0; col < 3; col++){
          stomps[row][col] = inf.nextInt();
        }
        cowStomp(stomp[row][0], stomp[row][1], stomp[row][2]);
      }

    private void cowStop(int row, int col, int depth){
      for (; row < row + 3; row++){
        for (; col < col + 3; col++){
          land[row][col] -= depth;
        }
      }
    }

    int output = 0;
  }

  public static int silver(String filename){

  }
}
