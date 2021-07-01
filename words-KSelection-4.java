import java.io.*;
import java.util.*;

public class Main {

  public static void sol(String str, HashMap<Character, Integer>map, int cs, int ts, String asf, int lcui){
      if(cs==ts){
          System.out.println(asf);
          return;
      }
      
      for(int i= lcui; i<str.length(); i++){
          char ch = str.charAt(i);
          if(map.get(ch)>0){
              map.put(ch, map.get(ch)-1);
              sol(str, map, cs+1, ts, asf+ch, i);
              map.put(ch, map.get(ch)+1);
          }
      }
  }

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
        sol(ustr, unique, 0, k, "", 0);
    
  }

}