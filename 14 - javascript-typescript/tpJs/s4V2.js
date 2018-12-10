//approche objet basic (es5) de javascript

//fonction constructeur de Personne à nombre d'arguments variable
function Personne(){
	var args=Personne.arguments;
	//propriétés:
	this.prenom = (args.length>=1)?args[0]:null;
	this.nom=(args.length>=2)?args[1]:null;
	this.age=(args.length>=3)?args[2]:null;
	//méthodes:
	this.aff = function (){
		console.log("prenom=" + this.prenom + " nom=" + this.nom + " age="+ 
		             this.age);
		}
}

var p1 = new Personne("jean" , "Bon" , 30); p1.aff();
var p2 = new Personne("prenomXy", "Dupond"); p2.aff();
var p3 = new Personne(); p3.aff();

p1.prenom="alex";  p1.nom = "Therieur";  p1.aff();
p1.couleur ="rouge" ; console.log("couleur de p1=" + p1.couleur);

p1["prenom"] = "alain";     p1.aff();
