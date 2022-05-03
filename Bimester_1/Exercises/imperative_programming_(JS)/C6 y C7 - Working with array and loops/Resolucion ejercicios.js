//                                                                  Parte 1 - Qué devuelven los códigos

// let numbers =[22, 33, 54, 66, 72]
// console.log(numbers[numbers.length])

// R/: La longitud del array numbers

// let grupoDeAmigos = [ "Harry", "Ron", "Hermione", "Spiderman", "Hulk",
// "Ironman","Penélope Glamour", "Pierre Nodoyuna","Patán" ]
// console.log(grupoDeAmigos[5])
// R/: Devuelve el dato ubicado en el índice 5, en este caso sería "Ironman"

// let str = "un string cualquiera";
// let arrayAleatorio= ["Digital", "House", true, "string", "123","false", 54, str ]
// console.log(arrayAleatorio[arrayAleatorio.length - 1])

// R/: Retorna la ultima posición del array, en este caso la variable str = "un string cualquiera";



//                                                                 // Ejercicio 1

let peliculas = ["star wars", "totoro", "rocky", "pulp fiction", "la vida es bella"]
let peliculas_animadas = ["toy story", "finding Nemo", "kung-fu panda", "wally", "fortnite"]

function mayusc(peliculas){
  
  let pelisMayusc = [ ]
  
    for (let i = 0; i < peliculas.length; i++){
    pelisMayusc.push(peliculas[i].toUpperCase());
    }
  return pelisMayusc;
}
let resultadoPelisMAYUS = mayusc(peliculas);
console.log(mayusc(resultadoPelisMAYUS));

//                                                                 // Ejercicio 2
let resultadoPelisAnimadasMAYUS = mayusc(peliculas_animadas);

function adicionPelis (peliculas, peliculas_animadas){
    let combinacion = peliculas;
    for (let i = 0; i < peliculas_animadas.length; i++){
        combinacion.push(peliculas_animadas[i]);
    }
    return combinacion;
}

let pelisTotal = adicionPelis(resultadoPelisMAYUS, resultadoPelisAnimadasMAYUS)
// console.log(pelisTotal);
//                                                                // Ejercicio 3
pelisTotal.pop();
console.log(pelisTotal);

//                                                                // Ejercicio 4

const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

function comparativa (asiaScores, euroScores){
    let comparacionesAsiaEuropa = [];
    for (let i = 0; i < asiaScores.length; i++){
    if (asiaScores[i] === euroScores[i]){
        comparacionesAsiaEuropa[i] = `La calificacion ${i} es la misma`;
    } else{
        comparacionesAsiaEuropa[i] = `La calificacion ${i} no es la misma`;
    }
    }
    return comparacionesAsiaEuropa;
}

console.log (comparativa(asiaScores, euroScores));

                                                              // Ejercicio 5
const ParticipanteA = [5, 8, 4, 9, 5];
const ParticipanteB = [8, 7, 8, 6, 8];
const ParticipanteC = [7, 5, 10, 8, 3];

function puntajePromedio (puntajeArray){
    let promedio = 0;
    for (let i = 0; i < puntajeArray.length; i++){
        promedio += puntajeArray[i];
    }
    return promedio / puntajeArray.length;
}

function puntajeMayor (puntajeArray){
    let mayor = puntajeArray[0];
    for (let i = 0; i < puntajeArray.length; i++){
        if (puntajeArray[i] > mayor){
            mayor = puntajeArray[i];
        }
    }
    return mayor;
}

let promedioParticipanteA = puntajePromedio(ParticipanteA);
console.log(promedioParticipanteA);
let promedioParticipanteB = puntajePromedio(ParticipanteB);
console.log(promedioParticipanteB);
let promedioParticipanteC = puntajePromedio(ParticipanteC);
console.log(promedioParticipanteC);


function ganadorporPromedio (promedioParticipanteA, promedioParticipanteB, promedioParticipanteC){
    if (promedioParticipanteA > promedioParticipanteB || promedioParticipanteA > promedioParticipanteC){
        return `El ganador por promedio es el Participante A con un puntaje de ${promedioParticipanteA}.`;
    }
    else if(promedioParticipanteB > promedioParticipanteA || promedioParticipanteB > promedioParticipanteC){
        return `El ganador por promedio es el Participante B con un puntaje de ${promedioParticipanteB}.`;
    }
    else if(promedioParticipanteC > promedioParticipanteA || promedioParticipanteC > promedioParticipanteB){
        return `El ganador por promedio es el Participante C con un puntaje de ${promedioParticipanteC}.`;
    }
}

console.log(ganadorporPromedio(promedioParticipanteA, promedioParticipanteB, promedioParticipanteC));

let puntajeMayorParticipanteA = puntajeMayor(ParticipanteA);
console.log(puntajeMayorParticipanteA);
let puntajeMayorParticipanteB = puntajeMayor(ParticipanteB);
console.log(puntajeMayorParticipanteB);
let puntajeMayorParticipanteC = puntajeMayor(ParticipanteC);
console.log(puntajeMayorParticipanteC);

function ganadorporPuntajeMayor (puntajeMayorParticipanteA, puntajeMayorParticipanteB, puntajeMayorParticipanteC){
    if (puntajeMayorParticipanteC > puntajeMayorParticipanteA || puntajeMayorParticipanteC > puntajeMayorParticipanteB){
        return `El ganador por puntaje mayor es el Participante C con un puntaje de ${puntajeMayorParticipanteC}.`;
    }
    else if(puntajeMayorParticipanteB > puntajeMayorParticipanteA || puntajeMayorParticipanteB > puntajeMayorParticipanteC){
        return `El ganador por puntaje mayor es el Participante B con un puntaje de ${puntajeMayorParticipanteB}.`;
    }
    else if(puntajeMayorParticipanteA > puntajeMayorParticipanteB || puntajeMayorParticipanteA > puntajeMayorParticipanteC){
        return `El ganador por puntaje mayor es el Participante A con un puntaje de ${puntajeMayorParticipanteA}.`;
}
}

console.log(ganadorporPuntajeMayor(puntajeMayorParticipanteA, puntajeMayorParticipanteB, puntajeMayorParticipanteC));