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

    public String imprimirLista() {
        int count = 0;
        String texto = "";
        if (esVacio()) {
            System.out.println("La lista está vacía");

        } else {
            NodoHash aux = primero;
            for (int i = 0; i < tamano; i++) {
                texto += "\"" + aux.getPalabra() + "\" : " + aux.getCount() + "\n";
                count += aux.getCount();

                aux = aux.getSiguienteLista();

            }
        }
        System.out.println("");
        System.out.println(count);
        return texto;
    }

}
