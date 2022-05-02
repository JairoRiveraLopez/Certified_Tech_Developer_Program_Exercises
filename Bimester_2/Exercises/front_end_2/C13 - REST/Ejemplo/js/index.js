const apiUrl = 'https://dog.ceo/api/breeds/imag';

async function callApi() {
  try {
    const res = await fetch(apiUrl)
    const data = await res.json()
    return data.message
  }
  catch(err) {
      console.log(err)
  }

}

// function callApi() {

//     fetch(apiUrl)
//         .then(respuesta => {
//             return respuesta.json();
//         })
//         .then(datos => {
//             loadImageAndShowAlert(datos.message);
//         })
//         .catch(error => {
//             console.log("Ocurrió un error al llamar a la API.", error);
//         });
// }

let button = document.querySelector('button');
button.addEventListener('click', callApi);

function loadImageAndShowAlert(src) {
  document.querySelector('img').setAttribute('src', src);
}