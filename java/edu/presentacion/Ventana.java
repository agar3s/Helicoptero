/*
 * Creado el 20-mar-2004
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.presentacion;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JApplet;

/**
 * @author Ekeisco
 * 
 *         Para cambiar la plantilla para este comentario de tipo generado vaya
 *         a Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y
 *         comentarios
 */
public class Ventana extends JApplet {

	private Ciudad ciudad;

	public void init() {
		Container contentPane = getContentPane();
		ciudad = new Ciudad();
		ciudad.setBackground(Color.BLACK);
		contentPane.add(ciudad);
	}
}
