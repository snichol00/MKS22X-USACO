public class USACO{
  public static int bronze(String filename){
    File text = new File("file.txt");
    Scanner inf = new Scanner(text);
    ArrayList<String> lines = new ArrayList<String>();

    while(inf.hasNextLine()){
          String line = inf.nextLine();
          lines.add(line);
    }

    int[] params = lines.get(0).split(" ");
    int r = params[0];
    int c = params[1];
    int e = params[2];
    int n = params[3];

    String[][] land = new String[r][c];
    for (int row = 1; row <= r; row++){
      land[row - 1] = lines.get(row).split(" ");
    }

    for (int idx = r + 1; idx < ArrayList.size(); idx ++){
      String[] stomp = lines.get(idx).split(" ");
      cowStomp(stomp[0], stomp[1], stomp[2]);
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
