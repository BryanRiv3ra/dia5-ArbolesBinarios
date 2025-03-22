import Personas.ArbolPersona;

public class Main {

    public static void main(String[] args) {
        ArbolPersona arbol = new ArbolPersona();
        arbol.insertar("Makoto", 504023);
        arbol.insertar("Yui", 504024);
        arbol.insertar("Ren", 504025);
        arbol.insertar("victor", 504026);
    
        // Mostrar el contenido del árbol
        System.out.println("Recorrido in-orden del árbol:");
        arbol.inOrden();
    
        System.out.println("Fin");
    }
}