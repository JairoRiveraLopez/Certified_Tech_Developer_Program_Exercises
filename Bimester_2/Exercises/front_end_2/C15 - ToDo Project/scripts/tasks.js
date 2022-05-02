// SEGURIDAD: Si no se encuentra en localStorage info del usuario
// no lo deja acceder a la página, redirigiendo al login inmediatamente.

const Token = localStorage.getItem('jwt');

// if (!Token) {
//   location.replace('./index.html')
// }

/* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

  /* ---------------- variables globales y llamado a funciones ---------------- */
  
  const urlBase = 'https://ctd-fe2-todo.herokuapp.com/v1';
  const formTarea =  document.querySelector(".nueva-tarea");
  const inputNuevaTarea =  document.querySelector("#nuevaTarea");
  const btnCerrarSesion = document.querySelector('#closeApp');
  const userName = document.querySelector('.user-info p');
  const listaTareasPendientes = document.querySelector('.tareas-pendientes');
  const listaTareasTerminadas = document.querySelector('.tareas-terminadas');
  const conteoFinalizadas = document.querySelector('#cantidad-finalizadas');

  obtenerNombreUsuario();

  consultarTareas();
  /* -------------------------------------------------------------------------- */
  /*                          FUNCIÓN 1 - Cerrar sesión                         */
  /* -------------------------------------------------------------------------- */

  btnCerrarSesion.addEventListener('click', function () {
  const preguntaCierre = confirm("¿Desea cerrar sesión?");

  if (preguntaCierre) {
    localStorage.clear();
    location.replace('./index.html')
  }

  });

  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 2 - Obtener nombre de usuario [GET]                */
  /* -------------------------------------------------------------------------- */

  function obtenerNombreUsuario() {
  
    const settings = {
      method: 'GET',
      headers: {
        authorization: JSON.parse(Token)
      }
    }

    fetch(`${urlBase}/users/getMe`, settings)
      .then(res => res.json())
      .then(data => {
        userName.innerText = data.firstName;
        userName.style.textTransform = 'capitalize'
      })
      .catch(error => {
        console.log(error);
      })


  };


  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 3 - Obtener listado de tareas [GET]                */
  /* -------------------------------------------------------------------------- */

  function consultarTareas() {
    
    const settings = {
      method: 'GET',
      headers: {
        authorization: JSON.parse(Token)
      }
    }

    fetch(`${urlBase}/tasks`, settings)
      .then(res => res.json())
      .then(data => {
        renderizarTareas(data);
      })
      .catch(error => {
        console.log(error);
      })
  };


  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 4 - Crear nueva tarea [POST]                    */
  /* -------------------------------------------------------------------------- */

  formTarea.addEventListener('submit', function (e) {

    e.preventDefault();

    const verificacion = validacionTarea(inputNuevaTarea.value);

    if(verificacion){
      const body = {
        description: inputNuevaTarea.value,
        completed: false
      }
    
    const settings = {
      method: 'POST',
      headers: {
        authorization: JSON.parse(Token),
        'Content-type': 'application/json'
      },
      body: JSON.stringify(body)
    }

    fetch(`${urlBase}/tasks`, settings)
        .then(res => res.json())
        .then(data => {
          console.log(data);
          consultarTareas();
        })
        .catch(error => {
          console.log(error);
        })
  } else{
    alert("No puedes crear una tarea sin datos.");
  }

  formTarea.reset();

  });


  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 5 - Renderizar tareas en pantalla                 */
  /* -------------------------------------------------------------------------- */
  function renderizarTareas(li) {

    listaTareasPendientes.innerHTML = "";
    listaTareasTerminadas.innerHTML = "";

    li.forEach(tarea => {
      
      const date = new Date(tarea.createdAt);

      if (tarea.completed) {

        listaTareasTerminadas.innerHTML += `
        <li class="tarea">
            <div class="hecha">
              <i class="fa-regular fa-circle-check"></i>
            </div>
            <div class="descripcion">
              <p class="nombre">${tarea.description}</p>
              <div class="cambios-estados">
                <button class="change incompleta" id="${tarea.id}" ><i class="fa-solid fa-rotate-left"></i></button>
                <button class="borrar" id="${tarea.id}"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
          </li>
        `
      } else {
        
        listaTareasPendientes.innerHTML += `
          <li class="tarea">
            <button class="change" id="${tarea.id}"><i class="fa-regular fa-circle"></i></button>
            <div class="descripcion">
              <p class="nombre">${tarea.description}</p>
              <p class="timestamp">${date.toLocaleDateString()}</p>
            </div>
          </li>
                        `
      }

    })

    const itemsTerminados = document.querySelectorAll('.tareas-terminadas li');
    conteoFinalizadas.innerText = itemsTerminados.length;

    botonesCambioEstado();
    botonBorrarTarea();

  };

  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 6 - Cambiar estado de tarea [PUT]                 */
  /* -------------------------------------------------------------------------- */
  function botonesCambioEstado() {
    
    const botonesDeUpdate = document.querySelectorAll('.change');

    botonesDeUpdate.forEach(boton => {

      boton.addEventListener('click', function (e) {
        
        const idCapturado = e.target.id;

        const tareaTerminada = e.target.classList.contains('incompleta');

        const body = {
          completed: !tareaTerminada
        }

        const settings = {
          method: 'PUT',
          headers: {
            authorization: JSON.parse(Token),
            'Content-type': 'application/json'
          },
          body: JSON.stringify(body)
        }

        fetch(`${urlBase}/tasks/${idCapturado}`, settings)
          .then(res => res.json())
          .then(data => {
            console.log(data);
            
            consultarTareas();
          })
          .catch(error => {
            console.log(error);
          })

      })

    })

  }


  /* -------------------------------------------------------------------------- */
  /*                     FUNCIÓN 7 - Eliminar tarea [DELETE]                    */
  /* -------------------------------------------------------------------------- */
  function botonBorrarTarea() {

    const botonesDelete = document.querySelectorAll('.borrar');

    botonesDelete.forEach(boton => {
      boton.addEventListener('click', function (e) {

        const idCapturado = e.target.id;

        
        const settings = {
          method: 'DELETE',
          headers: {
            authorization: JSON.parse(Token),
          }
        }

        // hacemos el POST en la api
        fetch(`${urlBase}/tasks/${idCapturado}`, settings)
          .then(res => res.json())
          .then(data => {
            console.log(data);
            
            consultarTareas();
          })
          .catch(error => {
            console.log(error);
          })


      })
    })

    

  };

});