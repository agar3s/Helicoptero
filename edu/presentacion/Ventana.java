/*
 * Creado el 20-mar-2004
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * @author Ekeisco
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Ventana extends JFrame {
	
	private Ciudad2 ciudad;
		public Ventana() {
			super("Ciudad");
			Container contentPane=getContentPane();
			ciudad=new Ciudad2();
			ciudad.setBackground(Color.BLACK);
			contentPane.add(ciudad);	
		}
	

		public static void main(String[] args) {
			Ventana ventana=new Ventana();
			ventana.setSize(750,550);
			ventana.setVisible(true);
			ventana.setResizable(false);
			ventana.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}	
				});
	
		}

}
