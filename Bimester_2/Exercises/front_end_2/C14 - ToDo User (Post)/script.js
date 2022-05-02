let url = "https://ctd-todo-api.herokuapp.com/v1/users"

let data = {
    "firstName": "Jairo",
    "lastName": "Rivera",
    "email": "jairorive0214@hotmail.com",
    "password": "plookiiju??"
}

let configuration = {
    method : "POST",
    body : JSON.stringify(data),
    headers : {
        "content-type" : "application/json"
    }
}

fetch(url, configuration)
    .then((response) => response.json())
    .then((json) => {
      // Aqui obtenemos la respuesta de la API.
    console.log("Usuario:", json);
    })

// jwt: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6I…jEyfQ.6FPb38ZAVfwF5liuMTRPi127bP06fW0VlJ8JpEpUM_s'