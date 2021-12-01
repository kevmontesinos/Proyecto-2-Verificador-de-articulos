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
    private String nombre;
    private int count;

    public NodoHash(String palabra) {
        this.siguiente = null;
        this.nombre = palabra;
        this.count = 1;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
    

}
