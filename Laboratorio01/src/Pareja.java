
/**
 * Clase Pareja para poder hacer una lista que tenga dos valores en sus nodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pareja<V, P>
{
    public V vertice;
    public P peso;
    
    public Pareja(V v,P p) {vertice = v; peso = p;}
    
    public V getVertice () {
        return vertice;
    }
    
    public P getPeso () {
        return peso;
    }
}
