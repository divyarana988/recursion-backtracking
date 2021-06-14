import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int [][]arr = new int[n][n];
        
        printNQueens(arr, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int r) {
        
        if(r==chess.length){
            System.out.println(qsf+".");
            return;
        }
        
        for(int col=0; col<chess[0].length; col++){
            if(isSafe(chess, r, col)){
                chess[r][col] = 1;
                printNQueens(chess, qsf+r+"-"+col+", ", r+1);
                chess[r][col] = 0;
            }
        }
    }
    
    public static boolean isSafe(int[][]chess, int r, int c){
        for(int i=r-1, j=c; i>=0; i--){
            if(chess[i][j]==1)
                return false;
        }
        
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--,j--){
            if(chess[i][j]==1)
                return false;
        }
        
        for(int i=r-1, j=c+1; i>=0 && j<chess[0].length; i--,j++){
            if(chess[i][j]==1)
                return false;
        }
        
        return true;
    }
}