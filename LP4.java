
// Starter code for LP4
// Do not rename this file or move it away from cs6301/g??

// change following line to your group number
package cs6301.g18;
import cs6301.g00.Graph;
import cs6301.g00.Graph.Vertex;
import cs6301.g00.Graph.Edge;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LP4 {
    Graph g;
    Vertex s;

    // common constructor for all parts of LP4: g is graph, s is source vertex
    public LP4(Graph g, Vertex s) {
	this.g = g;
	this.s = s;
    }


    // Part a. Return number of topological orders of g
    public long countTopologicalOrders() {
    	
    	HashMap<Integer,Vertex> nums = new HashMap<>();
    	boolean[] visited = new boolean[g.n];
    	Integer[] indegree = new Integer[g.n];
    	List<List<Vertex>> list = new ArrayList<>();
    	List<Vertex> tempList = new ArrayList<>();
    	for(Vertex s: g) {
    		List<Edge> edge = s.revAdj;
    		indegree[s.getName()] = edge.size();
    		visited[s.getName()] = false;
    		nums.put(s.getName(), s);
    	}
    	
    		   backtrack(list, tempList, nums, visited, indegree);
    		   return list.size();
    	
    }
    
   
    private List<List<Vertex>> backtrack(List<List<Vertex>> list, List<Vertex> tempList, HashMap<Integer, Vertex> nums, boolean[] visited, Integer[] indegree){
    		   if(tempList.size() == nums.size()){
    			   List<Vertex> temp = new ArrayList<>(tempList);
    			   list.add(temp);	   
    		   } else{
    			   for(Vertex s: g){     
    		         if(indegree[s.getName()] == 0 && !visited[s.getName()]){	//indegree 0, unvisited	         
	    		         tempList.add(s);
	    		         visited[s.getName()] = true;
	    		         List<Edge> ei = s.adj;
	    		         for(Edge ee: ei) {
	    		        	 Vertex vj = ee.otherEnd(s);
	    		        	 indegree[vj.getName()]--;
	    		         }
	    		         backtrack(list, tempList, nums, visited, indegree);
	    		         tempList.remove(tempList.size() - 1);
	    		         visited[s.getName()] = false;
	    		         List<Edge> e = s.adj;
	    		         for(Edge ej: e) {
	    		        	 Vertex vj = ej.otherEnd(s);
	    		        	 indegree[vj.getName()]++;
	    		         }
    		         }else {
    		        	 continue;
    		         }
    		      }
    		   }
			return list;
    		}
    
//    private boolean helper(List<Edge> pointto, Vertex vertextoadd, List<Vertex> tempList) {	
//    	while(pointto != null) {
//	    	for(Edge to: pointto) {
//	    		Vertex v = to.otherEnd(vertextoadd);
//	       	 	if(tempList.contains(v)) {
//		        	return true; // element already exists, skip
//	       	 	}else {
//	       	 		
//	       	 	vertextoadd = v;
//	   	 		pointto = vertextoadd.adj;
//	   	 		return helper(pointto, vertextoadd, tempList);
//	   	 		
//	       	 	}
//	    	}
//    	}
//		return false;
//    }



    // Part b. Print all topological orders of g, one per line, and 
    //	return number of topological orders of g
    public List<List<Vertex>> enumerateTopologicalOrders() { 	
    	HashMap<Integer,Vertex> nums = new HashMap<>();
		boolean[] visited = new boolean[g.n];
		Integer[] indegree = new Integer[g.n];
		List<List<Vertex>> list = new ArrayList<>();
		List<Vertex> tempList = new ArrayList<>();
		for(Vertex s: g) {
			List<Edge> edge = s.revAdj;
			indegree[s.getName()] = edge.size();
			visited[s.getName()] = false;
			nums.put(s.getName(), s);
		}
		
			   backtrack(list, tempList, nums, visited, indegree);
			  
			   return list;
	

    }


    // Part c. Return the number of shortest paths from s to t
    // 	Return -1 if the graph has a negative or zero cycle
    public long countShortestPaths(Vertex t) {
	// To do
	return 0;
    }

    
    // Part d. Print all shortest paths from s to t, one per line, and 
    //	return number of shortest paths from s to t.
    //	Return -1 if the graph has a negative or zero cycle.
    public long enumerateShortestPaths(Vertex t) {
        // To do
        return 0;
    }


    // Part e. Return weight of shortest path from s to t using at most k edges
    public int constrainedShortestPath(Vertex t, int k) {
	// To do
	return 0;
    }


    // Part f. Reward collection problem
    // Reward for vertices is passed as a parameter in a hash map
    // tour is empty list passed as a parameter, for output tour
    // Return total reward for tour
    public int reward(HashMap<Vertex,Integer> vertexRewardMap, List<Vertex> tour) {
	// To do
        return 0;
    }

    // Do not modify this function
    static void printGraph(Graph g, HashMap<Vertex,Integer> map, Vertex s, Vertex t, int limit) {
	System.out.println("Input graph:");
	for(Vertex u: g) {
	    if(map != null) { 
		System.out.print(u + "($" + map.get(u) + ")\t: ");
	    } else {
		System.out.print(u + "\t: ");
	    }
	    for(Edge e: u) {
		System.out.print(e + "[" + e.weight + "] ");
	    }
	    System.out.println();
	}
	if(s != null) { System.out.println("Source: " + s); }
	if(t != null) { System.out.println("Target: " + t); }
	if(limit > 0) { System.out.println("Limit: " + limit + " edges"); }
	System.out.println("___________________________________");
    }
}
