let opcionUsuario = prompt("Escoge una opción: tijera(1), papel(2), piedra (3)")

let opcionMaquina = Math.floor(Math.random()*3+1)

let comparacion = opcionMaquina < opcionUsuario

switch (true) {
    case (opcionMaquina == opcionUsuario):
        alert("Es un empate, la máquina seleccionó " + opcionMaquina);
        break;

    case (opcionMaquina == 3 && opcionUsuario == 1):
        alert("La máquina escogió piedra, tu perdiste");
        break;

    case (opcionUsuario == 3 && opcionMaquina== 1):
        alert("La máquina escogió tijeras, tu ganaste");
        break;

    case (comparacion):
        alert("El ganador es la máquina, la máquina seleccionó " + opcionMaquina);

    default:
        alert("ganaste, la máquina seleccionó " + opcionMaquina);
        break
        }