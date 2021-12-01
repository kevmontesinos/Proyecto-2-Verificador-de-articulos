/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 *
 * @author Kevin
 */
public class ListaEnlazada {

    NodoHash primero;
    NodoHash ultimo;
    int tamano;

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public NodoHash getPrimero() {
        return primero;
    }

    public void agregarInicio(NodoHash nuevo) {

        if (esVacio()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguienteLista(primero);
            primero = nuevo;
        }
        tamano++;
    }

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

    public void ordenarLista() {
        this.primero = mergeSort(this.primero);
    }

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
