function sumar(num1, num2, num3){
    resultsuma = num1 + num2 + num3;
    return (resultsuma);
}

function restar(num1, num2, num3){
    resultresta = num1 - num2 - num3;
    return (resultresta);
}

function multiplicar(num1, num2){
    resultmulti = num1 * num2;
    return (resultmulti);
}

function division(num1, num2){
    resultdivi = num1 / num2;
    return (resultdivi);
}

function cuadradoDeUnNumero(multiplicar){
    return resultmulti*resultmulti;
}

function promedioDeTresNumeros(sumar){
    return (resultsuma / 3);
}

function calcularPorcentaje(multiplicar){
    return (300 * resultdivi) + "%";
}

function GeneradorDePorcentaje(num3, num4){
    return((num3 / num4) * 100) + "%";
}
console.log("-------------- Testeo de Operaciones / Calculadora --------------")
console.log(sumar(100, 200, 3));
console.log(restar(100, 200, 3));
console.log(multiplicar(100, 200, 3));
console.log(division(15, 100));
console.log(cuadradoDeUnNumero());
console.log(promedioDeTresNumeros());
console.log(calcularPorcentaje());
console.log(GeneradorDePorcentaje(2, 200));