const alicia = [23,82,46];
const bob = [45,8,32]



function encontrarGanador (a, b){
let participante1 = 0;
let participante2 = 0;
let empate = 0;
    for (i=0; i < a.length; i++){
        if (a[i] > b[i]){
            participante1++;
        } else if (a[i] == b[i]){
            empate++;
        } else{
            participante2++;
        }
    }

    return `Puntaje del Participante 1 es = ${participante1} \nPuntaje del Participante 2 es = ${participante2}`
}

console.log(encontrarGanador(alicia, bob));

function digitalHouse (n1, n2){
    for (i=1; i <= 100; i++){
        if(i%n1 == 0){
            console.log("Digital ");
        } else if (i%n2 == 0){
            console.log("House ");
        } else{
            console.log(i + " ");
        }
    }
}

digitalHouse(7, 12);