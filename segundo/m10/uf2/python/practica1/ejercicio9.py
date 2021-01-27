#coding:utf-8

print("Divisor de números")
num1 = int(input("Escriba el primer número: "))
num2 = int(input("Escriba el segundo número: "))

if(num2 != 0):

    print("Resultado:", num1 / num2)
    if (num1%num2 == 0):
        print("La división es exacta")
    else:
        print("La división no es exacta")

else:
    print("No se puede dividir por", num2)