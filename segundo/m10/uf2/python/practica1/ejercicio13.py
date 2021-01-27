#coding:utf-8

num1 = int(input("Escriba un número: "))
num2 = int(input("Escriba otro número: "))

if (num2 > num1):

    suma = 0
    for i in range(num1, num2):
        suma = suma + i

    print("La suma de los números de", num1, "hasta", num2 , "es:",suma)

else:
    print("Error: los números introducidos son iguales, o el segundo es menor que el primero")