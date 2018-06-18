/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Imagen implements Icon {

    private String direccion;
    private JLabel etiqueta;

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int valor = 0;

    public Imagen(JLabel etiqueta, int i) {
        valor = i;
        etiqueta.setBorder(new LineBorder(Color.black));
        if (i == 0) {
            setDireccion("src/Imagenes/Extra/uno.jpg");
        }
        if (i == 1) {
            setDireccion("src/Imagenes/Extra/dos.jpg");
        }
        if (i == 2) {
            setDireccion("src/Imagenes/Extra/tres.jpg");
        }
        if (i == 3) {
            setDireccion("src/Imagenes/Extra/cuatro.jpg");
        }
        if (i == 4) {
            setDireccion("src/Imagenes/Extra/cinco.jpg");
        }
        if (i == 5) {
            setDireccion("src/Imagenes/Extra/seis.jpg");
        }
        setEtiqueta(etiqueta);
        setDireccion(direccion);
        Imagen();
    }

    public void Imagen() {
        Existe();
        ImageIcon iconoImagen = new ImageIcon(/*"D://Default//photos2-512.png"*/getDireccion());
        Icon icono = new ImageIcon(iconoImagen.getImage().getScaledInstance(getEtiqueta().getWidth(), getEtiqueta().getHeight(), Image.SCALE_DEFAULT));
        getEtiqueta().setIcon(icono);
    }

    public String Existe() {
        File archivo = new File(getDireccion());
        if (!archivo.exists()) {
            setDireccion("src/Default/photos2-512.png");
            return getDireccion();
        }
        return getDireccion();
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return String.valueOf(valor + 1);
    }
}
