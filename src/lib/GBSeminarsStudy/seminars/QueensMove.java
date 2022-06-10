package lib.GBSeminarsStudy.seminars;

import controller.io.Output;

public class QueensMove {

    public static boolean main(int square) {
        int[][] chess = new int[square][square];
        boolean status = solveNQueen(chess, 0);
        Output.consoleArrays(chess);
        return status;
    }

    private static boolean checkPosition(int[][] board, int row, int column) {
        // горизонтально
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) return false;
        }

        // снизу налево
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // сверху налево
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if (col >= board.length) {
            return true;
        }
        else {
            for (int i = 0; i < board.length; i++) {
                if (checkPosition(board, i, col)) {
                    board[i][col] = 1;

                    if (solveNQueen(board, col + 1)) {
                        return true;
                    }

                    board[i][col] = 0;
                }
            }
        }
        return false;
    }
}
