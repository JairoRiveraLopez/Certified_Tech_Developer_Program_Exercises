const jsonHelper = require('./jsonHelper');

const info = jsonHelper.leerJson('./response_ability');

let pokemones = info.results;

console.log(pokemones);

const buscarPorNombre = function(nombre) {
   let busqueda = pokemones.find(poke => poke.name == nombre)
   if (busqueda){
    return `¡Se encontró el Pokemon "${nombre}"! La URL es: ${busqueda.url} `
} else {
    return "El pokemon ingresado no existe en la API."
}
}

console.log(buscarPorNombre("static"));


