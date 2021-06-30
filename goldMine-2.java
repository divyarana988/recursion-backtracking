import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		boolean [][] vis = new boolean [arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++){
		    for(int j=0; j<arr[0].length; j++){
		        
		        if(arr[i][j]!=0 && vis[i][j]==false){
		            ArrayList<Integer> res = new ArrayList<>();
		            isSafe(arr, i, j, vis, res);
		            
		            int sum =0; 
		            for(int val: res){
		                sum+=val;
		            }
		            if(sum>max){
		                max = sum;
		            }
		        }
		        
		    }
		}
		
	}
	
	
	public static void isSafe(int [][]arr, int i, int j, boolean[][]vis, ArrayList<Integer> res){
	    if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0 || vis[i][j] ==true){
	        return ;
	    }
	    vis[i][j] =true;
	    res.add(arr[i][j]);
	    isSafe(arr, i-1, j, vis, res);
	    isSafe(arr, i, j+1, vis, res);
	    isSafe(arr, i, j-1, vis, res);
	    isSafe(arr, i+1, j, vis, res);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}