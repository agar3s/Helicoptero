/*
 * Creado el 19-mar-2004
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.Logica;

import java.awt.Color;
import java.awt.Graphics;

import edu.presentacion.Ciudad2;
import edu.presentacion.IPintar;

/**
 * @author Ekeisco
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Helicoptero implements Runnable,IPintar {

	private int x;
	private int y;
	//grados de helice
	private int h;
	
	//para el movimiento de la helice
	private int k;
	private int w;
	private int z;
	
	private boolean encendido;
	private Thread grafica=null;
	private Ciudad2 ciudad;


	public Helicoptero(Ciudad2 ciudad){
		x=140;
		y=440;
		k=-10;
		w=26;
		z=62;
		this.encendido=false;
		this.ciudad= ciudad;
		grafica = new Thread(this,"Helicoptero");
		grafica.start();
					
	}

	/* (no Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while(true){
			
			if(ciudad.isEncendido()){
				if(this.encendido){
				moverX(ciudad.getX());
				moverY(ciudad.getY());
				girar();
				girarHelice();
				}
				else{
					setEncendido(true);
				}
			}
			if(!ciudad.isEncendido()){
				if(this.isEncendido()){
					if(this.getY()<440){
						aterrizar(getY());
						girar();
						girarHelice();
					}
					setEncendido(false);
				}
				else
					setEncendido(true);
			}
			try{
				Thread.sleep(50);
			}catch (InterruptedException e){}
			ciudad.repaint();
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getH(){
		return h;
	}
	
	public boolean isEncendido(){
		return encendido;

	}

	public void moverX(int mX) {
		if(mX==1)
		x=x-10;
		if(mX==2)
		x=x+10;
		
		if(x>745){
			x=-145;
		}
		if(x<-145){
			x=745;
		}
		
	}

	public void moverY(int mY) {
		if(mY==1)
			y=y-10;
		if(mY==2)
			y=y+10;
		
		if(y>440){
			y=440;
		}
		if(y<10){
			y=10;
		}
		
	}

	public void setEncendido(boolean enc) {
		this.encendido=enc;
	}

	
	public void aterrizar(int a){
		if(a<440)
			y=y+10;
	}
	public void girar(){
		h=h+30;
	}
	public void girarHelice(){
		
		k=k+9;
		if(k>=99)
		k=-9;
		
		w= w+9;
		if(w>=99)
		w=-9;
		
		z= z+9;
		if(z>=99)
		z=-9;
	}

	public void lanzarPapeletas() {
	}

	/* (no Javadoc)
	 * @see edu.presentacion.IPintar#dibujar(java.awt.Graphics)
	 */
	public void dibujar(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(x,y+25,32,4);
		//vamos bien ahora los aterrizadores
		g.fillRect(x+45,y+40,4,16);
		g.fillRect(x+79,y+40,4,16);
		g.fillRect(x+25,y+54,80,4);
	
	
		g.fillOval(x+30,y+5,70,40);
		//helice
		g.setColor(Color.WHITE);
		g.fillOval(x-15,y+10,30,30);
		g.setColor(Color.BLACK);
		g.fillArc(x-15,y+10,30,30,h,30);
		g.fillArc(x-15,y+10,30,30,h+120,30);
		g.fillArc(x-15,y+10,30,30,h+240,30);
		
		//cabina
		g.setColor(new Color(0,46,91).brighter());
		g.fillArc(x+30,y+5,70,40,0,90);
		//la helice
		g.fillRect(x+63,y-10,4,15);
		g.fillRect(x+20,y-10,90,4);
		g.setColor(Color.WHITE);
		g.fillRect(x+k+20,y-10,15,4);
		g.fillRect(x+w+20,y-10,15,4);
		g.fillRect(x+z+20,y-10,15,4);
	}
	
	public void panelEstado(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(615,445,110,60);
		g.setColor(Color.BLACK);
		g.fillRect(620,450,100,50);
		
		
	}
	
	//grafica de on;
	
	public void on(Graphics g){
		
		g.setColor(Color.GREEN.brighter());
		g.fillRect(660,460,20,4);	
		g.fillRect(660,460,4,30);
		g.fillRect(676,460,4,30);
		g.fillRect(660,486,20,4);
		g.fillRect(690,460,20,4);
		g.fillRect(690,460,4,30);
		g.fillRect(706,460,4,30);
		g.setColor(Color.BLACK);
		//bordes o
		g.drawLine(660,475,664,471);
		g.drawLine(660,475,664,479);
		g.drawLine(676,471,680,475);
		g.drawLine(676,479,680,475);
		
		//bordes n
		g.drawLine(690,475,694,471);
		g.drawLine(690,475,694,479);
		g.drawLine(706,471,710,475);
		g.drawLine(706,479,710,475);
		
		g.drawLine(660,460,664,464);
		g.drawLine(676,464,680,460);	
		g.drawLine(690,460,694,464);
		g.drawLine(706,464,710,460);
		g.drawLine(660,490,664,486);
		g.drawLine(676,486,680,490);
		//esquinas de la n del on;
		for(int i=690;i<=694;i++){
			for(int j=486;j<=490;j++){
				g.drawLine(i,490,694,j);
			}
		}
		for(int i=706;i<=710;i++){
			for(int j=486;j<=490;j++){
				g.drawLine(706,j,i,490);
			}
		}
		
	}
	
	//frafica de off;
	public void off(Graphics g){
		
		g.setColor(Color.RED.brighter());
		//la o
		g.fillRect(630,460,20,4);	
		g.fillRect(630,460,4,30);
		g.fillRect(646,460,4,30);
		g.fillRect(630,486,20,4);
		g.setColor(Color.BLACK);
		g.drawLine(630,460,634,464);
		g.drawLine(646,464,650,460);	
		g.drawLine(630,490,634,486);
		g.drawLine(646,486,650,490);
		
		g.drawLine(630,475,634,471);
		g.drawLine(630,475,634,479);
		g.drawLine(646,471,650,475);
		g.drawLine(646,479,650,475);
		
		//la f
		g.setColor(Color.RED.brighter());
		g.fillRect(660,460,20,4);	
		g.fillRect(660,460,4,30);
		g.fillRect(660,473,20,4);
				
		g.fillRect(690,460,20,4);
		g.fillRect(690,460,4,30);
		g.fillRect(690,473,20,4);
		
		g.setColor(Color.BLACK);
		
		g.drawLine(660,460,664,464);
		g.drawLine(690,460,694,464);
				
		g.drawLine(660,475,664,471);
		g.drawLine(660,475,664,479);
		g.drawLine(676,471,680,475);
		g.drawLine(676,479,680,475);
		
		g.drawLine(690,475,694,471);
		g.drawLine(690,475,694,479);
		g.drawLine(706,471,710,475);
		g.drawLine(706,479,710,475);
		
		
		
		for(int i=660;i<=664;i++){
			for(int j=486;j<=490;j++){
				g.drawLine(i,490,664,j);
			}
		}
		for(int i=676;i<=680;i++){
			for(int j=473;j<=477;j++){
				g.drawLine(i,477,680,j);
			}
		}
		for(int i=676;i<=680;i++){
			for(int j=460;j<=464;j++){
				g.drawLine(i,464,680,j);
			}
		}
		for(int i=690;i<=694;i++){
			for(int j=486;j<=490;j++){
				g.drawLine(i,490,694,j);
			}
		}
		for(int i=706;i<=710;i++){
			for(int j=473;j<=477;j++){
				g.drawLine(i,477,710,j);
			}
		}
		for(int i=706;i<=710;i++){
			for(int j=460;j<=464;j++){
				g.drawLine(i,464,710,j);
			}
		}
		
	}
	
	
	

}
