import java.io.*;
import java.util.*;

public class Main {

	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		if(Integer.parseInt(max)<Integer.parseInt(str)){
		    max = str;
		}
		
		if(k==0){
		    return;
		    
		}
		
		for(int i=0; i<str.length(); i++){
		    for(int j=i+1; j<str.length(); j++){
		        
		        if(str.charAt(j)> str.charAt(i)){
		            String swpdStr = swap(str, i, j);
		            findMaximum(swpdStr, k-1);
		        }
		        
		    }
		}
	}
	
	public static String swap(String str, int i, int j){
	    StringBuilder sb = new StringBuilder(str);
	    char ith = sb.charAt(i);
	    char jth = sb.charAt(j);
	    
	    sb.setCharAt(i, jth);
	    sb.setCharAt(j, ith);
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}