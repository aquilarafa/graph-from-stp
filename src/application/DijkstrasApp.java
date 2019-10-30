package application;

import java.util.List;

import domain.Grafo;
import domain.GrafoPorLista;
import domain.Vertice;

public class DijkstrasApp {

	public static void main(String[] args) {

		Grafo g = new GrafoPorLista(5);
		Vertice v1 = new Vertice(0, "A");
		Vertice v2 = new Vertice(1, "B");
		Vertice v3 = new Vertice(2, "C");
		Vertice v4 = new Vertice(3, "D");
		Vertice v5 = new Vertice(4, "E");

		g.addVertice(v1);
		g.addVertice(v2);
		g.addVertice(v3);
		g.addVertice(v4);
		g.addVertice(v5);
		
		for(Vertice v : g.getVertices()){
			System.out.println(v);
		}
		
		System.out.println(g.toString());
		

	}

}
