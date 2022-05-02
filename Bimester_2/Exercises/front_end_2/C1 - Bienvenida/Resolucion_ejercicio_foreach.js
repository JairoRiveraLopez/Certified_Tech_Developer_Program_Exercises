let numeros = [1, 2, 3, 4, 5];

function suma(array) {
    let contador = array[0];
    for(let i = 1; i < array.length; i++) {
        contador = contador + array[i];
        console.log(contador);
    }
}

suma(numeros);

