#conding:utf-8

num = int(input("Introduzca un número para calcular su factorial: "))

if(num > 0):

    resultado = 0
    salir = False
    contador = 0
    val_initicial_num = num

    while (not salir):
        
        if(contador >= 1 ):
            resultado = resultado * (num -1)
        else:
            resultado = num * (num - 1)

        contador = contador + 1
        
        num = num -1

        if(num <= 1):
            salir = True

    print(resultado)

else:
    print("Error: se ha introducido 0")
