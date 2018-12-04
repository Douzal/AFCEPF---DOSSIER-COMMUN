console.log("hello world");
var s1 = "12";
var s2 = "3"
var n1 = 12;

var n1bis = Number(s1);
var n2 = Number(s2);
console.log("s1 + s2 =" + (s1 + s2));
console.log("n1bis + n2 =" + (n1bis + n2));

var v ;
console.log("type de v =" + (typeof v));
v= "abc"; console.log("type de v =" + (typeof v));
v= 36;    console.log("type de v =" + (typeof v));
v= true;  console.log("type de v =" + (typeof v));

if(s1 == n1 ) 
	console.log("s1 et n1 ont memes valeurs");
 else
	 console.log("s1 et n1 ont valeurs differentes");
 
 if(s1 === n1 ) 
	console.log("s1 et n1 ont memes valeurs et memes types");
 else
	 console.log("s1 et n1 ont valeurs ou types differents");