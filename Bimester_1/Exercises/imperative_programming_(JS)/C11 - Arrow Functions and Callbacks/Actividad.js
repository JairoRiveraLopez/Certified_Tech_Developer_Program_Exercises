// Crear una función que convierta pulgadas en centímetros.
// Recibe por parámetro pulgadas y retorna su equivalente en centímetros.

let convertirACM = (pulgadas) => pulgadas * 2.54;
console.log(convertirACM(1));

// Crear una función que recibe un string y lo convierte en una una URL. 
// ej: “pepito” es devuelto como “http://www.pepito.com”

let convertirAURL = (dominio) => "https://www." + dominio + ".com";
console.log(convertirAURL("NoEntiendoNada"));

// Crear una función que recibe un string y devuelve la misma frase pero con admiración.

let stringadmirado = (string) => "¡" + string + "!";
console.log(stringadmirado("NoEntiendoNada"));

// Crear una función que calcule la edad de los perros, considerando que 1 año para nosotros son 7 de ellos.
let edadAPerros = (edadperro) => edadperro * 7;
console.log(edadAPerros(9));

// Crear una función que calcule el valor de tu hora de trabajo, introduciendo tu sueldo mensual como parámetro.
let sueldo = (sueldo) => sueldo / 40;
console.log(sueldo(1000000));

// Crear la función calculadorIMC() que reciba la altura en metros y el peso en kilogramos y calcule el imc de una persona.  Luego, ejecutar la función probando diferentes valores.
let IMC = (peso, altura) => peso / (altura*altura);
console.log(IMC(80, 1.82));

// Crear una función que recibe un string en minúscula, lo convierta a mayúsculas y lo retorne. 
let aMayusc = (string) => string.toUpperCase();
console.log(aMayusc("no entiendo nada"));

// Crear una función que recibe un parámetro y devuelve qué tipo de dato es ese parámetro. 
let tipoArchivo = (bool) => typeof bool;
console.log(tipoArchivo(true));

// Crear una función que le pasamos el radio de un círculo y nos devuelve la circunferencia
let radioCirculo = (radio) => {
    let resultado = 2 * Math.PI * radio;
    return resultado.toFixed(2) + " cm2"
}
console.log(radioCirculo(30));

// Callback

const nombres = ['Martin','Homero','Cosme','Steven','Adam'];
function buscarNombre(nombre){
    for (let i = 0; i < nombres.length; i++) {
        if(nombres[i] == nombre) {
        return nombres[i];
        }
    }
}

function mostrarResultado(res){
    
    if (buscarNombre == true){
    res = "El nombre fue encontrado"
    } else{
    res = "El nombre NO fue encontrado"
    }
}

buscarNombre('Martin', mostrarResultado);


