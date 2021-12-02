/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Funciones {

    /**
     * Método lee el archivo cargado de manera remota
     */
    public String leerTxtCargado() {

        String line;
        String txt = ""; //donde se guardará todo

        try {
            JFileChooser fileC = new JFileChooser();
            fileC.showOpenDialog(null);
            File file = fileC.getSelectedFile();
            if (!file.exists()) {
                file.createNewFile(); //si el archivo no existe, lo crea
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        txt += line + " ";
                    }

                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer");
        }
        txt = txt.replaceAll("\\s{2,}", " ").trim();
        return txt;
    }

    /**
     * Función que te devuelve un arreglo con todas las palabras del texto, sin caracteres especiales.
     * 
     * @param texto texto proveniente de leer el .txt cargado
     * @return arreglo con las palabras
     * 
     */
    public String[] soloPalabrasArray(String texto) {

        texto = texto.replaceAll("[^A-Za-z0-9áéíóúÁÉÍÓÚüÜ ]", "").toLowerCase();
        texto.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u').replace("ü", "u");

        String[] array = texto.split(" ");

        return array;

    }
}
