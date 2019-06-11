/* Clase que representa un grafo
    G = (V, E)
*/
class Grafo{
  public ArrayList<Nodo> nodos;
  public ArrayList<Arista> aristas;
  
  Grafo(){
    aristas = new ArrayList<Arista>();
    nodos = new ArrayList<Nodo>();
  }
 
  //agregar un nodo al grafo
  public void addNodo(Nodo n){
    for(int i=0; i<nodos.size();i++){
      if(n.y <= nodos.get(i).y){
        nodos.add(i, n);
        return;
      }
    } 
    nodos.add(n);
  }
  
  //agregar una arista al grafo
  public void addArista(Nodo a, Nodo b){
    aristas.add(a.agregarVecino(b));
  }
  
  //mostrar el grafo
  public void mostrar(){
    for(Nodo n : nodos){
      if(!n.mostrado){
        n.mostrar();
      }
    }
    for(Arista a : aristas){
      a.mostrar();
    }
  }
}
