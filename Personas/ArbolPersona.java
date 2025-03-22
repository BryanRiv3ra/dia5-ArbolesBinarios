package Personas;

public class ArbolPersona {
    private NodoPersona raiz;

    public ArbolPersona() {
        this.raiz = null;
    }

    public void insertar(String nombre, int numero) {
        raiz = insertarRec(raiz, nombre, numero);
    }

    private NodoPersona insertarRec(NodoPersona nodo, String nombre, int numero) {
        if (nodo == null) {
            return new NodoPersona(nombre, numero);
        }
        if (numero < nodo.getNumero()) {
            nodo.setRamaIzdo(insertarRec(nodo.getSubArbolIzdo(), nombre, numero));
        } else if (numero > nodo.getNumero()) {
            nodo.setRamaDcho(insertarRec(nodo.getSubArbolDcho(), nombre, numero));
        }
        return nodo;
    }


    public NodoPersona buscar(int numero) {
        return buscarRec(raiz, numero);
    }

    private NodoPersona buscarRec(NodoPersona nodo, int numero) {
        if (nodo == null || nodo.getNumero() == numero) {
            return nodo;
        }
        if (numero < nodo.getNumero()) {
            return buscarRec(nodo.getSubArbolIzdo(), numero);
        }
        return buscarRec(nodo.getSubArbolDcho(), numero);
    }


    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoPersona nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getSubArbolIzdo());
            System.out.println(nodo.getNumero() + ": " + nodo.getNombre());
            inOrdenRec(nodo.getSubArbolDcho());
        }
    }
}