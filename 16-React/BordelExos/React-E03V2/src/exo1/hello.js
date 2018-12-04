/*
 * 2) Dans ce fichier, définir 3 fonctions (coucou, salut et hello),
 *    qui renvoient une chaine de caractère ('coucou', 'salut' et 'hello')
 *
 * 3) Exporter ces 3 fonctions, en faisant deux export nommés
 *    et un export par défaut
 *
 * 4) Importer ces 3 fonctions dans ce module (src/exo1/index.js)
 */
/* eslint-disable */
//  coucou = () => {
//      'coucou';
//  }

const salut = () => 'salut';

 const hello = () => {
    'hello';
 }
// export default () => 'coucou';
// export const salut = () => 'salut';
// export const hello = () => 'hello';

export default () => 'coucou';

export {salut, hello};






//  export default () => 'coucou';
// export const salut = () => 'salut';
// export const hello = () => 'hello';
// export const sum = (a, b) => a + b;
// export const name = 'JD';