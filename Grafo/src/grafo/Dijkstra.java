package grafo;

public class Dijkstra {	
	private double arestaWeight[];
	private int antes[];
	private MeuGrafo grafo;
	private StringBuilder path = new StringBuilder();

	public Dijkstra(MeuGrafo grafo) {
		this.grafo = grafo;
	}
	
	public int antes(int a) {
		return this.antes[a];
	}

	public double peso(int p) {
		return this.arestaWeight[p];
	}

	public void obterArvore(int raiz) throws Exception {
		int n = this.grafo.numVertices();
		this.arestaWeight = new double[n];
		int vs[] = new int[n + 1];
		this.antes = new int[n];

		for (int u = 0; u < n; u++) {
			this.antes[u] = -1;
			arestaWeight[u] = Double.MAX_VALUE;
			vs[u + 1] = u;
		}

		arestaWeight[raiz] = 0;
		MeuHeap heap = new MeuHeap(arestaWeight, vs);
		heap.constroi();

		while (!heap.empty()) {
			int u = heap.retiraMin();
			if (!this.grafo.listaVazia(u)) {
				MeuGrafo.Aresta adj = grafo.primeiroLista(u);
				while (adj != null) {
					int v = adj.v2();
					if (this.arestaWeight[v] > (this.arestaWeight[u] + adj.weight())) {
						antes[v] = u;
						heap.diminuiChave(v, this.arestaWeight[u] + adj.weight());
					}
					adj = grafo.prox(u);
				}
			}
		}
	}
	
	public StringBuilder showPath(int origem, int vertice)
			throws Exception {
		if (origem == vertice)
			path.append(origem);
		else if (this.antes[vertice] == -1)
			throw new Exception("Não há caminho de "+origem+" até "+vertice);
		else {
			path.append(vertice + " > ");
			showPath(origem, this.antes[vertice]);
		}

		return path;

	}		

}