/*
  clase que representa un Nodo de un grafo donde 
  x, y : es la posicion en pantalla del nodo
  c    : color del nodo
  vecinos : todos los vecinos que tiene
  id   : identificador del nodo
  mostrado : saber si ya se dibujo el nodo
*/

class Nodo{
  private float x;
  private float y;
  private color c;
  public ArrayList<Nodo> vecinos;
  private int id;
  public boolean mostrado;
  private String tarea;
  /*
    Constructor, asigna la posicion y el identificador dados, con un color negro por defecto que no se ha mostrado
  */
  Nodo(float x, float y, int id){
    this.x = x;
    this.y = y;
    this.id = id;
    this.c = color(0, 0, 0);
    this.vecinos = new ArrayList<Nodo>();
    this.mostrado = false;
    this.tarea = "";
  }
  
  Nodo(float x, float y, int id, String tarea){
    this.x = x;
    this.y = y;
    this.id = id;
    this.c = color(0, 0, 0);
    this.vecinos = new ArrayList<Nodo>();
    this.mostrado = false;
    this.tarea = tarea;
  }
  //colorea  al nodo
  public void setColor(color c){
    this.c = c;
  }
  //obtiene el color actual del nodo
  public color getColor(){
    return this.c;
  }
  //Agregar un vecino a este nodo y crear una arista entre ambos nodos
  public Arista agregarVecino(Nodo v){
    this.vecinos.add(v);
    v.vecinos.add(this);
    return new Arista(this, v);
  }
  //ver el nodo en pantalla
  public void mostrar(){
    if(tarea!= "")
    stroke(c);
    strokeWeight(15);
    point(x, y);
    textSize(20);
    fill(0);
    text(tarea, x+20, y+20);
    mostrado = true;
  }
  
}
