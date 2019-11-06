package application;

import domain.Aresta;
import domain.Dijkstra;
import domain.Grafo;
import domain.GrafoPorLista;
import domain.GrafoPorMatriz;
import domain.Vertice;

public class DijkstrasApp {

	public static void main(String[] args) {

		Grafo g = new GrafoPorMatriz(5);
		Vertice v1 = new Vertice(0, "A");
		Vertice v2 = new Vertice(1, "B");
		Vertice v3 = new Vertice(2, "C");
		Vertice v4 = new Vertice(3, "D");
		Vertice v5 = new Vertice(4, "E");

		//arestas
		Aresta ab = new Aresta(v1,v2,2);
		Aresta ac = new Aresta(v1,v3,4);
		Aresta ad = new Aresta(v1,v4,6);
		Aresta bd = new Aresta(v2,v4,3);
		Aresta be = new Aresta(v2,v5,7);
		Aresta ce = new Aresta(v3,v5,9);
		Aresta de = new Aresta(v4,v5,1);
		
		g.addAresta(ab);
		g.addAresta(ac);
		g.addAresta(ad);
		g.addAresta(bd);
		g.addAresta(be);
		g.addAresta(ce);
		g.addAresta(de);
		
		for(Vertice v : g.getVertices()){
			System.out.println(v);
		}
		
		System.out.println(g.toString());
		
		
		
		//dijkstra
		  
		Dijkstra d = new Dijkstra(g);
		int menor1_4 = d.menorCaminho(v1, v5);
		
		System.out.println(menor1_4);
		
		

	}

}
