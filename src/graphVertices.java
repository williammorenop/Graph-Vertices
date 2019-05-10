import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class graphVertices<T> {
	private List<Vertice<T>> vertices;
	private boolean dirigido;

	public graphVertices(boolean dirigido) {
		super();
		this.vertices = new ArrayList<Vertice<T>>();
		this.dirigido = dirigido;
	}

	@Override
	public String toString() {
		return "graphVertices [vertices=" + vertices + ", dirigido=" + dirigido + "]";
	}

	public void addVertex(T dato) {
		vertices.add(new Vertice<T>(dato));
	}

	public void addEdge(T origin, T destination, Double weight) {
		boolean estaori = hasVertex(origin);
		boolean estades = hasVertex(destination);

		if (estades && estaori) {
			for (Vertice<T> vertice : vertices) {
				if (vertice.getDato().equals(origin)) {
					vertice.addEdgeVertex(origin, destination, weight);
				}
			}
			if (!dirigido) {
				for (Vertice<T> vertice : vertices) {
					if (vertice.getDato().equals(destination)) {
						vertice.addEdgeVertex(destination, origin, weight);
					}
				}
			}
		} else {
			System.out.println("ERROR NO EXISTE UN VERTICE");
		}
	}

	public boolean hasVertex(T vertex) {
		for (Vertice<T> vertice : vertices) {
			if (vertice.getDato().equals(vertex)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasEdge(T origin, T destination) {
		for (Vertice<T> vertice : vertices) {
			if (vertice.getDato().equals(origin)) {
				return vertice.hasEdge(origin, destination);
			}
		}
		return false;
	}

	public Vector<T> dfs() {
		todosFalse();
		Vector<T> resultado = new Vector<T>();
		Stack<T> pila = new Stack<T>();
		vertices.get(0).setVisitado(true);
		resultado.add(vertices.get(0).getDato());
		for (Aristas<T> arista : vertices.get(0).getVecinos()) {
			pila.push((T) arista.getDestino());
		}
		while (!pila.isEmpty()) {
			T top = pila.pop();
			int pos = posDato(top);
			if (!vertices.get(pos).isVisitado()) {
				vertices.get(pos).setVisitado(true);
				resultado.add(top);
				for (Aristas<T> arista : vertices.get(pos).getVecinos()) {
					pila.push((T) arista.getDestino());
				}
			}

		}
		return resultado;
	}

	public Vector<T> bfs() { // cola
		todosFalse();
		Vector<T> resultado = new Vector<T>();
		Queue<T> cola = new LinkedList<T>();
		cola.add((T) vertices.get(0).getDato());
		while (!cola.isEmpty()) {
			T head = cola.remove();
			int pos = posDato(head);
			if (!vertices.get(pos).isVisitado()) {
				vertices.get(pos).setVisitado(true);
				resultado.add(head);
				for (Aristas<T> arista : vertices.get(pos).getVecinos()) {
					cola.add((T) arista.getDestino());
				}
			}
		}
		return resultado;
	}

	private void todosFalse() {
		for (Vertice<T> vertice : vertices) {
			vertice.setVisitado(false);
		}
	}

	private int posDato(T top) {
		int pos = -1;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getDato().equals(top)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

}

/*
 * --public void addVertex(T vertex); 
 * --public void addEdge(T origin, T destination, Double weight); 
 * --public boolean hasVertex( T vertex); 
 * --public boolean hasEdge(T origin, T destination);
 * 
 * --public Vector<T> dfs (); //pila 
 * --public Vector<T> bfs (); //cola 
 * public Vector< Pair<T, Double> > dijkstra (); // un nodo a muchos ~ cola deprioridad 
 * public Vector< Pair<T, Double> > floydWarshall (); // de todos a todos 
 * public Vector< T > kruskall (); //arbol de expansion minima - algoritmo voraz
 * public Vector< T > prim (); //arbol de expansion minima - programacion dinamica
 */
