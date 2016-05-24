import java.util.*;

class DoubleLinear {
  private static List<Integer> u;
  private static boolean initialized = false;
  public static int dblLinear (int n) {
    if(!initialized){ fillU(); }
    return u.get(n);
  }
  private static void fillU(){
    TreeSet<Integer> tmpTree = new TreeSet<>();
    int higher = 1;
    boolean doY = true, doZ = true;
    while(doY | doZ){
      if(doY){ doY=y(higher,tmpTree); }
      if(doZ){ doZ=z(higher,tmpTree); }
    }
    u = new ArrayList<Integer>(tmpTree);
    initialized = true;
  }
  private static boolean y(int x, TreeSet t){
    int tmp = 2*x+1;
    return gt(t,tmp,x);
  }
  private static boolean z(int x, TreeSet t){
    int tmp = 3*x+1;
    return gt(t,tmp,x);
  }
  private static boolean gt(TreeSet t, int b, int a){
    if(b>a){
      t.add(b);
      a = (Integer)t.higher(a);
      return true;
    } else {
      return false;
    }
  }
}
