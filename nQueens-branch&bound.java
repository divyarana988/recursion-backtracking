import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
   
    //write your code here
    
    sol(0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], "");
    
  }

    public static void sol(int row, boolean [] col, boolean ndia[], boolean rdia[],String asf){
        int n = col.length;
        
        if(row==n){
            System.out.println(asf+".");
            return;
        }
        
        for(int i=0; i<n;i++){
            
            if(isSafe(row, i, col,ndia, rdia)){
                mark(row, i, col, ndia, rdia);
                sol(row+1, col, ndia, rdia, asf+row+"-"+i+", ");
                unmark(row, i, col, ndia, rdia);
            }
        }
    }
    
    public static boolean isSafe(int r, int c, boolean col[], boolean ndia[], boolean rdia[]){
        int n= col.length;
        return col[c]==false && ndia[r-c+n-1]==false && rdia[r+c]==false;
    }
    
    public static void mark(int r, int c, boolean col[], boolean ndia[], boolean rdia[]){
        int n = col.length;
        col[c] = true;
        ndia[r-c+n-1] = true;
        rdia[r+c] = true;
    }
    
    public static void unmark(int r, int c, boolean col[], boolean ndia[], boolean rdia[]){
        int n = col.length;
        col[c] = false;
        ndia[r-c+n-1] = false;
        rdia[r+c] = false;
    }
   
}