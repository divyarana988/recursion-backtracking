import java.io.*;
import java.util.*;

public class Main {

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

   sol(ustr, unique, 0, "", k);
   
  }

    public static void sol(String ustr, HashMap<Character, Integer> map, int idx, String asf, int k){
        if(k<0){
            return;
        }
        if(idx == ustr.length()){
            if(k==0){
                System.out.println(asf);
               
            }
             return;
        }
        char ch = ustr.charAt(idx);
        if(map.get(ch)>0){
            map.put(ch, map.get(ch)-1);
            sol(ustr, map, idx, asf+ch, k-1);
            map.put(ch, map.get(ch)+1);
        }
        
        sol(ustr, map, idx+1, asf, k);
    }


}