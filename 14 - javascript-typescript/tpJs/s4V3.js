//approche objet basic (es5) de javascript

//expression litérale javascript d'un objet (très proche syntaxe JSON):
var p1 = {
		prenom : null,
		nom : null,
		age : null
};

p1.aff = function(){
	console.log(JSON.stringify(this));
}

p1.prenom="jean";
//p1.nom="Bon";
p1["nom"]="Bon";
p1.age=30;
p1.aff();