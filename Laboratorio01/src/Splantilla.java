/**
 * Esta clase debe de contener la solucion al problema planteado en el punto 1
 * del laboratorio#1 del curso de estructura de datos y algoritmos II
 * @author Daniel Mesa, Mauricio Toro
 * @version 1.0
 */
import java.io.*;
import java.util.Scanner;

public class Splantilla
{
  /**
   * El metodo debe de leer el archivo y construir la estrcutura de datos con el mapa
   *
   */
  public static void makeMap()
  {
  }
  public void readCoordinates(Digraph graph) {
    final String fileName = "C:\\Users\\saocr\\IdeaProjects\\Laboratorios\\Laboratorio01\\src\\medellin_colombia-grande.txt";
    String findLocation = "Arcos.";
    BufferedReader bufferedReader;
    Scanner sc = new Scanner(System.in);
    long id1;
    long id2;
    double distance;
    try {
      bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
      sc = new Scanner(bufferedReader);
    } catch ( Exception e ) {
      System.out.println(e);
      System.exit(-1);
    }
    sc.nextLine();
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      if(line.contains(findLocation)){
        while(sc.hasNextLine()) {
          line = sc.nextLine();
          String [] lineSplit = line.split(" ", 4);
                    id1 = Long.parseLong(lineSplit[0]);
                    id2 = Long.parseLong(lineSplit[1]);
          distance = Double.parseDouble(lineSplit[2]);
          graph.addVertex(id1, 0,0);
          System.out.println(graph.addArc(id1, id2, distance));
        }
      }
    }
  }
  /**
   * Metodo principal del programa
   * @param args un array de argumentos
   */
  public static void main(String[] args)
  {
    DigraphAlgorithms dga = new DigraphAlgorithms();
    Splantilla sp = new Splantilla();
    Digraph<Long, Double> gragh = new Digraph<>();
    sp.readCoordinates(gragh);
    dga.dibujarGrafo(gragh);
  }
}
