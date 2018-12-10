/*
 * Exo4 : Un peu d'épices…
 *
 * On s'aperçoit qu'on fait pas mal d'additions et de multiplications dans un
 * bout de code…
 *
 * Comme on est fainéant, on veut se créer des fonctions pour créer
 * des calculettes pré-branchées :) On appelle ça faire du "currying". What?
 *
 * Créez les fonctions createSum et createMulti, qui permettent de créer
 * des fonctions qui additionnent ou qui multiplient de la manière suivante :
 *
 *    var addTwo = createSum(2);
 *    addTwo(14); // => renvoie 16
 *    addTwo(42); // => renvoie 44
 *    var addFour = createSum(4);
 *    addFour(4); // 8
 *
 *    var double = createMulti(2);
 *    double(14); // => renvoie 28
 *    double(42); // => renvoie 84
 *
 * Notions :
 * - JS : portée de variable / closure / currying (ES5)
 * - paradigme : programmation fonctionnelle
 *
 * **Attention, exercice difficile !**
 */
// zone des curseurs >>>   <<<<<



/*Currying :
 *le currying est le processus consistant à décomposer une fonction en une série de fonctions qui prennent chacune un seul argument .
f(n, m) --> f(g(m))  */

function createSum(x) {
  return function (y) {
    return x + y;
  };
}


// function createMulti(x) {
//   return function (y) {
//     return x * y;
//   };
// }
// équivalent à :
// const createMulti = (x) => { return (y) => { return x * y; } }
// équivalent à :
// const creatMulti = ( (x) => (y) => (x*y) );
// équivalent à :
const creatMulti = x => y => x*y;









/*
 * Tests
 */
var result = document.getElementById('test');
var addTen = createSum(10);
var double = createMulti(2);
var triple = createMulti(3);
if (
  addTen
  && double
  && triple
  && double(3) === 6
  && triple(20) === 60
  && triple(50) === double(75)
  && addTen(-110) === -100
  && addTen(1) === 11
  && createSum('coucou')('js') === 'coucoujs'
) {
  result.className = 'success';
  result.textContent = 'Yep !';
}
