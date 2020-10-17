import java.util.ArrayList;
import java.util.Collections;

public class Board {
  private int[] board;
  private ArrayList<Integer> player1;
  private ArrayList<Integer> player2;

  private ArrayList<ArrayList<Integer>> combinations;

  public Board() {
    board = new int[9];
    player1 = new ArrayList<Integer>();
    player2 = new ArrayList<Integer>();

    for (int i = 0; i < 9; i++)
      board[i] = 0;

    combinations = new ArrayList<ArrayList<Integer>>();
  }

  public int getBoard(int i) {
    return board[i];
  }

  public void setBoard(int i, int p) {
    board[i - 1] = p;

    if (p == 1)
      player1.add(i);
    else
      player2.add(i);
  }

  public void displayBoard() {
    String r = "";

    for (int i = 0; i < 9; i++) {
      if (board[i] == 0)
        r += "~";
      else if (board[i] == 1)
        r += "X";
      else
        r += "O";

      if (r.length() == 5 || r.length() == 11)
        r += "\n";
      else
        r += " ";
    }

    System.out.println(r);
  }

  public ArrayList<Integer> getPlayer1() {
    return player1;
  }

  public ArrayList<Integer> getPlayer2() {
    return player2;
  }

  public boolean hasRow(ArrayList<Integer> arr) {
    if (arr.size() == 3) {
      return cycle3(arr);
    } else if (arr.size() == 4)
      return cycle(arr, 4);
    else if (arr.size() == 5)
      return cycle(arr, 5);
    else
      return false;
  }

  public void populateCombinations() {
    ArrayList<Integer> p1 = new ArrayList<Integer>();
    Collections.addAll(p1, 1, 2, 3);
    ArrayList<Integer> p2 = new ArrayList<Integer>();
    Collections.addAll(p2, 4, 5, 6);
    ArrayList<Integer> p3 = new ArrayList<Integer>();
    Collections.addAll(p3, 7, 8, 9);
    ArrayList<Integer> p4 = new ArrayList<Integer>();
    Collections.addAll(p4, 1, 4, 7);
    ArrayList<Integer> p5 = new ArrayList<Integer>();
    Collections.addAll(p5, 2, 5, 8);
    ArrayList<Integer> p6 = new ArrayList<Integer>();
    Collections.addAll(p6, 3, 6, 9);
    ArrayList<Integer> p7 = new ArrayList<Integer>();
    Collections.addAll(p7, 1, 5, 9);
    ArrayList<Integer> p8 = new ArrayList<Integer>();
    Collections.addAll(p8, 3, 5, 7);

    Collections.addAll(combinations, p1, p2, p3, p4, p5, p6, p7, p8);

  }

  public boolean cycle3(ArrayList<Integer> list) {
    int a = 0;
    int b = 0;
    int c = 0;

    for (Integer i : list) {
      if (i > c) {
        a = b;
        b = c;
        c = i;
      } else if (i > b) {
        a = b;
        b = i;
      } else
        a = i;
    }
    this.populateCombinations();

    for (ArrayList<Integer> combination : combinations) {
      if (combination.contains(a) && combination.contains(b) && combination.contains(c))
        return true;
    }

    return false;
  }

  public boolean cycle(ArrayList<Integer> list, int n) {
    ArrayList<Integer> group = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      int k = n - 1;
      int t = 0;

      while (k > 0) { // Creates the array that will get tested
        if (k > i)
          group.add(list.get(t));
        else
          group.add(list.get(t + 1));
        k--;
        t++;
      }

      if (group.size() == 3 && cycle3(group))
        return true;
      else if (cycle(group, n - 1))
        return true;
      group.clear();
    }

    return false;
  }

  /*
   * 
   * public boolean cycle5(ArrayList<Integer> list) { ArrayList<Integer> four =
   * new ArrayList<Integer>();
   * 
   * for (int i = 0; i < 4; i++) four.set(i, 0);
   * 
   * for (int i = 0; i < 5; i++) { if (i < 4) four.set(0, list.get(0)); else
   * four.set(0, list.get(1)); if (i < 3) four.set(1, list.get(1)); else
   * four.set(1, list.get(2)); if (i < 2) four.set(2, list.get(2)); else
   * four.set(2, list.get(3)); if (i < 1) four.set(3, list.get(3)); else
   * four.set(3, list.get(4));
   * 
   * if (cycle4(four)) return true; }
   * 
   * return false; }
   */
}
