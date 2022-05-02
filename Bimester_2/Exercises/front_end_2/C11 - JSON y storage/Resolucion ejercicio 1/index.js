    const listaComentarios = document.querySelector('.comentarios');
    const inputComentario = document.querySelector('#comentario');
    const form = document.querySelector('form');
    const borrarComentarios = document.querySelector("#borrarHistorial");

    let historialComentarios = obtenerComentariosAlmacenados();

    function guardarComentario(comentario) {
        
        historialComentarios.push(comentario);
        
        localStorage.setItem('comentariosAlmacenados', JSON.stringify(historialComentarios));
    }

    function obtenerComentariosAlmacenados() {
        let comentarioAlmacenado = JSON.parse(localStorage.getItem('comentariosAlmacenados'));

        comentarioAlmacenado.forEach( c => {
            listaComentarios.innerHTML += `<li>${c}</li>`
        })

        return comentarioAlmacenado;
    }

    borrarComentarios.addEventListener("click", ()=> {
        localStorage.clear();
        listaComentarios.remove("li")
        historialComentarios = [];
        
    })

    form.addEventListener('submit', function(event){
        event.preventDefault();

        guardarComentario(inputComentario.value);
        
        location.reload();

        form.reset();
    });
