window.addEventListener('load', function () {
 
const valor = document.querySelector("#valor")

let n = 0

let intervalo;

window.addEventListener("keypress", (event) => {
    if(event.key == "Enter") {
        intervalo = setInterval(() => {
            valor.innerText = n++
        }, 1000)
    }
})

document.addEventListener("keydown", function checkKey(evento){
    document.onkeydown = checkKey;
    evento = evento || window.event;
    if (evento.keyCode == '40') {
        clearInterval(intervalo);
        valor.innerText = n = 0;
    }
})


    document.addEventListener("keyup", (event) => {
        if(event.code === "Space") {
        clearInterval(intervalo);
        }
    })

    document.addEventListener("keydown", function checkKey(evento){
        document.onkeydown = checkKey;
        if (evento.keyCode == '39') {
        clearInterval(intervalo);
        
        intervalo = setInterval(() => {
            valor.innerText = n++
        }, 500)
    }
    })
})
