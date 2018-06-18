/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author isb3d
 */
public class Principal extends JFrame implements MouseListener, ActionListener {

    private final JPanel panelPrincipal = new JPanel();
    private final Personaje[] personajes = new Personaje[30];
    private JPanel[] paneles = new JPanel[2];
    private Personaje[][] personajeJugador = new Personaje[2][3];
    private JLabel[] jugador = new JLabel[2];
    private JButton[] aceptar = new JButton[2];
    JPanel[] contenedorImagen = new JPanel[2];
    
    String jugadorA;
    String jugadorB;
    private int jugadores = 0;
    private int seleccion = 0;
    private int posX = 0;
    private int posY = 0;
    private int aumentar = 0;
    private final String direccion[] = {"src/Imagenes/Guerrero/Foto_caballero_del_espejismo.jpg",
        "src/Imagenes/Guerrero/Foto_dama_guerrera_del_páramo.jpg",
        "src/Imagenes/Guerrero/Foto_espadachín_silencioso_lv5.jpg",
        "src/Imagenes/Guerrero/Foto_gearfried_el_caballero_de_hierro.jpg",
        "src/Imagenes/Guerrero/Foto_gran_escudo_gardna.jpg",
        "src/Imagenes/Guerrero/Foto_guerrero_dai_grepher.jpg",
        "src/Imagenes/Guerrero/Foto_homúnculo_dorado.jpg",
        "src/Imagenes/Guerrero/Foto_héroe_del_destino_-_malicious.jpg",
        "src/Imagenes/Guerrero/Foto_héroe_elemental_tempest.jpg",
        "src/Imagenes/Guerrero/Foto_soldado_del_brillo_negro.jpg",
        "src/Imagenes/Mago/Foto_brujo_eliminador_oscuro.jpg",
        "src/Imagenes/Mago/Foto_chica_maga_choco.jpg",
        "src/Imagenes/Mago/Foto_chica_maga_limón.jpg",
        "src/Imagenes/Mago/Foto_chica_maga_manzana.jpg",
        "src/Imagenes/Mago/Foto_chica_maga_oscura.jpg",
        "src/Imagenes/Mago/Foto_duende_místico.jpg",
        "src/Imagenes/Mago/Foto_mago_de_la_fe.jpg",
        "src/Imagenes/Mago/Foto_mago_del_tiempo.jpg",
        "src/Imagenes/Mago/Foto_mago_oscuro.jpg",
        "src/Imagenes/Mago/Foto_mago_oscuro_del_caos.jpg",
        "src/Imagenes/Reina/Foto_escolta_de_la_reina.jpg",
        "src/Imagenes/Reina/Foto_gwenhwyfar,_reina_de_las_armas_nobles.jpg",
        "src/Imagenes/Reina/Foto_juez_emperatriz.jpg",
        "src/Imagenes/Reina/Foto_magidulce_reina_tiaramisú.jpg",
        "src/Imagenes/Reina/Foto_número_83_reina_de_la_galaxia.jpg",
        "src/Imagenes/Reina/Foto_protector_del_trono.jpg",
        "src/Imagenes/Reina/Foto_reina_de_hielo.jpg",
        "src/Imagenes/Reina/Foto_reina_del_destino_-_eternia.jpg",
        "src/Imagenes/Reina/Foto_reina_del_encanto_lv3.jpg",
        "src/Imagenes/Reina/Foto_reina_del_encanto_lv7.jpg"};

    public Principal() {
        Ventana();
    }

    public final void Ventana() {
        jugadorA = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre", "Primer jugador", 3);
        jugadorB = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre", "Segundo jugador", 3);
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
        Personajes(30);
        Paneles(2);
        repaint();
    }

    public void Personajes(int i) {
        if (i == 0) {
            posX = 0;
            posY = 0;
            aumentar = 0;
            return;
        }
        personajes[aumentar] = new Personaje(direccion[aumentar]);
        personajes[aumentar].setLocation(posX * 100, posY * 100);
        personajes[aumentar].addMouseListener(this);
        panelPrincipal.add(personajes[aumentar]);

        posX++;
        aumentar++;

        int residuo = aumentar % 10;
        if (residuo == 0 || residuo == 5) {
            posX = 0;
            posY++;
        }
        i--;
        Personajes(i);
    }

