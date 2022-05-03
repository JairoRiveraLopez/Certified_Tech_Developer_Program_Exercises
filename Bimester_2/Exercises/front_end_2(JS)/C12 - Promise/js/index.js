console.log("Banca Mobile");
const cartelBanco = document.querySelector('.bancaMobile');
const btnConsultar = document.querySelector('button');

btnConsultar.addEventListener('click', function () {

    // mostramos la nueva UI
    cartelBanco.classList.remove('oculto');

    /* -------------------------------------------------------------------------- */
    /*                     simulamos un servidor respondiendo                     */
    /* -------------------------------------------------------------------------- */
    // const promesaBanco = new Promise((resolve, reject) => {

        // simulamos info en una base de datos
        const cuenta = {
            nombre: "Michael Scott",
            estadoActivo: true,
            fondos: 10000
        };

    //     setTimeout(function () {

    //         if (cuenta.estadoActivo != true) {
    //             reject({
    //                 mensaje: "Cuenta inactiva, petición rechazada.",
    //                 estatus: "x450"
    //             })
    //         } else if (cuenta.fondos < 100) {
    //             reject({
    //                 mensaje: "Fondos insuficientes.",
    //                 estatus: "z420"
    //             })
    //         } else {
    //             resolve({
    //                 mensaje: "Pago realizado con éxito",
    //                 estatus: "c200"
    //             })
    //         }

    //     }, 5500)

    // });

    /* -------------------------------------------------------------------------- */
    /*                 trabajamos con el resultado de una promesa                 */
    /* -------------------------------------------------------------------------- */

//     promesaBanco.then(respuesta => {
//         console.log("Respuesta resuelta:");
//         console.log(respuesta);
//         cartelBanco.innerHTML = `<h5>${respuesta.mensaje}</h5>`;
//         cartelBanco.style.border = "3px solid green";
//     }).catch(error => {
//         console.log("Respuesta rechazada");
//         console.log(error);
//         cartelBanco.innerHTML = `<h5>${error.mensaje}</h5>`;
//         cartelBanco.style.border = "3px solid red";
//     });

// CONSIGNA MESA
// Crear una funcion que reciba como parametro un mensaje de error,

function mensajeError(){
let mensaje;
//  la funcion debe presentar en pantalla el contenido del mensaje maquetado en el html
    if (cuenta.estadoActivo != true) {
        mensaje = "Cuenta inactiva, petición rechazada.";
        cartelBanco.style.border = "3px solid red";
    }

    else if (cuenta.fondos < 100){
        mensaje = "Fondos insuficientes."
        cartelBanco.style.border = "3px solid red";
    } else {
        mensaje = "Pago realizado con éxito"
        cartelBanco.style.border = "3px solid green";
    }

return mensaje;
}

function errorValidacion(){

    setTimeout(function () {
    
    let texto = mensajeError();
    cartelBanco.innerHTML = `<h5>${texto}</h5>`;
    
    
    }, 5500)
// Finalmente despues de 5 segundos la funcion debe recargar la página.
    setTimeout(function () {
    
        location.reload();
        
        }, 10500)
    
}

errorValidacion();

});

