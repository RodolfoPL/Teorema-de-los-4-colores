/*
  Clase que representa una arista de un grafo
  Esta formado por dos nodos n1 y n2;
*/
class Arista{
  private Nodo n1;
  private Nodo n2;
  
  Arista(Nodo n1, Nodo n2){
    this.n1 = n1;
    this.n2 = n2;
  }
  //mostrar la arista como una linea entre dos nodos
  public void mostrar(){
     stroke(0);
     strokeWeight(2.5);
     line(n1.x, n1.y, n2.x, n2.y);
  }
}
