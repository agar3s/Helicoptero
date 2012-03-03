/*
 * Creado el 21-mar-2004
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion;

import java.awt.Color;

import java.awt.Graphics;

/**
 * @author Ekeisco
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Fondo implements IPintar {
	
		
	public void dibujar(Graphics g) {
		
		g.setColor(Color.ORANGE);
		g.fillRect(100,100,215,550);
		g.fillRect(450,50,30,550);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(400,150,130,450);
		
		g.setColor(Color.BLACK.brighter());
		
		for(int i=0;i<6;i++){
			for(int h=0;h<15;h++){
					g.fillRect(410+(i*20),160+(h*20),10,10);
			}
		}
		for(int i=0;i<7;i++){
		for(int h=0;h<9;h++){
				g.fillRect(110+(i*30),120+(h*40),15,20);
		}
		}
		
		
		//luna parrandera
		g.setColor(new Color((Integer.parseInt(Long.toString(Math.round(Math.random()*255)))),(Integer.parseInt(Long.toString(Math.round(Math.random()*255)))),(Integer.parseInt(Long.toString(Math.round(Math.random()*255))))));
		g.drawString("<A> On-Off;",20,30);
		g.drawString("Utilize las flechas de direccion para moverse;",20,43);
		g.fillOval(650,50,100,100);
		
		//la calle
		g.setColor(Color.GRAY);
		g.fillRect(0,500,750,50);
		
		//poste
		g.setColor(Color.DARK_GRAY);
		g.fillRect(490,400,10,100);
		g.fillArc(480,398,30,23,0,180);
		
		
	}
	/* (no Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	

}
