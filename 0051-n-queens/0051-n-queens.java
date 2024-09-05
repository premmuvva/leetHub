import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
  private int n;
  private List<List<String>> builder;
  private String[] template;
  private String[] board;
  public List<List<String>> solveNQueens(int n) {
    // return new AbstractList<List<String>>() {
      List<List<String>> cache = null;
      // @Override
      // public List<String> get(int index) {
        // if (cache == null) 
        cache = solveNQueens1(n);
      return cache;
      //   return cache.get(index);
      // }
      // @Override
      // public int size() {
      //   if (cache == null) 
      //   cache = solveNQueens1(n);
      //   return cache.size();
      // }
    // };
  }
  public List<List<String>> solveNQueens1(int n) {
    this.n = n;
    this.builder = new ArrayList<>();
    this.template = new String[n];
    this.board = new String[n];
    char[] line = new char[n];
    Arrays.fill(line, '.');
    for (int i = 0; i < n; i++) {
      line[i] = 'Q';
      template[i] = String.valueOf(line);
      line[i] = '.';
    }
    enumerateRow(0, 0, 0, 0);
    return builder;
  }
  private void enumerateRow(int i, int shadow0, int shadow1, int shadow2) {
    int shadowSum = shadow0 | shadow1 | shadow2;
    // System.out.printf("%s %s %s \n", Integer.toBinaryString((int)shadow0), Integer.toBinaryString((int)shadow1), Integer.toBinaryString((int)shadow2));
    for (int j = 0; j < n; j++) {
      int cell = 1 << j;
      if ((shadowSum & cell) == 0) {
        board[i] = template[j];
        if (i == n - 1){
            // System.out.printf("%s %s %s \n", Integer.toBinaryString((int)shadow0), Integer.toBinaryString((int)shadow1), Integer.toBinaryString((int)shadow2));
            builder.add(new ArrayList<>(Arrays.asList(board)));
        }else
        enumerateRow(i + 1, (shadow0 | cell) << 1, shadow1 | cell, (shadow2 | cell) >> 1);
      }
    }
  }
}