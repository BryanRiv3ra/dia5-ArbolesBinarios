package ArbolCadena;

public class NodoCadena {

    protected String dato;
    protected NodoCadena izdo;
    protected NodoCadena dcho;


    public NodoCadena (String valor){
        dato = valor;
        izdo = dcho = null;
    }
    //Segundo constructor
    public NodoCadena(NodoCadena ramaIzdo,String valor, NodoCadena ramaDcho){
        this.dato = valor;
        this.izdo = ramaIzdo;
        this.dcho = ramaDcho;
    }


    //accesos:

    public String valorNodo(){
        return dato;
    }

    public NodoCadena GetRamaIzdo(){
        return izdo;
    }

    public NodoCadena GetRamaDcho(){
        return dcho;
    }

    public String GetDato(){
        return dato;
    }

    public NodoCadena GetSubardoIzdo(){
        return izdo;
    }

    public NodoCadena GetSubardoDcho(){
        return dcho;
    }


    public void SetRamaIzdo(NodoCadena n){
        izdo = n;
    }

    public void SerRamaDcho(NodoCadena n){
        dcho = n;
    }

    public void imprimirDato() {
        System.out.println(this.valorNodo());
    }
}