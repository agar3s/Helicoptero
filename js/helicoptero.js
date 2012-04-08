var helicoptero = function(){
    this.x=140;
    this.y=440;

    this.encendido=false;

    var velocity=10;
    var aterrizando=false;
    var phi=0;
    var k=-10;
    var w=26;
    var z=62;

    //x recibe un 1, -1 o 0, que significa adelante, atras o quieto
    this.moverX = function(x){
        if(!this.encendido&&!aterrizando)
            return 0;

        this.x+= x*velocity;
        if(this.x>745){
            this.x=-145;
        }
        if(this.x<-145){
            this.x=745;
        }
    };
    
    //y recibe un 1, -1 o 0, que significa abajo, arriba o quieto
    this.moverY = function(y){
        if(!this.encendido&&!aterrizando)
            return 0;

        this.y+= y*velocity;
        if(this.y>440){
            this.y=440;
        }
        if(this.y<10){
            this.y=10;
        }
    };

    this.encender = function(){
        this.encendido=!this.encendido;
    }

    this.animar = function(context){
        phi=phi+Math.PI/6;
        if(phi>=Math.PI*2){
            phi=0;
        }
        k=k+9;
        if(k>=99){
            k=-9;
        }
        w= w+9;
        if(w>=99){
            w=-9;
        }

        z= z+9;
        if(z>=99){
            z=-9;
        }
    }

    this.aterrizar = function(){
        if(this.y<440){
            this.moverY(1);
            aterrizando=true;

        }else{
            aterrizando=false;
        }
    }

    this.pintar = function(context){

        context.fillStyle="white";
        fillRect(this.x,this.y+25,32,4);
        fillRect(this.x+45,this.y+40,4,16);
        fillRect(this.x+79,this.y+40,4,16);
        fillRect(this.x+25,this.y+54,80,4);


        fillArc(this.x+65,this.y+25,35,20, 0, Math.PI*2);
        //helice

        fillCircle(this.x-10,this.y+25,15);
        context.fillStyle="black";

        fillArc(this.x-10,this.y+25,15,15,phi,phi+Math.PI/6);
        fillArc(this.x-10,this.y+25,15,15,phi+Math.PI*4/6,phi+Math.PI*5/6);
        fillArc(this.x-10,this.y+25,15,15,phi+Math.PI*8/6,phi+Math.PI*9/6);

        //cabina
        context.fillStyle="rgb(0,46,91)";
        fillArc(this.x+65,this.y+25,35,20,-Math.PI/2,0);
        //la helice
        fillRect(this.x+63,this.y-10,4,15);
        fillRect(this.x+20,this.y-10,90,4);
        context.fillStyle="white";
        fillRect(this.x+k+20,this.y-10,15,4);
        fillRect(this.x+w+20,this.y-10,15,4);
        fillRect(this.x+z+20,this.y-10,15,4);

        if(this.encendido || aterrizando){
            this.animar(context);
        }
    };
};