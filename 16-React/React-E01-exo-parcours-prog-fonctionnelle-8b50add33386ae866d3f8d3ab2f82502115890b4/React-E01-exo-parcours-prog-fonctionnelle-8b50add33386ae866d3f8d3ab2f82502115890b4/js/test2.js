/*
 * Exo2 : A ma guise
 *
 * Des datas sur les Simpsons nous proviennent d'un serveur, mais la structure
 * n'est pas top.
 *
 * Cela dit, vous n'avez pas trop envie d'aller voir le dev back pour qu'il
 * change les données — vraisemblablement, il n'a pas pris de douche depuis
 * longtemps, et de toute façon, il n'est pas connecté sur Slack.
 *
 * Coté JS, on préfererait avoir seulement une propriété `name` avec "Prénom Nom"
 * et une autre `young` qui contiendrait un booléen (true quand le personnage a
 * moins de 50 ans, sinon false). On souhaite que les infos inutiles ne soient
 * pas conservées.
 *
 * En gros, on souhaiterait passer d'un tableau à un autre tableau, en
 * transformant au passage les données, mais en conservant l'ordre des
 * personnages.
 *
 * Notions :
 * - JS : map (ES6)
 * - paradigmes : programmation fonctionnelle
 */
var datas = [
  {
    firstname: 'Marge',
    lastname: 'Simpson',
    gender: 'Women',
    age: 34,
  },
  {
    firstname: 'Ned',
    lastname: 'Flanders',
    age: 61,
  },
  {
    firstname: 'Charles Montgomery',
    lastname: 'Burns',
    age: 104,
  },
  {
    firstname: 'Waylon',
    lastname: 'Smithers',
    age: 36,
  },
  {
    firstname: "Alexis",
    lastname: "Masson",
    age: 28,
  },
];

var characters = [];
datas.forEach(element => {
  var rPersonne = {};
  rPersonne[0] = element.firstname + " " + element.lastname;
  rPersonne[1] = (element.age > 50 ? false : true);
  characters.push(rPersonne);

});
// var characters = datas.map(personne => {
//   var rPersonne = {};
//   rPersonne[0] = personne.firstname;
//   rPersonne[1] = personne.lastname;
//   rPersonne[2] = (personne.age > 50 ? true : false);
//   tablRetour.push(rPersonne);
// });
// datas.map( name => (firstname + ' ' + lastname));

characters.forEach(element => {
  console.log("Element (JSON) : " + JSON.stringify(element));
});

// function initComponent(datas) {
//   // const newList = ();

//   // characters = datas.map(/* ... */);
//   return characters;
// }



/////////////////////////////////////////////////////////

// var normalize = function (characters) {
//   return {
//     name: character.firstname + ' ' + character.lastname,
//     young: character.age < 50
//   };
// };

// var characters = datas.map(normalize);

//  autre solution
var autreSolution = datas.map((simpson) => ({
  name : simpson.firstname + " " + simpson.lastname,
  young : (simpson.age <50?true:false)
}));

characters = autreSolution;





/*
 * Tests
 */
var result = document.getElementById('test');
if (
  // On a désormais `name` et `young`
  characters[0].name === 'Marge Simpson'
  && characters[1].name === 'Ned Flanders'
  && characters[2].name === 'Charles Montgomery Burns'
  && characters[3].name === 'Waylon Smithers'
  && characters[0].young
  && !characters[1].young
  && !characters[2].young
  && characters[3].young


  // Les anciennes props ne doivent plus être définies
  && typeof characters[0].gender === 'undefined'
  && typeof characters[0].firstname === 'undefined'
  && typeof characters[0].lastname === 'undefined'
  && typeof characters[1].firstname === 'undefined'
  && typeof characters[1].lastname === 'undefined'
  && typeof characters[2].firstname === 'undefined'
  && typeof characters[2].lastname === 'undefined'
  && typeof characters[3].firstname === 'undefined'
  && typeof characters[3].lastname === 'undefined'
) {
  result.className = 'success';
  result.textContent = 'Yep !';
}
