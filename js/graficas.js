    var context=null;

    var iniciarGraficas=function(context){
        this.context = context;
    }

    //linea al estilo awt
    var drawLine=function(iniX, iniY, finX, finY){
        context.beginPath();
        context.moveTo(iniX,iniY);
        context.lineTo(finX,finY);
        context.stroke();
    };
    var drawArc= function(centerX, centerY, radius, startingAngle, endingAngle, counterclockwise){
        context.beginPath();
        context.arc(centerX, centerY, radius, startingAngle, endingAngle, counterclockwise);
        context.stroke();
    };

    var drawRect = function(iniX, iniY, width, height){
        context.beginPath();
        context.rect(iniX, iniY, width, height);
        context.stroke();
    };


    var fillRect= function(iniX, iniY, width, height){
        context.beginPath();
        context.rect(iniX, iniY, width, height);
        context.fill();
        context.stroke();
    };

    var drawCircle = function(centerX, centerY, radius){
        drawArc(centerX, centerY, radius, 0, Math.PI*2,false);
    };


    var fillCircle= function(centerX, centerY, radius){
        context.beginPath();
        context.arc(centerX, centerY, radius, 0, Math.PI*2, false);
        context.fill();
        context.stroke();
    };
    //fill arc con comportamiento estilo java
    var fillArc = function(centerX, centerY, radiusX, radiusY, startingAngle, endingAngle){
        context.save();
        context.beginPath();
        if(radiusX>radiusY){
            context.scale(1, radiusY/radiusX);
            context.arc(centerX, (centerY*radiusX)/radiusY, radiusX, startingAngle, endingAngle, false);
            context.lineTo(centerX,(centerY*radiusX)/radiusY);
        }else{
            context.scale(radiusX/radiusY, 1);
            context.arc((centerX*radiusY)/radiusX, centerY, radiusY, startingAngle, endingAngle, false);
            context.lineTo((centerX*radiusY)/radiusX, centerY);
        }
        context.closePath();
        context.fill();
        context.stroke();
        context.restore();
    }