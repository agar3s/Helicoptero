var ciudad = function(){
    this.pintarFondo = function(context){

        context.fillStyle="BLACK";
        fillRect(0,0,750,550);
        context.fillStyle="ORANGE";
        fillRect(100,100,215,550);
        fillRect(450,50,30,550);
        context.fillStyle="#ccc";
        fillRect(400,150,130,450);

        context.fillStyle="BLACK";

        for(var i=0;i<6;i++){
            for(var j=0;j<15;j++){
                fillRect(410+(i*20),160+(j*20),10,10);
            }
        }
        for(var i=0;i<7;i++){
            for(var j=0;j<9;j++){
                fillRect(110+(i*30),120+(j*40),15,20);
            }
        }

        //la calle
        context.fillStyle="GRAY";
        fillRect(0,500,750,50);

        //poste
        context.fillStyle="GRAY";
        fillRect(490,400,10,100);
        fillArc(495,412,15,15,Math.PI,0);

        //panel estado
        context.fillStyle="#ccc";
        fillRect(615,445,110,60);
        context.fillStyle="#000";
        fillRect(620,450,100,50);
    };

    this.lunaParrandera = function(context){

        context.fillStyle="rgb("+Math.floor(Math.random()*255)+
                               ","+Math.floor(Math.random()*255)+
                               ","+Math.floor(Math.random()*255)+")";
        fillCircle(650,50,50);

          
        context.fillText("<A> On-Off;",20,30);
        context.fillText("Utilize las flechas de direccion para moverse;",20,43);
        context.stroke();
    };

    //grafica de on;

    this.on = function(context){

        context.fillStyle="#0c0";
        fillRect(660,460,20,4);
        fillRect(660,460,4,30);
        fillRect(676,460,4,30);
        fillRect(660,486,20,4);
        fillRect(690,460,20,4);
        fillRect(690,460,4,30);
        fillRect(706,460,4,30);
    }

    //grafica de off;
    this.off = function(context){

        context.fillStyle="#c00";
        //la o
        fillRect(630,460,20,4);
        fillRect(630,460,4,30);
        fillRect(646,460,4,30);
        fillRect(630,486,20,4);

        //f
        fillRect(660,460,20,4);
        fillRect(660,460,4,30);
        fillRect(660,473,20,4);

        fillRect(690,460,20,4);
        fillRect(690,460,4,30);
        fillRect(690,473,20,4);

    }
}