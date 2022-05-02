const nombreUsuario = document.querySelector("#nombre")
const correo = document.querySelector("#email")
const contrasenia = document.querySelector("#pass")
const checkbox = document.querySelector("input[type=checkbox]")
const formulary = document.querySelector("form")
const passError = document.querySelector("#notPass")
const privacyError = document.querySelector("#notPass")
const notName = document.querySelector("#notName")

let user = {
    fullName: "",
    email: "",
    password: "",
    privacyAccepted: false,
}

let p = document.createElement("p")

function nameCondition(name) {
    let n = name.trim()
    if(n.length <= 25) {
        user.fullName = n
    }
    else {
        nombreUsuario.classList.toggle("error")
        alert("Name can't be longer than 25 characters")
        }
}

function emailCondition() {
    if(correo.value.includes("@")) {
        user.email = correo.value;
    }
    else {
        correo.classList.add("error")
        }
}


contrasenia.addEventListener("change", () => {
    let strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,20})");

    if (strongRegex.test(contrasenia.value)) {
        user.password = contrasenia.value
    }
    else {
        contrasenia.classList.add("error")  
        passError.appendChild(p)
        p.innerText = "Invalid password. It must have numbers, lower and upper case letters. Amount of characters between 8-20."
    }
    
})

nombreUsuario.addEventListener("blur", () => {
    nameCondition(nombreUsuario.value)
})

formulary.addEventListener("submit", (e) => {
    e.preventDefault();
    nameCondition(nombreUsuario.value);
    emailCondition();
    
    checkbox.checked ? user.privacyAccepted = true : alert("To continue you must accept Terms and Privacy Policy")
    

    console.log(user);
})
