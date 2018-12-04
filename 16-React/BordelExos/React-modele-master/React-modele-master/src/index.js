import '@babel/polyfill';
import React from 'react';
import { render } from 'react-dom';
import App from './components/App';


const rootComponent = (
 <App />
);
render(rootComponent, document.getElementById('root'));
