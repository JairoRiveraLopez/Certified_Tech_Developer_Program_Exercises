const {generateText, createElement, validateInput} = require('../util.js');

describe( "Validacion funciones util.js", () => {
    test('TestGenerateText', () => {
        const generacionTexto = generateText("Jairo Rivera", 24);
        expect(generacionTexto).toBe("Jairo Rivera (24 years old)")
    })

    test('CreateElement', () => {
        let divPrueba = document.createElement("div")
        const elemento = createElement('li','Jairo Rivera (24 years old)',"user-item");
        divPrueba.appendChild(elemento);
        let resultadoPrueba = divPrueba.outerHTML;
        expect(resultadoPrueba).toBe("<div><li class=\"user-item\">Jairo Rivera (24 years old)</li></div>")
    })

    test('validateInput Texto', () => {
        const input = validateInput("Jairo Rivera");
        expect (input).toBeTruthy();
    })

    test('validateInput Vacio', () => {
        const input = validateInput((null && 0));
        expect (input).toBeFalsy();
    })

    test('validateInput Numero', () => {
        const input = validateInput("",null, "Hola");
        expect (input).toBeFalsy();
    })
    
    })
