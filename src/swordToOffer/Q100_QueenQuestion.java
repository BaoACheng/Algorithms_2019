package swordToOffer;

public class Q100_QueenQuestion {

    public void EightQueen(int chessNumber) {
        int[][] chess = GetChessBoard(chessNumber);
        for (int i = 0; i < chessNumber; i++) {
            for (int j = 0; j < chessNumber; j++) {
                putQueen(chess, i, j);
            }
        }
    }

    public int[][] GetChessBoard(int number) {
        int[][] chess = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                chess[i][j] = 0;
            }
        }
        return chess;
    }



    public void putQueen(int[][] chess, int row, int col) {
        int rows = chess.length;
        int cols = chess[0].length;
        //皇后位置从上到下置为1
        for (int i = 0; i < rows; i++) {
            chess[i][col] = 1;
        }
        //皇后位置从左至右置为1
        for (int i = 0; i < cols; i++) {
            chess[row][i] = 1;
        }
        //左上
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            chess[i][j] = 1;
        //右上
        for (int i = row, j = col; i >= 0 && j < cols; i--, j++) {
            chess[i][j] = 1;
        }
        //右下
        for (int i = row, j = col; i < rows && j < cols; i++, j++) {
            chess[i][j] = 1;
        }
        //左下
        for (int i = row, j = col; i < rows && j >= 0; i++, j--) {
            chess[i][j] = 1;
        }
    }

    public void printChess(int[][] chess) {
        int rows = chess.length;
        int cols = chess[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Q100_QueenQuestion Queen = new Q100_QueenQuestion();
        Queen.EightQueen(8);
    }
}
