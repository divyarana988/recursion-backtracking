import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//write your code here
		
		if(pattern.length()==0){
		    if(str.length()==0){
		        HashSet<Character> set= new HashSet<>();
		        for(int i=0; i<op.length();i++){
		            char ch = op.charAt(i);
		            if(set.contains(ch)==false){
		                System.out.print(ch+" -> "+map.get(ch)+", ");
		                set.add(ch);
		            }
		        }
		        System.out.println(". ");
		    }
		    return;
		}
		
		
		char patCh = pattern.charAt(0);
		String rop = pattern.substring(1);
		
		if(map.containsKey(patCh)){
		    String prevMapping = map.get(patCh);
		    if(prevMapping.length() > str.length()){
		        return;
		    }
		    
		    String nextMapping = str.substring(0, prevMapping.length());
		    if(prevMapping.equals(nextMapping)){
		        String ros = str.substring(prevMapping.length());
		        solution(ros, rop, map, op);
		    }else{
		        return;
		    }
		    
		}
		else
		{
		    for(int i=0; i<str.length(); i++){
		        String fp = str.substring(0, i+1);
		        String sp = str.substring(i+1);
		        
		        map.put(patCh, fp);
		        solution(sp, rop, map, op);
		        map.remove(patCh);
		    }
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}