package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Estrutura de grafo implementado usando matriz de adjacencia
 * 
 * @author aquila
 *
 */
public class GrafoPorMatriz implements Grafo{

	private int adjMatrix[][];
	private int numVertices;

	public GrafoPorMatriz(int numVerticesParam) {
		this.numVertices = numVerticesParam;
		adjMatrix = new int[numVertices][numVertices];
	}

	public void addAresta(int v1, int v2, int peso) {
		adjMatrix[v1][v2] = peso;
		adjMatrix[v2][v1] = peso;
	}
	
	public void addAresta(Aresta a){
    	Vertice origV = a.getV1();
    	Vertice destV = a.getV2();
    	adjMatrix[origV.getId()][destV.getId()] = a.getPeso();
		adjMatrix[destV.getId()][origV.getId()] = a.getPeso();
    }

	public void removeAresta(int v1, int v2) {
		adjMatrix[v1][v2] = -1;
		adjMatrix[v2][v1] = -1;
	}

	public boolean isAresta(int v1, int v2) {
		if (adjMatrix[v1-1][v2-1] != -1) {
			return true;
		}
		return false;
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("  ");
        for (int i = 0; i < numVertices; i++) {
        	s.append(" " + (i+1));
        }
        s.append("\n");
        for (int i = 0; i < numVertices; i++) {
            s.append((i+1) + ": ");
            for (int j : adjMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

	@Override
	public void addVertice(Vertice vertice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vertice> getVertices() {
		List<Vertice> res = new ArrayList<>();
		for(int i = 0; i < getNumVertices(); i++) {
			res.add(new Vertice(adjMatrix[i][0]));
		}
		
		return res;
	}

	@Override
	public Integer getPeso(int v1, int v2) {
		return adjMatrix[v1][v2];
	}

	@Override
	public Integer getNumVertices() {
		return numVertices;
	}
	
	 public List<Vertice> getVerticesAdjacentes(int vertice) {
	        List<Vertice> vizinhos = new ArrayList<>();
	        for (int i = 0; i < adjMatrix[vertice].length; i++)
	            if (adjMatrix[vertice][i] > 0) {
	            	vizinhos.add(new Vertice(i));
	            }

	        return vizinhos;
	    }


	
	

}
