package ArbolBinario;

public class Nodo {
    
    protected int dato;
    protected Nodo izdo;
     protected Nodo dcho;
 
 
     public Nodo (int valor){
         dato = valor;
         izdo = dcho = null;
     }
     //Segundo constructor
     public Nodo (Nodo ramaIzdo,int valor, Nodo ramaDcho){
         this.dato = valor;
         this.izdo = ramaIzdo;
         this.dcho = ramaDcho;
     }
 
 
     //accesos:
 
     public int valorNodo(){
         return dato;
     }
 
     public Nodo GetSubardoIzdo(){
         return izdo;
     }
 
     public Nodo GetSubardoDcho(){
         return dcho;
     }
 
 
     public void SetRamaIzdo(Nodo n){
         izdo = n;
     }
 
     public void SerRamaDcho(Nodo n){
         dcho = n;
     }
 
     public void imprimirDato() {
         System.out.println(this.valorNodo());
     }
 
 
 }