package proyecto.pkg2;

/**
 *
 * Clase para el NodoHash (único nodo que usa el proyecto) utilizado para el
 * HashTable y la lista enlazada
 */
public class NodoHash {

    //Campos de la clase
    private NodoHash siguiente; //apuntador a siguiente en la hash table, en caso de haber colisiones
    private NodoHash siguienteLista; //apuntador siguiente en la lista
    private String palabra;
    private int count;

    //Constructor de la clase
    public NodoHash(String palabra) {
        this.siguiente = null;
        this.palabra = palabra;
        this.count = 1;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String nombre) {
        this.palabra = nombre;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    public NodoHash getSiguienteLista() {
        return siguienteLista;
    }

    public void setSiguienteLista(NodoHash siguienteLista) {
        this.siguienteLista = siguienteLista;
    }

}
