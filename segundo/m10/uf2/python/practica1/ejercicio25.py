#coding:utf-8

num = int(input("Introduzca un número: "))
n = int(input("Cantidad de múltiplos a mostrar: "))
multiplos = [i for i in range(0, n * num) if (i%num == 0)]
print(multiplos)