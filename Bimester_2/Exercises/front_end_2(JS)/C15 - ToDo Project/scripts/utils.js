function validacionTarea(tarea) {
    let respuesta = false;

    if(tarea !== "" && tarea.length > 2){
        respuesta = true;
    }
    
    return respuesta;
}
