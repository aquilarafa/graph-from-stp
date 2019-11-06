package domain;

/**
 * Aresta de um grafo
 * @author aquila
 *
 */
public class Aresta {

	private Vertice v1;
	private Vertice v2;
	private Integer peso;

	public Aresta(Vertice v1Param, Vertice v2Param, Integer pesoParam) {
		this.v1 = v1Param;
		this.v2 = v2Param;
		this.peso = pesoParam;
	}

	public Vertice getV1() {
		return v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public Integer getPeso() {
		return peso;
	}
	
	

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aresta other = (Aresta) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "V1: "+v1 + " V2: " + v2 + " Peso " + peso;
	}

}
