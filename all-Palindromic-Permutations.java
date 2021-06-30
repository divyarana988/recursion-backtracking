import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		
		if(cs==ts){
		    System.out.print(asf);
		if(oddc!=null){
		    System.out.print(oddc);
		}
		for(int idx = asf.length()-1; idx>=0; idx--){
		    System.out.print(asf.charAt(idx));
		}
		System.out.println();
		return;
		}
		
		for(Character ch: fmap.keySet()){
		    int freq = fmap.get(ch);
		    if(freq!=0){
		        fmap.put(ch, freq-1);
		        generatepw(cs+1, ts, fmap, oddc, asf+ch);
		        fmap.put(ch, freq); 
		    }
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		Character oddc = null;
		int len = 0;
		for(Character ch: fmap.keySet()){
		    int freq = fmap.get(ch);
		    if(freq%2!=0){
		        if(oddc!=null){
		            System.out.println("-1");
		            return;
		        }
		        oddc = ch;
		    }
		    
		    fmap.put(ch, freq/2);
		    len+=freq/2;
		}
		//write your code here
		generatepw(0, len, fmap, oddc, "");
	}
	
}