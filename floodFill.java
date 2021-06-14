import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
        floodfill(arr,0,0, "", new boolean[n][m]);
    }


    public static void floodfill(int[][] maze, int r, int c, String psf, boolean[][]         visited)
    {
        if(r<0 || r>=maze.length || c<0 || c>=maze[0].length || visited[r][c] ||                     maze[r][c]==1){
            return;
        }
        
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(psf);
            return;
        }
        
        visited[r][c] = true;
        
        floodfill(maze,r-1,c,psf+'t',visited);
        floodfill(maze,r,c-1,psf+'l',visited);
        floodfill(maze,r+1,c,psf+'d',visited);
        floodfill(maze,r,c+1,psf+'r',visited);
        
        visited[r][c] = false;
        
        
        
    }
    

}