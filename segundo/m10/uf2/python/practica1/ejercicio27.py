#coding: utf-8

texto = input("Introduzca un texto: ")

letras = [letters for letters in texto if not letters.isspace() ]

letras_rev = list(reversed(letras))

if(letras == letras_rev):
    print("El texto introducido es políndromo")

else:
    print("El texto introducido NO es políndromo")
