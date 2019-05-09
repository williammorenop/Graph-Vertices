
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graphVertices<Character> grafo = new graphVertices<Character>(false);
		grafo.addVertex('a');
		grafo.addVertex('b');
		grafo.addVertex('c');
		grafo.addVertex('d');
		grafo.addVertex('e');
		grafo.addVertex('f');
		grafo.addVertex('g');
		
		grafo.addEdge('a', 'b', (double) 1);
		grafo.addEdge('a', 'd', (double) 1);
		grafo.addEdge('a', 'f', (double) 1);
		grafo.addEdge('b', 'c', (double) 1);
		grafo.addEdge('b', 'e', (double) 1);
		grafo.addEdge('f', 'g', (double) 1);
		
		//System.out.println(grafo);
		System.out.println(grafo.hasEdge('a', 'c'));
		System.out.println(grafo.hasEdge('a', 'f'));
		
		System.out.println(grafo.hasVertex('z'));
		System.out.println(grafo.hasVertex('f'));
		
		System.out.println(grafo.dfs());
		
		System.out.println(grafo.bfs());
		
	}

}
