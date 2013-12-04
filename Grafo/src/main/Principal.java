package main;

import grafo.Dijkstra;
import grafo.MeuGrafo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Principal {

	
	private MeuGrafo grafo;
	private static int totalVertices;

	public static void main(String[] args) {
		
		int origem = 0;
		int destino = 0;
		
		try {
			totalVertices = countLines("grafo.txt");
			System.out.println("Maior índice do vértice: " + totalVertices);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite ORIGEM e DESTINO");
			
			String[] values = scanner.nextLine().split(" ");
			origem  = Integer.parseInt(values[0]);
			destino = Integer.parseInt(values[1]);
			
			if (origem < 0) {
				System.err.println("ORIGEM inválido");
				System.exit(-1);
			}
			if (destino > totalVertices) {
				System.err.println("DESTINO inválido");
				System.exit(-1);
			}
			
		} catch (IOException e) {
			System.err.println("Erro ao ler 'grafo.txt'");
			System.exit(-1);
		} catch (Exception e) {
			System.err.println("Erro de formatação");
			System.exit(-1);
		}
		
		try {
			new Principal(origem, destino);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public Principal(int origem, int destino) throws Exception {
		grafo = new MeuGrafo(totalVertices);
		carregaGrafo();
		int raiz = origem;
		Dijkstra dj = new Dijkstra(grafo);
		dj.obterArvore(raiz);

		StringBuilder melhorCaminho = dj.showPath(origem, destino);
		
		
		if (melhorCaminho.substring(0, 1).equals(String.valueOf(origem))) {
			System.out.println("Melhor caminho: " + melhorCaminho);
		} else {
			System.out.println("Melhor caminho: " + melhorCaminho.reverse());
		}
		
	}
	
	public void carregaGrafo() throws Exception {

		BufferedReader br = null;
		
		try {
			
			String linha;
			br = new BufferedReader(new FileReader("grafo.txt"));

			String[] value = new String[3];
			int v1 = 0;
			int v2 = 0;
			int peso = 0;
			
			while ((linha = br.readLine()) != null) {
				value = linha.split(" ");
				v1 = Integer.valueOf(value[0]);
				v2 = Integer.valueOf(value[1]);
				peso = Integer.valueOf(value[2]);
				grafo.criaAresta(v1, v2, peso);				
			}

		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			throw new Exception("Erro ao abrir o arquivo");
		} catch (Exception e) {
			throw new Exception("Arquivo mal estruturado");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Erro ao fechar arquivo. " + e.getMessage());
			}
		}
	}
	
	private static int countLines(String file) throws IOException {
		int lineCount = 0;
		LineNumberReader lineNumberReader = null;
		try {
			lineNumberReader = new LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			lineCount = lineNumberReader.getLineNumber();
		} finally {
			lineNumberReader.close();
		}
		return lineCount;
	}
}
