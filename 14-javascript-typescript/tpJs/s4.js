//approche objet basic (es5) de javascript

//fonction constructeur de Personne
function Personne(prenom, nom , age){
	//propriétés:
	this.prenom = prenom;
	this.nom=nom;
	this.age=age;
	//méthodes:
	this.aff = function (){
		console.log("prenom=" + this.prenom + " nom=" + this.nom + " age="+ 
		             this.age);
		}
}

var p1 = new Personne("jean" , "Bon" , 30);
p1.aff();

p1.prenom="alex";  p1.nom = "Therieur";  p1.aff();
p1.couleur ="rouge" ; console.log("couleur de p1=" + p1.couleur);

p1["prenom"] = "alain";     p1.aff();
