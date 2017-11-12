// Driver code for LP4, part b
// Do not rename this file or move it away from cs6301/g??
// Change following line to your group number.  Make no other changes.

package cs6301.g18;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import cs6301.g00.Graph;
import cs6301.g00.Graph.Vertex;

public class LP4b {
	
    static int VERBOSE = 0;
    
  
	    public static void main(String[] args) throws FileNotFoundException {
	        Scanner in;
	        if(args.length > 0) {
	            File inputFile = new File(args[0]);
	            in = new Scanner(inputFile);
	          //  VERBOSE = Integer.parseInt(args[0]);
	        } else {
	            in = new Scanner(System.in);
	        }
			
		Graph g = Graph.readDirectedGraph(in);
		cs6301.g00.Timer t = new cs6301.g00.Timer();
		LP4 handle = new LP4(g, null);
		List<List<Vertex>> result = handle.enumerateTopologicalOrders();
		
		if(VERBOSE > 0) { 
			LP4.printGraph(g, null, null, null, 0); 
			}
		
		System.out.println(result + "\n" + t.end());
    }
}
