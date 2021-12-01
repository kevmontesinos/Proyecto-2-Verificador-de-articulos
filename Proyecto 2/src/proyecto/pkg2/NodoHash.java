package proyecto.pkg2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class NodoHash {

    private NodoHash siguiente;
    private NodoHash siguienteLista;
    private String palabra;
    private int count;

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
