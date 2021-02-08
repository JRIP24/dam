#coding:utf-8

print("**************************")
print("*                        *")
print("*  Pies y pulgadas a cm:  *")
print("*                        *")
print("**************************")

pies = int(input("Pies: "))
pulgadas = int(input("Pulgadas: "))

pulgadas = pulgadas + (pies * 12)

resultado = pulgadas * 2.54

print("Equivalente en cm:", resultado)