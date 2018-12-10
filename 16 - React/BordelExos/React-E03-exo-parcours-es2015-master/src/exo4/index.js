/*
 * Exo 4 : React !
 *
 * OK, on gère. Maintenant, faisons-le avec React :D !!!
 *
 * 1) Installer les packages react et react-dom
 *
 * 2) Créer un composant <HelloWorld />, en créant une fonction HelloWorld()
 *    qui renvoie le JSX suivant :
 *      <div id="hello-world">
 *        <h1>Ce HTML a été généré par React</h1>
 *        <h2>Et affiché avec ReactDOM</h2>
 *      </div>
 *
 * 3) Importer la fonction render du module 'react-dom'
 *
 * 4) Exécuter au chargement du DOM la fonction render()
 *    pour afficher <HelloWorld /> dans la div #root
 */

/*
 * Npm import
 */

/*
 * Local import
 */
import React from 'react';
import { render } from 'react-dom';

/* equivalent à : import ReactDOM from 'react-dom'; */

import test from './test';


/*
 * Code
 */

/**
 * Composant React / UI.
 * Génère du contenu à afficher ensuite dans la page HTML.
 * @see https://reactjs.org/docs/react-without-jsx.html
 */
const HelloWorld = () => (
  <div id="hello-world">
    <h1>Ce HTML a été généré par React</h1>
    <h2>Et affiché avec ReactDOM</h2>
  </div> // <-- version JSX
  // React.createElement('div', {id: 'hello-world'}, [
  //   React.createElement(…),
  //   React.createElement(…)
  // ]); // <-- version sans JSX
);

console.log(HelloWorld());

render(
  HelloWorld(), // objet React source
  document.getElementById('root') // point d'injection dans la page HTML
);













// const toRender = <HelloWorld />; //ce n'est pas du html - +1
// render(toRender, document.getElementById('root'));
// ReactDOM.render(<HelloWorld />, document.getElementById('root'));


/*
 * Tests
 */
test();
