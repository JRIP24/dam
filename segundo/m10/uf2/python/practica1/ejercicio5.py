#coding:utf-8

vocales = ["a", "e", "i", "o", "u"]

num_el = int(input("Qué número de elemento quiere modificar(0-4)?: "))

if((num_el >= 0) and (num_el <= len(vocales) - 1)):
    
    valor = input("Nuevo valor del elemento: " )

    vocales[num_el] = valor
    print(vocales)

    vocal = input("Introduzca la vocal a modificar: ")
    
    if(vocal in vocales):
        indice = vocales.index(vocal)
        new_valor = input("Nuevo valor del elemento: ")
        vocales[indice] = new_valor
        print(vocales)


    else:
        print('No se ha encontrado"', vocal, '" en la lista')
    
    

    

else:
    print("Error: el número introducido está fuera del rango del array")