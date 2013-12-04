package grafo;

public class MeuGrafo {
	public static class Aresta {
		private int v1, v2, weight;

		public Aresta(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public int weight() {
			return this.weight;
		}

		public int v1() {
			return this.v1;
		}

		public int v2() {
			return this.v2;
		}
	}

	private int cab[], prox[], peso[];
	private int pos[];

	private int numVertices, proxDisponivel;

	public MeuGrafo(int numVertices) {
		int numArestas = numVertices / 2;
		int tam = numVertices + 2 * numArestas;
		this.cab = new int[tam];
		this.prox = new int[tam];
		this.peso = new int[tam];
		this.numVertices = numVertices;
		this.pos = new int[this.numVertices];

		for (int i = 0; i < this.numVertices; i++) {
			this.prox[i] = 0;
			this.cab[i] = i;
			this.peso[i] = 0;
			this.pos[i] = i;
		}
		this.proxDisponivel = this.numVertices;
	}
	
	public int numVertices() {
		return this.numVertices;
	}

	public boolean existeAresta(int v1, int v2) {
		for (int i = this.prox[v1]; i != 0; i = this.prox[i])
			if (this.cab[i] == v2)
				return true;
		return false;
	}	

	public Aresta prox(int v) {
		this.pos[v] = this.prox[this.pos[v]];
		if (pos[v] == 0)
			return null;
		else
			return new Aresta(v, this.cab[pos[v]], this.peso[pos[v]]);
	}
	
	public void criaAresta(int v1, int v2, int peso) {
		if (this.proxDisponivel == this.cab.length)
			System.out.println("Aresta sem espaço");
		else {
			int ind = this.proxDisponivel++;
			this.prox[this.cab[v1]] = ind;
			this.cab[ind] = v2;
			this.cab[v1] = ind;
			this.prox[ind] = 0;
			this.peso[ind] = peso;
		}
	}

	public Aresta removeAresta(int v1, int v2) {
		int index;

		for (index = v1; this.prox[index] != 0; index = this.prox[index])
			if (this.cab[this.prox[index]] == v2)
				break;

		int ind = this.prox[index];

		if (this.cab[ind] == v2) {
			Aresta aresta = new Aresta(v1, v2, this.peso[ind]);
			this.cab[ind] = this.cab.length;
			if (this.prox[ind] == 0)
				this.cab[v1] = index;
			this.prox[index] = this.prox[ind];
			return aresta;
		} else
			return null;
	}
	
	public boolean listaVazia(int v) {
		return (this.prox[v] == 0);
	}

	public Aresta primeiroLista(int v) {
		this.pos[v] = v;
		return this.prox(v);
	}

}
