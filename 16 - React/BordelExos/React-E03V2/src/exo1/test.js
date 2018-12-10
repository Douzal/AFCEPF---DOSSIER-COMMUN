/*
 * Import
 */
import test from '../test';
// import './hello';

/*
 * Export default
 */
/* eslint-disable */
export default (coucou, salut, hello) => {
  console.log('fonction coucou importée ? : ' + coucou);
  console.log(salut);
  console.log(hello);
  test((
    coucou() === 'coucou'
    && salut() === 'salut'
    && hello() === 'hello'
  ));
};
