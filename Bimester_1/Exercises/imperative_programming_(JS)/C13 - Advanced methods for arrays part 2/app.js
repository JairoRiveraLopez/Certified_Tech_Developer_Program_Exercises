const JSonHelper = require('./JsonHelper')



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
    primerosCincoProfesionales : function (){

        let datosOrdenados = this.datos.sort((a, b) => a.identificador - b.identificador);
        let primerosCincos = datosOrdenados.slice(0, 5);
        return primerosCincos;
    },
    
    appProfesionales : function (identificador){

        const nuevoProfesional = {
            identificador: 250,
            estaHabilitado: true,
            honorarioConsulta: 8000,
            edad: 52,
            nombre: 'Linus Torvalds',
            especialidad: 'Junior Developer',
            cantidadConsultas: 48,
            puntuacion: 50
            }
        let indexProfesional = this.datos.findIndex(id => id.identificador === identificador)
        return this.datos.splice(indexProfesional, 1, nuevoProfesional)
    },

    ordenarPorHonorarioConsulta : function(){
        return datosOrdenados = this.datos.sort((a, b) => a.honorarioConsulta - b.honorarioConsulta);
    },

    buscarProfesional : function(identificador){
    return this.datos.find(id => id.identificador === identificador)
    }

}

console.table(appProfesionales.buscarProfesional(1));

