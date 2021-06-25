import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();
    
    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for(char ch : str.toCharArray()){
        if(unique.contains(ch)== false){
            unique.add(ch);
            ustr+=ch;
        }
    }
    
    combination(-1,ustr,0,k,"");
  }
  
  
  public static void combination(int idx,String ustr,int ssf, int ts, String asf ){
      
      if(ssf ==ts){
          System.out.println(asf);
          return;
      }
      
      for(int i=idx+1; i<ustr.length(); i++){
          combination(i, ustr, ssf+1, ts, asf+ustr.charAt(i));
;      }
      
  }

}