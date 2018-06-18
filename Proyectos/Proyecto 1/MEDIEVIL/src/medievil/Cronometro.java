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
public class Cronometro extends JLabel implements Runnable {

    Thread hilo = new Thread(this);

    public Cronometro() {
        Cronometro();
    }

    public void Cronometro() {

        setBounds(650, 0, 33, 25);
        setHorizontalAlignment(0);
        setBorder(new LineBorder(Color.black));
        setText("00:00");
        hilo.start();
    }

    @Override
    public void run() {
        Contar();
    }

    public void Contar() {
        try {
            for (int i = 120; i >=0 ; i--) {
                int tiempo = i;
                int segundo = tiempo % 60;
                tiempo = tiempo / 60;
                int minuto = tiempo % 60;
                int hora = tiempo / 60;
                String cronometro = "";
                if (i < 3600) {
                } else {

                    cronometro += hora + ":";
                }
                if (minuto < 10) {
                    cronometro += "0" + minuto + ":";
                } else {
                    cronometro += "" + minuto + ":";

                }

                if (segundo < 10) {
                    cronometro += "0" + segundo + "";
                } else {
                    cronometro += "" + segundo + "";

                }
                setText(cronometro);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }

}
