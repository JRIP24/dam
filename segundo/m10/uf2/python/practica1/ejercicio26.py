#coding:utf-8

palabra = input("Introduzca una palabra: ")

if (palabra.isalpha()):

    alfabetica = True
    salir = False
    letras = [letters for letters in palabra]
    contador = 1


    while not salir:

        if (letras[contador] < letras[contador - 1]):

            alfabetica = False


        contador += 1

        #Condición de salida
        if(contador >= len(letras) or not alfabetica):
            salir = True

    if(alfabetica):
        print("La palabra introducida es alfabética")
    else:
        print("La palabra introducida NO es alfabética")

else:
    print("Error: se han encontrado números u otros carácteres en la palabra, se tiene que introducir solo letras")