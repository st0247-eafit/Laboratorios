import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
  LinkedList<LinkedList<Pareja<Integer,Integer>>> lista;

	/**
	* Constructor para el grafo
	* @param size numero de vetices del grafo
	*
	*/
	public DigraphAL(int size) {
    super(size);
		lista = new LinkedList();
    for (int i = 1; i <= size; i++)
       lista.add(new LinkedList<Pareja<Integer,Integer>>());
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public void addArc(int source, int destination, int weight){
    LinkedList<Pareja<Integer,Integer>> listaSource = lista.get(source);
		listaSource.add(new Pareja<>(destination, weight));
	}

	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<Integer> getSuccessors(int vertex) {
		// Una nueva lista que saque los sucesores
     ArrayList<Integer> successors = new ArrayList();
     LinkedList<Pareja<Integer,Integer>> listaDeParejas = lista.get(vertex);
     for (Pareja<Integer,Integer> pareja: listaDeParejas) {
		 successors.add(pareja.getVertice()); //segunda parte de la pareja
	 }
		if (successors.size() == 0) {
			return null;
		}
		successors.sort(Integer::compareTo);
		return successors;
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
		LinkedList<Pareja<Integer,Integer>> LSource = lista.get(source);
    int i= 0;
    int weight = 0;
	  while((weight != destination)&&(i < LSource.size())){
      if(LSource.get(i).getVertice() == destination) {
		  weight = LSource.get(i).getPeso();
	  }
      i++;
    }
    return weight;
	}

}
