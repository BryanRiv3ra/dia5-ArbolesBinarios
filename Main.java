import Personas.ArbolPersona;
import Personas.NodoPersona;
import ArbolBinario.Arbol;
import ArbolBinario.Nodo;

public class Main {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(16);
        
        // Elige uno de los siguientes métodos para visualizar
        arbol.visualizarArbol();
        // arbol.visualizarArbolMejorado();
        // arbol.visualizarArbolConCirculos();
    }
}