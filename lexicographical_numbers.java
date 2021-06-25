import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here
		for(int i=1; i<=9; i++){
		    solve(i, n);
		}
	}
	
	public static void solve(int num, int n){
	    if(num>n){
	        return;
	    }
	    System.out.println(num);
	    for(int digit=0; digit<=9; digit++){
	        solve((10*num)+digit, n);
	    }
	}
	
}