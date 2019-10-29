package domain;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementação de Grafo usando Lista Encadeada (de Vertices)
 * @author aquila
 *
 */
public class GrafoPorLista implements Grafo{
    private int numVertices;
    
    private List<Aresta> arestas;
    private LinkedList<Vertice> list[];

    public GrafoPorLista(int numVertices) {
        this.numVertices = numVertices;
        
        arestas = new ArrayList<Aresta>();
        
        //inicializa listas encadeadas
        list = new LinkedList[numVertices+1];
        for (int i = 1; i <= numVertices ; i++) {
        	LinkedList<Vertice> lk = new LinkedList<>();
            list[i] = lk;
        }
    }

    public void addAresta(int origem, int destino, int peso){
    	Vertice origV = list[origem].getFirst();
    	Vertice destV = list[destino].getFirst();
    	
    	if(null != origV && null != destV) {
    		Aresta a = new Aresta(origV, destV, peso);
    		arestas.add(a);
    		
    		list[origem].addFirst(destV);
    		list[destino].addFirst(origV);
    	}
    	
    }
    
    public void addAresta(Aresta a){
    	Vertice origV = a.getV1();
    	Vertice destV = a.getV2();
    	
    	arestas.add(a);
		
		list[origV.getId()].add(destV);
		list[destV.getId()].addFirst(origV);
    	
    }
    
    public boolean isAresta(int v1, int v2) {
    	for(Aresta a: arestas) {
    		if(a.getV1().getId().equals(v1) && a.getV2().getId().equals(v2)
    				|| a.getV2().getId().equals(v1) && a.getV1().getId().equals(v2)) {
    			return true;
    		}
    	}
    	
    	return false;
    }

	public int getNumVertices() {
		return numVertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public LinkedList<Vertice>[] getList() {
		return list;
	}
    
    


}
