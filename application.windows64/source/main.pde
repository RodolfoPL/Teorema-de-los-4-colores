Grafo g;
String archivo[];
void setup(){
  size(800,800);
  g = new Grafo();
  archivo = loadStrings("input.txt");
  int noNodos = parseInt(archivo[0]);
  for(int i=1; i<=noNodos; i++){
     String aux[] = split(archivo[i], ",");  
     float x = parseFloat(aux[1]);
     float y = parseFloat(aux[2]);
     int id = parseInt(aux[0]);
     //solo puede ser con tareas o sin tareas
     //sin tareas
   //  g.addNodo(new Nodo(width - x, height-y, id));
     //con tareas
     String tarea = aux[3];     
     g.addNodo(new Nodo(width - x, height-y, id, tarea));
  }  
  int noAristas=parseInt(archivo[noNodos+1]);
  
  for(int i=1; i<=noAristas; i++){
    String aux[] = split(archivo[i+noNodos+1], ",");
    int n1 = parseInt(aux[0]);
    int n2 = parseInt(aux[1]);
    g.addArista(g.nodos.get(n1), g.nodos.get(n2));
  }
  g.colorear();
}

void draw(){
  noLoop();
  g.mostrar();
}
 
