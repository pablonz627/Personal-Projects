#PROYECTO INTEGRADOR
#PABLO NAVARRO ZEPEDA A01284116
#JESUS ANTONIO GUEVARA DIAZ A00830031
#LUIS ALEJANDRO MONROY ANGELES A00828669

import random
import sys

def main():
    print("        Juego Ahorcado")
    print("Menu de opciones")
    print("1. Jugar contra la Computadora")
    print("2. Jugar 1v1 (2 jugadores)")
    print("3. Salir")
    print("")
    
    while True:
        opcion = int(input("Escoge la opcion deseada: "))
        if opcion != 1 and opcion != 2 and opcion != 3:
            continue
        else:
            break

    if opcion == 1:
        
        opcion1()

    elif opcion == 2:
        
        opcion2() 
    
    elif opcion ==3:
        print("===================================================================================================")
        print("")
        print("¡Gracias por jugar, hasta luego!")
        print("")
        print("===================================================================================================")
        sys.exit()






def opcion1 ():
    opciones = ["gato","barco","oceano","tierra","planeta","cama","helicoptero","refrigerador","papalote","computadora"]
    pista = [ ["pelo","animal","cola","mascota"],
              ["transporte","nave","acuatico","mar"],
               ["azul","extenso","agua","vida"],
              ["vida","hogar","naturaleza","planeta"],
               ["grande","vida","astronomico","masivo"],
              ["comodidad","descanso","mueble","habitacion"],
               ["transporte","vehiculo","veloz","aereo"],
              ["temperatura","electrodomestico","comida","refrigeracion"],
                ["juguete","mexicano","volar","cometa"],
              ["tecnologia","indispensable","herramienta","trabajo"]]
               
    palabra = random.choice(opciones)  #Asigna una a la variable  palabra una de las opciones de palabras
    indice_palabra = opciones.index(palabra)  #Obtiene el indice de la palabra
    palabra_tapada = [] #Crea un arreglo donde estara la palabra tapada
    separador = ""
    pista_conteo = 3
    intentos = 5
    
    print("===================================================================================================")
    print("¡BIENVENIDO A AHORCADO CONTRA LA COMPUTADORA!")
    print("")
    print("Instrucciones: El sistema escogera una palabra random y te dara una pista inicial.")
    print("Tu trabajo es ir adivinando las letras que componen la palabra hasta adivinar la palabra completa.")
    print("Si te equivocas en la letra mas de "+ str(intentos)+" veces, perderas el juego.")

    for i in range (len(palabra)): #Crea un array tapado con el numero de letras e la palabra
        palabra_tapada.append("_") 
    
    while True:
        print("")
        ahorcado(intentos)
        print("")
        for i in range (len(palabra)):
            print(palabra_tapada[i],end =" ")   #Imprime el arreglo tapado
        print("")
        print("")
        print("Tu palabra tiene: "+str(len(palabra))+ " letras") #Muestra el numero de letras que tiene la palabra
        print("Tu pista inicial es: "+ pista[indice_palabra][0])
        print("")
    
        print("Puedes escribir: ")
        print("- Una letra que crees que este en la palabra")
        print("- La palabra 'pista' si necesitas una pista (solo 3 disponibles)")
        print("- La palabra completa si crees que ya la conoces")
        
        if separador.join(palabra_tapada) == palabra:
            print("===================================================================================================")
            print("")
            print("Felicidades encontraste la palabra. !GANASTEEE!")
            print("")
            print("===================================================================================================")
            main()
    
        guess = input("Respuesta: ")  #Captura la respuesta del usuario
        guess = guess.lower()
        
        if guess == palabra: #Si la respuesta es igual a la palabra gana y acaba el juego
            print("===================================================================================================")
            print("")
            print("Felicidades encontraste la palabra. !GANASTE!")
            print("")
            print("===================================================================================================")
            main()
        
        
        elif guess in palabra: # Si la respuesta esta en la palabra (osea una letra ) 
            for i in range(len(palabra)): # Destapa la letra en el arreglo tapado
                if palabra[i] == guess:
                    indice_string = palabra.index(guess)
                    palabra_tapada[i] = palabra[i]
                    
            print("===================================================================================================")
            print("¡CORRECTO!")
            print("¡La letra que escribiste SI esta en la palabra, sigue asi!")
            continue #Vuelve a empezar el While
        
        elif guess == "pista" and pista_conteo == 0:
            print("===================================================================================================")
            print("¡NO HAY PISTAS RESTANTES!")
            print("Llegaste al limite de pistas. ¡Tendras que hacerlo por tu cuenta!")
            continue
        
        elif guess == "pista" :
            print("===================================================================================================")
            print("¡PISTA!")
            print("Tu pista es: "+pista[indice_palabra][pista_conteo])
            pista_conteo = pista_conteo - 1
            print("Te quedan "+str(pista_conteo)+" pistas restantes")
            continue
        
                
        elif guess not in palabra: #Si la respuesta (osea una letra) no esta en la palabra
            print("===================================================================================================")
            print("¡INCORRECTO!")
            print("¡La letra que escribiste NO esta en la palabra!")
            if intentos == 0: #Si no le quedan intentos incorrectos
                print("Llegaste al limite de intentos incorrectos. ¡PERDISTE!")
                print("")
                print( "X======X")
                print( "|      |")
                print( "|      O")
                print( "|     /|\ ")
                print( "|     / \ ")
                print( "|        ")
                print("===========")
                print("")
                print("Tu palabra era: "+palabra)
                print("")
                print("===================================================================================================")
                main()
            
            print("INTENTOS INCORRECTOS RESTANTES: "+str(intentos-1)) #Si si quedan intentos incorrectos
            intentos = intentos -1 #Se quita un intento
            continue #Vuelve a empezar el While





