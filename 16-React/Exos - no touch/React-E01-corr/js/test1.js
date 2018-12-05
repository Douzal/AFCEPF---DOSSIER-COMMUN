/*
 * Exo1 : For Hitch
 *
 * Hitch a besoin de ses outils pour séduire, même en HTML.
 * Il vous donne un array et il aimerait qu'avec cela, vous construisiez une
 * liste de <li>, puis que vous l'ajoutiez dans #result.
 *
 * Notions :
 * - DOM : document.getElementById / document.createElement / appendChild
 * - JS : forEach (ES5)
 * - paradigmes : programmation impérative & fonctionnelle
 */

const items = ['Sunglasses', 'Suit', 'Business card', 'Jet ski'];
// items est constant, mais pas son contenu interne :
// items.pop();
// items[1] = 'TADA';

/**
 * Crée un li avec du texte reçu en paramètre, et l'affiche dans la page
 * à un endroit précis.
 */

// On trouve le point d'injection dans le HTML actuel.
const result = document.getElementById('result');

// Fonction utilitaire pour une itération : créer & afficher un li avec du texte.
const display = (text) => {
  const li = document.createElement('li');
  li.textContent = text;
  result.appendChild(li);
};

// On branche tout : itération => affichage des <li>
items.forEach(display);


// Démarche générale :
// // 1. créer un élement virtuel
// document.createElement('li'); // {cle: valeur, ...}
// // 2. injecter / insérer l'élément virtuel dans le DOM
// document.appendChild(…);


// Version de Christophe :
// // Définition de la fonction de callback pour son utilisation avec le forEach
// var callback = function(valeurCourante, index, array) {
//   // Création d'un élément li
//   var list = document.createElement('li');
//   // Ajout du texte pour le li
//   list.textContent = array[index];
//   // Ajout de l'élément list à notre ul
//   ul.appendChild(list);
// };

// Version de Gregory :
// const render = '';
// items.forEach(item => { render += `<li>${item}</li>`; });
// document.getElementById('result').insertAdjacentHTML('afterbegin', render);

// Version de Luna :
// var callback = function (element) {
//   var liContent = document.createTextNode(element);
//   var li = document.createElement('li');
//   li.appendChild(liContent);
//   document.getElementById("result").appendChild(li);
// };
