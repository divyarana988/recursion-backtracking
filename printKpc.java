import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();
        
        printKPC(st, "");
    }

    static String keypad[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx",                                 "yz"};

    public static void printKPC(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String res = str.substring(1);
        int idx = Integer.parseInt(ch+"");
        String word = keypad[idx];
        
        for(int i=0; i<word.length();i++){
            printKPC(res,asf+word.charAt(i));
        }
        
       
    }

}