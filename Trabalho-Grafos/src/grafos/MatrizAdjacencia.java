package grafos;

import java.util.Arrays;

public class MatrizAdjacencia {
	private int [][] G;
	private int numVertices;
	private boolean ponderado;
	private boolean direcionado;
	
	public MatrizAdjacencia(int numVertices, boolean ponderado, boolean direcionado) {
		this.numVertices = numVertices;
		this.ponderado = ponderado;
		this.direcionado = direcionado;
		G = new int [numVertices][numVertices];
	}
	
	public void inserirAresta(int vertice1, int vertice2) {
		if (!ponderado) {
			G[vertice1][vertice2] = 1;
			if (!direcionado) {
				G[vertice2][vertice1] = 1;
			}
		}else {
			System.out.println("Grafo ponderado. Necessita peso da aresta");
		}
	}
	
	public void inserirAresta(int vertice1,int vertice2,int peso) {
		if (ponderado) {
			G[vertice1][vertice2] = peso;
			if (!direcionado) {
				G[vertice2][vertice1] = peso;
			}
		}else {
			System.out.println("Grafo nao ponderado, arestas não possuem peso");
		}
	}
	
	public void removerAresta(int vertice1, int vertice2) {
		G[vertice1][vertice2] = 0;
		if (!direcionado) {
			G[vertice2][vertice1] = 0;
		}
	}
	
	public void mostrarMatrizAdjacencia() {
		for(int i = 0; i<numVertices;i++) {
			for(int j = 0; j<numVertices;j++) {
				System.out.print(G[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean verificaAdjacencia(int vertice1, int vertice2) {
		if (G[vertice1][vertice2] == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public void removerVertice(int vertice) {
	    if (vertice < 0 || vertice >= numVertices) {
	        System.out.println("Índice de vértice inválido.");
	        return;
	    }

	    for (int i = vertice; i < numVertices - 1; i++) {
	        G[i] = G[i + 1];
	    }

	    for (int i = 0; i < numVertices; i++) {
	        for (int j = vertice; j < numVertices - 1; j++) {
	            G[i][j] = G[i][j + 1];
	        }
	    }

	    numVertices--;

	    if (direcionado) {
	        for (int i = 0; i < numVertices; i++) {
	            for (int j = 0; j < numVertices; j++) {
	                if (G[i][j] > vertice) {
	                    G[i][j]--;
	                }
	            }
	        }
	    }
	}

	public boolean verificarConexo() {
	    if (numVertices == 0) {
	        return true;
	    }

	    boolean[] visited = new boolean[numVertices];
	    dfs(0, visited);

	    for (int i = 0; i < numVertices; i++) {
	        if (!visited[i]) {
	            return false;
	        }
	    }

	    return true;
	}

	private void dfs(int vertex, boolean[] visited) {
	    visited[vertex] = true;

	    for (int i = 0; i < numVertices; i++) {
	        if (G[vertex][i] != 0 && !visited[i]) {
	            dfs(i, visited);
	        }
	    }
	}
	
	public boolean verificarCompleto() {
	    for (int i = 0; i < numVertices; i++) {
	        for (int j = i + 1; j < numVertices; j++) {
	            if (G[i][j] != 1) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	public void dijkstra(int origem, int destino) {
        if (!ponderado) {
            System.out.println("O grafo não é ponderado. Dijkstra não pode ser aplicado.");
            return;
        }

        int[] distancia = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int verticeAtual = obterVerticeMenorDistancia(distancia, visitado);
            visitado[verticeAtual] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visitado[j] && G[verticeAtual][j] != 0 && distancia[verticeAtual] != Integer.MAX_VALUE) {
                    int novaDistancia = distancia[verticeAtual] + G[verticeAtual][j];
                    if (novaDistancia < distancia[j]) {
                        distancia[j] = novaDistancia;
                    }
                }
            }
        }

        exibirCaminhoMaisCurto(origem, destino, distancia);
    }

    private int obterVerticeMenorDistancia(int[] distancia, boolean[] visitado) {
        int minDistancia = Integer.MAX_VALUE;
        int verticeMinDistancia = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i] && distancia[i] <= minDistancia) {
                minDistancia = distancia[i];
                verticeMinDistancia = i;
            }
        }

        return verticeMinDistancia;
    }

    private void exibirCaminhoMaisCurto(int origem, int destino, int[] distancia) {
        System.out.println("Distância mínima de " + origem + " para " + destino + ": " + distancia[destino]);

        System.out.print("Caminho: ");
        int verticeAtual = destino;
        while (verticeAtual != origem) {
            System.out.print(verticeAtual + " ");
            verticeAtual = obterVerticeAnterior(origem, verticeAtual, distancia);
        }
        System.out.println(origem);
    }

    private int obterVerticeAnterior(int origem, int destino, int[] distancia) {
        for (int i = 0; i < numVertices; i++) {
            if (G[i][destino] != 0 && distancia[i] + G[i][destino] == distancia[destino]) {
                return i;
            }
        }
        return -1;
    }

    public String verificarEulerianidade() {
        int verticesImpares = contarVerticesImpares();

        if (verticesImpares == 0) {
            return "Grafo Euleriano";
        } else if (verticesImpares == 2) {
            return "Grafo Semieuleriano";
        } else {
            return "Grafo Não Euleriano";
        }
    }

    private int contarVerticesImpares() {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            int grau = 0;
            for (int j = 0; j < numVertices; j++) {
                grau += G[i][j];
            }
            if (grau % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    
    public String verificarHamiltonianidade() {
        if (!verificarConexo()) {
            return "Grafo Não Hamiltoniano";
        }

        int numVertices = this.numVertices;
        boolean[] visitado = new boolean[numVertices];

        // Verificar para cada vértice se há um ciclo/caminho Hamiltoniano
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(visitado, false);
            if (verificarCicloHamiltoniano(i, i, visitado, 1)) {
                return "Grafo Hamiltoniano";
            }
            if (verificarCaminhoHamiltoniano(i, visitado, 1)) {
                return "Grafo Semi-Hamiltoniano";
            }
        }

        return "Grafo Não Hamiltoniano";
    }

    private boolean verificarCicloHamiltoniano(int origem, int atual, boolean[] visitado, int count) {
        if (count == numVertices) {
            return G[atual][origem] == 1;
        }

        visitado[atual] = true;
        for (int i = 0; i < numVertices; i++) {
            if (G[atual][i] == 1 && !visitado[i]) {
                if (verificarCicloHamiltoniano(origem, i, visitado, count + 1)) {
                    return true;
                }
            }
        }

        visitado[atual] = false;
        return false;
    }

    private boolean verificarCaminhoHamiltoniano(int atual, boolean[] visitado, int count) {
        if (count == numVertices) {
            return true;
        }

        visitado[atual] = true;
        for (int i = 0; i < numVertices; i++) {
            if (G[atual][i] == 1 && !visitado[i]) {
                if (verificarCaminhoHamiltoniano(i, visitado, count + 1)) {
                    return true;
                }
            }
        }

        visitado[atual] = false;
        return false;
    }
}
