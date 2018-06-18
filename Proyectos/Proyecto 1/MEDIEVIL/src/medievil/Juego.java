/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Juego extends JFrame implements MouseListener {

    private JPanel panelPrincipal = new JPanel();
    private Tablero tablero;
    private Cronometro cronometro = new Cronometro();
    private JLabel seleccion = new JLabel();
    private char[][] caracter;
    int tamanyo = 0;

    public Juego() {
        Ventana();
        tamanyo = 6;
    }

    public final void Ventana() {
        setSize(1006, 629);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        panelPrincipal.setBounds(0, 0, 1000, 600);
        panelPrincipal.setBorder(new LineBorder(Color.black));
        panelPrincipal.setLayout(null);
        add(panelPrincipal);
//        casilla[0][0]=new JLabel();
//        casilla[0][0].setBounds(0,0,100,100);
//        casilla[0][0].setBorder(new LineBorder(Color.black));
//        panelPrincipal.add(casilla[0][0]);

        Preguntar();
        int casilla = tamanyo;
        tablero = new Tablero(casilla);
        panelPrincipal.add(tablero);
        repaint();
        casillas= new char[tamanyo][tamanyo];
        Casillas(tamanyo);
        int cantidad=((tamanyo*tamanyo)*5)/100;
        System.out.println(cantidad);
//        Extra(8);
//        Extra(7);
//        Extra(6);
//        Extra(5);
//        Extra(4);
//        Extra(3);
//        Extra(2);
//        Extra(1);
        cronometro.addMouseListener(this);
        panelPrincipal.add(cronometro);
        dado.setLocation(700, 100);

        dado.addMouseListener(this);
        panelPrincipal.add(dado);
        
    }
    public void Extra(int i){
        if(i==8){
            for(int j=0;j<((tamanyo*tamanyo)*(5/100));j++){
                
            }
        }
        if(i>0&&i<7){
            
        }
    }
    public void Casillas(int i){
        if(i==0){
            return;
        }
        for(int j=0;j<tamanyo;j++){
            casillas[i-1][j]='0';
            System.out.print(casillas[i-1][j]);
        }
        System.out.println();
        i--;
        Casillas(i);
    }
char[][]casillas;
    Dado dado = new Dado();
//    
    String[] tamanyoTablero = {"Aleatorio", "8 x 8", "9 x 9", "10 x 10", "11 x 11", "12 x 12", "13 x"
        + " 13", "14 x 14", "15 x 15", "16 x 16", "17 x 17", "18 x 18"};
    String seleccionar;

    public void Preguntar() {
        seleccionar = (String) JOptionPane.showInputDialog(null, "Selecciona el tamaño del tablero", "Elegir", 0, null, tamanyoTablero, tamanyoTablero[0]);
        if (seleccionar.equals("Aleatorio")) {;
            do {
                
                Random rnd = new Random();
                tamanyo=rnd.nextInt(19);
                System.out.println(tamanyo);
            } while (!(tamanyo > 7 && tamanyo<19));
        }

        if (seleccionar.equals("8 x 8")) {
            tamanyo = 8;
        }
        if (seleccionar.equals("9 x 9")) {
            tamanyo = 9;
        }
        if (seleccionar.equals("10 x 10")) {
            tamanyo = 10;
        }
        if (seleccionar.equals("11 x 11")) {
            tamanyo = 11;
        }
        if (seleccionar.equals("12 x 12")) {
            tamanyo = 12;
        }
        if (seleccionar.equals("13 x 13")) {
            tamanyo = 13;
        }
        if (seleccionar.equals("14 x 14")) {
            tamanyo = 14;
        }
        if (seleccionar.equals("15 x 15")) {
            tamanyo = 15;
        }
        if (seleccionar.equals("16 x 16")) {
            tamanyo = 16;
        }
        if (seleccionar.equals("17 x 17")) {
            tamanyo = 17;
        }
        if (seleccionar.equals("18 x 18")) {
            tamanyo = 18;
        }

        caracter = new char[tamanyo][tamanyo];
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == dado) {
            seleccion.setBounds(0, 0, 100, 100);
            Random random = new Random();
            int j = random.nextInt(6);
            Imagen imagen = new Imagen(seleccion, j);
            dado.add(seleccion);
            System.out.println(imagen);
            dado.removeMouseListener(this);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
