// Te proveemos la siguiente plantilla que tiene dos partes:
// - Desarrollo de las consignas, donde escribirás el código que responda a los enunciados
// - Ejecución de las consignas, donde ejecutarás los métodos correspondientes mostrando por consola sus resultados
const nombre = "Jairo Rivera López";
/*******************************/
/* Desarrollo de las consignas */
/*******************************/

const jsonHelper = require('./jsonHelper');

let info = jsonHelper.leerJson('./recetas')
// A
const restaurante = {
// B
    recetas : info,
// C
buscarPorNombre  : function(nombre) {
    return this.recetas.find(receta => receta.nombre == nombre)
},
// D
filtrarPorTiempo  : function(tiempo) {
    return this.recetas.filter(receta => receta.tiempo < tiempo)
},
// E
ordenarPorDificultad : function(arrayRecetas = this.recetas){
    return arrayRecetas.sort((a,b) => a.dificultad-b.dificultad)
  },
// F
duracionPromedio: function () {
    let sumatoria = this.recetas.reduce(
      (acum, dur) => acum += dur.tiempo,
      0
    );
    return `La duración promedio de todas las recetas es de ${(
      sumatoria / this.recetas.length
    ).toFixed(2)} minutos.`;
  },
// G
IncrementarPrecio  : function(nombre, incremento) {
    let busqueda = this.buscarPorNombre(nombre);
    if (busqueda) {
        busqueda.precio += incremento;
        jsonHelper.escribirJson('./recetas', this.recetas);
    return busqueda;
    }
},
}

/******************************/
/* Ejecución de las consignas */
/******************************/

console.table([{ alumno: nombre }]); // NO MODIFICAR NADA DE ESTA LINEA

console.log("---------- ↧ .C. Buscar ↧ ----------");
// Ejecución aquí:
console.log(restaurante.buscarPorNombre('Fajitas veganas'));
console.log("---------- ↥ ---------- ↥ ----------");

console.log("---------- ↧ .D. Filtrar ↧ ----------");
// Ejecución aquí:
console.log(restaurante.filtrarPorTiempo(45));
console.log("---------- ↥ ------------- ↥ ----------");

console.log("---------- ↧ .E. Ordenar ↧ ----------");
// Ejecución aquí:
console.log(restaurante.ordenarPorDificultad());
console.log("---------- ↥ ------------- ↥ ----------");

console.log("---------- ↧ .F. Total ↧ ----------");
// Ejecución aquí:
console.log(restaurante.duracionPromedio());
console.log("---------- ↥ ----------- ↥ ----------");

console.log("---------- ↧ .G. Modificar ↧ ----------");
// Ejecución aquí:
console.log(restaurante.IncrementarPrecio('Fajitas veganas', 17));
console.log("---------- ↥ --------- ↥ ----------");

