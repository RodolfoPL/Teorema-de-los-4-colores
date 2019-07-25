import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {

Grafo g;
String archivo[];
public void setup(){
  
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

public void draw(){
  noLoop();
  g.mostrar();
}
 
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
     strokeWeight(2.5f);
     line(n1.x, n1.y, n2.x, n2.y);
  }
}
/* 
 Clase que representa un grafo
 G = (V, E)
 */
class Grafo {
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> aristas;
  private int c[];

  Grafo() {
    aristas = new ArrayList<Arista>();
    nodos = new ArrayList<Nodo>();
    this.c = new int[5];
    this.c[0] = color(0, 0, 0);       //sin color (negro)
    this.c[1] = color(0, 0, 255);     //color 1 (azul)
    this.c[2] = color(255, 0, 0);     //color 2 (rojo)
    this.c[3] = color(0, 255, 0);     //color 3 (verde)
    this.c[4] = color(244, 215, 66);  //color 4 (amarillo)
  }

  //agregar un nodo al grafo
  public void addNodo(Nodo n) {
    for (int i=0; i<nodos.size(); i++) {
      if (n.y <= nodos.get(i).y) {
        nodos.add(i, n);
        return;
      }
    } 
    nodos.add(n);
  }

  //agregar una arista al grafo y ordenarlas por su coordenada y  
  public void addArista(Nodo a, Nodo b) {
    aristas.add(a.agregarVecino(b));
  }

  //mostrar el grafo
  public void mostrar() {
    for (Arista a : aristas) {
      a.mostrar();
    }
    for (Nodo n : nodos) {
      if (!n.mostrado) {
        n.mostrar();
      }
    }
  }

  //colorear el grafo
  public void colorear() {
    for (Nodo n : nodos) {
      int edoColores[] = new int[5]; 
      for (Nodo v : n.vecinos) {
        if (v.getColor() == c[0])   //si el vecino no tiene color
          edoColores[0]++;
        if (v.getColor() == c[1])  //si un vecino tiene el color 1;
          edoColores[1]++;
        if (v.getColor() == c[2])  //si un vecino tiene el color 2;
          edoColores[2]++;
        if (v.getColor() == c[3])  //si un vecino tiene el color 3;
          edoColores[3]++;
        if (v.getColor() == c[4])  //si un vecino tiene el color 4;
          edoColores[4]++;
      }
 
      //Si nungun vecino tiene color, colorear este nodo del color 1
      if (edoColores[0] == n.vecinos.size()) {   
        n.setColor(c[1]);
        continue;
      }
      if (edoColores[1] == 0) {   
        n.setColor(c[1]);
        continue;
      }
      //Si algun vecino ya es azul pintamos de rojo
      if(edoColores[2] == 0){
        n.setColor(c[2]);
        continue;
      }
      //Si algun vecino ya es rojo pintamos de verde
      if(edoColores[3] == 0){
        n.setColor(c[3]);
        continue;
      }
      //Si algun vecino ya es verde pintamos de amarillo
      if(edoColores[4] == 0){
        n.setColor(c[4]);
        continue;
      }
      if(edoColores[4] > 0){
        print("NO es un grafo planar!\n");
        n.setColor(c[0]);
        return;
      }
    }
   // print("Los nodos negros no deberian de ir");
  }
}
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
  private int c;
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
  public void setColor(int c){
    this.c = c;
  }
  //obtiene el color actual del nodo
  public int getColor(){
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
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
