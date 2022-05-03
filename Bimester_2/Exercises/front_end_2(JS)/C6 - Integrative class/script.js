// Selecciono todos los div con la clase "Tarjeta"
const tarjetas = document.querySelectorAll('div.tarjeta');

// Funcion que crear Elemento <a> en cada div con la clase "Tarjeta"
tarjetas.forEach( tarjeta => {
    const a = document.createElement("a");
    a.classList.add("rutas-img")
    tarjeta.appendChild(a);
});

// Selecciono todas las <a> y las <img> del archivo de HTML. El resultado es un array de A y de Img

const links = document.querySelectorAll('a');
const img = document.querySelectorAll('img');

// Asigno manualmente ( no dio automáticamente) el elemento <img> de la posición 0 al elemennto a de la posición 0, y
// así sucesivamente

links[0].appendChild(img[0]);
links[1].appendChild(img[1]);
links[2].appendChild(img[2]);



// Función que le pide al usuario agregar URL de la imagen

img.forEach(i => {
        const url = prompt("Ingrese url para cargar cada imagen. Se pedirán 3 URLS: ");
        i.setAttribute("src", url);
        i.setAttribute("width", "300px");
    });

// Función que le asigna a cada imagen el link que lo redirecciona a otra página, sin salir del Home.
links.forEach(a => {
    a.setAttribute("href", "https://shopee.com.mx/PLAYERA-FULL-GATOS-GATITOS-MICHIS-KAWAII-LINDOS-E-i.521488703.11660806420");
    a.setAttribute("target", "_blank")
})













