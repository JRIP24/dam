#coding:utf-8

palabra = input("Introduzca una palabra: ")

if (palabra.isalpha()):

    '''letras = [letters for letters in palabra]
    print(letras)'''

else:
    print("Error: se han encontrado números u otros carácteres en la palabra, se tiene que introducir solo letras")