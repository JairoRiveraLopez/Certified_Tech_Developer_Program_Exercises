window.addEventListener('load', function () {


    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.querySelector('form');
    const inputName = document.querySelector('#inputNombre');
    const inputLName = document.querySelector('#inputApellido');
    const inputEmail = document.querySelector('#inputEmail');
    const inputPass = document.querySelector('#inputPassword');
    const inputPassVal= document.querySelector('#inputPasswordRepetida');

    const urlBase = 'https://ctd-fe2-todo.herokuapp.com/v1';

    let mensajeErrorNombre = document.createElement("p");
    let mensajeErrorApellido = document.createElement("p");
    let mensajeErrorEmail = document.createElement("p");
    let mensajeErrorPasswd1 = document.createElement("p");
    let mensajeErrorPasswd2 = document.createElement("p");

    let valdInputName = document.querySelector("#valdInputName");
    let valdInputLastName = document.querySelector("#valdInputLastName");
    let valdEmail = document.querySelector("#valdEmail");
    let valdPaswd1 = document.querySelector("#valdPaswd1");
    let valdPaswd2 = document.querySelector("#valdPaswd2");

    const usuario = {
        firstName: "",
        lastName: "",
        email: "",
        password: ""
    }
    /* -------------------------------------------------------------------------- */
    /*                          FUNCIÓN 1: Validaciones                           */
    /* -------------------------------------------------------------------------- */

    function errorValidarNombre(mensaje){
        inputName.classList.add("error");
        mensajeErrorNombre.classList.add("perror");
        mensajeErrorNombre.innerText = mensaje;
        valdInputName.appendChild(mensajeErrorNombre);
    }

    function validacionNombre(nombre){
        let n = nombre.trim().split(" ");
        let contadorErrores = 0;

        !/\d/.test(nombre) ? contadorErrores++ : errorValidarNombre("* No debe contener números");
        n[0].length > 0 ? contadorErrores++ : errorValidarNombre("* El nombre no puede estar vacio");
    
        if(contadorErrores == 2){
            inputName.classList.remove("error");
            mensajeErrorNombre.remove()
            usuario.firstName = n.join(" ");
        }
    }

    inputName.addEventListener("blur", () => {
        validacionNombre(inputName.value)
    })
    // //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //

    function errorValidarApellido(mensaje){
        inputLName.classList.add("error");
        mensajeErrorApellido.classList.add("perror");
        mensajeErrorApellido.innerText = mensaje;
        valdInputLastName.appendChild(mensajeErrorApellido);
    }

    function validacionApellido(apellido){
        let a = apellido.trim().split(" ");
        let contadorErrores = 0;

        !/\d/.test(apellido) ? contadorErrores++ : errorValidarApellido("* No debe contener números");
        a[0].length > 0 ? contadorErrores++ : errorValidarApellido("* El apellido no puede estar vacio");
    
        if(contadorErrores == 2){
            inputLName.classList.remove("error");
            mensajeErrorApellido.remove()
            usuario.lastName = a.join(" ");
        }
    }

    inputLName.addEventListener("blur", () => {
        validacionApellido(inputLName.value)
    })

    // //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //
    
    function validacionEmail() {
    const validateEmail = (email) => {
        return email.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)
    }

    if(validateEmail(inputEmail.value)){
        usuario.email = inputEmail.value;
        valdEmail.removeChild(mensajeErrorEmail);
        inputEmail.classList.remove("error");
    } else {
        inputEmail.classList.add("error");
        mensajeErrorEmail.innerText = "Email ingresado no es válido";
        mensajeErrorEmail.classList.add("perror");
        valdEmail.appendChild(mensajeErrorEmail);
        
    }
}

    inputEmail.addEventListener("change", () => {
    validacionEmail();
    })

    // //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //

    function validacionContrasenia1() {
        const validatePassword = (passwd) => {
            return passwd.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,20})/)
        }

        if(validatePassword(inputPass.value)){
        
        valdPaswd1.removeChild(mensajeErrorPasswd1);
        inputPass.classList.remove("error");
        } else {
        inputPass.classList.add("error");
        mensajeErrorPasswd1.innerText = "Contraseña debe contener de 8 a 20 caracteres, minimo 1 mayuscula y minimo 1 número.";
        mensajeErrorPasswd1.classList.add("perror");
        valdPaswd1.appendChild(mensajeErrorPasswd1);
        }
        
        }

        inputPass.addEventListener("change", () => {
            validacionContrasenia1();
            })

    // //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //// //        
        function validacionContrasenia2(){
            if(inputPass.value === inputPassVal.value){
                usuario.password = inputPassVal.value;
                valdPaswd2.removeChild(mensajeErrorPasswd2);
                inputPassVal.classList.remove("error");
            } else {
            inputPassVal.classList.add("error");
            mensajeErrorPasswd2.innerText = "Contraseña no coincide con la ingresada.";
            mensajeErrorPasswd2.classList.add("perror");
            valdPaswd2.appendChild(mensajeErrorPasswd2);
            }
        }

        inputPassVal.addEventListener("change", () => {
            validacionContrasenia2();
            })

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 2: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (e) {
        e.preventDefault();

        // preparo la data para crear usuario
        
        console.log(usuario);
        
        const settings = {
            method: 'POST',
            body: JSON.stringify(usuario),
            headers: {
                'Content-Type': 'application/json'
            }
        } 

        //   intentamos registrar nuestro usuario
        realizarRegister(settings);

    });



    /* -------------------------------------------------------------------------- */
    /*                    FUNCIÓN 3: Realizar el signup [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarRegister(configuraciones) {

        // creamos la consulta a la API
        fetch(`${urlBase}/users`, configuraciones)
            .then(respuesta => respuesta.json())
            .then(data => {
                // corroboramos que nos llega un toke
                if(data.jwt){
                    // guardamos el token en storage
                    localStorage.setItem('jwt', JSON.stringify(data.jwt));

                    // redireccionamos al usuario a la pantalla de tareas
                    location.replace('./mis-tareas.html');
                }
            }).catch( error => {
                console.log("Error escuchando la promesa.");
                console.log(error);
            })

    };


})
