/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 *
 * Lista enlazada para almacenar las palabras independientemente del hash que
 * contengan, es usada para que sea más eficiente a la hora de recorrer todas
 * las palabras y saber la cuenta, ya que recorrerarlas en la HashTable sería
 * computacionalmente costoso
 *
 */
public class ListaEnlazada {

    //Campos de la clase
    NodoHash primero;
    NodoHash ultimo;
    int tamano;

    /**
     *
     * Constructor de ListaClientes
     *
     */
    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    /**
     *
     * Método que devuelve si la lista es vacia o no
     *
     * @return true si está vacía, si no false
     *
     */
    public boolean esVacio() {
        return primero == null;
    }

    /**
     *
     * Procedimiento para agregar elementos al final de la lista
     *
     * @param nuevo nuevo nodo a agregar, este nodo contendrá la palabra y las
     * veces que se repite
     *
     */
    public void agregarFinal(NodoHash nuevo) {

        if (esVacio()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguienteLista(nuevo);
            ultimo = nuevo;
        }
        tamano++;
    }

    /**
     *
     * Procedimiento para ordenar la lista de manera decreciente, para esto se
     * utiliza el método de Merge Sort en base al atributo count
     *
     */
    public void ordenarLista() {
        this.primero = mergeSort(this.primero);
        NodoHash aux = this.primero;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        this.ultimo = aux;
    }

    /**
     *
     * Procedimiento para ordenar la lista de manera decreciente, para esto se
     * utiliza el método de Merge Sort en base al atributo count
     *
     */
    public NodoHash sortedMerge(NodoHash a, NodoHash b) {
        NodoHash resultado = null;

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.getCount() >= b.getCount()) {
            resultado = a;
            resultado.setSiguienteLista(sortedMerge(a.getSiguienteLista(), b));
        } else {
            resultado = b;
            resultado.setSiguienteLista(sortedMerge(a, b.getSiguienteLista()));

        }
        return resultado;
    }

    public NodoHash mergeSort(NodoHash h) {

        if (h == null || h.getSiguienteLista() == null) {
            return h;
        }

        NodoHash mitad = getMitad(h);
        NodoHash mitadSiguiente = mitad.getSiguienteLista();

        mitad.setSiguienteLista(null);

        NodoHash izq = mergeSort(h);

        NodoHash der = mergeSort(mitadSiguiente);

        NodoHash sortedlist = sortedMerge(izq, der);
        return sortedlist;
    }

    public static NodoHash getMitad(NodoHash primero) {
        if (primero == null) {
            return primero;
        }

        NodoHash slow = primero, fast = primero;

        while (fast.getSiguienteLista() != null && fast.getSiguienteLista().getSiguienteLista() != null) {
            slow = slow.getSiguienteLista();
            fast = fast.getSiguienteLista().getSiguienteLista();
        }
        return slow;
    }

    /**
     *
     * Procedimiento que devuelve la información de la lista de la siguiente manera: "palabra : veces que se repite"
     *
     * @return información de la lista 
     */
    public String imprimirLista() {
        String texto = "";
        if (esVacio()) {

        } else {
            NodoHash aux = primero;
            for (int i = 0; aux.getSiguienteLista() != null; i++) {
                texto += "\"" + aux.getPalabra() + "\" : " + aux.getCount() + "\n";

                aux = aux.getSiguienteLista();

            }
        }
        return texto;
    }
}
