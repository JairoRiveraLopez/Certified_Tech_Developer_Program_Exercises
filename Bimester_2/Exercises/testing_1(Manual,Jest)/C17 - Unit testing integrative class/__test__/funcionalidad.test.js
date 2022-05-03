
const fs = require('fs');

document.body.innerHTML = fs.readFileSync("./calculadora.html")
const { init, limpiar, resetear, resolver, setVars} = require('../funcionalidad');

/* -------------------------------------------------------------------------- */
/*                      PRUEBAS UNIT TEST FUNCION INIT                   */
/* -------------------------------------------------------------------------- */

describe('Funcion Init',()=>{
    test('Init',()=>{
        init();
    })

    test('uno', () => {
        limpiar();
        init();
        uno.onclick() ;
        expect( resultado.textContent).toBe("1");
    })

    test('dos', () => {
        limpiar();
        init();
        dos.onclick();
        expect(resultado.textContent).toBe("2");
    })

    test('tres', () => {
        limpiar();
        init();
        tres.onclick();
        expect(resultado.textContent).toBe("3");
    })
    
    test('cuatro', () => {
        limpiar();
        init();
        cuatro.onclick();
        expect(resultado.textContent).toBe("4");
    })

    test('cinco', () => {
        limpiar();
        init();
        cinco.onclick();
        expect(resultado.textContent).toBe("5");
    })
    
    test('seis', () => {
        limpiar();
        init();
        seis.onclick();
        expect(resultado.textContent).toBe("6");
    })

    test('siete', () => {
        limpiar();
        init();
        siete.onclick();
        expect(resultado.textContent).toBe("7");
    })

    test('ocho', () => {
        limpiar();
        init();
        ocho.onclick();
        expect(resultado.textContent).toBe("8");
    })

    test('nueve', () => {
        limpiar();
        init();
        nueve.onclick();
        expect(resultado.textContent).toBe("9");
    })

    test('cero', () => {
        limpiar();
        init();
        cero.onclick();
        expect(resultado.textContent).toBe("0");
    })

    test('suma', () => {
        limpiar();
        init();
        nueve.onclick();
        suma.onclick();
        ocho.onclick();
        igual.onclick();
        expect(resultado.textContent).toBe("17");
    })

    test('resta', () => {
        limpiar();
        init();
        nueve.onclick();
        resta.onclick();
        ocho.onclick();
        igual.onclick();
        expect(resultado.textContent).toBe("1");
    })

    test('multiplicar', () => {
        limpiar();
        init();
        nueve.onclick();
        multiplicacion.onclick();
        ocho.onclick();
        igual.onclick();
        expect(resultado.textContent).toBe("72");
    })

    test('dividir', () => {
        limpiar();
        init();
        ocho.onclick();
        division.onclick();
        cuatro.onclick();
        igual.onclick();
        expect(resultado.textContent).toBe("2");
    })

    test('resetear', () => {
        limpiar();
        init();
        ocho.onclick();
        suma.onclick();
        nueve.onclick ();
        igual.onclick();
        reset.onclick();
        expect(resultado.textContent).toBe("");
    })

    test('igual', () => {
        limpiar();
        init();
        ocho.onclick();
        suma.onclick();
        nueve.onclick ();
        expect(igual.onclick()).toBe(resolver());
    })
})

/* -------------------------------------------------------------------------- */
/*                      PRUEBAS UNIT TEST FUNCION LIMPIAR                   */
/* -------------------------------------------------------------------------- */

describe('Funcion Limpiar',()=>{
    test('limpiar', () => {
        limpiar();
        expect(resultado.textContent).toBe("");
    })
})

/* -------------------------------------------------------------------------- */
/*                      PRUEBAS UNIT TEST FUNCION RESETEAR                   */
/* -------------------------------------------------------------------------- */

describe('Funcion resetear',()=>{
    test('Reseteo a resultado vacío', () => {
        resetear();
        expect(document.getElementById('resultado').textContent).toBe("");
    })

    test('Prueba reseteo primer numero', () => {
        init();
        nueve.onclick();
        resetear();
        let operandoa = resultado.textContent;
        expect(operandoa).toBe("");
})

test('Prueba reseteo segundo numero', () => {
    init();
    cuatro.onclick();
    resetear();
    let operandob = resultado.textContent;
    expect(operandob).toBe("");
})

test('Prueba reseteo operacion', () => {
    const resultado = document.getElementById('resultado');
    cuatro.onclick();
    suma.onclick();
    cuatro.onclick();
    igual.onclick();
    resetear();
    expect(resultado.textContent).toBe("")
})
})

/* -------------------------------------------------------------------------- */
/*                   PRUEBAS UNIT TEST PARA FUNCION RESOLVER                  */
/* -------------------------------------------------------------------------- */
describe('Prueba función reolver', () => {
test ("Switch", () => {
    resultado.value = "";
    resolver();
    expect(parseFloat(resultado.textContent)).toBe(0);
})
})