package application;

import java.io.File;

import domain.Aresta;
import domain.Grafo;
import domain.GrafoPorLista;
import domain.GrafoPorMatriz;
import util.StepFileReader;

public class ParserApp {

	
	public static void main(String[] args) {
		File file = new File("./res/sample2.stp");
		StepFileReader stp = new StepFileReader(file);
		
		
		
		Grafo g = new GrafoPorLista(stp.getNumVertices());
		
		for(Aresta a: stp.getArestas()) {
			System.out.println(a.toString());
			g.addAresta(a);
		}
		
		
		
		System.out.println(g.toString());
		
		System.out.println(g.isAresta(6, 1));
		
	}
	
}
