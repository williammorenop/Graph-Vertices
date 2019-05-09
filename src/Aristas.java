
public class Aristas<T> {
	private double costo;
	private T destino;
	
	public Aristas(double costo, T destino) {
		super();
		this.costo = costo;
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Aristas [costo=" + costo + ", destino=" + destino + "]";
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public T getDestino() {
		return destino;
	}

	public void setDestino(T destino) {
		this.destino = destino;
	}
	
	
	
	
}
