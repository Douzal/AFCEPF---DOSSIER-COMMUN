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
import './HelloWorldStyle.css';

// 1) Créer une fonction helloWorld() qui renvoie la chaîne de caractère :
//      <div id="hello-world">
//        <h1>Ce HTML a été généré par JS</h1>
//        <h2>Et affiché avec innerHTML</h2>
//      </div>


const helloWorld = () => {
    let phrase = '<div id="hello-world">';
    phrase = phrase.concat('', '<h1>Ce HTML a été généré par JS</h1>');
    phrase = phrase.concat('', '<h2>Et affiché avec innerHTML</h2>');
    phrase = phrase.concat('', '</div>');
    return phrase;
}


console.log('phrase : ' + helloWorld());

/*  avec syntaxe JSX
import React from 'react';
Component Helloword() => {
    return (
        <div id="hello-world" className="HelloWorld">
            <h1>Ce HTML a été généré par JS</h1>
            <h2>Et affiché avec innerHTML</h2>
        </div >
    )
} */

//  export default Helloword;

/* 
2) Créer une fonction render() qui prend un argument une string HTML,
   et qui l'ajoute avec innerHTML à la div #root présent dans le document.
 */

const render = (str) => {
    const rootElement = document.querySelector("#root");
    rootElement.innerHTML = str;
};

/* 
3) Executer au chargement du DOM la fonction render()
   avec en argument la fonction helloWorld()
*/

render(helloWorld());

// le faut-il ?
export default { render };

/*
 * Code
 */


/*
 * Tests
 */
test();
