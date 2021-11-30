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
public class HashTable {

    NodoHash[] tabla;
    int tamano; //n primo, mientras más pequeño más colisiones pueden ocurrir

    public HashTable(int tamano) {
        this.tamano = tamano;
        this.tabla = new NodoHash[tamano];
        for (int i = 0; i < tamano; i++) {
            this.tabla[i] = null;
        }
    }

    public int hashing(String llave) {
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < llave.length(); i++) {
            if (llave.codePointAt(i) == 32) {
                valor += 0;
            } else if (llave.codePointAt(i) >= 49 && llave.codePointAt(i) <= 57) {
                valor += (llave.codePointAt(i) - 47) * posicion;
            } else if (llave.codePointAt(i) >= 65 && llave.codePointAt(i) <= 90) {
                valor += (llave.codePointAt(i) - 54) * posicion;
            } else if (llave.codePointAt(i) >= 97 && llave.codePointAt(i) <= 122) {
                valor += (llave.codePointAt(i) - 60) * posicion;
            }
            posicion++;
        }
        return (valor % tamano);
    }
    
    public void insertar (String nombre) {
        int posicion = hashing(nombre);
        boolean existe = false;     
        
        if (this.tabla[posicion] != null){
            
            NodoHash temp = this.tabla[posicion];
            if (temp.getNombre().equals(nombre)){
                existe = true;
            }
            while (temp.getSiguiente() != null){
                temp = temp.getSiguiente();
                if (temp.getNombre().equals(nombre)){
                    existe = true;
                }
            }
            if (!existe){
                NodoHash nuevo = new NodoHash(nombre);
                temp.setSiguiente(nuevo);
            }
        }else{
            NodoHash nuevo = new NodoHash (nombre);
            this.tabla[posicion] = nuevo;
        }
    }
    
    public NodoHash buscar(String nombre){
        int posicion = hashing(nombre);
        NodoHash temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null){
            if (temp.getSiguiente() == null){
                existe = true;
            }else{
                while (temp.getSiguiente() != null && !existe){
                    if (temp.getNombre().equals(nombre)){
                        existe = true;
                    }else{
                        temp = temp.getSiguiente();
                    }
                }
            }
        }
        if (existe){
            return temp;
        }else{
            return null;
        }
    }

}
