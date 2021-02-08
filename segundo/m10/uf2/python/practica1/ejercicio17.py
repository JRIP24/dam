#coding:utf-8

num_letras = int(input("Introduzca el número de palabras a guardar: "))

palabras = []
palabras2 = []

print("Lista de palabras 1:")
for i in range(num_letras):
    palabras.append(input("Introduzca una palabra: "))

print("Lista de palabras 2:")
for i in range(num_letras):
    palabras2.append(input("Introduzca una palabra: "))

for i in  palabras2:

    if i in palabras:
        palabras.remove(i)

print("Lista de palabras 1:")
print(palabras)
print("Lista de palabras 2:")
print(palabras2)