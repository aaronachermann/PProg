

  static ArrayList<ArrayList<Integer>> g;
  static int[] low, dfs;
  static boolean[] vis;
  static int num;
  static int n;
  static boolean[] isCutVertex;
  static ArrayList<ArrayList<Integer>> t;
  static ArrayList<Integer> result = new ArrayList<Integer>();

  public static void main(String[] args) {
    n = In.readInt();
    int m = In.readInt();
    g = new ArrayList<>();
    t = new ArrayList<>();
    dfs = new int[n];
    low = new int[n];
    vis = new boolean[n];
    isCutVertex = new boolean[n];

    for (int i = 0; i < n; i++) {
      g.add(new ArrayList<Integer>());
      t.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < m; i++) {
      int a = In.readInt();
      int b = In.readInt();
      g.get(a).add(b);
      g.get(b).add(a);
    }
    
    
    
    //DFS execution
    for (int i = 0; i < n; i++) {
      dfs_helper(i);
    }

    boolean noPoint = true;
    for (int i = 0; i < n; i++) {
      if (isCutVertex[i]) {
        noPoint = false;
        Out.print(i + " ");
      }
    }

    if (noPoint) {
      Out.print(-1);
    }

    Out.println();
  }

  public static void dfs_helper(int curr) {
    if (dfs[curr] == 0) {
      num = 0;
      int val = dfs(curr);
      if (t.get(curr).size() >= 2) {
        isCutVertex[curr] = true;
      } else {
        isCutVertex[curr] = false;
      }
    }
  }


  public static int dfs(int curr) {
    num++;
    dfs[curr] = num;
    low[curr] = dfs[curr];

    isCutVertex[curr] = false;

    for (Integer next : g.get(curr)) {

      if (dfs[next] == 0) {
        t.get(curr).add(next);
        int val = dfs(next);

        if (val >= dfs[curr]) {
          isCutVertex[curr] = true;
        }
        low[curr] = Math.min(low[curr], val);
      } else if (dfs[next] != 0 && !t.get(curr).contains(next)) {
        low[curr] = Math.min(low[curr], dfs[next]);
      }
    }
    return low[curr];
  }

}
