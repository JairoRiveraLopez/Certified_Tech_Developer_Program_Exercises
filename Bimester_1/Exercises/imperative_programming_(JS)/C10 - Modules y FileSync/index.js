const jsonHelper = require('./JsonHelper');


let carros = jsonHelper.leer("AUTOS");

const concesionaria = {
    autos: carros,
    agregarAuto: function(marca, modelo, añoVehiculo, precio, patente) {
    let datos = {
        marca : marca,
        modelo : modelo,
        anio: añoVehiculo,
        precio: precio,
        patente: patente,
        vendido: false
    }
    this.autos.push(datos);
    jsonHelper.escribir("AUTOS", this.autos);
    return "Vehículo agregado correctamente.";
    },
    venderAuto: function (patente){
        let autoEncontrado = this.autos.find(car => car.patente === patente)
        if (autoEncontrado.vendido == true){
            return "El auto mencionado ya se encuentra vendido.";
        } else {
            autoEncontrado.vendido = true;
            jsonHelper.escribir("AUTOS", this.autos);
            return `El vehículo ${autoEncontrado.marca} ${autoEncontrado.modelo} ha sido vendido.`;
        }
        
    },
    totalDeVentas: function(){
        let ventasTotales = 0;
        this.autos.forEach(auto => {
            if(auto.vendido){
                ventasTotales += auto.precio;
            }
        });
        return ` Las ventas totales hasta ahora es de ${ventasTotales}$`; 
    },
    eliminarAuto: function(patente){
        let autoEncontrado = this.autos.find(car => car.patente === patente);
        let filtroAuto = this.autos.filter(car => car !== autoEncontrado)
        jsonHelper.escribir("AUTOS", filtroAuto);
        return "Auto eliminado satisfactoriamente";
    }
}






