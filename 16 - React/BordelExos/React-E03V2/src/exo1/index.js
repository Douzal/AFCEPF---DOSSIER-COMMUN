/*
 * Exo 1 : Import/Export
 *
 * OK, on a découvert ES5 et un peu ES2015 la semaine dernière
 * Il est temps de s'y mettre vraiment, et de maîtriser les modules !
 *
 * 1) Créer un fichier src/exo1/hello.js
 *
 * 2) Dans ce fichier, définir 3 fonctions (coucou, salut et hello),
 *    qui renvoient une chaine de caractère ('coucou', 'salut' et 'hello')
 *
 * 3) Exporter ces 3 fonctions, en faisant deux export nommés
 *    et un export par défaut
 *
 * 4) Importer ces 3 fonctions dans ce module (src/exo1/index.js)
 */

/*
 * Import
 */

/* eslint-disable */
// import React from 'react';
// import 'test';
import test from './test';
// import './hello.js' // .js par défaut  // pourquoi ça ne marche pas ?

import coucou, { salut, hello } from './hello';



/*
 * Code
 */
console.log('fonction coucou importée ? : ' + coucou);
console.log(salut);
console.log(hello);

/*
 * Tests
 */
console.log('---début tests---');
test(coucou, salut, hello);
console.log('---fin tests---');
