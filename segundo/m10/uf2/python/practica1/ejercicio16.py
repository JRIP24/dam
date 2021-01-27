#coding:utf-8

num_letras = int(input("Introduzca el número de palabras a guardar: "))

if (num_letras > 0):

    palabras = []

    for i in range(num_letras):

        palabras.append(input("Introduzca una palabra: "))

    print(palabras)

else:
    print("Se ha introducido 0, no se recogerán palabras")