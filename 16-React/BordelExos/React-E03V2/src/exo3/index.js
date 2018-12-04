/*
 * Exo 3 : Un peu plus de templating :)
 *
 * OK, on écrit du HTML. Maintenant, pourrait-on écrire du HTML
 * en fonction de datas passées en argument ?
 */


import test from './test';
/*
* 2) Importer la fonction render() de l'exo2, sans avoir à la recoder ici.
*/
import { render } from '../exo2/index'; // par defaut, .js, normalement no need de remettre
// import '../exo2/HelloWorldStyle.css'; // ne semble pas marcher, mais pas sur que la classe soit gérer encore

/* 1) Créer une fonction helloWorld() qui renvoie cette chaîne :
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
*/

// rien compris
App = () => {
    <helloWorld lang='ES2015' method='innerHTML' foo='couilles' />
}

const propertiesSoitDisant = {
    lang: 'ES2015',
    method: '',
    foo: 'couilles',
};


const helloWorld = ({ lang, method, foo }) => {
    (
        `<div id="hello-world" className="HelloWorld">
        <h1>Ce HTML a été généré par ${objetPerso.langlang}</h1>
        <h2>Et affiché avec ${objetPerso.method}</h2>
        </div >`)
};

/* 3) Exécuter au chargement du DOM la fonction render()
*    avec en argument helloWorld({ lang: 'ES2015', method: 'innerHTML' })
*/
// render("couille");
render(helloWorld(propertiesSoitDisant));
// render("couille");

/*
 * Import
 */

test();
