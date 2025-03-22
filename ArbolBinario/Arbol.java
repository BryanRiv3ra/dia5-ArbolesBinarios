package ArbolBinario;

public class Arbol {
    // Nodo raíz
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    // Método público para insertar un dato
    public void insertar(int dato) {
        if (this.raiz == null) {
            raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    // Método privado para insertar un dato recursivamente
    private void insertar(Nodo padre, int dato) {
        if (dato < padre.valorNodo()) {
            if (padre.GetSubardoIzdo() == null) {
                padre.SetRamaIzdo(new Nodo(dato));
            } else {
                insertar(padre.GetSubardoIzdo(), dato);
            }
        } else if (dato > padre.valorNodo()) {
            if (padre.GetSubardoDcho() == null) {
                padre.SerRamaDcho(new Nodo(dato));
            } else {
                insertar(padre.GetSubardoDcho(), dato);
            }
        }
        // Si el dato es igual, no se hace nada (manejo de duplicados)
    }

    // Método público para recorrido postorden
    public void postorden() {
        postorden(this.raiz);
    }

    // Método privado para recorrido postorden recursivo
    private void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.GetSubardoIzdo());
            postorden(nodo.GetSubardoDcho());
            System.out.println(nodo.valorNodo() + " ");
        }
    }

    // Método público para recorrido preorden
    public void preorden() {
        preorden(this.raiz);
    }

    // Método privado para recorrido preorden recursivo
    private void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.valorNodo() + " ");
            preorden(nodo.GetSubardoIzdo());
            preorden(nodo.GetSubardoDcho());
        }
    }

    // Método público para recorrido inorden descendente
    public void inordenDescendente() {
        inordenDescendente(this.raiz);
    }

    // Método privado para recorrido inorden descendente recursivo
    private void inordenDescendente(Nodo nodo) {
        if (nodo != null) {
            inordenDescendente(nodo.GetSubardoDcho());
            System.out.println(nodo.valorNodo() + " ");
            inordenDescendente(nodo.GetSubardoIzdo());
        }
    }

    public void mostrarArbol() {
        mostrarArbol(this.raiz, "", true);
    }

    // Método privado para mostrar el árbol en el formato solicitado (recursivo)
    private void mostrarArbol(Nodo nodo, String prefijo, boolean esDerecho) {
        if (nodo != null) {
            // Mostrar el subárbol izquierdo primero
            mostrarArbol(nodo.GetSubardoIzdo(), prefijo + (esDerecho ? "│   " : "    "), false);

            // Imprimir el nodo actual con el prefijo y el carácter correspondiente
            System.out.println(prefijo + (esDerecho ? "└──" : "┌── ") + nodo.valorNodo());

            // Mostrar el subárbol derecho después
            mostrarArbol(nodo.GetSubardoDcho(), prefijo + (esDerecho ? "    " : "│   "), true);
        }
    }
    
    /**
     * Método público para mostrar la estructura visual del árbol en consola
     * con orientación de arriba hacia abajo
     */
    public void visualizarArbol() {
        System.out.println("Estructura del Árbol Binario:");
        visualizarArbol(this.raiz, 0, "");
    }

    /**
     * Método privado para visualizar el árbol de forma recursiva
     * @param nodo Nodo actual a visualizar
     * @param nivel Nivel de profundidad en el árbol
     * @param prefijo Prefijo para las conexiones
     */
    private void visualizarArbol(Nodo nodo, int nivel, String prefijo) {
        if (nodo == null) {
            return;
        }
        
        // Espacio entre niveles
        String espacios = "    ".repeat(nivel);
        
        // Visualizar subárbol derecho primero (aparecerá arriba)
        visualizarArbol(nodo.GetSubardoDcho(), nivel + 1, "/");
        
        // Mostrar el nodo actual como un círculo
        if (nivel == 0) {
            // Nodo raíz
            System.out.println(espacios + "(" + nodo.valorNodo() + ")");
        } else {
            // Otros nodos con conexión
            System.out.println(espacios + prefijo + "(" + nodo.valorNodo() + ")");
        }
        
        // Visualizar subárbol izquierdo después (aparecerá abajo)
        visualizarArbol(nodo.GetSubardoIzdo(), nivel + 1, "\\");
    }
    
    /**
     * Método público para mostrar una representación visual mejorada del árbol
     * con orientación de arriba hacia abajo y círculos para los nodos
     */
    public void visualizarArbolMejorado() {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }
        
        // Calculamos la altura del árbol para determinar el ancho necesario
        int altura = obtenerAltura(raiz);
        int ancho = (int) Math.pow(2, altura + 1) - 1;
        
        // Matriz para almacenar la representación del árbol
        String[][] representacion = new String[altura * 2][ancho];
        
        // Inicializar la matriz con espacios en blanco
        for (int i = 0; i < representacion.length; i++) {
            for (int j = 0; j < representacion[0].length; j++) {
                representacion[i][j] = " ";
            }
        }
        
        // Llenar la matriz con la representación del árbol
        llenarMatriz(raiz, representacion, 0, 0, ancho - 1);
        
        // Imprimir la matriz
        for (String[] fila : representacion) {
            for (String celda : fila) {
                System.out.print(celda);
            }
            System.out.println();
        }
    }

    /**
     * Calcula la altura del árbol
     * @param nodo Nodo actual
     * @return Altura del árbol
     */
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(obtenerAltura(nodo.GetSubardoIzdo()), obtenerAltura(nodo.GetSubardoDcho()));
    }

    /**
     * Llena la matriz con la representación del árbol
     * @param nodo Nodo actual
     * @param matriz Matriz de representación
     * @param nivel Nivel actual en el árbol
     * @param izquierda Límite izquierdo de la representación
     * @param derecha Límite derecho de la representación
     */
    private void llenarMatriz(Nodo nodo, String[][] matriz, int nivel, int izquierda, int derecha) {
        if (nodo == null) {
            return;
        }
        
        int medio = (izquierda + derecha) / 2;
        
        // Colocar el nodo actual como un círculo
        matriz[nivel * 2][medio] = "⦿" + nodo.valorNodo() + "⦿";
        
        // Dibujar conexiones
        if (nodo.GetSubardoIzdo() != null) {
            int siguienteMedio = (izquierda + medio) / 2;
            // Dibujar línea diagonal hacia abajo-izquierda
            matriz[nivel * 2 + 1][medio - 1] = "/";
            llenarMatriz(nodo.GetSubardoIzdo(), matriz, nivel + 1, izquierda, medio - 1);
        }
        
        if (nodo.GetSubardoDcho() != null) {
            int siguienteMedio = (medio + derecha) / 2;
            // Dibujar línea diagonal hacia abajo-derecha
            matriz[nivel * 2 + 1][medio + 1] = "\\";
            llenarMatriz(nodo.GetSubardoDcho(), matriz, nivel + 1, medio + 1, derecha);
        }
    }
    
    /**
     * Método alternativo para visualizar el árbol con mejor formato,
     * orientación de arriba hacia abajo y representación clara de nodos y conexiones
     */
    public void visualizarArbolConCirculos() {
        int altura = obtenerAltura(raiz);
        int anchoPantalla = 80; // Ancho estándar de consola
        
        System.out.println("\n----- ÁRBOL BINARIO -----");
        
        if (raiz == null) {
            System.out.println("(Árbol vacío)");
            return;
        }
        
        // Creamos niveles para la representación
        String[][] niveles = new String[altura][anchoPantalla];
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchoPantalla; j++) {
                niveles[i][j] = " ";
            }
        }
        
        // Calculamos la distancia entre nodos dependiendo del nivel
        int[] distanciaNivel = new int[altura];
        for (int i = 0; i < altura; i++) {
            distanciaNivel[i] = anchoPantalla / (int)Math.pow(2, i + 1);
        }
        
        // Llenamos la matriz de representación
        llenarNiveles(raiz, niveles, distanciaNivel, 0, anchoPantalla / 2, 0);
        
        // Imprimimos la representación
        for (int i = 0; i < altura; i++) {
            // Imprimir fila de nodos
            for (int j = 0; j < anchoPantalla; j++) {
                System.out.print(niveles[i][j]);
            }
            System.out.println();
            
            // Imprimir conexiones si no es el último nivel
            if (i < altura - 1) {
                for (int j = 0; j < anchoPantalla; j++) {
                    if (j < anchoPantalla - 1 && niveles[i][j].equals("○") && !niveles[i + 1][j - 1].equals(" ")) {
                        System.out.print("/");
                    } else if (j > 0 && niveles[i][j-1].equals("○") && !niveles[i + 1][j + 1].equals(" ")) {
                        System.out.print("\\");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("--------------------------");
    }
    
    /**
     * Método auxiliar para llenar los niveles de representación
     */
    private void llenarNiveles(Nodo nodo, String[][] niveles, int[] distanciaNivel, int nivel, int posicion, int offset) {
        if (nodo == null || nivel >= niveles.length) {
            return;
        }
        
        // Dibujamos el nodo como un círculo
        String nodoStr = "○" + nodo.valorNodo() + "○";
        int posicionInicial = Math.max(0, posicion - nodoStr.length() / 2);
        
        for (int i = 0; i < nodoStr.length(); i++) {
            if (posicionInicial + i < niveles[nivel].length) {
                niveles[nivel][posicionInicial + i] = String.valueOf(nodoStr.charAt(i));
            }
        }
        
        // Calculamos posiciones para los hijos
        int proxDistancia = distanciaNivel[nivel];
        
        // Llamadas recursivas para los hijos
        if (nodo.GetSubardoIzdo() != null) {
            llenarNiveles(nodo.GetSubardoIzdo(), niveles, distanciaNivel, nivel + 1, posicion - proxDistancia, offset);
        }
        
        if (nodo.GetSubardoDcho() != null) {
            llenarNiveles(nodo.GetSubardoDcho(), niveles, distanciaNivel, nivel + 1, posicion + proxDistancia, offset);
        }
    }
}