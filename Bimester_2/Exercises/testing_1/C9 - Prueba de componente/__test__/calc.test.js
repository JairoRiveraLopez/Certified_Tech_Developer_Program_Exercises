let importacion = require("../calc.js")

describe( "PruebasSuma", () => {
test('TestSumaNumeros', () => {
    const suma = importacion.suma(28, 20);
    expect(suma).toBe(48)
})

test('TestSumaString', () => {
    const suma = importacion.suma("", 20);
    expect(suma).toBe(0)
})

test('TestSumaNull', () => {
    const suma = importacion.suma(null, null);
    expect(suma).toBe(0)
})

test('TestSumaUndefined', () => {
    const suma = importacion.suma(undefined, undefined);
    expect(suma).toBe(0)
})
})

describe( "PruebasResta", () => {
    test('TestRestaNumeros', () => {
        const resta = importacion.resta(28, 20);
        expect(resta).toBe(8)
    })
    
    test('TestRestaString', () => {
        const resta = importacion.resta("", 20);
        expect(resta).toBe(0)
    })
    
    test('TestRestaNull', () => {
        const resta = importacion.resta(null, null);
        expect(resta).toBe(0)
    })
    
    test('TestRestaUndefined', () => {
        const resta = importacion.resta(undefined, undefined);
        expect(resta).toBe(0)
    })
})

describe( "PruebasMultiplicacion", () => {
    test('TestMultiplicacionNumeros', () => {
        const multiplicacion = importacion.multiplicacion(4, 10);
        expect(multiplicacion).toBe(40)
    })
    
    test('TestMultiplicacionString', () => {
        const multiplicacion = importacion.multiplicacion("", 20);
        expect(multiplicacion).toBe(0)
    })
    
    test('TestMultiplicacionNull', () => {
        const multiplicacion = importacion.multiplicacion(null, null);
        expect(multiplicacion).toBe(0)
    })
    
    test('TestMultiplicacionUndefined', () => {
        const multiplicacion = importacion.multiplicacion(undefined, undefined);
        expect(multiplicacion).toBe(0)
    })
})

describe( "PruebasDivision", () => {
    test('TestDivisionNumeros', () => {
        const division = importacion.division(40, 10);
        expect(division).toBe(4)
    })
    
    test('TestDivisionString', () => {
        const division = importacion.division("", 20);
        expect(division).toBe(0)
    })
    
    test('TestDivisionNull', () => {
        const division = importacion.division(null, null);
        expect(division).toBe(0)
    })
    
    test('TestDivisionUndefined', () => {
        const division = importacion.division(undefined, undefined);
        expect(division).toBe(0)
    })

    test('TestDivisionPor0', () => {
        const division = importacion.division(40, 0);
        expect(division).toBe("Sos pendej@ que no se puede dividir por 0.")
    })
})