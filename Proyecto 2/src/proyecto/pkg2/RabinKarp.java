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
public class RabinKarp {

    public final static int d = 256;
    String indicesTxt = "";

    public String indices(String patron, String texto) {
        String ind = search(patron, texto.toLowerCase(), 101);

        if (!ind.isBlank() || !ind.isEmpty()) {

            String[] array = ind.split("\n");
            int[] indices = new int[array.length];
            int posIni, posFin;
            int desplazamiento = 0;
            for (int i = 0; i < indices.length; i++) {
                indices[i] = Integer.parseInt(array[i].split(" ")[7]);
                if (i < 1) {
                    posIni = indices[i];
                    posFin = posIni + patron.length();
                } else {
                    desplazamiento += 6;
                    posIni = indices[i] + desplazamiento;
                    posFin = posIni + patron.length();
                }
                texto = texto.substring(0, posIni) + " © " + texto.substring(posIni, posFin) + " © " + texto.substring(posFin, texto.length());

            }
        } else {
            return "";
        }
        return ind + texto;

    }

    public String search(String patron, String txt, int prim) {
        int M = patron.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash para patron
        int t = 0; // hash para texto
        int h = 1;

        for (i = 0; i < M - 1; i++) {
            h = (h * d) % prim;
        }


        for (i = 0; i < M; i++) {
            p = (d * p + patron.charAt(i)) % prim;
            t = (d * t + txt.charAt(i)) % prim;
        }

        for (i = 0; i <= N - M; i++) {

            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != patron.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {

                    indicesTxt += ("El fragmento fue encontrado en la posición " + i + "\n");
                }
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % prim;

                if (t < 0) {
                    t = (t + prim);
                }
            }
        }
        return indicesTxt;
    }

}
