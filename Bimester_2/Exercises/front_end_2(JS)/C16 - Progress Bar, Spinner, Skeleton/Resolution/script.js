const divSpinner = document.querySelector("#contenedor-carga");
const divs = document.querySelectorAll(".card")
function timeout(ms) {
  return new Promise(resolve => setTimeout(resolve, 2000));
}

async function fillPokemonData(name, order) {

  

  await timeout();
  const pokemonData = await getPokemonData(name);

  

  //Actividades

  // 1) Insertar la imagen del pokemon dentro cada card. Para ello,
  // puedes explorar los elementos HTML utilizando las Dev Tools de tu
  // navegador.

  const img = document.getElementById(`imagen-pokemon-${order}`) // Obtenemos la imagen correspondiente al pokemon

  img.src = pokemonData.imagen // Cambiamos el src

  
  pokemonData.stats.forEach(stat => { // Iteramos los stats que trae la consulta a la API
    const cantidad = document.getElementById(`cantidad-${stat.name}-${order}`) // Obtenemos el DIV de la cantidad
    cantidad.innerText = stat.amount // Asignamos el valor de la cantidad

    const barra = document.getElementById(`barra-${stat.name}-${order}`) // Obtenemos el DIV de la barra 
    barra.style.width = `${stat.amount}%` // Asignamos el porcentaje de anchura de la barra

    // Condiciones para asignar los colores
  


  // 2) Utilizando los stats de cada pokemon, deberás rellenar cada una de las
  // barras que figuran en la card. Dependiendo de la cantidad de cada atributo
  // tendrás que decidir el color que tendrá la barra en cada caso:
  // Si la habilidad es menor a 35, la barra será de color rojo
  // Si la habilidad es mayor o igual a 35 pero menor que 70, la barra será amarilla
  // Si la habilidad es igual o mayor a 70, la barra será de color verde.
  // Deberás utilizar las clases que se encuentran en el archivo styles.css


  if (stat.amount < 35) { 
    barra.classList.add("rojo")
  } else if (stat.amount <= 70) {
    barra.classList.add("amarillo")
  } else {
    barra.classList.add("verde")
  }
  
})

divSpinner.remove();
  //ESCRIBE TU CÓDIGO A CONTINUACIÓN DENTRO DE LA FUNCIÓN:
}



//LISTADO DE POKEMONS - PUEDES CAMBIAR POR TU FAVORITO!
const pokemons = ["charizard", "raichu", "charmander", "mewtwo"];



//INICIALIZADOR - NO TOCAR

pokemons.forEach((pokemon, index) => {
  const pokemonNumber = index + 1;
  createPokemonCard(pokemon, pokemonNumber);
  fillPokemonData(pokemon, pokemonNumber);
});
