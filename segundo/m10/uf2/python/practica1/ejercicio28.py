#coding: utf-8

letras = ["T", "R", "W", "A", "G", "M", "I", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"]

dni = input("Introduzca su DNI: ")
num = int(dni[0:-1])

if (dni[-1].upper() == letras[num%23]):
    print("El DNI introducido es correcto")
else:
    print("El DNI introducido es incorrecto")
