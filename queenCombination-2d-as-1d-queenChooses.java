import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        
        
        if(qpsf==tq){
            for(boolean arr[]: chess){
                for(boolean v1: arr){
                    if(v1==true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                    
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i= lcno+1; i<tq*tq; i++){
            int r = i/tq;
            int c = i%tq;
            
            chess[r][c] = true;
            queensCombinations(qpsf+1, tq, chess, i);
            chess[r][c] = false;
            
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}