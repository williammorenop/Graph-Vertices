
public class Pair<T,S> {
	
	public T first;
	public S second;
	
	
	public Pair(T first, S second) {
		super();
		this.first = first;
		this.second = second;
	}


	public T getFirst() {
		return first;
	}


	public void setFirst(T first) {
		this.first = first;
	}


	public S getSecond() {
		return second;
	}


	public void setSecond(S second) {
		this.second = second;
	} 
	
	
	
}