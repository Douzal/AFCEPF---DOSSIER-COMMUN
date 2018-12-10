//quelques nouveautés de es2015 (let , of , ...)

var tabSaisons = [ "hiver" , "printemps" , "ete" , "automne" ];

//for(...of ...) ayant le sens "forEach":
for(let saison of tabSaisons){
	console.log (saison);
}

function callBack1(){
	console.log("coucou apres 2000 ms");
}
// setTimeout exite depuis très longtemps en javascript
setTimeout(callBack1,2000); 

setTimeout(function () { 
               console.log("coucou dans fonction callback anonyme imbriquée");
            } ,2000); 

//callback sous forme de lambda expression 
//(alias arrow function) depuis es6/es2015
setTimeout( ()=>{ console.log("coucou lambda apres 4000 ms"); } , 4000);

