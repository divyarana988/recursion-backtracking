import java.io.*;
import java.util.*;

public class Main {

	public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here
		if(vidx==words.length){
		    print(arr);
		    return;
		}
		 
	   String word = words[vidx];
	   for(int i=0; i<10; i++){
	       for(int j=0; j<10; j++){
	           	if(arr[i][j]=='-' || arr[i][j] == word.charAt(0)){
        		    if(canPlaceHori(arr, i, j, word)){
        		        boolean vis[]= new boolean[word.length()];
        		        placeHori(arr,  i, j,word, vis);
        		        solution(arr, words, vidx+1);
        		        unplaceHori(arr,  i, j,word, vis);
        		    }
        		    
        		    if(canPlaceVert(arr, i, j, word)){
        		        boolean vis[]= new boolean[word.length()];
        		        placeVert(arr, i, j, word, vis);
        		        solution(arr, words, vidx+1);
        		        unplaceVert(arr,  i, j,word, vis);
        		    }
           		}
	       }
	   }
	}

	public static boolean canPlaceHori(char[][]arr, int r, int c, String word){
	    for(int i=0; i<word.length(); i++){
	        if(c+i>=10){
	            return false;
	        }
	        if(arr[r][c+i]=='-' || arr[r][c+i]==word.charAt(i)){
	            continue;
	        }
	        else{
	            return false;
	        }
	    }
	    
	   // if(c!=0){
	   //     if(arr[r][c-1] !='+')
	   //     return false;
	   // }
	    
	    if(c+word.length()==10 || arr[r][c+word.length()]=='+'){
	        return true;
	    }else{
	        return false;
	    }
	   
	}
	
	public static boolean canPlaceVert(char[][]arr, int r, int c, String word){
	     for(int i=0; i<word.length(); i++){
	        if(r+i>=10){
	            return false;
	        }
	        if(arr[r+i][c]=='-' || arr[r+i][c]==word.charAt(i)){
	            continue;
	        }
	        else{
	            return false;
	        }
	    }
	    
	   // if(r!=0){
	   //     if(arr[r-1][c] !='-')
	   //     return false;
	   // }
	    if(r+word.length()==10 || arr[r+word.length()][c]=='+'){
	        return true;
	    }else{
	        return false;
	    }
	    
	}
	
	public static void placeHori(char[][]arr, int r, int c, String word, boolean vis[]){
	    for(int i=0; i<word.length(); i++){
	        if(arr[r][c+i]=='-'){
	            arr[r][c+i] = word.charAt(i);
	            vis[i] = true;
	        }
	    }
	}
	public static void placeVert(char[][]arr, int r, int c, String word, boolean vis[]){
	    for(int i=0; i<word.length(); i++){
	        if(arr[r+i][c]=='-'){
	            arr[r+i][c] = word.charAt(i);
	            vis[i] = true;
	        }
	    }
	}
	
	public static void unplaceVert(char[][]arr, int r, int c, String word, boolean vis[]){
	    for(int i=0; i<word.length(); i++){
	        if(vis[i]==true){
	            arr[r+i][c]='-';
	            
	        }
	    }
	}
	
		public static void unplaceHori(char[][]arr, int r, int c, String word, boolean vis[]){
	    for(int i=0; i<word.length(); i++){
	        if(vis[i]==true){
	            arr[r][c+i]='-';
	            
	        }
	    }
	}
	
	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        solution(arr, words, 0);
	}
}