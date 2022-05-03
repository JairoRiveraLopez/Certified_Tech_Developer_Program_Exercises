window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
   
    const inputEmail = document.querySelector('#inputEmail');
    const inputPasswd = document.querySelector('#inputPassword');
    const form = document.querySelector('form');

    const urlBase = 'https://ctd-fe2-todo.herokuapp.com/v1';


    
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {
       
        event.preventDefault();

        const usuario = {
            email: inputEmail.value,
            password: inputPasswd.value
        };
    

        const config = {
            method: 'POST',
            body: JSON.stringify(usuario),
            headers: {
                'Content-Type': 'application/json'
            }
        } 
        
        realizarLogin(config);
        
        form.reset();
    });


    /* -------------------------------------------------------------------------- */
    /*                     FUNCIÓN 2: Realizar el login [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarLogin(settings) {
    
        // creamos la consulta a la API
        fetch(`${urlBase}/users/login`, settings)
            .then(respuesta => {
                if (respuesta.ok != true) {
                    alert("Alguno de los datos es incorrecto.")
                } 
                return respuesta.json();
                })
            .then(data => {
                
                if(data.jwt){
                    
                    localStorage.setItem('jwt', JSON.stringify(data.jwt));
                    
                    
                    location.replace('./mis-tareas.html');
                }
            }).catch( error => {
                console.log(error);
                
            })



        
    };


});