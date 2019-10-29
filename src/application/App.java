package application;

import java.io.File;

import domain.Aresta;
import domain.Grafo;
import domain.GrafoPorLista;
import domain.GrafoPorMatriz;
import util.StepFileReader;

public class App {

	
	public static void main(String[] args) {
		File file = new File("./res/sample2.stp");
		StepFileReader stp = new StepFileReader(file);
		
		
		
		Grafo g = new GrafoPorMatriz(stp.getNumVertices());
		
		for(Aresta a: stp.getArestas()) {
			System.out.println(a.toString());
			g.addAresta(a);
		}
		
		
		//printGrafo((GrafoPorLista) g);
		
		System.out.println(g.toString());
		
		System.out.println(g.isAresta(6, 1));
		
	}
	
	 public static void printGrafo(GrafoPorLista g){
	        for (int i = 1; i <=g.getNumVertices() ; i++) {
	            if(g.getList()[i].size()>0) {
	                System.out.print("Vértice " + i + " está conectado ao: ");
	                for (int j = 0; j < g.getList()[i].size(); j++) {
	                    System.out.print(g.getList()[i].get(j) + " ");
	                }
	                System.out.println();
	            }
	        }
	    }
}
