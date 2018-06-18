/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Inicio extends JFrame implements MouseListener {

    public Inicio() {
        Ventana();
    }
    private Fondo fondo = new Fondo();

    public final void Ventana() {
        setSize(1006, 629);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setDireccion("src/Imagenes/Extra/armadura.jpg");
        fondo.setIcon(fondo.Imagen());
        add(fondo);
        menu();
        aumentar=1;
        Accion(3);
        etiquetas[1].setText("Juego Nuevo");
        etiquetas[1].setHorizontalAlignment(CENTER);
        etiquetas[2].setText("Puntaje mayor");
        etiquetas[2].setHorizontalAlignment(CENTER);
        etiquetas[3].setText("Salir");
        etiquetas[3].setHorizontalAlignment(CENTER);
        repaint();
    }
    JLabel[]etiquetas=new JLabel[4];
    int aumentar=0;
    public void menu(){
        etiquetas[0]=new JLabel();
        etiquetas[0].setSize(200,150);
        etiquetas[0].setLocation(400,225);
        fondo.add(etiquetas[0]);
        
    }
    public void Accion(int i){
        if(i==0){
            aumentar=0;
            return;
        }
        etiquetas[aumentar]=new JLabel();
        etiquetas[aumentar].setSize(200,50);
        etiquetas[aumentar].setLocation(0,(aumentar-1)*50);
        etiquetas[aumentar].setBorder(new LineBorder(Color.white));
        etiquetas[aumentar].addMouseListener(this);
        etiquetas[aumentar].setForeground(Color.white);
        
        etiquetas[0].add(etiquetas[aumentar]);
        aumentar++;
        i--;
        Accion(i);
    }

    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==etiquetas[1]){
            this.setVisible(false);
            Principal principal = new Principal();
        }
        if(me.getSource()==etiquetas[2]){
            
        }
        if(me.getSource()==etiquetas[3]){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("mouse Exited");
    }

}