    public String Capturar(String texto, int i) {

        String direccion = "";
        boolean acertar = false;
        aumentar = 18;
        do {
            int contenedor = 0;
            if (i == 0) {
                contenedor = texto.length();

                acertar = true;
            } else {
                contenedor = 110 + aumentar;
            }
            for (int j = 110; j < contenedor; j++) {
                direccion += texto.charAt(j);
            }
            if (direccion.equals("src/Imagenes/Guerrero/")) {
                acertar = true;
            } else if (direccion.equals("src/Imagenes/Mago/")) {
                acertar = true;
            } else if (direccion.equals("src/Imagenes/Reina/")) {
                acertar = true;
            } else {
                if (acertar == true) {

                } else {

                    direccion = "";
                    aumentar += 1;
                }
            }
        } while (!(acertar == true));
        aumentar = 0;
        return direccion;
    }

    public void Bloquear(int i, int j) {
        if (j == 0) {
            aumentar = 0;
            return;
        }
        personajes[(i * 10) + aumentar].removeMouseListener(this);
        personajes[(i * 10) + aumentar].setEnabled(false);
        aumentar++;
        j--;
        Bloquear(i, j);
    }

    public void Paneles(int i) {
        if (i == 0) {
            aumentar = 0;
//            aceptar[1].removeChangeListener(this);
            return;
        }
        paneles[aumentar] = new JPanel();
        paneles[aumentar].setBounds(600, aumentar * 200 + (aumentar + 1) * 50, 300, 200);
        panelPrincipal.add(paneles[aumentar]);
        jugador[aumentar] = new JLabel();
        jugador[aumentar].setBounds(122, 0, 57, 50);
        jugador[aumentar].setText("Jugador " + (1 + aumentar));
        paneles[aumentar].add(jugador[aumentar]);
        contenedorImagen[aumentar] = new JPanel();
        contenedorImagen[aumentar].setBounds(0, 50, 300, 100);
        paneles[aumentar].add(contenedorImagen[aumentar]);
        for (int j = 0; j < 3; j++) {
            personajeJugador[aumentar][j] = new Personaje();
            personajeJugador[aumentar][j].setLocation(j * 100, 0);
            contenedorImagen[aumentar].add(personajeJugador[aumentar][j]);
        }
        aceptar[aumentar] = new JButton("Aceptar");
        aceptar[aumentar].setBounds(100, 150, 100, 50);
        aceptar[aumentar].addActionListener(this);
        aceptar[aumentar].setEnabled(false);
        paneles[aumentar].add(aceptar[aumentar]);
        aumentar++;
        i--;
        Paneles(i);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        String texto = me.toString();
        String direccion = Capturar(texto, 0);

        personajeJugador[jugadores][seleccion].setDireccion(direccion);
        personajeJugador[jugadores][seleccion].setIcon(personajeJugador[jugadores][seleccion].Imagen());
        //jlabel
        String carpeta = Capturar(texto, 1);
        if (carpeta.equals("src/Imagenes/Guerrero/")) {
            Bloquear(0, 10);
        }
        if (carpeta.equals("src/Imagenes/Mago/")) {
            Bloquear(1, 10);
        }
        if (carpeta.equals("src/Imagenes/Reina/")) {
            Bloquear(2, 10);
        }
        seleccion++;
        if (seleccion >= 3) {
            aceptar[jugadores].setEnabled(true);
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

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (jugadores == 0) {
            seleccion = 0;
            jugadores = 1;
            aumentar = 0;
            aceptar[0].setEnabled(false);
            aceptar[1].setEnabled(true);
            HabilitarTodo(30);
        }

    }

    public void HabilitarTodo(int i) {
        if (i == 0) {
            return;
        }
        personajes[aumentar].setEnabled(true);
        personajes[aumentar].addMouseListener(this);
        aumentar++;
        i--;
        HabilitarTodo(i);
    }

}
