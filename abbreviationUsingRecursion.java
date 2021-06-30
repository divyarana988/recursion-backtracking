import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        
        if(pos==str.length()){
            System.out.println(asf+(count==0? "": count));
            return;
            
        }
        
        char ch = str.charAt(pos);
        String temp = (count==0? ""+ch : ""+ count+ch);
        
        solution(str, asf+temp,0, pos+1);
        
        solution(str, asf, count+1, pos+1);
        
        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}