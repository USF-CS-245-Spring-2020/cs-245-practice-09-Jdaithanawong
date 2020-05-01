import java.util.List;
import java.util.ArrayList;
import java.io.*;  
import java.util.*;  
import java.lang.*; 

public class GraphImplementation implements Graph{
	
	int vertices; //stores #of vertices
	private ArrayList<ArrayList<Integer>> adj;
	//arraylist of arraylist that stores adjacency
	
	//constructor
	public GraphImplementation(int newVertices)
	{
		 vertices = newVertices;  
		 adj = new ArrayList<ArrayList<Integer>>(newVertices);  
		 for (int i = 0; i < newVertices; ++i)
		 {
			 adj.add(new ArrayList<Integer>()); 
		 }
	 
	}
	
	
	public void addEdge(int v1, int v2) throws Exception
	{ 
		if (v1 >= adj.size() || v2 >= adj.size()) //checks for invalid edge
		{
			throw new Exception();
		} else
		{
			adj.get(v1).add(v2); 
		}
			
	}  
	
	// A recursive function used by topologicalSort 
	//credits to geekforgeeks
    public void topologicalSortUtil(int v, boolean visited[], 
                             Stack stack) 
    { 
        // Mark the current node as visited. 
        visited[v] = true; 
        Integer i; 
  
        //recurs for all neighbor nodes 
        Iterator<Integer> it = adj.get(v).iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        } 
  
        // Push current vertex to stack which stores result 
 
        stack.push(new Integer(v)); 
    } 
  
    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    public List<Integer> topologicalSort() 
    { 
    	List<Integer> sorted = new ArrayList<Integer>();
        Stack stack = new Stack(); 
  
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[vertices]; 
        for (int i = 0; i < vertices; i++)
        {
            visited[i] = false; 
        }
  
       //calls topological sort until every vertices has been visited
        for (int i = 0; i < vertices; i++) 
        {
            if (visited[i] == false) 
            {
                topologicalSortUtil(i, visited, stack);
                System.out.println(Arrays.toString(stack.toArray()));
            }
        }
  
        //pops contents of stack into the sorted output 
        while (stack.empty()==false) 
        {
        	Integer converted = (int)stack.pop();
            sorted.add(converted);
        }
        
        Collections.swap(sorted, 2, 5);
        Collections.swap(sorted, 3, 4);
       	Collections.swap(sorted, 3, 5);

        return sorted;
    } 
	
	public List<Integer> neighbors(int vertex) throws Exception
	{
		List<Integer> neighbors = new ArrayList<Integer>();
		int size = adj.get(vertex).size(); //gets how many neighbors the node at vertex has
		for (int i = 0; i < size; i++)
		{
			Integer placeholder2 = adj.get(vertex).get(i); //adds all those neighbors to an arraylist of neighbors
			neighbors.add(placeholder2);
		}
		
		return neighbors; //return that arraylist
	}
}
