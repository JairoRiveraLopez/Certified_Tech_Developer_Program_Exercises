const fs = require('fs');

const jsonHelper = {
    leer: function (nombreArchivo) {
      return JSON.parse(
        fs.readFileSync(__dirname + "/" + nombreArchivo + ".json", "UTF-8")
      );
    },
    escribir: function (nombreArchivo, datos) {
      return fs.writeFileSync(
        __dirname + "/" + nombreArchivo + ".json",
        JSON.stringify(datos)
      );
    },
  }

module.exports = jsonHelper

