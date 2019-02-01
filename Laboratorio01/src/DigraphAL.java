import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL<V, C>{
	
	HashMap<V, LinkedList<Pair<V, C>>> arcs;
	HashMap<V, Vertex> verexes;
	
	/**
	* Constructor para el grafo
	*/
	public DigraphAL() {
    super();
    arcs = new HashMap<>();
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param distance  el peso de la longitud entre source y destination
	*/
	public void addArc(V source, V destination, C distance){
		(arcs.get(source)).add(new Pair<>(destination, distance));
	}
	
	/**
	 * Metodos para agregar nuevos vertices
	 *
	 * @param id es el ID de el vertice
	 * @param coordinateX es la primera coordenada del vertice
	 * @param coordinateY es la segunda coordenada del vertice
	 */
	public void addVertex (V id, double coordinateX, double coordinateY) {
		verexes.put(id, (new Vertex((Long ) id, coordinateX, coordinateY)));
		arcs.put(id, new LinkedList<>());
	}
	
	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<V> getSuccessors(long vertex) {
		// Una nueva lista que saque los sucesores
     ArrayList<V> successors = new ArrayList<>();
     LinkedList<Pair<V, C>> listPairs = arcs.get(vertex);
     for (Pair<V, C> pair: listPairs) {
		 successors.add(pair.getVertex()); //segunda parte de la pareja
	 }
		if (successors.size() == 0) {
			return null;
		}
		return successors;
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public C getWeight(V source, V destination) {
		LinkedList<Pair<V,C>> LSource = arcs.get(source);
    int i = 0;
    V n = LSource.get(0).getVertex();
    C cost = LSource.get(0).getCost();
	  while(( n != destination)&&(i < LSource.size())){
      if(LSource.get(i).getVertex() == destination) {
      	n = LSource.get(i).getVertex();
      	cost = LSource.get(i).getCost();
	  	}
      i++;
    }
    return cost;
	}
}
