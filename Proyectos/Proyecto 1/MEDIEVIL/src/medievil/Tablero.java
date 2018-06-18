/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Tablero extends Fondo  {

    private int tamanyo = 0;

    public Tablero() {
        this(8);
    }

    public Tablero(int tamanyo) {

        setTamanyo(tamanyo);
        int tamanyoFondo=600/tamanyo;
        setSize(tamanyo*tamanyoFondo, tamanyo*tamanyoFondo);
        setLocation(0, 0);
        setBorder(new LineBorder(Color.black));
        setDireccion("src/Imagenes/Extra/1.jpg");
        setIcon(this.Imagen());
        casillas = new JLabel[tamanyo][tamanyo];
        Casillas(tamanyo);
        

    }
    int aumentar = 0;

    public void Casillas(int i) {
        if (i == 0) {
            aumentar = 0;
            return;
        }
        for (int j = 0; j < getTamanyo(); j++) {
            casillas[aumentar][j] = new JLabel();
            casillas[aumentar][j].setSize(600/getTamanyo(), 600/getTamanyo());
            casillas[aumentar][j].setLocation(j * (600/getTamanyo()), aumentar * (600/getTamanyo()));
            casillas[aumentar][j].setBorder(new LineBorder(Color.black));
            add(casillas[aumentar][j]);
        }
        aumentar++;
        i--;
        Casillas(i);
    }
    private JLabel[][] casillas;

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }
}
