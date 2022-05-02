const JSonHelper = require('./JsonHelper')

                                            /* Punto 1*/

let profesionales = JSonHelper.leerJson('profesionales')

const appProfesionales = {

    datos: profesionales,

    filtroporNombreEspecialidad : function(){
        this.datos.forEach(profesional =>
            console.table(profesional.nombre + " - " + profesional.especialidad));
},

    honorarioConsulta : function(){
        this.datos.forEach(valor =>
            console.table(valor.honorarioConsulta * 1.05)
            )
    },

    desabilitado : function(){
        return this.datos.filter(profesional => profesional.estaHabilitado == false)
    },

    profesionalesHabilitados : function(){
        return this.datos.filter(profesional => profesional.estaHabilitado == true)
    },

    filtroArquitectos : function(){
        return this.datos.filter(profesional => profesional.especialidad == 'Arquitecto')
    },

    habilitar : function(){
        let inhabilitado = this.desabilitado()
        return inhabilitado.forEach(profesional => profesional.estaHabilitado = true)
    },

    cantidadTotalConsultas : function(){
        return this.datos.reduce((acum, profesional) =>
        acum += profesional.cantidadConsultas , 0)
        },

    arrayRecaudacion : function(){
        return this.datos.map( profesional => {
            return {
                nombre: profesional.nombre,
                especialidad: profesional.especialidad,
                recaudacion: profesional.honorarioConsulta * profesional.cantidadConsultas + "$",
            }
        })    
},

}
// console.table(appProfesionales.filtroporNombreEspecialidad())


                                            /* Punto 2*/

// console.table(appProfesionales.honorarioConsulta())  

                                            /* Punto 3*/

// console.table(appProfesionales.desabilitado())

                                            /* Punto 4*/

// console.table(appProfesionales.profesionalesHabilitados())

                                            /* Punto 5*/

// console.table(appProfesionales.filtroArquitectos())

                                            /* Punto 6*/
// appProfesionales.habilitar()
// console.table(appProfesionales.datos)

                                            /* Punto 7*/
// console.log(appProfesionales.cantidadTotalConsultas())

                                            /* Punto 8*/
console.table(appProfesionales.arrayRecaudacion())                                
