#coding:utf-8

print("**************************")
print("*                        *")
print("*  Calcular el área de:  *")
print("*                        *")
print("*   1) Círculo           *")
print("*   2) Triángulo         *")
print("*                        *")
print("**************************")

opcion = int(input("Introduca 1 o 2: "))

if(opcion == 1):
    
    PI = 3.14
    radio = int(input("Introduzca el radio del círculo: "))
    resultado = PI * (radio ** 2)
    print("El área del círculo es:",resultado)

elif(opcion == 2):

    base = int(input("Introduzca la base del triángulo: "))
    altura = int(input("Introduzca la altura del triángulo: "))

    resultado = (base * altura) / 2
    print("El área del triángulo es:",resultado)

else:
    print("Error: el no se acepta el valor introducido")