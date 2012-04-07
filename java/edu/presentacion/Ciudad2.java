/*
 * Creado el 19-mar-2004
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.JPanel;




import edu.Logica.Helicoptero;

/**
 * @author Ekeisco
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Ciudad2 extends JPanel  implements KeyListener {
	
	

	private Helicoptero helicoptero;
	private int x, y; 
	private Vector papeles;
	private boolean encendido,votar;
	private Fondo fondo;
	
	
	public Ciudad2(){
		

		this.encendido=false;
		helicoptero= new Helicoptero(this);
		fondo= new Fondo();
		this.setLayout(null);
	}
	
	public void setX(int x){
		this.x=x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
			this.y=y;
		}
	public int getY(){
			return y;
	}
	public void encender(){
		encendido=true;
	}
	public void apagar(){
		encendido=false;
	}
	public boolean isEncendido(){
	
		return encendido;
	}

	public void setVotar(boolean vot){
		this.votar=vot;
	}
	
	
	public void keyTyped(KeyEvent ke) {
		
	}

	
	public void keyPressed(KeyEvent ke) {
		int key= ke.getKeyCode();
		switch(key){
			case KeyEvent.VK_LEFT:
				this.setX(1);
			break;
			case KeyEvent.VK_RIGHT:
				this.setX(2);
			break;
			case KeyEvent.VK_UP:
				this.setY(1);
			break;
			case KeyEvent.VK_DOWN:
				this.setY(2);
			break;
			case KeyEvent.VK_A:
				if(this.isEncendido())
					this.apagar();
				else
					this.encender();
			break;				
		}
		this.repaint();
	}
	public void keyReleased(KeyEvent ke) {
		int key= ke.getKeyCode();
		if(key==39||key==37)
		this.setX(0);
		if(key==38||key==40)
		this.setY(0);
		if(key==86)
		this.setVotar(false);
		
	}
	
	
	protected void paintComponent(Graphics g) {
		addKeyListener(this);
		requestFocus();
		super.paintComponent(g);
		fondo.dibujar(g);
		
		helicoptero.dibujar(g);
		helicoptero.panelEstado(g);
		if(this.isEncendido())
			helicoptero.on(g);
		else
			helicoptero.off(g);

		
		
	
		
	}

		

}
