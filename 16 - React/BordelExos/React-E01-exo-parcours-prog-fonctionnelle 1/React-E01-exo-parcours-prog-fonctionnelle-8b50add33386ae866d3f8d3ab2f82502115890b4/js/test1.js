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


function creation() {
    var items = ['Sunglasses', 'Suit', 'Business card', 'Jet ski'];
    // var result = document.getElementById("result");
    var result = document.querySelector("#result");
    // for (let element of items) {
    //     var el = document.createElement("li");
    //     el.append(element);
    //     result.appendChild(el);
    // }

    items.forEach(element => {
        var v = document.createElement("li");
        v.textContent = element;
        result.appendChild(v);
    });
}
