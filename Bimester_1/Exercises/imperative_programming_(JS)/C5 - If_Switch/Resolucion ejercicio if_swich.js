// Ejercicio 1
// if (edad=>18){
//     console.log("Puede pasar");
// } else{
//     console.log("No puede pasar");
// }

// R/: El código está bien. Lo único que falta es la variabla edad definida.

// Ejercicio 2

let edad = 20;

if(edad < 18) {
console.log("Error, edad inválida. Por favor ingrese un número válido.");
}
else if(edad == 21){
console.log("Bienvenido. Felicidades por haber llegado a la mayoría de edad.");
}
if ((edad % 2) === 1){
console.log("¿Sabías que tu edad es impar?");
}
else{
    console.log("");
}


// Ejercicio 3

let vehiculo;
let litrosConsumidos;
let precioPorVehiculo;

function precioFinal (vehiculo, litrosConsumidos, precioPorVehiculo){
    if (vehiculo === "coche" && litrosConsumidos <= 25){
        precioPorVehiculo = 86;
        return (litrosConsumidos * precioPorVehiculo + 50);
    }

    else if (vehiculo === "coche" && litrosConsumidos > 25){
        precioPorVehiculo = 86;
        return (litrosConsumidos * precioPorVehiculo + 25);
    }

    if (vehiculo === "moto" && litrosConsumidos <= 25){
        precioPorVehiculo = 70;
        return (litrosConsumidos * precioPorVehiculo + 50);
    }
    else if (vehiculo === "moto" && litrosConsumidos > 25){
        precioPorVehiculo = 70;
        return (litrosConsumidos * precioPorVehiculo + 25);
    }

    if (vehiculo === "autobús" && litrosConsumidos <= 25){
        precioPorVehiculo = 55;
        return (litrosConsumidos * precioPorVehiculo + 50);
        }
    else if (vehiculo === "autobús" && litrosConsumidos > 25){
         precioPorVehiculo = 55;
         return (litrosConsumidos * precioPorVehiculo + 25); 
    }  
}

console.log("$" + precioFinal("coche", 10));
console.log("$" + precioFinal("moto", 22));
console.log("$" + precioFinal("autobús", 50));

// Ejercicio 4

function pedidoTotal(tipoSandwichBase, tipoPan, Queso, Tomate, Lechuga, Cebolla, Mayonesa, Mostaza){

let sandwichBase = tipoSandwichBase;

if (sandwichBase === "pollo"){
    precioBaseSandwich = 150;
}else if (sandwichBase === "carne"){
    precioBaseSandwich = 200;
}else if (sandwichBase === "veggie"){
    precioBaseSandwich = 100;
}

let pan = tipoPan;
if (pan === "blanco"){
    precioPan = 50;
}else if (pan === "negro"){
    precioPan = 60;
}else if (pan === "s/gluten"){
    precioPan = 75;
}

Queso = "Queso" ? 20 : 0;
Tomate = "Tomate" ? 15 : 0;
Lechuga = "Lechuga" ? 10 : 0;
Cebolla = "Cebolla" ? 20 : 0;
Mayonesa = "Mayonesa" ? 5 : 0;
Mostaza = "Mostaza" ? 5 : 0;

let adicionales = Queso + Tomate + Lechuga + Cebolla + Mayonesa + Mostaza;

let valorSandwich = "$" + (precioBaseSandwich + precioPan + adicionales);

return valorSandwich;
}

console.log(pedidoTotal("pollo", "blanco", "Queso", "Mostaza", "Mayonesa")) 

// Cuarto ejercicio //

function numeroSecreto(min, max) {
    min = 1;
    max = 10;

    let aleatorio = Math.floor(Math.random() * (max - min)) + min;

if (aleatorio == 1){
    console.log("¡Felicidades! Haz acertado.");
}else{
    console.log("Lo sentimos. Ese no es el número secreto. El número secreto es 1.");
}
return ("Número ingresado = " + aleatorio)
}
console.log(numeroSecreto());