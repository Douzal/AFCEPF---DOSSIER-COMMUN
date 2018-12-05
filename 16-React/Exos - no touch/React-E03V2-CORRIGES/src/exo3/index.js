/*
 * Exo 3 : Un peu plus de templating :)
 *
 * OK, on écrit du HTML. Maintenant, pourrait-on écrire du HTML
 * en fonction de datas passées en argument ?
 *
 * 1) Créer une fonction helloWorld() qui renvoie cette chaîne :
 *      <div id="hello-world">
 *        <h1>Ce HTML a été généré par *lang*</h1>
 *        <h2>Et affiché avec *method*</h2>
 *      </div>
 *
 *      *lang* et *method* étant les deux propriétés d'un objet passé en argument.
 *
 *    Par exemple : helloWorld({ lang: 'Titi', method: 'Gros minet'}) doit renvoyer :
 *      <div id="hello-world">
 *        <h1>Ce HTML a été généré par Titi</h1>
 *        <h2>Et affiché avec Gros minet</h2>
 *      </div>
 *
 * 2) Importer la fonction render() de l'exo2, sans avoir à la recoder ici.
 *
 * 3) Exécuter au chargement du DOM la fonction render()
 *    avec en argument helloWorld({ lang: 'ES2015', method: 'innerHTML' })
 */

/*
 * Import
 */
import test from './test';
import { render } from '../exo2/index.js';

/*
 * Code
 */
const helloWorld = (lang, method) => (
    `<div id="hello-world">
      <h1>Ce HTML à été généré par `+lang+`</h1>
      <h2>Et affiché avec `+method+`</h2>
    </div>`
  );



  render ( helloWorld ('ES2015', 'innerHTML'));


const App = () => (
    <helloWorld lang='ES2015' method= 'innerHTML' foo='bar' />
);


  const props = {
    lang: 'ES2015',
    method: 'innerHTML',
    foo: 'bar'
  };
  
  const helloWorld = ({ lang, method }) => (
    `<div id="hello-world">
      <h1>Ce HTML a été généré par ${lang}</h1>
      <h2>Et affiché avec ${method}</h2>
    </div>`
  );
  
  render(helloWorld(props));






/*
 * Tests
 */
test();


