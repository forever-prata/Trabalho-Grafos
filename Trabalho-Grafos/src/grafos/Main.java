package grafos;

public class Main {
	public static void main(String[] args) {
		//int numVertices = 3;
		//MatrizAdjacencia grafo = new MatrizAdjacencia(numVertices, false, false);
		
		//grafo.inserirAresta(0, 1);
		//grafo.inserirAresta(0, 2);
		//grafo.inserirAresta(1, 2);
		
		//grafo.mostrarMatrizAdjacencia();
		//grafo.removerVertice(1);
		//grafo.mostrarMatrizAdjacencia();
		
		//System.out.println(grafo.verificarConexo());
		//System.out.println(grafo.verificarCompleto());
		
		/*
		MatrizAdjacencia grafoPonderado = new MatrizAdjacencia(5, true, true);
		grafoPonderado.inserirAresta(0, 1, 2);
		grafoPonderado.inserirAresta(0, 2, 4);
		grafoPonderado.inserirAresta(1, 2, 1);
		grafoPonderado.inserirAresta(1, 3, 7);
		grafoPonderado.inserirAresta(2, 3, 3);
		grafoPonderado.inserirAresta(2, 4, 5);
		grafoPonderado.inserirAresta(3, 4, 2);
		grafoPonderado.dijkstra(0, 4);
        */
		
		/*
		MatrizAdjacencia grafoPonderadoNaoDirecionado = new MatrizAdjacencia(5, true, false);
		grafoPonderadoNaoDirecionado.inserirAresta(0, 1, 3);
		grafoPonderadoNaoDirecionado.inserirAresta(0, 2, 4);
		grafoPonderadoNaoDirecionado.inserirAresta(1, 2, 1);
		grafoPonderadoNaoDirecionado.inserirAresta(1, 3, 7);
		grafoPonderadoNaoDirecionado.inserirAresta(2, 3, 3);
		grafoPonderadoNaoDirecionado.inserirAresta(2, 4, 5);
		grafoPonderadoNaoDirecionado.inserirAresta(3, 4, 8);
		grafoPonderadoNaoDirecionado.dijkstra(0, 4);
		*/
		
		/*
		MatrizAdjacencia grafoEuleriano = new MatrizAdjacencia(4, false, false);
		grafoEuleriano.inserirAresta(0, 1);
		grafoEuleriano.inserirAresta(1, 2);
		grafoEuleriano.inserirAresta(2, 3);
		grafoEuleriano.inserirAresta(3, 0);
		System.out.println(grafoEuleriano.verificarEulerianidade());
		*/
		
		/*
        MatrizAdjacencia grafoSemiHamiltoniano = new MatrizAdjacencia(5, false, false);
        grafoSemiHamiltoniano.inserirAresta(0, 1);
        grafoSemiHamiltoniano.inserirAresta(1, 2);
        grafoSemiHamiltoniano.inserirAresta(2, 3);
        grafoSemiHamiltoniano.inserirAresta(3, 4);
        System.out.println(grafoSemiHamiltoniano.verificarHamiltonianidade());
		*/
		
		/*ex2a
		MatrizAdjacencia grafo = new MatrizAdjacencia(5, true, true);
		grafo.inserirAresta(0, 4, 10);
		grafo.inserirAresta(0, 1, 1);
		grafo.inserirAresta(0, 3, 3);
		grafo.inserirAresta(1, 2, 5);
		grafo.inserirAresta(2, 4, 1);
		grafo.inserirAresta(3, 2, 2);
		grafo.inserirAresta(3, 4, 6);
		grafo.dijkstra(0, 1);
		grafo.dijkstra(0, 2);
		grafo.dijkstra(0, 3);
		grafo.dijkstra(0, 4);
		*/
		
		/*ex2b
		MatrizAdjacencia grafo = new MatrizAdjacencia(6, true, true);
		grafo.inserirAresta(0, 1, 15);
		grafo.inserirAresta(0, 2, 9);
		grafo.inserirAresta(1, 3, 2);
		grafo.inserirAresta(2, 1, 4);
		grafo.inserirAresta(2, 3, 3);
		grafo.inserirAresta(2, 4, 16);
		grafo.inserirAresta(3, 4, 6);
		grafo.inserirAresta(3, 5, 21);
		grafo.inserirAresta(4, 5, 7);
		grafo.dijkstra(0, 5);
		*/
		
		MatrizAdjacencia grafo = new MatrizAdjacencia(18, true, false);
		grafo.inserirAresta(0, 1, 170);
		grafo.inserirAresta(0, 3, 260);
		grafo.inserirAresta(1, 3, 135);
		grafo.inserirAresta(1, 2, 80);
		grafo.inserirAresta(3, 4, 50);
		grafo.inserirAresta(2, 4, 150);
		grafo.inserirAresta(2, 5, 100);
		grafo.inserirAresta(2, 6, 120);
		grafo.inserirAresta(4, 6, 70);
		grafo.inserirAresta(4, 8, 130);
		grafo.inserirAresta(6, 5, 150);
		grafo.inserirAresta(6, 7, 200);
		grafo.inserirAresta(5, 7, 80);
		grafo.inserirAresta(8, 9, 70);
		grafo.inserirAresta(9, 7, 160);
		grafo.inserirAresta(7, 10, 100);
		grafo.inserirAresta(9, 12, 80);
		grafo.inserirAresta(9, 10, 160);
		grafo.inserirAresta(9, 11, 80);
		grafo.inserirAresta(10, 11, 80);
		grafo.inserirAresta(12, 13, 70);
		grafo.inserirAresta(12, 11, 100);
		grafo.inserirAresta(10, 15, 200);
		grafo.inserirAresta(10, 14, 150);
		grafo.inserirAresta(11, 14, 110);
		grafo.inserirAresta(13, 14, 120);
		grafo.inserirAresta(13, 17, 50);
		grafo.inserirAresta(13, 16, 80);
		grafo.inserirAresta(16, 17, 50);
		grafo.inserirAresta(17, 14, 100);
		grafo.inserirAresta(14, 15, 140);
		grafo.dijkstra(4, 17);
	}
}
