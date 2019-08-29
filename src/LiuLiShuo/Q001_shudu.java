package LiuLiShuo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q001_shudu {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/liuli.txt")));
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = sc.nextLine().toCharArray();
        }
        //print(board);
        System.out.println(checkIsValidSudoku(board));
    }

    public static void print(char[][] array){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkIsValidSudoku(char[][] board){
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.' && !row.add(board[i][j]))
                    return false;
                if(board[i][j]!='.' && !col.add(board[i][j]))
                    return false;
                int cubeRow = 3*(i/3)+j/3, cubeCol = 3*(i%3)+j%3;
                if(board[cubeRow][cubeCol] !='.' && !cube.add(board[cubeRow][cubeCol]))
                    return false;
            }
        }
        return true;
    }
}
