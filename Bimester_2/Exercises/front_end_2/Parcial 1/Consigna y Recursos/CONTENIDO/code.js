/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
};

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://jherax.files.wordpress.com/2018/08/javascript_logo.png",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/React.svg/1200px-React.svg.png",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
];

const profileBtn = document.querySelector("#completar-perfil");
const materiasBtn = document.querySelector("#obtener-materias");
const verMasBtn = document.querySelector("#ver-mas");
const cambiarTema = document.querySelector('#cambiar-tema');

profileBtn.addEventListener("click", renderizarDatosUsuario);
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas);
cambiarTema.addEventListener("click", alternarColorTema);
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

function obtenerDatosDelUsuario() {
  /* --------------- PUNTO 1: Escribe tu codigo a partir de aqui --------------- */
  const nombreUsuario = prompt("Ingresa tu nombre ");
  datosPersona.nombre = nombreUsuario;

  const anioNacimiento = prompt("Ingresa el año en que naciste ");
  var anioActual = new Date().getFullYear();
  let edad = anioActual - anioNacimiento;

  datosPersona.edad = edad;
  const ciudadResidencia = prompt("Ingrese la ciudad donde vives ");

  datosPersona.ciudad = ciudadResidencia;
  const interesJava = confirm("¿Te gusta JavaScript? ");

  if (interesJava == true){
    let meEncanta = "¡Me Encanta!"
    datosPersona.interesPorJs = meEncanta
  } else {
    let noMeGusta = "¡No me gusta!"
    datosPersona.interesPorJs = noMeGusta
  }
}

function renderizarDatosUsuario() {
  /* ------------------- NO TOCAR NI ELIMINAR ESTA FUNCION. ------------------- */
  obtenerDatosDelUsuario();
  /* --------------- PUNTO 2: Escribe tu codigo a partir de aqui --------------- */
  let datos = document.querySelectorAll("h3 span")
  datos[0].innerText = datosPersona.nombre;
  datos[1].innerText = datosPersona.edad;
  datos[2].innerText = datosPersona.ciudad;
  datos[3].innerText = datosPersona.interesPorJs;
}


function recorrerListadoYRenderizarTarjetas() {
  /* ------------------ PUNTO 3: Escribe tu codigo desde aqui ------------------ */
  let contenedor = document.querySelector('#fila')
  contenedor.innerHTML = ''
  listado.map( info => {
    return contenedor.innerHTML += 
    `
    <div class = "caja">
    <img src = "${info.imgUrl}" alt = "${info.lenguajes}">
    <p class = "lenguajes" >${info.lenguajes}</p>
    <p class = "bimestre" >${info.bimestre}</p>
    </div>
    `
  })
}

function alternarColorTema() {
  /* --------------------- PUNTO 4: Escribe tu codigo aqui --------------------- */
  let divmain = document.querySelector('#sitio')
  divmain.classList.toggle("dark");
}

/* --------------------- PUNTO 5: Escribe tu codigo aqui --------------------- */
let psobremi = document.querySelector('#sobre-mi')
window.addEventListener("keypress", (event) => {
  if(event.key == "F") {
    psobremi.classList.remove("oculto");
  }
})