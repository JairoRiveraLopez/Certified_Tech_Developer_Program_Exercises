                                                            // Ejercicio 1

function mayorMenorIgual(N1, N2){

if (N1 < N2){
    return `El número ${N1} es menor que ${N2}`;
} 
else if (N1 > N2){
    return `El número ${N1} es mayor que ${N2}`;
} 
else{
    return `El número ${N1} es igual que ${N2}`;
}
}

console.log(mayorMenorIgual(3, 15));
console.log(mayorMenorIgual(15, 3));
console.log(mayorMenorIgual(15, 15));

//                                                             Ejercicio 2

function generacion(añoDeNacimiento){

    if (añoDeNacimiento <= 1964){
        return `Si el año es ${añoDeNacimiento}, la generación es Baby Boomer`;
    }
    else if(añoDeNacimiento >= 1965 && añoDeNacimiento <= 1981){
        return `Si el año es ${añoDeNacimiento}, la generación es Generación X`;
    }
    else if(añoDeNacimiento >= 1982 && añoDeNacimiento <= 1997){
        return `Si el año es ${añoDeNacimiento}, la generación es Millenial`;
    }
    else if(añoDeNacimiento > 1997){
        return `Si el año es ${añoDeNacimiento}, la generación es Generación Z`;
    }
}

console.log(generacion(1950));
console.log(generacion(1965));
console.log(generacion(1982));
console.log(generacion(1998));

//                                                           Ejercicio 3

function mayorMenorQue100(N1, N2){

let suma = N1 + N2;

if (suma < 100){
    return `La suma de ${N1} y ${N2} es ${suma}, y es menor que 100`
}
else if (suma > 100){
    return `La suma de ${N1} y ${N2} es ${suma}, y es mayor que 100`
}
else{
    return `La suma de ${N1} y ${N2} es exactamente 100`
}
}

console.log(mayorMenorQue100(1, 2));
console.log(mayorMenorQue100(70, 50));
console.log(mayorMenorQue100(60, 40));