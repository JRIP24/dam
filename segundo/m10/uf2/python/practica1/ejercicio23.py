#coding:utf-8

n1 = int(input("Introduzca un número: "))
n2 = int(input("Introduzca otro número: "))

if(n1 < n2):
    for i in range(n1, n2):
        if(i%2 == 0):
            print(i)