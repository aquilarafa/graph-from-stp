package util;
import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Aresta;
import domain.Vertice;


/**
 * Parser para transformar arquivo .stp em elementos de um Grafo
 * @author aquila
 *
 */

public class StepFileReader {

	public static void main(String[] args) {
		File file = new File("/home/aquila/Downloads/alue2087.stp");
		StepFileReader stp = new StepFileReader(file);
	}

	private File file;
	private List<Aresta> arestas = new ArrayList<>();
	private long numEdges;
	private int numVertices;

	public StepFileReader(File file) {

		this.file = file;
		
		System.out.println("Init parser (god help us)...");
		parser();
	}

	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.US_ASCII);
		}

		catch (IOException e) {

			e.printStackTrace();
		}
		return lines;
	}
	
	private void parser() {
		List<String> l = readFileInList(file.getAbsolutePath());

		int graphSectionIndex = 0;
		long numEdges = 0;
		int numVertices = 0;

		//sets the section graph 
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equalsIgnoreCase("SECTION GRAPH")) {
				graphSectionIndex = l.indexOf(l.get(i));
				numVertices = Integer.parseInt(l.get(i + 1).replaceAll("\\D+", ""));
				numEdges = Long.parseLong(l.get(i + 2).replaceAll("\\D+", ""));
				break;
			}
		}
		
		//iterate over the edges definition
		int i = graphSectionIndex + 3;
		while (!l.get(i).equalsIgnoreCase("END")) {
			String[] edgeLine = l.get(i).split("\\s+");
			System.out.print("V1: "+ edgeLine[1] + " V2: "+ edgeLine[2] + " V3: " + edgeLine[3]);
			Vertice v1 = new Vertice(Integer.parseInt(edgeLine[1]));
			Vertice v2 = new Vertice(Integer.parseInt(edgeLine[2]));
			 int peso = Integer.parseInt(edgeLine[3]);
			 Aresta aresta = new Aresta(v1,v2, peso);
			 this.arestas.add(aresta);
			 
			System.out.println();
			i++;
		}

		System.out.println("EDGES: " + numEdges);
		System.out.println("VERTICES: " + numVertices);
		this.numEdges = numEdges;
		this.numVertices = numVertices;
	}

	public File getFile() {
		return file;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public long getNumEdges() {
		return numEdges;
	}

	public int getNumVertices() {
		return numVertices;
	}
	
	

}