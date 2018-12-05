/*
 * Exo3 : Chacun son tour
 *
 * L'intégrateur nous a préparé des boîtes dans le HTML.
 * Ils les a mis en display: none, pour qu'on les affiche nous, en JS.
 *
 * - On peut les récupérer avec la classe CSS `.box`.
 * - On doit les afficher, mais une à une, avec 1 seconde entre chaque. Parce que.
 *
 * Notions :
 * - DOM : document.querySelectorAll
 * - JS : for / forEach / setTimeout / IIFE (ES5)
 * - paradigme : programmation impérative & fonctionnelle
 */

/**
 * récupérer des .div => DOM / document.getElementsByClassName par exemple
 * afficher => display: block;
 * une à une => itération, forEach, setTimeout
 */

const boxes = document.querySelectorAll('.box');
// console.log(boxes);

/**
 * Version avec for
 */
// for (let i = 0; i < boxes.length; i++) {
//   console.log(i);
//   window.setTimeout(function() {
//     console.log(i, boxes[i]);
//     boxes[i].style.display = 'block';
//   }, 1000 * i);
// }

/**
 * Version avec forEach
 */
const display = (box, index) => {
  window.setTimeout(() => {
    box.style.display = 'block';
  }, 1000 * index);
};

boxes.forEach(display);
