var obj;
obj = {
	   prenom : "Jean",
	   nom : "Bon"
      };
console.log("type de obj=" + (typeof obj)); 

function addition(a,b){
	return a+b;
}

function multiplication(a,b){
	return a*b;
}
var res;
var operation;
operation = addition; //le contenu de la variable operation
                      //est une référence vers la fonction addition
console.log("type de operation=" + (typeof operation)); 
res=operation(12,3);
console.log("res="+res);

operation=multiplication;
res=operation(12,3);
console.log("res="+res);