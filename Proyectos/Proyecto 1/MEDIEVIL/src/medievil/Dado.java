/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Dado extends JLabel implements Runnable {

    Thread hilo = new Thread(this);

    public Dado() {
        setBorder(new LineBorder(Color.black));
        setSize(100, 100);
        hilo.start();
    }

    public void Dados(int numero) throws InterruptedException {
        for (int i = 0; i < numero; i++) {
            Random aleatorio = new Random();
            int j = aleatorio.nextInt(6);
            String cadena = "";
            if (j == 0) {
                cadena += "src/Imagenes/Extra/uno.jpg";
            }
            if (j == 1) {
                cadena += "src/Imagenes/Extra/dos.jpg";
            }
            if (j == 2) {
                cadena += "src/Imagenes/Extra/tres.jpg";
            }
            if (j == 3) {
                cadena += "src/Imagenes/Extra/cuatro.jpg";
            }
            if (j == 4) {
                cadena += "src/Imagenes/Extra/cinco.jpg";
            }
            if (j == 5) {
                cadena += "src/Imagenes/Extra/seis.jpg";
            }

            File archivo = new File(cadena);
            if (!archivo.exists()) {
                cadena = "src/Default/photos2-512.png";
            }

            ImageIcon iconoImagen = new ImageIcon(/*"D://Default//photos2-512.png"*/cadena);
            Icon icono = new ImageIcon(iconoImagen.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
            setIcon(icono);
            Thread.sleep(500);
        }
        Dados(numero);
    }

    @Override
    public void run() {
        try {
            Dados(6);
        } catch (InterruptedException e) {
        }
    }
}
