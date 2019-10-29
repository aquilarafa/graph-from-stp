package domain;

/**
 * Interface para as diferentes implementações de estrutura de Grafo
 * @author aquila
 *
 */
public interface Grafo {
	
	/**
	 * Adiciona uma nova aresta a um grafo bidirecional
	 * @param v1 posicao do vertice 1
	 * @param v2 posicao do vertice 2
	 * @param peso
	 */
	public void addAresta(int v1, int v2, int peso);
	
	/**
	 * Checa se duas posições de vértices são arestas, ou seja 
	 * estão conectados.
	 * @param v1 posicao do vertice 1
	 * @param v2 posicao do vertice 2
	 * @return true se são aresta.
	 */
	public boolean isAresta(int v1, int v2);
	
	/**
	 * 
	 * @param a
	 */
	public void addAresta(Aresta a);

}
