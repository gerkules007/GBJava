package lib.AlgorithmsCollection;

import java.util.LinkedList;
import java.util.Queue;

public class AlgorithmLi {
    private final int[][] desk;
    private final int[][] STEPS = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
    private final Queue<int[]> queue;
    private final int[] start;
    public AlgorithmLi(int[][] desk, int[] start) {
        this.desk = desk;
        this.start = start;
        queue = new LinkedList<>();
    }

    public void search() {
        desk[start[0]][start[1]] = 1;
        queue.add(start);
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            if (desk[point[0]][point[1]] == -2) return;
            addPoints(point[0], point[1]);
        }
    }

    private void addPoints(int row, int column) {
        int cost = desk[row][column];
        for (int[] step : STEPS) {
            int newRow = row + step[0];
            int newColumn = column + step[1];
            if (checkPosition(newRow, newColumn)) {
                desk[newRow][newColumn] = cost + 1;
                queue.add(new int[] {newRow, newColumn});
            }
        }
    }
    private boolean checkPosition(int row, int column) {
        return     (row < desk.length       && row >= 0 )
                && (column < desk[0].length && column>= 0)
                && desk[row][column] == 0;
    }
    public int[][] getDesk() {
        return desk;
    }
}
