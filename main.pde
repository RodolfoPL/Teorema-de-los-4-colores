Grafo g;
void setup(){
  size(800,500);
  
  g = new Grafo();
  g.addNodo(new Nodo(100, 200, 1));
  g.addNodo(new Nodo(400, 200, 2));
  g.addNodo(new Nodo(400, 500, 3));
  g.addArista(g.nodos.get(0),g.nodos.get(1));
  g.addArista(g.nodos.get(0),g.nodos.get(2));
  g.addArista(g.nodos.get(1),g.nodos.get(2));
}

void draw(){
  noLoop();
  g.mostrar();
}
  
