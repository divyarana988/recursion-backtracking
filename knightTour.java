import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();
        
        printKnightsTour(new int[n][n], row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int moveNo) {
        if(r<0 || r>=chess.length || c<0 || c>=chess[0].length || chess[r][c]!=0)
            return;
            
        if(moveNo==chess.length*chess[0].length){
            chess[r][c] = moveNo;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }    
        
        chess[r][c] = moveNo ;
        
        printKnightsTour(chess, r-2, c+1, moveNo+1);
         printKnightsTour(chess, r-1, c+2, moveNo+1);
          printKnightsTour(chess, r+1, c+2, moveNo+1);
           printKnightsTour(chess, r+2, c+1, moveNo+1);
            printKnightsTour(chess, r+2, c-1, moveNo+1);
             printKnightsTour(chess, r+1, c-2, moveNo+1);
              printKnightsTour(chess, r-1, c-2, moveNo+1);
               printKnightsTour(chess, r-2, c-1, moveNo+1);
               
        chess[r][c] = 0;       
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}