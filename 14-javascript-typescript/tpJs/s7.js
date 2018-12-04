//approche objet en es2015 (class , constructor , extends , ...)
class Figure {
	constructor(couleur = "black"){
		this.couleur = couleur;
	}
}

class Cercle extends Figure {
	constructor(xc=0,yc=0,rayon=0 , couleur = "black"){
		super(couleur);
		this.xc= xc; this.yc= yc; this.rayon = rayon;
	}

    perimetre(){
       return 2 * Math.PI * this.rayon ;
	}	
}

var c1 = new Cercle(); //new Cercle(0,0,0);
var c2 = new Cercle(150,150,60,"red");
console.log("c1="+JSON.stringify(c1));
console.log("c2="+JSON.stringify(c2));
c1.xc= 10 ; c1.yc= 20; c1.rayon = 30;
console.log("c1="+JSON.stringify(c1));
console.log("perimetre de c1=" + c1.perimetre());
