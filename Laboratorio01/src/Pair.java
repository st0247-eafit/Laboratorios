
/**
 * Clase Pareja para poder hacer una lista que tenga dos valores en sus nodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pair<V, P>
{
    public V vertex;
    public P cost;
    
    public Pair(V v,P c) {vertex = v; cost = c;}
    
    public V getVertex () {
        return vertex;
    }
    
    public P getCost () {
        return cost;
    }
}
