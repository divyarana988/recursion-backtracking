import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {

            Scanner scn = new Scanner(System.in);
            int nr= scn.nextInt();
            int nc = scn.nextInt();
            
            printMazePaths(0,0,nr-1,nc-1, "");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sc>dc || sr>dr)
	            return;
	            
	        if(sr==dr && sc==dc){
	            System.out.println(psf);
	            return;
	        }
	        
	        
	       for(int jmp=1; jmp+sc<=dc; jmp++){
	           printMazePaths(sr,sc+jmp,dr,dc,psf+"h"+jmp);
	       }     
	       for(int jmp=1; jmp+sr<=dr; jmp++){
	            printMazePaths(sr+jmp, sc, dr, dc, psf+"v"+jmp);
	       }
	       for(int jmp=1; jmp+sc<=dc && jmp+sr<=dr; jmp++){
	            printMazePaths(sr+jmp, sc+jmp, dr, dc, psf+"d"+jmp);
	       }
	    }

}