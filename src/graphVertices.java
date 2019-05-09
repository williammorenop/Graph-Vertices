import java.util.List;

public class graphVertices<T> {
	private List<Vertice<T>> vertices;
	
	public  void addVertex(T dato) {
		vertices.add(new Vertice<T>(dato));
	}
	public  void addEdge(T origin, T destination, Double weight) {
		boolean estaori = hasVertex(origin);		
		boolean estades = hasVertex(destination);
		
		if(estades && estaori)
		{
			for (Vertice<T> vertice : vertices) {
				if(vertice.getDato().equals(origin))
				{
					vertice.addEdgeVertex(origin, destination, weight);
				}
			}
		}
		else
		{
			System.out.println("ERROR NO EXISTE UN VERTICE");		
		}
	}
	public  boolean hasVertex( T vertex) {
		for (Vertice<T> vertice : vertices) {
			if(vertice.getDato().equals(vertex))
			{
				return true;
			}
		}
		return false;
	}
	
	public  boolean hasEdge(T origin, T destination)
	{
		for (Vertice<T> vertice : vertices) {
			if(vertice.getDato().equals(origin))
			{
				return vertice.hasEdge(origin,destination);				
			}
		}
		return false;
	}
	
	/*
	--public  void addVertex(T vertex); 
	--public  void addEdge(T origin, T destination, Double weight);
	--public  boolean hasVertex( T vertex);
	--public  boolean hasEdge(T origin, T destination);
	
	public  Vector<T> dfs (); //pila
	public  Vector<T> bfs (); //cola
	public  Vector< Pair<T, Double> > dijkstra (); // un nodo a muchos ~ cola de prioridad
	public  Vector< Pair<T, Double> > floydWarshall (); // de todos a todos
	public  Vector< T > kruskall (); //arbol de expansion minima - algoritmo voraz 
	public  Vector< T > prim (); //arbol de expansion minima - programacion dinamica */
}
