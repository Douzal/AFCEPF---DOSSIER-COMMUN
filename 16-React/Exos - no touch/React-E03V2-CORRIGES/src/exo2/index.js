/* eslint-disable import/prefer-default-export */
/*
 * Exo 2 : Un peu de templating
 *
 * Yeah, ça importe ! C'est pas beau ça ?
 * Personnellement, je trouve ça ouf, mais pensez ce que vous voulez :)
 *
 * Bref, maintenant qu'on sait compartimenter notre code, il est temps
 * de se mettre à construire des vues avec JS, n'est-ce pas ?
 *
 * Pour l'instant, on va faire ça en vanilla JS !
 *
 * 1) Créer une fonction helloWorld() qui renvoie la chaîne de caractère :
 *      <div id="hello-world">
 *        <h1>Ce HTML a été généré par JS</h1>
 *        <h2>Et affiché avec innerHTML</h2>
 *      </div>
 *
 * 2) Créer une fonction render() qui prend un argument une string HTML,
 *    et qui l'ajoute avec innerHTML à la div #root présent dans le document.
 *
 * 3) Executer au chargement du DOM la fonction render()
 *    avec en argument la fonction helloWorld()
 *
 * 4) Rajouter un fichier .css pour venir centrer le texte de #hello-world
 */

/*
 * Import
 */
import test from './test';
// import './HelloWorldStyle.css';

/* 1 */
// const helloWorld = () => {
//     let phrase = '<div id="hello-world">';
//     phrase = phrase.concat('', '<h1>Ce HTML a été généré par JS</h1>');
//     phrase = phrase.concat('', '<h2>Et affiché avec innerHTML</h2>');
//     phrase = phrase.concat('', '</div>');
//     return phrase;
// }
// /* en plus compliqué */
// const helloWorld = () => {
// // function helloWorld() {
//     const biggerDiv = document.createElement('div');
//     const div = document.createElement('div');
//     div.setAttribute('id', 'hello-world');
//     const h1 = document.createElement('h1');
//     h1.innerHTML = 'Ce HTML a été généré par JS';
//     const h2 = document.createElement('h2');
//     h2.innerHTML = 'Et affiché avec innerHTML';
//     div.appendChild(h1);
//     div.appendChild(h2);
//     biggerDiv.appendChild(div);
//     return biggerDiv.innerHTML;
//   }

//   /* Solution 3 */
//   const helloWorld = () => {
//       return '<div id="hello-world">'
//             +   '<h1>Ce HTML a ${} été généré par JS</h1>'
//             +   '<h2>Et affiché avec innerHTML</h2>'
//             + '</div>';
//   }

//   export default function render(html) {
//     var elem = document.getElementById('root');
//     elem.innerHTML = html;
//   }

//   document.onreadystatechange = function () {
//       render ( helloWorld() );
//   }

//   /* autre façon */
//   window.addEventListener('load', render(helloWorld()));

  /* fin solution 3*/

   /* Correction prof*/
  const helloWorld = () => (
    `<div id="hello-world">
      <h1>Ce HTML à été généré par JS</h1>
      <h2>Et affiché avec innerHTML</h2>
    </div>`
  );
  const render = (content) => {
    const myroot = document.getElementById('root');
    myroot.innerHTML = content;
  };
  render(helloWorld());

  // + CSS
//   #hello-world {
//     text-align: center;
// }
 // + CSS
   /* Correction prof*/
        
console.log('Vérifier phrase : ' + helloWorld());

/* 2 */
// const render = (str) => {
//     const rootElement = document.querySelector("#root");
//     rootElement.innerHTML = str;
// };

/*
 * Tests
 */
test();
