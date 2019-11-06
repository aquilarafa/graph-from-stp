package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

	private Grafo g;

	public Dijkstra(Grafo g) {
		this.g = g;
	}

	public int menorCaminho(Vertice orig, Vertice dest) {
		if (orig.getId() >= g.getNumVertices()) {
			// exception
		}

		// init
		
		
		
		int dist[] = new int[g.getNumVertices()]; //distancias
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[orig.getId()] = 0;
		
		//mapeia VERTICE e DIST 
		HashMap<Vertice, Integer> queue = new HashMap<>(); 
		for(int i = 0; i < dist.length; i++) {
			queue.put(new Vertice(i), dist[i]);
		}
		
		while(!queue.isEmpty()) {
			//menor distancia
			Integer minValue = Collections.min(queue.values()); 
			Vertice current = (Vertice) getKeyFromValue(queue, minValue);
					
			
			queue.remove(current);
			for(Vertice z : g.getVerticesAdjacentes(current.getId())) {
				if(queue.containsKey(z)) {
					
					int fator = dist[current.getId()] + g.getPeso(current.getId(), z.getId());
					if(((dist[current.getId()] + fator)) < dist[z.getId()]) {
						dist[z.getId()] = fator;
						queue.put(z, fator);
					}
				}
			}
			
		}//end while

		return dist[dest.getId()];
	}
	
	 private Object getKeyFromValue(Map hm, Object value) {
         for (Object o : hm.keySet()) {
           if (hm.get(o).equals(value)) {
             return o;
           }
         }
         return null;
       }
     

}
