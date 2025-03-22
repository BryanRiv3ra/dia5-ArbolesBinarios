package ArbolBinario;
public class Arbol {
    //nodo root
    private Nodo raiz;

    public Arbol(){
        this.raiz=null;

    }

    public void insertar(int dato){
        if(this.raiz==null){
            raiz = new Nodo(dato);
    }
        else{
            this.insertar(this.raiz,dato);

        }

        }
    private void insertar(Nodo padre, int dato){
        if(dato<padre.valorNodo()){
            if(padre.GetSubardoIzdo()==null){
                padre.SetRamaIzdo(new Nodo(dato));
            }
            else{
                insertar(padre.GetSubardoIzdo(),dato);
            }
        } else if (dato>padre.valorNodo()){
            if(padre.GetSubardoIzdo()==null){
                padre.SerRamaDcho(new Nodo(dato));
            } else {
                insertar(padre.GetSubardoDcho(),dato);
            }
        }
    }


}