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

    public void insertar(String palabra, ListaEnlazada lista) {
        int posicion = hashing(palabra);
        boolean existe = false;

        if (this.tabla[posicion] != null) {

            NodoHash temp = this.tabla[posicion];
            if (temp.getPalabra().equals(palabra)) {
                existe = true;
                temp.addCount();
            }
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                if (temp.getPalabra().equals(palabra)) {
                    existe = true;
                    temp.addCount();

                }
            }
            if (!existe) {
                NodoHash nuevo = new NodoHash(palabra);
                temp.setSiguiente(nuevo);
                lista.agregarFinal(nuevo);

            }
        } else {
            NodoHash nuevo = new NodoHash(palabra);
            this.tabla[posicion] = nuevo;
            lista.agregarFinal(nuevo);

        }
    }

    public NodoHash buscar(String palabra) {
        int posicion = hashing(palabra);
        NodoHash temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null) {
            if (temp.getSiguiente() == null) {
                existe = true;
            } else {
                while (temp.getSiguiente() != null && !existe) {
                    if (temp.getPalabra().equals(palabra)) {
                        existe = true;
                    } else {
                        temp = temp.getSiguiente();
                    }
                }
            }
        }
        if (existe) {
            return temp;
        } else {
            return null;
        }
    }

//    public String repeticiones() {
//        String texto = "";
//        int cuenta = 0;
//        for (int i = 0; i < tamano; i++) {
//            if (this.tabla[i] != null) {
//                texto += "\"" + this.tabla[i].getPalabra() + "\" : " + this.tabla[i].getCount() + "\n";
//                cuenta += this.tabla[i].getCount();
//                System.out.println(cuenta);
//                NodoHash temp = this.tabla[i].getSiguiente();
//                while (temp != null) {
//                    texto += "*" + "\"" + temp.getPalabra()+ "\": " + temp.getCount() + "\n";
//                    cuenta += this.tabla[i].getCount();
//                    System.out.println(cuenta);
//                    temp = temp.getSiguiente();
//
//                }
//
//            }
//        }
//        System.out.println("Cuenta " + cuenta);
//        return texto;
//    }

}
