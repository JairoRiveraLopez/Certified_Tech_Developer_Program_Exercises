// Ejemplo discoteca
let edadMínima = 18;
let capacidadMáxima = 1000;

if (edadMínima >= 18 || capacidadMáxima <= 1000){
    console.log("Puede entrar");
}

console.log("____________________________________");
// Variables númericos
let uno = 21;
let dos = uno;
uno = 14;

console.log(uno);
console.log("____________________________________");

// Mensaje con variables (Escrito con el bonus)
let nombre = "Jairo", edad = "19", cumpleaños = "14/02/1996", ciudad = "Medellín", ocupación = "estudiante", 
hobbie = "aprender código";

console.log(`Mi nombre es ${nombre}, nací el ${cumpleaños} y ahorita tengo ${edad} años. Vivo en la ciudad de ${ciudad}
y actualmente soy ${ocupación} en Digital House. Lo que más disfruto hacer en mis tiempos libres es ${hobbie}.`);
console.log("____________________________________");

// Calculadora edad
let edadUsuario1 = 22, edadUsuario2 = 52, edadUsuario3 = 9;

let Calculadora = console.log(`La edad del usuario1 (${edadUsuario1 + " años"}) en días es ${edadUsuario1*365}`) + 
console.log(`La edad del usuario2 (${edadUsuario2 + " años"}) en días es ${edadUsuario2*365}`) + 
console.log(`La edad del usuario3 (${edadUsuario3 + " años"}) en días es ${edadUsuario3*365}`);
console.log("____________________________________");

// Suma de valores
let num1 = 2, num2 = 3, resultado;
resultado = num1 + num2;
console.log(resultado);
console.log("____________________________________");

                                      // Calculador de abastecimiento de vida

// Ejercicio 1

let miEdad = 26, edadMaxima = 80, snack = "Bocadillo", consumoSnacks = 2, precioSnackUnidad = 500;

let snacksHastaLaMuerte = ((edadMaxima - miEdad)*365) * consumoSnacks;

console.log(`Tengo ${miEdad + " años"}, mi snack favorito es el ${snack} y me como ${consumoSnacks} al día. 
Suponiendo que vivo hasta los ${miEdad + " años"} y sigo comiendo con esa intensidad, necesitaré 
${snacksHastaLaMuerte} y alrededor de ${snacksHastaLaMuerte * precioSnackUnidad} pesos Colombianos`);
console.log("____________________________________");

// Ejercicio 2
let diasVacaciones = 15, presupuestoMaximoUSD = 1000, cantidadComidas = 3;
let gastoXComida = Math.round(presupuestoMaximoUSD/(cantidadComidas * diasVacaciones));
console.log("Podés gastar " + gastoXComida + " USD en cada comida para que te alcance la plata durane los " + diasVacaciones + " días de viaje.");
console.log("____________________________________");
// Ejercicio 3

let usuario1 = { 
    Nombre: "José",
    Apellido: "Fermoso",
    Edad: 33,
    Peso: 63.7,
    Altura: 153,
    Prepaga: null
}

let calculadoraIMC = Math.round(usuario1.Peso/((usuario1.Altura/100)*(usuario1.Altura/100)))


let infoIMC = console.log(`${usuario1.Nombre} ${usuario1.Apellido} tiene ${edad} años y su índice de masa 
corporal es de ${calculadoraIMC}.
`);