package lib.GBSeminarsStudy.seminars;

import controller.io.Output;

public class KnightsMove {

    public static void main(int square) {
        int[][] chess = new int[square][square];
        int[][] moveRule = new int[][] {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,-1}, {2,1}, {-1,-2}, {1,-2}};
//        for (int i = 0; i < chess.length; i++) {
//            for (int j = 0; j < chess[0].length; j++) {
//                chess = new int[square][square];
//                chess[i][j] = 1;
//                solveNKhights(chess, moveRule, i, j, 1)
//            }
//        }
        chess[2][2] = 1;
        solveNKnights(chess, moveRule, 2, 2, 1);
    }

    private static boolean checkPosition(int[][] board, int[][] move, int i, int row, int column) {
        if ((row + move[i][0] < board.length && row + move[i][0] >= 0 ) &&
                (column + move[i][1] < board.length && column + move[i][1] >= 0) ) {
            if (board[row + move[i][0]][column + move[i][1]] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void solveNKnights(int[][] board, int[][] move, int row, int column, int count) {
        if (count == board.length * board[0].length){
            System.out.printf("position: %d,%d\n", row, column);
            Output.consoleArrays(board);
            System.out.println();
            return;
        } else {
            for (int k = 0; k < move.length; k++) {
                if (checkPosition(board, move, k, row, column)) {
                    board[row + move[k][0]][column + move[k][1]] = ++count;
                    solveNKnights(board, move, row + move[k][0], column + move[k][1], count);
                    --count;
                    board[row + move[k][0]][column + move[k][1]] = 0;
                }
            }
        }
    }
}
