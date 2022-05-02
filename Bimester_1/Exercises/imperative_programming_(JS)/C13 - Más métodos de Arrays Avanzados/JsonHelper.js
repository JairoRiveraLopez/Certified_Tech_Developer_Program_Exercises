const fs = require('fs');

const JsonHelper = {
leerJson: function (nombreArchivo){
return JSON.parse(fs.readFileSync(__dirname + "/" + nombreArchivo + ".json", 'utf-8'))
},
escribirJson: function (nombreArchivo, datos){
    let cambiarAJSON = JSON.stringify(datos);
    return fs.writeFileSync(__dirname + "/" + nombreArchivo + ".json", 'utf-8');
}
}

module.exports = JsonHelper