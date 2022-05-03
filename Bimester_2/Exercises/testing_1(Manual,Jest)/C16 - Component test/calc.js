function suma(a,b){
    if (typeof (a) != "number" || typeof (b) != "number"){
    return 0;
} else{
    return a+b;
}
}

function resta(a,b){
    if (typeof (a) != "number" || typeof (b) != "number"){
        return 0;
    } else{
        return a-b;
    }
}

function multiplicacion(a,b){
    if (typeof (a) != "number" || typeof (b) != "number"){
        return 0;
    } else{
        return a*b;
    }
}

function division(a,b){
    
    if (typeof (a) != "number" || typeof (b) != "number") {
        return 0;
    } else if (b === 0){
        return "Sos pendej@ que no se puede dividir por 0."
    }
    else{
        return a/b;
    }
}

module.exports = {suma, resta, multiplicacion, division};
