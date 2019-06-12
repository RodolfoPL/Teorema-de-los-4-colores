Grafo g;
void setup(){
  size(800,500);
  
  g = new Grafo();
  /*g.addNodo(new Nodo(100, 100, 1));  //0
  g.addNodo(new Nodo(400, 100, 2));  //1
  g.addNodo(new Nodo(250, 400, 3));  //2
  g.addNodo(new Nodo(250, 200, 4));  //3

  
  g.addArista(g.nodos.get(3),g.nodos.get(0));
  g.addArista(g.nodos.get(3),g.nodos.get(1));
  g.addArista(g.nodos.get(3),g.nodos.get(2));

  g.addArista(g.nodos.get(1),g.nodos.get(0));
  g.addArista(g.nodos.get(2),g.nodos.get(0));
  
  g.addArista(g.nodos.get(1),g.nodos.get(2));*/
  
  g.addNodo(new Nodo(400, 400, 1));  //0
  g.addNodo(new Nodo(100, 200, 2));  //1
  g.addNodo(new Nodo(400, 200, 3));  //2
  g.addNodo(new Nodo(700, 200, 4));  //3
  g.addNodo(new Nodo(400, 100, 4));  //4
  
  g.addArista(g.nodos.get(2),g.nodos.get(0));
  g.addArista(g.nodos.get(2),g.nodos.get(1));
  g.addArista(g.nodos.get(2),g.nodos.get(3));
  g.addArista(g.nodos.get(2),g.nodos.get(4));
    
  g.addArista(g.nodos.get(0),g.nodos.get(1));
  g.addArista(g.nodos.get(0),g.nodos.get(3));
  
  g.addArista(g.nodos.get(4),g.nodos.get(1));
  g.addArista(g.nodos.get(4),g.nodos.get(3));
  g.colorear();
}

void draw(){
  noLoop();
  g.mostrar();
}
 