def opcion2():
    palabra_tapada = [] #Crea un arreglo donde estara la palabra tapada
    separador = ""
    pista_conteo = 3
    intentos = 5
    
    print("===================================================================================================")
    print("¡BIENVENIDO A AHORCADO 1 VS 1!")
    print("")
    print("Instrucciones: Los dos jugadores se deben nombrar como Jugador 1 y Jugador 2.")
    print("El Jugador 1 debera escoger una palabra y 4 pistas")
    print("EL trabajo del Jugador 2 es ir adivinando las letras que componen la palabra hasta adivinar la palabra completa.")
    print("Si el Jugador 2 se equivoca  en la letra mas de "+ str(intentos)+" veces, perdera el juego y gana el Jugador 1.")
    print("Si el Jugador 2 adivina la palabra completa ganara el juego y perdera el Jugador 1.")
    print("")
    print("Jugador 1 porfavor escribe la palabra y la pistas. Asegurate que el Jugador 2 no este viendo")
    print("")
    palabra = input("Palabra por adivinar: ")
    pista = [0]* 4
    
    for i in range(len(pista)):
        pista[i] = input("Pista "+str(i+1)+": ")
    
    print("")
    print("")
    print("")
    print("=========================================================================================================")
    
    print("¡JUGADOR 2 NO VEAS MAS ARRIBA DE ESTA LINEA!")
    
    print("¡JUGADOR 2 PUEDE EMPEZAR A ADIVINAR!")
    
    for i in range (len(palabra)): #Crea un array tapado con el numero de letras e la palabra
        palabra_tapada.append("_") 
    
    while True:
        print("")
        ahorcado(intentos)
        print("")
        for i in range (len(palabra)):
            print(palabra_tapada[i],end =" ")   #Imprime el arreglo tapado
        print("")
        print("")
        print("Tu palabra tiene: "+str(len(palabra))+ " letras") #Muestra el numero de letras que tiene la palabra
        print("Tu pista inicial es: "+ pista[0])
        print("")
    
        print("Puedes escribir: ")
        print("- Una letra que crees que este en la palabra")
        print("- La palabra 'pista' si necesitas una pista (solo 3 disponibles)")
        print("- La palabra completa si crees que ya la conoces")
        
        if separador.join(palabra_tapada) == palabra:
            print("===================================================================================================")
            print("")
            print("Felicidades encontraste la palabra Jugador 2. !GANASTEEE!")
            print("")
            print("===================================================================================================")
            main()
    
        guess = input("Respuesta: ")  #Captura la respuesta del usuario
        guess = guess.lower()
        
        if guess == palabra: #Si la respuesta es igual a la palabra gana y acaba el juego
            print("===================================================================================================")
            print("")
            print("Felicidades encontraste la palabra, Jugador 2. !GANASTE!")
            print("")
            print("===================================================================================================")
            main()
        
        
        elif guess in palabra: # Si la respuesta esta en la palabra (osea una letra ) 
            for i in range(len(palabra)): # Destapa la letra en el arreglo tapado
                if palabra[i] == guess:
                    indice_string = palabra.index(guess)
                    palabra_tapada[i] = palabra[i]
                    
            print("===================================================================================================")
            print("¡CORRECTO!")
            print("¡La letra que escribiste SI esta en la palabra, sigue asi!")
            continue #Vuelve a empezar el While
        
        elif guess == "pista" and pista_conteo == 0:
            print("===================================================================================================")
            print("¡NO HAY PISTAS RESTANTES!")
            print("Llegaste al limite de pistas. ¡Tendras que hacerlo por tu cuenta!")
            continue
        
        elif guess == "pista" :
            print("===================================================================================================")
            print("¡PISTA!")
            print("Tu pista es: "+pista[pista_conteo])
            pista_conteo = pista_conteo - 1
            print("Te quedan "+str(pista_conteo)+" pistas restantes")
            continue
        
                
        elif guess not in palabra: #Si la respuesta (osea una letra) no esta en la palabra
            print("===================================================================================================")
            print("¡INCORRECTO!")
            print("¡La letra que escribiste NO esta en la palabra!")
            if intentos == 0: #Si no le quedan intentos incorrectos
                print("Llegaste al limite de intentos incorrectos. ¡GANA EL JUGADOR 1!")
                print("")
                print( "X======X")
                print( "|      |")
                print( "|      O")
                print( "|     /|\ ")
                print( "|     / \ ")
                print( "|        ")
                print("===========")
                print("")
                print("Tu palabra era: "+palabra)
                print("")
                print("===================================================================================================")
                main()
            
            print("INTENTOS INCORRECTOS RESTANTES: "+str(intentos-1)) #Si si quedan intentos incorrectos
            intentos = intentos -1 #Se quita un intento
            continue #Vuelve a empezar el While
               
            
    
    
def ahorcado(intentos):
    if intentos == 0:
        print( "X======X")
        print( "|      |")
        print( "|      O")
        print( "|     /|\ ")
        print( "|     /  ")
        print( "|        ")
        print("===========")
    elif intentos == 1:
        print( "X======X")
        print( "|      |")
        print( "|      O")
        print( "|     /|\ ")
        print( "|         ")
        print( "|        ")
        print("===========")
    elif intentos == 2:
        print( "X======X")
        print( "|      |")
        print( "|      O")
        print( "|     /| ")
        print( "|         ")
        print( "|        ")
        print("===========")
    elif intentos == 3:
        print( "X======X")
        print( "|      |")
        print( "|      O")
        print( "|      | ")
        print( "|         ")
        print( "|        ")
        print("===========")
    elif intentos == 4:
        print( "X======X")
        print( "|      |")
        print( "|      O")
        print( "|       ")
        print( "|         ")
        print( "|        ")
        print("===========")
    elif intentos == 5:
        print( "X======X")
        print( "|      |")
        print( "|       ")
        print( "|       ")
        print( "|         ")
        print( "|        ")
        print("===========")
        

main()

    
    
    
    


    