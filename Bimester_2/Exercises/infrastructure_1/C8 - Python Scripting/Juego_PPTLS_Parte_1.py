import random

puntajeUsuario=0
puntajePC=0
ganador=0

while True: 
    aleatorio = random.randrange(0, 5)
    elijePc = ""
    print("1)Piedra")
    print("2)Papel")
    print("3)Tijera")
    print("4)Lagarto")
    print("5)Spock")
    print("6)Salir del Programa")
    opcion = int(input("Que eliges: "))
    
    if opcion == 1:
        eligeUsuario = "piedra"
    elif opcion == 2:
        eligeUsuario = "papel"
    elif opcion == 3:
        eligeUsuario = "tijera"
    elif opcion == 4:
        eligeUsuario = "lagarto"
    elif opcion == 5:
        eligeUsuario = "spock"
    elif opcion == 6:
        print ("Nos vemos!")
        break
    else:
        print ("Valor Invalido")
        continue
        
    print("Tu eliges: ", eligeUsuario)   
    if aleatorio == 0:
        eligePc = "piedra"
    elif aleatorio == 1:
        eligePc = "papel"
    elif aleatorio == 2:
        eligePc = "tijera"
    elif aleatorio == 3:
        eligePc = "lagarto"
    elif aleatorio == 4:
        eligePc = "spock"
    print("PC eligio: ", eligePc)
    print("...")
    
    if eligePc == "piedra" and eligeUsuario == "papel":
        ganador = 1
        print("Ganaste, papel envuelve piedra")
    elif eligePc == "spock" and eligeUsuario == "papel":
        ganador = 1
        print("Ganaste, papel desautoriza spock")
    elif eligePc == "papel" and eligeUsuario == "tijera":
        ganador = 1
        print("Ganaste, tijera corta papel")
    elif eligePc == "lagarto" and eligeUsuario == "tijera":
        ganador = 1
        print("Ganaste, tijera decapita lagarto")
    elif eligePc == "lagarto" and eligeUsuario == "piedra":
        ganador = 1
        print("Ganaste, piedra aplasta lagarto")
    elif eligePc == "tijera" and eligeUsuario == "piedra":
        ganador = 1
        print("Ganaste, piedra aplasta tijera")
    elif eligePc == "papel" and eligeUsuario == "lagarto":
        ganador = 1
        print("Ganaste, largato devora papel")
    elif eligePc == "spock" and eligeUsuario == "lagarto":
        ganador = 1
        print("Ganaste, largato envenena spock")
    elif eligePc == "tijera" and eligeUsuario == "spock":
        ganador = 1
        print("Ganaste, spock rompe tijera")
    elif eligePc == "piedra" and eligeUsuario == "spock":
        ganador = 1
        print("Ganaste, spock vaporiza piedra")

    
    
    if eligeUsuario == "piedra" and eligePc == "papel":
        ganador = 2
        print("Perdiste, papel envuelve piedra")
    elif eligeUsuario == "spock" and eligePc == "papel":
        ganador = 2
        print("Perdiste, papel desautoriza spock")
    elif eligeUsuario == "papel" and eligePc == "tijera":
        ganador = 2
        print("Perdiste, tijera corta papel")
    elif eligeUsuario == "lagarto" and eligePc == "tijera":
        ganador = 2
        print("Perdiste, tijera decapita lagarto")
    elif eligeUsuario == "tijera" and eligePc == "piedra":
        ganador = 2
        print("Perdiste, piedra aplasta tijera")
    elif eligeUsuario == "lagarto" and eligePc == "piedra":
        ganador = 2
        print("Perdiste, piedra aplasta lagarto")
    elif eligeUsuario == "spock" and eligePc == "lagarto":
        ganador = 2
        print("Perdiste, lagarto envenena spock")
    elif eligeUsuario == "papel" and eligePc == "lagarto":
        ganador = 2
        print("Perdiste, lagarto devora papel")
    elif eligeUsuario == "tijera" and eligePc == "spock":
        ganador = 2
        print("Perdiste, spock rompe tijera")
    elif eligeUsuario == "piedra" and eligePc == "spock":
        ganador = 2
        print("Perdiste, spock vaporiza piedra") 
        
    elif eligePc == eligeUsuario:
        ganador = 0
        print("Empate")
    
    if ganador == 1 :
        puntajeUsuario += 1
    elif ganador == 2 :
        puntajePC += 1
    
        
    print("El resultado hasta ahora es: ")
    print("Usuario: ",puntajeUsuario," PC: ",puntajePC)
    
    again = input("Jugamos de nuevo? Si/No: ")
    if 'si' in again:
        continue
    elif 'no' in again:
        print("Nos vemos!")
        break
    else:
        print("Valor Invalido")