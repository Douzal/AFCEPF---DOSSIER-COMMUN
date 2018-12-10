//manipulation  de tableaux en javascript

function affTab(tableau){
	console.log("--------------------");
	for(i=0;i<tableau.length;i++){
		console.log(tableau[i]);
	}
}

function affTabViaIn(tableau){
	console.log("--------------------");
	for(indice in tableau){
		console.log(tableau[indice]);
	}
}

function removeInTabAtPosition(tab, position){
	tab.splice(position, 1) ;	
}

var tableauBizarre = new Array("abc" , 12 , "xyz" , true );
affTab(tableauBizarre);
tableauBizarre[9]="valeur en position 9+1";
affTab(tableauBizarre);
//affTabViaIn(tableauBizarre);

//var tab = []; //tableau vide
var tab =  new Array(); //tableau vide
tab.push("Paris");   tab.push("Rouen");
tab.push("Amiens");  tab.push("Tours"); tab.push("Bordeaux");
affTabViaIn(tab); //affichage avant tri
//delete tab[2]; //supprime l'élement en position 2(+1)
               //la valeur de tab[2] devient "undefined"  
removeInTabAtPosition(tab,2);			   
affTabViaIn(tab); //affichage apres  delete tab[2] ou splice(i,1)
			   
tab.sort();
affTab(tab); //affichage apres tri
console.log("type de tab=" + (typeof tab));

var tableauAclefs = []; //equivalent d'une "map" de java
tableauAclefs['janvier']=1234;
tableauAclefs['fevrier']=2566;
affTabViaIn(tableauAclefs);
affTab(tableauAclefs);//affiche rien , car rien en [0] , [1]









