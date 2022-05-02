window.addEventListener("load", () => {

    const nombreUsuario = document.querySelector("#nombre");
    const telefono = document.querySelector("#tel");
    const contrasena = document.querySelector("#pass");
    const checkboxes = document.querySelectorAll("input[type=checkbox]");
    const formulario = document.querySelector("form");
    const radio = document.querySelectorAll("input[type=radio]");

    let usuario = {
        nombreCompleto: "",
        contrasenia: "",
        tel: "",
        hobbiesSeleccionados: [],
        nacionalidad: ""
    }

    let mensajeErrorNombre = document.createElement("p")
    let mensajeErrorCantidadHobbies = document.createElement("p")
    let mensajeErrorTele = document.createElement("p")
    let mensajeErrorContra = document.createElement("p")
    let mensajeErrorValidarHobbies = document.createElement("p")
    let mensajeErrorArgentina = document.createElement("p")
    let mensajeErrorPais = document.createElement("p")
    
    let nombreError = document.querySelector("#valdNombre")
    let telError = document.querySelector("#valdTel")
    let contraError = document.querySelector("#valdContra")
    let checkBoxError = document.querySelector("#checkBoxError")
    let radioError = document.querySelector("#radioError")

    function errorValidarNombre(mensaje){
        nombreUsuario.classList.add("error");
        mensajeErrorNombre.innerText = mensaje;
        nombreError.appendChild(mensajeErrorNombre);
    }

    function validacionNombre(nombre){
            let nCompleto = nombre.trim().split(" ", 4);
            let contadorCondiciones = 0;

            !/\d/.test(nombre) ? contadorCondiciones++ : errorValidarNombre("* No debe contener números");
            nombre.length <= 150 ? contadorCondiciones++ : errorValidarNombre("* Debe contener menos de 151 carácteres");
            nCompleto.length > 1 ? contadorCondiciones++ : errorValidarNombre("* El nombre debe tener más de 1 palabra");
            nCompleto[0].length > 1 ? contadorCondiciones++ : errorValidarNombre("* Cada palabra debe contener más de 1 caracter");
            nCompleto[1].length > 1 ? contadorCondiciones++ : errorValidarNombre("* Cada palabra debe contener más de 1 caracter");


            if(contadorCondiciones == 5){
                nombreUsuario.classList.remove("error");
                mensajeErrorNombre.remove()
                usuario.nombreCompleto = nCompleto.join(" ");
            } 
    }

    nombreUsuario.addEventListener("change", () => {
        validacionNombre(nombreUsuario.value)
    })

    function validarTel(tele) {
        let regex = /\d\d\d\s\d\d\d\s\d\d\d/i
            
        if (regex.test(telefono.value)){
            usuario.tel = telefono.value;
            telefono.classList.remove("error")
            telError.removeChild(mensajeErrorTele)
        } else{
            telefono.classList.add("error")
            mensajeErrorTele.innerText = "El teléfono debe tener 9 digitos y un espacio cada 3. Ejemplo: 923 238 384"
            telError.appendChild(mensajeErrorTele)
        }
    }
    

    telefono.addEventListener("change", () => {
        
        validarTel(telefono.value)
    })

    function validarContra(contra) {
        
        let strongRegex = new RegExp("^(?=.*[!@#$%^&*])(?=.{10,15})");
        if (strongRegex.test(contrasena.value)) {
            usuario.contrasenia = contrasena.value
            contrasena.classList.remove("error")
            contraError.removeChild(mensajeErrorContra)
        } else{
            contrasena.classList.add("error")
            mensajeErrorContra.innerText = "La contraseña debe tener entre 10 a 15 caracteres, y al menos uno de estos caracteres especiales: !@#$%^&*"
            contraError.appendChild(mensajeErrorContra)
        }
    }

    contrasena.addEventListener("blur", () => {
        validarContra(contrasena.value)
    })

    function validarCantidadHobbies (){

        if(usuario.hobbiesSeleccionados.length >= 5){
            usuario.hobbiesSeleccionados = [];
            checkBoxError.classList.add("error");
            mensajeErrorCantidadHobbies.innerText = "¡No puedes tener más de 4 hobbies!";
            checkBoxError.appendChild(mensajeErrorCantidadHobbies);
        } else {
            mensajeErrorCantidadHobbies.remove();
        }
        }

    function validarHobbies() {
        
            if (usuario.hobbiesSeleccionados.includes("hobbiesNetflix") && usuario.hobbiesSeleccionados.includes("hobbiesTejer")){
                usuario.hobbiesSeleccionados = [];
                checkBoxError.classList.add("error");
                mensajeErrorValidarHobbies.innerText = "¡La combinación de Netflix y Tejer no es mágica!";
                checkBoxError.appendChild(mensajeErrorValidarHobbies);
            } 
            else if (usuario.hobbiesSeleccionados.includes("hobbiesGuitarra") && usuario.hobbiesSeleccionados.includes("Lectura")){
                usuario.hobbiesSeleccionados = [];
                checkBoxError.classList.add("error");
                mensajeErrorValidarHobbies.innerText = "¡La combinación de Guitarra y Lectura no es mágica!";
                checkBoxError.appendChild(mensajeErrorValidarHobbies);
            }
            else if (usuario.hobbiesSeleccionados.includes("hobbiesVideoJuegos") && usuario.hobbiesSeleccionados.includes("hobbiesCocina")){
                usuario.hobbiesSeleccionados = [];
                checkBoxError.classList.add("error");
                mensajeErrorValidarHobbies.innerText = "¡La combinación de Videojuegos y Cocina no es mágica!";;
                checkBoxError.appendChild(mensajeErrorValidarHobbies);
            } else{
                checkBoxError.classList.remove("error");
                mensajeErrorValidarHobbies.remove();
            }
    }

    function validarPaisArgentina(){
        if(radio[0].checked){
            radioError.classList.add("error");
            mensajeErrorArgentina.innerText = "Lo sentimos, aún no estamos reclutando magos en Argentina, pero pronto llegaremos.";
            radioError.appendChild(mensajeErrorArgentina);
        } else {
            radioError.classList.remove("error");
            mensajeErrorArgentina.remove();
        }
    }

    function validarSeleccionPais (){

        radio.forEach(radio => {
                radio.checked ? usuario.nacionalidad = radio.id : null
        })

        if(usuario.nacionalidad == ""){
            radioError.classList.add("error");
            mensajeErrorPais.innerText = "Escoje tu pais de nacimiento para continuar.";
            radioError.appendChild(mensajeErrorPais);
        } else {
            radioError.classList.remove("error");
            mensajeErrorPais.remove();
        }
    
    }
    

    formulario.addEventListener("submit", (e) => {
        e.preventDefault()

        checkboxes.forEach(hobbie => {
            hobbie.checked ? usuario.hobbiesSeleccionados.push(hobbie.id) : null
        })

        validarHobbies();

        validarCantidadHobbies();
        
        validarSeleccionPais();

        validarPaisArgentina();

            
        
        console.log(usuario);
    })

})