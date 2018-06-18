/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
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
public class Fondo extends JLabel {

    private String direccion = "";

    public Fondo() {
        setBorder(new LineBorder(Color.black));
    }

    public Fondo(String direccion) {
        setDireccion(direccion);
        setIcon(Imagen());
    }

    public final Icon Imagen() {
        Existe();
        ImageIcon iconoImagen = new ImageIcon(/*"D://Default//photos2-512.png"*/getDireccion());
        Icon icono = new ImageIcon(iconoImagen.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }

    public String Existe() {
        File archivo = new File(getDireccion());
        if (!archivo.exists()) {
            setDireccion("src/Default/photos2-512.png");
            return getDireccion();
        }
        return getDireccion();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
