import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
        generatwords(k,0,new Character[k],0,ustr);
    
  }
  
  public static void generatwords(int ts, int sfsf, Character spot[], int idx, String ustr){
      if(idx==ustr.length()){
          if(sfsf == ts){
            for(Character ch: spot){
              System.out.print(ch);
             }
             System.out.println();
           }
           return;
      }
      
      char ch = ustr.charAt(idx);
      for(int i=0; i<spot.length; i++){
          if(spot[i]==null){
              spot[i] = ch;
              generatwords(ts, sfsf+1, spot, idx+1, ustr);
              spot[i] = null;
          }
      }
      generatwords(ts, sfsf, spot, idx+1, ustr);
  }

}